/*
 * Copyright (c) 2013, Kyle Mulleady
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the organization nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY KYLE MULLEADY ''AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL KYLE MULLEADY BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package ics311km;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class SkipListDynamicSet implements DynamicSet, Const {

    private Node head;
    private int size;
    private int numLevels;
    
    // Creates an instance of ADT DynamicSet and initializes it to the empty set.   
    public SkipListDynamicSet() {
        this.head = new QuadNode(MIN_VALUE);
        this.head.setRight(new QuadNode(MAX_VALUE));
        this.size = 0;
        this.numLevels = 1;
    }

    // Returns the number of elements currently in the set.
    public int size() {
        return this.size;
    }

    // Inserts element e in the set under key k.
    public void insert(KeyType k, Object e) {
        // Start at top left, work our way right and down.
        Node currentNode = this.head;
        int currentLevel = this.numLevels;
        // If we insert a tower of nodes, we need to keep track of who the left and right at each level will be.
        Map<Integer, List<Node>> rows = new HashMap<Integer, List<Node>>();
        while (true) {
            // If the currentNode's right node is less than k, move right.
            if (currentNode.getRight().getKey().compareTo(k) < 0 
                && !currentNode.getRight().getKey().getValue().equals(MAX_VALUE)) {
                currentNode = currentNode.getRight();
            }
            // If the currentNode's right node is >= k, move down.
            else {
                // If we're not at the bottom level, move down.
                if (currentLevel > 1) {
                    // Store the left and right nodes of the current level in case we make a tower.
                    List<Node> nodes = new ArrayList<Node>(2);
                    nodes.add(LEFT, currentNode);
                    nodes.add(RIGHT, currentNode.getRight());
                    rows.put(currentLevel, nodes);
                    currentNode = currentNode.getBelow();
                    currentLevel--;
                }
                // If we can't move down any further, we've found our insert point.
                else {
                    // When the first element is inserted, we need to add a new level.
                    if (this.numLevels == 1) {
                        addLevel();
                        // Store the nodes of the new level in case we make a tower.
                        rows.put(currentLevel+1, getTopNodes());
                    }
                    // Create new node and set appropriate left and right pointers.
                    Node n = new QuadNode(k);
                    n.setLeft(currentNode);
                    n.setRight(currentNode.getRight());
                    currentNode.getRight().setLeft(n);
                    currentNode.setRight(n);
                    currentNode = n;
                    // Flip coin to see if we're creating a tower.
                    while (Math.random() <= 0.5) {
                        // Move up one level.
                        currentLevel++;
                        // If we're at the top level, add a new one.
                        if (currentLevel == this.numLevels) {
                            addLevel();
                            // Store the nodes of the new level in case we continue the tower.
                            rows.put(currentLevel+1, getTopNodes());
                        }
                        // Create a tower by setting appropriate above and below pointers.
                        n = new QuadNode(k);
                        currentNode.setAbove(n);
                        n.setBelow(currentNode);
                        // Also set appropriate left and right pointers.
                        n.setLeft(rows.get(currentLevel).get(LEFT));
                        n.setRight(rows.get(currentLevel).get(RIGHT));
                        rows.get(currentLevel).get(LEFT).setRight(n);
                        rows.get(currentLevel).get(RIGHT).setLeft(n);
                        currentNode = n;
                    }
                    this.size++;
                    return;
                }
            }
        }
    }
                                        
    // Given a key k, removes elements indexed by k from the set.
    public void delete(KeyType k) {
        // Run nodeSearch() to find the node with k.
        Node n = nodeSearch(k);
        if (n.getKey().compareTo(k) == 0) {
            // Found the node with k. Move to the top of its tower.
            while (n.getAbove() != null) {
                n = n.getAbove();
            }
            // Delete the node out of the current level and move down.
            while (n != null) {
                n.getLeft().setRight(n.getRight());
                n.getRight().setLeft(n.getLeft());
                n.setLeft(null);
                n.setRight(null);
                // Delete above and below pointers if applicable.
                if (n.getAbove() != null) {
                    n.getAbove().setBelow(null);
                    n.setAbove(null);
                }
                n = n.getBelow();
                // Remove a level if necessary. This checks to see if the 2nd highest level is empty.
                if (this.head.getBelow().getRight().getKey().getValue().equals(MAX_VALUE)) {
                    this.head.getRight().setBelow(null);
                    this.head.getRight().setLeft(null);
                    this.head.setRight(null);
                    this.head = this.head.getBelow();
                    this.head.getAbove().setBelow(null);
                    this.head.setAbove(null);
                    this.head.getRight().setAbove(null);
                    this.numLevels--;
                }
            }
            this.size--;
        }
    }
                                                   
    // Finds an Object with key k and returns a pointer to it,
    // or null if not found. 
    public Object search(KeyType k) {
        Node n = nodeSearch(k);
        if (n.getKey().compareTo(k) != 0)
            return null;
        return n.getKey();
    }

    // Returns either the node with k or the max node less than k.
    private Node nodeSearch(KeyType k) {
        Node currentNode = this.head;
        int currentLevel = this.numLevels;
        // Loop until we find the node we're looking for or the max node less than k.
        while (true) {
            if (currentNode.getKey().compareTo(k) == 0) {
                return currentNode;
            }
            // If the currentNode's right node is less than k, move right.
            else if (currentNode.getRight().getKey().compareTo(k) < 0 
                && !currentNode.getRight().getKey().getValue().equals(MAX_VALUE)) {
                currentNode = currentNode.getRight();
            }
            // If the currentNode's right node is >= k, try and move down one level.
            else {
                // If we're not at the bottom level, move down and keep searching.
                if (currentLevel > 1) {
                    currentNode = currentNode.getBelow();
                    currentLevel--;
                }
                // If we're at the bottom level, stop.
                else {
                    // Check if the right node's key is k.
                    if (currentNode.getRight().getKey().compareTo(k) == 0)
                        return currentNode.getRight();
                    // Otherwise, return the max node less than k.
                    else
                        return currentNode;
                }
            }
        }
    }
                                                                   
    // The following operations apply when there is a total ordering on KeyType   
                                                                         
    // Finds an Object that has the smallest key, and returns a pointer to it,
    // or null if the set is empty. 
    public Object minimum() {
        Node n = nodeMinimum();
        if (n == null)
            return null;
        return n.getKey();
    }

    // Returns the min node or null if empty set.
    private Node nodeMinimum() {
        if (this.size == 0)
            return null;
        Node currentNode = this.head;
        // Start at the head, go straight down to the bottom level.
        while (currentNode.getBelow() != null) 
            currentNode = currentNode.getBelow();
        // Return the sentinel's right node's key.
        return currentNode.getRight();
    }
                                                                                         
    // Finds an Object that has the largest key, and returns a pointer to it,
    // or null if the set is empty.
    public Object maximum() {
        Node n = nodeMaximum();
        if (n == null)
            return null;
        return n.getKey();
    }

    // Returns the max node or null if empty set.
    private Node nodeMaximum() {
        if (this.size == 0)
            return null;
        // Start at the max sentinel and move down.
        Node currentNode = this.head.getRight();
        while (currentNode.getBelow() != null) {
            currentNode = currentNode.getBelow();
        }
        // Return the sentinel's left node's key.
        return currentNode.getLeft();
    }
                                                                                                         
    // Finds an Object that has the next larger key in the set above k, 
    // and returns a pointer to it, or null if k is the maximum element.
    public Object successor(KeyType k) {
        if (this.size == 0)
            return null;
        Node n = nodeSearch(k);
        // If nodeSearch didn't find the node with k, return null.
        if (n.getKey().compareTo(k) != 0) {
            return null;
        }
        else {
            // If nodeSearch found the node with k, check if it's the max.
            if (n == nodeMaximum())
                return null;
            return n.getRight().getKey();
        }
    }

    // Finds an Object that has the next smaller key in the set below k,
    // and returns a pointer to it, or null if k is the minimum element.
    public Object predecessor(KeyType k) {
        if (this.size == 0)
            return null;
        Node n = nodeSearch(k);
        // If nodeSearch didn't find the node with k, return null.
        if (n.getKey().compareTo(k) != 0) {
            return null;
        }
        // If n is the min element, return null.
        if (n == nodeMinimum())
            return null;
        return n.getLeft().getKey();
    }

    // Adds a new level to the skip list. Sets pointers and new head.
    private void addLevel() {
        Node newHead = new QuadNode(MIN_VALUE);
        Node newHeadRight = new QuadNode(MAX_VALUE);
        newHead.setBelow(this.head);
        this.head.setAbove(newHead);
        newHead.setRight(newHeadRight);
        newHeadRight.setLeft(newHead);
        newHeadRight.setBelow(this.head.getRight());
        this.head.getRight().setAbove(newHeadRight);
        this.head = newHead;
        this.numLevels++;
    }

    // Helper function for creating a tower of nodes.
    private List<Node> getTopNodes() {
        List<Node> nodes = new ArrayList<Node>(2);
        nodes.add(LEFT, this.head);
        nodes.add(RIGHT, this.head.getRight());
        return nodes;
    }

    // Print space-separated values of the keys of the bottom level only.
    public String toString() {
        String s = "";
        Node currentNode = this.head;
        while (currentNode.getBelow() != null) {
            currentNode = currentNode.getBelow();
        }
        currentNode = currentNode.getRight();
        while (currentNode.getKey().getValue().compareTo(MAX_VALUE) != 0) {
            s += currentNode.getKey().getValue() + " ";
            currentNode = currentNode.getRight();
        }
        return s;
    }
}

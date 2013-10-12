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

/** 
 * RedBlackDynamicSet is the red-black tree implementation of DynamicSet.
 * 
 * @author Kyle Mulleady
 * @version 1.0
 */
public class RedBlackDynamicSet implements DynamicSet {

    private Node root;
    private int size;
     
    public RedBlackDynamicSet() {
    }

    public int size() {
        return this.size;
    }

    public void insert(KeyType k, Object e) {
    }

    private void insert(KeyType k) {
    }

    private void insertFix() {
    }
                                        
    public void delete(KeyType k) {
    }
                                                   
    private void deleteFix() {
    }

    public Object search(KeyType k) {
        return null;
    }

    // Returns the node of interest.
    private Node nodeSearch(KeyType k) {
        if (this.size == 0)
            return null;
        // Start at the root. 
        Node currentNode = this.root;
        // Make comparisons and move down the tree as necessary.
        while (currentNode != null) {
            if (currentNode.getKey().compareTo(k) == 0) {
                return currentNode;
            }
            else if (currentNode.getKey().compareTo(k) > 0) {
                currentNode = currentNode.getLeft();
            }
            else {
                currentNode = currentNode.getRight();
            }
        }
        // If we made it here, the search was unsuccessful.
        return null;
    }
                                                                   
    public Object minimum() {
        return null;
    }
                                                                                         
    public Object maximum() {
        return null;
    }
                                                                                                         
    public Object successor(KeyType k) {
        return null;
    }

    public Object predecessor(KeyType k) {
        return null;
    }
}




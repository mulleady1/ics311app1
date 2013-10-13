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
 * BSTNode extends the abstract class Node and is used solely by BSTDynamicSet.
 *
 * @author Kyle Mulleady
 * @version 1.0
 */
public class BSTNode extends Node {

    /**
     *  the parent node
     */
    private Node p;

    public BSTNode() { }
    public BSTNode(String s)  { super(s); }
    public BSTNode(KeyType k) { super(k); }
    public Node getP() { return this.p; }
    public void setP(Node n) { this.p = n; }

    // These methods are not used in BSTNode.
    public Node getAbove() { throw new UnsupportedOperationException(); }
    public Node getBelow() { throw new UnsupportedOperationException(); }
    public void setAbove(Node n) { throw new UnsupportedOperationException(); }
    public void setBelow(Node n) { throw new UnsupportedOperationException(); }
    public boolean isRed() { throw new UnsupportedOperationException(); }
    public void isRed(boolean b) { throw new UnsupportedOperationException(); }
}

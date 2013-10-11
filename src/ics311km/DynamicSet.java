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

public interface DynamicSet {
// ADT that stores and retrieves Objects according to keys of type KeyType
     
    // Creates an instance of ADT DynamicSet and initializes it to the empty set.   
    //public DynamicSet(); 

    public int size();
    // Returns the number of elements currently in the set.

    public void insert(KeyType k, Object e); 
    // Inserts element e in the set under key k.
                                        
    public void delete(KeyType k); 
    // Given a key k, removes elements indexed by k from the set.
                                                   
    public Object search(KeyType k); 
    // Finds an Object with key k and returns a pointer to it,
    // or null if not found. 
                                                                   
    // The following operations apply when there is a total ordering on KeyType   
                                                                         
    public Object minimum(); 
    // Finds an Object that has the smallest key, and returns a pointer to it,
    // or null if the set is empty. 
                                                                                         
    public Object maximum(); 
    // Finds an Object that has the largest key, and returns a pointer to it,
    // or null if the set is empty.
                                                                                                         
    public Object successor(KeyType k); 
    // Finds an Object that has the next larger key in the set above k, 
    // and returns a pointer to it, or null if k is the maximum element.

    public Object predecessor(KeyType k); 
    // Finds an Object that has the next smaller key in the set below k,
    // and returns a pointer to it, or null if k is the minimum element.

}




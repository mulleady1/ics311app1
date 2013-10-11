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
 * ADT that stores and retrieves Objects according to keys of type KeyType
 * 
 * @author Dan Suthers
 * @version 1.0
 */
public interface DynamicSet {
     
    /**
     * Creates an instance of ADT DynamicSet and initializes it to the empty set.   
     */
    //public DynamicSet(); 

    /**
     * @return  the number of elements currently in the set.
     */
    public int size();

    /**
     * Inserts k.getValue() in the set under key k.
     */
    public void insert(KeyType k, Object e); 
                                        
    /**
     * Given a key k, removes elements indexed by k from the set.
     */
    public void delete(KeyType k); 
                                                   
    /**
     * Finds an Object with key k and returns a pointer to it,
     * or null if not found. 
     *
     * @return  an Object to be casted to KeyType
     */
    public Object search(KeyType k); 
                                                                   
    // The following operations apply when there is a total ordering on KeyType   
                                                                         
    /**
     * Finds an Object that has the smallest key, and returns a pointer to it,
     * or null if the set is empty. 
     *
     * @return  an Object to be casted to KeyType
     */
    public Object minimum(); 
                                                                                         
    /**
     * Finds an Object that has the largest key, and returns a pointer to it,
     * or null if the set is empty. 
     *
     * @return  an Object to be casted to KeyType
     */
    public Object maximum(); 
                                                                                                         
    /**
     * Finds an Object that has the next larger key in the set above k, 
     * and returns a pointer to it, or null if k is the maximum element.
     *
     * @return  an Object to be casted to KeyType
     */
    public Object successor(KeyType k); 

    /**
     * Finds an Object that has the next smaller key in the set below k, 
     * and returns a pointer to it, or null if k is the minimum element.
     *
     * @return  an Object to be casted to KeyType
     */
    public Object predecessor(KeyType k); 
}




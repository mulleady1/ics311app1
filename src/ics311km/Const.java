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
 * Const is an interface that defines the constants used throughout the 
 * ics311km package.
 *
 * @author Kyle Mulleady
 * @version 1.0
 */
public interface Const {
    /**
     * the sentinel value 'negative infinity'
     */
    final String MIN_VALUE = "NEGATIVE_INFINITY";
    /**
     * the sentinel value 'positive infinity'
     */
    final String MAX_VALUE = "POSITIVE_INFINITY";
    /**
     * used by SkipListDynamicSet for accessing left nodes in a tower.
     */
    final int LEFT = 0;
    /**
     * used by SkipListDynamicSet for accessing right nodes in a tower.
     */
    final int RIGHT = 1;

    // Constants used in my Driver.java.
    final int LIMIT = 10;
    final int NUM_DATA_STRUCTURES = 3;
    final String RUNTEST = "runtest";
    final String INSERT  = "insert";
    final String SEARCH  = "search";
    final String DELETE  = "delete";
    final String PRED    = "pred";
    final String SUCC    = "succ";
    final String MAX     = "max";
    final String MIN     = "min";
}

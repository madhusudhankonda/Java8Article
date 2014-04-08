/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.madhusudhan.java8.article.interfaces;

/**
 *
 * @author mkonda
 */
public class Test {
    ISquareRoot root = (i) ->  Math.sqrt(i);
    
    private void testSquareRoot(double d) {
        System.out.println("SQ ROOT "+root.sqrt(d));
    }
    
    public static void main(String[] args) {
        Test t = new Test();
        t.testSquareRoot(225);
    }
    
}

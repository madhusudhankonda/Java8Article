/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.madhusudhan.java8.article.interfaces.virtual;

/**
 *
 * @author mkonda
 */
public class VirtualFunctionTest {
    
    IComponent c = () -> System.out.println("Component:");
    
    class Component implements IComponent {
        @Override
        public String getComponentName(){
            return "Actual Component Name";
            
        }

        @Override
        public void init() {
        }
    };

    private void test() {
//        Component c = new Component();
        System.out.println("Component default values: Name: "+c.getComponentName()+", created on: "+c.getCreationDate());
    }

    public static void main(String[] args) {
        VirtualFunctionTest test = new VirtualFunctionTest();
        test.test();
    }
}

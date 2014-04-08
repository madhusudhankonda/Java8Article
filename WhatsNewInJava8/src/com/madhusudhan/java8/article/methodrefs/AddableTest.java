package com.madhusudhan.java8.article.methodrefs;

import java.util.function.Consumer;


/**
 *
 * @author mkonda
 */
public class AddableTest {

    IAddable addable = (a, b) -> a+b;
    IAddable addableViaMethodReference = this::addThemUp;
    IAddable addableViaMethodReference2 = Integer::sum;
    IAddable addableViaMethodReference3 = AddableUtil::addThemUp;
    IAddable addableViaMethodReference4 = new AddableUtil2()::addThemUp;

  
    private int addThemUp(int i1, int i2){
        return i1*i2;
    }
    public void add(int i1, int i2){
        System.out.println("Sum of two numbers using lambda: "+addable.add(i1, i2));
        System.out.println("Sum using Method Reference to a local method: "+addableViaMethodReference.add(i1, i2));
        System.out.println("Sum using references to a someother type's method: "+addableViaMethodReference2.add(i1, i2));
        System.out.println("Sum of two numbers some other object's method: "+addableViaMethodReference3.add(i1, i2));
        System.out.println("Sum of two numbers some other object's method: "+addableViaMethodReference4.add(i1, i2));
    }
    public static void main(String[] args) {
        AddableTest test = new AddableTest();
        test.add(100, 200);
    }
    
}

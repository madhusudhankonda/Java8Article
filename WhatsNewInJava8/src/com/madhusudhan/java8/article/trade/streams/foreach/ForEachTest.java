/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.madhusudhan.java8.article.trade.streams.foreach;

import com.madhusudhan.java8.article.trade.Trade;
import com.madhusudhan.java8.article.trade.util.TradeUtil;
import java.util.List;
import java.util.function.Consumer;

/**
 *
 * @author mkonda
 */
public class ForEachTest {
    List<Trade> trades = TradeUtil.createTrades();

    private void testForEach1(){
        trades.forEach(trade -> System.out.println(trade));
    }
    private void testForEach2(){
        trades.forEach(System.out::println);
    }
    private void testForEach3(){
        Consumer<Trade> printTrade = trade -> System.out.println(trade); 
        trades.forEach(printTrade);
    }
    
    public static void main(String[] args) {
        ForEachTest coreTest = new ForEachTest();
        coreTest.testForEach1();
        coreTest.testForEach2();
        coreTest.testForEach3();
    }
            
}

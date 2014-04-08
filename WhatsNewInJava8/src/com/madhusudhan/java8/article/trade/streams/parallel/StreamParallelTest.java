/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.java8.article.trade.streams.parallel;

import com.madhusudhan.java8.article.trade.Trade;
import com.madhusudhan.java8.article.trade.util.TradeUtil;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;


/**
 *
 * @author mkonda
 */
public class StreamParallelTest {

    Consumer<Trade> print = x -> doSomething(x);
    Consumer<Trade> consumer = x -> x.setQuantity(x.getQuantity() * 2);
    List<Trade> trades = TradeUtil.createTrades(100);

    private void doSomething(Trade t) {
        try {
            System.out.println(t);
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException ex) {
            System.out.println("Sleeping...");
        }
    }

    private void runSequential() {
       
        int cpus = Runtime.getRuntime().availableProcessors();
        long start = System.currentTimeMillis();
        trades.stream().forEach(t->doSomething(t) );
        long end = System.currentTimeMillis();

        System.out.println("Time for sequential op:"+(end - start)/1000+"sec on "+cpus);

    }
    
    private void runParallel() {
      
        int cpus = Runtime.getRuntime().availableProcessors();
        long start = System.currentTimeMillis();
        trades.stream().parallel().forEach(t->doSomething(t) );
        long end = System.currentTimeMillis();

        System.out.println("Time for parallel op:"+(end - start)/1000+"sec on "+cpus);

    }

    private double timeDiff(long start, long end) {
        return (end - start) / 1000000000;
    }

    public static void main(String[] args) {
        StreamParallelTest test = new StreamParallelTest();
        test.runSequential();
//        test.runParallel();
    }

}

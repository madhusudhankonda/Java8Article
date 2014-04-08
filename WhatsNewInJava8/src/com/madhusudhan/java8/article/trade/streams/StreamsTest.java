/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.java8.article.trade.streams;

import com.madhusudhan.java8.article.trade.Trade;
import com.madhusudhan.java8.article.trade.util.TradeUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author mkonda
 */
public class StreamsTest {

    private final int THRESHOLD = 3000;
    Consumer<Trade> printQuantity = x -> System.out.println("Quantiy: " + x.getQuantity());
    Consumer<Trade> consumer = x -> x.setQuantity(x.getQuantity() * 2);
    Predicate p = null;
    List<Trade> trades = TradeUtil.createTrades();

    int[] ids = {1,2,3};
    Integer[] iArray = new Integer[]{1,2};
    
    private List<Trade> preJava8LargeTrades(List<Trade> trades) {
        List<Trade> largeTrades = new ArrayList<Trade>();
        
        for (Trade trade : trades) {
            if(trade.getQuantity() > THRESHOLD)
            largeTrades.add(trade);
        }
        return largeTrades;
    }
    
    
    private List<Trade> java8LargeTrades(List<Trade> trades ) {
        
        return trades.stream()
                .filter(trade -> trade.getQuantity() > THRESHOLD)
                .collect(Collectors.toList());
        
    }
    
    private void createStreams() {
        Stream<Trade> tradeStream = trades.stream();
        
        
        long count = Stream.of(1,2,3,5,6,7).count();
        System.out.println("Elements in Stream: "+count);

        count = Stream.of(new Trade(1,"IBM",120,"NEW"), new Trade(2,"GGL",200,"NEW")).count();
        System.out.println("Trades in Stream: "+count);

        Stream.of(iArray)
                .forEach(x->System.out.println(x+"-"+x.getClass()))
                ;
        System.out.println("using array: "+count);
        
    } 

    // fiter all IBM trades
    // and filter only trades qty  > 2000
    // multiply by 10!
    
    private void findFirstOrElse() {
    
        Trade trade = trades.stream()
                .filter(t -> t.getIssuer().equals("IBM"))
                .filter(t-> t.getQuantity()>1000)
                .filter(t -> t.getStatus().equals("PENDING"))
                .findFirst()
                .orElse(null);
        
        System.out.println("Trade: " + trade);
    }
    
    private Stream<Trade> getTrades(String issuer, String status, int qty) {
    
        return trades.stream()
                .filter(t -> t.getIssuer().equals(issuer))
                .filter(t-> t.getQuantity()>qty)
                .filter(t -> t.getStatus().equals(status));
    }

    
    private void testStream2() {
        List<Trade> trades = TradeUtil.createTrades();

        System.out.println("Trades: " + trades);
        
        trades.stream().allMatch(t -> t.getIssuer().equals("IBM"));   
        System.out.println("Trades: " + trades);
    }

    private void testStreams() {

        List<Trade> trades = TradeUtil.createTrades();
        long x = trades.stream().map(t -> {
            t.setQuantity(t.getQuantity() * 2);
            return t;
        }).filter(trade -> trade.getQuantity() > 5000)
                .count();

        System.out.println("Count of double of tradew with more than 5000:" + x);
        trades.stream().forEach(printQuantity);

    }

    public static void main(String[] args) {
//        new StreamsTest().createStreams();
        new StreamsTest().findFirstOrElse();
//        new StreamsTest().testStreams();
//        new StreamsTest().testStreamFilters();
        List<Trade> trades = TradeUtil.createTrades();
        
        List<Trade> oldTrades = new StreamsTest().preJava8LargeTrades(trades);
        System.out.println("Old Trades: "+oldTrades);
        List<Trade> newTrades = new StreamsTest().java8LargeTrades(trades);
        System.out.println("New Trades: "+newTrades);
    }
}

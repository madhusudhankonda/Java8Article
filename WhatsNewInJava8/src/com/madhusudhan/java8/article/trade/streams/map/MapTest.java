/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.java8.article.trade.streams.map;

import com.madhusudhan.java8.article.trade.Trade;
import com.madhusudhan.java8.article.trade.util.TradeUtil;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 *
 * @author mkonda
 */
public class MapTest {

    List<Trade> trades = TradeUtil.createTrades();

    private Optional<Trade> getTradeById(int tradeId) {
        Optional<Trade> trade = trades.stream()
                .filter(t -> t.getTradeId() == tradeId)
                .findFirst();
        return trade;
    }

    private void mapIDsToTrades(Integer[] ids) {

        Stream.of(ids)
                .map(id -> getTradeById(id))
                .forEach(System.out::println);

//        trades.stream().map(t -> t.getQuantity()).forEach(System.out::println);
    }

    private void doubleQty(int bigTrade) {

        Function<Trade, Integer> doubledQty = t -> {
            t.setQuantity(t.getQuantity() * 2); 
            return t.getQuantity();
        };
        
        long x = trades.stream()
                .map(doubledQty)
                .filter(qty -> qty > bigTrade)
                .count();

        System.out.println(String.format("Count of trades with more than %d qty is %d",bigTrade, x));
//        trades.stream().forEach(printQuantity);

    }
    
    private void mapReduce() {

        Function<Trade, Integer> doubleQty = t -> {
            t.setQuantity(t.getQuantity() * 2); 
            return t.getQuantity();
        };
        
        BinaryOperator<Integer> adder = (a,b) -> {
            System.out.println("A and B: "+a+","+b);
            return a+b;
        };
        Integer sum = trades.stream()
                .map(doubleQty)
                .reduce(1,adder);
        
        System.out.println("Sum of qtys:"+sum);
        
    }
    private void mapReduce1() {

        BinaryOperator<Integer> adder = (a,b) -> a+b;

        Integer aggQty = trades.stream()
                .map(t->t.getQuantity())
                .reduce(0,adder);
        
        System.out.println("Sum of qtys:"+aggQty);
        
    }

    private void mapReduce2() {
        BinaryOperator<String> adder = (a,b) -> {
            System.out.println("A and B: "+a+","+b);
            return a+b;
        };
        String[] alphabets = {"Just","Java 8"};
        String sum = Stream.of(alphabets)
                .reduce(" ",adder);
        
        System.out.println("Alphabets:"+sum);
        
    }
    public static void main(String[] args) {
        MapTest test = new MapTest();
//        Integer[] ids = {1, 3};
//        test.mapIDsToTrades(ids);
//        test.doubleQty(5000);
//        test.mapReduce();
        test.mapReduce1();
//        test.mapReduce2();
    }
}

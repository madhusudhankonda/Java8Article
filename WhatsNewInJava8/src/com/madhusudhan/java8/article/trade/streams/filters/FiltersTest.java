/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.java8.article.trade.streams.filters;

import com.madhusudhan.java8.article.trade.Trade;
import com.madhusudhan.java8.article.trade.util.TradeUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 *
 * @author mkonda
 */
public class FiltersTest {
   List<Trade> trades = TradeUtil.createTrades();

    // conventional
    private void conventionalFilter(String issuer) {
        List<Trade> issuerTrades = new ArrayList<Trade>();

        for (Trade trade : trades) {
            if (trade.getIssuer().equals(issuer)) {
                issuerTrades.add(trade);
            }
        }
        System.out.println("Trade for " + issuer + " " + issuerTrades);
    }

    private void filter1(String issuer) {
        trades.stream()
                .filter(t -> t.getIssuer().equals(issuer))
                .forEach(System.out::println);

    }

    private void filter2(String issuer, int quantity) {
   
        trades.stream()
                .filter(t -> t.getIssuer().equals(issuer))
                .filter(t -> t.getQuantity() > quantity)
                .forEach(x -> System.out.println(issuer+" trades, qty over 2000 "+x));

    }
    private void filter3(String issuer, int quantity, String status) {

        Consumer<Trade> printTrade = x -> System.out.println(issuer+" trades, qty over "+quantity+", in a "+status+" state:"+x);
        trades.stream()
                .filter(t -> t.getIssuer().equals(issuer))
                .filter(t -> t.getQuantity() > quantity)
                .filter(t -> t.getStatus().equals(status))
                .forEach(printTrade);

    }

    public static void main(String[] args) {
        FiltersTest test = new FiltersTest();
//        test.conventionalFilter("IBM");
//        test.filter1("IBM");
//        test.filter2("IBM",2000);
        test.filter3("IBM",1000,"NEW");
    }

}

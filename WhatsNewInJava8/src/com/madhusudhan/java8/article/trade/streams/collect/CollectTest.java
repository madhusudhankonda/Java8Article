/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.madhusudhan.java8.article.trade.streams.collect;

import com.madhusudhan.java8.article.trade.Trade;
import com.madhusudhan.java8.article.trade.util.TradeUtil;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.groupingBy;

/**
 *
 * @author mkonda
 */
public class CollectTest {
    List<Trade> trades = TradeUtil.createTrades();

    private void collectQuantitiesToList() {
        List<Integer> list = trades.stream()
                .map(t->t.getQuantity())
                .collect(toList());
        System.out.println("Collect List: "+list);
    }
    
    private void group() {
        Map<String, List<Trade>> issuers = trades.stream()
                .collect(groupingBy(t->t.getIssuer()));
        
        System.out.println("Grouped List: "+issuers);
    }
    
    public static void main(String[] args) {
        CollectTest test = new CollectTest();
        test.collectQuantitiesToList();
        test.group();
    }
}

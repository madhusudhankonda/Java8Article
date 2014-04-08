/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.madhusudhan.java8.article.trade.util;

import com.madhusudhan.java8.article.trade.Trade;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mkonda
 */
public class TradeUtil {

    public static List<Trade> createTrades(){
        List<Trade> trades = new ArrayList<Trade>();
        
        Trade t = new Trade(1,"IBM",1000,"NEW");
        trades.add(t);
        t = new Trade(2,"APPL",2000,"NEW");
        trades.add(t);
        t = new Trade(3,"IBM",3000,"NEW");
        trades.add(t);
        t = new Trade(4,"IBM",4000,"PENDING");
        trades.add(t);
        
        return trades;
    }
    
    public static List<Trade> createTrades(int size){
        List<Trade> trades = new ArrayList<>();
        
        for (int i = 0; i < size; i++) {
            Trade t = new Trade(i,"ISUER "+i,i+1000,"NEW");
            trades.add(t);
        }
        
        return trades;
    }
    
    
}

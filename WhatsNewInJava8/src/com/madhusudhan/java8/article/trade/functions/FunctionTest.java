/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.madhusudhan.java8.article.trade.functions;

import com.madhusudhan.java8.article.trade.Trade;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 *
 * @author mkonda
 */
public class FunctionTest {
 
    Function<String,Integer> stringToInt = x -> new Integer(x);

    Function<Integer,Double> centToFahrenheitInt = x -> new Double((x*9/5)+32);
    
    Function<List<Trade>,Integer> aggegatedQuantity = x -> {
        int aggregatedQuantity = 0;
        for (Trade t: x){
            aggregatedQuantity+=t.getQuantity();
        }
        return aggregatedQuantity;
    };
    
    Function<List<Trade>,Integer> aggegatedQuantityUsingUtility = x -> {
        int aggregatedQuantity = 0;
//        x.stream().forEach(x-> Trade:: new);

        return aggregatedQuantity;
    };
    
    
    //using streams!
    Function<List<Trade>,Integer> aggegatedQuantity2 = trades -> {
        int aggregatedQuantity = 0;
        aggregatedQuantity = trades.stream().map((t) -> t.getQuantity()).reduce(aggregatedQuantity, Integer::sum);
        return aggregatedQuantity;
    };
    
    private void toFahrenheit(int centigrade) {
        double fahrenheit = centToFahrenheitInt.apply(centigrade);
        System.out.println("Centigrade to Fahrenheit: "+centToFahrenheitInt.apply(centigrade));
    }
    
    private void stringToInteger(String s) {
        int i = stringToInt.apply(s);
        System.out.println("String to integer: "+i);
    }
    
    private int aggregatedTradeQuantity(List<Trade> trades) {
        int aggQty = aggegatedQuantity.apply(trades);
        System.out.println("Aggregated quantity: "+aggQty);
        return aggQty;
    }
    
    private static List<Trade> createTrades(){
        List<Trade> trades = new ArrayList<Trade>();
        
        Trade t = new Trade(1,"XT",1000,"NEW");
        trades.add(t);
        t = new Trade(2,"XT",2000,"NEW");
        trades.add(t);
        t = new Trade(3,"XT",3000,"NEW");
        trades.add(t);
        t = new Trade(4,"XT",4000,"NEW");
        trades.add(t);
        
        return trades;
    }
    public static void main(String[] args) {
        new FunctionTest().stringToInteger("10");
        new FunctionTest().toFahrenheit(21);
        new FunctionTest().aggregatedTradeQuantity(createTrades());
    }
}

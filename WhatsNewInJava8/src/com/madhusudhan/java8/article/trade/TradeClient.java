/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.java8.article.trade;

import com.madhusudhan.java8.article.trade.util.TradeUtil;
import java.util.List;

/**
 *
 * @author mkonda
 */
public class TradeClient {

    ITrade newTradeChecker = (Trade t) -> t.getStatus().equals("NEW");

    private boolean checkTrade(Trade trade, ITrade tradeLambda) {
        return tradeLambda.check(trade);
    }

    private boolean checkTrade(ITrade tradeLambda, Trade trade) {
        return tradeLambda.check(trade);
    }

    private List<Trade> applyLambdaOnTrades(ITrade tradeLambda, List<Trade> trades) {
        List<Trade> newTrades = null;
        for (Trade trade : trades) {
            if (tradeLambda.check(trade)) {
                newTrades.add(trade);
            }
        }
        return newTrades;
    }

    public static void main(String[] args) {
        TradeClient client = new TradeClient();
        ITrade tradeLambda = (Trade t) -> t.getStatus().equals("NEW");
        ITrade bigTradeLambda = (Trade t) -> t.getQuantity() > 10000000;
        ITrade googleBigNewTradeLambda = (Trade t) -> {
            if(t.getIssuer().equals("GOOG") && 
               t.getQuantity() > 10000000 &&
               t.getStatus().equals("NEW"))
                return true;
            return false;
        };

        Trade t = new Trade(1, "GOOG", 20000020, "NEW");

        if (client.checkTrade(t, tradeLambda)) {
            System.out.println("NEW trade");
        } 
        if (client.checkTrade(t, bigTradeLambda)) {
            System.out.println("BIG trade");
        }
        if (client.checkTrade(t, googleBigNewTradeLambda)) {
            System.out.println("A NEW, BIG GOOGLE trade");
        }
        List<Trade> trades = client.applyLambdaOnTrades(googleBigNewTradeLambda,TradeUtil.createTrades());
            
        System.out.println("Trades "+trades);
    }
}

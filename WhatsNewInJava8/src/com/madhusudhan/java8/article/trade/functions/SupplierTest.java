/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.madhusudhan.java8.article.trade.functions;

import com.madhusudhan.java8.article.trade.Trade;
import com.madhusudhan.java8.article.trade.util.TradeUtil;
import java.util.List;
import java.util.function.Supplier;

/**
 *
 * @author mkonda
 */
public class SupplierTest {
    Supplier<List<Trade>> supplier = () -> TradeUtil.createTrades();
    
    private void testSupplier() {
        System.out.println("Supplier Result "+supplier.get());
    }
    
    public static void main(String[] args) {
        new SupplierTest().testSupplier();
        
    }
    
}

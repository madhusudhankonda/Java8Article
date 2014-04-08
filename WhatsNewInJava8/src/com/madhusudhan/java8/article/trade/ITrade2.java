/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.madhusudhan.java8.article.trade;

/**
 *
 * @author mkonda
 */
public interface ITrade2<T,V> {
    public T  action(T t, V v);
}

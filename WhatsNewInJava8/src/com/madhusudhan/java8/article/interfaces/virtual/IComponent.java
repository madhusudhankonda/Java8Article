/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.madhusudhan.java8.article.interfaces.virtual;

import java.util.Date;

/**
 *
 * @author mkonda
 */
@FunctionalInterface
public interface IComponent {
    String componentName = "Default component name";
    Date creationDate = new Date();
    
    public void init();
    default String getComponentName(){
        return componentName;
    }
    
    default Date getCreationDate(){
        return creationDate;
    }    
}

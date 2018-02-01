/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinerefactor.dto;

import java.math.BigDecimal;

/**
 *
 * @author kmlnd
 */
public enum Currency {
    PENNIES(new BigDecimal("0.01")),
    QUARTERS(new BigDecimal("0.25")),
    NICKELS(new BigDecimal("0.05")),
    DIMES(new BigDecimal("0.10")),
    DOLLARS(new BigDecimal("1.00")),
    FIVEDOLLARS(new BigDecimal("5.00"));
    
  
    //variable that holds the big decimal
    BigDecimal coins; 
    
    //constructor
    Currency(BigDecimal coins){
        this.coins = coins;
    }

    //only need a getter
    public BigDecimal getCoins() {
        return coins;
    }

    
    
   
    
}

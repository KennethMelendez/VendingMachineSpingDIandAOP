/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinerefactor.dto;

import static com.sg.vendingmachinerefactor.dto.Currency.DOLLARS;
import static java.lang.Integer.parseInt;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author kmlnd
 */
public class Change {

    public BigDecimal cashier(BigDecimal UserMoney, Item UserItem) {

        //variables for USER PRICE AND ITEM COST
        BigDecimal ItemCost = UserItem.getItemCost();
        BigDecimal result = UserMoney.subtract(ItemCost);

        

        return result;

    }

    public String makeChangeOutput(BigDecimal UserMoney) {

        //variables for USER PRICE AND ITEM COST
       
        BigDecimal result = UserMoney;

        //String convertOutputToString = result.toString();
        
        
        /*  ____________________________    
            Assigning ENUMS to Variables
            ****************************
                      ô¿ô
                       -
         */
        
        BigDecimal UserCashRemainingAmount = result;
        
        BigDecimal DOLLARS = Currency.DOLLARS.getCoins();
        BigDecimal QUARTERS = Currency.QUARTERS.getCoins();
        BigDecimal FIVEDOLLARS = Currency.FIVEDOLLARS.getCoins();
        BigDecimal NICKELS = Currency.NICKELS.getCoins();
        BigDecimal PENNIES = Currency.PENNIES.getCoins();
        BigDecimal DIMES = Currency.DIMES.getCoins();

        int fiveDollars = 0;
        int dollars = 0;
        int quarters = 0;
        int nickels = 0;
        int pennies = 0;
        int dimes = 0;

        // Multiplying the result by 100
        //UserCashRemainingAmount.multiply(new BigDecimal("100"));

        while (UserCashRemainingAmount.compareTo(FIVEDOLLARS) >= 0) {
            fiveDollars++;
            UserCashRemainingAmount = UserCashRemainingAmount.subtract(FIVEDOLLARS);
        }

        while (UserCashRemainingAmount.compareTo(DOLLARS) >= 0) {
            dollars++;
            UserCashRemainingAmount = UserCashRemainingAmount.subtract(DOLLARS);
        }

        while (UserCashRemainingAmount.compareTo(QUARTERS) >= 0) {
            quarters++;
            UserCashRemainingAmount = UserCashRemainingAmount.subtract(QUARTERS);
        }

        while (UserCashRemainingAmount.compareTo(DIMES) >= 0) {
            dimes++;
            UserCashRemainingAmount = UserCashRemainingAmount.subtract(DIMES);
        }

        while (UserCashRemainingAmount.compareTo(NICKELS) >= 0) {
            nickels++;
            UserCashRemainingAmount = UserCashRemainingAmount.subtract(NICKELS);
        }
        while (UserCashRemainingAmount.compareTo(PENNIES) >= 0) {
            pennies++;
            UserCashRemainingAmount = UserCashRemainingAmount.subtract(PENNIES);
        }
        return "\nHere is your change.\n==> Five Dollars: " + fiveDollars + "\n==> Dollars: " + dollars + "\n==> Quarters: " + quarters + "\n==> Nickels: " + nickels + "\n==> Dimes: " + dimes + "\n==> Pennies " + pennies+"\n";

    }

}

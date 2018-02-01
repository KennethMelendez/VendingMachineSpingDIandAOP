/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinerefactor.servicelayer;

import com.sg.vendingmachinerefactor.dao.PersistanceException;
import com.sg.vendingmachinerefactor.dto.Item;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author kmlnd
 */
public interface ServiceLayer {

    Item getItem(String ItemID) throws PersistanceException;

    List<Item> ItemList() throws PersistanceException;
 
    boolean inventoryAvailibility(BigDecimal userMoney, Item selectedItem) throws InventoryAvailibilityException;
    
    boolean checkIfMoneyEnough(BigDecimal userMoney, Item selectedItem)throws InsufficientFundsException;
    
    //call change method and call dao to subtract one
    BigDecimal completePurchase(BigDecimal userMoney, Item selectedItem)throws InventoryAvailibilityException;
}

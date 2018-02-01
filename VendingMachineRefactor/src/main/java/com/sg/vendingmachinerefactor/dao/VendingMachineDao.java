/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinerefactor.dao;

import com.sg.vendingmachinerefactor.dto.Item;
import java.util.List;

/**
 *
 * @author kmlnd
 */
public interface VendingMachineDao {

    //getProduct returns item class
    //getProductChangeInventory
    //List get products return arrayList with values
    Item getItem(String ItemID) throws PersistanceException;

    List<Item> ItemList() throws PersistanceException;

   void SaveState() throws PersistanceException;
    

}

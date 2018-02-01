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
public class Item {
    
    
    private String ItemID;
    private String ItemName;
    private BigDecimal ItemCost;
    private int ItemInventory;

    /*
        Creating the ItemID as the identifier for
        the program.
    */
    
    
    public Item(String ItemID) {
        this.ItemID = ItemID;
    }

    
    
    public String getItemID() {
        return ItemID;
    }

    
    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }

    public BigDecimal getItemCost() {
        return ItemCost;
    }

    public void setItemCost(BigDecimal ItemCost) {
        this.ItemCost = ItemCost;
    }

    public int getItemInventory() {
        return ItemInventory;
    }

    public void setItemInventory(int ItemInventory) {
        this.ItemInventory = ItemInventory;
    }
    
    
    @Override
    public String toString(){
        return " ID " + ItemID + "| Name " + ItemName + "| ItemCost " + ItemCost.toString() + "| Item Inventory " + ItemInventory;
    }
    
    
}

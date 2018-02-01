/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinerefactor.ui;

import com.sg.vendingmachinerefactor.dao.PersistanceException;
import com.sg.vendingmachinerefactor.dto.Change;
import com.sg.vendingmachinerefactor.dto.Item;
import java.util.List;
import static java.lang.Integer.parseInt;
import java.math.BigDecimal;

/**
 *
 * @author kmlnd
 */
public class View {

    private UserIO io;

    public View(UserIO io) {
        this.io = io;
    }
    
    public void DISPLAYCHANGEAMOUNTandCurrentAMOUNT(BigDecimal Cash){
        Change change = new Change();
        String OutputTheChangeResult = change.makeChangeOutput(Cash);
        io.DisplayString(OutputTheChangeResult);
        io.DisplayString("Current Currency : $" + Cash.toString());
    }

    public void menu(List<Item> myList) throws PersistanceException {
     
        myList.forEach((currentList) -> {
            io.DisplayString("Inventory Code: ("+currentList.getItemID()+")" + " | Item: " + currentList.getItemName() + " | Price: " + currentList.getItemCost());
          
        });
    }

    public void WelcomeBanner() {
        io.DisplayString("============== VENDING MACHINE MENU ==============");
    }
    
    public void EXITBUTTON(){
        io.DisplayString("============== ( EXIT ) ==============");
    }

    public BigDecimal InsertCash(){
        
        String cash = io.ReadString("Please Insert Cash");
        return new BigDecimal(cash);
    }
    
    public String InsertInventoryCode(){
        return io.ReadString("Please Insert Selection (Code/Exit)");
    }
    
    public void HitEnterToContinue(){
        io.ReadString("Hit Enter To Continue.");
    }
    
    public void DisplayProductName(String msg){
        io.DisplayString(msg);
    }
    public void DisplayErrorEXCEPTION(String msg){
        io.DisplayString(msg);
    }
    public void DISPLAYCURRENTMONEY(String msg){
        io.DisplayString(msg);
    }
}



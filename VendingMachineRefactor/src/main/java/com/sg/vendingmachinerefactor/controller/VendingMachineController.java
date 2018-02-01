/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinerefactor.controller;

import com.sg.vendingmachinerefactor.dao.PersistanceException;
import com.sg.vendingmachinerefactor.dao.VendingMachineDao;
import com.sg.vendingmachinerefactor.dto.Change;
import com.sg.vendingmachinerefactor.dto.Item;
import com.sg.vendingmachinerefactor.servicelayer.DataValidation;
import com.sg.vendingmachinerefactor.servicelayer.ServiceLayer;
import com.sg.vendingmachinerefactor.ui.UserIO;
import com.sg.vendingmachinerefactor.ui.View;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kmlnd
 */
public class VendingMachineController {

    View view;
    ServiceLayer serviceLayer;
    Change change;

    public VendingMachineController(View view, ServiceLayer serviceLayer, Change change) {
        this.view = view;
        this.serviceLayer = serviceLayer;
        this.change = change;
    }

    
    
    
    
    
    /* 
    []  []  []  []  []  []  []  []  []  []  []  []  []  []  []  []  
    
                WELCOME TO THE VENDING MACHINE
    
    []  []  []  []  []  []  []  []  []  []  []  []  []  []  []  [] */
 /*RESTOCK ITEMS IN THE inventory.txt file*/
    
    
    
    
    
    
    
    public void run() {

        boolean runProgram = true;                                                                      //runs the program
        boolean runPrompt = true;

        //===[  START OF LOOP that runs the prompt for the users money  ]
        while (runPrompt) {
            WelcomeBanner();                                                                            //WELCOME BANNER        
            try {                                                                                       //Creates a try in order to catch and exceptions        
                getMenu();

                EXITBUTTON();
                BigDecimal Cash = InputCash();

                if (Cash == null) {
                    runProgram = false;
                }

                while (runProgram) {                                                                   //[  START OF LOOP that runs the main app    ]
                    try {
                        getMenu();
                        EXITBUTTON();                                                                  //displays exit button
                        String PURCHASECODE = InputCode();

                        //[BREAK OUT OF LOOP CODE EXIT OPTION]
                        if (PURCHASECODE.equalsIgnoreCase("exit")) {
                            //if user presses exits you will break out of both loops
                            runProgram = false;
                            runPrompt = false;
                            break;
                        } else {
                            // ______________Below
                            //else continue with the program and get the item display and calculate currency
                            //Calling the cash program method in order to output the change
                            //below displays the amount of money you have and the current change

                            Item getItem = getItem(PURCHASECODE);
                            displayItemIntoIO("Item: " + getItem.getItemName() + " $" + getItem.getItemCost());

                            if (serviceLayer.inventoryAvailibility(Cash, getItem) == true && serviceLayer.checkIfMoneyEnough(Cash, getItem) == true) {
                                Cash = serviceLayer.completePurchase(Cash, getItem);

                                DISPLAYCHANGEAMOUNTandCurrentAMOUNT(Cash);
                            } else {
                                break;
                            }
                        }   //[ DISPLAY ITEM CODE END ]

                        /*============================================================================================================================
        Catching the Exceptions
============================================================================================================================*/
                    } catch (Exception e) {

                        DisplayErrorEXCEPTION("Invalid Input");

                    } //END OF EXCEPTION

                } //============ END OF WHILE LOOP

            } catch (Exception e) {

                DisplayErrorEXCEPTION("ERROR");
            } // END OF EXCEPTION
        }//end of boolean run prompt
    } // END OF RUN METHOD

    /*============================================================================================================================
        PRIVATE METHODS
============================================================================================================================*/
    private void getMenu() throws PersistanceException {
        view.menu(serviceLayer.ItemList());
    }

    private void WelcomeBanner() {
        view.WelcomeBanner();
    }

    private void EXITBUTTON() {
        view.EXITBUTTON();
    }

    private BigDecimal InputCash() {
        return view.InsertCash();
    }

    private String InputCode() {
        return view.InsertInventoryCode();
    }

    private Item getItem(String itemCode) throws PersistanceException {
        return serviceLayer.getItem(itemCode);
    }

    private void displayItemIntoIO(String msg) {
        view.DisplayProductName(msg);
    }

    private void DisplayErrorEXCEPTION(String msg) {
        view.DisplayErrorEXCEPTION(msg);
    }

    private void DISPLAYCHANGEAMOUNTandCurrentAMOUNT(BigDecimal Cash) {
        view.DISPLAYCHANGEAMOUNTandCurrentAMOUNT(Cash);
    }

//    private void DisplayCurrentMoney(String msg) {
//        view.DISPLAYCURRENTMONEY(msg);
//    }
}

//Source: https://github.com/KennethMelendez
//Kenneth Melendez

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinerefactor.servicelayer;

/**
 *
 * @author kmlnd
 */
public class InventoryAvailibilityException extends Exception{

    public InventoryAvailibilityException(String message) {
        super(message);
    }

    public InventoryAvailibilityException(String message, Throwable cause) {
        super(message, cause);
    }
    
}

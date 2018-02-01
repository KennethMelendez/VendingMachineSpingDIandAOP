/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinerefactor.servicelayer;

import com.sg.vendingmachinerefactor.dao.AuditDao;
import com.sg.vendingmachinerefactor.dao.PersistanceException;
import com.sg.vendingmachinerefactor.dao.VendingMachineDao;
import com.sg.vendingmachinerefactor.dao.VendingMachineDaoImpl;
import com.sg.vendingmachinerefactor.dto.Change;
import com.sg.vendingmachinerefactor.dto.Item;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kmlnd
 */
public class ServiceLayerImpl implements ServiceLayer {

    VendingMachineDao dao;
    AuditDao auditDao;

    public ServiceLayerImpl(VendingMachineDao dao,AuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }

    @Override
    public Item getItem(String ItemID) throws PersistanceException {
        return dao.getItem(ItemID);
    }

    @Override
    public List<Item> ItemList() throws PersistanceException {
        return dao.ItemList();
    }

    @Override
    public boolean inventoryAvailibility(BigDecimal userMoney, Item selectedItem) throws InventoryAvailibilityException {
        try {
            if (selectedItem.getItemInventory() == 0) {
                throw new InventoryAvailibilityException("Sorry, The item you have chosen is Out of Stock.\nHere is your refund $" + userMoney);
            } else {
                return true;
            }
            //below is preventing the program from breaking
        } catch (InventoryAvailibilityException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean checkIfMoneyEnough(BigDecimal userMoney, Item selectedItem) throws InsufficientFundsException {
        try {
            if (selectedItem.getItemCost().compareTo(userMoney) > 0) {
                throw new InsufficientFundsException("Insufficient Funds, Thank You and have a nice day.");
            } else {
                return true;
            }
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public BigDecimal completePurchase(BigDecimal userMoney, Item selectedItem)throws InventoryAvailibilityException {
        /*
        call the change method and reduce the inventory count
         */

        Change change = new Change();
        BigDecimal result = change.cashier(userMoney, selectedItem);

        int invo = selectedItem.getItemInventory();
        invo--;
        selectedItem.setItemInventory(invo);
        try {
            
            //auditdao
            //auditDao.writeAuditEntry("Purchased " + selectedItem.getItemName() + " " + selectedItem.getItemCost());
            dao.SaveState();
        } catch (PersistanceException ex) {
            throw new InventoryAvailibilityException("Save Sate Currupted", ex);
            //System.out.println("Save State Corrupted");
        }
        return result;

    }

}

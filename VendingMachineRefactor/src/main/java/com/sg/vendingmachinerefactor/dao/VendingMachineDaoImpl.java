/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinerefactor.dao;

import com.sg.vendingmachinerefactor.dto.Item;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author kmlnd
 */
public class VendingMachineDaoImpl implements VendingMachineDao {

//        keys|Values
    Map<String, Item> Inventory = new HashMap<>();

    public static final String INVENTORY_FILE = "inventory.txt";
    public static final String DELIMITER = "::";

    @Override
    public Item getItem(String ItemID) throws PersistanceException {
        loadInventory();
        Item currentItem = Inventory.get(ItemID);

//        /*=====================================================================        
//                INVENTORY COUNT
//======================================================================*/
//        int invo = currentItem.getItemInventory();
//        invo--;
//        currentItem.setItemInventory(invo);
//
//        /*=====================================================================        
//                INVENTORY COUNT END
//======================================================================*/
        writeInventory();
        return currentItem;
    }

    @Override
    public List<Item> ItemList() throws PersistanceException {
        loadInventory();
        List currentItem = new ArrayList<>(Inventory.values());
        
        return currentItem;
    }

    private void loadInventory() throws PersistanceException {
        //clear the list
        Scanner scanner;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(INVENTORY_FILE)));
        } catch (FileNotFoundException e) {
            throw new PersistanceException("Could not load into memory", e);
        }

        String currentLine;
        String[] currentTokens;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);

            Item currentItem = new Item(currentTokens[0]);
            currentItem.setItemName(currentTokens[1]);
            currentItem.setItemInventory(parseInt(currentTokens[2]));
            currentItem.setItemCost(new BigDecimal(currentTokens[3]));

            Inventory.put(currentItem.getItemID(), currentItem);

        }
        //close Scanner
        scanner.close();

    }
   
    private void writeInventory() throws PersistanceException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(INVENTORY_FILE));
        } catch (IOException e) {
            throw new PersistanceException(
                    "Could not save inventory data.", e);
        }

        List<Item> ItemList = this.ItemList();
        for (Item currentItem : ItemList) {
            //write objects to the file
            out.println(
                    currentItem.getItemID() + DELIMITER
                    + currentItem.getItemName() + DELIMITER
                    + currentItem.getItemInventory() + DELIMITER
                    + currentItem.getItemCost().toString()
            );
            //force printwriter to line to the file
            out.flush();
        }
        //cleanup
        out.close();
    }

    /**
     *
     * @throws PersistanceException
     */
    @Override
    public void SaveState() throws PersistanceException {
      writeInventory();
    }

  

}

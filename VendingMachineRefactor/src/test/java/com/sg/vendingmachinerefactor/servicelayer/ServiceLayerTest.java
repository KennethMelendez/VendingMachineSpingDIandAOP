/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinerefactor.servicelayer;

import com.sg.vendingmachinerefactor.dao.PersistanceException;
import com.sg.vendingmachinerefactor.dao.VendingMachineDao;
import com.sg.vendingmachinerefactor.dao.VendingMachineDaoImpl;
import com.sg.vendingmachinerefactor.dto.Item;
import java.math.BigDecimal;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author kmlnd
 */
public class ServiceLayerTest {
//    VendingMachineDao dao = new VendingMachineDaoImpl();
//    ServiceLayer sl = new ServiceLayerImpl(dao);
//    
    
     ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    //VendingMachineDao VendingMachineDao = ctx.getBean("VendingMachineDao",VendingMachineDao.class);
    ServiceLayer ServiceLayer = ctx.getBean("ServiceLayer",ServiceLayer.class);
    
       
    public ServiceLayerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getItem method, of class ServiceLayer.
     */
    @Test
    public void testGetItem() throws Exception {
    }

    /**
     * Test of ItemList method, of class ServiceLayer.
     */
    @Test
    public void testItemList() throws Exception {
    }

    /**
     * Test of inventoryAvailibility method, of class ServiceLayer.
     */
    @Test
    public void testInventoryAvailibility() throws Exception {
        Item Pepsi = new Item("01");
        Pepsi.setItemName("Pepsi");
        Pepsi.setItemCost(new BigDecimal("1.00"));
        Pepsi.setItemInventory(10);
        
        assertEquals(Pepsi.getItemInventory(),10);
    }

    /**
     * Test of checkIfMoneyEnough method, of class ServiceLayer.
     */
    @Test
    public void testCheckIfMoneyEnough() throws Exception {
        BigDecimal userAmount = new BigDecimal("5.00");
        
        Item newItem = new Item("01");
        newItem.setItemName("Pepsi");
        newItem.setItemCost(new BigDecimal("1.00"));
        newItem.setItemInventory(10);
        
        ServiceLayer.checkIfMoneyEnough(userAmount, newItem);
        assertTrue(ServiceLayer.checkIfMoneyEnough(userAmount, newItem));
    }

    /**
     * Test of completePurchase method, of class ServiceLayer.
     */
    @Test
    public void testCompletePurchase() throws Exception {
    }

//    public class ServiceLayerImpl implements ServiceLayer {
//
//        public Item getItem(String ItemID) throws PersistanceException {
//            return null;
//        }
//
//        public List<Item> ItemList() throws PersistanceException {
//            return null;
//        }
//
//        public boolean inventoryAvailibility(BigDecimal userMoney, Item selectedItem) throws InventoryAvailibilityException {
//            return false;
//        }
//
//        public boolean checkIfMoneyEnough(BigDecimal userMoney, Item selectedItem) throws InsufficientFundsException {
//            return false;
//        }
//
//        public BigDecimal completePurchase(BigDecimal userMoney, Item selectedItem) throws InventoryAvailibilityException {
//            return null;
//        }
//    }
    
}

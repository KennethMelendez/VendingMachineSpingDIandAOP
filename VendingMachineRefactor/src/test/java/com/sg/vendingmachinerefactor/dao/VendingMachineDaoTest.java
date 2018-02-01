/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinerefactor.dao;

import com.sg.vendingmachinerefactor.controller.VendingMachineController;
import com.sg.vendingmachinerefactor.dto.Item;
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
public class VendingMachineDaoTest {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    VendingMachineDao VendingMachineDao = ctx.getBean("VendingMachineDao",VendingMachineDao.class);
//    VendingMachineDao dao = new VendingMachineDaoImpl();
    
    public VendingMachineDaoTest() {
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
     * Test of getItem method, of class VendingMachineDao.
     */
    @Test
    public void testGetItem() throws Exception {
        //Item item = VendingMachineDao.getItem("A1");
        assertEquals(VendingMachineDao.getItem("A1"),VendingMachineDao.getItem("A1"));
    }

    /**
     * Test of ItemList method, of class VendingMachineDao.
     */
    @Test
    public void testItemList() throws PersistanceException {
        VendingMachineDao.ItemList();
        assertEquals(8,VendingMachineDao.ItemList().size());
//        dao.ItemList();
//        assertEquals(8,dao.ItemList().size());
    }

//    public class VendingMachineDaoImpl implements VendingMachineDao {
//
//        public Item getItem(String ItemID) throws PersistanceException {
//            return null;
//        }
//
//        public List<Item> ItemList() throws PersistanceException {
//            return null;
//        }
//    }
    
}

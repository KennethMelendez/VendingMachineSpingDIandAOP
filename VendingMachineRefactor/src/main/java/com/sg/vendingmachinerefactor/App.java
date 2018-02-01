/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinerefactor;

import com.sg.vendingmachinerefactor.controller.VendingMachineController;
import com.sg.vendingmachinerefactor.dao.VendingMachineDao;
import com.sg.vendingmachinerefactor.dao.VendingMachineDaoImpl;
import com.sg.vendingmachinerefactor.dto.Change;
import com.sg.vendingmachinerefactor.dto.Item;
import com.sg.vendingmachinerefactor.servicelayer.ServiceLayer;
import com.sg.vendingmachinerefactor.servicelayer.ServiceLayerImpl;
import com.sg.vendingmachinerefactor.ui.UserIO;
import com.sg.vendingmachinerefactor.ui.UserIOImpl;
import com.sg.vendingmachinerefactor.ui.View;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author kmlnd
 */
public class App {
    public static void main(String[] args) {
//    UserIO io = new UserIOImpl(); 
//    View view = new View(io);
//    VendingMachineDao dao = new VendingMachineDaoImpl();
//    ServiceLayer serviceLayer = new ServiceLayerImpl(dao);
//    Change change = new Change();
//    VendingMachineController controller = new VendingMachineController(view,serviceLayer,change);
//    controller.run();    
//       
//
    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    VendingMachineController controller = ctx.getBean("VendingMachineController",VendingMachineController.class);
    controller.run();
    }
}

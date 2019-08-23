/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Customer;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author jojus1101
 */
public class FacadeRunner {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        CustomerFacade facade = CustomerFacade.getCustomerFacade(emf);
        Customer c1 = facade.addCustomer("Søren", "Hansen");
        Customer c2 = facade.addCustomer("Flemming", "Hansen");
        Customer c3 = facade.addCustomer("Benny", "Hansen");
        List<Customer> customers = facade.getAllCustomers();
        for (Customer c : customers) {
            System.out.println(facade.getAllCustomers().toString());
        }
        

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author jojus1101
 */
public class EntityRunner {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

        EntityManager em = emf.createEntityManager();
        Customer c1 = new Customer("Niels", "Larsen");
        System.out.println("Customer1: " + c1.toString());
        
        Customer c2 = new Customer("Lars","Jensen");
        Customer c3 = new Customer("Leon","Jensen");
        try {
            em.getTransaction().begin();
            em.persist(c1);
            em.persist(c2);
            em.persist(c3);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        System.out.println("Customer: "+ c1.toString());
    
    }
}

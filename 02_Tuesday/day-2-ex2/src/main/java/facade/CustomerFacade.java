/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Customer;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author jojus1101
 */
public class CustomerFacade {
    private static EntityManagerFactory emf;
    private static CustomerFacade instance;

    private CustomerFacade() {}

    public static CustomerFacade getCustomerFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CustomerFacade();
        }
        return instance;
    }
    
    public Customer addCustomer(String firstname,String lastname){
        Customer customer = new Customer(firstname, lastname);
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(customer);
            em.getTransaction().commit();
            return customer;
        }finally {
            em.close();
        }
    }
    
    public List<Customer> findCustomerByLastname(String lastname){
    EntityManager em = emf.createEntityManager();
        try{
            TypedQuery<Customer> query = em.createQuery("SELECT c FROM Customer c WHERE c.lastname = :lastname",Customer.class)
                    .setParameter("lastname", lastname);
            return query.getResultList();
        }finally {
            em.close();
        }
       
    }
public Customer findById(int id){
         EntityManager em = emf.createEntityManager();
        try{
            Customer customer = em.find(Customer.class,id);
            return customer;
        }finally {
            em.close();
        }
    }

    public List<Customer> getAllCustomers(){
         EntityManager em = emf.createEntityManager();
        try{
            TypedQuery<Customer> query = 
                       em.createQuery("SELECT c from Customer c",Customer.class);
            return query.getResultList();
        }finally {
            em.close();
        }
    }

}

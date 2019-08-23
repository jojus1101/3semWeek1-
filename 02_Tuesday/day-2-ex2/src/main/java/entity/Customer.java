/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import static javax.persistence.TemporalType.DATE;

/**
 *
 * @author jojus1101
 */
@Entity
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String firstname;
    private String lastname;
    @Temporal(DATE)
     protected java.util.Date created;

    public Customer(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.created = new Date();
    }

    public Customer() {
    }
    

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getCreated() {
        return created;
    }

    @Override
    public String toString() {
        return "Customer{" + "firstname=" + firstname + ", lastname=" + lastname + ", created=" + created + '}';
    }
    
    
    
}

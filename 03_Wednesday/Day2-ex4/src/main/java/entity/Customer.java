/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author jojus1101
 */
public class Customer {
    private int id;
    private String name;
    private String adress;

    public Customer(int id, String name, String adress) {
        this.id = id;
        this.name = name;
        this.adress = adress;
    }

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name=" + name + ", adress=" + adress + '}';
    }
    
}

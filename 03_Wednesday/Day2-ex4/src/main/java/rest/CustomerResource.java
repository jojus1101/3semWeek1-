/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Customer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author jojus1101
 */
@Path("generic")
public class CustomerResource {

    @Context
    private UriInfo context;
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    /**
     * Creates a new instance of CustomerResource
     */
    public CustomerResource() {
    }

    /**
     * Retrieves representation of an instance of rest.CustomerResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    @GET
    @Path("/random")
    @Produces(MediaType.APPLICATION_JSON)

    public String getRandomCustomer() {
        List<Customer> list = new ArrayList();
        Customer customer1 = new Customer(12, "simon", "hejvej2");
        Customer customer2 = new Customer(42, "jens", "hejvej24");
        Customer customer3 = new Customer(32, "morten", "hejvej21");
        Customer customer4 = new Customer(22, "mikkel", "hejvej4");
        list.add(customer1);
        list.add(customer2);
        list.add(customer3);
        list.add(customer4);
        Random rand = new Random();
        Customer randomCustomer = list.get(rand.nextInt(list.size()));
        return gson.toJson(randomCustomer);

    }
    
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllCustomer(){
        
        List<Customer> list = new ArrayList();
        Customer customer1 = new Customer(12, "simon", "hejvej2");
        Customer customer2 = new Customer(42, "jens", "hejvej24");
        Customer customer3 = new Customer(32, "morten", "hejvej21");
        Customer customer4 = new Customer(22, "mikkel", "hejvej4");
        list.add(customer1);
        list.add(customer2);
        list.add(customer3);
        list.add(customer4);
        return gson.toJson(list);
    }
//    @GET
//    @Path("/{id}")
//    @Consumes({MediaType.APPLICATION_JSON})
//    public String EmployeeById(Customer entity, @PathParam("id") int id) {
//        Customer emp = facade.getCustomerById(id);
//        return gson.toJson(emp);
//    }

    /**
     * PUT method for updating or creating an instance of CustomerResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}

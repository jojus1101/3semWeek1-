/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Animal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author jojus1101
 */
@Path("animal")
public class AnimalResource {

    @Context
    private UriInfo context;
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    /**
     * Creates a new instance of AnimalResource
     */
    public AnimalResource() {
    }

    /**
     * Retrieves representation of an instance of rest2.AnimalResource
     *
     * @return an instance of java.lang.String
     */
    @GET
//    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        return "Hello my first web service";
    }

    @GET
    @Path("/random")
    @Produces(MediaType.APPLICATION_JSON)

    public String getEndpoint() {
        List<Animal> list = new ArrayList();
        Animal animal1 = new Animal("Giraf", 2008, "muh'en");
        Animal animal2 = new Animal("Slange", 1990, "sssssss");
        Animal animal3 = new Animal("Fisk", 2018, "blop blop");
        Animal animal4 = new Animal("Hund", 2010, "vuf");
        list.add(animal1);
        list.add(animal2);
        list.add(animal3);
        list.add(animal4);
        Random rand = new Random();
        Animal randomAnimal = list.get(rand.nextInt(list.size()));
        return gson.toJson(randomAnimal);

    }

    /**
     * PUT method for updating or creating an instance of AnimalResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}

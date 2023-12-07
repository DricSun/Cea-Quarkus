package org.acme;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/test")
public class GreetingResource {

    @Inject
    GreetingService greetingService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {

        return "Découverte de Quarkus";
    }

    @GET
    @Path("/home")
    @Produces(MediaType.TEXT_PLAIN)
    public String cea(){
        return "Bienvenue sur la home du cea Quarkus";
    }

    @GET
    @Path("/greeting/{name}")
    public String greeting (String name){
        return greetingService.getGretting(name);
    }
}

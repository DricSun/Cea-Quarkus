package org.acme;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService {


    public String getGretting(String name) {
        return  " hello" +  name;
    }
}

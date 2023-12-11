package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.PathParam;
import org.acme.entity.Arme;
import org.acme.repository.ArmeRepository;

import java.util.List;
@ApplicationScoped
public class ArmeService{


    @Inject
    ArmeRepository armeRepository;

    public Arme getArmeById(@PathParam("id")Long id){

        return armeRepository.findById(id);
    }

    public Arme createArme(Arme arme) {
        Arme createdArme = new Arme();
        System.out.println("test ******");
        createdArme.setName(arme.getName());
        createdArme.setDescription(arme.getDescription());

        armeRepository.persist(createdArme);

        return createdArme;
    }

    public List<Arme> getArmes(){

        return armeRepository.listAll();
    }

    public void deleteArme(@PathParam("id")Long id){

        armeRepository.deleteById(id);
    }

    public Arme updateArme(Long id, Arme updateArme) {
        Arme existingArme = armeRepository.findById(id);

        if (existingArme != null) {
            existingArme.setName(updateArme.getName());
            existingArme.setDescription(updateArme.getDescription());

            armeRepository.persist(existingArme);
        } else {
            return null;
        }
        return existingArme;
    }

}

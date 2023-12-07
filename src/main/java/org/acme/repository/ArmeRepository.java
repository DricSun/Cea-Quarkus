package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entity.Arme;



@ApplicationScoped
public class ArmeRepository implements PanacheRepository<Arme> {



}

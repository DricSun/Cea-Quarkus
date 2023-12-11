package org.acme.controller;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.entity.Arme;
import org.acme.repository.ArmeRepository;
import org.acme.service.ArmeService;


import java.util.List;


@Path("/cea")
public class ArmeControlleur {

    @Inject
    ArmeService armeService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/armes")
    public Response getAllArmes() {
        List<Arme> armes = armeService.getArmes();
        return Response.ok().entity(armes).build();
    }

    @GET
    @Path("/armes/{id}")
    public Response getArmeById(@PathParam("id")Long id){
        Arme arme = armeService.getArmeById(id);
        if (arme != null) {
            return Response.ok().entity(arme).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Arme introuvable").build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response createArme(Arme arme) {
        try{
            Arme createdArme = armeService.createArme(arme);
            return Response.ok().entity(createdArme).header("Content-Type" ,  "application/json; charset=utf-8").build();
        }catch (Exception e){
            System.out.println("une erreur s 'est produite" + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @DELETE
    @Transactional
    @Path("/{armeId}")
    public Response deleteArme(@PathParam("armeId") Long armeId){
        Arme deletedArme = armeService.getArmeById(armeId); // Récupérer l'arme à supprimer
        if (deletedArme == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Arme non trouvée").build();
        }

        armeService.deleteArme(armeId); // Supprimer l'arme

        return Response.ok().entity("Arme supprimée avec succès").build();
    }

    @PUT
    @Path("/{id}")
    public Response updateArme(@PathParam("id") Long id, Arme arme) {
        Arme updatedArme = armeService.updateArme(id, arme);

        if (updatedArme != null) {
            return Response.ok().entity(updatedArme).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Arme introuvable").build();
        }
    }

}

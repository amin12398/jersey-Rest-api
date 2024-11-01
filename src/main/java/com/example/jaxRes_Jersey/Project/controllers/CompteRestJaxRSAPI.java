package com.example.jaxRes_Jersey.Project.controllers;

import com.example.jaxRes_Jersey.Project.entity.Compte;
import com.example.jaxRes_Jersey.Project.repository.CompteRepository;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Path("/banque")
public class CompteRestJaxRSAPI {

    @Autowired
    private CompteRepository compteRepository;

    // Récupérer tous les comptes
    @Path("/comptes")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Compte> getComptes() {
        return compteRepository.findAll();
    }

    // Récupérer un compte par son identifiant
    @Path("/comptes/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Compte getCompte(@PathParam("id") Long id) {
        return compteRepository.findById(id).orElse(null);
    }

    // Ajouter un compte
    @Path("/comptes")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Compte addCompte(Compte compte) {
        return compteRepository.save(compte);
    }

    // Mettre à jour un compte existant
    @Path("/comptes/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Compte updateCompte(@PathParam("id") Long id, Compte compte) {
        Compte compteExist = compteRepository.findById(id).orElse(null);

        if (compteExist != null) {
            compteExist.setSolde(compte.getSolde());
            compteExist.setDateCreation(compte.getDateCreation());
            compteExist.setTypeCompte(compte.getTypeCompte());

            return compteRepository.save(compteExist);
        }

        return null;
    }

    // Supprimer un compte
    @Path("/comptes/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteCompte(@PathParam("id") Long id) {
        compteRepository.deleteById(id);
    }
}

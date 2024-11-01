package com.example.jaxRes_Jersey.Project.controllers;

import com.example.jaxRes_Jersey.Project.entity.Compte;

import com.example.jaxRes_Jersey.Project.repository.CompteRepository;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import jakarta.ws.rs.*;


import java.util.List;

@Path("/banque")
@Component
public class CompteRestJaxRSAPI {

    @Autowired
    private CompteRepository compteRepository;

    // Retrieve all accounts
    @Path("/comptes")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Compte> getComptes() {
        return compteRepository.findAll();
    }

    // Retrieve an account by ID
    @Path("/comptes/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Compte getCompte(@PathParam("id") Long id) {
        return compteRepository.findById(id).orElse(null);
    }

    // Add an account
    @Path("/comptes")
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Compte addCompte(Compte compte) {
        return compteRepository.save(compte);
    }

    // Update an existing account
    @Path("/comptes/{id}")
    @PUT
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
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

    // Delete an account
    @Path("/comptes/{id}")
    @DELETE
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void deleteCompte(@PathParam("id") Long id) {
        compteRepository.deleteById(id);
    }
}
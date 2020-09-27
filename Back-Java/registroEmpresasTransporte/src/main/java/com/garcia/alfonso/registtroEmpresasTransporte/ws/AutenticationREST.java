/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.garcia.alfonso.registtroEmpresasTransporte.ws;

import com.garcia.alfonso.registtroEmpresasTransporte.negocio.AutenticationFacade;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Alfonso_Garcia_Q
 */
@Path("/Autentication")
public class AutenticationREST {
    
    @Inject
    AutenticationFacade facade;
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response autentication (@QueryParam("user")String user, @QueryParam("password") String password){
        try {
            return Response.ok().entity(this.facade.userAutentication(user, password)).build();            
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Ocurrio un error al intentar realizar la autenticacion").build();
        }
    }
    
    
    
}

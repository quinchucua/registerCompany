/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.garcia.alfonso.registtroEmpresasTransporte.ws;

import com.garcia.alfonso.registtroEmpresasTransporte.negocio.CompanyFacade;
import com.garcia.alfonso.registtroEmpresasTransporte.vo.Company;
import java.io.InputStream;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

/**
 *
 * @author Alfonso_Garcia_Q
 */
@Path("company")
public class RegistroEmpresasREST {
    
    @Inject
    CompanyFacade facade;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/create")
    public Response createCompany (Company company) {
        try {
            return Response.ok().entity(this.facade.createCompany(company)).build();            
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Ocurrio un error al intentar crear la empresa").build();
        }
    }
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/findCompanies")
    public Response findCompanies(){
        try {
            return Response.ok().entity(this.facade.findCompanies()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error al consultar las empresas").build();
        }
    }
    
    @POST
    @Path("/uploadFile")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile(@FormDataParam("file") InputStream uploadFile,
            @FormDataParam("file") FormDataContentDisposition fileDetails){
        try {
            return Response.ok().entity(this.facade.uploadFile(uploadFile, fileDetails)).build();            
        } catch (Exception e) {
        }   return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error al guardar el archivo").build();
    }
    
    
}

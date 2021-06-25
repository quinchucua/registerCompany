/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.garcia.alfonso.registtroEmpresasTransporte.negocio;

import com.garcia.alfonso.registtroEmpresasTransporte.data.CompanyDAO;
import com.garcia.alfonso.registtroEmpresasTransporte.data.DataCache;
import com.garcia.alfonso.registtroEmpresasTransporte.vo.Company;
import com.garcia.alfonso.registtroEmpresasTransporte.vo.ResponseMessage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import javax.inject.Inject;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

/**
 *
 * @author Alfonso_Garcia_Q
 */
public class CompanyFacade {
    
    @Inject 
    CompanyDAO dao;
    
    @Inject
    DataCache cache;
    
    public ResponseMessage createCompany(Company company){
        this.cache.saveCompany(company);
        return dao.createCompany(company);
    }
    
    public List<Company> findCompanies () {        
        return this.cache.findCompanies();
    }
    
    public boolean uploadFile(InputStream file, FormDataContentDisposition detailsFile) {
        String fileLocation = "d://upload/" + detailsFile.getFileName();
        try {
            OutputStream out = new FileOutputStream(new File(fileLocation));
            int read = 0;
            byte[] bytes = new byte[1024];
            while((read = file.read(bytes)) != -1){
                out.write(bytes,0, read);
            } 
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    
}

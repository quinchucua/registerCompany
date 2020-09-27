/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.garcia.alfonso.registtroEmpresasTransporte.negocio;

import com.garcia.alfonso.registtroEmpresasTransporte.data.CompanyDAO;
import com.garcia.alfonso.registtroEmpresasTransporte.data.DataCache;
import com.garcia.alfonso.registtroEmpresasTransporte.vo.Company;
import com.garcia.alfonso.registtroEmpresasTransporte.vo.responseMessage;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Alfonso_Garcia_Q
 */
public class CompanyFacade {
    
    @Inject 
    CompanyDAO dao;
    
    @Inject
    DataCache cache;
    
    public responseMessage createCompany(Company company){
        this.cache.saveCompany(company);
        return dao.createCompany(company);
    }
    
    public List<Company> findCompanies () {        
        return this.cache.findCompanies();
    }
    
}

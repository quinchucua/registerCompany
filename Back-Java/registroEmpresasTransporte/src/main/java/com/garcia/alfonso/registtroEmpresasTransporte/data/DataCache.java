/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.garcia.alfonso.registtroEmpresasTransporte.data;

import com.garcia.alfonso.registtroEmpresasTransporte.vo.Company;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 *
 * @author Alfonso_Garcia_Q
 */
@Singleton
public class DataCache {
    
    private List<Company> memory = new ArrayList<>();
    
    @Inject
    CompanyDAO companies;
    
    @PostConstruct
    private void populateMemory(){
        memory = createMemory();
    }
        
    private List<Company> createMemory(){
        List<Company> data = null;
        return data = companies.findCompanies();
    }
    
    @Lock(LockType.READ)
    public List<Company> findCompanies(){
        return memory;
    }
    
    public void saveCompany( Company company){
        this.memory.add(company);
    }
    
}

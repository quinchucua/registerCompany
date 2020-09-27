/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.garcia.alfonso.registtroEmpresasTransporte.data;
import com.garcia.alfonso.registtroEmpresasTransporte.vo.Company;
import com.garcia.alfonso.registtroEmpresasTransporte.vo.TypeCompany;
import com.garcia.alfonso.registtroEmpresasTransporte.vo.responseMessage;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Alfonso_Garcia_Q
 */
public class CompanyDAO {
    
        
    List<Company> companies = new ArrayList<>(); 
    
    public responseMessage createCompany( Company company){
        responseMessage response = new responseMessage();
        this.companies.add(company);        
        response.setMessage("OK");
        return response;
    }
    
    public List<Company> findCompanies(){
        return this.companies;
    }
    
}

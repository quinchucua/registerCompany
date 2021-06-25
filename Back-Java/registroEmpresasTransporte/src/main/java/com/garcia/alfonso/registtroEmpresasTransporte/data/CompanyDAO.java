/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.garcia.alfonso.registtroEmpresasTransporte.data;
import com.garcia.alfonso.registtroEmpresasTransporte.vo.Company;
import com.garcia.alfonso.registtroEmpresasTransporte.vo.TypeCompany;
import com.garcia.alfonso.registtroEmpresasTransporte.vo.ResponseMessage;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Alfonso_Garcia_Q
 */
public class CompanyDAO {
    
        
    List<Company> companies = new ArrayList<>(); 
    
    public ResponseMessage createCompany( Company company){
        ResponseMessage response = new ResponseMessage();
        this.companies.add(company);        
        response.setMessage("OK");
        return response;
    }
    
    public List<Company> findCompanies(){
        return this.companies;
    }
    
}

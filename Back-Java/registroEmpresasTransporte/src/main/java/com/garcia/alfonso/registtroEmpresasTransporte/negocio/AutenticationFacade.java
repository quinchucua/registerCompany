/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.garcia.alfonso.registtroEmpresasTransporte.negocio;

import com.garcia.alfonso.registtroEmpresasTransporte.data.AutenticationDAO;
import com.garcia.alfonso.registtroEmpresasTransporte.vo.ResponseMessage;
import javax.inject.Inject;

/**
 *
 * @author Alfonso_Garcia_Q
 */
public class AutenticationFacade {
    
    @Inject
    AutenticationDAO dao;
    
    public ResponseMessage userAutentication(String user, String password){
        return dao.userAutentition(user, password);
    }
    
    
}

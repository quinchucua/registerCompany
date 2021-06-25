/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.garcia.alfonso.registtroEmpresasTransporte.data;

import com.garcia.alfonso.registtroEmpresasTransporte.vo.ResponseMessage;

/**
 *
 * @author Alfonso_Garcia_Q
 */
public class AutenticationDAO {
    
    private final String USER = "prueba";
    private final String PASSWORD = "123456";
    
    public ResponseMessage userAutentition ( String user, String password) {
        ResponseMessage response = new ResponseMessage();
        if ( user.equalsIgnoreCase(USER) && password.equalsIgnoreCase(PASSWORD)){
            response.setMessage("confirmado");
        } else {
            response.setMessage("denegado");
        }
        return response;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.garcia.alfonso.registtroEmpresasTransporte.data;

import com.garcia.alfonso.registtroEmpresasTransporte.vo.responseMessage;

/**
 *
 * @author Alfonso_Garcia_Q
 */
public class AutenticationDAO {
    
    private final String USER = "prueba";
    private final String PASSWORD = "123456";
    
    public responseMessage userAutentition ( String user, String password) {
        responseMessage response = new responseMessage();
        if ( user.equalsIgnoreCase(USER) && password.equalsIgnoreCase(PASSWORD)){
            response.setMessage("confirmado");
        } else {
            response.setMessage("denegado");
        }
        return response;
    }
    
}

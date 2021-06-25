/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.garcia.alfonso.registtroEmpresasTransporte.data;

import com.garcia.alfonso.registtroEmpresasTransporte.vo.ResponseMessage;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alfonso_Garcia_Q
 */
public class AutenticationDAOTest {
    
    
    @Test
    public void testUserAutentition() {
        String user = "";
        String password = "";
        AutenticationDAO instance = new AutenticationDAO();
        String expResult = "denegado";
        ResponseMessage result = instance.userAutentition(user, password);
        assertEquals(expResult, result.getMessage());
    }
    
    @Test
    public void testUserAutentition2() {
        String user = "prueba";
        String password = "123456";
        AutenticationDAO instance = new AutenticationDAO();
        String expResult = "confirmado";
        ResponseMessage result = instance.userAutentition(user, password);
        assertEquals(expResult, result.getMessage());
    }
    
}

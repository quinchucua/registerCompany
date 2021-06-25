/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.garcia.alfonso.registtroEmpresasTransporte.ws;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.Filter;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
public class CORSFilter implements Filter {

    private static final String SOURCE_IP_1 = "http://localhost:4200";

    /**
     * Default constructor.
     */
    public CORSFilter() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Filter#destroy()
     */
    @Override
    public void destroy() {
        // TODO Auto-generated method stub
    }

    /**
     * @param servletRequest
     * @param servletResponse
     * @param chain
     * @throws java.io.IOException
     * @throws javax.servlet.ServletException
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        // Authorize (allow) all domains to consume the content

        String origin = request.getHeader("origin");
        String Origin = request.getHeader("Origin");
        String permitido = null;

        if (SOURCE_IP_1.equals(origin) || SOURCE_IP_1.equals(Origin)) {
            permitido = SOURCE_IP_1;
        }

        if (permitido != null) {
            ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Origin", permitido);
        }

        ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Methods", "GET, OPTIONS, HEAD, PUT, POST, DELETE, HEAD");
        ((HttpServletResponse) servletResponse).addHeader("Access-Control-Allow-Headers", "Content-Type, Authorization, Accept, enctype");

        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        // For HTTP OPTIONS verb/method reply with ACCEPTED status code -- per CORS handshake
        if ("OPTIONS".equals(request.getMethod())) {
            resp.setStatus(HttpServletResponse.SC_ACCEPTED);
            return;
        }

        // pass the request along the filter chain
        chain.doFilter(request, servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

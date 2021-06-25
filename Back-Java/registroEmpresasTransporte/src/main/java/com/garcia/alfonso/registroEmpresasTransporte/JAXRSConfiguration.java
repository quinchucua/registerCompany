package com.garcia.alfonso.registroEmpresasTransporte;

import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Configures JAX-RS for the application.
 * @author Juneau
 */
@ApplicationPath("resources")
public class JAXRSConfiguration extends Application {
    @Override
    public Map<String, Object> getProperties() {

        Map<String, Object> properties = new HashMap<>();

        properties.put("jersey.config.server.provider.packages", "com.garcia.alfonso.registtroEmpresasTransporte.ws");
        properties.put("jersey.config.server.provider.classnames",
                "org.glassfish.jersey.filter.LoggingFilter;org.glassfish.jersey.media.multipart.MultiPartFeature");

        return properties;
    }
    
}

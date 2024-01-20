package hu.webuni.spring.centralsystem.config;

import hu.webuni.spring.centralsystem.xmlws.CentralsystemXmlWs;
import jakarta.xml.ws.Endpoint;
import lombok.RequiredArgsConstructor;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.jaxws.context.WebServiceContextImpl;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class WebServiceConfig {



    // Define the username and password
    private final Bus bus;
    private final CentralsystemXmlWs centralsystemXmlWs;

    // Define the username and password
    private final String username = "akos";
    private final String password = "akos";

    @Bean
    public EndpointImpl endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, centralsystemXmlWs);

        // Remove the WS-Security interceptor for basic authentication
        endpoint.getInInterceptors().removeIf(interceptor -> interceptor instanceof org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor);

        endpoint.publish("/centralsystem");
        return endpoint;
    }
}

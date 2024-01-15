package hu.webuni.spring.centralsystem.config;

import hu.webuni.spring.centralsystem.xmlws.CentralsystemXmlWs;
import jakarta.xml.ws.Endpoint;
import lombok.RequiredArgsConstructor;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class WebServiceConfig {

    private final Bus bus;
    private final CentralsystemXmlWs centralsystemXmlWs;
    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, centralsystemXmlWs);
        endpoint.publish("/centralsystem"); //relative to cxf's default url "/services".. localhost:8080/services/centralsystem?wsdl
        return endpoint;
    }

}

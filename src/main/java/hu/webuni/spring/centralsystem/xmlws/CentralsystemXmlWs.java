package hu.webuni.spring.centralsystem.xmlws;

import jakarta.jws.WebService;
import org.springframework.web.bind.annotation.PathVariable;

@WebService
public interface CentralsystemXmlWs {

    public int getFreeSemesterByCentralId(@PathVariable long centralId);


}

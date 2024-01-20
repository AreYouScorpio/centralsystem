package hu.webuni.spring.centralsystem.xmlws;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import org.springframework.web.bind.annotation.PathVariable;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface CentralsystemXmlWs {

    public int getFreeSemesterByCentralId(@PathVariable long centralId);


}

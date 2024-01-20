package hu.webuni.spring.centralsystem.xmlws;

import jakarta.annotation.Resource;
import jakarta.jws.WebService;
import jakarta.xml.ws.WebServiceContext;
import jakarta.xml.ws.handler.MessageContext;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class CentralsystemXmlWsImpl implements CentralsystemXmlWs{


    @Resource
    WebServiceContext webServiceContext;
    @Override
    public int getFreeSemesterByCentralId(long centralId) {
        Random random = new Random();

        System.out.println("getFreeSemesterByCentralId within CentralSystem called");


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        int result = random.nextInt(0, 11);



        return result;
    }


    }


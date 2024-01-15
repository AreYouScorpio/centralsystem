package hu.webuni.spring.centralsystem.xmlws;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class CentralsystemXmlWsImpl implements CentralsystemXmlWs{

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

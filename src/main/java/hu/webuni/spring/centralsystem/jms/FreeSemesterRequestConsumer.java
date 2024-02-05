package hu.webuni.spring.centralsystem.jms;

import hu.webuni.jms.dto.FreeSemesterRequest;
import hu.webuni.jms.dto.FreeSemesterResponse;
import hu.webuni.spring.centralsystem.xmlws.CentralsystemXmlWs;
import jakarta.jms.Topic;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.JmsHeaders;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FreeSemesterRequestConsumer {

    private final JmsTemplate jmsTemplate; // ezzel kuldom majd a valaszt, injektalni kell
    private final CentralsystemXmlWs centralsystemXmlWs; // a random generalas, sima Service osztaly, siman injektalhato

    //ez egy fogadas es kuldes metodus:
    @JmsListener(destination = "free_semester_requests") // bejovo request fogadasa, erre figyel (ez queue lesz, nem topic), ez a bejovo parameter
    public void onFreeSemesterRequest(Message<FreeSemesterRequest> message) { //FreeSemesterRequest message helyett, de nekunk a ReplyTo fejlec fog szerepelni, abban szerepel, hova kell a valaszt kuldeni (nem csak a torzse erdekel a message-nek, hanem a fejlece is, igy nem a payload-ot veszem fel fel bejovo argumentumkent, hanem bewrappelem egy springframework-os message-be)
        int studentId = message.getPayload().getStudentId(); // a payload a FreeSemesterRequest, ebbol az id kell, valojaban centralId/eduId es nem sima id

        System.out.println("Now CentralSystem is called by JMS message !");

        int freeSemesters = centralsystemXmlWs.getFreeSemesterByCentralId(studentId); //uzleti logika hivas, mennyi a freeSemester
        System.out.println("This is the freesemester given by CentralSystem called by JMS message: " + freeSemesters);

        //valasz eloallitasa:
        FreeSemesterResponse freeSemesterResponse = new FreeSemesterResponse();
        freeSemesterResponse.setStudentId(studentId); //besettelni
        freeSemesterResponse.setNumFreeSemesters(freeSemesters); //besettelni
        //elkuldeni a megfelelo helyre:
        jmsTemplate.convertAndSend((Topic)message.getHeaders().get(JmsHeaders.REPLY_TO), freeSemesterResponse); // destination is megadhato elso parameternek, masodiknak pedig amit visszakuldunk
    }
}
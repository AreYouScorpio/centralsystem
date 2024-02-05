package hu.webuni.spring.centralsystem.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.Random;

@RequiredArgsConstructor
//@RestController
@RequestMapping("/api/centralsystem")
public class CentralsystemController {

    @GetMapping("/{centralId}")
    public int getFreeSemesterByCentralId(@PathVariable long centralId) {

        Random random = new Random();

        System.out.println("getFreeSemesterByCentralId within CentralSystem called at " + LocalDateTime.now());


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        int result = random.nextInt(0, 11);



        return result;

    }

}

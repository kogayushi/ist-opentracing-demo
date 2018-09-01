package jp.co.is_tech.opentracing.sleuth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class SampleController {
    private final String myName = "sleuth ";
    private final String message = "=> " + myName;
    @Autowired
    RestTemplate restTemplate;


    @GetMapping(value = "/to-sleuth", produces = MediaType.TEXT_PLAIN_VALUE)
    public String toSleuth() {
        String response = message + restTemplate.getForObject("http://localhost:8081/sleuth-end", String.class);
        log.info(myName);
        return response;
    }

    @GetMapping(value = "/to-brave", produces = MediaType.TEXT_PLAIN_VALUE)
    public String toBrave() {
        String response = message + restTemplate.getForObject("http://localhost:8082/brave-end", String.class);
        log.info(myName);
        return response;
    }


    @GetMapping(value = "/sleuth-end", produces = MediaType.TEXT_PLAIN_VALUE)
    public String sleuthEnd() {
        String response = message;
        log.info(myName);
        return response;
    }
}

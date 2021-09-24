package ee.bitweb.votingresultsapi.controller;

import ee.bitweb.votingresultsapi.model.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Controller
public class WebController {

    @Value("${DB_APP_PORT:8080}")
    private String dbAppPort;


    @Autowired
    private RestTemplate restTemplate;

    @MessageMapping("/")
    @SendTo("/votes")
    public List<Vote> getVotes()  {
        Vote[] votes = this.restTemplate.getForEntity(
                String.format("http://localhost:%s/voting/all", dbAppPort),
                Vote[].class).getBody();

        return votes != null ? Arrays.asList(votes) : List.of();
    }
}

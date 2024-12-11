package com.stackroute.teledemo.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

@RestController
@RequestMapping("/service")
public class HomeController {
    private static Logger logger = LoggerFactory.getLogger(HomeController.class);
    private RestTemplate restTemplate;
    public HomeController(RestTemplate restTemplate)
    {
        this.restTemplate=restTemplate;
    }

    @Value("${spring.application.name}")
    private  String applicationName; // Set your application name

    @GetMapping("/path1")
    public ResponseEntity<String> path1() {
        logger.info("Incoming request at {} for request/path1");

        String response = restTemplate.getForObject("http://localhost:8090/service/path2", String.class);

        return ResponseEntity.ok("Response from /path1: " + response);
    }

    @GetMapping("/path2")
    public ResponseEntity<String> path2() {
        logger.info("Incoming request at path1");

//        String response = restTemplate.getForObject("http://localhost:8090/service/path2", String.class);

        return ResponseEntity.ok("Response from path2: ");
    }

}

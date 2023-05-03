package org.example.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

@org.springframework.context.annotation.Configuration
public class Configuration {


    @Autowired
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}

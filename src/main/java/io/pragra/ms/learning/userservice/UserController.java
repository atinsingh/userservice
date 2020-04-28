package io.pragra.ms.learning.userservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")

public class UserController {

    @Value("${user.name}")
    private String name;
    @Value("${user.address}")
    private String address;
    private Environment environment;

    public UserController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/user")
    public Map<String,String> getUser() throws UnknownHostException {
        Map<String, String> user = new HashMap<>();
        user.put("name",name);
        user.put("address",address);
        user.put("systemId", environment.getProperty("server.port"));
        return user;
    }

}

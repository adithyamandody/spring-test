package adithyaproj.server.customer;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class Customer {

    @GetMapping("/")
    public String helloWorld() {
        return "hello world as";
    }
}

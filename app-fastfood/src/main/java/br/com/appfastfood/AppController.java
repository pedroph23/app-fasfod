package br.com.appfastfood;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class AppController {
    @GetMapping("/")
    public String getMessage() {
        return "Hello from Docker!";
    }
}
package org.example.springbootapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AppController {

    private final ReverseService reverseService;
    private final RestTemplate restTemplate;

    @Autowired
    public AppController(ReverseService reverseService, RestTemplate restTemplate) {
        this.reverseService = reverseService;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/hello") // http://localhost:391/hello
    public String hello(@RequestParam(required = false) String name) {
        if (name != null && !name.isEmpty()) {
            return "Hello, " + name + "!";
        } else {
            return "Hello, World! <br>Enter your name, for example, <a href=\"/hello?name=GB\">http://localhost:391/hello?name=GB</a>";
        }
    }


    @GetMapping("/reverse") // http://localhost:391/reverse?input=GeekBrains
    public String reverse(@RequestParam(name = "input", required = false) String input) {
        if (input != null && !input.isEmpty()) {
            String reversedString = reverseService.reverseString(input);
            return "Reversed String: " + reversedString;
        } else {
            return "Please provide a valid 'input' parameter, for example, <a href=\"/reverse?input=GeekBrains\">http://localhost:391/reverse?input=GeekBrains</a>";
        }
    }

    /**
     * Пример использования RestTemplate.
     */
    @GetMapping("/external-data") // http://localhost:391/external-data
    public String getExternalData() {
        ResponseEntity<String> response = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/todos/1", String.class);
        String externalData = response.getBody();
        return "External Data: " + externalData;
    }
}

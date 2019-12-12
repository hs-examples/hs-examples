package com.github.nkolytschew.userservicems.web.rest;


import com.github.nkolytschew.userservicems.service.ExampleService;
import com.github.nkolytschew.userservicems.web.model.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class WelcomeController {

    @Value("${app.custom.welcome.message}")
    private String welcomeMessage;


    private final ExampleService service;

    public WelcomeController(ExampleService service) {
        this.service = service;
    }

    @RequestMapping(value = "welcome", method = RequestMethod.GET)
    public String printWelcomeMessage() {
        return welcomeMessage;
    }

    @GetMapping("{pathVar}/welcome")
    public String printWelcomeMessageBasedOnPath(@PathVariable String pathVar) {
        return welcomeMessage + " with following pathVar: " + pathVar;
    }

    @GetMapping("welcomeRequest")
    public String printWelcomeMessageWithRequestParam(@RequestParam("name") String requestParam) {
        return welcomeMessage + " with request param '?name=' : " + requestParam;
    }

    @PostMapping("welcomeRequest")
    public String printWelcomeWithRequestBodyPost(@RequestBody String requestBody) {
        return welcomeMessage + " with request body : " + requestBody;
    }

    @GetMapping("random")
    public ResponseEntity<ResponseModel> printRandomStringFromService() {
        return ResponseEntity.ok(new ResponseModel(welcomeMessage + " random service call : " + this.service.randomServiceCall()));
    }
}

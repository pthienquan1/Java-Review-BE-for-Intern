package com.example.review2springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by quan0
 * Date 5/18/2023 - 9:56 PM
 * Description: ...
 */
@RestController
@RequestMapping(value = "/hello")
public class HelloController {
    @GetMapping
    public String hello(@RequestParam(value = "name", defaultValue = "world") String name){
        return String.format("Hello %s!", name);
    }
}

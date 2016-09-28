package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Favio Gonzalez on 9/23/2016.
 */
@RestController
public class GreetingsController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    private GreetingsService greetingsService;

    private AppProperties appProperties;

    @Autowired
    public void setAppProperties(AppProperties appProperties){
        this.appProperties = appProperties;
    }



    @Value("${breakbot.doh}")
    private String bla;

    @RequestMapping("/greeting")
    public Greetings greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greetings(counter.incrementAndGet(),
                String.format(template, greetingsService.getMessage() + " " + bla + " " + appProperties.getName() + " " + greetingsService.getaName() + " " + greetingsService.getaMsg() ));
    }

    @Autowired
    public void setGreetingsService(GreetingsService greetingsService) {
        this.greetingsService = greetingsService;
    }
}

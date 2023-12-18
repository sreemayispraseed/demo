package com.example.demo;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;

@RestController
@RequestMapping("/welcome")
public class WelcomeController {
    @GetMapping("/cat")
    public String welcomeCat() {
        return "Hello Ginger";
    }

    @PostMapping("/age")
    public String catAge(@RequestParam String name, @RequestParam String breadName , @RequestParam int Age) {

        return "Name:"+ name + ", BreadName:" + breadName + " Age:" + Age;
    }

    @PostMapping("/calculateAge")
    public catResponse calculateAge(@RequestBody catDetails catDetail){
        String name = catDetail.getName();
        String breadName = catDetail.getBreadName();
        LocalDate dob = catDetail.getDob();


        int age = Period.between(dob,LocalDate.now()).getYears();


        catResponse catResponseO = new catResponse();
        catResponseO.setName(name);
        catResponseO.setBreadName(breadName);
        catResponseO.setAge(age);

        return catResponseO;
    }
}


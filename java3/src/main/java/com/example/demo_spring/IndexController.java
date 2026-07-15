package com.example.demo_spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    @GetMapping("/")
    public String indexPage(){
        return "index";
    }

    @GetMapping("contact-us")
    public String contactPage(){
        return "contact";
    }

    @PostMapping("contact-us") // contact-us?name=XX&email=YY&message=Hello
    public String submitForm(@RequestParam String name,
                             @RequestParam(name = "emailAddress", required = false) String email,
                             @RequestParam String message){
        System.out.println("Form submitted");
        System.out.println("name:"+name);
        System.out.println("email:"+email);
        System.out.println("message:"+message);
        return "contact";
    }

    @GetMapping("register-now")
    public String registerNow(){
        return "registration";
    }

    @PostMapping("register-now")
    public String registerForm(@RequestParam String name,
                               @RequestParam String id,
                               @RequestParam String password){
        System.out.println("Form submitted");
        System.out.println("name:"+name);
        System.out.println("id:"+id);
        System.out.println("password:"+password);
        return "registration";
    }
}

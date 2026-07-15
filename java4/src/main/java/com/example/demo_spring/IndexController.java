package com.example.demo_spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Slf4j
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

    @PostMapping("submit-form") // contact-us?name=XX&email=YY&message=Hello
    public String submitForm(@ModelAttribute Contact contact){
        log.info("Contact Form submitted {}", contact);
        return "redirect:/register-now";
    }

    @GetMapping("register-now")
    public String registerNow(){
        return "registration";
    }

    @PostMapping("registerSubmit")
    public String registerForm(@ModelAttribute register register){
        log.info("Register Form submitted {}", register);
        return "redirect:/contact-us";
    }
}

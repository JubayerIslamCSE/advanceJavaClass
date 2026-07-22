package com.example.java56;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/product")
public class ProductController {

    private final List<Product> products = new ArrayList<>();



    @GetMapping("/add")
    public String showForm(Model model) {
//        model.addAttribute("name", "Mr. Java");
        model.addAttribute("product", new Product());
        return "form";
    }

    @PostMapping("/add")
    public String submit(@Valid @ModelAttribute Product product, BindingResult bindingResult) {
        log.info("Product {} has been Submitted", product);

        if (bindingResult.hasErrors()) {
            return "form";
        }

        products.add(product);
        log.info("Product {} has been Saved", product);
        return "redirect:/product/add";
    }

    //List
    @GetMapping("list")
    public String list(Model model) {
        model.addAttribute("products", products);
        return "list";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(Model model, @PathVariable int id) {
        model.addAttribute("product", products.get(id));
        return "product/add";
    }

}

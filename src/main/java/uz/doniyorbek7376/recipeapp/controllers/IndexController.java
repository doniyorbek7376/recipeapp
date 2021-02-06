package uz.doniyorbek7376.recipeapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping({ "", "/", "/index" })
    public String getIndexPage() {
        System.out.println("Index Controller");
        return "index";
    }
}

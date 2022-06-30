package br.com.brunolutterbach.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {

    // Retorna a view "hello"
    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("nome", "Mundo");
        return "hello";
    }

}

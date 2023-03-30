package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.ContactForm;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
    
    @GetMapping("/contact")
    public String contactForm(Model model) {
        model.addAttribute("contactForm", new ContactForm());
        return "contact";
    }
    
    @PostMapping("/contact")
    public String contactFormSubmit(@ModelAttribute("contactForm") ContactForm contactForm, Model model) {
        model.addAttribute("name", contactForm.getName());
        model.addAttribute("email", contactForm.getEmail());
        model.addAttribute("message", contactForm.getMessage());
        return "contact-confirm";
    }


    @GetMapping("/about")
    @ResponseBody
    public String about() {
        return "About this site";
    }

    @RequestMapping(value = "*", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String error() {
        return "Error: Unsupported HTTP method or invalid URL.";
    }

}


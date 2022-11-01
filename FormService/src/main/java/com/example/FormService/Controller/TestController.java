package com.example.FormService.Controller;

import com.example.FormService.Domain.Models.Photo;
import com.example.FormService.Domain.Models.User_Form;
import com.example.FormService.Domain.Repos.FormRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.Normalizer;

@RestController
public class TestController {
    @Autowired
    FormRepo repo;
    @GetMapping("/")
    public String greeting(
            @RequestParam(name = "name", required = false, defaultValue = "World") String name,
            Model model
    ){
        model.addAttribute("name", name);
        Photo photo = new Photo();
        repo.save(photo);
        return "Greeting" + name;
    }
}

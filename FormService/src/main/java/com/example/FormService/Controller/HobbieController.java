package com.example.FormService.Controller;

import com.example.FormService.Domain.Models.Hobby;
import com.example.FormService.Service.Interfaces.HobbyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="api/profile/hobbies",
        produces = "application/json"
)
public class HobbieController {
    private final HobbyService hobbyService;

    public HobbieController(HobbyService hobbyService) {
        this.hobbyService = hobbyService;
    }
    @GetMapping
    public List<Hobby> getHobbies(){
        return hobbyService.getListofHobbies();
    }
}

package com.example.FormService.Controller;

import com.example.FormService.DTO.SexDTO;
import com.example.FormService.Domain.Models.Hobby;
import com.example.FormService.Domain.Models.Sex;
import com.example.FormService.Service.Interfaces.SexService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/profiles/sex")
public class SexController {
    private final SexService sexService;
    public SexController(SexService sexService) {
        this.sexService = sexService;
    }

    @GetMapping
    public List<SexDTO> getSex(){
        return sexService.getListofSex();
    }
    @GetMapping(path = "/{Name}")
    public Sex getSexByName(@PathVariable("Name") String name){
        sexService.getSexByName(name);
        return null;
    }
}

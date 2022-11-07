package com.example.FormService.Controller;

import com.example.FormService.DTO.FormDTO;
import com.example.FormService.Domain.Models.User_Form;
import com.example.FormService.Service.FormService;
import org.springframework.web.bind.annotation.*;

@RestController("api/profile")
public class FormController {
    private final FormService formService;
    public FormController(FormService formService){
        this.formService = formService;
    }
    @GetMapping("/{userId}")
    public FormDTO getForm(@PathVariable int userId){
        return formService.getForm(userId);
    }
    @PostMapping(value = "/create", consumes={"application/json"})
    public void addForm(@RequestBody User_Form form){
        formService.saveForm(form);
    }
    @DeleteMapping("/{userId}")
    public void deleteForm(@PathVariable int userId){
        formService.delForm(userId);
    }
    @PutMapping("/{userId}")
    public void updateForm(@PathVariable int userId, @RequestBody User_Form form){

    }
}

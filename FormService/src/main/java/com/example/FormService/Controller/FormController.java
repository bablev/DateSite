package com.example.FormService.Controller;

import com.example.FormService.DTO.FormDTO;
import com.example.FormService.Domain.Models.User_Form;
import com.example.FormService.Service.FormService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping(path = "api/profile", produces = "application/json")
public class FormController {
    private final FormService formService;
    public FormController(FormService formService){
        this.formService = formService;
    }
    @GetMapping("/{userId}")
    public FormDTO   getForm(@PathVariable int userId){
        return formService.getForm(userId);
    }
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void addForm(@RequestBody FormDTO form){
        formService.saveForm(form);
    }
    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping("/{userId}")
    public void deleteForm(@PathVariable int userId){
        formService.delForm(userId);
    }
    @PutMapping("/{userId}")
    public void updateForm(@PathVariable int userId, @RequestBody FormDTO form){
        formService.updateForm(form,userId);
    }
}

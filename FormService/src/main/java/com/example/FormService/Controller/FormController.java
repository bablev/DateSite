package com.example.FormService.Controller;

import com.example.FormService.DTO.FormDTO;
import com.example.FormService.DTO.FormResponseDTO;
import com.example.FormService.Service.FormService;
import com.example.FormService.Utils.Exceptions.ParameterMustBeSet;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController()
@RequestMapping(path = "api/profiles", produces = "application/json")
public class FormController {
    private final FormService formService;
    public FormController(FormService formService){
        this.formService = formService;
    }
    @GetMapping("/{userId}")
    public FormDTO getForm(@PathVariable int userId, @RequestParam(required = false) boolean preview){
        return formService.getForm(userId,preview);
    }
    @GetMapping(value = "/search")
    public List<FormResponseDTO> search(@RequestParam(required = false) Optional<String> age,
                                        @RequestParam(required = false) Optional<String> sex,
                                        @RequestParam(required = false) Optional<String> interestedSex,
                                        @RequestParam(required = false) Optional<List<String>> hobbies
                                        ){
        if(age.isPresent())
            return formService.getFormByAge(Integer.parseInt(age.get()));
        else if (sex.isPresent())
            return formService.getFormBySex(sex.get());
        else if (interestedSex.isPresent())
            return formService.getFormByInterestedSex(interestedSex.get());
        else if (hobbies.isPresent())
            return formService.getFormByHobbies(hobbies.get());
        else
            throw new ParameterMustBeSet("Обязательно должен быть указан 1 параметр!");
    }
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void addForm(@Valid @RequestBody FormResponseDTO form){
        System.out.println(form.getSexualOrientation());
        formService.saveForm(form);
    }
    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping("/{userId}")
    public void deleteForm(@PathVariable int userId){
        formService.delForm(userId);
    }
    @PutMapping("/{userId}")
    public void updateForm(@PathVariable int userId, @RequestBody FormResponseDTO form){
        formService.updateForm(form,userId);
    }
}

package com.example.FormService.Service;

import com.example.FormService.DTO.FormDTO;
import com.example.FormService.Domain.Models.User_Form;
import com.example.FormService.Domain.Repos.FormRepo;
import com.example.FormService.Service.Interfaces.HobbyService;
import com.example.FormService.Service.Interfaces.SexService;
import com.example.FormService.Service.Interfaces.SexualOrientationService;
import com.example.FormService.Utils.Exceptions.FormNotFoundException;
import com.example.FormService.Utils.FormConvertor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.NoSuchElementException;

@Service
public class FormService {
    private final FormConvertor convertor;
    private final FormRepo formRepo;
    private final SexService sexService;
    private final HobbyService hobbyService;
    private final SexualOrientationService sexualOrientationService;
    public FormService(FormRepo formRepo, FormConvertor convertor, SexService sexService, HobbyService hobbyService, SexualOrientationService sexualOrientationService){
        this.formRepo = formRepo;
        this.convertor = convertor;
        this.sexService = sexService;
        this.hobbyService = hobbyService;
        this.sexualOrientationService = sexualOrientationService;
    }
    public FormDTO getForm(int userId){
        User_Form form;
        try {
            form = formRepo.findById(userId).get();
        }
        catch (NoSuchElementException ex){
            throw new FormNotFoundException("Анкета с id " + userId + " была не найдена");
        }
        FormDTO dto = convertor.convertToDTO(form);
        dto.setHobbies(hobbyService.getHobbiesByForm(form.getId()));
        dto.setSexualOrientation(form.getSexualorientation().getName());
        dto.setSex(form.getSex().getSex_name());
        dto.setInterestedSex(form.getInterestedsex().getSex_name());
        return dto;
    }
    public void saveForm(FormDTO form){
        User_Form user_form = convertor.convertToEntity(form);
        user_form.setSex(sexService.getSexByName(form.getSex()));
        user_form.setInterestedsex(sexService.getSexByName(form.getInterestedSex()));
        user_form.setHobbyList(hobbyService.getListofHobbiesByName(form.getHobbies()));
        user_form.setSexualorientation(sexualOrientationService.getSexualOrientationByName(form.getSexualOrientation()));
        user_form.setUpdated_at(new Timestamp(System.currentTimeMillis()));
        user_form.setStatus(User_Form.Status.Inactive);
        formRepo.save(user_form);

    }
    public void delForm(int userId){
        try {
            User_Form form = formRepo.findById(userId).get();
        }
        catch (NoSuchElementException ex){
            throw new FormNotFoundException("Анкета с id " + userId + " была не найдена");
        }
        formRepo.deleteById(userId);
    }
    public void updateForm(FormDTO form, int user_id){
        try {
            formRepo.findById(user_id).get();
        }
        catch (NoSuchElementException ex){
            throw new FormNotFoundException("Анкета с id " + user_id + " была не найдена");
        }
        User_Form user_form = convertor.convertToEntity(form);
        user_form.setSex(sexService.getSexByName(form.getSex()));
        user_form.setInterestedsex(sexService.getSexByName(form.getInterestedSex()));
        user_form.setHobbyList(hobbyService.getListofHobbiesByName(form.getHobbies()));
        user_form.setSexualorientation(sexualOrientationService.getSexualOrientationByName(form.getSexualOrientation()));
        user_form.setUpdated_at(new Timestamp(System.currentTimeMillis()));
        user_form.setStatus(User_Form.Status.Inactive);
        user_form.setId(user_id);
        formRepo.save(user_form);
    }
}

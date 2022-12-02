package com.example.FormService.Service;

import com.example.FormService.DTO.FormDTO;
import com.example.FormService.DTO.FormResponseDTO;
import com.example.FormService.Domain.Models.User_Form;
import com.example.FormService.Domain.Repos.Implementation.FormRepo;
import com.example.FormService.Domain.Repos.Interfaces.CustomFormRepository;
import com.example.FormService.Service.Interfaces.HobbyService;
import com.example.FormService.Service.Interfaces.SexService;
import com.example.FormService.Service.Interfaces.SexualOrientationService;
import com.example.FormService.Utils.Exceptions.FormNotFoundException;
import com.example.FormService.Utils.Exceptions.NotValidCountParams;
import com.example.FormService.Utils.FormConvertor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional(readOnly = true)
public class FormService {
    private final FormConvertor convertor;
    private final FormRepo formRepo;
    private final SexService sexService;
    private final CustomFormRepository customFormRepository;
    private final HobbyService hobbyService;
    private final SexualOrientationService sexualOrientationService;
    public FormService(FormRepo formRepo, FormConvertor convertor, SexService sexService, CustomFormRepository customFormRepository, HobbyService hobbyService, SexualOrientationService sexualOrientationService){
        this.formRepo = formRepo;
        this.convertor = convertor;
        this.sexService = sexService;
        this.customFormRepository = customFormRepository;
        this.hobbyService = hobbyService;
        this.sexualOrientationService = sexualOrientationService;
    }

    public FormDTO getForm(int userId, boolean preview){
        try {
            User_Form form = customFormRepository.retrieveById(userId);
            if (preview) {
                return convertor.convertToPreviewDTO(form);
            }
            return convertor.convertToDTO(form);
        }
        catch (EmptyResultDataAccessException ex){
            throw new FormNotFoundException("Анкета с id " + userId + " была не найдена");
        }
    }
    @Transactional(readOnly = false)
    public void saveForm(FormResponseDTO form){
        User_Form user_form = convertor.convertToEntity(form);
        user_form.setUpdated_at(new Timestamp(System.currentTimeMillis()));
        user_form.setStatus(User_Form.Status.Inactive);
        formRepo.save(user_form);

    }
    @Transactional(readOnly = false)
    public void delForm(int userId){
        try {
            User_Form form = formRepo.findById(userId).get();
        }
        catch (NoSuchElementException ex){
            throw new FormNotFoundException("Анкета с id " + userId + " была не найдена");
        }
        formRepo.deleteById(userId);
    }
//    @Transactional
//    public List<FormResponseDTO>  getFormByParam(Map<String,String> params){
//        if(params.size() > 1)
//            throw new NotValidCountParams("Неверное количество параметров. Максимум только одно");
//        final String key,value;
//        params.entrySet().forEach(p->{
//            key = p.getKey();
//        });
//        return null;
//
//    }
    public List<FormResponseDTO> getFormByAge(int age){
        List<User_Form> form = customFormRepository.retrieveByAge(age);
        return form.stream().map(convertor::convertToDTO).toList();
    }
    public List<FormResponseDTO> getFormBySex(String sex){
        List<User_Form> form = customFormRepository.retrieveBySex(sex);
        return form.stream().map(convertor::convertToDTO).toList();
    }
    public List<FormResponseDTO> getFormByInterestedSex(String interestedSex){
        List<User_Form> form = customFormRepository.retrieveByInterestedSex(interestedSex);
        return form.stream().map(convertor::convertToDTO).toList();
    }
    public List<FormResponseDTO> getFormByHobbies(List<String> hobbies){
        List<User_Form> form = customFormRepository.retrieveByHobbies(hobbies);
        return form.stream().map(convertor::convertToDTO).toList();
    }
    @Transactional(readOnly = false)
    public void updateForm(FormResponseDTO form, int user_id){
        try {
            formRepo.findById(user_id).get();
        }
        catch (NoSuchElementException ex){
            throw new FormNotFoundException("Анкета с id " + user_id + " была не найдена");
        }
        User_Form user_form = convertor.convertToEntity(form);
//        user_form.setSex(sexService.getSexByName(form.getSex()));
//        user_form.setInterestedsex(sexService.getSexByName(form.getInterestedSex()));
//        user_form.setHobbyList(hobbyService.getListofHobbiesByName(form.getHobbies()));
//        user_form.setSexualorientation(sexualOrientationService.getSexualOrientationByName(form.getSexualOrientation()));
        user_form.setUpdated_at(new Timestamp(System.currentTimeMillis()));
        user_form.setStatus(User_Form.Status.Inactive);
        user_form.setId(user_id);
        formRepo.save(user_form);
    }
}

package com.example.FormService.Service;

import com.example.FormService.DTO.FormDTO;
import com.example.FormService.Domain.Models.User_Form;
import com.example.FormService.Domain.Repos.FormRepo;
import com.example.FormService.Utils.FormConvertor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;

@Service
public class FormService {
    private final FormConvertor convertor;
    private final FormRepo formRepo;
    public FormService(FormRepo formRepo, FormConvertor convertor){
        this.formRepo = formRepo;
        this.convertor = convertor;
    }
    public FormDTO getForm(int userId){
        User_Form form = formRepo.findById(userId).get();
        if(form == null){
            throw new IllegalArgumentException();
        }
        return convertor.convertToDTO(form);
    }
    public void saveForm(User_Form form){
        form.setUpdated_at(new Timestamp(System.currentTimeMillis()));
        form.setStatus(User_Form.Status.Inactive);
        formRepo.save(form);
    }
    public void delForm(int userId){
        formRepo.deleteById(userId);
    }
    public void updateForm(User_Form form){
        formRepo.save(form);
    }
}

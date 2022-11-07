package com.example.FormService.Utils;

import com.example.FormService.DTO.FormDTO;
import com.example.FormService.Domain.Models.User_Form;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class FormConvertor {
    private final ModelMapper modelMapper;
    public FormConvertor(){
        this.modelMapper = new ModelMapper();
    }
    public FormDTO convertToDTO(User_Form form){
        return modelMapper.map(form,FormDTO.class);
    }
}

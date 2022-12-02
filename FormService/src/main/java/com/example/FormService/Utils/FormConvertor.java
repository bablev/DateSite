package com.example.FormService.Utils;

import com.example.FormService.DTO.FormResponseDTO;
import com.example.FormService.DTO.FormPreviewDTO;
import com.example.FormService.Domain.Models.User_Form;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class FormConvertor {
    private final ModelMapper modelMapper;
    public FormConvertor(){
        this.modelMapper = new ModelMapper();
    }
    public FormResponseDTO convertToDTO(User_Form form){
        return modelMapper.map(form, FormResponseDTO.class);
    }
    public User_Form convertToEntity(FormResponseDTO formResponseDTO){
        return modelMapper.map(formResponseDTO, User_Form.class);
    }
    public FormPreviewDTO convertToPreviewDTO(User_Form form){
        return modelMapper.map(form,FormPreviewDTO.class);
    }
    //public User_Form convertToEntity(FormDTO formDTO){
        // TypeMap<FormDTO, User_Form> propertyMapper = this.modelMapper.createTypeMap(FormDTO.class,User_Form.class);
        // propertyMapper.addMappings(modelMapper -> modelMapper.skip(User_Form::se);
        // propertyMapper.addMappings(modelMapper -> modelMapper.skip(User_Form::setHobbyList));
        // propertyMapper.addMappings(modelMapper -> modelMapper.skip(User_Form::setInterestedsex));
        // propertyMapper.addMappings(modelMapper -> modelMapper.skip(User_Form::setSexualorientation));
        // return modelMapper.map(formDTO, User_Form.class);
    //}
}

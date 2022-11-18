package com.example.FormService.Utils;

import com.example.FormService.DTO.FormDTO;
import com.example.FormService.DTO.SexDTO;
import com.example.FormService.Domain.Models.Sex;
import com.example.FormService.Domain.Models.User_Form;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class SexConvertor {
    private final ModelMapper modelMapper;

    public SexConvertor() {
        this.modelMapper = new ModelMapper();
    }

    public SexDTO convertToDTO(Sex sex){
            return modelMapper.map(sex, SexDTO.class);
        }
}

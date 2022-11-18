package com.example.FormService.Service.Interfaces;

import com.example.FormService.DTO.SexDTO;
import com.example.FormService.Domain.Models.Sex;

import java.util.List;
import java.util.Optional;

public interface SexService {
    public Sex getSexByName(String name);
    public List<SexDTO> getListofSex();
}

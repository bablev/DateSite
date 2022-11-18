package com.example.FormService.Service.Interfaces;

import com.example.FormService.Domain.Models.Sexual_Orientation;

import java.util.List;

public interface SexualOrientationService {
    public List<Sexual_Orientation> getListofSexOrientations();
    public Sexual_Orientation getSexualOrientationByName(String name);
}

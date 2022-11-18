package com.example.FormService.Service.Interfaces;

import com.example.FormService.Domain.Models.Hobby;

import java.util.List;

public interface HobbyService {
    public List<Hobby> getListofHobbiesByName(List<String> names);
    public List<Hobby> getListofHobbies();
    public List<String> getHobbiesByForm(int id);
}

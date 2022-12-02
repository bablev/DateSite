package com.example.FormService.Domain.Repos.Interfaces;

import com.example.FormService.DTO.FormResponseDTO;
import com.example.FormService.Domain.Models.User_Form;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomFormRepository {
    public User_Form retrieveById(int id);
    public List<User_Form> retrieveByAge(int age);
    public List<User_Form> retrieveBySex(String sex);
    public List<User_Form> retrieveByInterestedSex(String interestedSex);
    public List<User_Form> retrieveByHobbies(List<String> hobbies);
}

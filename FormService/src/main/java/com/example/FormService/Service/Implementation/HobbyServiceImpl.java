package com.example.FormService.Service.Implementation;

import com.example.FormService.Domain.Models.Hobby;
import com.example.FormService.Domain.Repos.Interfaces.HobbyRepository;
import com.example.FormService.Service.Interfaces.HobbyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional(readOnly = true)
public class HobbyServiceImpl implements HobbyService {
    private final HobbyRepository hobbyRepository;
    public HobbyServiceImpl(HobbyRepository hobbyRepository){
        this.hobbyRepository = hobbyRepository;
    }
    @Override
    public List<Hobby> getListofHobbies(){
        return hobbyRepository.findAll();
    }

    @Override
    public List<String> getHobbiesByForm(int id) {
        return hobbyRepository.getHobbiesByForm(id);
    }

    public List<Hobby> getListofHobbiesByName(List<String> names){
        return hobbyRepository.getHobbiesByTitle(names);
    }
}

package com.example.FormService.Service.Implementation;

import com.example.FormService.Domain.Models.Sexual_Orientation;
import com.example.FormService.Domain.Repos.Interfaces.SexualOrientationRepository;
import com.example.FormService.Service.Interfaces.SexualOrientationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SexualOrientationServiceImpl implements SexualOrientationService {
    private final SexualOrientationRepository sexualOrientationRepository;

    public SexualOrientationServiceImpl(SexualOrientationRepository sexualOrientationRepository) {
        this.sexualOrientationRepository = sexualOrientationRepository;
    }

    @Override
    public List<Sexual_Orientation> getListofSexOrientations() {
        return sexualOrientationRepository.findAll();
    }
    public Sexual_Orientation getSexualOrientationByName(String name){
        return sexualOrientationRepository.getSexual_OrientationByName(name);
    }
}

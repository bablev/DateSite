package com.example.FormService.Service.Implementation;

import com.example.FormService.DTO.SexDTO;
import com.example.FormService.Domain.Models.Sex;
import com.example.FormService.Domain.Repos.Interfaces.SexRepository;
import com.example.FormService.Service.Interfaces.SexService;
import com.example.FormService.Utils.SexConvertor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SexServiceImpl implements SexService {
    private final SexConvertor sexConvertor;
    private final SexRepository sexRepository;

    public SexServiceImpl(SexConvertor sexConvertor, SexRepository sexRepository) {
        this.sexConvertor = sexConvertor;
        this.sexRepository = sexRepository;
    }

    @Override
    public Sex getSexByName(String name) {
        return sexRepository.getSexByName(name);
    }

    @Override
    public List<SexDTO> getListofSex() {
        List<SexDTO> list = sexRepository.findAll()
                .stream()
                .map(sexConvertor::convertToDTO).toList();
        return list;
    }

}

package com.example.FormService.Domain.Repos.Interfaces;

import com.example.FormService.DTO.SexDTO;
import com.example.FormService.Domain.Models.Sex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface SexRepository extends JpaRepository<Sex, Integer> {
    @Query(value = "SELECT new com.example.FormService.Domain.Models.Sex(s.sex_name, s.id) FROM Sex s WHERE s.sex_name = ?1")
    Sex getSexByName(String title);
}

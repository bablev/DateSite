package com.example.FormService.Domain.Repos;

import com.example.FormService.Domain.Models.Sex;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SexRepo extends CrudRepository<Sex, Integer> {
}

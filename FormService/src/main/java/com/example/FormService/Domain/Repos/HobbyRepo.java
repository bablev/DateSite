package com.example.FormService.Domain.Repos;

import com.example.FormService.Domain.Models.Hobby;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HobbyRepo extends JpaRepository<Hobby, Integer> {
}

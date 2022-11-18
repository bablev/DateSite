package com.example.FormService.Domain.Repos.Interfaces;

import com.example.FormService.Domain.Models.Sexual_Orientation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SexualOrientationRepository  extends JpaRepository<Sexual_Orientation, Integer> {
    @Query("SELECT new Sexual_Orientation(s.name,s.id) FROM Sexual_Orientation s WHERE s.name = ?1")
    public Sexual_Orientation getSexual_OrientationByName(String name);
}

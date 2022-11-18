package com.example.FormService.Domain.Repos.Interfaces;

import com.example.FormService.Domain.Models.Hobby;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface HobbyRepository extends JpaRepository<Hobby, Integer> {
    @Query("SELECT new com.example.FormService.Domain.Models.Hobby(h.hobby_name, h.id) FROM Hobby h WHERE h.hobby_name IN :names")
    public List<Hobby> getHobbiesByTitle(@Param("names")List<String> names);
    @Query(value = "SELECT h.hobby_name FROM Hobby h INNER JOIN user_formshobbies uf ON h.id=uf.hobbyid " +
            "WHERE uf.user_formid = ?1", nativeQuery = true)
    public List<String> getHobbiesByForm(int id);
}

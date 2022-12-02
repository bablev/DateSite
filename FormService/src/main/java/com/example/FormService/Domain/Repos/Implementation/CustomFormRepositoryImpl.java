package com.example.FormService.Domain.Repos.Implementation;

import com.example.FormService.DTO.FormDTO;
import com.example.FormService.DTO.FormResponseDTO;
import com.example.FormService.Domain.Models.User_Form;
import com.example.FormService.Domain.Repos.Interfaces.CustomFormRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CustomFormRepositoryImpl implements CustomFormRepository {
    private final EntityManager entityManager;

    public CustomFormRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public User_Form retrieveById(int id) {
        User_Form form = (User_Form) entityManager.createQuery("SELECT us FROM User_Form us LEFT JOIN FETCH us.sex " +
                "INNER JOIN FETCH us.interestedsex ins INNER JOIN FETCH us.sexualorientation so INNER JOIN FETCH us.hobbyList hl WHERE us.id = :id")
                .setParameter("id",id).getSingleResult();
        return form;
    }

    @Override
    public List<User_Form> retrieveByAge(int age) {
        List<User_Form> form = entityManager.createQuery("SELECT us FROM User_Form us LEFT JOIN FETCH us.sex " +
                                "INNER JOIN FETCH us.interestedsex ins INNER JOIN FETCH us.sexualorientation so INNER JOIN FETCH us.hobbyList hl WHERE us.age = :age")
                .setParameter("age",age).getResultList();
        return form;
    }

    @Override
    public List<User_Form> retrieveBySex(String sex) {
        List<User_Form> form = entityManager.createQuery("SELECT us FROM User_Form us LEFT JOIN FETCH us.sex " +
                        "INNER JOIN FETCH us.interestedsex ins INNER JOIN FETCH us.sexualorientation so INNER JOIN FETCH us.hobbyList hl WHERE us.sex.sex_name = :sex")
                .setParameter("sex",sex).getResultList();
        return form;
    }

    @Override
    public List<User_Form> retrieveByInterestedSex(String interestedSex) {
        List<User_Form> form = entityManager.createQuery("SELECT us FROM User_Form us LEFT JOIN FETCH us.sex " +
                        "INNER JOIN FETCH us.interestedsex ins INNER JOIN FETCH us.sexualorientation so " +
                        "INNER JOIN FETCH us.hobbyList hl WHERE us.interestedsex.sex_name = :interestedSex")
                .setParameter("interestedSex",interestedSex).getResultList();
        return form;
    }

    @Override
    public List<User_Form> retrieveByHobbies(List<String> hobbies) {
        List<User_Form> form = entityManager.createQuery("SELECT us FROM User_Form us LEFT JOIN FETCH us.sex " +
                                       "INNER JOIN FETCH us.interestedsex ins INNER JOIN FETCH us.sexualorientation so "  +
                                       "INNER JOIN FETCH us.hobbyList hl WHERE hl.hobby_name IN :hobbies")
                .setParameter("hobbies",hobbies).getResultList();
        return form;
    }

}

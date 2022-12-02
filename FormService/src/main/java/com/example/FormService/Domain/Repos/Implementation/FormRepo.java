package com.example.FormService.Domain.Repos.Implementation;

import com.example.FormService.Domain.Models.Photo;
import com.example.FormService.Domain.Models.User_Form;
import com.example.FormService.Domain.Repos.Interfaces.CustomFormRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Repository
public interface FormRepo extends JpaRepository<User_Form,Integer> {

}

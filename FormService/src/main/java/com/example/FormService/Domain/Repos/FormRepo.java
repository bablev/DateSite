package com.example.FormService.Domain.Repos;

import com.example.FormService.Domain.Models.Photo;
import com.example.FormService.Domain.Models.User_Form;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Service
@Configuration
@EnableJpaRepositories(basePackages = {"com.example.FormService.Domain.Repos"})
@EnableTransactionManagement
public interface FormRepo extends CrudRepository<Photo, Integer> {

}

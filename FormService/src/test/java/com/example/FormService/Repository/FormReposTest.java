package com.example.FormService.Repository;
import com.example.FormService.Application;
import com.example.FormService.Domain.Models.Hobby;
import com.example.FormService.Domain.Models.Sex;
import com.example.FormService.Domain.Models.Sexual_Orientation;
import com.example.FormService.Domain.Models.User_Form;
import com.example.FormService.Domain.Repos.FormRepo;
import com.example.FormService.Domain.Repos.HobbyRepo;
import org.h2.engine.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ExtendWith(SpringExtension.class)
public class FormReposTest {
    private User_Form form;
    @Autowired
    private HobbyRepo hobbyRepo;
    private List<Hobby> hobbies = new ArrayList<>();
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private FormRepo formRepo;
    private void setup(){
        Hobby hobby = Hobby.builder().hobby_name("Swimming").id(1).build();
        hobbyRepo.save(hobby);
        hobbies.add(Hobby.builder().hobby_name("Swimming").id(1).build());

        User_Form userForm = User_Form.builder()
                .sex(Sex.builder().title("Male").build())
                .date_birth(Date.valueOf("2002-10-29"))
                .interestedsex(Sex.builder().title("Women").build())
                .owner_id(32)
                .name("Chuchkevic Victor")
                .status(User_Form.Status.Inactive)
                .updated_at(new Timestamp(System.currentTimeMillis()))
                .sexualorientation(Sexual_Orientation.builder().name("Natural").build())
                .hobbyList(hobbies)
                .build();
        form = userForm;

    }
    @Test
    public void it_should_save_form() {
        setup();
        assertThat(formRepo.findById(form.getId())).isNotPresent();
        formRepo.save(form);
        assertThat(formRepo.findById(form.getId()).get()).isEqualTo(form);
    }
    @Test
    public void it_should_delete_form(){
            setup();
            formRepo.save(form);
            assertThat(formRepo.findById(form.getId())).isPresent();
            formRepo.deleteById(form.getId());
            assertThat(formRepo.findById(form.getId())).isNotPresent();
    }
    @Test
    public void it_should_return_form_byId(){
        setup();
        assertThat(formRepo.findById(form.getId())).isNotPresent();
        formRepo.save(form);
        User_Form form2 = formRepo.findById(form.getId()).get();
        assertThat(form2).isEqualTo(form);
    }
    @Test
    public void it_should_update_form(){
        setup();
        formRepo.save(form);
        User_Form form1 = formRepo.findById(2).get();
        form1.setStatus(User_Form.Status.Active);
        User_Form updatedForm = formRepo.save(form1);
        assertThat(updatedForm.getStatus()).isEqualTo(User_Form.Status.Active);
    }
}

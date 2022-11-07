package com.example.FormService.Service;
import com.example.FormService.Domain.Models.Hobby;
import com.example.FormService.Domain.Models.Sex;
import com.example.FormService.Domain.Models.Sexual_Orientation;
import com.example.FormService.Domain.Models.User_Form;
import com.example.FormService.Domain.Repos.FormRepo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FormServiceTest {
    @Mock
    private FormRepo formRepo;
    @InjectMocks
    private FormService formService;
    private Sex sex;
    private Sex interestedsex;
    private List<Hobby> hobbies;
    private Sexual_Orientation sexualOrientation;
    private User_Form user_form;
    public void setup(){
        sex = new Sex();
        sex.setId(1);
        sex.setTitle("Male");
        interestedsex = sex;
        hobbies.add(Hobby.builder().hobby_name("Swimming").id(1).build());
        sexualOrientation = Sexual_Orientation.builder().id(1).name("Natural").build();
        user_form = User_Form.builder()
                .id(1)
                .name("Chuchkevic Sergey")
                .sex(sex)
                .owner_id(2)
                .date_birth(Date.valueOf("29.10.2002"))
                .sexualorientation(sexualOrientation)
                .hobbyList(hobbies)
                .interestedsex(interestedsex)
                .build();
    }
}

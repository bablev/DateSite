package com.example.FormService.DTO;

import com.example.FormService.Domain.Models.Hobby;
import com.example.FormService.Domain.Models.Sex;
import com.example.FormService.Domain.Models.Sexual_Orientation;
import com.example.FormService.Domain.Models.User_Form;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
public class FormResponseDTO extends FormDTO {
    private int owner_id;
    @NotBlank(message = "Please provide a name")
    private String name;
    @Min(value = 18, message = "Age should not be less than 18")
    private int age;
    @NotNull(message = "Please provide a date birth")
    private java.sql.Date date_birth;
    @NotNull(message = "Please provide a sex")
    private Sex sex;
    @NotNull(message = "Please provide an interested sex")
    private Sex interestedSex;
    @NotNull(message = "Please provide a sexual orientation")
    private Sexual_Orientation sexualOrientation;
    private List<Hobby> hobbyList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public Date getDate_birth() {
        return date_birth;
    }

    public void setDate_birth(Date date_birth) {
        this.date_birth = date_birth;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Sex getInterestedSex() {
        return interestedSex;
    }

    public void setInterestedSex(Sex interestedSex) {
        this.interestedSex = interestedSex;
    }

    public Sexual_Orientation getSexualOrientation() {
        return sexualOrientation;
    }

    public void setSexualOrientation(Sexual_Orientation sexualOrientation) {
        this.sexualOrientation = sexualOrientation;
    }

    public List<Hobby> getHobbyList() {
        return hobbyList;
    }

    public void setHobbyList(List<Hobby> hobbyList) {
        this.hobbyList = hobbyList;
    }
    public FormResponseDTO(User_Form user_form, Sex interestedSex, Sex sex, List<Hobby> hobbies){
        this.age = user_form.getAge();
        this.date_birth = user_form.getDate_birth();
        this.name = user_form.getName();
        this.owner_id = user_form.getOwner_id();
        this.sex = sex;
        this.hobbyList = hobbies;
        this.interestedSex = interestedSex;
    }
}

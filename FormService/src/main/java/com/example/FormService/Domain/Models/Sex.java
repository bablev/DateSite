package com.example.FormService.Domain.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Entity
@AllArgsConstructor
@Builder
public class Sex {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "sex_name")
    private String sex_name;
    @JsonIgnore
    @OneToMany(mappedBy = "sex")
    private List<User_Form> user_sex_formList;
    @JsonIgnore
    @OneToMany(mappedBy = "interestedsex")
    private List<User_Form> user_interestedsex_formList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSex_name() {
        return sex_name;
    }

    public void setSex_name(String sex_name) {
        this.sex_name = sex_name;
    }

    public List<User_Form> getUser_sex_formList() {
        return user_sex_formList;
    }

    public void setUser_sex_formList(List<User_Form> user_sex_formList) {
        this.user_sex_formList = user_sex_formList;
    }

    public List<User_Form> getUser_interestedsex_formList() {
        return user_interestedsex_formList;
    }

    public void setUser_interestedsex_formList(List<User_Form> user_interestedsex_formList) {
        this.user_interestedsex_formList = user_interestedsex_formList;
    }

    public Sex(String sex_name, int id){
        this.sex_name = sex_name;
        this.id = id;
    }

}

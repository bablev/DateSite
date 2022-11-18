package com.example.FormService.Domain.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Sexual_Orientation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "orientation_name", length = 20)
    private String name;
    @JsonIgnore
    @OneToMany(mappedBy = "sexualorientation")
    private List<User_Form> formsList;
    public Sexual_Orientation(String name, int id){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User_Form> getFormsList() {
        return formsList;
    }

    public void setFormsList(List<User_Form> formsList) {
        this.formsList = formsList;
    }
}

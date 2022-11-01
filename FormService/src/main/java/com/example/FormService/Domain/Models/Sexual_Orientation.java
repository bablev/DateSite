package com.example.FormService.Domain.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Sexual_Orientation {
    @Id
    private int id;
    @Column(name = "orientation_name", length = 20)
    private String name;
    @OneToMany(mappedBy = "sexualorientation")
    private List<User_Form> formsList;
}

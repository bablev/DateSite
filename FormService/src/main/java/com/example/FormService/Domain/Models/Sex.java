package com.example.FormService.Domain.Models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Sex {
    @Id
    private int id;
    @Column(name = "sex_name")
    private String title;
    @OneToMany(mappedBy = "sex")
    private List<User_Form> user_sex_formList;
    @OneToMany(mappedBy = "interestedsex")
    private List<User_Form> user_interestedsex_formList;
}

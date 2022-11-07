package com.example.FormService.Domain.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
    @OneToMany(mappedBy = "sexualorientation")
    private List<User_Form> formsList;

}

package com.example.FormService.Domain.Models;

import javax.persistence.*;

@Entity
@Table(name = "hobby")
public class Hobby {
    @Id
    private int id;
    @Column(name = "Hobby_name", length = 20)
    private String hobby_name;
}

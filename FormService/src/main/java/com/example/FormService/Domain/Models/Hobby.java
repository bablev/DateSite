package com.example.FormService.Domain.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hobby")
public class Hobby {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "Hobby_name", length = 20)
    private String hobby_name;
    public Hobby(String hobby_name, int id){
        this.hobby_name = hobby_name;
        this.id = id;
    }

}

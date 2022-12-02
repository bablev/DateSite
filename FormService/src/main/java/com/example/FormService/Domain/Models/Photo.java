package com.example.FormService.Domain.Models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Data
@Entity
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "form_generator")
    @SequenceGenerator(name="form_generator", sequenceName = "form_seq")
    private int id;
    private int photo_id;
    @ManyToOne
    private User_Form user_form;
}

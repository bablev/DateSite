package com.example.FormService.Domain.Models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Data
@Entity
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(
            columnDefinition = "NUMERIC(19,0)"
    )
    private int id;
    private int photo_id;
}

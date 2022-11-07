package com.example.FormService.Domain.Models;

import javax.persistence.*;
import java.util.List;
@Entity
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(
            columnDefinition = "NUMERIC(19,0)"
    )
    private int id;
    private int photo_id;
    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getPhoto_id() {
        return photo_id;
    }

    public void setPhoto_id(int photo_id) {
        this.photo_id = photo_id;
    }


}

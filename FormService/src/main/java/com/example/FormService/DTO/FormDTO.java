package com.example.FormService.DTO;

import lombok.Data;
import org.hibernate.annotations.NotFound;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class FormDTO {
    private int owner_id;
    @NotEmpty(message = "Please provide a name")
    private String name;
    private java.sql.Date date_birth;
    @NotEmpty(message = "Please provide a sex")
    private String sex;
    @NotEmpty(message = "Please provide a interested sex")
    private String interestedSex;
    private String sexualOrientation;
    private List<String> hobbie s;
}

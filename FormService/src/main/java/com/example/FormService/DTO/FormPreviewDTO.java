package com.example.FormService.DTO;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


public class FormPreviewDTO extends FormDTO {
    @NotBlank(message = "Please provide a name")
    private String name;
    @Min(value = 18, message = "Age should not be less than 18")
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

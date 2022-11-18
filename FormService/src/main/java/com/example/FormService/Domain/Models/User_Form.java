package com.example.FormService.Domain.Models;

import com.example.FormService.Domain.Models.Hobby;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
@TypeDef(
        name = "pgsql_enum",
        typeClass = PostgreSQLEnumType.class
)
@Builder
@Table(name = "user_form")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User_Form {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "owner_id")
    private int owner_id;
    @Column(name = "name", length = 50)
    private String name;
    @Column(name = "date_birth")
    private java.sql.Date date_birth;
    @ManyToOne(fetch = FetchType.LAZY)
    private Sex sex;
    @ManyToOne(fetch = FetchType.LAZY)
    private Sex interestedsex;
    @JoinTable(name = "user_formshobbies",
            joinColumns = @JoinColumn(name = "user_formid"),
            inverseJoinColumns = @JoinColumn(name = "hobbyid")
    )
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Hobby> hobbyList;
    @ManyToOne(fetch = FetchType.LAZY)
    private Sexual_Orientation sexualorientation;
    @Column(name = "updated_at")
    private java.sql.Timestamp updated_at;

    public enum Status {
        Active,
        Inactive,
        Deleted
    }

    @Enumerated(EnumType.STRING)
    @Type(type = "pgsql_enum")
    @Column(name = "Status")
    private Status status;
}
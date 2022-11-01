package com.example.FormService.Domain.Models;

import com.example.FormService.Domain.Models.Hobby;
import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.List;
@TypeDef(
        name = "pgsql_enum",
        typeClass = PostgreSQLEnumType.class
)
@Table(name = "user_form")
@Entity
public class User_Form {
    @Id
    private int id;
    @Column(name = "owner_id")
    private int owner_id;
    @Column(name = "name", length = 50)
    private String name;
    @Column(name = "date_birth")
    private java.sql.Date date_birth;
    @ManyToOne
    private Sex sex;
    @ManyToOne
    private Sex interestedsex;
    @JoinTable(name = "user_formshobbies",
            joinColumns = @JoinColumn(name = "user_formid"),
            inverseJoinColumns = @JoinColumn(name = "hobbyid")
    )
    @ManyToMany
    private List<Hobby> hobbyList;
    @ManyToOne
    private Sexual_Orientation sexualorientation;
    @Column(name = "updated_at")
    private java.sql.Timestamp updated_at;
    public enum Status{
        Active,
        Inactive,
        Deleted
    }
    @Enumerated(EnumType.ORDINAL)
    @Type(type = "pgsql_enum")
    @Column(name = "Status")
    private Status status;
}

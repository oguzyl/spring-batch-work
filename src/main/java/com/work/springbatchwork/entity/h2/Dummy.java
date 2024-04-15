package com.work.springbatchwork.entity.h2;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "DUMMY")
@Data
public class Dummy {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "AGE")
    private int age;

}

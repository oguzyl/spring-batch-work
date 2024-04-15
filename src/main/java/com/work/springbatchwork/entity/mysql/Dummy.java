package com.work.springbatchwork.entity.mysql;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "DUMMY")
@Data
public class Dummy {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    @Id
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "AGE")
    private int age;

}

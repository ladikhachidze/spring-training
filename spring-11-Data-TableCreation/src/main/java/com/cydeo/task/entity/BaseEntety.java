package com.cydeo.task.entity;

import com.cydeo.enums.Gender;

import javax.persistence.*;
import java.time.LocalDate;

@MappedSuperclass
public class BaseEntety {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;



}

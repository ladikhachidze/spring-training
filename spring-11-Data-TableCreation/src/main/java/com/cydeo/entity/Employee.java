package com.cydeo.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity // directly takes class and creates the table in the DB
public class Employee {


    @Id // primary key annotation
    private int id;
    private String firstName;
    private String lastName;



}

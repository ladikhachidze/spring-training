package com.cydeo.task.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Departments extends BaseEntety {

    private String department;
    private String division;

}

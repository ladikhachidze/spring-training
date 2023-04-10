package com.cydeo.task.entity.bootstrap;

import com.cydeo.enums.Gender;
import com.cydeo.task.entity.Departments;
import com.cydeo.task.entity.EmployeeTask;
import com.cydeo.task.entity.repo.DepartmentRepo;
import com.cydeo.task.entity.repo.EmployeeRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataGeneratorAV implements CommandLineRunner {

    private final EmployeeRepo employeeRepo;
    private final DepartmentRepo departmentRepo;

    public DataGeneratorAV(EmployeeRepo employeeRepo, DepartmentRepo departmentRepo) {
        this.employeeRepo = employeeRepo;
        this.departmentRepo = departmentRepo;
    }

    List<EmployeeTask> employeeTaskList = new ArrayList<>();
    List<Departments> departmentsList = new ArrayList<>();

    @Override
    public void run(String... args) throws Exception {


        EmployeeTask e1 = new EmployeeTask("Berrie", "Manueau", "bmanueau0@dion.ne.jp", LocalDate.of(2006,04,20), Gender.FEMALE, 2500);
        EmployeeTask e2 = new EmployeeTask("Aeriell", "McNee", "amcnee1@google.es", LocalDate.of(2009,01,26),Gender.FEMALE, 2500);
        EmployeeTask e3 = new EmployeeTask("Sydney", "Symonds", "ssymonds2@hhs.gov", LocalDate.of(2010,05,17), Gender.FEMALE, 2500);
        EmployeeTask e4 = new EmployeeTask("Avrom", "Rowantree", null, LocalDate.of(2014,03,02), Gender.MALE, 2500);
        EmployeeTask e5 = new EmployeeTask("Feliks", "Morffew", "fmorffew4@a8.net", LocalDate.of(2003,01,14), Gender.MALE, 2500);

        Departments d1 = new Departments("Sports", "Outdoors");
        Departments d2 = new Departments("Tools", "Hardware");
        Departments d3 = new Departments("Clothing", "Home");
        Departments d4 = new Departments("Phones & Tablets", "Electronics");
        Departments d5 = new Departments("Computers", "Electronics");


        employeeTaskList.addAll(Arrays.asList(e1,e2,e3,e4,e5));
        departmentsList.addAll(Arrays.asList(d1,d2,d3,d4,d5));

        employeeRepo.saveAll(employeeTaskList);
        departmentRepo.saveAll(departmentsList);




    }
}

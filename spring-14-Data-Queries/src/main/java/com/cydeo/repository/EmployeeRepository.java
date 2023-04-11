package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {


    List<Employee> findByEmail(String email);

    List<Employee> findByFirstNameAndLastNameOrEmail(String firstName,String lastName, String email);

    List<Employee> findByFirstNameIsNot(String firstName);

    List<Employee> findByLastNameStartingWith(String lastNameStartsWith);

    List<Employee> findBySalaryGreaterThan(Integer salary);

    List<Employee> findBySalaryLessThan(Integer salary);

    List<Employee> findByHireDateBetween(LocalDate start, LocalDate end);

    List<Employee> findBySalaryIsGreaterThanEqualOrderBySalary(Integer salary);

    List<Employee> findTop3BySalaryLessThan(Integer salary);

    List<Employee> findByEmailIsNull();



    @Query("SELECT employee from Employee employee where employee.email='bmanueau0@dion.ne.jp'")
    Employee retrieveEmployeeDetail();

    @Query("select e.salary from Employee e where  e.email='bmanueau0@dion.ne.jp'")
    Employee retriveEmployeeSalary();





}

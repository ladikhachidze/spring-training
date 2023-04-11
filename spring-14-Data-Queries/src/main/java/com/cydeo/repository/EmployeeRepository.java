package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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


    @Query("select e from Employee e where e.salary <> ?1")
    List<Employee> retriveEmployeeSalaryNotEqual(int salary);

    @Query("select e from Employee e where e.firstName like ?1")
    List<Employee> retriveEmployeeFirstNameLike(String pattern);

    @Query("select e from Employee e where e.salary < ?1")
    List<Employee> retriveEmplyeeSalaryLessThen(int salary);

    @Query("select e from Employee e where e.salary > ?1")
    List<Employee> retriveEmplyeeSalaryGreaterThen(int salary);


    @Query("select e from Employee e where e.salary between ?1 and ?2 ")
    List<Employee> retriveEmplyeeSalaryBetween(int salary1,int salary2);

    @Query("select e from Employee e where e.hireDate > ?1")
    List<Employee> retriveEmplyeeHireDateBefore(LocalDate date);


    @Query("select e from Employee e where e.email is null ")
    List<Employee> retrieveEmployeeIsNull();


    @Query("select e from Employee e where e.email is Not null ")
    List<Employee> retrieveEmployeeIsNotNull();


    @Query("select e from Employee e order by e.salary")
    List<Employee> retrieveEmployeeSalaryOrderAsc();

    @Query("select e from Employee e order by e.salary desc")
    List<Employee> retrieveEmployeeSalaryOrderDesc();

    //Native Query
    @Query(value = "SELECT * FROM employees WHERE salary = ?1", nativeQuery = true)
    List<Employee> retrieveEmployeeDitailBySalary(int salary);


    @Query("select e from Employee e where e.salary = :salary")
    List<Employee> retrieveEmployeeSalary(@Param("salary")int salary);





}

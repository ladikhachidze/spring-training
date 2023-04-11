package com.cydeo.repository;

import com.cydeo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface DepartmentRepository extends JpaRepository<Department,String> {

    List<Department> findByDepartment(String department);
    List<Department> findByDivision(String division);
    List<Department> findByDivisionIs(String division);

    List<Department> findByDivisionEndsWith(String pattern);

    List<Department> findDistinctTop3ByDivisionContains(String division);


    @Query("select d from Department d where d.division in ?1")
    List<Department> retrieveDepartmentDivision(List<String> division);

}

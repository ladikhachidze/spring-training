package com.cydeo.task.entity.repo;

import com.cydeo.task.entity.Departments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;

@Repository
public interface DepartmentRepo extends JpaRepository<Departments,Integer> {
}

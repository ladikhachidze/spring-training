package com.cydeo.task.entity.repo;

import com.cydeo.task.entity.EmployeeTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeTask,Integer> {


}

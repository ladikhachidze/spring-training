package com.cydeo.controller;


import com.cydeo.dto.CourseDTO;
import com.cydeo.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses/api/v1")
public class CourseController {

    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }


    @GetMapping
    public List<CourseDTO> getAllCourses(){

        return courseService.getCourses();
    }


    @GetMapping("{id}")
    public CourseDTO getCourseById(@PathVariable("id") Long courseId){

        return courseService.getCourseById(courseId);
    }


    @GetMapping("category/{name}")
    public List<CourseDTO> getCourseByName(@PathVariable("name") String catName){

        return courseService.getCoursesByCategory(catName);
    }



    @PostMapping
    public CourseDTO createCourse(@RequestBody CourseDTO course){

        return courseService.createCourse(course);
    }


    @PutMapping("{id}")
    public void updateCourse(@PathVariable("id") Long courseId,@RequestBody CourseDTO course){

        courseService.updateCourse(courseId,course);
    }


    @DeleteMapping("{id}")
    public void deleteCourseById(@PathVariable("id") Long courseId){

        courseService.deleteCourseById(courseId);

    }

}

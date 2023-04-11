package com.cydeo;

import com.cydeo.repository.DepartmentRepository;
import com.cydeo.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class QueryDemo implements CommandLineRunner {
private final RegionRepository regionRepository;
private final DepartmentRepository departmentRepository;

    public QueryDemo(RegionRepository regionRepository, DepartmentRepository departmentRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        System.out.println("-----------------------Regions-----------------------");

        System.out.println("findByCountry: "+regionRepository.findByCountry("Canada"));

        System.out.println(regionRepository.findByCountryContaining("United"));

        System.out.println("findByCountryContainsOrderByRegionDesc: "+regionRepository.findByCountryContainsOrderByRegionDesc("United"));
        System.out.println("findTopByCountry "+regionRepository.findTop2ByCountry("United States"));

        System.out.println("findTopByCountry "+regionRepository.findTopByCountryContainsOrderByRegion("United States"));


        System.out.println("-----------------------Departmenrs-----------------------");

        System.out.println("findByDepartment "+departmentRepository.findByDepartment("Furniture"));
        System.out.println("findByDivision "+departmentRepository.findByDivision("Health"));
        System.out.println("findByDivisionEndsWith "+departmentRepository.findByDivisionEndsWith("ics"));
        System.out.println("findDistinctTop3ByDivisionContains "+departmentRepository.findDistinctTop3ByDivisionContains("Hea"));





    }
}

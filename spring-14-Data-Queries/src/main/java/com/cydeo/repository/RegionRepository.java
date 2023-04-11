package com.cydeo.repository;

import com.cydeo.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;


public interface RegionRepository extends JpaRepository<Region,Integer> {



    List<Region> findByCountry(String country);
    List<Region> getByCountry(String country);


    List<Region> findByCountryContaining(String country);

    List<Region> findByCountryContainsOrderByRegionDesc(String country);

    List<Region> findTop2ByCountry(String country);

    List<Region> findTopByCountryContainsOrderByRegion(String country);


}

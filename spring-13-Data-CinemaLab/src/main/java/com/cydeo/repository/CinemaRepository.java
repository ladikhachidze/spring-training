package com.cydeo.repository;

import com.cydeo.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to get cinema with a specific name
    Optional<Cinema> findByName(String name);

    //Write a derived query to read sorted the top 3 cinemas that contains a specific sponsored name
    List<Cinema> findFirst3BySponsoredNameContainingOrderBySponsoredName(String name);


    //Write a derived query to list all cinemas in a specific country
    List<Cinema> findAllByLocationCountry(String country);


    //Write a derived query to list all cinemas with a specific name or sponsored name
    List<Cinema> findAllByNameOrSponsoredName(String name, String sponsoredName);


    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to read the cinema name with a specific id

    @Query("select c from Cinema c where c.id = ?1")
    String fetchById(@Param("id") Long id);


    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all cinemas by location country
    @Query(value = "SELECT * FROM cinema c JOIN l", nativeQuery = true)
    List<Cinema> getAllCinemasByLocation(@Param("location") String location);


    //Write a native query to read all cinemas by name or sponsored name contains a specific pattern
    @Query(value = "select * from cinema where lower(name) LIKE concat('%', ?1,'%')", nativeQuery = true)
    List<Cinema> retrieveAllByNameOrSponsoredName(@Param("pattern") String pattern);


    //Write a native query to sort all cinemas by name


    //Write a native query to distinct all cinemas by sponsored name


}
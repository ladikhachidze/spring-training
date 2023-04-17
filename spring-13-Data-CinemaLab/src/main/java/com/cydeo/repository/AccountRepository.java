package com.cydeo.repository;

import com.cydeo.entity.Account;
import com.cydeo.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to list all accounts with a specific country or state

    List<Account> findByCountryOrState(String country,String state);

    //Write a derived query to list all accounts with age lower than or equal to a specific value
    List<Account> findByAgeLessThanEqual(Integer age);


    //Write a derived query to list all accounts with a specific role
    List<Account> findByRole(UserRole role);


    //Write a derived query to list all accounts between a range of ages

    List<Account> findByAgeBetween(Integer ageStart, Integer ageEnd);



    //Write a derived query to list all accounts where the beginning of the address contains the keyword
    List<Account> findByAddressStartsWith(String address);


    //Write a derived query to sort the list of accounts with age

    List<Account> findAllByOOrderByAgeDesc();

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all accounts
    @Query("select c from Account c")
    List<Account> listOfAllAccount();


    //Write a JPQL query to list all admin accounts

    @Query("select c from Account c where c.role = 'ADMIN'")
    List<Account> allAdminAccount();


    //Write a JPQL query to sort all accounts with age

    @Query("select c from Account c order by c.age desc ")
    List<Account> allAccountSort();


    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all accounts with an age lower than a specific value




    //Write a native query to read all accounts that a specific value can be containable in the name, address, country, state city


    //Write a native query to read all accounts with an age higher than a specific value


}

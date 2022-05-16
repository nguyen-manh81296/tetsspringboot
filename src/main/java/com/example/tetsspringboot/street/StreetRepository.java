package com.example.tetsspringboot.street;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StreetRepository extends JpaRepository <Street,Integer>{
    Page<Street> findAll(Pageable pageable);

    @Query(value = "SELECT * FROM streets p WHERE p.name like %:name% and p.descripton like %:description%",
            nativeQuery = true)
    List<Street> search(@Param("name") String name, @Param("description") String description);

    // Automatic Street Queries
    List<Street> findAllByNameContainsAndDistrictIdLessThanEqual(String name, String dir);

    @Query(value = "select  * from street s where s.name like %:name% and s.price<= :price",nativeQuery = true)
    List<Object[]> search(@Param("name")String name,@Param("price") double price);
}

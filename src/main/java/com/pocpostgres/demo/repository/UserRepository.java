package com.pocpostgres.demo.repository;

import com.pocpostgres.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByName(String Name);

    @Query(value = "select * from dbo.user where age > :age and money > :money", nativeQuery = true)
    List<User> findAllByAgeAndMoney(@Param("age") Integer age, @Param("money") BigDecimal money);

    @Query(value = "select * from dbo.user", nativeQuery = true)
    List<User> getAllData();

    @Query(value = "select * from dbo.user where roles ->> 'name' = :text", nativeQuery = true)
    List<User> getAllRoleName(@Param("text") String text );
}
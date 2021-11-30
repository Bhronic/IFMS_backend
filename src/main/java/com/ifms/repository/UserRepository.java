package com.ifms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ifms.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByPhone(String phone);

    Boolean existsByPhone(String phone);

    Boolean existsByEmail(String email);
    
    @Query("select u from User u inner join u.roles r where r.id = :id")
    List<User> findByRoles_Id(Integer id);
}

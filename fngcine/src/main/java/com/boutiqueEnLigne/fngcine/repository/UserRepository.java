package com.boutiqueEnLigne.fngcine.repository;

import com.boutiqueEnLigne.fngcine.entity.User;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Registered
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByLastName(String lastName);
    Optional<User> findByUsername(String username);
    Optional<User> findByFirstName(String firstName);
    Optional<User> findById(Long id);

    Boolean existsByLastName(String lastName);
    Boolean existsByFirstName(String firstName);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}

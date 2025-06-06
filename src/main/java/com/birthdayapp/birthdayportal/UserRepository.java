package com.birthdayapp.birthdayportal;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByNameAndPassword(String name, String password);
}

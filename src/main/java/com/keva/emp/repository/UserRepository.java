package com.keva.emp.repository;

import com.keva.emp.entity.Users;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByUserName(String userName);

    Optional<Users> findByUserNameAndStatus(@Email String userName, Integer id);

    boolean existsByUserName(@NotBlank(message = "Email is required") @Email(message = "Please enter a valid email address") String userName);
}

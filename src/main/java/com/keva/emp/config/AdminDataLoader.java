package com.keva.emp.config;

import com.keva.emp.entity.Users;
import com.keva.emp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdminDataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public void run(String... args) throws Exception {

        if (!userRepository.existsByUserName("admin@gmail.com")) {

            Users admin = new Users();
            admin.setUserName("admin@gmail.com");
            admin.setPassword(passwordEncoder.encode("Password@123"));
            admin.setStatus(1);

            userRepository.save(admin);
        }
    }
}

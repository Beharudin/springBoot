package com.myjwt.myjwt.repository;

import com.myjwt.myjwt.model.JwtUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JwtRepository extends JpaRepository<JwtUser, Integer> {
    Optional<JwtUser> findByEmail(String email);

    void deleteByEmail(String email);

}

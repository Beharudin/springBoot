package com.myjwt.myjwt.repository;

import com.myjwt.myjwt.model.JwtUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JwtRepository extends JpaRepository<JwtUser, Integer> {
}

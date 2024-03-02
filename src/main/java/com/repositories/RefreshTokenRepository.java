package com.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schoolmanagement.entities.RefreshToken;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken,String> {

	Optional<RefreshToken> findByRefreshToken(String token);
}

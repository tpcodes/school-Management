package com.schoolmanagement.Service;

import java.time.Instant;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repositories.RefreshTokenRepository;
import com.repositories.UserRepository;
import com.schoolmanagement.entities.RefreshToken;
import com.schoolmanagement.entities.User;

@Service
public class RefreshTokenService {

	public long refreshTokenValidity=7*24*60*60*1000;
	
	@Autowired
	private RefreshTokenRepository refreshTokenRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	public RefreshToken createRefreshToken(String userName)
	{
		
		User user=userRepository.findByEmail(userName);
		RefreshToken refreshToken1=user.getRefreshToken();
		if(refreshToken1==null)
		{
			refreshToken1=RefreshToken.builder().refreshToken(UUID.randomUUID().toString())
					.expiry(Instant.now().plusMillis(refreshTokenValidity))
					.user(userRepository.findByEmail(userName))
					.build();
			
		}
		else
		{
			refreshToken1.setExpiry(Instant.now().plusMillis(refreshTokenValidity));
		}
		user.setRefreshToken(refreshToken1);
		
		
		refreshTokenRepository.save(refreshToken1);
		return refreshToken1;
	}
	
	public RefreshToken verifyRefreshToken(String refreshToken)
	{
		RefreshToken refreshTokenOb=refreshTokenRepository.findByRefreshToken(refreshToken).orElseThrow(()->new RuntimeException("Given token does not exist in db!"));
		if(refreshTokenOb.getExpiry().compareTo(Instant.now())<0)
		{
			refreshTokenRepository.delete(refreshTokenOb);
			throw new RuntimeException("Refresh token expired!!");
		}
		
		return refreshTokenOb;
	}
}

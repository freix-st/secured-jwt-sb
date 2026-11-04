package com.freixst.securedjwt.security;

import java.util.Base64;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

@Component 
public class JwtUtil {
    private final SecretKeySpec SECRET_KEY;

    public JwtUtil(
        @Value("${jwt.secret.key}")
        String privateKeyBase64) {
        
        byte[] privateKeyBytes = Base64.getDecoder().decode(privateKeyBase64);
        this.SECRET_KEY = new SecretKeySpec(privateKeyBytes, "HmacSHA256");
    }

    public String generateToken(String username) {
        return Jwts.builder()
            .subject(username)
            .issuedAt(new Date())
            .expiration(new Date(System.currentTimeMillis() + 1000 * 60  * 60))
            .signWith(SECRET_KEY)
            .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parser()
            .verifyWith(SECRET_KEY)
            .build()
            .parseSignedClaims(token)
            .getPayload()
            .getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                .verifyWith(SECRET_KEY)
                .build()
                .parseSignedClaims(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }
}

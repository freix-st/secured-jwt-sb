package com.freixst.securedjwt.security;

import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {
    private final String SECRET_KEY = System.getProperty("jwt.secret.key");

    public String generateToken(String username) {
        return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60  * 60))
            .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
            .compact();
    }
}

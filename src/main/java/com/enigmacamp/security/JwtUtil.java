package com.enigmacamp.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.enigmacamp.model.entity.AppUser;
import org.hibernate.type.descriptor.java.ObjectJavaType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.validation.ObjectError;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class JwtUtil {
    @Value("${app.loan-system.jwt.jwt-secret}")
    private String jwtSecret;
    @Value("${app.loan-system.jwt.app.name")
    private String appName;
    @Value("${app.loan-system.jwt.expired}")
    private long jwtExpiration;

    public String generateToken(AppUser appUser) {
        Algorithm algorithm = Algorithm.HMAC256(jwtSecret.getBytes(StandardCharsets.UTF_8));
        return JWT.create()
                .withIssuer(appName)
                .withSubject(appUser.getId())
                .withExpiresAt(Instant.now().plusSeconds(jwtExpiration))
                .withIssuedAt(Instant.now())
                // FIXME: list of roles https://stackoverflow.com/questions/75608603/issue-with-extracting-role-claim-from-jwt-token-in-spring-api
                .withClaim("roles", appUser.getRoles().toString())
                .sign(algorithm);
    }

    public boolean verifyJwtToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(jwtSecret.getBytes(StandardCharsets.UTF_8));
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = verifier.verify(token);
        return decodedJWT.getIssuer().equals(appName);
    }

    public Map<String, Object> getUserInfoByToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(jwtSecret.getBytes(StandardCharsets.UTF_8));
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT decodedJWT = verifier.verify(token);

            Map<String, Object> userInfo = new HashMap<>();
            userInfo.put("userId", decodedJWT.getSubject());
            userInfo.put("roles", decodedJWT.getClaim("roles"));

            return userInfo;
        } catch (JWTVerificationException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}

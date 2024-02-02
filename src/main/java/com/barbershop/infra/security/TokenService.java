package com.barbershop.infra.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.IncorrectClaimException;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.MissingClaimException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.barbershop.domain.user.User;


@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(User user) {

        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("Barbershop api")
                    .withSubject(user.getEmail())
                    .withClaim("userId", user.getId().toString())
                    .withExpiresAt(this.generateExpirationDate())
                    .sign(algorithm);
        } catch (JWTCreationException e) {
            throw new RuntimeException("Error while generating token: " + e);
        } catch (IllegalArgumentException  e) {
            throw new RuntimeException("Error Generico: " + e);
        } catch (Exception e) {
            throw new RuntimeException("Error Generico: " + e);
        }
        
    }
   
    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("Barbershop api")
                    .build()
                    .verify(token)
                    .getSubject();

        } catch (IllegalArgumentException  e) {
            return "";
        } catch (AlgorithmMismatchException  e) {
            return "";
        } catch (SignatureVerificationException  e) {
            return "";
        } catch (TokenExpiredException  e) {
            return "";
        } catch (MissingClaimException  e) {
            return "";
        } catch (IncorrectClaimException  e) {
            return "";
        } catch (JWTVerificationException  e) {
            return "";
        }
    }

    private Instant generateExpirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

    public UUID getLoggedUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User userDetails = (User) authentication.getPrincipal();
        return userDetails.getId();
    }

}
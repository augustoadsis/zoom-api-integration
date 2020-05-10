package com.augusto.zoom.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Slf4j
@Service
public class AuthService {

    @Value("${zoom.apiKey}")
    private String apiKey;

    @Value("${zoom.apiSecret}")
    private String apiSecret;

    public String auth() {
        try {
                Algorithm algorithm = Algorithm.HMAC256(apiSecret);
                Date date = Date.from(LocalDate.now().plusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant());
                String token = JWT.create()
                        .withIssuer(apiKey)
                        .withExpiresAt(date)
                        .sign(algorithm);
            log.info(token);
            return token;
        } catch (JWTCreationException exception){
            log.error(exception.getMessage());
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
    }

    public HttpHeaders generateHeader() {
        String token = auth();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer "+token );
        return headers;
    }
}

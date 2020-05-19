package com.augusto.zoom.user;

import com.augusto.zoom.auth.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class UserService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AuthService authService;

    @Value("${zoom.endpoint.baseUri}")
    private String baseUri;

    @Value("${zoom.endpoint.users}")
    private String usersPath;

    public ResponseEntity<Object> fildAll() {
        try {
            HttpHeaders headers = authService.generateHeader();
            HttpEntity request = new HttpEntity(headers);
            ResponseEntity<Object> meetings = restTemplate.exchange(baseUri + usersPath, HttpMethod.GET, request, Object.class);
            return meetings;
        } catch (Exception exception) {
            log.error(exception.getMessage());
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
    }

    public UserResponse create(UserRequest userRequest) {
        try {
            HttpHeaders headers = authService.generateHeader();
            HttpEntity<UserRequest> request = new HttpEntity<>(userRequest, headers);
            UserResponse subaccount = restTemplate.postForObject(baseUri + usersPath, request, UserResponse.class);
            return subaccount;
        } catch (Exception exception) {
            log.error(exception.getMessage());
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
    }
}

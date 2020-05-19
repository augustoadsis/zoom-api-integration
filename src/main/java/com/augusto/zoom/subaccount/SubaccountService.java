package com.augusto.zoom.subaccount;

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
public class SubaccountService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AuthService authService;

    @Value("${zoom.endpoint.baseUri}")
    private String baseUri;

    @Value("${zoom.endpoint.subaccounts}")
    private String subaccountPath;

    public ResponseEntity<Object> fildAll() {
        try {
            HttpHeaders headers = authService.generateHeader();
            HttpEntity request = new HttpEntity(headers);
            ResponseEntity<Object> meetings = restTemplate.exchange(baseUri + subaccountPath, HttpMethod.GET, request, Object.class);
            return meetings;
        } catch (Exception exception) {
            log.error(exception.getMessage());
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
    }

    public SubaccountResponse create(SubaccountRequest subaccountRequest) {
        try {
            HttpHeaders headers = authService.generateHeader();
            HttpEntity<SubaccountRequest> request = new HttpEntity<>(subaccountRequest, headers);
            SubaccountResponse subaccount = restTemplate.postForObject(baseUri + subaccountPath, request, SubaccountResponse.class);
            return subaccount;
        } catch (Exception exception) {
            log.error(exception.getMessage());
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
    }
}

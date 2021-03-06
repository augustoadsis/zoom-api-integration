package com.augusto.zoom.meeting;

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
public class MeetingService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AuthService authService;

    @Value("${zoom.endpoint.baseUri}")
    private String baseUri;

    @Value("${zoom.endpoint.users}")
    private String usersPath;

    @Value("${zoom.endpoint.meetings}")
    private String meetingsPath;

    public ResponseEntity<Object> fildAll() {
        try {
            HttpHeaders headers = authService.generateHeader();
            HttpEntity request = new HttpEntity(headers);
            ResponseEntity<Object> meetings = restTemplate.exchange(baseUri + meetingsPath, HttpMethod.GET, request, Object.class);
            return meetings;
        } catch (Exception exception) {
            log.error(exception.getMessage());
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
    }

    public MeetingResponse schedule(String id, MeetingRequest meetingRequest) {
        try {
            HttpHeaders headers = authService.generateHeader();
            HttpEntity<MeetingRequest> request = new HttpEntity<>(meetingRequest, headers);
            MeetingResponse meeting = restTemplate.postForObject(baseUri + usersPath + "/" + id + meetingsPath, request, MeetingResponse.class);
            return meeting;
        } catch (Exception exception) {
            log.error(exception.getMessage());
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
    }
}

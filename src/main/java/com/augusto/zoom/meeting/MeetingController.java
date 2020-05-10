package com.augusto.zoom.meeting;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/meetings")
@Slf4j
public class MeetingController {

    @Autowired
    MeetingService meetingService;

    @GetMapping
    public ResponseEntity<Object> findAll() {
        return meetingService.fildAll();
    }

    @PostMapping
    public ResponseEntity<Object> schedule(@RequestBody MeetingRequest request) {
        MeetingResponse meeting = meetingService.schedule(request);
        return ResponseEntity.status(HttpStatus.OK).body(meeting);
    }

}

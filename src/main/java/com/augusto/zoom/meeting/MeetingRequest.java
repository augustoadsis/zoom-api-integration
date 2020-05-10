package com.augusto.zoom.meeting;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MeetingRequest {

    private String topic;
    private Integer type;
    private String start_time;
    private Integer duration;
    private String timezone;
    private String password;
    private String agenda;
    private Settings settings;
}

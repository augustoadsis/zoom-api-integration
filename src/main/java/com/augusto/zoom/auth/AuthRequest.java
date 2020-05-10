package com.augusto.zoom.auth;

import com.augusto.zoom.meeting.Settings;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {

    private String topic;
    private Integer type;
    private String start_time;
    private Integer duration;
    private String timezone;
    private String password;
    private String agenda;
    private Settings settings;
}

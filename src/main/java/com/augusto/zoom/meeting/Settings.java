package com.augusto.zoom.meeting;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Settings {

    private Boolean host_video;
    private Boolean participant_video;
    private Boolean join_before_host;
    private Boolean mute_upon_entry;
    private Boolean watermark;
    private Boolean use_pmi;
    private float approval_type;
    private String audio;
    private String auto_recording;
    private Boolean enforce_login;
    private Boolean registrants_email_notification;
}

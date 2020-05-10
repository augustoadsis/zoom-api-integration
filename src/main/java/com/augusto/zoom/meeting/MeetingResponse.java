package com.augusto.zoom.meeting;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MeetingResponse {

    private String created_at;
    private Integer duration;
    private String host_id;
    private Long id;
    private String join_url;
    private String start_time;
    private String start_url;
    private String status;
    private String timezone;
    private String topic;
    private Integer type;
    private String uuid;

}

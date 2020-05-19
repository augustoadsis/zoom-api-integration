package com.augusto.zoom.subaccount;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Options {

    private Boolean share_rc;
    private String room_connectors;
    private Boolean share_mc;
    private String meeting_connectors;
    private String pay_mode;
}

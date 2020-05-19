package com.augusto.zoom.user;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private String action;
    private UserInfo user_info;
}

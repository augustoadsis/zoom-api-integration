package com.augusto.zoom.user;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {

    private String email;
    private String first_name;
    private String last_name;
    private Integer type;
}

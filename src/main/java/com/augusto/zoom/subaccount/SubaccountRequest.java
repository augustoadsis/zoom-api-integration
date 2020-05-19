package com.augusto.zoom.subaccount;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubaccountRequest {

    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private Options options;
}

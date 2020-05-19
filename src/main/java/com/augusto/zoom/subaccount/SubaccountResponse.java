package com.augusto.zoom.subaccount;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubaccountResponse {

    private String id;
    private String owner_id;
    private String owner_email;
    private String created_at;

}

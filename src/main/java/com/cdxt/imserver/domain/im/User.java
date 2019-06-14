package com.cdxt.imserver.domain.im;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
    private String userName;

    private String passWord;

    private String nickName;
}

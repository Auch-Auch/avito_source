package com.voximplant.sdk.internal.proto;

import com.voximplant.sdk.internal.messaging.User;
public class MES_getUser extends WSMessageChat {
    public MES_getUser(String str, User user) {
        this.request_uuid = str;
        this.payload = user;
    }
}

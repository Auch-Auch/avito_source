package com.voximplant.sdk.internal.proto;

import com.voximplant.sdk.internal.messaging.User;
public class MES_editUser extends WSMessageChat {
    public MES_editUser(String str, User user) {
        this.request_uuid = str;
        this.payload = user;
    }
}

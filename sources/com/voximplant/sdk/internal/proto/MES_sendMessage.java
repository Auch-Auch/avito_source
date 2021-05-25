package com.voximplant.sdk.internal.proto;

import com.voximplant.sdk.internal.messaging.Message;
public class MES_sendMessage extends WSMessageChat {
    public MES_sendMessage(String str, Message message) {
        this.request_uuid = str;
        this.payload = message;
    }
}

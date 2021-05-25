package com.voximplant.sdk.internal.proto;

import com.voximplant.sdk.internal.messaging.Message;
public class MES_editMessage extends WSMessageChat {
    public MES_editMessage(String str, Message message) {
        this.request_uuid = str;
        this.payload = message;
    }
}

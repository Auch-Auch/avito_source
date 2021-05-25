package com.voximplant.sdk.internal.proto;

import com.voximplant.sdk.internal.messaging.Conversation;
public class MES_createConversation extends WSMessageChat {
    public MES_createConversation(String str, Conversation conversation) {
        this.request_uuid = str;
        this.payload = conversation;
    }
}

package com.voximplant.sdk.internal.proto;

import java.util.Map;
public class MES_leaveConversation extends WSMessageChat {
    public MES_leaveConversation(String str, Map<String, Object> map) {
        this.request_uuid = str;
        this.payload = map;
    }
}

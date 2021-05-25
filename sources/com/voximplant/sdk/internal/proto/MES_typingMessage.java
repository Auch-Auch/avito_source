package com.voximplant.sdk.internal.proto;

import java.util.Map;
public class MES_typingMessage extends WSMessageChat {
    public MES_typingMessage(String str, Map<String, Object> map) {
        this.request_uuid = str;
        this.payload = map;
    }
}

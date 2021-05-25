package com.voximplant.sdk.internal.proto;

import java.util.Map;
public class MES_addParticipants extends WSMessageChat {
    public MES_addParticipants(String str, Map<String, Object> map) {
        this.request_uuid = str;
        this.payload = map;
    }
}

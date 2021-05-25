package com.voximplant.sdk.internal.proto;

import java.util.Map;
public class MES_subscribe extends WSMessageChat {
    public MES_subscribe(String str, Map<String, Object> map) {
        this.request_uuid = str;
        this.payload = map;
    }
}

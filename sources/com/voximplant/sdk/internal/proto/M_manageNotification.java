package com.voximplant.sdk.internal.proto;

import java.util.Map;
public class M_manageNotification extends WSMessageChat {
    public M_manageNotification(String str, Map<String, Object> map) {
        this.request_uuid = str;
        this.payload = map;
    }
}

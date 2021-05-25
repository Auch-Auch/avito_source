package com.voximplant.sdk.internal.proto;

import java.util.Map;
public class M_pushFeedback extends WSMessagePush {
    public M_pushFeedback(Map<String, String> map) {
        this.params.add(map);
    }
}

package com.voximplant.sdk.internal.proto;

import java.util.LinkedHashMap;
import java.util.Map;
import org.webrtc.SessionDescription;
public class M_ReInvite extends WSMessageCall {
    public M_ReInvite(String str, Map<String, String> map, SessionDescription sessionDescription, Map<String, Map<String, String>> map2) {
        this.params.add(str);
        this.params.add(map == null ? new LinkedHashMap<>() : map);
        this.params.add(sessionDescription.description);
        this.params.add(map2);
    }
}

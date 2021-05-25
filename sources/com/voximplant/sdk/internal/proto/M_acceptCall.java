package com.voximplant.sdk.internal.proto;

import java.util.Map;
import org.webrtc.SessionDescription;
public class M_acceptCall extends WSMessageCall {
    public M_acceptCall(String str, Map map, SessionDescription sessionDescription, Map<String, Map<String, String>> map2) {
        this.params.add(str);
        this.params.add(map);
        this.params.add(sessionDescription.description);
        this.params.add(map2);
    }
}

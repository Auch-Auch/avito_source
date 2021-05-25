package com.voximplant.sdk.internal.proto;

import java.util.HashMap;
import java.util.Map;
import org.webrtc.SessionDescription;
public class M_callConference extends WSMessageCall {
    public M_callConference(String str, String str2, boolean z, Map map, SessionDescription sessionDescription, Map<String, Map<String, String>> map2) {
        this.params.add(-1);
        this.params.add(str2);
        this.params.add(Boolean.valueOf(z));
        this.params.add(str);
        this.params.add(new HashMap());
        this.params.add(new HashMap());
        this.params.add(map);
        this.params.add("");
        this.params.add(sessionDescription.description);
        this.params.add(map2);
    }
}

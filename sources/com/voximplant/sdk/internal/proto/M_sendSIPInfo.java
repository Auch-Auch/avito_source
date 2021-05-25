package com.voximplant.sdk.internal.proto;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.webrtc.IceCandidate;
public class M_sendSIPInfo extends WSMessageCall {
    public M_sendSIPInfo(String str, List<IceCandidate> list) {
        this.params.add(str);
        this.params.add("voximplant");
        this.params.add("sdpfrag");
        JSONArray jSONArray = new JSONArray();
        for (IceCandidate iceCandidate : list) {
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(iceCandidate.sdpMLineIndex);
            jSONArray2.put("a=" + iceCandidate.sdp);
            jSONArray.put(jSONArray2);
        }
        this.params.add(jSONArray.toString());
        this.params.add(new LinkedHashMap());
    }

    public M_sendSIPInfo(String str, String str2, String str3, String str4, Map<String, String> map) {
        this.params.add(str);
        this.params.add(str2);
        this.params.add(str3);
        this.params.add(str4);
        this.params.add(map);
    }
}

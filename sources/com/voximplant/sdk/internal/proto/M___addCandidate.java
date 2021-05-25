package com.voximplant.sdk.internal.proto;

import a2.b.a.a.a;
import java.util.ArrayList;
import org.webrtc.IceCandidate;
public class M___addCandidate extends WSMessageCall {
    public M___addCandidate(String str, IceCandidate iceCandidate) {
        this.params.add(str);
        ArrayList arrayList = this.params;
        StringBuilder L = a.L("a=");
        L.append(iceCandidate.sdp);
        arrayList.add(L.toString());
        this.params.add(Integer.valueOf(iceCandidate.sdpMLineIndex));
    }
}

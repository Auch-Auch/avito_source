package com.voximplant.sdk.internal.proto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.webrtc.SessionDescription;
public class M_handleConnectionConnected extends WSMessageCall {
    public final ArrayList<String> a() {
        if (this.params.size() > 2) {
            return (ArrayList) this.params.get(3);
        }
        return null;
    }

    public Map<String, String> headers() {
        return this.params.size() >= 2 ? (Map) this.params.get(1) : new HashMap();
    }

    public boolean isServerCall() {
        String str = this.params.size() >= 3 ? (String) this.params.get(2) : null;
        return str == null || str.contains("VIMS");
    }

    public SessionDescription sdpAnswer() {
        if (this.params.size() < 3) {
            return null;
        }
        return new SessionDescription(SessionDescription.Type.ANSWER, (String) this.params.get(2));
    }

    public String sipUri() {
        ArrayList<String> a = a();
        if (a != null) {
            return a.get(0);
        }
        return null;
    }

    public String userDisplayName() {
        ArrayList<String> a = a();
        if (a != null) {
            return a.get(1);
        }
        return null;
    }
}

package com.voximplant.sdk.internal.proto;

import com.avito.android.util.preferences.Preference;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.webrtc.PeerConnection;
public class M_loginSuccessful extends WSMessageAuth {
    public final Map<String, Object> a() {
        if (this.params.size() > 1) {
            try {
                return (Map) ((Map) this.params.get(1)).get("OAuth");
            } catch (NullPointerException unused) {
            }
        }
        return null;
    }

    public final ArrayList<Object> b() {
        Map map;
        Map map2;
        if (this.params.size() <= 1 || (map = (Map) this.params.get(1)) == null || (map2 = (Map) map.get("iceConfig")) == null) {
            return null;
        }
        return (ArrayList) map2.get("iceServers");
    }

    public int getAccessExpire() {
        Map<String, Object> a = a();
        if (a != null) {
            return ((Double) a.get("accessExpire")).intValue();
        }
        return 0;
    }

    public String getAccessToken() {
        Map<String, Object> a = a();
        if (a != null) {
            return (String) a.get(SDKConstants.PARAM_ACCESS_TOKEN);
        }
        return null;
    }

    public String getDisplayName() {
        if (!this.params.isEmpty()) {
            return (String) this.params.get(0);
        }
        return null;
    }

    public List<PeerConnection.IceServer> getIceServers() {
        ArrayList<Object> b = b();
        if (b == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Object> it = b.iterator();
        while (it.hasNext()) {
            Map map = (Map) it.next();
            Iterator it2 = ((ArrayList) map.get("urls")).iterator();
            while (it2.hasNext()) {
                String str = (String) it2.next();
                String str2 = (String) map.get(Preference.USERNAME);
                String str3 = (String) map.get("credential");
                if (str2 == null) {
                    str2 = "";
                }
                if (str3 == null) {
                    str3 = "";
                }
                arrayList.add(new PeerConnection.IceServer(str, str2, str3));
            }
        }
        return arrayList;
    }

    public int getRefreshExpire() {
        Map<String, Object> a = a();
        if (a != null) {
            return ((Double) a.get("refreshExpire")).intValue();
        }
        return 0;
    }

    public String getRefreshToken() {
        Map<String, Object> a = a();
        if (a != null) {
            return (String) a.get("refreshToken");
        }
        return null;
    }

    public List<PeerConnection.IceServer> getStunServers() {
        ArrayList<Object> b = b();
        if (b == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Object> it = b.iterator();
        while (it.hasNext()) {
            Map map = (Map) it.next();
            Iterator it2 = ((ArrayList) map.get("urls")).iterator();
            while (it2.hasNext()) {
                String str = (String) it2.next();
                String str2 = (String) map.get(Preference.USERNAME);
                String str3 = (String) map.get("credential");
                if (str2 == null && str3 == null) {
                    arrayList.add(new PeerConnection.IceServer(str, "", ""));
                }
            }
        }
        return arrayList;
    }
}

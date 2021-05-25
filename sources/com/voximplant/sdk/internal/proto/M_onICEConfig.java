package com.voximplant.sdk.internal.proto;

import com.avito.android.util.preferences.Preference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.webrtc.PeerConnection;
public class M_onICEConfig extends WSMessageCall {
    public List<PeerConnection.IceServer> getIceServers() {
        ArrayList arrayList = null;
        if (this.params.size() > 1) {
            ArrayList arrayList2 = (ArrayList) this.params.get(1);
            if (arrayList2 == null) {
                return null;
            }
            arrayList = new ArrayList();
            Iterator it = arrayList2.iterator();
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
        }
        return arrayList;
    }
}

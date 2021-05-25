package com.voximplant.sdk.internal.proto;

import a2.b.a.a.a;
import android.util.SparseArray;
import com.voximplant.sdk.internal.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.webrtc.IceCandidate;
public class M_handleSIPInfo extends WSMessageCall {
    public String body() {
        return (String) this.params.get(3);
    }

    public List<IceCandidate> getIceCandidates(SparseArray<String> sparseArray) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(body());
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONArray jSONArray2 = jSONArray.getJSONArray(i);
                int i2 = jSONArray2.getInt(0);
                arrayList.add(new IceCandidate(sparseArray.get(i2), i2, jSONArray2.getString(1).substring(2)));
            }
        } catch (JSONException e) {
            StringBuilder L = a.L("M_handleSIPInfo: getIceCandidates(): error parsing candidates ");
            L.append(e.getMessage());
            Logger.e(L.toString());
        }
        return arrayList;
    }

    public Map<String, String> headers() {
        return (Map) this.params.get(4);
    }

    public String subType() {
        return (String) this.params.get(2);
    }

    public String type() {
        return (String) this.params.get(1);
    }
}

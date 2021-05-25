package com.yandex.metrica.impl.ob;

import a2.b.a.a.a;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.sumsub.sns.core.common.SNSConstants;
import org.json.JSONException;
import org.json.JSONObject;
@Deprecated
public class or {
    @NonNull
    private final oq a;
    private final ot b;
    private final long c;
    private final boolean d;
    private final long e;

    public or(@NonNull JSONObject jSONObject, long j) throws JSONException {
        this.a = new oq(jSONObject.optString(SNSConstants.Preference.KEY_DEVICE_ID, null), jSONObject.optString("device_id_hash", null));
        if (jSONObject.has("device_snapshot_key")) {
            this.b = new ot(jSONObject.optString("device_snapshot_key", null));
        } else {
            this.b = null;
        }
        this.c = jSONObject.optLong("last_elections_time", -1);
        this.d = d();
        this.e = j;
    }

    private boolean d() {
        if (this.c <= -1 || System.currentTimeMillis() - this.c >= 604800000) {
            return false;
        }
        return true;
    }

    public String a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(SNSConstants.Preference.KEY_DEVICE_ID, this.a.a);
        jSONObject.put("device_id_hash", this.a.b);
        ot otVar = this.b;
        if (otVar != null) {
            jSONObject.put("device_snapshot_key", otVar.b());
        }
        jSONObject.put("last_elections_time", this.c);
        return jSONObject.toString();
    }

    @NonNull
    public oq b() {
        return this.a;
    }

    @Nullable
    public ot c() {
        return this.b;
    }

    public String toString() {
        StringBuilder L = a.L("Credentials{mIdentifiers=");
        L.append(this.a);
        L.append(", mDeviceSnapshot=");
        L.append(this.b);
        L.append(", mLastElectionsTime=");
        L.append(this.c);
        L.append(", mFresh=");
        L.append(this.d);
        L.append(", mLastModified=");
        return a.k(L, this.e, '}');
    }

    public or(@NonNull oq oqVar, @NonNull ot otVar, long j) {
        this.a = oqVar;
        this.b = otVar;
        this.c = j;
        this.d = d();
        this.e = -1;
    }
}

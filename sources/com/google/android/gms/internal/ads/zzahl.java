package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzp;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;
import org.json.JSONObject;
@ParametersAreNonnullByDefault
public final class zzahl implements zzahf<Object> {
    private final Object lock = new Object();
    @GuardedBy("lock")
    private final Map<String, zzahn> zzdev = new HashMap();

    public final void zza(String str, zzahn zzahn) {
        synchronized (this.lock) {
            this.zzdev.put(str, zzahn);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzahf
    public final void zza(Object obj, Map<String, String> map) {
        String str;
        String str2 = map.get("id");
        String str3 = map.get("fail");
        String str4 = map.get("fail_reason");
        String str5 = map.get("fail_stack");
        String str6 = map.get("result");
        if (TextUtils.isEmpty(str5)) {
            str4 = "Unknown Fail Reason.";
        }
        if (TextUtils.isEmpty(str5)) {
            str = "";
        } else {
            String valueOf = String.valueOf(str5);
            str = valueOf.length() != 0 ? "\n".concat(valueOf) : new String("\n");
        }
        synchronized (this.lock) {
            zzahn remove = this.zzdev.remove(str2);
            if (remove == null) {
                String valueOf2 = String.valueOf(str2);
                zzbbd.zzfe(valueOf2.length() != 0 ? "Received result for unexpected method invocation: ".concat(valueOf2) : new String("Received result for unexpected method invocation: "));
            } else if (!TextUtils.isEmpty(str3)) {
                String valueOf3 = String.valueOf(str4);
                String valueOf4 = String.valueOf(str);
                remove.onFailure(valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3));
            } else if (str6 == null) {
                remove.zzc(null);
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(str6);
                    if (zzaxy.zzww()) {
                        String valueOf5 = String.valueOf(jSONObject.toString(2));
                        zzaxy.zzei(valueOf5.length() != 0 ? "Result GMSG: ".concat(valueOf5) : new String("Result GMSG: "));
                    }
                    remove.zzc(jSONObject);
                } catch (JSONException e) {
                    remove.onFailure(e.getMessage());
                }
            }
        }
    }

    public final <EngineT extends zzakh> zzdvt<JSONObject> zza(EngineT enginet, String str, JSONObject jSONObject) {
        zzbbq zzbbq = new zzbbq();
        zzp.zzkp();
        String zzxo = zzayh.zzxo();
        zza(zzxo, new zzaho(this, zzbbq));
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", zzxo);
            jSONObject2.put("args", jSONObject);
            enginet.zza(str, jSONObject2);
        } catch (Exception e) {
            zzbbq.setException(e);
        }
        return zzbbq;
    }
}

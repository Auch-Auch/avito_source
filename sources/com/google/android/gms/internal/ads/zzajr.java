package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
public final /* synthetic */ class zzajr {
    public static void zza(zzajs zzajs, String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        zzajs.zzj(str, jSONObject.toString());
    }

    public static void zzb(zzajs zzajs, String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        StringBuilder W = a.W("(window.AFMA_ReceiveMessage || function() {})('", str, "'", ",", jSONObject.toString());
        W.append(");");
        String valueOf = String.valueOf(W.toString());
        zzbbd.zzef(valueOf.length() != 0 ? "Dispatching AFMA event: ".concat(valueOf) : new String("Dispatching AFMA event: "));
        zzajs.zzdc(W.toString());
    }

    public static void zza(zzajs zzajs, String str, String str2) {
        zzajs.zzdc(a.t2(a.q0(str2, a.q0(str, 3)), str, "(", str2, ");"));
    }

    public static void zza(zzajs zzajs, String str, Map map) {
        try {
            zzajs.zzb(str, zzp.zzkp().zzj(map));
        } catch (JSONException unused) {
            zzbbd.zzfe("Could not convert parameters to JSON.");
        }
    }
}

package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
public final class zzagm implements zzahf<Object> {
    private final zzagl zzddv;

    public zzagm(zzagl zzagl) {
        this.zzddv = zzagl;
    }

    @Override // com.google.android.gms.internal.ads.zzahf
    public final void zza(Object obj, Map<String, String> map) {
        if (this.zzddv != null) {
            String str = map.get("name");
            if (str == null) {
                zzbbd.zzfd("Ad metadata with no name parameter.");
                str = "";
            }
            Bundle bundle = null;
            if (map.containsKey("info")) {
                try {
                    bundle = zzbab.zzh(new JSONObject(map.get("info")));
                } catch (JSONException e) {
                    zzbbd.zzc("Failed to convert ad metadata to JSON.", e);
                }
            }
            if (bundle == null) {
                zzbbd.zzfc("Failed to convert ad metadata to Bundle.");
            } else {
                this.zzddv.zza(str, bundle);
            }
        }
    }
}

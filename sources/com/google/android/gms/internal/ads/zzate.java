package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;
import org.json.JSONObject;
public final class zzate implements zzast {
    private zzalm<JSONObject, JSONObject> zzduw;
    private zzalm<JSONObject, JSONObject> zzdux;

    public zzate(Context context) {
        zzalu zza = zzp.zzlc().zza(context, zzbbg.zzyr());
        zzalq<JSONObject> zzalq = zzalp.zzdhs;
        this.zzdux = zza.zza("google.afma.request.getAdDictionary", zzalq, zzalq);
        this.zzduw = zzp.zzlc().zza(context, zzbbg.zzyr()).zza("google.afma.sdkConstants.getSdkConstants", zzalq, zzalq);
    }

    @Override // com.google.android.gms.internal.ads.zzast
    public final zzalm<JSONObject, JSONObject> zzvd() {
        return this.zzduw;
    }
}

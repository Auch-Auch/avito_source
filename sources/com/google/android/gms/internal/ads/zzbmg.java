package com.google.android.gms.internal.ads;

import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.ads.internal.zzp;
import org.json.JSONObject;
public final class zzbmg implements zzelo<zzqo> {
    private final zzelx<JSONObject> zzeum;
    private final zzelx<zzdkx> zzfnc;
    private final zzelx<zzbbg> zzfnd;
    private final zzelx<String> zzfne;

    private zzbmg(zzelx<zzdkx> zzelx, zzelx<zzbbg> zzelx2, zzelx<JSONObject> zzelx3, zzelx<String> zzelx4) {
        this.zzfnc = zzelx;
        this.zzfnd = zzelx2;
        this.zzeum = zzelx3;
        this.zzfne = zzelx4;
    }

    public static zzbmg zza(zzelx<zzdkx> zzelx, zzelx<zzbbg> zzelx2, zzelx<JSONObject> zzelx3, zzelx<String> zzelx4) {
        return new zzbmg(zzelx, zzelx2, zzelx3, zzelx4);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        this.zzfnc.get();
        zzbbg zzbbg = this.zzfnd.get();
        JSONObject jSONObject = this.zzeum.get();
        String str = this.zzfne.get();
        boolean equals = AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE.equals(str);
        zzp.zzkp();
        return (zzqo) zzelu.zza(new zzqo(zzayh.zzxo(), zzbbg, str, jSONObject, false, equals), "Cannot return null from a non-@Nullable @Provides method");
    }
}

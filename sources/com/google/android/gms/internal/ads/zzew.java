package com.google.android.gms.internal.ads;

import android.view.View;
import androidx.annotation.NonNull;
import com.avito.android.util.preferences.db_preferences.Types;
import com.google.android.gms.internal.ads.zzcf;
import com.vk.sdk.api.VKApiConst;
import java.util.HashMap;
import java.util.Map;
public final class zzew implements zzdrz {
    private final zzfi zzxn;
    private final zzdqc zzyr;
    private final zzdqo zzys;
    private final zzev zzyt;

    public zzew(@NonNull zzdqc zzdqc, @NonNull zzdqo zzdqo, @NonNull zzfi zzfi, @NonNull zzev zzev) {
        this.zzyr = zzdqc;
        this.zzys = zzdqo;
        this.zzxn = zzfi;
        this.zzyt = zzev;
    }

    private final Map<String, Object> zzcc() {
        HashMap hashMap = new HashMap();
        zzcf.zza zzco = this.zzys.zzco();
        hashMap.put(VKApiConst.VERSION, this.zzyr.zzavb());
        hashMap.put("gms", Boolean.valueOf(this.zzyr.zzcm()));
        hashMap.put(Types.INT, zzco.zzaf());
        hashMap.put("up", Boolean.valueOf(this.zzyt.zzcb()));
        hashMap.put("t", new Throwable());
        return hashMap;
    }

    public final void zzc(View view) {
        this.zzxn.zze(view);
    }

    @Override // com.google.android.gms.internal.ads.zzdrz
    public final Map<String, Object> zzcd() {
        Map<String, Object> zzcc = zzcc();
        zzcf.zza zzavi = this.zzys.zzavi();
        zzcc.put("gai", Boolean.valueOf(this.zzyr.zzavc()));
        zzcc.put("did", zzavi.zzal());
        zzcc.put("dst", Integer.valueOf(zzavi.zzam().zzv()));
        zzcc.put("doo", Boolean.valueOf(zzavi.zzan()));
        return zzcc;
    }

    @Override // com.google.android.gms.internal.ads.zzdrz
    public final Map<String, Object> zzce() {
        return zzcc();
    }

    @Override // com.google.android.gms.internal.ads.zzdrz
    public final Map<String, Object> zzcf() {
        Map<String, Object> zzcc = zzcc();
        zzcc.put("lts", Long.valueOf(this.zzxn.zzcu()));
        return zzcc;
    }
}

package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;
import org.json.JSONObject;
public final class zzbmk implements zzelo<Set<zzbys<zzo>>> {
    private final zzelx<Executor> zzerr;
    private final zzelx<zzbma> zzfmx;
    private final zzelx<JSONObject> zzfmy;

    private zzbmk(zzelx<zzbma> zzelx, zzelx<Executor> zzelx2, zzelx<JSONObject> zzelx3) {
        this.zzfmx = zzelx;
        this.zzerr = zzelx2;
        this.zzfmy = zzelx3;
    }

    public static zzbmk zze(zzelx<zzbma> zzelx, zzelx<Executor> zzelx2, zzelx<JSONObject> zzelx3) {
        return new zzbmk(zzelx, zzelx2, zzelx3);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        Set set;
        zzbma zzbma = this.zzfmx.get();
        Executor executor = this.zzerr.get();
        if (this.zzfmy.get() == null) {
            set = Collections.emptySet();
        } else {
            set = Collections.singleton(new zzbys(zzbma, executor));
        }
        return (Set) zzelu.zza(set, "Cannot return null from a non-@Nullable @Provides method");
    }
}

package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;
import java.util.Set;
public final class zzbuu implements zzelo<zzbur> {
    private final zzelx<Set<zzbys<zzo>>> zzfor;

    private zzbuu(zzelx<Set<zzbys<zzo>>> zzelx) {
        this.zzfor = zzelx;
    }

    public static zzbuu zzo(zzelx<Set<zzbys<zzo>>> zzelx) {
        return new zzbuu(zzelx);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzbur(this.zzfor.get());
    }
}

package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;
import java.util.Set;
public final class zzbuk implements zzelo<zzbui> {
    private final zzelx<Set<zzbys<AdMetadataListener>>> zzfor;

    private zzbuk(zzelx<Set<zzbys<AdMetadataListener>>> zzelx) {
        this.zzfor = zzelx;
    }

    public static zzbuk zzm(zzelx<Set<zzbys<AdMetadataListener>>> zzelx) {
        return new zzbuk(zzelx);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzbui(this.zzfor.get());
    }
}

package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.internal.ads.zztw;
public final class zzcbi implements zzelo<zzcbf> {
    private final zzelx<Context> zzert;
    private final zzelx<zzawb> zzfku;
    private final zzelx<View> zzflx;
    private final zzelx<zztw.zza.EnumC0204zza> zzfne;
    private final zzelx<zzavy> zzfpq;

    private zzcbi(zzelx<zzavy> zzelx, zzelx<Context> zzelx2, zzelx<zzawb> zzelx3, zzelx<View> zzelx4, zzelx<zztw.zza.EnumC0204zza> zzelx5) {
        this.zzfpq = zzelx;
        this.zzert = zzelx2;
        this.zzfku = zzelx3;
        this.zzflx = zzelx4;
        this.zzfne = zzelx5;
    }

    public static zzcbi zzd(zzelx<zzavy> zzelx, zzelx<Context> zzelx2, zzelx<zzawb> zzelx3, zzelx<View> zzelx4, zzelx<zztw.zza.EnumC0204zza> zzelx5) {
        return new zzcbi(zzelx, zzelx2, zzelx3, zzelx4, zzelx5);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzcbf(this.zzfpq.get(), this.zzert.get(), this.zzfku.get(), this.zzflx.get(), this.zzfne.get());
    }
}

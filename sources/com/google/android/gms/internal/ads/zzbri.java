package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;
public final class zzbri implements zzelo<zzbys<zzo>> {
    private final zzelx<zzbpx> zzfnr;
    private final zzbqz zzfri;

    private zzbri(zzbqz zzbqz, zzelx<zzbpx> zzelx) {
        this.zzfri = zzbqz;
        this.zzfnr = zzelx;
    }

    public static zzbri zza(zzbqz zzbqz, zzelx<zzbpx> zzelx) {
        return new zzbri(zzbqz, zzelx);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (zzbys) zzelu.zza(new zzbys(this.zzfnr.get(), zzbbi.zzedz), "Cannot return null from a non-@Nullable @Provides method");
    }
}

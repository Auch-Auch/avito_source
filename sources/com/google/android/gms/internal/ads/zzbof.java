package com.google.android.gms.internal.ads;
public final class zzbof implements zzelo<zzcre<zzbni>> {
    private final zzelx<zzcvp<zzbni, zzdlx, zzcso>> zzfcc;
    private final zzelx<Boolean> zzfhk;
    private final zzelx<zzctx> zzfhm;

    public zzbof(zzelx<Boolean> zzelx, zzelx<zzctx> zzelx2, zzelx<zzcvp<zzbni, zzdlx, zzcso>> zzelx3) {
        this.zzfhk = zzelx;
        this.zzfhm = zzelx2;
        this.zzfcc = zzelx3;
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        boolean booleanValue = this.zzfhk.get().booleanValue();
        zzctx zzctx = this.zzfhm.get();
        zzcvp<zzbni, zzdlx, zzcso> zzcvp = this.zzfcc.get();
        if (!booleanValue) {
            zzctx = zzcvp;
        }
        return (zzcre) zzelu.zza(zzctx, "Cannot return null from a non-@Nullable @Provides method");
    }
}

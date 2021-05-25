package com.google.android.gms.internal.ads;
public final class zzbff extends zzbev {
    public zzbff(zzbde zzbde) {
        super(zzbde);
    }

    @Override // com.google.android.gms.internal.ads.zzbev
    public final void abort() {
    }

    @Override // com.google.android.gms.internal.ads.zzbev
    public final boolean zzfn(String str) {
        zzbde zzbde = this.zzekx.get();
        if (zzbde != null) {
            zzbde.zza(zzfo(str), this);
        }
        zzbbd.zzfe("VideoStreamNoopCache is doing nothing.");
        zza(str, zzfo(str), "noop", "Noop cache is a noop.");
        return false;
    }
}

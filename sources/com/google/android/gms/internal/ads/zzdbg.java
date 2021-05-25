package com.google.android.gms.internal.ads;
public final class zzdbg implements zzelo<zzdbe> {
    private final zzelx<zzdij> zzfrt;

    private zzdbg(zzelx<zzdij> zzelx) {
        this.zzfrt = zzelx;
    }

    public static zzdbg zzam(zzelx<zzdij> zzelx) {
        return new zzdbg(zzelx);
    }

    public static zzdbe zzb(zzdij zzdij) {
        return new zzdbe(zzdij);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return zzb(this.zzfrt.get());
    }
}

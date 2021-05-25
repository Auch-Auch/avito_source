package com.google.android.gms.internal.ads;
public final class zzdef implements zzelo<zzded> {
    private final zzelx<zzdjf> zzfrt;

    private zzdef(zzelx<zzdjf> zzelx) {
        this.zzfrt = zzelx;
    }

    public static zzdef zzaq(zzelx<zzdjf> zzelx) {
        return new zzdef(zzelx);
    }

    public static zzded zzb(zzdjf zzdjf) {
        return new zzded(zzdjf);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return zzb(this.zzfrt.get());
    }
}

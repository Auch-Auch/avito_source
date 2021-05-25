package com.google.android.gms.internal.ads;
public final class zzccl implements zzelo<zzccm> {
    private final zzelx<zzccv> zzfwo;

    private zzccl(zzelx<zzccv> zzelx) {
        this.zzfwo = zzelx;
    }

    public static zzccl zzy(zzelx<zzccv> zzelx) {
        return new zzccl(zzelx);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return new zzccm(this.zzfwo.get());
    }
}

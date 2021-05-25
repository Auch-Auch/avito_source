package com.google.android.gms.internal.ads;
public final class zzcdn implements zzelo<zzccv> {
    private final zzcdh zzfyt;

    private zzcdn(zzcdh zzcdh) {
        this.zzfyt = zzcdh;
    }

    public static zzcdn zza(zzcdh zzcdh) {
        return new zzcdn(zzcdh);
    }

    public static zzccv zzb(zzcdh zzcdh) {
        return (zzccv) zzelu.zza(zzcdh.zzamj(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return zzb(this.zzfyt);
    }
}

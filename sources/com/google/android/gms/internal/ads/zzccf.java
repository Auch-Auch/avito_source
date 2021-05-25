package com.google.android.gms.internal.ads;
public final class zzccf implements zzelo<zzchc> {
    private final zzccc zzfwr;

    public zzccf(zzccc zzccc) {
        this.zzfwr = zzccc;
    }

    public static zzchc zza(zzccc zzccc) {
        return (zzchc) zzelu.zza(zzccc.zzalg(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return zza(this.zzfwr);
    }
}

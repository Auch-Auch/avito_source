package com.google.android.gms.internal.ads;
public final class zzbis implements zzelo<zzbbg> {
    private final zzbih zzern;

    public zzbis(zzbih zzbih) {
        this.zzern = zzbih;
    }

    public static zzbbg zzb(zzbih zzbih) {
        return (zzbbg) zzelu.zza(zzbih.zzadg(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return zzb(this.zzern);
    }
}

package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;
public final class zzcma implements zzelo<Set<zzbys<zzbuj>>> {
    private final zzelx<Executor> zzerr;
    private final zzelx<zzcmg> zzgek;
    private final zzclw zzgfx;

    private zzcma(zzclw zzclw, zzelx<zzcmg> zzelx, zzelx<Executor> zzelx2) {
        this.zzgfx = zzclw;
        this.zzgek = zzelx;
        this.zzerr = zzelx2;
    }

    public static Set<zzbys<zzbuj>> zzb(zzclw zzclw, zzcmg zzcmg, Executor executor) {
        return (Set) zzelu.zza(zzclw.zzc(zzcmg, executor), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static zzcma zzd(zzclw zzclw, zzelx<zzcmg> zzelx, zzelx<Executor> zzelx2) {
        return new zzcma(zzclw, zzelx, zzelx2);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return zzb(this.zzgfx, this.zzgek.get(), this.zzerr.get());
    }
}

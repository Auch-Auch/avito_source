package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;
public final class zzcmd implements zzelo<Set<zzbys<zzdpl>>> {
    private final zzelx<Executor> zzerr;
    private final zzelx<zzcmg> zzgek;
    private final zzclw zzgfx;

    private zzcmd(zzclw zzclw, zzelx<zzcmg> zzelx, zzelx<Executor> zzelx2) {
        this.zzgfx = zzclw;
        this.zzgek = zzelx;
        this.zzerr = zzelx2;
    }

    public static zzcmd zzg(zzclw zzclw, zzelx<zzcmg> zzelx, zzelx<Executor> zzelx2) {
        return new zzcmd(zzclw, zzelx, zzelx2);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (Set) zzelu.zza(zzclw.zzh(this.zzgek.get(), this.zzerr.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}

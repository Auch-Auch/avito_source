package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;
public final class zzclx implements zzelo<Set<zzbys<zzbtp>>> {
    private final zzelx<Executor> zzerr;
    private final zzelx<zzcmg> zzgek;
    private final zzclw zzgfx;

    private zzclx(zzclw zzclw, zzelx<zzcmg> zzelx, zzelx<Executor> zzelx2) {
        this.zzgfx = zzclw;
        this.zzgek = zzelx;
        this.zzerr = zzelx2;
    }

    public static zzclx zzb(zzclw zzclw, zzelx<zzcmg> zzelx, zzelx<Executor> zzelx2) {
        return new zzclx(zzclw, zzelx, zzelx2);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (Set) zzelu.zza(zzclw.zza(this.zzgek.get(), this.zzerr.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}

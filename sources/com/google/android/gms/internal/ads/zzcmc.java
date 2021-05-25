package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Set;
import java.util.concurrent.Executor;
public final class zzcmc implements zzelo<Set<zzbys<AppEventListener>>> {
    private final zzelx<Executor> zzerr;
    private final zzelx<zzcmg> zzgek;
    private final zzclw zzgfx;

    private zzcmc(zzclw zzclw, zzelx<zzcmg> zzelx, zzelx<Executor> zzelx2) {
        this.zzgfx = zzclw;
        this.zzgek = zzelx;
        this.zzerr = zzelx2;
    }

    public static zzcmc zzf(zzclw zzclw, zzelx<zzcmg> zzelx, zzelx<Executor> zzelx2) {
        return new zzcmc(zzclw, zzelx, zzelx2);
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        return (Set) zzelu.zza(zzclw.zzb(this.zzgek.get(), this.zzerr.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}

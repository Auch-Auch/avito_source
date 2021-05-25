package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;
public final class zzclw {
    public static Set<zzbys<zzbtp>> zza(zzcmg zzcmg, Executor executor) {
        return zzc(zzcmg, executor);
    }

    public static Set<zzbys<AppEventListener>> zzb(zzcmg zzcmg, Executor executor) {
        return zzc(zzcmg, executor);
    }

    public static Set<zzbys<zzbuj>> zzc(zzcmg zzcmg, Executor executor) {
        return zzc(zzcmg, executor);
    }

    public static Set<zzbys<zzbsz>> zzd(zzcmg zzcmg, Executor executor) {
        return zzc(zzcmg, executor);
    }

    public static Set<zzbys<zzbsu>> zze(zzcmg zzcmg, Executor executor) {
        return zzc(zzcmg, executor);
    }

    public static Set<zzbys<zzbtm>> zzf(zzcmg zzcmg, Executor executor) {
        return zzc(zzcmg, executor);
    }

    public static Set<zzbys<zzut>> zzg(zzcmg zzcmg, Executor executor) {
        return zzc(zzcmg, executor);
    }

    public static Set<zzbys<zzdpl>> zzh(zzcmg zzcmg, Executor executor) {
        return zzc(zzcmg, executor);
    }

    public static Set<zzbys<zzbvj>> zzi(zzcmg zzcmg, Executor executor) {
        return zzc(zzcmg, executor);
    }

    private static <T> Set<zzbys<T>> zzc(T t, Executor executor) {
        if (zzacn.zzdaw.get().booleanValue()) {
            return Collections.singleton(new zzbys(t, executor));
        }
        return Collections.emptySet();
    }
}

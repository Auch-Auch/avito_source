package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzb;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
public final class zzchm implements Callable<zzchc> {
    private final zzbfy zzbpp;
    private final zzbbg zzdpq;
    private final zzeg zzenn;
    private final Executor zzfmk;
    private final zzb zzgbm;
    private final Context zzvr;

    public zzchm(Context context, Executor executor, zzeg zzeg, zzbbg zzbbg, zzb zzb, zzbfy zzbfy) {
        this.zzvr = context;
        this.zzfmk = executor;
        this.zzenn = zzeg;
        this.zzdpq = zzbbg;
        this.zzgbm = zzb;
        this.zzbpp = zzbfy;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ zzchc call() throws Exception {
        zzchc zzchc = new zzchc(this);
        zzchc.zzang();
        return zzchc;
    }
}

package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
public final class zzbln implements zzbsu, zzbti, zzbtm, zzbuj, zzut {
    private final Executor executor;
    @Nullable
    private final View view;
    private final zzabt zzeno;
    private final ScheduledExecutorService zzflf;
    private final zzdlj zzflg;
    private final zzdkx zzflh;
    private final zzdps zzfli;
    private final zzeg zzflj;
    private final zzaby zzflk;
    @GuardedBy("this")
    private boolean zzfll;
    @GuardedBy("this")
    private boolean zzflm;
    private final Context zzvr;

    public zzbln(Context context, Executor executor2, ScheduledExecutorService scheduledExecutorService, zzdlj zzdlj, zzdkx zzdkx, zzdps zzdps, @Nullable View view2, zzeg zzeg, zzabt zzabt, zzaby zzaby) {
        this.zzvr = context;
        this.executor = executor2;
        this.zzflf = scheduledExecutorService;
        this.zzflg = zzdlj;
        this.zzflh = zzdkx;
        this.zzfli = zzdps;
        this.zzflj = zzeg;
        this.view = view2;
        this.zzeno = zzabt;
        this.zzflk = zzaby;
    }

    @Override // com.google.android.gms.internal.ads.zzut
    public final void onAdClicked() {
        if (!zzacl.zzdah.get().booleanValue()) {
            zzdps zzdps = this.zzfli;
            zzdlj zzdlj = this.zzflg;
            zzdkx zzdkx = this.zzflh;
            zzdps.zza(zzdlj, zzdkx, zzdkx.zzdis);
            return;
        }
        zzdvl.zza(zzdvc.zzg(this.zzflk.zza(this.zzvr, null, this.zzeno.zzrs(), this.zzeno.zzrt())).zza(((Long) zzwe.zzpu().zzd(zzaat.zzcoh)).longValue(), TimeUnit.MILLISECONDS, this.zzflf), new zzblq(this), this.executor);
    }

    @Override // com.google.android.gms.internal.ads.zzbsu
    public final void onAdClosed() {
    }

    @Override // com.google.android.gms.internal.ads.zzbtm
    public final synchronized void onAdImpression() {
        if (!this.zzflm) {
            String zza = ((Boolean) zzwe.zzpu().zzd(zzaat.zzcre)).booleanValue() ? this.zzflj.zzca().zza(this.zzvr, this.view, (Activity) null) : null;
            if (!zzacl.zzdai.get().booleanValue()) {
                zzdps zzdps = this.zzfli;
                zzdlj zzdlj = this.zzflg;
                zzdkx zzdkx = this.zzflh;
                zzdps.zza(zzdlj, zzdkx, false, zza, null, zzdkx.zzdit);
                this.zzflm = true;
                return;
            }
            zzdvl.zza(zzdvc.zzg(this.zzflk.zzc(this.zzvr, null)).zza(((Long) zzwe.zzpu().zzd(zzaat.zzcoh)).longValue(), TimeUnit.MILLISECONDS, this.zzflf), new zzblp(this, zza), this.executor);
            this.zzflm = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsu
    public final void onAdLeftApplication() {
    }

    @Override // com.google.android.gms.internal.ads.zzbuj
    public final synchronized void onAdLoaded() {
        if (this.zzfll) {
            ArrayList arrayList = new ArrayList(this.zzflh.zzdit);
            arrayList.addAll(this.zzflh.zzhai);
            this.zzfli.zza(this.zzflg, this.zzflh, true, null, null, arrayList);
        } else {
            zzdps zzdps = this.zzfli;
            zzdlj zzdlj = this.zzflg;
            zzdkx zzdkx = this.zzflh;
            zzdps.zza(zzdlj, zzdkx, zzdkx.zzhak);
            zzdps zzdps2 = this.zzfli;
            zzdlj zzdlj2 = this.zzflg;
            zzdkx zzdkx2 = this.zzflh;
            zzdps2.zza(zzdlj2, zzdkx2, zzdkx2.zzhai);
        }
        this.zzfll = true;
    }

    @Override // com.google.android.gms.internal.ads.zzbsu
    public final void onAdOpened() {
    }

    @Override // com.google.android.gms.internal.ads.zzbsu
    public final void onRewardedVideoCompleted() {
        zzdps zzdps = this.zzfli;
        zzdlj zzdlj = this.zzflg;
        zzdkx zzdkx = this.zzflh;
        zzdps.zza(zzdlj, zzdkx, zzdkx.zzhaj);
    }

    @Override // com.google.android.gms.internal.ads.zzbsu
    public final void onRewardedVideoStarted() {
        zzdps zzdps = this.zzfli;
        zzdlj zzdlj = this.zzflg;
        zzdkx zzdkx = this.zzflh;
        zzdps.zza(zzdlj, zzdkx, zzdkx.zzdsi);
    }

    @Override // com.google.android.gms.internal.ads.zzbsu
    public final void zzb(zzatj zzatj, String str, String str2) {
        zzdps zzdps = this.zzfli;
        zzdlj zzdlj = this.zzflg;
        zzdkx zzdkx = this.zzflh;
        zzdps.zza(zzdlj, zzdkx, zzdkx.zzdsj, zzatj);
    }

    @Override // com.google.android.gms.internal.ads.zzbti
    public final void zzf(zzuw zzuw) {
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcpw)).booleanValue()) {
            zzdps zzdps = this.zzfli;
            zzdlj zzdlj = this.zzflg;
            zzdkx zzdkx = this.zzflh;
            zzdps.zza(zzdlj, zzdkx, zzdkx.zzhal);
        }
    }
}

package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbsg;
import com.google.android.gms.internal.ads.zzbxj;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;
public final class zzcxo extends zzwx {
    private final Executor zzfmk;
    private final zzbii zzgmy;
    private final Context zzgpr;
    @GuardedBy("this")
    private final zzdlp zzgps;
    private final zzcxm zzgpw = new zzcxm();
    private final zzcxl zzgpy = new zzcxl();
    private final zzcxh zzgpz = new zzcxh();
    @Nullable
    @GuardedBy("this")
    private zzabq zzgqc;
    @Nullable
    @GuardedBy("this")
    private zzdvt<zzbzr> zzgqd;
    private final zzdje zzgqq = new zzdje(new zzdmt());
    @Nullable
    @GuardedBy("this")
    private zzbzr zzgqr;
    @GuardedBy("this")
    private boolean zzgqs;

    public zzcxo(zzbii zzbii, Context context, zzvj zzvj, String str) {
        zzdlp zzdlp = new zzdlp();
        this.zzgps = zzdlp;
        this.zzgqs = false;
        this.zzgmy = zzbii;
        zzdlp.zze(zzvj).zzgt(str);
        this.zzfmk = zzbii.zzadj();
        this.zzgpr = context;
    }

    private final synchronized boolean zzaqd() {
        zzbzr zzbzr;
        zzbzr = this.zzgqr;
        return zzbzr != null && !zzbzr.isClosed();
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final synchronized void destroy() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        zzbzr zzbzr = this.zzgqr;
        if (zzbzr != null) {
            zzbzr.zzail().zzcb(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final Bundle getAdMetadata() {
        Preconditions.checkMainThread("getAdMetadata must be called on the main UI thread.");
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final synchronized String getAdUnitId() {
        return this.zzgps.zzass();
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final synchronized String getMediationAdapterClassName() {
        zzbzr zzbzr = this.zzgqr;
        if (zzbzr == null || zzbzr.zzaim() == null) {
            return null;
        }
        return this.zzgqr.zzaim().getMediationAdapterClassName();
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final zzyg getVideoController() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final synchronized boolean isLoading() {
        zzdvt<zzbzr> zzdvt;
        zzdvt = this.zzgqd;
        return zzdvt != null && !zzdvt.isDone();
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final synchronized boolean isReady() {
        Preconditions.checkMainThread("isLoaded must be called on the main UI thread.");
        return zzaqd();
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final synchronized void pause() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
        zzbzr zzbzr = this.zzgqr;
        if (zzbzr != null) {
            zzbzr.zzail().zzbz(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final synchronized void resume() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
        zzbzr zzbzr = this.zzgqr;
        if (zzbzr != null) {
            zzbzr.zzail().zzca(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final synchronized void setImmersiveMode(boolean z) {
        Preconditions.checkMainThread("setImmersiveMode must be called on the main UI thread.");
        this.zzgqs = z;
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final synchronized void setManualImpressionsEnabled(boolean z) {
        Preconditions.checkMainThread("setManualImpressionsEnabled must be called from the main thread.");
        this.zzgps.zzbp(z);
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void setUserId(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final synchronized void showInterstitial() {
        Preconditions.checkMainThread("showInterstitial must be called on the main UI thread.");
        zzbzr zzbzr = this.zzgqr;
        if (zzbzr != null) {
            zzbzr.zzbi(this.zzgqs);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void stopLoading() {
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zza(zzaqv zzaqv) {
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zza(zzarb zzarb, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zza(zzsi zzsi) {
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zza(zzvj zzvj) {
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zza(zzvm zzvm) {
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zza(zzwg zzwg) {
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zza(zzym zzym) {
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final synchronized boolean zza(zzvc zzvc) {
        zzcar zzcar;
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        zzp.zzkp();
        if (zzayh.zzbe(this.zzgpr) && zzvc.zzchi == null) {
            zzbbd.zzfc("Failed to load the ad because app ID is missing.");
            zzcxm zzcxm = this.zzgpw;
            if (zzcxm != null) {
                zzcxm.zzg(zzdmb.zza(zzdmd.zzhcr, null, null));
            }
            return false;
        } else if (this.zzgqd != null || zzaqd()) {
            return false;
        } else {
            zzdly.zze(this.zzgpr, zzvc.zzcgy);
            this.zzgqr = null;
            zzdln zzasu = this.zzgps.zzh(zzvc).zzasu();
            if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcxs)).booleanValue()) {
                zzcar = this.zzgmy.zzadt().zzd(new zzbsg.zza().zzcd(this.zzgpr).zza(zzasu).zzajj()).zzd(new zzbxj.zza().zzake()).zzb(new zzcwh(this.zzgqc)).zzafz();
            } else {
                zzbxj.zza zza = new zzbxj.zza();
                zzdje zzdje = this.zzgqq;
                if (zzdje != null) {
                    zza.zza((zzbsu) zzdje, this.zzgmy.zzadj()).zza((zzbuj) this.zzgqq, this.zzgmy.zzadj()).zza((zzbsz) this.zzgqq, this.zzgmy.zzadj());
                }
                zzcar = this.zzgmy.zzadt().zzd(new zzbsg.zza().zzcd(this.zzgpr).zza(zzasu).zzajj()).zzd(zza.zza((zzbsu) this.zzgpw, this.zzgmy.zzadj()).zza((zzbuj) this.zzgpw, this.zzgmy.zzadj()).zza((zzbsz) this.zzgpw, this.zzgmy.zzadj()).zza((zzut) this.zzgpw, this.zzgmy.zzadj()).zza(this.zzgpy, this.zzgmy.zzadj()).zza(this.zzgpz, this.zzgmy.zzadj()).zzake()).zzb(new zzcwh(this.zzgqc)).zzafz();
            }
            zzdvt<zzbzr> zzaiv = zzcar.zzafc().zzaiv();
            this.zzgqd = zzaiv;
            zzdvl.zza(zzaiv, new zzcxn(this, zzcar), this.zzfmk);
            return true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zzbp(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final IObjectWrapper zzkc() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zzkd() {
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final zzvj zzke() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final synchronized String zzkf() {
        zzbzr zzbzr = this.zzgqr;
        if (zzbzr == null || zzbzr.zzaim() == null) {
            return null;
        }
        return this.zzgqr.zzaim().getMediationAdapterClassName();
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final synchronized zzyf zzkg() {
        if (!((Boolean) zzwe.zzpu().zzd(zzaat.zzcwy)).booleanValue()) {
            return null;
        }
        zzbzr zzbzr = this.zzgqr;
        if (zzbzr == null) {
            return null;
        }
        return zzbzr.zzaim();
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final zzxc zzkh() {
        return this.zzgpy.zzaqb();
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final zzwl zzki() {
        return this.zzgpw.zzaqc();
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zza(zzwl zzwl) {
        Preconditions.checkMainThread("setAdListener must be called on the main UI thread.");
        this.zzgpw.zzc(zzwl);
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zza(zzxc zzxc) {
        Preconditions.checkMainThread("setAppEventListener must be called on the main UI thread.");
        this.zzgpy.zzb(zzxc);
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final synchronized void zza(zzxi zzxi) {
        Preconditions.checkMainThread("setCorrelationIdProvider must be called on the main UI thread");
        this.zzgps.zzc(zzxi);
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final synchronized void zza(zzaac zzaac) {
        this.zzgps.zzc(zzaac);
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final synchronized void zza(zzabq zzabq) {
        Preconditions.checkMainThread("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.zzgqc = zzabq;
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zza(zzya zzya) {
        Preconditions.checkMainThread("setPaidEventListener must be called on the main UI thread.");
        this.zzgpz.zzb(zzya);
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zza(zzxb zzxb) {
        Preconditions.checkMainThread("setAdMetadataListener must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zza(zzatt zzatt) {
        this.zzgqq.zzb(zzatt);
    }
}

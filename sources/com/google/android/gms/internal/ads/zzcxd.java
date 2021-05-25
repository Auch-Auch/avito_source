package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbsg;
import com.google.android.gms.internal.ads.zzbxj;
import java.util.Collections;
import javax.annotation.concurrent.GuardedBy;
public final class zzcxd extends zzwx implements zzbvf {
    private final ViewGroup zzfnx;
    private final zzbii zzgmy;
    @Nullable
    @GuardedBy("this")
    private zzbni zzgpm;
    private final Context zzgpr;
    @GuardedBy("this")
    private final zzdlp zzgps;
    private final zzcxm zzgpw = new zzcxm();
    private final zzcxj zzgpx = new zzcxj();
    private final zzcxl zzgpy = new zzcxl();
    private final zzcxh zzgpz = new zzcxh();
    private final zzbvb zzgqa;
    private zzvj zzgqb;
    @Nullable
    @GuardedBy("this")
    private zzabq zzgqc;
    @Nullable
    @GuardedBy("this")
    private zzdvt<zzbni> zzgqd;

    public zzcxd(zzbii zzbii, Context context, zzvj zzvj, String str) {
        zzdlp zzdlp = new zzdlp();
        this.zzgps = zzdlp;
        this.zzfnx = new FrameLayout(context);
        this.zzgmy = zzbii;
        this.zzgpr = context;
        zzdlp.zze(zzvj).zzgt(str);
        zzbvb zzadn = zzbii.zzadn();
        this.zzgqa = zzadn;
        zzadn.zza(this, zzbii.zzadj());
        this.zzgqb = zzvj;
    }

    private final synchronized zzboe zzb(zzdln zzdln) {
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcxp)).booleanValue()) {
            return this.zzgmy.zzadq().zzc(new zzbsg.zza().zzcd(this.zzgpr).zza(zzdln).zzajj()).zzc(new zzbxj.zza().zzake()).zza(new zzcwh(this.zzgqc)).zzb(new zzcbj(zzcdg.zzfyr, null)).zza(new zzbpa(this.zzgqa)).zzb(new zzbnd(this.zzfnx)).zzafp();
        }
        return this.zzgmy.zzadq().zzc(new zzbsg.zza().zzcd(this.zzgpr).zza(zzdln).zzajj()).zzc(new zzbxj.zza().zza((zzut) this.zzgpw, this.zzgmy.zzadj()).zza(this.zzgpx, this.zzgmy.zzadj()).zza((zzbsu) this.zzgpw, this.zzgmy.zzadj()).zza((zzbuj) this.zzgpw, this.zzgmy.zzadj()).zza((zzbsz) this.zzgpw, this.zzgmy.zzadj()).zza(this.zzgpy, this.zzgmy.zzadj()).zza(this.zzgpz, this.zzgmy.zzadj()).zzake()).zza(new zzcwh(this.zzgqc)).zzb(new zzcbj(zzcdg.zzfyr, null)).zza(new zzbpa(this.zzgqa)).zzb(new zzbnd(this.zzfnx)).zzafp();
    }

    private final synchronized void zzd(zzvj zzvj) {
        this.zzgps.zze(zzvj);
        this.zzgps.zzbo(this.zzgqb.zzchu);
    }

    private final synchronized boolean zzg(zzvc zzvc) {
        zzcxm zzcxm;
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        zzp.zzkp();
        if (zzayh.zzbe(this.zzgpr) && zzvc.zzchi == null) {
            zzbbd.zzfc("Failed to load the ad because app ID is missing.");
            zzcxm zzcxm2 = this.zzgpw;
            if (zzcxm2 != null) {
                zzcxm2.zzg(zzdmb.zza(zzdmd.zzhcr, null, null));
            }
            return false;
        } else if (this.zzgqd != null) {
            return false;
        } else {
            zzdly.zze(this.zzgpr, zzvc.zzcgy);
            zzdln zzasu = this.zzgps.zzh(zzvc).zzasu();
            if (!zzacp.zzdbb.get().booleanValue() || !this.zzgps.zzke().zzchr || (zzcxm = this.zzgpw) == null) {
                zzboe zzb = zzb(zzasu);
                zzdvt<zzbni> zzaiv = zzb.zzafc().zzaiv();
                this.zzgqd = zzaiv;
                zzdvl.zza(zzaiv, new zzcxg(this, zzb), this.zzgmy.zzadj());
                return true;
            }
            zzcxm.zzg(zzdmb.zza(zzdmd.zzhcu, null, null));
            return false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final synchronized void destroy() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        zzbni zzbni = this.zzgpm;
        if (zzbni != null) {
            zzbni.destroy();
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
        zzbni zzbni = this.zzgpm;
        if (zzbni == null || zzbni.zzaim() == null) {
            return null;
        }
        return this.zzgpm.zzaim().getMediationAdapterClassName();
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final synchronized zzyg getVideoController() {
        Preconditions.checkMainThread("getVideoController must be called from the main thread.");
        zzbni zzbni = this.zzgpm;
        if (zzbni == null) {
            return null;
        }
        return zzbni.getVideoController();
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final synchronized boolean isLoading() {
        zzdvt<zzbni> zzdvt;
        zzdvt = this.zzgqd;
        return zzdvt != null && !zzdvt.isDone();
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final boolean isReady() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final synchronized void pause() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
        zzbni zzbni = this.zzgpm;
        if (zzbni != null) {
            zzbni.zzail().zzbz(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final synchronized void resume() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
        zzbni zzbni = this.zzgpm;
        if (zzbni != null) {
            zzbni.zzail().zzca(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void setImmersiveMode(boolean z) {
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
    public final void showInterstitial() {
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
    public final void zza(zzatt zzatt) {
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zza(zzsi zzsi) {
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zza(zzvm zzvm) {
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zza(zzym zzym) {
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final synchronized boolean zza(zzvc zzvc) {
        zzd(this.zzgqb);
        return zzg(zzvc);
    }

    @Override // com.google.android.gms.internal.ads.zzbvf
    public final synchronized void zzajp() {
        boolean z;
        ViewParent parent = this.zzfnx.getParent();
        if (!(parent instanceof View)) {
            z = false;
        } else {
            View view = (View) parent;
            z = zzp.zzkp().zza(view, view.getContext());
        }
        if (z) {
            zzvj zzke = this.zzgps.zzke();
            zzbni zzbni = this.zzgpm;
            if (!(zzbni == null || zzbni.zzahu() == null || !this.zzgps.zzasv())) {
                zzke = zzdls.zzb(this.zzgpr, Collections.singletonList(this.zzgpm.zzahu()));
            }
            zzd(zzke);
            zzg(this.zzgps.zzasr());
            return;
        }
        this.zzgqa.zzdw(60);
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zzbp(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final IObjectWrapper zzkc() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        return ObjectWrapper.wrap(this.zzfnx);
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final synchronized void zzkd() {
        Preconditions.checkMainThread("recordManualImpression must be called on the main UI thread.");
        zzbni zzbni = this.zzgpm;
        if (zzbni != null) {
            zzbni.zzkd();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final synchronized zzvj zzke() {
        Preconditions.checkMainThread("getAdSize must be called on the main UI thread.");
        zzbni zzbni = this.zzgpm;
        if (zzbni != null) {
            return zzdls.zzb(this.zzgpr, Collections.singletonList(zzbni.zzahp()));
        }
        return this.zzgps.zzke();
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final synchronized String zzkf() {
        zzbni zzbni = this.zzgpm;
        if (zzbni == null || zzbni.zzaim() == null) {
            return null;
        }
        return this.zzgpm.zzaim().getMediationAdapterClassName();
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final synchronized zzyf zzkg() {
        if (!((Boolean) zzwe.zzpu().zzd(zzaat.zzcwy)).booleanValue()) {
            return null;
        }
        zzbni zzbni = this.zzgpm;
        if (zzbni == null) {
            return null;
        }
        return zzbni.zzaim();
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
    public final synchronized void zza(zzvj zzvj) {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
        this.zzgps.zze(zzvj);
        this.zzgqb = zzvj;
        zzbni zzbni = this.zzgpm;
        if (zzbni != null) {
            zzbni.zza(this.zzfnx, zzvj);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final synchronized void zza(zzxi zzxi) {
        Preconditions.checkMainThread("setCorrelationIdProvider must be called on the main UI thread");
        this.zzgps.zzc(zzxi);
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final synchronized void zza(zzaac zzaac) {
        Preconditions.checkMainThread("setVideoOptions must be called on the main UI thread.");
        this.zzgps.zzc(zzaac);
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zza(zzwg zzwg) {
        Preconditions.checkMainThread("setAdListener must be called on the main UI thread.");
        this.zzgpx.zzb(zzwg);
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
}

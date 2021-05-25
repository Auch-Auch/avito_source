package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.overlay.zzq;
import com.google.android.gms.ads.internal.overlay.zzy;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;
public final class zzdhl extends zzwx implements zzy, zzbuo, zzsc {
    private final zzbbg zzbop;
    private final String zzbuo;
    private final ViewGroup zzfnx;
    private final zzbii zzgmy;
    private final Context zzgpr;
    private AtomicBoolean zzgxh = new AtomicBoolean();
    private final zzdhc zzgxi;
    private final zzdht zzgxj;
    private long zzgxk;
    @Nullable
    private zzbmn zzgxl;
    @Nullable
    @GuardedBy("this")
    public zzbnc zzgxm;

    public zzdhl(zzbii zzbii, Context context, String str, zzdhc zzdhc, zzdht zzdht, zzbbg zzbbg) {
        this.zzfnx = new FrameLayout(context);
        this.zzgmy = zzbii;
        this.zzgpr = context;
        this.zzbuo = str;
        this.zzgxi = zzdhc;
        this.zzgxj = zzdht;
        zzdht.zza(this);
        this.zzbop = zzbbg;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzarx */
    public final void zzasa() {
        if (this.zzgxh.compareAndSet(false, true)) {
            zzbnc zzbnc = this.zzgxm;
            if (!(zzbnc == null || zzbnc.zzahs() == null)) {
                this.zzgxj.zzb(this.zzgxm.zzahs());
            }
            this.zzgxj.onAdClosed();
            this.zzfnx.removeAllViews();
            zzbmn zzbmn = this.zzgxl;
            if (zzbmn != null) {
                zzp.zzks().zzb(zzbmn);
            }
            zzbnc zzbnc2 = this.zzgxm;
            if (zzbnc2 != null) {
                zzbnc2.zzfd(zzp.zzkw().elapsedRealtime() - this.zzgxk);
            }
            destroy();
        }
    }

    /* access modifiers changed from: private */
    public final zzvj zzary() {
        return zzdls.zzb(this.zzgpr, Collections.singletonList(this.zzgxm.zzahp()));
    }

    /* access modifiers changed from: private */
    public static RelativeLayout.LayoutParams zzb(zzbnc zzbnc) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(zzbnc.zzabx() ? 11 : 9);
        return layoutParams;
    }

    /* access modifiers changed from: private */
    public final void zzc(zzbnc zzbnc) {
        zzbnc.zza(this);
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final synchronized void destroy() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        zzbnc zzbnc = this.zzgxm;
        if (zzbnc != null) {
            zzbnc.destroy();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final Bundle getAdMetadata() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final synchronized String getAdUnitId() {
        return this.zzbuo;
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final synchronized String getMediationAdapterClassName() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final synchronized zzyg getVideoController() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final synchronized boolean isLoading() {
        return this.zzgxi.isLoading();
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final boolean isReady() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final synchronized void pause() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final synchronized void resume() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void setImmersiveMode(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final synchronized void setManualImpressionsEnabled(boolean z) {
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
    public final void zza(zzvm zzvm) {
        this.zzgxi.zza(zzvm);
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zza(zzwg zzwg) {
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zza(zzwl zzwl) {
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zza(zzxb zzxb) {
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zza(zzxc zzxc) {
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zza(zzya zzya) {
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zza(zzym zzym) {
    }

    @Override // com.google.android.gms.internal.ads.zzbuo
    public final void zzajl() {
        if (this.zzgxm != null) {
            this.zzgxk = zzp.zzkw().elapsedRealtime();
            int zzahh = this.zzgxm.zzahh();
            if (zzahh > 0) {
                zzbmn zzbmn = new zzbmn(this.zzgmy.zzadk(), zzp.zzkw());
                this.zzgxl = zzbmn;
                zzbmn.zza(zzahh, new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzdhn
                    private final zzdhl zzgxg;

                    {
                        this.zzgxg = r1;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zzgxg.zzarz();
                    }
                });
            }
        }
    }

    public final /* synthetic */ void zzarz() {
        this.zzgmy.zzadj().execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzdhk
            private final zzdhl zzgxg;

            {
                this.zzgxg = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzgxg.zzasa();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zzbp(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final IObjectWrapper zzkc() {
        Preconditions.checkMainThread("getAdFrame must be called on the main UI thread.");
        return ObjectWrapper.wrap(this.zzfnx);
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final synchronized void zzkd() {
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final synchronized zzvj zzke() {
        Preconditions.checkMainThread("getAdSize must be called on the main UI thread.");
        zzbnc zzbnc = this.zzgxm;
        if (zzbnc == null) {
            return null;
        }
        return zzdls.zzb(this.zzgpr, Collections.singletonList(zzbnc.zzahp()));
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final synchronized String zzkf() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final synchronized zzyf zzkg() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final zzxc zzkh() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final zzwl zzki() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzsc
    public final void zzmr() {
        zzasa();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzy
    public final void zzup() {
        zzasa();
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final synchronized boolean zza(zzvc zzvc) throws RemoteException {
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        zzp.zzkp();
        if (zzayh.zzbe(this.zzgpr) && zzvc.zzchi == null) {
            zzbbd.zzfc("Failed to load the ad because app ID is missing.");
            this.zzgxj.zzg(zzdmb.zza(zzdmd.zzhcr, null, null));
            return false;
        } else if (isLoading()) {
            return false;
        } else {
            this.zzgxh = new AtomicBoolean();
            return this.zzgxi.zza(zzvc, this.zzbuo, new zzdhm(this), new zzdhp(this));
        }
    }

    /* access modifiers changed from: private */
    public final zzq zza(zzbnc zzbnc) {
        boolean zzabx = zzbnc.zzabx();
        int intValue = ((Integer) zzwe.zzpu().zzd(zzaat.zzctj)).intValue();
        com.google.android.gms.ads.internal.overlay.zzp zzp = new com.google.android.gms.ads.internal.overlay.zzp();
        zzp.size = 50;
        zzp.paddingLeft = zzabx ? intValue : 0;
        zzp.paddingRight = zzabx ? 0 : intValue;
        zzp.paddingTop = 0;
        zzp.paddingBottom = intValue;
        return new zzq(this.zzgpr, zzp, this);
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zza(zzsi zzsi) {
        this.zzgxj.zzb(zzsi);
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final synchronized void zza(zzvj zzvj) {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final synchronized void zza(zzxi zzxi) {
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final synchronized void zza(zzaac zzaac) {
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final synchronized void zza(zzabq zzabq) {
    }
}

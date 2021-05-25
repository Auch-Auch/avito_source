package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.atomic.AtomicBoolean;
public final class zzyq {
    private final zzvh zzacs;
    private VideoOptions zzbnn;
    private boolean zzbnu;
    private AppEventListener zzbnw;
    private zzwu zzbun;
    private String zzbuo;
    private final zzamr zzbuq;
    private zzut zzcgq;
    private AdListener zzcgu;
    private AdSize[] zzchv;
    private final AtomicBoolean zzcji;
    private final VideoController zzcjj;
    @VisibleForTesting
    private final zzwh zzcjk;
    private OnCustomRenderedAdLoadedListener zzcjl;
    private ViewGroup zzcjm;
    private int zzcjn;
    @Nullable
    private OnPaidEventListener zzcjo;

    public zzyq(ViewGroup viewGroup) {
        this(viewGroup, null, false, zzvh.zzchm, 0);
    }

    private static boolean zzcz(int i) {
        return i == 1;
    }

    public final void destroy() {
        try {
            zzwu zzwu = this.zzbun;
            if (zzwu != null) {
                zzwu.destroy();
            }
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
        }
    }

    public final AdListener getAdListener() {
        return this.zzcgu;
    }

    public final AdSize getAdSize() {
        zzvj zzke;
        try {
            zzwu zzwu = this.zzbun;
            if (!(zzwu == null || (zzke = zzwu.zzke()) == null)) {
                return zzke.zzpm();
            }
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
        }
        AdSize[] adSizeArr = this.zzchv;
        if (adSizeArr != null) {
            return adSizeArr[0];
        }
        return null;
    }

    public final AdSize[] getAdSizes() {
        return this.zzchv;
    }

    public final String getAdUnitId() {
        zzwu zzwu;
        if (this.zzbuo == null && (zzwu = this.zzbun) != null) {
            try {
                this.zzbuo = zzwu.getAdUnitId();
            } catch (RemoteException e) {
                zzbbd.zze("#007 Could not call remote method.", e);
            }
        }
        return this.zzbuo;
    }

    public final AppEventListener getAppEventListener() {
        return this.zzbnw;
    }

    public final String getMediationAdapterClassName() {
        try {
            zzwu zzwu = this.zzbun;
            if (zzwu != null) {
                return zzwu.zzkf();
            }
            return null;
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    public final OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzcjl;
    }

    @Nullable
    public final ResponseInfo getResponseInfo() {
        zzyf zzyf = null;
        try {
            zzwu zzwu = this.zzbun;
            if (zzwu != null) {
                zzyf = zzwu.zzkg();
            }
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
        }
        return ResponseInfo.zza(zzyf);
    }

    public final VideoController getVideoController() {
        return this.zzcjj;
    }

    public final VideoOptions getVideoOptions() {
        return this.zzbnn;
    }

    public final boolean isLoading() {
        try {
            zzwu zzwu = this.zzbun;
            if (zzwu != null) {
                return zzwu.isLoading();
            }
            return false;
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
            return false;
        }
    }

    public final void pause() {
        try {
            zzwu zzwu = this.zzbun;
            if (zzwu != null) {
                zzwu.pause();
            }
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
        }
    }

    public final void recordManualImpression() {
        if (!this.zzcji.getAndSet(true)) {
            try {
                zzwu zzwu = this.zzbun;
                if (zzwu != null) {
                    zzwu.zzkd();
                }
            } catch (RemoteException e) {
                zzbbd.zze("#007 Could not call remote method.", e);
            }
        }
    }

    public final void resume() {
        try {
            zzwu zzwu = this.zzbun;
            if (zzwu != null) {
                zzwu.resume();
            }
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setAdListener(AdListener adListener) {
        this.zzcgu = adListener;
        this.zzcjk.zza(adListener);
    }

    public final void setAdSizes(AdSize... adSizeArr) {
        if (this.zzchv == null) {
            zza(adSizeArr);
            return;
        }
        throw new IllegalStateException("The ad size can only be set once on AdView.");
    }

    public final void setAdUnitId(String str) {
        if (this.zzbuo == null) {
            this.zzbuo = str;
            return;
        }
        throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        try {
            this.zzbnw = appEventListener;
            zzwu zzwu = this.zzbun;
            if (zzwu != null) {
                zzwu.zza(appEventListener != null ? new zzvn(appEventListener) : null);
            }
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setManualImpressionsEnabled(boolean z) {
        this.zzbnu = z;
        try {
            zzwu zzwu = this.zzbun;
            if (zzwu != null) {
                zzwu.setManualImpressionsEnabled(z);
            }
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzcjl = onCustomRenderedAdLoadedListener;
        try {
            zzwu zzwu = this.zzbun;
            if (zzwu != null) {
                zzwu.zza(onCustomRenderedAdLoadedListener != null ? new zzabr(onCustomRenderedAdLoadedListener) : null);
            }
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setOnPaidEventListener(@Nullable OnPaidEventListener onPaidEventListener) {
        try {
            this.zzcjo = onPaidEventListener;
            zzwu zzwu = this.zzbun;
            if (zzwu != null) {
                zzwu.zza(new zzzt(onPaidEventListener));
            }
        } catch (RemoteException e) {
            zzbbd.zze("#008 Must be called on the main UI thread.", e);
        }
    }

    public final void setVideoOptions(VideoOptions videoOptions) {
        zzaac zzaac;
        this.zzbnn = videoOptions;
        try {
            zzwu zzwu = this.zzbun;
            if (zzwu != null) {
                if (videoOptions == null) {
                    zzaac = null;
                } else {
                    zzaac = new zzaac(videoOptions);
                }
                zzwu.zza(zzaac);
            }
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
        }
    }

    public final void zza(zzyo zzyo) {
        zzwu zzwu;
        try {
            zzwu zzwu2 = this.zzbun;
            if (zzwu2 == null) {
                if ((this.zzchv == null || this.zzbuo == null) && zzwu2 == null) {
                    throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
                }
                Context context = this.zzcjm.getContext();
                zzvj zza = zza(context, this.zzchv, this.zzcjn);
                if ("search_v2".equals(zza.zzacx)) {
                    zzwu = (zzwu) new zzvw(zzwe.zzpr(), context, zza, this.zzbuo).zzd(context, false);
                } else {
                    zzwu = (zzwu) new zzvq(zzwe.zzpr(), context, zza, this.zzbuo, this.zzbuq).zzd(context, false);
                }
                this.zzbun = zzwu;
                zzwu.zza(new zzuy(this.zzcjk));
                if (this.zzcgq != null) {
                    this.zzbun.zza(new zzuv(this.zzcgq));
                }
                if (this.zzbnw != null) {
                    this.zzbun.zza(new zzvn(this.zzbnw));
                }
                if (this.zzcjl != null) {
                    this.zzbun.zza(new zzabr(this.zzcjl));
                }
                if (this.zzbnn != null) {
                    this.zzbun.zza(new zzaac(this.zzbnn));
                }
                this.zzbun.zza(new zzzt(this.zzcjo));
                this.zzbun.setManualImpressionsEnabled(this.zzbnu);
                try {
                    IObjectWrapper zzkc = this.zzbun.zzkc();
                    if (zzkc != null) {
                        this.zzcjm.addView((View) ObjectWrapper.unwrap(zzkc));
                    }
                } catch (RemoteException e) {
                    zzbbd.zze("#007 Could not call remote method.", e);
                }
            }
            if (this.zzbun.zza(zzvh.zza(this.zzcjm.getContext(), zzyo))) {
                this.zzbuq.zzf(zzyo.zzqn());
            }
        } catch (RemoteException e2) {
            zzbbd.zze("#007 Could not call remote method.", e2);
        }
    }

    public final zzyg zzdt() {
        zzwu zzwu = this.zzbun;
        if (zzwu == null) {
            return null;
        }
        try {
            return zzwu.getVideoController();
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    public zzyq(ViewGroup viewGroup, int i) {
        this(viewGroup, null, false, zzvh.zzchm, i);
    }

    public zzyq(ViewGroup viewGroup, AttributeSet attributeSet, boolean z) {
        this(viewGroup, attributeSet, z, zzvh.zzchm, 0);
    }

    public zzyq(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, int i) {
        this(viewGroup, attributeSet, false, zzvh.zzchm, i);
    }

    @VisibleForTesting
    private zzyq(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzvh zzvh, zzwu zzwu, int i) {
        zzvj zzvj;
        this.zzbuq = new zzamr();
        this.zzcjj = new VideoController();
        this.zzcjk = new zzyt(this);
        this.zzcjm = viewGroup;
        this.zzacs = zzvh;
        this.zzbun = null;
        this.zzcji = new AtomicBoolean(false);
        this.zzcjn = i;
        if (attributeSet != null) {
            Context context = viewGroup.getContext();
            try {
                zzvo zzvo = new zzvo(context, attributeSet);
                this.zzchv = zzvo.zzy(z);
                this.zzbuo = zzvo.getAdUnitId();
                if (viewGroup.isInEditMode()) {
                    zzbat zzpq = zzwe.zzpq();
                    AdSize adSize = this.zzchv[0];
                    int i2 = this.zzcjn;
                    if (adSize.equals(AdSize.INVALID)) {
                        zzvj = zzvj.zzpl();
                    } else {
                        zzvj zzvj2 = new zzvj(context, adSize);
                        zzvj2.zzchq = zzcz(i2);
                        zzvj = zzvj2;
                    }
                    zzpq.zza(viewGroup, zzvj, "Ads by Google");
                }
            } catch (IllegalArgumentException e) {
                zzwe.zzpq().zza(viewGroup, new zzvj(context, AdSize.BANNER), e.getMessage(), e.getMessage());
            }
        }
    }

    public final void zza(zzut zzut) {
        try {
            this.zzcgq = zzut;
            zzwu zzwu = this.zzbun;
            if (zzwu != null) {
                zzwu.zza(zzut != null ? new zzuv(zzut) : null);
            }
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
        }
    }

    @VisibleForTesting
    private zzyq(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzvh zzvh, int i) {
        this(viewGroup, attributeSet, z, zzvh, null, i);
    }

    public final void zza(AdSize... adSizeArr) {
        this.zzchv = adSizeArr;
        try {
            zzwu zzwu = this.zzbun;
            if (zzwu != null) {
                zzwu.zza(zza(this.zzcjm.getContext(), this.zzchv, this.zzcjn));
            }
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
        }
        this.zzcjm.requestLayout();
    }

    public final boolean zza(zzwu zzwu) {
        if (zzwu == null) {
            return false;
        }
        try {
            IObjectWrapper zzkc = zzwu.zzkc();
            if (zzkc == null || ((View) ObjectWrapper.unwrap(zzkc)).getParent() != null) {
                return false;
            }
            this.zzcjm.addView((View) ObjectWrapper.unwrap(zzkc));
            this.zzbun = zzwu;
            return true;
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
            return false;
        }
    }

    private static zzvj zza(Context context, AdSize[] adSizeArr, int i) {
        for (AdSize adSize : adSizeArr) {
            if (adSize.equals(AdSize.INVALID)) {
                return zzvj.zzpl();
            }
        }
        zzvj zzvj = new zzvj(context, adSizeArr);
        zzvj.zzchq = zzcz(i);
        return zzvj;
    }
}

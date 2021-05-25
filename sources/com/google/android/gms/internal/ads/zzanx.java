package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.AdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
public final class zzanx<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> implements MediationBannerListener, MediationInterstitialListener {
    private final zzana zzdks;

    public zzanx(zzana zzana) {
        this.zzdks = zzana;
    }

    public static /* synthetic */ zzana zza(zzanx zzanx) {
        return zzanx.zzdks;
    }

    @Override // com.google.ads.mediation.MediationBannerListener
    public final void onClick(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzbbd.zzef("Adapter called onClick.");
        zzwe.zzpq();
        if (!zzbat.zzyn()) {
            zzbbd.zze("#008 Must be called on the main UI thread.", null);
            zzbat.zzaah.post(new zzaoa(this));
            return;
        }
        try {
            this.zzdks.onAdClicked();
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.ads.mediation.MediationBannerListener
    public final void onDismissScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzbbd.zzef("Adapter called onDismissScreen.");
        zzwe.zzpq();
        if (!zzbat.zzyn()) {
            zzbbd.zzfe("#008 Must be called on the main UI thread.");
            zzbat.zzaah.post(new zzaob(this));
            return;
        }
        try {
            this.zzdks.onAdClosed();
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.ads.mediation.MediationBannerListener
    public final void onFailedToReceiveAd(MediationBannerAdapter<?, ?> mediationBannerAdapter, AdRequest.ErrorCode errorCode) {
        String valueOf = String.valueOf(errorCode);
        StringBuilder sb = new StringBuilder(valueOf.length() + 47);
        sb.append("Adapter called onFailedToReceiveAd with error. ");
        sb.append(valueOf);
        zzbbd.zzef(sb.toString());
        zzwe.zzpq();
        if (!zzbat.zzyn()) {
            zzbbd.zze("#008 Must be called on the main UI thread.", null);
            zzbat.zzaah.post(new zzaoe(this, errorCode));
            return;
        }
        try {
            this.zzdks.onAdFailedToLoad(zzaoj.zza(errorCode));
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.ads.mediation.MediationBannerListener
    public final void onLeaveApplication(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzbbd.zzef("Adapter called onLeaveApplication.");
        zzwe.zzpq();
        if (!zzbat.zzyn()) {
            zzbbd.zze("#008 Must be called on the main UI thread.", null);
            zzbat.zzaah.post(new zzaod(this));
            return;
        }
        try {
            this.zzdks.onAdLeftApplication();
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.ads.mediation.MediationBannerListener
    public final void onPresentScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzbbd.zzef("Adapter called onPresentScreen.");
        zzwe.zzpq();
        if (!zzbat.zzyn()) {
            zzbbd.zze("#008 Must be called on the main UI thread.", null);
            zzbat.zzaah.post(new zzaog(this));
            return;
        }
        try {
            this.zzdks.onAdOpened();
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.ads.mediation.MediationBannerListener
    public final void onReceivedAd(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzbbd.zzef("Adapter called onReceivedAd.");
        zzwe.zzpq();
        if (!zzbat.zzyn()) {
            zzbbd.zze("#008 Must be called on the main UI thread.", null);
            zzbat.zzaah.post(new zzaof(this));
            return;
        }
        try {
            this.zzdks.onAdLoaded();
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialListener
    public final void onDismissScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzbbd.zzef("Adapter called onDismissScreen.");
        zzwe.zzpq();
        if (!zzbat.zzyn()) {
            zzbbd.zze("#008 Must be called on the main UI thread.", null);
            zzbat.zzaah.post(new zzaoi(this));
            return;
        }
        try {
            this.zzdks.onAdClosed();
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialListener
    public final void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, AdRequest.ErrorCode errorCode) {
        String valueOf = String.valueOf(errorCode);
        StringBuilder sb = new StringBuilder(valueOf.length() + 47);
        sb.append("Adapter called onFailedToReceiveAd with error ");
        sb.append(valueOf);
        sb.append(".");
        zzbbd.zzef(sb.toString());
        zzwe.zzpq();
        if (!zzbat.zzyn()) {
            zzbbd.zze("#008 Must be called on the main UI thread.", null);
            zzbat.zzaah.post(new zzaoh(this, errorCode));
            return;
        }
        try {
            this.zzdks.onAdFailedToLoad(zzaoj.zza(errorCode));
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialListener
    public final void onLeaveApplication(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzbbd.zzef("Adapter called onLeaveApplication.");
        zzwe.zzpq();
        if (!zzbat.zzyn()) {
            zzbbd.zze("#008 Must be called on the main UI thread.", null);
            zzbat.zzaah.post(new zzaok(this));
            return;
        }
        try {
            this.zzdks.onAdLeftApplication();
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialListener
    public final void onPresentScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzbbd.zzef("Adapter called onPresentScreen.");
        zzwe.zzpq();
        if (!zzbat.zzyn()) {
            zzbbd.zze("#008 Must be called on the main UI thread.", null);
            zzbat.zzaah.post(new zzanz(this));
            return;
        }
        try {
            this.zzdks.onAdOpened();
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialListener
    public final void onReceivedAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzbbd.zzef("Adapter called onReceivedAd.");
        zzwe.zzpq();
        if (!zzbat.zzyn()) {
            zzbbd.zze("#008 Must be called on the main UI thread.", null);
            zzbat.zzaah.post(new zzaoc(this));
            return;
        }
        try {
            this.zzdks.onAdLoaded();
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
        }
    }
}

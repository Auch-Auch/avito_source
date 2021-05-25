package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.concurrent.GuardedBy;
public final class zzdkr extends zzatp {
    private final zzdli zzfsl;
    @GuardedBy("this")
    private boolean zzgqs = false;
    private final zzdkd zzgzu;
    private final zzdje zzgzv;
    @Nullable
    @GuardedBy("this")
    private zzchu zzgzw;

    public zzdkr(zzdkd zzdkd, zzdje zzdje, zzdli zzdli) {
        this.zzgzu = zzdkd;
        this.zzgzv = zzdje;
        this.zzfsl = zzdli;
    }

    private final synchronized boolean zzaqd() {
        zzchu zzchu;
        zzchu = this.zzgzw;
        return zzchu != null && !zzchu.isClosed();
    }

    @Override // com.google.android.gms.internal.ads.zzatm
    public final void destroy() throws RemoteException {
        zzl(null);
    }

    @Override // com.google.android.gms.internal.ads.zzatm
    public final Bundle getAdMetadata() {
        Preconditions.checkMainThread("getAdMetadata can only be called from the UI thread.");
        zzchu zzchu = this.zzgzw;
        return zzchu != null ? zzchu.getAdMetadata() : new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzatm
    public final synchronized String getMediationAdapterClassName() throws RemoteException {
        zzchu zzchu = this.zzgzw;
        if (zzchu == null || zzchu.zzaim() == null) {
            return null;
        }
        return this.zzgzw.zzaim().getMediationAdapterClassName();
    }

    @Override // com.google.android.gms.internal.ads.zzatm
    public final boolean isLoaded() throws RemoteException {
        Preconditions.checkMainThread("isLoaded must be called on the main UI thread.");
        return zzaqd();
    }

    @Override // com.google.android.gms.internal.ads.zzatm
    public final void pause() {
        zzj(null);
    }

    @Override // com.google.android.gms.internal.ads.zzatm
    public final void resume() {
        zzk(null);
    }

    @Override // com.google.android.gms.internal.ads.zzatm
    public final void setAppPackageName(String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzatm
    public final synchronized void setCustomData(String str) throws RemoteException {
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcod)).booleanValue()) {
            Preconditions.checkMainThread("#008 Must be called on the main UI thread.: setCustomData");
            this.zzfsl.zzdvf = str;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatm
    public final synchronized void setImmersiveMode(boolean z) {
        Preconditions.checkMainThread("setImmersiveMode must be called on the main UI thread.");
        this.zzgqs = z;
    }

    @Override // com.google.android.gms.internal.ads.zzatm
    public final synchronized void setUserId(String str) throws RemoteException {
        Preconditions.checkMainThread("setUserId must be called on the main UI thread.");
        this.zzfsl.zzdve = str;
    }

    @Override // com.google.android.gms.internal.ads.zzatm
    public final synchronized void show() throws RemoteException {
        zzi(null);
    }

    @Override // com.google.android.gms.internal.ads.zzatm
    public final synchronized void zza(zzatz zzatz) throws RemoteException {
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        if (!zzaav.zzct(zzatz.zzbuo)) {
            if (zzaqd()) {
                if (!((Boolean) zzwe.zzpu().zzd(zzaat.zzcui)).booleanValue()) {
                    return;
                }
            }
            zzdka zzdka = new zzdka(null);
            this.zzgzw = null;
            this.zzgzu.zzea(zzdlf.zzhbh);
            this.zzgzu.zza(zzatz.zzdpw, zzatz.zzbuo, zzdka, new zzdkq(this));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatm
    public final synchronized void zzi(@Nullable IObjectWrapper iObjectWrapper) throws RemoteException {
        Activity activity;
        Preconditions.checkMainThread("showAd must be called on the main UI thread.");
        if (this.zzgzw != null) {
            if (iObjectWrapper != null) {
                Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
                if (unwrap instanceof Activity) {
                    activity = (Activity) unwrap;
                    this.zzgzw.zzb(this.zzgqs, activity);
                }
            }
            activity = null;
            this.zzgzw.zzb(this.zzgqs, activity);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatm
    public final synchronized void zzj(IObjectWrapper iObjectWrapper) {
        Context context;
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
        if (this.zzgzw != null) {
            if (iObjectWrapper == null) {
                context = null;
            } else {
                context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
            }
            this.zzgzw.zzail().zzbz(context);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatm
    public final synchronized void zzk(IObjectWrapper iObjectWrapper) {
        Context context;
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
        if (this.zzgzw != null) {
            if (iObjectWrapper == null) {
                context = null;
            } else {
                context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
            }
            this.zzgzw.zzail().zzca(context);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatm
    public final synchronized zzyf zzkg() throws RemoteException {
        if (!((Boolean) zzwe.zzpu().zzd(zzaat.zzcwy)).booleanValue()) {
            return null;
        }
        zzchu zzchu = this.zzgzw;
        if (zzchu == null) {
            return null;
        }
        return zzchu.zzaim();
    }

    @Override // com.google.android.gms.internal.ads.zzatm
    public final synchronized void zzl(IObjectWrapper iObjectWrapper) {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        Context context = null;
        this.zzgzv.zza(null);
        if (this.zzgzw != null) {
            if (iObjectWrapper != null) {
                context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
            }
            this.zzgzw.zzail().zzcb(context);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzatm
    public final boolean zzqx() {
        zzchu zzchu = this.zzgzw;
        return zzchu != null && zzchu.zzqx();
    }

    @Override // com.google.android.gms.internal.ads.zzatm
    public final void zza(zzatt zzatt) throws RemoteException {
        Preconditions.checkMainThread("setRewardedVideoAdListener can only be called from the UI thread.");
        this.zzgzv.zzb(zzatt);
    }

    @Override // com.google.android.gms.internal.ads.zzatm
    public final void zza(zzatk zzatk) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.: setRewardedAdSkuListener");
        this.zzgzv.zzb(zzatk);
    }

    @Override // com.google.android.gms.internal.ads.zzatm
    public final void zza(zzxb zzxb) {
        Preconditions.checkMainThread("setAdMetadataListener can only be called from the UI thread.");
        if (zzxb == null) {
            this.zzgzv.zza(null);
        } else {
            this.zzgzv.zza(new zzdkt(this, zzxb));
        }
    }
}

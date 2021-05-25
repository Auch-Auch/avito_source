package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import java.util.List;
public final class zzcgx extends zzafv {
    @Nullable
    private final String zzfqh;
    private final zzccv zzfvt;
    private final zzcco zzfyz;

    public zzcgx(@Nullable String str, zzcco zzcco, zzccv zzccv) {
        this.zzfqh = str;
        this.zzfyz = zzcco;
        this.zzfvt = zzccv;
    }

    @Override // com.google.android.gms.internal.ads.zzafw
    public final void cancelUnconfirmedClick() throws RemoteException {
        this.zzfyz.cancelUnconfirmedClick();
    }

    @Override // com.google.android.gms.internal.ads.zzafw
    public final void destroy() throws RemoteException {
        this.zzfyz.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzafw
    public final String getAdvertiser() throws RemoteException {
        return this.zzfvt.getAdvertiser();
    }

    @Override // com.google.android.gms.internal.ads.zzafw
    public final String getBody() throws RemoteException {
        return this.zzfvt.getBody();
    }

    @Override // com.google.android.gms.internal.ads.zzafw
    public final String getCallToAction() throws RemoteException {
        return this.zzfvt.getCallToAction();
    }

    @Override // com.google.android.gms.internal.ads.zzafw
    public final Bundle getExtras() throws RemoteException {
        return this.zzfvt.getExtras();
    }

    @Override // com.google.android.gms.internal.ads.zzafw
    public final String getHeadline() throws RemoteException {
        return this.zzfvt.getHeadline();
    }

    @Override // com.google.android.gms.internal.ads.zzafw
    public final List<?> getImages() throws RemoteException {
        return this.zzfvt.getImages();
    }

    @Override // com.google.android.gms.internal.ads.zzafw
    public final String getMediationAdapterClassName() throws RemoteException {
        return this.zzfqh;
    }

    @Override // com.google.android.gms.internal.ads.zzafw
    public final List<?> getMuteThisAdReasons() throws RemoteException {
        if (isCustomMuteThisAdEnabled()) {
            return this.zzfvt.getMuteThisAdReasons();
        }
        return Collections.emptyList();
    }

    @Override // com.google.android.gms.internal.ads.zzafw
    public final String getPrice() throws RemoteException {
        return this.zzfvt.getPrice();
    }

    @Override // com.google.android.gms.internal.ads.zzafw
    public final double getStarRating() throws RemoteException {
        return this.zzfvt.getStarRating();
    }

    @Override // com.google.android.gms.internal.ads.zzafw
    public final String getStore() throws RemoteException {
        return this.zzfvt.getStore();
    }

    @Override // com.google.android.gms.internal.ads.zzafw
    public final zzyg getVideoController() throws RemoteException {
        return this.zzfvt.getVideoController();
    }

    @Override // com.google.android.gms.internal.ads.zzafw
    public final boolean isCustomClickGestureEnabled() {
        return this.zzfyz.isCustomClickGestureEnabled();
    }

    @Override // com.google.android.gms.internal.ads.zzafw
    public final boolean isCustomMuteThisAdEnabled() throws RemoteException {
        return !this.zzfvt.getMuteThisAdReasons().isEmpty() && this.zzfvt.zzalq() != null;
    }

    @Override // com.google.android.gms.internal.ads.zzafw
    public final void performClick(Bundle bundle) throws RemoteException {
        this.zzfyz.zzg(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzafw
    public final void recordCustomClickGesture() {
        this.zzfyz.recordCustomClickGesture();
    }

    @Override // com.google.android.gms.internal.ads.zzafw
    public final boolean recordImpression(Bundle bundle) throws RemoteException {
        return this.zzfyz.zzi(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzafw
    public final void reportTouchEvent(Bundle bundle) throws RemoteException {
        this.zzfyz.zzh(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzafw
    public final void zza(zzafr zzafr) throws RemoteException {
        this.zzfyz.zza(zzafr);
    }

    @Override // com.google.android.gms.internal.ads.zzafw
    public final zzyf zzkg() throws RemoteException {
        if (!((Boolean) zzwe.zzpu().zzd(zzaat.zzcwy)).booleanValue()) {
            return null;
        }
        return this.zzfyz.zzaim();
    }

    @Override // com.google.android.gms.internal.ads.zzafw
    public final IObjectWrapper zzsg() throws RemoteException {
        return ObjectWrapper.wrap(this.zzfyz);
    }

    @Override // com.google.android.gms.internal.ads.zzafw
    public final zzadw zzsh() throws RemoteException {
        return this.zzfvt.zzsh();
    }

    @Override // com.google.android.gms.internal.ads.zzafw
    public final zzado zzsi() throws RemoteException {
        return this.zzfvt.zzsi();
    }

    @Override // com.google.android.gms.internal.ads.zzafw
    public final IObjectWrapper zzsj() throws RemoteException {
        return this.zzfvt.zzsj();
    }

    @Override // com.google.android.gms.internal.ads.zzafw
    public final void zzsr() {
        this.zzfyz.zzsr();
    }

    @Override // com.google.android.gms.internal.ads.zzafw
    public final zzadr zzss() throws RemoteException {
        return this.zzfyz.zzalk().zzss();
    }

    @Override // com.google.android.gms.internal.ads.zzafw
    public final void zza(@Nullable zzxv zzxv) throws RemoteException {
        this.zzfyz.zza(zzxv);
    }

    @Override // com.google.android.gms.internal.ads.zzafw
    public final void zza(zzxr zzxr) throws RemoteException {
        this.zzfyz.zza(zzxr);
    }

    @Override // com.google.android.gms.internal.ads.zzafw
    public final void zza(zzya zzya) throws RemoteException {
        this.zzfyz.zza(zzya);
    }
}

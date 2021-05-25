package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
public final class zzcwz extends zzwx {
    private final ViewGroup zzfnx;
    private final zzdln zzfqn;
    private final zzwl zzfvl;
    private final zzbni zzgpm;
    private final Context zzvr;

    public zzcwz(Context context, @Nullable zzwl zzwl, zzdln zzdln, zzbni zzbni) {
        this.zzvr = context;
        this.zzfvl = zzwl;
        this.zzfqn = zzdln;
        this.zzgpm = zzbni;
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.removeAllViews();
        frameLayout.addView(zzbni.zzahq(), zzp.zzkr().zzxt());
        frameLayout.setMinimumHeight(zzke().heightPixels);
        frameLayout.setMinimumWidth(zzke().widthPixels);
        this.zzfnx = frameLayout;
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void destroy() throws RemoteException {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzgpm.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final Bundle getAdMetadata() throws RemoteException {
        zzbbd.zzfd("getAdMetadata is not supported in Publisher AdView returned by AdLoader.");
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final String getAdUnitId() throws RemoteException {
        return this.zzfqn.zzhbv;
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final String getMediationAdapterClassName() throws RemoteException {
        if (this.zzgpm.zzaim() != null) {
            return this.zzgpm.zzaim().getMediationAdapterClassName();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final zzyg getVideoController() throws RemoteException {
        return this.zzgpm.getVideoController();
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final boolean isLoading() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final boolean isReady() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void pause() throws RemoteException {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzgpm.zzail().zzbz(null);
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void resume() throws RemoteException {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzgpm.zzail().zzca(null);
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void setImmersiveMode(boolean z) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void setManualImpressionsEnabled(boolean z) throws RemoteException {
        zzbbd.zzfd("setManualImpressionsEnabled is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void setUserId(String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void showInterstitial() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void stopLoading() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zza(zzaqv zzaqv) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zza(zzarb zzarb, String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zza(zzatt zzatt) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zza(zzsi zzsi) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zza(zzvm zzvm) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zza(zzym zzym) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final boolean zza(zzvc zzvc) throws RemoteException {
        zzbbd.zzfd("loadAd is not supported for a Publisher AdView returned from AdLoader.");
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zzbp(String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final IObjectWrapper zzkc() throws RemoteException {
        return ObjectWrapper.wrap(this.zzfnx);
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zzkd() throws RemoteException {
        this.zzgpm.zzkd();
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final zzvj zzke() {
        Preconditions.checkMainThread("getAdSize must be called on the main UI thread.");
        return zzdls.zzb(this.zzvr, Collections.singletonList(this.zzgpm.zzahp()));
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final String zzkf() throws RemoteException {
        if (this.zzgpm.zzaim() != null) {
            return this.zzgpm.zzaim().getMediationAdapterClassName();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final zzyf zzkg() {
        return this.zzgpm.zzaim();
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final zzxc zzkh() throws RemoteException {
        return this.zzfqn.zzhca;
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final zzwl zzki() throws RemoteException {
        return this.zzfvl;
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zza(zzaac zzaac) throws RemoteException {
        zzbbd.zzfd("setVideoOptions is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zza(zzvj zzvj) throws RemoteException {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
        zzbni zzbni = this.zzgpm;
        if (zzbni != null) {
            zzbni.zza(this.zzfnx, zzvj);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zza(zzabq zzabq) throws RemoteException {
        zzbbd.zzfd("setOnCustomRenderedAdLoadedListener is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zza(zzwg zzwg) throws RemoteException {
        zzbbd.zzfd("setAdClickListener is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zza(zzxi zzxi) throws RemoteException {
        zzbbd.zzfd("setCorrelationIdProvider is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zza(zzwl zzwl) throws RemoteException {
        zzbbd.zzfd("setAdListener is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zza(zzxc zzxc) throws RemoteException {
        zzbbd.zzfd("setAppEventListener is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zza(zzxb zzxb) throws RemoteException {
        zzbbd.zzfd("setAdMetadataListener is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzwu
    public final void zza(zzya zzya) {
        zzbbd.zzfd("setOnPaidEventListener is not supported in Publisher AdView returned by AdLoader.");
    }
}

package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
public class zzcvw extends zzamz {
    private final zzbue zzfpt;
    private final zzbtu zzfqj;
    private final zzbtb zzfuw;
    private final zzbur zzfvb;
    private final zzbtl zzfvu;
    private final zzbst zzfvv;
    private final zzbws zzgct;
    private final zzbwp zzgof;
    private final zzbzh zzgoq;

    public zzcvw(zzbst zzbst, zzbtl zzbtl, zzbtu zzbtu, zzbue zzbue, zzbws zzbws, zzbur zzbur, zzbzh zzbzh, zzbwp zzbwp, zzbtb zzbtb) {
        this.zzfvv = zzbst;
        this.zzfvu = zzbtl;
        this.zzfqj = zzbtu;
        this.zzfpt = zzbue;
        this.zzgct = zzbws;
        this.zzfvb = zzbur;
        this.zzgoq = zzbzh;
        this.zzgof = zzbwp;
        this.zzfuw = zzbtb;
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void onAdClicked() {
        this.zzfvv.onAdClicked();
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void onAdClosed() {
        this.zzfvb.zzui();
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void onAdFailedToLoad(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public void onAdImpression() {
        this.zzfvu.onAdImpression();
        this.zzgof.zzaiy();
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void onAdLeftApplication() {
        this.zzfqj.onAdLeftApplication();
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void onAdLoaded() {
        this.zzfpt.onAdLoaded();
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void onAdOpened() {
        this.zzfvb.zzuj();
        this.zzgof.zzaja();
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void onAppEvent(String str, String str2) {
        this.zzgct.onAppEvent(str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public void onVideoEnd() {
        this.zzgoq.onVideoEnd();
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void onVideoPause() {
        this.zzgoq.onVideoPause();
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void onVideoPlay() throws RemoteException {
        this.zzgoq.onVideoPlay();
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void zza(zzaes zzaes, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void zza(zzanb zzanb) {
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public void zza(zzaug zzaug) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void zzb(Bundle bundle) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public void zzb(zzaue zzaue) {
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void zzb(zzuw zzuw) {
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void zzc(int i, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzana
    @Deprecated
    public final void zzdd(int i) throws RemoteException {
        this.zzfuw.zzh(zzdmb.zza(zzdmd.zzhcv, new zzuw(i, "", AdError.UNDEFINED_DOMAIN, null)));
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void zzdn(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public final void zzdo(String str) {
        this.zzfuw.zzh(zzdmb.zza(zzdmd.zzhcv, new zzuw(0, str, AdError.UNDEFINED_DOMAIN, null)));
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public void zzty() {
        this.zzgoq.onVideoStart();
    }

    @Override // com.google.android.gms.internal.ads.zzana
    public void zztz() throws RemoteException {
    }
}

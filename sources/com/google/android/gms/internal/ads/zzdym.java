package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzebt;
import java.security.GeneralSecurityException;
public final class zzdym extends zzdwx<zzecj> {
    public zzdym() {
        super(zzecj.class, new zzdyp(zzdwq.class));
    }

    @Override // com.google.android.gms.internal.ads.zzdwx
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey";
    }

    @Override // com.google.android.gms.internal.ads.zzdwx
    public final zzebt.zza zzaxs() {
        return zzebt.zza.REMOTE;
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzdxa<com.google.android.gms.internal.ads.zzecm, com.google.android.gms.internal.ads.zzecj>' to match base method */
    @Override // com.google.android.gms.internal.ads.zzdwx
    public final zzdxa<?, zzecj> zzaxv() {
        return new zzdyo(this, zzecm.class);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzehz] */
    @Override // com.google.android.gms.internal.ads.zzdwx
    public final /* synthetic */ void zzc(zzecj zzecj) throws GeneralSecurityException {
        zzeej.zzy(zzecj.getVersion(), 0);
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzehz' to match base method */
    @Override // com.google.android.gms.internal.ads.zzdwx
    public final /* synthetic */ zzecj zzp(zzeff zzeff) throws zzegz {
        return zzecj.zzv(zzeff, zzegc.zzbex());
    }
}

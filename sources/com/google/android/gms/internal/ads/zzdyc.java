package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzebt;
import java.security.GeneralSecurityException;
public final class zzdyc extends zzdwx<zzeam> {
    public zzdyc() {
        super(zzeam.class, new zzdyf(zzdwq.class));
    }

    @Override // com.google.android.gms.internal.ads.zzdwx
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesGcmKey";
    }

    @Override // com.google.android.gms.internal.ads.zzdwx
    public final zzebt.zza zzaxs() {
        return zzebt.zza.SYMMETRIC;
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzdxa<com.google.android.gms.internal.ads.zzeap, com.google.android.gms.internal.ads.zzeam>' to match base method */
    @Override // com.google.android.gms.internal.ads.zzdwx
    public final zzdxa<?, zzeam> zzaxv() {
        return new zzdye(this, zzeap.class);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzehz] */
    @Override // com.google.android.gms.internal.ads.zzdwx
    public final /* synthetic */ void zzc(zzeam zzeam) throws GeneralSecurityException {
        zzeam zzeam2 = zzeam;
        zzeej.zzy(zzeam2.getVersion(), 0);
        zzeej.zzfp(zzeam2.zzayi().size());
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzehz' to match base method */
    @Override // com.google.android.gms.internal.ads.zzdwx
    public final /* synthetic */ zzeam zzp(zzeff zzeff) throws zzegz {
        return zzeam.zzk(zzeff, zzegc.zzbex());
    }
}

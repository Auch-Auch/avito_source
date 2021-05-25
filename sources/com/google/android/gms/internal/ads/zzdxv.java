package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzebt;
import java.security.GeneralSecurityException;
public final class zzdxv extends zzdwx<zzdzw> {
    public zzdxv() {
        super(zzdzw.class, new zzdxu(zzdwq.class));
    }

    @Override // com.google.android.gms.internal.ads.zzdwx
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    }

    @Override // com.google.android.gms.internal.ads.zzdwx
    public final zzebt.zza zzaxs() {
        return zzebt.zza.SYMMETRIC;
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzdxa<com.google.android.gms.internal.ads.zzdzz, com.google.android.gms.internal.ads.zzdzw>' to match base method */
    @Override // com.google.android.gms.internal.ads.zzdwx
    public final zzdxa<?, zzdzw> zzaxv() {
        return new zzdxx(this, zzdzz.class);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzehz] */
    @Override // com.google.android.gms.internal.ads.zzdwx
    public final /* synthetic */ void zzc(zzdzw zzdzw) throws GeneralSecurityException {
        zzeej.zzy(zzdzw.getVersion(), 0);
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzehz' to match base method */
    @Override // com.google.android.gms.internal.ads.zzdwx
    public final /* synthetic */ zzdzw zzp(zzeff zzeff) throws zzegz {
        return zzdzw.zze(zzeff, zzegc.zzbex());
    }
}

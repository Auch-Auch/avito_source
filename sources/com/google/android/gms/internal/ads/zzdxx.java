package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
public final class zzdxx extends zzdxa<zzdzz, zzdzw> {
    private final /* synthetic */ zzdxv zzhse;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzdxx(zzdxv zzdxv, Class cls) {
        super(cls);
        this.zzhse = zzdxv;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzehz] */
    @Override // com.google.android.gms.internal.ads.zzdxa
    public final /* synthetic */ void zzd(zzdzz zzdzz) throws GeneralSecurityException {
        zzdzz zzdzz2 = zzdzz;
        new zzdxw().zzaxv().zzd(zzdzz2.zzayu());
        new zzdzk().zzaxv().zzd(zzdzz2.zzayv());
        zzeej.zzfp(zzdzz2.zzayu().getKeySize());
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzehz] */
    @Override // com.google.android.gms.internal.ads.zzdxa
    public final /* synthetic */ zzdzw zze(zzdzz zzdzz) throws GeneralSecurityException {
        zzdzz zzdzz2 = zzdzz;
        return (zzdzw) ((zzegp) zzdzw.zzays().zzb(new zzdxw().zzaxv().zze(zzdzz2.zzayu())).zzb(new zzdzk().zzaxv().zze(zzdzz2.zzayv())).zzet(0).zzbfx());
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzehz' to match base method */
    @Override // com.google.android.gms.internal.ads.zzdxa
    public final /* synthetic */ zzdzz zzr(zzeff zzeff) throws zzegz {
        return zzdzz.zzf(zzeff, zzegc.zzbex());
    }
}

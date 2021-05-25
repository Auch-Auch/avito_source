package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
public final class zzdxy extends zzdxa<zzead, zzeaa> {
    private final /* synthetic */ zzdxw zzhsf;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzdxy(zzdxw zzdxw, Class cls) {
        super(cls);
        this.zzhsf = zzdxw;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzehz] */
    @Override // com.google.android.gms.internal.ads.zzdxa
    public final /* synthetic */ void zzd(zzead zzead) throws GeneralSecurityException {
        zzead zzead2 = zzead;
        zzeej.zzfp(zzead2.getKeySize());
        zzdxw zzdxw = this.zzhsf;
        zzdxw.zza(zzead2.zzayx());
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzehz] */
    @Override // com.google.android.gms.internal.ads.zzdxa
    public final /* synthetic */ zzeaa zze(zzead zzead) throws GeneralSecurityException {
        zzead zzead2 = zzead;
        return (zzeaa) ((zzegp) zzeaa.zzayy().zzc(zzead2.zzayx()).zzu(zzeff.zzu(zzeei.zzfo(zzead2.getKeySize()))).zzeu(0).zzbfx());
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzehz' to match base method */
    @Override // com.google.android.gms.internal.ads.zzdxa
    public final /* synthetic */ zzead zzr(zzeff zzeff) throws zzegz {
        return zzead.zzh(zzeff, zzegc.zzbex());
    }
}

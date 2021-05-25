package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
public final class zzdzh extends zzdxa<zzdzs, zzdzr> {
    public zzdzh(zzdzf zzdzf, Class cls) {
        super(cls);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzehz] */
    @Override // com.google.android.gms.internal.ads.zzdxa
    public final /* synthetic */ void zzd(zzdzs zzdzs) throws GeneralSecurityException {
        zzdzs zzdzs2 = zzdzs;
        zzdzf.zzb(zzdzs2.zzayj());
        zzdzf.zzer(zzdzs2.getKeySize());
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzehz] */
    @Override // com.google.android.gms.internal.ads.zzdxa
    public final /* synthetic */ zzdzr zze(zzdzs zzdzs) throws GeneralSecurityException {
        zzdzs zzdzs2 = zzdzs;
        return (zzdzr) ((zzegp) zzdzr.zzayk().zzes(0).zzt(zzeff.zzu(zzeei.zzfo(zzdzs2.getKeySize()))).zzd(zzdzs2.zzayj()).zzbfx());
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzehz' to match base method */
    @Override // com.google.android.gms.internal.ads.zzdxa
    public final /* synthetic */ zzdzs zzr(zzeff zzeff) throws zzegz {
        return zzdzs.zzd(zzeff, zzegc.zzbex());
    }
}

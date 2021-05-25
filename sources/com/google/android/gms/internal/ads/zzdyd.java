package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
public final class zzdyd extends zzdxa<zzeai, zzeah> {
    private final /* synthetic */ zzdyb zzhsg;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzdyd(zzdyb zzdyb, Class cls) {
        super(cls);
        this.zzhsg = zzdyb;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzehz] */
    @Override // com.google.android.gms.internal.ads.zzdxa
    public final /* synthetic */ void zzd(zzeai zzeai) throws GeneralSecurityException {
        zzeai zzeai2 = zzeai;
        zzeej.zzfp(zzeai2.getKeySize());
        if (zzeai2.zzazg().zzazd() != 12 && zzeai2.zzazg().zzazd() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzehz] */
    @Override // com.google.android.gms.internal.ads.zzdxa
    public final /* synthetic */ zzeah zze(zzeai zzeai) throws GeneralSecurityException {
        zzeai zzeai2 = zzeai;
        return (zzeah) ((zzegp) zzeah.zzazh().zzv(zzeff.zzu(zzeei.zzfo(zzeai2.getKeySize()))).zzb(zzeai2.zzazg()).zzev(0).zzbfx());
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzehz' to match base method */
    @Override // com.google.android.gms.internal.ads.zzdxa
    public final /* synthetic */ zzeai zzr(zzeff zzeff) throws zzegz {
        return zzeai.zzj(zzeff, zzegc.zzbex());
    }
}

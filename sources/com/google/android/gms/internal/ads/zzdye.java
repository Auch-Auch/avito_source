package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
public final class zzdye extends zzdxa<zzeap, zzeam> {
    private final /* synthetic */ zzdyc zzhsh;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzdye(zzdyc zzdyc, Class cls) {
        super(cls);
        this.zzhsh = zzdyc;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzehz] */
    @Override // com.google.android.gms.internal.ads.zzdxa
    public final /* synthetic */ void zzd(zzeap zzeap) throws GeneralSecurityException {
        zzeej.zzfp(zzeap.getKeySize());
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzehz] */
    @Override // com.google.android.gms.internal.ads.zzdxa
    public final /* synthetic */ zzeam zze(zzeap zzeap) throws GeneralSecurityException {
        return (zzeam) ((zzegp) zzeam.zzazm().zzw(zzeff.zzu(zzeei.zzfo(zzeap.getKeySize()))).zzew(0).zzbfx());
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzehz' to match base method */
    @Override // com.google.android.gms.internal.ads.zzdxa
    public final /* synthetic */ zzeap zzr(zzeff zzeff) throws zzegz {
        return zzeap.zzl(zzeff, zzegc.zzbex());
    }
}

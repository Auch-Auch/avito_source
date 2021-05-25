package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;
public final class zzdyu extends zzdxa<zzeaz, zzebd> {
    private final /* synthetic */ zzdys zzhsq;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzdyu(zzdys zzdys, Class cls) {
        super(cls);
        this.zzhsq = zzdys;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzehz] */
    @Override // com.google.android.gms.internal.ads.zzdxa
    public final /* synthetic */ void zzd(zzeaz zzeaz) throws GeneralSecurityException {
        zzdze.zza(zzeaz.zzazv());
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzehz] */
    @Override // com.google.android.gms.internal.ads.zzdxa
    public final /* synthetic */ zzebd zze(zzeaz zzeaz) throws GeneralSecurityException {
        zzeaz zzeaz2 = zzeaz;
        KeyPair zza = zzedq.zza(zzedq.zza(zzdze.zza(zzeaz2.zzazv().zzazx().zzbak())));
        ECPoint w = ((ECPublicKey) zza.getPublic()).getW();
        return (zzebd) ((zzegp) zzebd.zzbad().zzez(0).zzb((zzebe) ((zzegp) zzebe.zzbah().zzfa(0).zzc(zzeaz2.zzazv()).zzab(zzeff.zzu(w.getAffineX().toByteArray())).zzac(zzeff.zzu(w.getAffineY().toByteArray())).zzbfx())).zzaa(zzeff.zzu(((ECPrivateKey) zza.getPrivate()).getS().toByteArray())).zzbfx());
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzehz' to match base method */
    @Override // com.google.android.gms.internal.ads.zzdxa
    public final /* synthetic */ zzeaz zzr(zzeff zzeff) throws zzegz {
        return zzeaz.zzo(zzeff, zzegc.zzbex());
    }
}

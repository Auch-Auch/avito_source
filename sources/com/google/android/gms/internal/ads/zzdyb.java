package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzebt;
import java.security.GeneralSecurityException;
public final class zzdyb extends zzdwx<zzeah> {
    public zzdyb() {
        super(zzeah.class, new zzdya(zzdwq.class));
    }

    @Override // com.google.android.gms.internal.ads.zzdwx
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesEaxKey";
    }

    @Override // com.google.android.gms.internal.ads.zzdwx
    public final zzebt.zza zzaxs() {
        return zzebt.zza.SYMMETRIC;
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzdxa<com.google.android.gms.internal.ads.zzeai, com.google.android.gms.internal.ads.zzeah>' to match base method */
    @Override // com.google.android.gms.internal.ads.zzdwx
    public final zzdxa<?, zzeah> zzaxv() {
        return new zzdyd(this, zzeai.class);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzehz] */
    @Override // com.google.android.gms.internal.ads.zzdwx
    public final /* synthetic */ void zzc(zzeah zzeah) throws GeneralSecurityException {
        zzeah zzeah2 = zzeah;
        zzeej.zzy(zzeah2.getVersion(), 0);
        zzeej.zzfp(zzeah2.zzayi().size());
        if (zzeah2.zzazg().zzazd() != 12 && zzeah2.zzazg().zzazd() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzehz' to match base method */
    @Override // com.google.android.gms.internal.ads.zzdwx
    public final /* synthetic */ zzeah zzp(zzeff zzeff) throws zzegz {
        return zzeah.zzi(zzeff, zzegc.zzbex());
    }
}

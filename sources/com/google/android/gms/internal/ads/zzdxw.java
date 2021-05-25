package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzebt;
import java.security.GeneralSecurityException;
public final class zzdxw extends zzdwx<zzeaa> {
    public zzdxw() {
        super(zzeaa.class, new zzdxz(zzeed.class));
    }

    /* access modifiers changed from: private */
    public static void zza(zzeae zzeae) throws GeneralSecurityException {
        if (zzeae.zzazd() < 12 || zzeae.zzazd() > 16) {
            throw new GeneralSecurityException("invalid IV size");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdwx
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesCtrKey";
    }

    @Override // com.google.android.gms.internal.ads.zzdwx
    public final zzebt.zza zzaxs() {
        return zzebt.zza.SYMMETRIC;
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzdxa<com.google.android.gms.internal.ads.zzead, com.google.android.gms.internal.ads.zzeaa>' to match base method */
    @Override // com.google.android.gms.internal.ads.zzdwx
    public final zzdxa<?, zzeaa> zzaxv() {
        return new zzdxy(this, zzead.class);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzehz] */
    @Override // com.google.android.gms.internal.ads.zzdwx
    public final /* synthetic */ void zzc(zzeaa zzeaa) throws GeneralSecurityException {
        zzeaa zzeaa2 = zzeaa;
        zzeej.zzy(zzeaa2.getVersion(), 0);
        zzeej.zzfp(zzeaa2.zzayi().size());
        zza(zzeaa2.zzayx());
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzehz' to match base method */
    @Override // com.google.android.gms.internal.ads.zzdwx
    public final /* synthetic */ zzeaa zzp(zzeff zzeff) throws zzegz {
        return zzeaa.zzg(zzeff, zzegc.zzbex());
    }
}

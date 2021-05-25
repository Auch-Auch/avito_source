package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzebt;
import java.security.GeneralSecurityException;
public final class zzdyh extends zzdwx<zzeaq> {
    public zzdyh() {
        super(zzeaq.class, new zzdyg(zzdwq.class));
    }

    @Override // com.google.android.gms.internal.ads.zzdwx
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key";
    }

    @Override // com.google.android.gms.internal.ads.zzdwx
    public final zzebt.zza zzaxs() {
        return zzebt.zza.SYMMETRIC;
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzdxa<com.google.android.gms.internal.ads.zzeat, com.google.android.gms.internal.ads.zzeaq>' to match base method */
    @Override // com.google.android.gms.internal.ads.zzdwx
    public final zzdxa<?, zzeaq> zzaxv() {
        return new zzdyj(this, zzeat.class);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzehz] */
    @Override // com.google.android.gms.internal.ads.zzdwx
    public final /* synthetic */ void zzc(zzeaq zzeaq) throws GeneralSecurityException {
        zzeaq zzeaq2 = zzeaq;
        zzeej.zzy(zzeaq2.getVersion(), 0);
        if (zzeaq2.zzayi().size() != 32) {
            throw new GeneralSecurityException("invalid ChaCha20Poly1305Key: incorrect key length");
        }
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzehz' to match base method */
    @Override // com.google.android.gms.internal.ads.zzdwx
    public final /* synthetic */ zzeaq zzp(zzeff zzeff) throws zzegz {
        return zzeaq.zzm(zzeff, zzegc.zzbex());
    }
}

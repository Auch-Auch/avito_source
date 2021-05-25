package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzebt;
import java.security.GeneralSecurityException;
public final class zzdzf extends zzdwx<zzdzr> {
    public zzdzf() {
        super(zzdzr.class, new zzdzi(zzdxd.class));
    }

    public static void zza(zzdzv zzdzv) throws GeneralSecurityException {
        if (zzdzv.zzayn() < 10) {
            throw new GeneralSecurityException("tag size too short");
        } else if (zzdzv.zzayn() > 16) {
            throw new GeneralSecurityException("tag size too long");
        }
    }

    public static void zzeq(int i) throws GeneralSecurityException {
        if (i != 32) {
            throw new GeneralSecurityException("AesCmacKey size wrong, must be 16 bytes");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdwx
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesCmacKey";
    }

    @Override // com.google.android.gms.internal.ads.zzdwx
    public final zzebt.zza zzaxs() {
        return zzebt.zza.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.ads.zzdwx
    public final zzdxa<?, zzdzr> zzaxv() {
        return new zzdzh(this, zzdzs.class);
    }

    @Override // com.google.android.gms.internal.ads.zzdwx
    public final /* synthetic */ void zzc(zzdzr zzdzr) throws GeneralSecurityException {
        zzdzr zzdzr2 = zzdzr;
        zzeej.zzy(zzdzr2.getVersion(), 0);
        zzeq(zzdzr2.zzayi().size());
        zza(zzdzr2.zzayj());
    }

    @Override // com.google.android.gms.internal.ads.zzdwx
    public final /* synthetic */ zzdzr zzp(zzeff zzeff) throws zzegz {
        return zzdzr.zzc(zzeff, zzegc.zzbex());
    }
}

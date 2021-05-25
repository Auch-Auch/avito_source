package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzebt;
import java.security.GeneralSecurityException;
public final class zzdys extends zzdxj<zzebd, zzebe> {
    private static final byte[] zzhso = new byte[0];

    public zzdys() {
        super(zzebd.class, zzebe.class, new zzdyv(zzdwu.class));
    }

    @Override // com.google.android.gms.internal.ads.zzdwx
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey";
    }

    @Override // com.google.android.gms.internal.ads.zzdwx
    public final zzebt.zza zzaxs() {
        return zzebt.zza.ASYMMETRIC_PRIVATE;
    }

    @Override // com.google.android.gms.internal.ads.zzdwx
    public final zzdxa<zzeaz, zzebd> zzaxv() {
        return new zzdyu(this, zzeaz.class);
    }

    @Override // com.google.android.gms.internal.ads.zzdwx
    public final /* synthetic */ void zzc(zzehz zzehz) throws GeneralSecurityException {
        zzebd zzebd = (zzebd) zzehz;
        if (!zzebd.zzayi().isEmpty()) {
            zzeej.zzy(zzebd.getVersion(), 0);
            zzdze.zza(zzebd.zzbac().zzazv());
            return;
        }
        throw new GeneralSecurityException("invalid ECIES private key");
    }

    @Override // com.google.android.gms.internal.ads.zzdwx
    public final /* synthetic */ zzehz zzp(zzeff zzeff) throws zzegz {
        return zzebd.zzp(zzeff, zzegc.zzbex());
    }
}

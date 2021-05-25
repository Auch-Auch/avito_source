package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;
public final class zzdzj extends zzdwz<zzdxd, zzebl> {
    public zzdzj(Class cls) {
        super(cls);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdwz
    public final /* synthetic */ zzdxd zzag(zzebl zzebl) throws GeneralSecurityException {
        zzebl zzebl2 = zzebl;
        zzebj zzbav = zzebl2.zzbap().zzbav();
        SecretKeySpec secretKeySpec = new SecretKeySpec(zzebl2.zzayi().toByteArray(), "HMAC");
        int zzayn = zzebl2.zzbap().zzayn();
        int i = zzdzl.zzhsu[zzbav.ordinal()];
        if (i == 1) {
            return new zzeeg("HMACSHA1", secretKeySpec, zzayn);
        }
        if (i == 2) {
            return new zzeeg("HMACSHA256", secretKeySpec, zzayn);
        }
        if (i == 3) {
            return new zzeeg("HMACSHA512", secretKeySpec, zzayn);
        }
        throw new GeneralSecurityException("unknown hash");
    }
}

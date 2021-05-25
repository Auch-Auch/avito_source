package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.ECPrivateKeySpec;
public final class zzdyv extends zzdwz<zzdwu, zzebd> {
    public zzdyv(Class cls) {
        super(cls);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzdwz
    public final /* synthetic */ zzdwu zzag(zzebd zzebd) throws GeneralSecurityException {
        zzebd zzebd2 = zzebd;
        zzeba zzazv = zzebd2.zzbac().zzazv();
        zzebh zzazx = zzazv.zzazx();
        zzeds zza = zzdze.zza(zzazx.zzbak());
        byte[] byteArray = zzebd2.zzayi().toByteArray();
        return new zzedj((ECPrivateKey) zzedt.zzhzs.zzhs("EC").generatePrivate(new ECPrivateKeySpec(new BigInteger(1, byteArray), zzedq.zza(zza))), zzazx.zzbam().toByteArray(), zzdze.zza(zzazx.zzbal()), zzdze.zza(zzazv.zzazz()), new zzdzg(zzazv.zzazy().zzazs()));
    }
}

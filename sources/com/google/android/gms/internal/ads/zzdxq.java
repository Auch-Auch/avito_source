package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzebt;
import com.google.android.gms.internal.ads.zzecb;
import com.google.android.gms.internal.ads.zzece;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
public final class zzdxq {
    private static final Charset UTF_8 = Charset.forName("UTF-8");

    public static zzece zzb(zzecb zzecb) {
        zzece.zzb zzfi = zzece.zzbbt().zzfi(zzecb.zzbbl());
        for (zzecb.zzb zzb : zzecb.zzbbm()) {
            zzfi.zzb((zzece.zza) ((zzegp) zzece.zza.zzbbv().zzhr(zzb.zzbbq().zzbay()).zzb(zzb.zzaya()).zzb(zzb.zzayb()).zzfj(zzb.zzbbr()).zzbfx()));
        }
        return (zzece) ((zzegp) zzfi.zzbfx());
    }

    public static void zzc(zzecb zzecb) throws GeneralSecurityException {
        int zzbbl = zzecb.zzbbl();
        int i = 0;
        boolean z = false;
        boolean z2 = true;
        for (zzecb.zzb zzb : zzecb.zzbbm()) {
            if (zzb.zzaya() == zzebu.ENABLED) {
                if (!zzb.zzbbp()) {
                    throw new GeneralSecurityException(String.format("key %d has no key data", Integer.valueOf(zzb.zzbbr())));
                } else if (zzb.zzayb() == zzecn.UNKNOWN_PREFIX) {
                    throw new GeneralSecurityException(String.format("key %d has unknown prefix", Integer.valueOf(zzb.zzbbr())));
                } else if (zzb.zzaya() != zzebu.UNKNOWN_STATUS) {
                    if (zzb.zzbbr() == zzbbl) {
                        if (!z) {
                            z = true;
                        } else {
                            throw new GeneralSecurityException("keyset contains multiple primary keys");
                        }
                    }
                    if (zzb.zzbbq().zzbba() != zzebt.zza.ASYMMETRIC_PUBLIC) {
                        z2 = false;
                    }
                    i++;
                } else {
                    throw new GeneralSecurityException(String.format("key %d has unknown status", Integer.valueOf(zzb.zzbbr())));
                }
            }
        }
        if (i == 0) {
            throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
        } else if (!z && !z2) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
    }
}

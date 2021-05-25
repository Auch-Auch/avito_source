package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzebt;
import com.google.android.gms.internal.ads.zzecb;
import java.security.GeneralSecurityException;
@Deprecated
public final class zzdxg {
    @Deprecated
    public static final zzdxc zzm(byte[] bArr) throws GeneralSecurityException {
        try {
            zzecb zzc = zzecb.zzc(bArr, zzegc.zzbex());
            for (zzecb.zzb zzb : zzc.zzbbm()) {
                if (zzb.zzbbq().zzbba() == zzebt.zza.UNKNOWN_KEYMATERIAL || zzb.zzbbq().zzbba() == zzebt.zza.SYMMETRIC || zzb.zzbbq().zzbba() == zzebt.zza.ASYMMETRIC_PRIVATE) {
                    throw new GeneralSecurityException("keyset contains secret key material");
                }
            }
            return zzdxc.zza(zzc);
        } catch (zzegz unused) {
            throw new GeneralSecurityException("invalid keyset");
        }
    }
}

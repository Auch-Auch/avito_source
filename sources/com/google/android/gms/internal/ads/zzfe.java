package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.GeneralSecurityException;
public final class zzfe {
    public static zzdwt zzaaa;

    public static boolean zzb(zzex zzex) throws IllegalAccessException, InvocationTargetException {
        Method zza;
        if (zzaaa != null) {
            return true;
        }
        String str = (String) zzwe.zzpu().zzd(zzaat.zzcqt);
        if (str == null || str.length() == 0) {
            str = (zzex == null || (zza = zzex.zza("TkuK+8ZKbIcxeUe4msY7eeifKf/tICuqqRvwzwQUhsKM0HemvJhBrPQYp0qpvgcE", "eNJuSXkridnHpFkTgNBQFH0ivDH801goaJfT5bONEac=")) == null) ? null : (String) zza.invoke(null, new Object[0]);
            if (str == null) {
                return false;
            }
        }
        try {
            zzdxc zzm = zzdxg.zzm(zzcv.zzb(str, true));
            for (zzeca zzeca : zzdyz.zzhsa.zzbck()) {
                if (zzeca.zzbay().isEmpty()) {
                    throw new GeneralSecurityException("Missing type_url.");
                } else if (zzeca.zzbbg().isEmpty()) {
                    throw new GeneralSecurityException("Missing primitive_name.");
                } else if (zzeca.zzbbj().isEmpty()) {
                    throw new GeneralSecurityException("Missing catalogue_name.");
                } else if (!zzeca.zzbbj().equals("TinkAead") && !zzeca.zzbbj().equals("TinkMac") && !zzeca.zzbbj().equals("TinkHybridDecrypt") && !zzeca.zzbbj().equals("TinkHybridEncrypt") && !zzeca.zzbbj().equals("TinkPublicKeySign") && !zzeca.zzbbj().equals("TinkPublicKeyVerify") && !zzeca.zzbbj().equals("TinkStreamingAead") && !zzeca.zzbbj().equals("TinkDeterministicAead")) {
                    zzdwp<?> zzhn = zzdxm.zzhn(zzeca.zzbbj());
                    zzdxm.zza(zzhn.zzaxo());
                    zzdxm.zza(zzhn.zzb(zzeca.zzbay(), zzeca.zzbbg(), zzeca.zzbbh()), zzeca.zzbbi());
                }
            }
            zzdwt zza2 = zzdza.zza(zzm, null);
            zzaaa = zza2;
            if (zza2 != null) {
                return true;
            }
            return false;
        } catch (IllegalArgumentException unused) {
        }
    }
}

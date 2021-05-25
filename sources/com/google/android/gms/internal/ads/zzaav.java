package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;
import java.util.regex.Pattern;
public final class zzaav {
    public static boolean zzct(String str) {
        return zzf((String) zzwe.zzpu().zzd(zzaat.zzcue), str);
    }

    private static boolean zzf(String str, String str2) {
        if (!(str == null || str2 == null)) {
            try {
                return Pattern.matches(str, str2);
            } catch (RuntimeException e) {
                zzp.zzkt().zza(e, "NonagonUtil.isPatternMatched");
            }
        }
        return false;
    }
}

package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzbu;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
public abstract class zzv {
    public String zza;
    public int zzb;
    public Boolean zzc;
    public Boolean zzd;
    public Long zze;
    public Long zzf;

    public zzv(String str, int i) {
        this.zza = str;
        this.zzb = i;
    }

    @VisibleForTesting
    public static Boolean zza(Boolean bool, boolean z) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() != z);
    }

    public abstract int zza();

    public abstract boolean zzb();

    public abstract boolean zzc();

    @VisibleForTesting
    public static Boolean zza(String str, zzbu.zzf zzf2, zzez zzez) {
        String str2;
        List<String> list;
        Preconditions.checkNotNull(zzf2);
        if (str == null || !zzf2.zza() || zzf2.zzb() == zzbu.zzf.zza.UNKNOWN_MATCH_TYPE) {
            return null;
        }
        zzbu.zzf.zza zzb2 = zzf2.zzb();
        zzbu.zzf.zza zza2 = zzbu.zzf.zza.IN_LIST;
        if (zzb2 == zza2) {
            if (zzf2.zzh() == 0) {
                return null;
            }
        } else if (!zzf2.zzc()) {
            return null;
        }
        zzbu.zzf.zza zzb3 = zzf2.zzb();
        boolean zzf3 = zzf2.zzf();
        if (zzf3 || zzb3 == zzbu.zzf.zza.REGEXP || zzb3 == zza2) {
            str2 = zzf2.zzd();
        } else {
            str2 = zzf2.zzd().toUpperCase(Locale.ENGLISH);
        }
        if (zzf2.zzh() == 0) {
            list = null;
        } else {
            List<String> zzg = zzf2.zzg();
            if (!zzf3) {
                ArrayList arrayList = new ArrayList(zzg.size());
                for (String str3 : zzg) {
                    arrayList.add(str3.toUpperCase(Locale.ENGLISH));
                }
                zzg = Collections.unmodifiableList(arrayList);
            }
            list = zzg;
        }
        return zza(str, zzb3, zzf3, str2, list, zzb3 == zzbu.zzf.zza.REGEXP ? str2 : null, zzez);
    }

    private static Boolean zza(String str, zzbu.zzf.zza zza2, boolean z, String str2, List<String> list, String str3, zzez zzez) {
        if (str == null) {
            return null;
        }
        if (zza2 == zzbu.zzf.zza.IN_LIST) {
            if (list == null || list.size() == 0) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z && zza2 != zzbu.zzf.zza.REGEXP) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (zzr.zza[zza2.ordinal()]) {
            case 1:
                try {
                    return Boolean.valueOf(Pattern.compile(str3, z ? 0 : 66).matcher(str).matches());
                } catch (PatternSyntaxException unused) {
                    if (zzez != null) {
                        zzez.zzi().zza("Invalid regular expression in REGEXP audience filter. expression", str3);
                    }
                    return null;
                }
            case 2:
                return Boolean.valueOf(str.startsWith(str2));
            case 3:
                return Boolean.valueOf(str.endsWith(str2));
            case 4:
                return Boolean.valueOf(str.contains(str2));
            case 5:
                return Boolean.valueOf(str.equals(str2));
            case 6:
                return Boolean.valueOf(list.contains(str));
            default:
                return null;
        }
    }

    public static Boolean zza(long j, zzbu.zzd zzd2) {
        try {
            return zza(new BigDecimal(j), zzd2, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Boolean zza(double d, zzbu.zzd zzd2) {
        try {
            return zza(new BigDecimal(d), zzd2, Math.ulp(d));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static Boolean zza(String str, zzbu.zzd zzd2) {
        if (!zzks.zza(str)) {
            return null;
        }
        try {
            return zza(new BigDecimal(str), zzd2, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0081, code lost:
        if (r3 != null) goto L_0x0083;
     */
    @com.google.android.gms.common.util.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Boolean zza(java.math.BigDecimal r9, com.google.android.gms.internal.measurement.zzbu.zzd r10, double r11) {
        /*
        // Method dump skipped, instructions count: 269
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzv.zza(java.math.BigDecimal, com.google.android.gms.internal.measurement.zzbu$zzd, double):java.lang.Boolean");
    }
}

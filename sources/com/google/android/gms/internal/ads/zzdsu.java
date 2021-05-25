package com.google.android.gms.internal.ads;

import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public final class zzdsu {
    private static final Logger logger = Logger.getLogger(zzdsu.class.getName());
    private static final zzdsr zzhlr = new zza();

    public static final class zza {
        private zza() {
        }
    }

    private zzdsu() {
    }

    public static String emptyToNull(@NullableDecl String str) {
        if (zzhh(str)) {
            return null;
        }
        return str;
    }

    public static boolean zzhh(@NullableDecl String str) {
        return str == null || str.isEmpty();
    }

    public static String zzhi(@NullableDecl String str) {
        return str == null ? "" : str;
    }
}

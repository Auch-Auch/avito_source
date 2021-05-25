package com.google.android.gms.internal.gtm;
public final class zzpp {
    private static final Class<?> zzavt = zzcx("libcore.io.Memory");
    private static final boolean zzavu = (zzcx("org.robolectric.Robolectric") != null);

    private static <T> Class<T> zzcx(String str) {
        try {
            return (Class<T>) Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean zzna() {
        return zzavt != null && !zzavu;
    }

    public static Class<?> zznb() {
        return zzavt;
    }
}

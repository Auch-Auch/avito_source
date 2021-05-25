package com.google.android.gms.internal.ads;
public final class zzeey {
    private static final Class<?> zziau = zzht("libcore.io.Memory");
    private static final boolean zziav = (zzht("org.robolectric.Robolectric") != null);

    public static boolean zzbdd() {
        return zziau != null && !zziav;
    }

    public static Class<?> zzbde() {
        return zziau;
    }

    private static <T> Class<T> zzht(String str) {
        try {
            return (Class<T>) Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}

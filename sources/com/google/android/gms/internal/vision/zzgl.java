package com.google.android.gms.internal.vision;
public final class zzgl {
    private static final Class<?> zzti = zzu("libcore.io.Memory");
    private static final boolean zztj = (zzu("org.robolectric.Robolectric") != null);

    public static boolean zzel() {
        return zzti != null && !zztj;
    }

    public static Class<?> zzem() {
        return zzti;
    }

    private static <T> Class<T> zzu(String str) {
        try {
            return (Class<T>) Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}

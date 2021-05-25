package com.google.android.gms.internal.ads;
public final class zzpg {
    public static boolean zzbf(String str) {
        return "audio".equals(zzbh(str));
    }

    public static boolean zzbg(String str) {
        return "video".equals(zzbh(str));
    }

    private static String zzbh(String str) {
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(47);
        if (indexOf != -1) {
            return str.substring(0, indexOf);
        }
        throw new IllegalArgumentException(str.length() != 0 ? "Invalid mime type: ".concat(str) : new String("Invalid mime type: "));
    }
}

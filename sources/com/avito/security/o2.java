package com.avito.security;
public class o2 extends n2 {
    public static final boolean a(String str, int i, String str2, int i2, int i3, boolean z) {
        j1.b(str, "$this$regionMatches");
        j1.b(str2, "other");
        return !z ? str.regionMatches(i, str2, i2, i3) : str.regionMatches(z, i, str2, i2, i3);
    }

    public static boolean a(String str, String str2, boolean z) {
        return str == null ? str2 == null : !z ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }
}

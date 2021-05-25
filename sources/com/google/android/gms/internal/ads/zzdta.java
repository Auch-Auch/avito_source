package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
public final class zzdta {
    public static void zzb(Object obj, Object obj2) {
        if (obj == null) {
            String valueOf = String.valueOf(obj2);
            throw new NullPointerException(a.r2(valueOf.length() + 24, "null key in entry: null=", valueOf));
        } else if (obj2 == null) {
            String valueOf2 = String.valueOf(obj);
            throw new NullPointerException(a.s2(valueOf2.length() + 26, "null value in entry: ", valueOf2, "=null"));
        }
    }

    public static int zzh(int i, String str) {
        if (i >= 0) {
            return i;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40);
        sb.append(str);
        sb.append(" cannot be negative but was: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }
}

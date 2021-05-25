package com.google.android.gms.internal.vision;

import a2.b.a.a.a;
public final class zzdq {
    public static void zza(Object obj, Object obj2) {
        if (obj == null) {
            String valueOf = String.valueOf(obj2);
            throw new NullPointerException(a.r2(valueOf.length() + 24, "null key in entry: null=", valueOf));
        } else if (obj2 == null) {
            String valueOf2 = String.valueOf(obj);
            throw new NullPointerException(a.s2(valueOf2.length() + 26, "null value in entry: ", valueOf2, "=null"));
        }
    }
}

package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import android.text.TextUtils;
import androidx.annotation.Nullable;
public final class zzabf extends zzabe {
    @Nullable
    private static String zzcw(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int i = 0;
        int length = str.length();
        while (i < str.length() && str.charAt(i) == ',') {
            i++;
        }
        while (length > 0 && str.charAt(length - 1) == ',') {
            length--;
        }
        if (length < i) {
            return null;
        }
        if (i == 0 && length == str.length()) {
            return str;
        }
        return str.substring(i, length);
    }

    @Override // com.google.android.gms.internal.ads.zzabe
    public final String zzg(@Nullable String str, String str2) {
        String zzcw = zzcw(str);
        String zzcw2 = zzcw(str2);
        if (TextUtils.isEmpty(zzcw)) {
            return zzcw2;
        }
        if (TextUtils.isEmpty(zzcw2)) {
            return zzcw;
        }
        return a.s2(a.q0(zzcw2, a.q0(zzcw, 1)), zzcw, ",", zzcw2);
    }
}

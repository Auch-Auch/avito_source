package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.net.URI;
public final class ed {
    @NonNull
    private final Context a;

    public ed(@NonNull Context context) {
        this.a = context.getApplicationContext();
    }

    @Nullable
    private static String b(@Nullable String str) {
        try {
            Uri parse = Uri.parse(str);
            return new URI(parse.getScheme(), parse.getAuthority(), parse.getPath(), parse.getQuery(), parse.getFragment()).toASCIIString();
        } catch (Exception unused) {
            return str;
        }
    }

    @Nullable
    public final String a(@Nullable String str) {
        fz a3 = fy.a().a(this.a);
        boolean z = a3 != null && a3.o();
        if (TextUtils.isEmpty(str) || !z) {
            return str;
        }
        String decode = Uri.decode(str.trim());
        if (!TextUtils.isEmpty(decode) && decode.startsWith("//")) {
            decode = "https:".concat(decode);
        }
        return eb.a(b(decode));
    }
}

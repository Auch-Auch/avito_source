package com.yandex.metrica.impl.ob;

import a2.b.a.a.a;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.UUID;
public class adx implements adw<String> {
    public adu a(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return adu.a(this, "ApiKey is empty. Please, read official documentation how to obtain one: https://tech.yandex.com/metrica-mobile-sdk/doc/mobile-sdk-dg/concepts/android-initialize-docpage/");
        }
        try {
            UUID.fromString(str);
            return adu.a(this);
        } catch (Throwable unused) {
            StringBuilder W = a.W("Invalid ApiKey=", str, ". ", "Please, read official documentation how to obtain one:", " ");
            W.append("https://tech.yandex.com/metrica-mobile-sdk/doc/mobile-sdk-dg/concepts/android-initialize-docpage/");
            return adu.a(this, W.toString());
        }
    }
}

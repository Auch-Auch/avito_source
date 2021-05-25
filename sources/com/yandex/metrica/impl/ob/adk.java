package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
public class adk extends adc<String> {
    public adk(int i, @NonNull String str) {
        this(i, str, abd.a());
    }

    @Override // com.yandex.metrica.impl.ob.adc
    @VisibleForTesting(otherwise = 3)
    public /* bridge */ /* synthetic */ int a() {
        return super.a();
    }

    @Override // com.yandex.metrica.impl.ob.adc
    @VisibleForTesting(otherwise = 3)
    @NonNull
    public /* bridge */ /* synthetic */ String b() {
        return super.b();
    }

    public adk(int i, @NonNull String str, @NonNull abl abl) {
        super(i, str, abl);
    }

    @Nullable
    public String a(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            byte[] bytes = str.getBytes("UTF-8");
            if (bytes.length <= a()) {
                return str;
            }
            String str2 = new String(bytes, 0, a(), "UTF-8");
            try {
                if (this.a.c()) {
                    this.a.b("\"%s\" %s exceeded limit of %d bytes", b(), str, Integer.valueOf(a()));
                }
            } catch (UnsupportedEncodingException unused) {
            }
            return str2;
        } catch (UnsupportedEncodingException unused2) {
            return str;
        }
    }
}

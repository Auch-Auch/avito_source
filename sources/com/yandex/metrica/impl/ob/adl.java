package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
public class adl extends adc<String> {
    public adl(int i, @NonNull String str) {
        this(i, str, abl.h());
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

    public adl(int i, @NonNull String str, @NonNull abl abl) {
        super(i, str, abl);
    }

    @Nullable
    public String a(@Nullable String str) {
        if (str == null || str.length() <= a()) {
            return str;
        }
        String substring = str.substring(0, a());
        if (this.a.c()) {
            this.a.b("\"%s\" %s size exceeded limit of %d characters", b(), str, Integer.valueOf(a()));
        }
        return substring;
    }
}

package com.yandex.mobile.ads.nativeads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.an;
import com.yandex.mobile.ads.nativeads.au;
public final class at implements au.a {
    private final String a;
    private final an.a b;

    public at(@NonNull an.a aVar, @Nullable String str) {
        this.a = str;
        this.b = aVar;
    }

    @Override // com.yandex.mobile.ads.nativeads.au.a
    public final String a() {
        return this.a;
    }

    @Override // com.yandex.mobile.ads.nativeads.au.a
    public final an.a b() {
        return this.b;
    }
}

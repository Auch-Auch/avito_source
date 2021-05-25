package com.yandex.mobile.ads.nativeads;

import android.support.annotation.NonNull;
import com.yandex.mobile.ads.impl.lv;
public final class t {
    @NonNull
    private final s a;
    @NonNull
    private final bg b;
    @NonNull
    private final lv c;
    @NonNull
    private final bn d;

    public t(@NonNull s sVar, @NonNull bg bgVar, @NonNull lv lvVar, @NonNull bn bnVar) {
        this.a = sVar;
        this.b = bgVar;
        this.c = lvVar;
        this.d = bnVar;
    }

    @NonNull
    public final s a() {
        return this.a;
    }

    @NonNull
    public final bg b() {
        return this.b;
    }

    @NonNull
    public final lv c() {
        return this.c;
    }

    @NonNull
    public final bn d() {
        return this.d;
    }
}

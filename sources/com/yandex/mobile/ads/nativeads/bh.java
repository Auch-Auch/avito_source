package com.yandex.mobile.ads.nativeads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.bo;
import com.yandex.mobile.ads.impl.oq;
import java.util.Collections;
import java.util.List;
public final class bh {
    @Nullable
    private final String a;
    private final List<oq> b;
    private final List<bo> c;
    @NonNull
    private final List<String> d;

    public bh(@Nullable List<oq> list, @NonNull List<bo> list2, @NonNull List<String> list3, @Nullable String str) {
        this.b = list;
        this.c = list2;
        this.d = list3;
        this.a = str;
    }

    @NonNull
    public final List<oq> a() {
        List<oq> list = this.b;
        return list != null ? list : Collections.emptyList();
    }

    @NonNull
    public final List<bo> b() {
        return this.c;
    }

    @NonNull
    public final List<String> c() {
        return this.d;
    }

    @Nullable
    public final String d() {
        return this.a;
    }
}

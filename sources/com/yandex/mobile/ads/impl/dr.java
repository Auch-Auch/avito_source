package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.ae;
import com.yandex.mobile.ads.impl.ds;
public final class dr implements ds {
    @NonNull
    private final bm a;

    public dr(@NonNull bm bmVar) {
        this.a = bmVar;
    }

    @Override // com.yandex.mobile.ads.impl.ds
    @Nullable
    public final String a(@NonNull fo foVar) {
        return ae.a(foVar);
    }

    @Override // com.yandex.mobile.ads.impl.ds
    @NonNull
    public final String a(@NonNull Context context, @NonNull fo foVar) {
        ae.a a3 = ae.a(context, foVar);
        a3.a(this.a.b());
        return a3.d();
    }

    @Override // com.yandex.mobile.ads.impl.ds
    @NonNull
    public final int a() {
        return ds.a.b;
    }
}

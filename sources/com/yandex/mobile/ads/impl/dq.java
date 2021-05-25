package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.ds;
public final class dq implements ds {
    @Override // com.yandex.mobile.ads.impl.ds
    @Nullable
    public final String a(@NonNull fo foVar) {
        return ae.a(foVar);
    }

    @Override // com.yandex.mobile.ads.impl.ds
    @NonNull
    public final String a(@NonNull Context context, @NonNull fo foVar) {
        return ae.a(context, foVar).d();
    }

    @Override // com.yandex.mobile.ads.impl.ds
    @NonNull
    public final int a() {
        return ds.a.a;
    }
}

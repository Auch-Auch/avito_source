package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.os.ResultReceiver;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.lang.ref.WeakReference;
public final class og implements dm {
    @NonNull
    private final WeakReference<Context> a;
    @NonNull
    private final fo b;
    @NonNull
    private final ResultReceiver c;

    public og(@NonNull Context context, @NonNull fo foVar, @NonNull ResultReceiver resultReceiver) {
        this.a = new WeakReference<>(context);
        this.b = foVar;
        this.c = resultReceiver;
    }

    @Override // com.yandex.mobile.ads.impl.dm
    public final void a(@NonNull cq cqVar, @Nullable String str) {
        o.a(this.a.get(), cqVar, str, this.c, this.b.k());
    }
}

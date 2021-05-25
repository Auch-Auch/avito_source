package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.os.ResultReceiver;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.lang.ref.WeakReference;
public final class dl implements dm {
    @NonNull
    private final WeakReference<Context> a;
    @Nullable
    private final ResultReceiver b;
    private final boolean c;

    public dl(@Nullable Context context, boolean z, @Nullable ResultReceiver resultReceiver) {
        this.a = new WeakReference<>(context);
        this.c = z;
        this.b = resultReceiver;
    }

    @Override // com.yandex.mobile.ads.impl.dm
    public final void a(@NonNull cq cqVar, @Nullable String str) {
        o.a(this.a.get(), cqVar, str, this.b, this.c);
    }
}

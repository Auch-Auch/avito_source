package com.yandex.mobile.ads.impl;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.LruCache;
import com.yandex.mobile.ads.impl.pl;
public final class pm implements pl.b {
    @NonNull
    private final LruCache<String, Bitmap> a;
    @NonNull
    private final pi b;

    public pm(@NonNull LruCache<String, Bitmap> lruCache, @NonNull pi piVar) {
        this.a = lruCache;
        this.b = piVar;
    }

    @Override // com.yandex.mobile.ads.impl.pl.b
    @Nullable
    public final Bitmap a(@NonNull String str) {
        return this.a.get(pi.a(str));
    }

    @Override // com.yandex.mobile.ads.impl.pl.b
    public final void a(@NonNull String str, @NonNull Bitmap bitmap) {
        this.a.put(pi.a(str), bitmap);
    }
}

package com.yandex.mobile.ads.impl;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.LruCache;
import com.yandex.mobile.ads.impl.ss;
public final class pl {
    @NonNull
    private static final Object a = new Object();
    private static volatile pl b;
    @NonNull
    private final ss c;
    @NonNull
    private final b d;
    @NonNull
    private final pk e;

    @TargetApi(12)
    public static class a implements ss.b {
        @NonNull
        private final LruCache<String, Bitmap> a;

        public a(@NonNull LruCache<String, Bitmap> lruCache) {
            this.a = lruCache;
        }

        @Override // com.yandex.mobile.ads.impl.ss.b
        public final Bitmap a(String str) {
            return this.a.get(str);
        }

        @Override // com.yandex.mobile.ads.impl.ss.b
        public final void a(String str, Bitmap bitmap) {
            this.a.put(str, bitmap);
        }
    }

    public interface b {
        @Nullable
        Bitmap a(@NonNull String str);

        void a(@NonNull String str, @NonNull Bitmap bitmap);
    }

    private pl(@NonNull Context context) {
        AnonymousClass1 r1 = new LruCache<String, Bitmap>(dy.a(context)) { // from class: com.yandex.mobile.ads.impl.pl.1
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // android.util.LruCache
            public final /* synthetic */ int sizeOf(String str, Bitmap bitmap) {
                String str2 = str;
                Bitmap bitmap2 = bitmap;
                if (bitmap2 != null) {
                    return bitmap2.getByteCount() / 1024;
                }
                return super.sizeOf(str2, null);
            }
        };
        rz a3 = bw.a(context, 4);
        a3.a();
        a aVar = new a(r1);
        pi piVar = new pi();
        this.d = new pm(r1, piVar);
        pk pkVar = new pk(ea.i(context));
        this.e = pkVar;
        this.c = new pj(a3, aVar, piVar, pkVar);
    }

    @NonNull
    @TargetApi(12)
    public static pl a(@NonNull Context context) {
        if (b == null) {
            synchronized (a) {
                if (b == null) {
                    b = new pl(context);
                }
            }
        }
        return b;
    }

    @NonNull
    public final ss b() {
        return this.c;
    }

    @NonNull
    public final b a() {
        return this.d;
    }
}

package com.yandex.mobile.ads.video;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.gk;
import com.yandex.mobile.ads.impl.gm;
import com.yandex.mobile.ads.impl.tq;
public final class b {
    private static final Object a = new Object();
    private static volatile b b;
    @NonNull
    private final tq c;
    @NonNull
    private final gm d;
    @Nullable
    private gm e;

    private b(@NonNull Context context) {
        this.c = tq.a(context);
        this.d = gk.a(context);
    }

    @NonNull
    public static b a(@NonNull Context context) {
        if (b == null) {
            synchronized (a) {
                if (b == null) {
                    b = new b(context);
                }
            }
        }
        return b;
    }

    public final void a(@NonNull Context context, @NonNull BlocksInfoRequest blocksInfoRequest) {
        this.c.a(context, blocksInfoRequest, a());
    }

    public final void a(@NonNull Context context, @NonNull VideoAdRequest videoAdRequest) {
        this.c.a(context, videoAdRequest, a());
    }

    @NonNull
    private gm a() {
        gm gmVar = this.e;
        return gmVar != null ? gmVar : this.d;
    }
}

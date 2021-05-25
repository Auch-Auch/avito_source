package com.yandex.mobile.ads.nativeads;

import a2.b.a.a.a;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.cq;
import com.yandex.mobile.ads.impl.dm;
import com.yandex.mobile.ads.impl.hv;
public final class g implements dm {
    @NonNull
    private final Handler a = new Handler(Looper.getMainLooper());
    @NonNull
    private final AdTapHandler b;

    public g(@NonNull AdTapHandler adTapHandler) {
        this.b = adTapHandler;
    }

    @Override // com.yandex.mobile.ads.impl.dm
    public final void a(@NonNull cq cqVar, @Nullable final String str) {
        cqVar.a(hv.b.CLICK, a.k0("click_type", "custom"));
        this.a.post(new Runnable() { // from class: com.yandex.mobile.ads.nativeads.g.1
            @Override // java.lang.Runnable
            public final void run() {
                g.this.b.handleAdTapWithURL(str);
            }
        });
    }
}

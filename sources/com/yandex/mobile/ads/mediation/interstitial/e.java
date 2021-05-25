package com.yandex.mobile.ads.mediation.interstitial;

import android.content.Context;
import android.support.annotation.NonNull;
import com.yandex.mobile.ads.impl.bl;
import com.yandex.mobile.ads.impl.in;
import com.yandex.mobile.ads.impl.kq;
import com.yandex.mobile.ads.impl.x;
import java.lang.ref.WeakReference;
public final class e implements kq {
    @NonNull
    private final WeakReference<in> a;
    @NonNull
    private final bl b;

    public e(@NonNull in inVar) {
        this.a = new WeakReference<>(inVar);
        this.b = new bl(inVar.s());
    }

    @Override // com.yandex.mobile.ads.impl.kq
    public final void a(@NonNull Context context) {
    }

    @Override // com.yandex.mobile.ads.impl.kq
    public final boolean a() {
        in inVar = this.a.get();
        return inVar != null && inVar.l();
    }

    @Override // com.yandex.mobile.ads.impl.kq
    public final void b() {
        in inVar = this.a.get();
        if (inVar != null) {
            inVar.h();
        }
    }

    @Override // com.yandex.mobile.ads.impl.kq
    public final void a(@NonNull Context context, @NonNull x<String> xVar) {
        in inVar = this.a.get();
        if (inVar != null) {
            this.b.a(context, xVar);
            this.b.b(context, xVar);
            inVar.b(xVar);
        }
    }
}

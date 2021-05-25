package com.yandex.mobile.ads.mediation.banner;

import android.content.Context;
import android.support.annotation.NonNull;
import com.yandex.mobile.ads.impl.a;
import com.yandex.mobile.ads.impl.bl;
import com.yandex.mobile.ads.impl.x;
import java.lang.ref.WeakReference;
public final class h implements b {
    @NonNull
    private final WeakReference<a> a;
    @NonNull
    private final bl b;

    public h(@NonNull a aVar) {
        this.a = new WeakReference<>(aVar);
        this.b = new bl(aVar.s());
    }

    @Override // com.yandex.mobile.ads.mediation.banner.b
    public final void a(@NonNull Context context) {
    }

    @Override // com.yandex.mobile.ads.mediation.banner.b
    public final void a(@NonNull Context context, @NonNull x<String> xVar) {
        a aVar = this.a.get();
        if (aVar != null) {
            this.b.a(context, xVar);
            this.b.b(context, xVar);
            aVar.b(xVar);
        }
    }
}

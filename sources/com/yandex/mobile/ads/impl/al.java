package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import com.yandex.mobile.ads.impl.aj;
import com.yandex.mobile.ads.impl.tb;
public final class al implements tb.a<fz> {
    @NonNull
    private final Context a;
    @NonNull
    private final ak b;
    @NonNull
    private final aj.a c;

    public al(@NonNull Context context, @NonNull ak akVar, @NonNull aj.a aVar) {
        this.a = context.getApplicationContext();
        this.b = akVar;
        this.c = aVar;
    }

    @Override // com.yandex.mobile.ads.impl.sa.b
    public final /* bridge */ /* synthetic */ void a(@NonNull Object obj) {
        this.b.a(this.a, (fz) obj);
        this.c.a();
    }

    @Override // com.yandex.mobile.ads.impl.sa.a
    public final void a(sl slVar) {
        this.c.a(slVar);
    }
}

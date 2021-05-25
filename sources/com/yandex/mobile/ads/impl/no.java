package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import com.yandex.mobile.ads.nativeads.i;
import com.yandex.mobile.ads.nativeads.j;
import com.yandex.mobile.ads.nativeads.k;
import com.yandex.mobile.ads.nativeads.p;
import com.yandex.mobile.ads.nativeads.t;
import java.util.Map;
public final class no {
    @NonNull
    private final ng a = new ng();
    @NonNull
    private final nl b;
    @NonNull
    private final i c;

    public no(@NonNull nl nlVar, @NonNull i iVar) {
        this.b = nlVar;
        this.c = iVar;
    }

    public final void a(@NonNull final Context context, @NonNull final p pVar, @NonNull final j jVar, @NonNull final t tVar, @NonNull final nj njVar) {
        this.c.a(this.c.a(pVar.c().c()), new k() { // from class: com.yandex.mobile.ads.impl.no.1
            @Override // com.yandex.mobile.ads.nativeads.k
            public final void a(@NonNull Map<String, Bitmap> map) {
                ng.a(pVar, map);
                jVar.a(map);
                no.this.b.a(context, pVar, jVar, tVar, njVar);
            }
        });
    }
}

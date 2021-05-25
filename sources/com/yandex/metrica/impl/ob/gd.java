package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import com.yandex.metrica.CounterConfiguration;
import com.yandex.metrica.impl.ob.ew;
public class gd extends gq {
    @Override // com.yandex.metrica.impl.ob.gq
    @NonNull
    /* renamed from: a */
    public fe d(@NonNull Context context, @NonNull fb fbVar, @NonNull ew.a aVar, @NonNull yc ycVar) {
        return new ev(context, ycVar.e(), fbVar, aVar, new ga(as.a().i()), new yi());
    }

    @Override // com.yandex.metrica.impl.ob.gq
    @NonNull
    /* renamed from: b */
    public gv c(@NonNull Context context, @NonNull fb fbVar, @NonNull ew.a aVar, @NonNull yc ycVar) {
        return new gv(context, fbVar, aVar, ycVar.e(), new yi(), CounterConfiguration.a.APPMETRICA);
    }
}

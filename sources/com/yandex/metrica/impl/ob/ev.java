package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.CounterConfiguration;
import com.yandex.metrica.impl.ob.ew;
import com.yandex.metrica.impl.ob.fe;
import com.yandex.metrica.impl.ob.we;
public class ev extends fe {
    public ev(@NonNull Context context, @NonNull yb ybVar, @NonNull fb fbVar, @NonNull ew.a aVar, @NonNull we.d dVar, @NonNull ye yeVar) {
        this(context, fbVar, new fe.a(), new dj(), new ff(context, fbVar, aVar, yeVar, ybVar, dVar, as.a().k().g(), dl.c(context, fbVar.b())));
    }

    @Override // com.yandex.metrica.impl.ob.fe
    @NonNull
    public CounterConfiguration.a a() {
        return CounterConfiguration.a.APPMETRICA;
    }

    @VisibleForTesting
    public ev(@NonNull Context context, @NonNull fb fbVar, @NonNull fe.a aVar, @NonNull dj djVar, @NonNull ff ffVar) {
        super(context, fbVar, aVar, djVar, ffVar);
    }
}

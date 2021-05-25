package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import com.yandex.metrica.CounterConfiguration;
import com.yandex.metrica.impl.ob.ew;
public class gq implements gh, gk<fe> {
    @Override // com.yandex.metrica.impl.ob.gh
    @NonNull
    public gg a(@NonNull Context context, @NonNull gl glVar, @NonNull ge geVar, @NonNull ew ewVar) {
        return new gp(context, glVar.a(new fb(geVar.b(), geVar.a()), ewVar, new fu(this)));
    }

    @NonNull
    /* renamed from: b */
    public gv c(@NonNull Context context, @NonNull fb fbVar, @NonNull ew.a aVar, @NonNull yc ycVar) {
        return new gv(context, fbVar, aVar, ycVar.e(), new yf(ycVar), CounterConfiguration.a.MANUAL);
    }

    @NonNull
    /* renamed from: a */
    public fe d(@NonNull Context context, @NonNull fb fbVar, @NonNull ew.a aVar, @NonNull yc ycVar) {
        return new fz(context, fbVar, aVar, as.a().i(), ycVar.e(), new yf(ycVar));
    }
}

package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import com.yandex.metrica.CounterConfiguration;
import com.yandex.metrica.impl.ob.ew;
public class gm implements gh, gk<fq> {
    @Override // com.yandex.metrica.impl.ob.gh
    @NonNull
    public gg a(@NonNull Context context, @NonNull gl glVar, @NonNull ge geVar, @NonNull ew ewVar) {
        return new gn(context, glVar.a(new fs(geVar.b(), geVar.a()), ewVar, new fu(this)));
    }

    @NonNull
    /* renamed from: b */
    public gv c(@NonNull Context context, @NonNull fb fbVar, @NonNull ew.a aVar, @NonNull yc ycVar) {
        return new gv(context, fbVar, aVar, ycVar.e(), new yf(ycVar), CounterConfiguration.a.MAIN);
    }

    @NonNull
    /* renamed from: a */
    public fq d(@NonNull Context context, @NonNull fb fbVar, @NonNull ew.a aVar, @NonNull yc ycVar) {
        return new fq(context, ycVar.e(), fbVar, aVar, as.a().d(), as.a().i(), new yf(ycVar));
    }
}

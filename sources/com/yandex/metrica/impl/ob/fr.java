package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.ew;
import com.yandex.metrica.impl.ob.fq;
import com.yandex.metrica.impl.ob.we;
import java.io.File;
public class fr extends ff {
    public fr(@NonNull Context context, @NonNull fb fbVar, @NonNull ew.a aVar, @NonNull ye yeVar, @NonNull yb ybVar, @NonNull we.d dVar, @NonNull act act, int i) {
        super(context, fbVar, aVar, yeVar, ybVar, dVar, act, i);
    }

    @NonNull
    public fq.a a(@NonNull fq fqVar) {
        fqVar.getClass();
        return new fq.a();
    }

    @NonNull
    public bw b(@NonNull fq fqVar) {
        return new bw(fqVar);
    }

    @NonNull
    public bv a(@NonNull bw bwVar, @NonNull mo moVar) {
        return new bv(this.a, bwVar, moVar);
    }

    @NonNull
    public lm a(@NonNull an anVar, @NonNull aby<File> aby) {
        return new lm(anVar.c(this.a), aby);
    }
}

package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
public class wo {
    @NonNull
    private mx<wr> a;
    @NonNull
    private wr b;
    @NonNull
    private abs c;
    @NonNull
    private wt d;
    @NonNull
    private a e;

    public interface a {
        void a();
    }

    public wo(@NonNull mx<wr> mxVar, @NonNull a aVar) {
        this(mxVar, aVar, new abs(), new wt(mxVar));
    }

    public void a(@NonNull wr wrVar) {
        this.a.a(wrVar);
        this.b = wrVar;
        this.d.a();
        this.e.a();
    }

    @VisibleForTesting
    public wo(@NonNull mx<wr> mxVar, @NonNull a aVar, @NonNull abs abs, @NonNull wt wtVar) {
        this.a = mxVar;
        this.b = mxVar.a();
        this.c = abs;
        this.d = wtVar;
        this.e = aVar;
    }

    public void a() {
        wr wrVar = this.b;
        wr wrVar2 = new wr(wrVar.a, wrVar.b, this.c.a(), true, true);
        this.a.a(wrVar2);
        this.b = wrVar2;
        this.e.a();
    }
}

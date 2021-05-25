package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.metrica.impl.ob.vy;
import java.util.List;
public class sc extends vy {
    @Nullable
    private final ql a;

    public static class a {
        public final yb a;
        public final ql b;

        public a(yb ybVar, ql qlVar) {
            this.a = ybVar;
            this.b = qlVar;
        }
    }

    public static class b implements vy.d<sc, a> {
        @NonNull
        private final Context a;

        public b(@NonNull Context context) {
            this.a = context;
        }

        @NonNull
        public sc a(a aVar) {
            sc scVar = new sc(aVar.b);
            Context context = this.a;
            scVar.d(dl.b(context, context.getPackageName()));
            Context context2 = this.a;
            scVar.c(dl.a(context2, context2.getPackageName()));
            scVar.i((String) abw.b(x.a(this.a).a(aVar.a), ""));
            scVar.a(aVar.a);
            scVar.a(x.a(this.a));
            scVar.b(this.a.getPackageName());
            scVar.e(aVar.a.a);
            scVar.f(aVar.a.b);
            scVar.g(aVar.a.c);
            scVar.a(pe.a().c(this.a));
            return scVar;
        }
    }

    private sc(@Nullable ql qlVar) {
        this.a = qlVar;
    }

    @Nullable
    public List<String> b() {
        return e().i;
    }

    @Nullable
    public ql a() {
        return this.a;
    }
}

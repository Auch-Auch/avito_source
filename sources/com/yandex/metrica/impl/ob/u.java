package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.SparseArray;
import com.yandex.metrica.impl.ob.bu;
import java.util.Map;
public class u extends bu {
    private final mn a;

    public class b implements bu.a {
        private final mn b;

        public b(mn mnVar) {
            this.b = mnVar;
        }

        @Override // com.yandex.metrica.impl.ob.bu.a
        public void a(Context context) {
            this.b.r(new th("COOKIE_BROWSERS").b());
            this.b.r(new th("BIND_ID_URL").b());
            ax.a(context, "b_meta.dat");
            ax.a(context, "browsers.dat");
        }
    }

    public u(mn mnVar) {
        this.a = mnVar;
    }

    @Override // com.yandex.metrica.impl.ob.bu
    public SparseArray<bu.a> a() {
        return new SparseArray<bu.a>() { // from class: com.yandex.metrica.impl.ob.u.1
            {
                put(47, new a(u.this.a));
                put(66, new b(u.this.a));
            }
        };
    }

    @Override // com.yandex.metrica.impl.ob.bu
    public int a(td tdVar) {
        return (int) this.a.c(-1);
    }

    @Override // com.yandex.metrica.impl.ob.bu
    public void a(td tdVar, int i) {
        this.a.f((long) i);
        tdVar.c().j();
    }

    public static class a implements bu.a {
        private mn a;

        public a(mn mnVar) {
            this.a = mnVar;
        }

        private boolean a(long j, long j2, long j3) {
            return j != j3 && j2 == j3;
        }

        private void b(@NonNull tb tbVar) {
            String a3 = tbVar.a();
            if (a(a3, this.a.a())) {
                this.a.m(a3);
            }
        }

        private void c(@NonNull tb tbVar) {
            String a3 = tbVar.a((String) null);
            if (a(a3, this.a.a((String) null))) {
                this.a.g(a3);
            }
        }

        private void d(@NonNull tb tbVar) {
            String c = tbVar.c(null);
            if (a(c, this.a.d((String) null))) {
                this.a.j(c);
            }
        }

        private void e(@NonNull tb tbVar) {
            String d = tbVar.d(null);
            if (a(d, this.a.e((String) null))) {
                this.a.k(d);
            }
        }

        private void f(@NonNull tb tbVar) {
            String e = tbVar.e(null);
            if (a(e, this.a.f((String) null))) {
                this.a.l(e);
            }
        }

        private void g(@NonNull tb tbVar) {
            long a3 = tbVar.a(-1);
            if (a(a3, this.a.a(-1), -1)) {
                this.a.d(a3);
            }
        }

        private void h(@NonNull tb tbVar) {
            long b = tbVar.b(-1);
            if (a(b, this.a.b(-1), -1)) {
                this.a.e(b);
            }
        }

        @Override // com.yandex.metrica.impl.ob.bu.a
        public void a(Context context) {
            tb tbVar = new tb(context);
            if (dl.a((Map) tbVar.c())) {
                return;
            }
            if (this.a.a((String) null) == null || this.a.b((String) null) == null) {
                a(tbVar);
                b(tbVar);
                c(tbVar);
                d(tbVar);
                e(tbVar);
                f(tbVar);
                g(tbVar);
                h(tbVar);
                this.a.q();
                tbVar.b().j();
            }
        }

        private boolean a(String str, String str2) {
            return !TextUtils.isEmpty(str) && TextUtils.isEmpty(str2);
        }

        private void a(@NonNull tb tbVar) {
            String b = tbVar.b((String) null);
            if (a(b, this.a.b((String) null))) {
                this.a.h(b);
            }
        }
    }
}

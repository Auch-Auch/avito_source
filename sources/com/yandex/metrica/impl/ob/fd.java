package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import com.google.android.exoplayer2.offline.DownloadService;
import com.yandex.metrica.impl.ob.i;
import java.util.LinkedList;
import java.util.List;
public class fd {
    private final fe a;
    private final sy b;
    private List<g> c;

    public static class a {
        @NonNull
        private final fe a;

        public a(@NonNull fe feVar) {
            this.a = feVar;
        }

        public fd a(@NonNull sy syVar) {
            return new fd(this.a, syVar);
        }
    }

    public static class b extends g {
        private final tc a;
        private final mo b;
        private final mq c;

        public b(fe feVar) {
            super(feVar);
            this.a = new tc(feVar.k(), feVar.c().toString());
            this.b = feVar.y();
            this.c = feVar.a;
        }

        private void g() {
            i.a a3 = this.a.a();
            if (a3 != null) {
                this.b.a(a3);
            }
            String a4 = this.a.a((String) null);
            if (!TextUtils.isEmpty(a4) && TextUtils.isEmpty(this.b.f())) {
                this.b.a(a4);
            }
            long c2 = this.a.c(Long.MIN_VALUE);
            if (c2 != Long.MIN_VALUE && this.b.a(Long.MIN_VALUE) == Long.MIN_VALUE) {
                this.b.b(c2);
            }
            this.b.q();
        }

        @Override // com.yandex.metrica.impl.ob.fd.g
        public boolean a() {
            return this.a.e();
        }

        @Override // com.yandex.metrica.impl.ob.fd.g
        public void b() {
            d();
            c();
            g();
            this.a.g();
        }

        @VisibleForTesting
        public void c() {
            jx jxVar = new jx(this.b, DownloadService.KEY_FOREGROUND);
            if (!jxVar.i()) {
                long d = this.a.d(-1);
                if (-1 != d) {
                    jxVar.d(d);
                }
                boolean booleanValue = this.a.a(true).booleanValue();
                if (booleanValue) {
                    jxVar.a(booleanValue);
                }
                long a3 = this.a.a(Long.MIN_VALUE);
                if (a3 != Long.MIN_VALUE) {
                    jxVar.e(a3);
                }
                long f = this.a.f(0);
                if (f != 0) {
                    jxVar.a(f);
                }
                long h = this.a.h(0);
                if (h != 0) {
                    jxVar.b(h);
                }
                jxVar.h();
            }
        }

        @VisibleForTesting
        public void d() {
            jx jxVar = new jx(this.b, "background");
            if (!jxVar.i()) {
                long e = this.a.e(-1);
                if (e != -1) {
                    jxVar.d(e);
                }
                long b2 = this.a.b(Long.MIN_VALUE);
                if (b2 != Long.MIN_VALUE) {
                    jxVar.e(b2);
                }
                long g = this.a.g(0);
                if (g != 0) {
                    jxVar.a(g);
                }
                long i = this.a.i(0);
                if (i != 0) {
                    jxVar.b(i);
                }
                jxVar.h();
            }
        }
    }

    public static class c extends h {
        public c(fe feVar, sy syVar) {
            super(feVar, syVar);
        }

        @Override // com.yandex.metrica.impl.ob.fd.g
        public boolean a() {
            return e() instanceof fq;
        }

        @Override // com.yandex.metrica.impl.ob.fd.g
        public void b() {
            c().a();
        }
    }

    public static class d extends g {
        private final sz a;
        private final mm b;

        public d(fe feVar, sz szVar) {
            super(feVar);
            this.a = szVar;
            this.b = feVar.u();
        }

        @Override // com.yandex.metrica.impl.ob.fd.g
        public boolean a() {
            return "DONE".equals(this.a.c(null)) || "DONE".equals(this.a.b(null));
        }

        @Override // com.yandex.metrica.impl.ob.fd.g
        public void b() {
            if ("DONE".equals(this.a.c(null))) {
                this.b.b();
            }
            String e = this.a.e(null);
            if (!TextUtils.isEmpty(e)) {
                this.b.c(e);
            }
            if ("DONE".equals(this.a.b(null))) {
                this.b.a();
            }
            this.a.d();
            this.a.e();
            this.a.c();
        }
    }

    public static class e extends h {
        public e(fe feVar, sy syVar) {
            super(feVar, syVar);
        }

        @Override // com.yandex.metrica.impl.ob.fd.g
        public boolean a() {
            return e().u().a(null) == null;
        }

        @Override // com.yandex.metrica.impl.ob.fd.g
        public void b() {
            sy c = c();
            if (e() instanceof fq) {
                c.c();
            } else {
                c.b();
            }
        }
    }

    public static class f extends g {
        @Deprecated
        public static final th a = new th("SESSION_SLEEP_START");
        @Deprecated
        public static final th b = new th("SESSION_ID");
        @Deprecated
        public static final th c = new th("SESSION_COUNTER_ID");
        @Deprecated
        public static final th d = new th("SESSION_INIT_TIME");
        @Deprecated
        public static final th e = new th("SESSION_IS_ALIVE_REPORT_NEEDED");
        @Deprecated
        public static final th f = new th("BG_SESSION_ID");
        @Deprecated
        public static final th g = new th("BG_SESSION_SLEEP_START");
        @Deprecated
        public static final th h = new th("BG_SESSION_COUNTER_ID");
        @Deprecated
        public static final th i = new th("BG_SESSION_INIT_TIME");
        @Deprecated
        public static final th j = new th("BG_SESSION_IS_ALIVE_REPORT_NEEDED");
        private final mo k;

        public f(fe feVar) {
            super(feVar);
            this.k = feVar.y();
        }

        private void g() {
            this.k.r(a.b());
            this.k.r(b.b());
            this.k.r(c.b());
            this.k.r(d.b());
            this.k.r(e.b());
            this.k.r(f.b());
            this.k.r(g.b());
            this.k.r(h.b());
            this.k.r(i.b());
            this.k.r(j.b());
        }

        @Override // com.yandex.metrica.impl.ob.fd.g
        public boolean a() {
            return true;
        }

        @Override // com.yandex.metrica.impl.ob.fd.g
        public void b() {
            d();
            c();
            g();
        }

        @VisibleForTesting
        public void c() {
            long b2 = this.k.b(a.b(), -2147483648L);
            if (b2 != -2147483648L) {
                jx jxVar = new jx(this.k, DownloadService.KEY_FOREGROUND);
                if (!jxVar.i()) {
                    if (b2 != 0) {
                        jxVar.b(b2);
                    }
                    long b3 = this.k.b(b.b(), -1L);
                    if (-1 != b3) {
                        jxVar.d(b3);
                    }
                    boolean b4 = this.k.b(e.b(), true);
                    if (b4) {
                        jxVar.a(b4);
                    }
                    long b5 = this.k.b(d.b(), Long.MIN_VALUE);
                    if (b5 != Long.MIN_VALUE) {
                        jxVar.e(b5);
                    }
                    long b6 = this.k.b(c.b(), 0L);
                    if (b6 != 0) {
                        jxVar.a(b6);
                    }
                    jxVar.h();
                }
            }
        }

        @VisibleForTesting
        public void d() {
            long b2 = this.k.b(g.b(), -2147483648L);
            if (b2 != -2147483648L) {
                jx jxVar = new jx(this.k, "background");
                if (!jxVar.i()) {
                    if (b2 != 0) {
                        jxVar.b(b2);
                    }
                    long b3 = this.k.b(f.b(), -1L);
                    if (b3 != -1) {
                        jxVar.d(b3);
                    }
                    boolean b4 = this.k.b(j.b(), true);
                    if (b4) {
                        jxVar.a(b4);
                    }
                    long b5 = this.k.b(i.b(), Long.MIN_VALUE);
                    if (b5 != Long.MIN_VALUE) {
                        jxVar.e(b5);
                    }
                    long b6 = this.k.b(h.b(), 0L);
                    if (b6 != 0) {
                        jxVar.a(b6);
                    }
                    jxVar.h();
                }
            }
        }
    }

    public static abstract class g {
        private final fe a;

        public g(fe feVar) {
            this.a = feVar;
        }

        public abstract boolean a();

        public abstract void b();

        public fe e() {
            return this.a;
        }

        public void f() {
            if (a()) {
                b();
            }
        }
    }

    public static abstract class h extends g {
        private sy a;

        public h(fe feVar, sy syVar) {
            super(feVar);
            this.a = syVar;
        }

        public sy c() {
            return this.a;
        }
    }

    private void b() {
        LinkedList linkedList = new LinkedList();
        this.c = linkedList;
        linkedList.add(new c(this.a, this.b));
        this.c.add(new e(this.a, this.b));
        List<g> list = this.c;
        fe feVar = this.a;
        list.add(new d(feVar, feVar.v()));
        this.c.add(new b(this.a));
        this.c.add(new f(this.a));
    }

    public void a() {
        if (!a(this.a.c().a())) {
            for (g gVar : this.c) {
                gVar.f();
            }
        }
    }

    private fd(fe feVar, sy syVar) {
        this.a = feVar;
        this.b = syVar;
        b();
    }

    private boolean a(String str) {
        return sy.a.values().contains(str);
    }
}

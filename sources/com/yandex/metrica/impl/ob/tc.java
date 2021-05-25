package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.Nullable;
import com.yandex.metrica.impl.ob.i;
@Deprecated
public class tc extends ta {
    @Deprecated
    public static final th d = new th("APP_ENVIRONMENT");
    @Deprecated
    public static final th e = new th("APP_ENVIRONMENT_REVISION");
    private static final th f = new th("SESSION_SLEEP_START_");
    private static final th g = new th("SESSION_ID_");
    private static final th h = new th("SESSION_COUNTER_ID_");
    private static final th i = new th("SESSION_INIT_TIME_");
    private static final th j = new th("SESSION_ALIVE_TIME_");
    private static final th k = new th("SESSION_IS_ALIVE_REPORT_NEEDED_");
    private static final th l = new th("BG_SESSION_ID_");
    private static final th m = new th("BG_SESSION_SLEEP_START_");
    private static final th n = new th("BG_SESSION_COUNTER_ID_");
    private static final th o = new th("BG_SESSION_INIT_TIME_");
    private static final th p = new th("COLLECT_INSTALLED_APPS_");
    private static final th q = new th("IDENTITY_SEND_TIME_");
    private static final th r = new th("USER_INFO_");
    private static final th s = new th("REFERRER_");
    private static final th t = new th("APP_ENVIRONMENT_");
    private static final th u = new th("APP_ENVIRONMENT_REVISION_");
    private th A = new th(k.a(), i());
    private th B = new th(l.a(), i());
    private th C = new th(m.a(), i());
    private th D = new th(n.a(), i());
    private th E = new th(o.a(), i());
    private th F = new th(q.a(), i());
    private th G = new th(p.a(), i());
    private th H = new th(r.a(), i());
    private th I = new th(s.a(), i());
    private th J = new th(t.a(), i());
    private th K = new th(u.a(), i());
    private th v = new th(f.a(), i());
    private th w = new th(g.a(), i());
    private th x = new th(h.a(), i());
    private th y = new th(i.a(), i());
    private th z = new th(j.a(), i());

    public tc(Context context, String str) {
        super(context, str);
        a(-1);
        b(0);
        c(0);
    }

    public long a(long j2) {
        return a(this.y.b(), j2);
    }

    public long b(long j2) {
        return a(this.E.b(), j2);
    }

    public long c(long j2) {
        return a(this.F.b(), j2);
    }

    public long d(long j2) {
        return a(this.w.b(), j2);
    }

    public long e(long j2) {
        return a(this.B.b(), j2);
    }

    public long f(long j2) {
        return a(this.x.b(), j2);
    }

    @Override // com.yandex.metrica.impl.ob.ta
    public String f() {
        return "_boundentrypreferences";
    }

    public long g(long j2) {
        return a(this.D.b(), j2);
    }

    public long h(long j2) {
        return a(this.v.b(), j2);
    }

    public long i(long j2) {
        return a(this.C.b(), j2);
    }

    private long a(String str, long j2) {
        return this.c.getLong(str, j2);
    }

    public Boolean b() {
        int i2 = this.c.getInt(this.G.b(), -1);
        if (i2 == 0) {
            return Boolean.FALSE;
        }
        if (i2 != 1) {
            return null;
        }
        return Boolean.TRUE;
    }

    public tc c() {
        return (tc) h(this.I.b());
    }

    public tc d() {
        return this.c.contains(this.G.b()) ? (tc) h(this.G.b()) : this;
    }

    public boolean e() {
        return this.c.contains(this.y.b()) || this.c.contains(this.z.b()) || this.c.contains(this.A.b()) || this.c.contains(this.v.b()) || this.c.contains(this.w.b()) || this.c.contains(this.x.b()) || this.c.contains(this.E.b()) || this.c.contains(this.C.b()) || this.c.contains(this.B.b()) || this.c.contains(this.D.b()) || this.c.contains(this.J.b()) || this.c.contains(this.H.b()) || this.c.contains(this.I.b()) || this.c.contains(this.F.b());
    }

    public void g() {
        this.c.edit().remove(this.E.b()).remove(this.D.b()).remove(this.B.b()).remove(this.C.b()).remove(this.y.b()).remove(this.x.b()).remove(this.w.b()).remove(this.v.b()).remove(this.A.b()).remove(this.z.b()).remove(this.H.b()).remove(this.J.b()).remove(this.K.b()).remove(this.I.b()).remove(this.F.b()).apply();
    }

    private void c(int i2) {
        ti.a(this.c, this.x.b(), i2);
    }

    @Nullable
    public i.a a() {
        synchronized (this) {
            if (!this.c.contains(this.J.b()) || !this.c.contains(this.K.b())) {
                return null;
            }
            return new i.a(this.c.getString(this.J.b(), "{}"), this.c.getLong(this.K.b(), 0));
        }
    }

    public String b(String str) {
        return this.c.getString(this.I.b(), str);
    }

    private void b(int i2) {
        ti.a(this.c, this.v.b(), i2);
    }

    public Boolean a(boolean z2) {
        return Boolean.valueOf(this.c.getBoolean(this.A.b(), z2));
    }

    public String a(String str) {
        return this.c.getString(this.H.b(), str);
    }

    public tc a(i.a aVar) {
        synchronized (this) {
            a(this.J.b(), aVar.a);
            a(this.K.b(), Long.valueOf(aVar.b));
        }
        return this;
    }

    private void a(int i2) {
        ti.a(this.c, this.z.b(), i2);
    }
}

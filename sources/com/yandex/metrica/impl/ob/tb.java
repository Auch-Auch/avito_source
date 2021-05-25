package com.yandex.metrica.impl.ob;

import android.content.Context;
import java.util.Map;
@Deprecated
public class tb extends ta {
    private static final th d = new th("UUID");
    private static final th e = new th("DEVICEID");
    private static final th f = new th("DEVICEID_2");
    private static final th g = new th("DEVICEID_3");
    private static final th h = new th("AD_URL_GET");
    private static final th i = new th("AD_URL_REPORT");
    private static final th j = new th("HOST_URL");
    private static final th k = new th("SERVER_TIME_OFFSET");
    private static final th l = new th("STARTUP_REQUEST_TIME");
    private static final th m = new th("CLIDS");
    private th n = new th(d.a());
    private th o = new th(e.a());
    private th p = new th(f.a());
    private th q = new th(g.a());
    private th r = new th(h.a());
    private th s = new th(i.a());
    private th t = new th(j.a());
    private th u = new th(k.a());
    private th v = new th(l.a());
    private th w = new th(m.a());

    public tb(Context context) {
        super(context, null);
    }

    public String a(String str) {
        return this.c.getString(this.n.b(), str);
    }

    public String b(String str) {
        return this.c.getString(this.q.b(), str);
    }

    public String c(String str) {
        return this.c.getString(this.r.b(), str);
    }

    public String d(String str) {
        return this.c.getString(this.s.b(), str);
    }

    public String e(String str) {
        return this.c.getString(this.w.b(), str);
    }

    @Override // com.yandex.metrica.impl.ob.ta
    public String f() {
        return "_startupinfopreferences";
    }

    public String a() {
        return this.c.getString(this.p.b(), this.c.getString(this.o.b(), ""));
    }

    public long b(long j2) {
        return this.c.getLong(this.v.b(), j2);
    }

    public Map<String, ?> c() {
        return this.c.getAll();
    }

    public tb b() {
        return (tb) h();
    }

    public long a(long j2) {
        return this.c.getLong(this.u.a(), j2);
    }
}

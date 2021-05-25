package com.yandex.metrica.impl.ob;

import android.content.Context;
@Deprecated
public class tf extends ta {
    public static final th d = new th("PREF_KEY_DEVICE_ID_");
    public static final th e = new th("PREF_KEY_UID_");
    public static final th f = new th("STARTUP_CLIDS_MATCH_WITH_APP_CLIDS_");
    public static final th g = new th("PREF_KEY_PINNING_UPDATE_URL");
    private static final th h = new th("PREF_KEY_HOST_URL_");
    private static final th i = new th("PREF_KEY_REPORT_URL_");
    private static final th j = new th("PREF_KEY_GET_AD_URL");
    private static final th k = new th("PREF_KEY_REPORT_AD_URL");
    private static final th l = new th("PREF_KEY_STARTUP_OBTAIN_TIME_");
    private static final th m = new th("PREF_KEY_STARTUP_ENCODED_CLIDS_");
    private static final th n = new th("PREF_KEY_DISTRIBUTION_REFERRER_");
    private static final th o = new th("PREF_KEY_EASY_COLLECTING_ENABLED_");
    private th p;
    private th q;
    private th r;
    private th s;
    private th t;
    private th u;
    private th v;
    private th w;
    private th x;
    private th y;

    public tf(Context context) {
        this(context, null);
    }

    public long a(long j2) {
        return this.c.getLong(this.v.b(), j2);
    }

    public String b(String str) {
        return this.c.getString(this.q.b(), str);
    }

    public String c(String str) {
        return this.c.getString(this.r.b(), str);
    }

    public String d(String str) {
        return this.c.getString(this.w.b(), str);
    }

    public String e(String str) {
        return this.c.getString(this.s.b(), str);
    }

    @Override // com.yandex.metrica.impl.ob.ta
    public String f() {
        return "_startupserviceinfopreferences";
    }

    public String f(String str) {
        return this.c.getString(this.t.b(), str);
    }

    public String g(String str) {
        return this.c.getString(this.u.b(), str);
    }

    public tf i(String str) {
        return (tf) a(this.q.b(), str);
    }

    public tf j(String str) {
        return (tf) a(this.p.b(), str);
    }

    public tf(Context context, String str) {
        super(context, str);
        this.p = new th(d.a());
        this.q = new th(e.a(), i());
        this.r = new th(h.a(), i());
        this.s = new th(i.a(), i());
        this.t = new th(j.a(), i());
        this.u = new th(k.a(), i());
        this.v = new th(l.a(), i());
        this.w = new th(m.a(), i());
        this.x = new th(n.a(), i());
        this.y = new th(o.a(), i());
    }

    public String a(String str) {
        return this.c.getString(this.p.b(), str);
    }

    public void b() {
        h(this.p.b()).h(this.q.b()).h(this.r.b()).h(this.s.b()).h(this.t.b()).h(this.u.b()).h(this.v.b()).h(this.y.b()).h(this.w.b()).h(this.x.a()).h(f.a()).h(g.a()).j();
    }

    public String a() {
        return this.c.getString(this.x.a(), null);
    }

    public static void a(Context context) {
        ti.a(context, "_startupserviceinfopreferences").edit().remove(d.a()).apply();
    }
}

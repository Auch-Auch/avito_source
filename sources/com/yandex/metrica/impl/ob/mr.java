package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.xk;
import com.yandex.metrica.impl.ob.yb;
import java.util.List;
@Deprecated
public class mr extends mp {
    public static final th a = new th("PREF_KEY_UID_");
    public static final th b = new th("PREF_KEY_DEVICE_ID_");
    private static final th c = new th("PREF_KEY_HOST_URL_");
    private static final th d = new th("PREF_KEY_HOST_URLS_FROM_STARTUP");
    private static final th e = new th("PREF_KEY_HOST_URLS_FROM_CLIENT");
    @Deprecated
    private static final th f = new th("PREF_KEY_REPORT_URL_");
    private static final th g = new th("PREF_KEY_REPORT_URLS_");
    @Deprecated
    private static final th h = new th("PREF_L_URL");
    private static final th i = new th("PREF_L_URLS");
    private static final th j = new th("PREF_KEY_GET_AD_URL");
    private static final th k = new th("PREF_KEY_REPORT_AD_URL");
    private static final th l = new th("PREF_KEY_STARTUP_OBTAIN_TIME_");
    private static final th m = new th("PREF_KEY_STARTUP_ENCODED_CLIDS_");
    private static final th n = new th("PREF_KEY_DISTRIBUTION_REFERRER_");
    private static final th o = new th("STARTUP_CLIDS_MATCH_WITH_APP_CLIDS_");
    @Deprecated
    private static final th p = new th("PREF_KEY_PINNING_UPDATE_URL");
    private static final th q = new th("PREF_KEY_EASY_COLLECTING_ENABLED_");
    private static final th r = new th("PREF_KEY_COLLECTING_PACKAGE_INFO_ENABLED_");
    private static final th s = new th("PREF_KEY_PERMISSIONS_COLLECTING_ENABLED_");
    private static final th t = new th("PREF_KEY_FEATURES_COLLECTING_ENABLED_");
    private static final th v = new th("SOCKET_CONFIG_");
    private static final th w = new th("LAST_STARTUP_REQUEST_CLIDS");
    private th A = q(d.a());
    private th B = q(e.a());
    @Deprecated
    private th C = q(f.a());
    private th D = q(g.a());
    @Deprecated
    private th E = q(h.a());
    private th F = q(i.a());
    private th G = q(j.a());
    private th H = q(k.a());
    private th I = q(l.a());
    private th J = q(m.a());
    private th K = q(n.a());
    private th L = q(o.a());
    private th M = q(q.a());
    private th N = q(r.a());
    private th O = q(s.a());
    private th P = q(t.a());
    private th Q = q(v.a());
    private th R = q(w.a());
    private th x = new th(b.a());
    private th y = q(a.a());
    private th z = q(c.a());

    public mr(lx lxVar, String str) {
        super(lxVar, str);
    }

    public mr a(String str) {
        return (mr) b(this.y.b(), str);
    }

    @Deprecated
    public mr b(String str) {
        return (mr) b(this.x.b(), str);
    }

    @Deprecated
    public mr c(String str) {
        return (mr) b(this.C.b(), str);
    }

    public mr d(String str) {
        return (mr) b(this.H.b(), str);
    }

    public mr e(String str) {
        return (mr) b(this.G.b(), str);
    }

    public mr f(String str) {
        return (mr) b(this.z.b(), str);
    }

    public mr g(String str) {
        return (mr) b(this.J.b(), str);
    }

    public mr h(String str) {
        return (mr) b(this.K.b(), str);
    }

    @Deprecated
    public String i(String str) {
        return c(this.C.b(), str);
    }

    @Deprecated
    public String j(String str) {
        return c(this.E.b(), str);
    }

    public mr a(List<String> list) {
        return (mr) b(this.D.b(), abc.a(list));
    }

    public mr b(List<String> list) {
        return (mr) b(this.F.b(), abc.a(list));
    }

    public mr a(long j2) {
        return (mr) a(this.I.b(), j2);
    }

    public mr a(boolean z2) {
        return (mr) a(this.L.b(), z2);
    }

    @NonNull
    @Deprecated
    public yb a() {
        return new yb.a(new xk.a().a(b(this.M.b(), xk.b.a)).b(b(this.N.b(), xk.b.b)).c(b(this.O.b(), xk.b.c)).d(b(this.P.b(), xk.b.d)).a()).a(s(this.y.b())).c(abc.c(s(this.A.b()))).d(abc.c(s(this.B.b()))).h(s(this.J.b())).a(abc.c(s(this.D.b()))).b(abc.c(s(this.F.b()))).e(s(this.G.b())).f(s(this.H.b())).j(c(this.K.b(), null)).a(xs.a(s(this.Q.b()))).i(s(this.R.b())).b(b(this.L.b(), true)).a(b(this.I.b(), -1L)).a();
    }
}

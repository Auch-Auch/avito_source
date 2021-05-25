package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import com.yandex.metrica.IParamsCallback;
import com.yandex.metrica.impl.ob.op;
import com.yandex.metrica.impl.ob.pc;
import com.yandex.metrica.impl.ob.wf;
import com.yandex.metrica.impl.ob.yb;
import java.util.Collection;
import java.util.List;
import java.util.Map;
public class yc implements fj {
    private static final pc.a[] a = {pc.a.GOOGLE, pc.a.HMS};
    @NonNull
    private final Context b;
    @NonNull
    private final fb c;
    @NonNull
    private final ya d;
    @NonNull
    private volatile mx<yb> e;
    @Nullable
    private volatile de f;
    @NonNull
    private xu g;

    public yc(@NonNull Context context, @NonNull String str, @NonNull wf.a aVar, @NonNull ya yaVar) {
        this(context, new ex(str), aVar, yaVar, op.a.a(yb.class).a(context), new aba());
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0075  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(@android.support.annotation.NonNull com.yandex.metrica.impl.ob.yb r7, @android.support.annotation.NonNull com.yandex.metrica.impl.ob.aba r8) {
        /*
            r6 = this;
            com.yandex.metrica.impl.ob.yb$a r0 = r7.a()
            com.yandex.metrica.impl.ob.xu r1 = r6.g
            com.yandex.metrica.impl.ob.vy r1 = r1.d()
            com.yandex.metrica.impl.ob.wf r1 = (com.yandex.metrica.impl.ob.wf) r1
            java.util.Map r1 = r1.E()
            com.yandex.metrica.impl.ob.pc r1 = r6.a(r1)
            java.lang.String r2 = ""
            r3 = 1
            if (r1 == 0) goto L_0x002e
            java.lang.String r1 = r1.b
            java.lang.String r1 = r8.a(r1)
            java.lang.String r4 = r7.c
            boolean r4 = android.text.TextUtils.equals(r4, r1)
            if (r4 != 0) goto L_0x002c
            com.yandex.metrica.impl.ob.yb$a r0 = r0.c(r1)
            goto L_0x0033
        L_0x002c:
            r4 = 0
            goto L_0x0034
        L_0x002e:
            com.yandex.metrica.impl.ob.yb$a r0 = r0.c(r2)
            r1 = r2
        L_0x0033:
            r4 = 1
        L_0x0034:
            java.lang.String r5 = r7.a
            boolean r5 = r6.a(r5)
            if (r5 == 0) goto L_0x0047
            java.lang.String r5 = r7.b
            boolean r5 = r6.b(r5)
            if (r5 != 0) goto L_0x0045
            goto L_0x0047
        L_0x0045:
            r3 = r4
            goto L_0x0068
        L_0x0047:
            java.lang.String r4 = r7.a
            boolean r4 = r6.a(r4)
            if (r4 != 0) goto L_0x0057
            java.lang.String r8 = r8.a()
            com.yandex.metrica.impl.ob.yb$a r0 = r0.a(r8)
        L_0x0057:
            java.lang.String r8 = r7.b
            boolean r8 = r6.b(r8)
            if (r8 != 0) goto L_0x0068
            com.yandex.metrica.impl.ob.yb$a r8 = r0.b(r1)
            com.yandex.metrica.impl.ob.yb$a r8 = r8.d(r2)
            r0 = r8
        L_0x0068:
            if (r3 == 0) goto L_0x0075
            com.yandex.metrica.impl.ob.yb r7 = r0.a()
            r6.d(r7)
            r6.b(r7)
            goto L_0x0078
        L_0x0075:
            r6.b(r7)
        L_0x0078:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.metrica.impl.ob.yc.a(com.yandex.metrica.impl.ob.yb, com.yandex.metrica.impl.ob.aba):void");
    }

    @Deprecated
    private void e(yb ybVar) {
        if (!TextUtils.isEmpty(ybVar.b)) {
            try {
                Intent intent = new Intent("com.yandex.metrica.intent.action.SYNC");
                intent.putExtra("CAUSE", "CAUSE_DEVICE_ID");
                intent.putExtra("SYNC_TO_PKG", this.c.b());
                intent.putExtra("SYNC_DATA", ybVar.b);
                intent.putExtra("SYNC_DATA_2", ybVar.a);
                this.b.sendBroadcast(intent);
            } catch (Throwable unused) {
            }
        }
    }

    private synchronized void f() {
        this.f = null;
    }

    public synchronized boolean b() {
        boolean z;
        z = e().H;
        if (!z && !(!a(((Long) abw.b(Long.valueOf(e().u), 0L)).longValue())) && !b(((wf) this.g.d()).J())) {
            z = true;
        }
        return z;
    }

    @Override // com.yandex.metrica.impl.ob.fj
    @NonNull
    public fb c() {
        return this.c;
    }

    @NonNull
    public wf d() {
        return (wf) this.g.d();
    }

    private void c(@NonNull yb ybVar) {
        this.d.a(this.c.b(), ybVar);
        b(ybVar);
    }

    private void d(@NonNull yb ybVar) {
        this.g.a(ybVar);
        a(ybVar);
        e(ybVar);
    }

    private yc(@NonNull Context context, @NonNull fb fbVar, @NonNull wf.a aVar, @NonNull ya yaVar, @NonNull mx<yb> mxVar, @NonNull aba aba) {
        this(context, fbVar, aVar, yaVar, mxVar, mxVar.a(), aba);
    }

    private boolean c(@Nullable String str) {
        return !TextUtils.isEmpty(str);
    }

    private boolean d(@Nullable String str) {
        return !TextUtils.isEmpty(str);
    }

    private yc(@NonNull Context context, @NonNull fb fbVar, @NonNull wf.a aVar, @NonNull ya yaVar, @NonNull mx<yb> mxVar, @NonNull yb ybVar, @NonNull aba aba) {
        this(context, fbVar, yaVar, mxVar, ybVar, aba, new xu(new wf.b(context, fbVar.b()), ybVar, aVar));
    }

    private boolean b(@Nullable Map<String, String> map) {
        if (dl.a((Map) map)) {
            return true;
        }
        return map.equals(abq.a(e().n));
    }

    @NonNull
    public yb e() {
        return this.g.b();
    }

    @VisibleForTesting
    public yc(@NonNull Context context, @NonNull fb fbVar, @NonNull ya yaVar, @NonNull mx<yb> mxVar, @NonNull yb ybVar, @NonNull aba aba, @NonNull xu xuVar) {
        this.b = context;
        this.c = fbVar;
        this.d = yaVar;
        this.e = mxVar;
        this.g = xuVar;
        a(ybVar, aba);
    }

    private boolean e(@Nullable String str) {
        return !TextUtils.isEmpty(str);
    }

    public void b(yb ybVar) {
        eh.a().b(new er(this.c.b(), ybVar));
        if (!TextUtils.isEmpty(ybVar.a)) {
            eh.a().b(new es(ybVar.a, this.c.b()));
        }
        if (!TextUtils.isEmpty(ybVar.b)) {
            eh.a().b(new eo(ybVar.b));
        }
        if (ybVar.r == null) {
            eh.a().a(eq.class);
        } else {
            eh.a().b(new eq(ybVar.r));
        }
    }

    private boolean b(@Nullable String str) {
        return !TextUtils.isEmpty(str);
    }

    @VisibleForTesting
    @Nullable
    public pc a(@NonNull Map<pc.a, pc> map) {
        for (pc.a aVar : a) {
            pc pcVar = map.get(aVar);
            if (!(pcVar == null || TextUtils.isEmpty(pcVar.b))) {
                return pcVar;
            }
        }
        return null;
    }

    @Nullable
    public synchronized de a() {
        if (!b()) {
            return null;
        }
        if (this.f == null) {
            this.f = new de(this, d());
        }
        return this.f;
    }

    public synchronized boolean a(@Nullable List<String> list, @NonNull Map<String, String> map) {
        boolean a3;
        boolean z = false;
        if (list == null) {
            return false;
        }
        yb b2 = this.g.b();
        for (String str : list) {
            if (str.equals("yandex_mobile_metrica_uuid")) {
                a3 = a(b2.a);
            } else if (str.equals("yandex_mobile_metrica_device_id")) {
                a3 = b(b2.b);
            } else if (str.equals("appmetrica_device_id_hash")) {
                a3 = c(b2.d);
            } else if (str.equals("yandex_mobile_metrica_get_ad_url")) {
                a3 = d(b2.f);
            } else if (str.equals("yandex_mobile_metrica_report_ad_url")) {
                a3 = e(b2.g);
            } else if (str.equals(IParamsCallback.YANDEX_MOBILE_METRICA_CLIDS)) {
                a3 = b(map);
            } else {
                z = true;
            }
            z |= !a3;
        }
        return z;
    }

    @VisibleForTesting
    public synchronized boolean a(long j) {
        if (!((wf) this.g.d()).g()) {
            return false;
        }
        long b2 = abu.b() - j;
        if (b2 > 86400 || b2 < 0) {
            return false;
        }
        return true;
    }

    @VisibleForTesting
    public void a(@NonNull yb ybVar) {
        this.e.a(ybVar);
    }

    public void a(@NonNull yx yxVar, @NonNull wf wfVar, @Nullable Map<String, List<String>> map) {
        yb a3;
        synchronized (this) {
            Long l = (Long) abw.b(yw.a(map), 0L);
            a(yxVar.r(), l);
            a3 = a(yxVar, wfVar, l);
            new os().a(this.b, new oq(a3.b, a3.d), new so(sl.b().a(a3).a()));
            f();
            d(a3);
        }
        c(a3);
    }

    @VisibleForTesting
    @NonNull
    public yb a(@NonNull yx yxVar, @NonNull wf wfVar, @Nullable Long l) {
        String a3 = abq.a(wfVar.J());
        String a4 = a(yxVar.j(), e().m);
        String str = e().b;
        if (TextUtils.isEmpty(str)) {
            str = yxVar.h();
        }
        yb e2 = e();
        return new yb.a(yxVar.a()).a(abu.b()).b(str).c(e().c).d(yxVar.i()).a(e().a).e(yxVar.d()).c(yxVar.b()).d(wfVar.I()).a(yxVar.e()).b(yxVar.g()).f(yxVar.f()).g(yxVar.c()).e(yxVar.u()).h(a4).i(a3).b(a(wfVar.J(), a4)).a(yxVar.l()).f(yxVar.p()).a(yxVar.q()).g(yxVar.s()).l(yxVar.t()).a(yxVar.m()).h(yxVar.o()).a(yxVar.n()).a(yxVar.v()).a(true).b(((Long) abw.b(l, Long.valueOf(abu.b() * 1000))).longValue()).c(((wf) this.g.d()).b(l.longValue())).c(false).j(e2.s).k(e2.t).a(yxVar.w()).a(yxVar.x()).a(yxVar.y()).a(yxVar.z()).a(yxVar.A()).b(yxVar.B()).a();
    }

    private void a(@Nullable Long l, @NonNull Long l2) {
        abp.a().a(l2.longValue(), l);
    }

    @Nullable
    private static String a(@Nullable String str, @Nullable String str2) {
        if (abq.b(str)) {
            return str;
        }
        if (abq.b(str2)) {
            return str2;
        }
        return null;
    }

    private boolean a(Map<String, String> map, @Nullable String str) {
        Map<String, String> a3 = abq.a(str);
        if (dl.a((Map) map)) {
            return dl.a((Map) a3);
        }
        return a3.equals(map);
    }

    public void a(@NonNull xv xvVar) {
        f();
        this.d.a(c().b(), xvVar, e());
    }

    public synchronized void a(@NonNull wf.a aVar) {
        this.g.a(aVar);
        a((wf) this.g.d());
    }

    private void a(wf wfVar) {
        if (wfVar.N()) {
            boolean z = false;
            List<String> M = wfVar.M();
            boolean z2 = true;
            yb.a aVar = null;
            if (dl.a((Collection) M) && !dl.a((Collection) wfVar.I())) {
                aVar = e().a().d((List<String>) null);
                z = true;
            }
            if (dl.a((Collection) M) || dl.a(M, wfVar.I())) {
                z2 = z;
            } else {
                aVar = e().a().d(M);
            }
            if (z2) {
                d(aVar.a());
            }
        }
    }

    public synchronized void a(String str, @NonNull bd bdVar) {
        d(e().a().j(str).k(bdVar.d).a());
    }

    private boolean a(@Nullable String str) {
        return !TextUtils.isEmpty(str);
    }
}

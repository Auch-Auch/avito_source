package com.yandex.metrica.impl.ob;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import com.yandex.browser.crashreports.a;
import com.yandex.metrica.a;
import com.yandex.metrica.j;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
public class bj extends o implements av, bm, dm {
    private static final adw<String> f = new ads(new adq("Deeplink"));
    private static final adw<String> g = new ads(new adq("Referral url"));
    private static final Long h = Long.valueOf(TimeUnit.SECONDS.toMillis(5));
    @NonNull
    private final com.yandex.metrica.a i;
    @NonNull
    private final vr j;
    @NonNull
    private final j k;
    @NonNull
    private final xw l;
    @NonNull
    private com.yandex.browser.crashreports.a m;
    @NonNull
    private final aao n;
    @NonNull
    private final mn o;
    @NonNull
    private final a p;
    @Nullable
    private volatile Activity q;
    private final Object r;
    private final AtomicBoolean s;
    private final eg t;

    public static class a {
        public aal a(@NonNull aai aai, boolean z) {
            return new aal(aai, z);
        }
    }

    public static class b {
        public aao a(@NonNull act act, @NonNull mn mnVar, @NonNull bj bjVar, @NonNull xw xwVar) {
            return new aao(act, mnVar, bjVar, bjVar, xwVar.d());
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public bj(@android.support.annotation.NonNull android.content.Context r17, @android.support.annotation.NonNull com.yandex.metrica.impl.ob.eu r18, @android.support.annotation.NonNull com.yandex.metrica.j r19, @android.support.annotation.NonNull com.yandex.metrica.impl.ob.cs r20, @android.support.annotation.NonNull com.yandex.metrica.impl.ob.xw r21, @android.support.annotation.NonNull com.yandex.metrica.impl.ob.cq r22, @android.support.annotation.NonNull com.yandex.metrica.impl.ob.cq r23, @android.support.annotation.NonNull com.yandex.metrica.impl.ob.mn r24) {
        /*
            r16 = this;
            r1 = r17
            r2 = r19
            com.yandex.metrica.impl.ob.co r4 = new com.yandex.metrica.impl.ob.co
            com.yandex.metrica.CounterConfiguration r0 = new com.yandex.metrica.CounterConfiguration
            r0.<init>(r2)
            r3 = r18
            r4.<init>(r3, r0)
            com.yandex.metrica.a r5 = new com.yandex.metrica.a
            java.lang.Integer r0 = r2.sessionTimeout
            if (r0 != 0) goto L_0x001f
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS
            r6 = 10
            long r6 = r0.toMillis(r6)
            goto L_0x0024
        L_0x001f:
            int r0 = r0.intValue()
            long r6 = (long) r0
        L_0x0024:
            r5.<init>(r6)
            com.yandex.metrica.impl.ob.vr r6 = new com.yandex.metrica.impl.ob.vr
            r6.<init>(r1)
            com.yandex.metrica.impl.ob.bh r8 = new com.yandex.metrica.impl.ob.bh
            r8.<init>()
            com.yandex.metrica.impl.ob.act r12 = com.yandex.metrica.impl.ob.dr.a()
            com.yandex.metrica.impl.ob.am r13 = new com.yandex.metrica.impl.ob.am
            r13.<init>(r1)
            com.yandex.metrica.impl.ob.bj$b r14 = new com.yandex.metrica.impl.ob.bj$b
            r14.<init>()
            com.yandex.metrica.impl.ob.bj$a r15 = new com.yandex.metrica.impl.ob.bj$a
            r15.<init>()
            r0 = r16
            r1 = r17
            r2 = r19
            r3 = r20
            r7 = r21
            r9 = r22
            r10 = r23
            r11 = r24
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yandex.metrica.impl.ob.bj.<init>(android.content.Context, com.yandex.metrica.impl.ob.eu, com.yandex.metrica.j, com.yandex.metrica.impl.ob.cs, com.yandex.metrica.impl.ob.xw, com.yandex.metrica.impl.ob.cq, com.yandex.metrica.impl.ob.cq, com.yandex.metrica.impl.ob.mn):void");
    }

    @TargetApi(14)
    private void b(Application application, @NonNull act act) {
        application.registerActivityLifecycleCallbacks(new ad(this, act));
    }

    private void h(@Nullable String str) {
        if (this.c.c()) {
            this.c.a("Referral URL received: " + d(str));
        }
    }

    @Override // com.yandex.metrica.impl.ob.bm
    public void b(boolean z) {
    }

    public void c(Activity activity) {
        b(d(activity));
        this.i.b();
        synchronized (this.r) {
            this.q = null;
        }
    }

    public String d(Activity activity) {
        if (activity != null) {
            return activity.getClass().getSimpleName();
        }
        return null;
    }

    public void e(String str) {
        f.a(str);
        this.e.a(al.g(str, this.c), this.b);
        g(str);
    }

    public void f(String str) {
        g.a(str);
        this.e.a(al.h(str, this.c), this.b);
        h(str);
    }

    public final void g() {
        if (this.s.compareAndSet(false, true)) {
            this.m.a();
        }
    }

    @Override // com.yandex.metrica.impl.ob.o, com.yandex.metrica.IReporter
    public void reportError(String str, Throwable th) {
        super.reportError(str, th);
    }

    @Override // com.yandex.metrica.impl.ob.av
    @Nullable
    public Activity a() {
        Activity activity;
        synchronized (this.r) {
            activity = this.q;
        }
        return activity;
    }

    public void b(Activity activity) {
        a(d(activity));
        this.i.a();
        this.n.a(activity);
        synchronized (this.r) {
            this.q = activity;
        }
    }

    private void g(@Nullable String str) {
        if (this.c.c()) {
            this.c.a("App opened  via deeplink: " + d(str));
        }
    }

    private void h() {
        this.e.b(this.b.g());
        this.i.a(new a.AbstractC0331a() { // from class: com.yandex.metrica.impl.ob.bj.2
            @Override // com.yandex.metrica.a.AbstractC0331a
            public void a() {
                bj bjVar = bj.this;
                bjVar.e.a(bjVar.b.g());
            }

            @Override // com.yandex.metrica.a.AbstractC0331a
            public void b() {
                bj bjVar = bj.this;
                bjVar.e.b(bjVar.b.g());
            }
        }, h.longValue());
    }

    public void a(Activity activity) {
        if (activity != null) {
            if (activity.getIntent() != null) {
                String dataString = activity.getIntent().getDataString();
                if (!TextUtils.isEmpty(dataString)) {
                    this.e.a(al.g(dataString, this.c), this.b);
                }
                g(dataString);
            }
        } else if (this.c.c()) {
            this.c.b("Null activity parameter for reportAppOpen(Activity)");
        }
    }

    @VisibleForTesting
    public bj(@NonNull Context context, @NonNull j jVar, @NonNull cs csVar, @NonNull co coVar, @NonNull com.yandex.metrica.a aVar, @NonNull vr vrVar, @NonNull xw xwVar, @NonNull bh bhVar, @NonNull cq cqVar, @NonNull cq cqVar2, @NonNull mn mnVar, @NonNull act act, @NonNull am amVar, @NonNull b bVar, @NonNull a aVar2) {
        super(context, csVar, coVar, amVar);
        this.r = new Object();
        this.s = new AtomicBoolean(false);
        this.t = new eg();
        this.b.a(new ch(jVar.preloadInfo, this.c));
        this.i = aVar;
        this.j = vrVar;
        this.k = jVar;
        aao a3 = bVar.a(act, mnVar, this, xwVar);
        this.n = a3;
        this.l = xwVar;
        this.o = mnVar;
        this.p = aVar2;
        xwVar.a(a3);
        boolean booleanValue = ((Boolean) abw.b(jVar.nativeCrashReporting, Boolean.TRUE)).booleanValue();
        this.e.a(booleanValue, this.b);
        if (this.c.c()) {
            this.c.a("Set report native crashes enabled: %b", Boolean.valueOf(booleanValue));
        }
        vrVar.a(aVar, jVar, jVar.m, xwVar.b(), this.c);
        this.m = a(act, bhVar, cqVar, cqVar2);
        if (aau.a(jVar.l)) {
            g();
        }
        h();
    }

    public void a(Application application, @NonNull act act) {
        if (this.c.c()) {
            this.c.a("Enable activity auto tracking");
        }
        b(application, act);
    }

    public void a(j jVar, boolean z) {
        if (z) {
            b();
        }
        b(jVar.i);
        a(jVar.h);
    }

    @Override // com.yandex.metrica.impl.ob.bm
    public void a(Location location) {
        this.b.h().a(location);
        if (this.c.c()) {
            abl abl = this.c;
            StringBuilder L = a2.b.a.a.a.L("Set location: %s");
            L.append(location.toString());
            abl.a(L.toString(), new Object[0]);
        }
    }

    @Override // com.yandex.metrica.impl.ob.bm
    public void a(boolean z) {
        this.b.h().a(z);
    }

    @NonNull
    private com.yandex.browser.crashreports.a a(@NonNull final act act, @NonNull final bh bhVar, @NonNull final cq cqVar, @NonNull final cq cqVar2) {
        return new com.yandex.browser.crashreports.a(new a.AbstractC0329a() { // from class: com.yandex.metrica.impl.ob.bj.1
            @Override // com.yandex.browser.crashreports.a.AbstractC0329a
            public void a() {
                final ky a3 = bj.this.t.a();
                act.a(new Runnable() { // from class: com.yandex.metrica.impl.ob.bj.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        bj.this.a(a3);
                        if (bhVar.a(a3.a.f)) {
                            cqVar.a().a(a3);
                        }
                        if (bhVar.b(a3.a.f)) {
                            cqVar2.a().a(a3);
                        }
                    }
                });
            }
        });
    }

    @Override // com.yandex.metrica.impl.ob.dm
    public void a(@NonNull JSONObject jSONObject) {
        this.e.a(al.a(jSONObject, this.c), this.b);
    }

    public void a(@NonNull aai aai, boolean z) {
        aal a3 = this.p.a(aai, z);
        zo a4 = this.n.a();
        Activity activity = this.q;
        if ((z || a4.a().isEmpty()) && activity != null) {
            a3.a(true);
            this.n.a(activity, a3, true);
        } else {
            a3.a(a4.b());
        }
        this.o.b(true);
    }
}

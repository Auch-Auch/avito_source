package com.yandex.metrica.impl.ob;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.AppMetricaDeviceIDListener;
import com.yandex.metrica.DeferredDeeplinkParametersListener;
import com.yandex.metrica.IIdentifierCallback;
import com.yandex.metrica.f;
import com.yandex.metrica.impl.ob.ab;
import com.yandex.metrica.impl.ob.abh;
import com.yandex.metrica.impl.ob.la;
import com.yandex.metrica.j;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
public class dr implements ab.a {
    @SuppressLint({"StaticFieldLeak"})
    private static dr a;
    private static ae b = new ae();
    private static volatile boolean c;
    private static final EnumMap<IIdentifierCallback.Reason, AppMetricaDeviceIDListener.Reason> d;
    private static acr e = new acr();
    private final Context f;
    private final cp g;
    private bj h;
    private bt i;
    private final xw j;
    private final ck k;
    private la l;
    private final eu m;
    private IIdentifierCallback n;
    private final mn o;
    private cs p;
    @NonNull
    private v q;

    static {
        EnumMap<IIdentifierCallback.Reason, AppMetricaDeviceIDListener.Reason> enumMap = new EnumMap<>(IIdentifierCallback.Reason.class);
        d = enumMap;
        enumMap.put((EnumMap<IIdentifierCallback.Reason, AppMetricaDeviceIDListener.Reason>) IIdentifierCallback.Reason.UNKNOWN, (IIdentifierCallback.Reason) AppMetricaDeviceIDListener.Reason.UNKNOWN);
        enumMap.put((EnumMap<IIdentifierCallback.Reason, AppMetricaDeviceIDListener.Reason>) IIdentifierCallback.Reason.INVALID_RESPONSE, (IIdentifierCallback.Reason) AppMetricaDeviceIDListener.Reason.INVALID_RESPONSE);
        enumMap.put((EnumMap<IIdentifierCallback.Reason, AppMetricaDeviceIDListener.Reason>) IIdentifierCallback.Reason.NETWORK, (IIdentifierCallback.Reason) AppMetricaDeviceIDListener.Reason.NETWORK);
    }

    private dr(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f = applicationContext;
        lx f2 = lv.a(applicationContext).f();
        abe.a(context.getApplicationContext());
        cx.a();
        pe.b().a(applicationContext);
        Handler a3 = k().b().a();
        eu euVar = new eu(applicationContext, new ab(a3, this));
        this.m = euVar;
        mn mnVar = new mn(f2);
        this.o = mnVar;
        cs csVar = new cs(euVar, applicationContext, k().b());
        this.p = csVar;
        b.a(csVar);
        new u(mnVar).a(applicationContext);
        xw xwVar = new xw(this.p, mnVar, a3);
        this.j = xwVar;
        this.p.a(xwVar);
        this.k = new ck(this.p, mnVar, k().b());
        this.g = new cp(applicationContext, euVar, this.p, a3, xwVar);
        v vVar = new v();
        this.q = vVar;
        vVar.a();
    }

    public static synchronized void b(@NonNull Context context, @NonNull j jVar) {
        synchronized (dr.class) {
            abl a3 = abd.a(jVar.apiKey);
            abb b2 = abd.b(jVar.apiKey);
            boolean d2 = b.d();
            j a4 = b.a(jVar);
            a(context);
            dr drVar = a;
            if (drVar.h == null) {
                drVar.b(jVar);
                a.j.a(a3);
                a.a(jVar);
                a.m.a(jVar);
                a.a(a4, d2);
                dl.b(a4.apiKey);
                if (aau.a(a4.logs)) {
                    a3.a();
                    b2.a();
                    abd.a().a();
                    abd.b().a();
                } else {
                    a3.b();
                    b2.b();
                    abd.a().b();
                    abd.b().b();
                }
            } else if (a3.c()) {
                a3.b("Appmetrica already has been activated!");
            }
        }
    }

    public static boolean c() {
        return c;
    }

    public static synchronized dr d() {
        dr drVar;
        synchronized (dr.class) {
            drVar = a;
        }
        return drVar;
    }

    @Nullable
    public static dr e() {
        return d();
    }

    public static synchronized bj f() {
        bj bjVar;
        synchronized (dr.class) {
            bjVar = d().h;
        }
        return bjVar;
    }

    public static synchronized boolean g() {
        boolean z;
        synchronized (dr.class) {
            dr drVar = a;
            z = (drVar == null || drVar.h == null) ? false : true;
        }
        return z;
    }

    @VisibleForTesting
    public static bm h() {
        return g() ? d().h : b;
    }

    public static acr k() {
        return e;
    }

    private void m() {
        be.a();
        k().b().a(new abh.a(this.f));
    }

    public String i() {
        return this.j.b();
    }

    public String j() {
        return this.j.a();
    }

    public static act a() {
        return k().a();
    }

    public void c(boolean z) {
        h().b(z);
    }

    public void d(boolean z) {
        h().setStatisticsSending(z);
    }

    public static synchronized void a(@NonNull Context context, @NonNull j jVar) {
        synchronized (dr.class) {
            a(context);
            if (((Boolean) abw.b(jVar.crashReporting, Boolean.TRUE)).booleanValue() && d().i == null) {
                d().i = new bt(Thread.getDefaultUncaughtExceptionHandler(), context);
                Thread.setDefaultUncaughtExceptionHandler(d().i);
            }
        }
    }

    public static synchronized void a(@NonNull final Context context) {
        synchronized (dr.class) {
            if (a == null) {
                dr drVar = new dr(context.getApplicationContext());
                a = drVar;
                drVar.m();
                a().a(new Runnable() { // from class: com.yandex.metrica.impl.ob.dr.1
                    @Override // java.lang.Runnable
                    public void run() {
                        xa.a(context);
                    }
                });
            }
        }
    }

    private void a(j jVar) {
        if (jVar != null) {
            this.j.a(jVar.d);
            this.j.a(jVar.b);
            this.j.a(jVar.c);
            if (dl.a((Object) jVar.c)) {
                this.j.b(bd.API.d);
            }
        }
    }

    public void a(@NonNull f fVar) {
        this.g.a(fVar);
    }

    public void a(String str) {
        this.k.a(str);
    }

    public static void a(Location location) {
        h().a(location);
    }

    public static void a(boolean z) {
        h().a(z);
    }

    public static void b() {
        c = true;
    }

    public void a(IIdentifierCallback iIdentifierCallback, @NonNull List<String> list) {
        this.j.a(iIdentifierCallback, list, this.m.c());
    }

    public static dr b(Context context) {
        a(context.getApplicationContext());
        return d();
    }

    @VisibleForTesting
    public void a(j jVar, boolean z) {
        this.p.a(jVar.locationTracking, jVar.statisticsSending, (Boolean) null);
        this.h = this.g.a(jVar, z, this.o);
        this.j.c();
    }

    @NonNull
    public ay b(@NonNull f fVar) {
        return this.g.b(fVar);
    }

    @Override // com.yandex.metrica.impl.ob.ab.a
    public void a(int i2, @NonNull Bundle bundle) {
        this.j.a(i2, bundle);
    }

    public void b(boolean z) {
        h().a(z);
    }

    private void b(@NonNull j jVar) {
        bt btVar = this.i;
        if (btVar != null) {
            btVar.a(new lb(new cq(this.g, "20799a27-fa80-4b36-b2db-0f8141f24180"), new la.a() { // from class: com.yandex.metrica.impl.ob.dr.3
                @Override // com.yandex.metrica.impl.ob.la.a
                public boolean a(Throwable th) {
                    return cx.a(th);
                }
            }, null));
            this.i.a(new lb(new cq(this.g, "0e5e9c33-f8c3-4568-86c5-2e4f57523f72"), new la.a() { // from class: com.yandex.metrica.impl.ob.dr.4
                @Override // com.yandex.metrica.impl.ob.la.a
                public boolean a(Throwable th) {
                    return cx.b(th);
                }
            }, null));
            if (this.l == null) {
                this.l = new lb(new cq(this.g, jVar.apiKey), new la.a() { // from class: com.yandex.metrica.impl.ob.dr.5
                    @Override // com.yandex.metrica.impl.ob.la.a
                    public boolean a(Throwable th) {
                        return true;
                    }
                }, jVar.n);
            }
            this.i.a(this.l);
        }
    }

    public void a(DeferredDeeplinkParametersListener deferredDeeplinkParametersListener) {
        this.k.a(deferredDeeplinkParametersListener);
    }

    public void a(@NonNull final AppMetricaDeviceIDListener appMetricaDeviceIDListener) {
        AnonymousClass2 r0 = new IIdentifierCallback() { // from class: com.yandex.metrica.impl.ob.dr.2
            @Override // com.yandex.metrica.IIdentifierCallback
            public void onReceive(Map<String, String> map) {
                dr.this.n = null;
                appMetricaDeviceIDListener.onLoaded(map.get("appmetrica_device_id_hash"));
            }

            @Override // com.yandex.metrica.IIdentifierCallback
            public void onRequestError(IIdentifierCallback.Reason reason) {
                dr.this.n = null;
                appMetricaDeviceIDListener.onError((AppMetricaDeviceIDListener.Reason) dr.d.get(reason));
            }
        };
        this.n = r0;
        this.j.a(r0, Collections.singletonList("appmetrica_device_id_hash"), this.m.c());
    }
}

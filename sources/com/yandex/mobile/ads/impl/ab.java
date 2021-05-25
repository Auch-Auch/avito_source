package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import com.yandex.mobile.ads.AdEventListener;
import com.yandex.mobile.ads.AdRequest;
import com.yandex.mobile.ads.AdRequestError;
import com.yandex.mobile.ads.b;
import com.yandex.mobile.ads.impl.ah;
import com.yandex.mobile.ads.impl.aj;
import com.yandex.mobile.ads.impl.dw;
import com.yandex.mobile.ads.impl.gn;
import com.yandex.mobile.ads.impl.tb;
import com.yandex.mobile.ads.impl.y;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
public abstract class ab<T> implements AdEventListener, ad, ah.b, tb.a<x<T>>, y.a {
    @NonNull
    public final Handler a;
    @NonNull
    public final Context b;
    @NonNull
    public final s c = new s(this);
    @NonNull
    public final y d;
    @NonNull
    public final aj e;
    @NonNull
    public final fo f;
    @Nullable
    public x<T> g;
    @NonNull
    private final gu h;
    @NonNull
    private final Executor i;
    @NonNull
    private final ah j;
    @NonNull
    private final ds k;
    @NonNull
    private final gn l;
    @NonNull
    private final dg m;
    @NonNull
    private final fq n;
    @NonNull
    private final fu o;
    @NonNull
    private int p;
    private boolean q;
    private long r;
    @Nullable
    private AdEventListener s;
    @NonNull
    private gm t;
    @NonNull
    private fw u;

    public ab(@NonNull Context context, @NonNull b bVar) {
        this.b = context;
        Handler handler = new Handler(Looper.getMainLooper());
        this.a = handler;
        y yVar = new y(handler);
        this.d = yVar;
        yVar.a(this);
        this.p = u.b;
        this.j = ah.a();
        this.k = new dq();
        fo foVar = new fo(bVar);
        this.f = foVar;
        this.i = Executors.newSingleThreadExecutor(new dz("YandexMobileAds.BaseController"));
        this.e = new aj(context, foVar);
        this.l = new gn(foVar);
        this.t = gk.a(context);
        this.h = new gu();
        this.m = new dg(context, foVar);
        fq fqVar = new fq();
        this.n = fqVar;
        this.o = new fu(fqVar);
        this.u = fs.a();
    }

    @VisibleForTesting
    private boolean A() {
        if (!dw.b()) {
            onAdFailedToLoad(v.s);
            return false;
        } else if (ar.a()) {
            return true;
        } else {
            onAdFailedToLoad(v.r);
            return false;
        }
    }

    private boolean B() {
        if (this.f.n()) {
            return true;
        }
        onAdFailedToLoad(v.p);
        return false;
    }

    private boolean h() {
        if (this.f.c() != null) {
            return true;
        }
        onAdFailedToLoad(v.n);
        return false;
    }

    @NonNull
    public abstract bx<T> a(String str, String str2);

    public final void a_(String str) {
        this.f.b(str);
    }

    public synchronized void d() {
        if (!a_()) {
            this.q = true;
            v();
            this.l.a(this.t);
            w();
            x();
            this.d.a(null);
            this.c.b();
            this.g = null;
            getClass().toString();
        }
    }

    public void e() {
        d();
    }

    @Nullable
    public AdEventListener i() {
        return this.s;
    }

    public synchronized void j() {
        AdEventListener adEventListener = this.s;
        if (adEventListener != null) {
            adEventListener.onAdLoaded();
        }
    }

    public final synchronized AdRequest k() {
        return this.f.c();
    }

    public final synchronized boolean l() {
        return this.p == u.d;
    }

    public final synchronized boolean m() {
        return this.p == u.a;
    }

    @NonNull
    public final Context n() {
        return this.b;
    }

    @VisibleForTesting
    public boolean o() {
        boolean z;
        boolean z2;
        if (p()) {
            if (this.f.b() == null) {
                onAdFailedToLoad(v.q);
                z = false;
            } else {
                z = true;
            }
            if (z) {
                if (!dt.b(this.b)) {
                    onAdFailedToLoad(v.b);
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (z2) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.yandex.mobile.ads.AdEventListener
    public synchronized void onAdClosed() {
        AdEventListener adEventListener = this.s;
        if (adEventListener != null) {
            adEventListener.onAdClosed();
        }
    }

    @Override // com.yandex.mobile.ads.AdEventListener
    public void onAdFailedToLoad(@NonNull final AdRequestError adRequestError) {
        ij.b(adRequestError.getDescription(), new Object[0]);
        c(u.e);
        this.a.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.ab.7
            @Override // java.lang.Runnable
            public final void run() {
                ab.this.a(adRequestError);
            }
        });
    }

    @Override // com.yandex.mobile.ads.AdEventListener
    public synchronized void onAdLeftApplication() {
        AdEventListener adEventListener = this.s;
        if (adEventListener != null) {
            adEventListener.onAdLeftApplication();
        }
    }

    @Override // com.yandex.mobile.ads.AdEventListener
    public void onAdLoaded() {
        t();
        j();
    }

    @Override // com.yandex.mobile.ads.AdEventListener
    public synchronized void onAdOpened() {
        AdEventListener adEventListener = this.s;
        if (adEventListener != null) {
            adEventListener.onAdOpened();
        }
    }

    @VisibleForTesting
    public final boolean p() {
        return A() && q() && B() && h();
    }

    @VisibleForTesting
    public final boolean q() {
        try {
            dw.a().a(this.b);
            return true;
        } catch (dw.a e2) {
            onAdFailedToLoad(v.a(e2.getMessage()));
            return false;
        }
    }

    public final String r() {
        return this.f.e();
    }

    @NonNull
    public final fo s() {
        return this.f;
    }

    public final void t() {
        c(u.d);
        this.r = SystemClock.elapsedRealtime();
    }

    public final void u() {
        this.j.a(this, this.b);
    }

    public final void v() {
        this.j.b(this, this.b);
    }

    public final void w() {
        this.h.a(this.b);
    }

    public final void x() {
        this.o.a(this.u);
    }

    public final boolean y() {
        return !this.j.a(this.b);
    }

    @Nullable
    public final x<T> z() {
        return this.g;
    }

    @Override // com.yandex.mobile.ads.impl.ad
    public final synchronized boolean a_() {
        return this.q;
    }

    public final synchronized void b(@Nullable AdRequest adRequest) {
        a(adRequest, this.k);
    }

    public final synchronized void c(AdRequest adRequest) {
        this.f.a(adRequest);
    }

    @Override // com.yandex.mobile.ads.impl.sa.b
    public /* bridge */ /* synthetic */ void a(@NonNull Object obj) {
        a((x) ((x) obj));
    }

    public final void a_(boolean z) {
        this.f.a(z);
    }

    public synchronized void a(@Nullable AdRequest adRequest) {
        if (b()) {
            if (d(adRequest)) {
                c(u.b);
                b(adRequest);
                return;
            }
            j();
        }
    }

    @VisibleForTesting
    public final synchronized void b(@NonNull final ds dsVar) {
        this.i.execute(new Runnable() { // from class: com.yandex.mobile.ads.impl.ab.6
            @Override // java.lang.Runnable
            public final void run() {
                if (!ab.this.a_()) {
                    String a3 = dsVar.a(ab.this.f);
                    if (!TextUtils.isEmpty(a3)) {
                        ab.this.f.a(dsVar.a());
                        ds dsVar2 = dsVar;
                        ab abVar = ab.this;
                        Context context = abVar.b;
                        fo foVar = abVar.f;
                        fq unused = abVar.n;
                        bx<T> a4 = ab.this.a(a3, dsVar2.a(context, foVar));
                        a4.a(dt.a(this));
                        ab.this.c.a(a4);
                        return;
                    }
                    ab.this.onAdFailedToLoad(v.o);
                }
            }
        });
    }

    public final synchronized void c(@NonNull int i2) {
        this.p = i2;
    }

    @VisibleForTesting
    private synchronized boolean b() {
        return this.p != u.c;
    }

    public void c(@NonNull ds dsVar) {
        a(this.f.c(), dsVar);
    }

    public final void b(@Nullable am amVar) {
        this.f.a(amVar);
    }

    public static /* synthetic */ void c(ab abVar, final ds dsVar) {
        abVar.i.execute(new Runnable() { // from class: com.yandex.mobile.ads.impl.ab.4
            @Override // java.lang.Runnable
            public final void run() {
                ab abVar2 = ab.this;
                aj ajVar = abVar2.e;
                fq unused = abVar2.n;
                ajVar.a(new aj.a() { // from class: com.yandex.mobile.ads.impl.ab.4.1
                    @Override // com.yandex.mobile.ads.impl.aj.a
                    public final void a() {
                        AnonymousClass4 r0 = AnonymousClass4.this;
                        ab.this.a(dsVar);
                    }

                    @Override // com.yandex.mobile.ads.impl.aj.a
                    public final void a(@NonNull sl slVar) {
                        ab.this.b(slVar);
                    }
                });
            }
        });
    }

    public final synchronized void b(String str) {
        if (this.g != null) {
            this.m.a(str, this.g, new dl(this.b, this.f.k(), this.d));
        }
    }

    public final synchronized void a(@Nullable final AdRequest adRequest, @NonNull final ds dsVar) {
        this.a.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.ab.1
            @Override // java.lang.Runnable
            public final void run() {
                ab.this.c(adRequest);
                if (ab.this.o()) {
                    ab.this.c(u.c);
                    ab.a(ab.this, dsVar);
                }
            }
        });
    }

    @VisibleForTesting
    public final void a(@NonNull final ds dsVar) {
        this.i.execute(new Runnable() { // from class: com.yandex.mobile.ads.impl.ab.5
            @Override // java.lang.Runnable
            public final void run() {
                fu fuVar = ab.this.o;
                ab abVar = ab.this;
                fuVar.a(abVar.b, abVar.u, new fx() { // from class: com.yandex.mobile.ads.impl.ab.5.1
                    @Override // com.yandex.mobile.ads.impl.fx
                    public final void a(@Nullable String str) {
                        ab.this.f.f(str);
                        AnonymousClass5 r2 = AnonymousClass5.this;
                        ab.this.b(dsVar);
                    }
                });
            }
        });
    }

    public synchronized boolean d(AdRequest adRequest) {
        if (this.g == null || this.r <= 0 || SystemClock.elapsedRealtime() - this.r > ((long) this.g.v()) || ((adRequest != null && !adRequest.equals(this.f.c())) || a())) {
            return true;
        }
        return false;
    }

    private synchronized boolean a() {
        return this.p == u.e;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void b(@NonNull sl slVar) {
        if (slVar instanceof r) {
            onAdFailedToLoad(s.a(((r) slVar).a()));
        }
    }

    public void a(@Nullable AdEventListener adEventListener) {
        this.s = adEventListener;
    }

    @Override // com.yandex.mobile.ads.impl.y.a
    public void a(int i2, @Nullable Bundle bundle) {
        if (i2 == 6) {
            onAdOpened();
        } else if (i2 == 7) {
            onAdLeftApplication();
        } else if (i2 == 8) {
            onAdClosed();
        }
    }

    public static /* synthetic */ void b(ab abVar, final ds dsVar) {
        abVar.h.a(abVar.b, new gz() { // from class: com.yandex.mobile.ads.impl.ab.3
            @Override // com.yandex.mobile.ads.impl.gz
            public final void a(@Nullable gs gsVar) {
                if (gsVar != null) {
                    ab.this.f.a(gsVar.a());
                    ab.this.f.b(gsVar.b());
                }
                ab.c(ab.this, dsVar);
            }
        });
    }

    @Override // com.yandex.mobile.ads.impl.ah.b
    public void a(@NonNull Intent intent) {
        intent.getAction();
    }

    public synchronized void a(@NonNull x<T> xVar) {
        this.g = xVar;
    }

    @Override // com.yandex.mobile.ads.impl.sa.a
    public final void a(@NonNull sl slVar) {
        b(slVar);
    }

    public synchronized void a(@NonNull AdRequestError adRequestError) {
        AdEventListener adEventListener = this.s;
        if (adEventListener != null) {
            adEventListener.onAdFailedToLoad(adRequestError);
        }
    }

    public static /* synthetic */ void a(ab abVar, final ds dsVar) {
        abVar.l.a(abVar.t, new gn.a() { // from class: com.yandex.mobile.ads.impl.ab.2
            @Override // com.yandex.mobile.ads.impl.gn.a
            public final void a() {
                ab.b(ab.this, dsVar);
            }

            @Override // com.yandex.mobile.ads.impl.gn.a
            public final void a(@NonNull String str) {
                ab.this.onAdFailedToLoad(v.a(str));
            }
        });
    }
}

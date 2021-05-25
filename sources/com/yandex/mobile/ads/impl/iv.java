package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.webkit.WebView;
import com.yandex.mobile.ads.b;
import com.yandex.mobile.ads.impl.an;
import com.yandex.mobile.ads.impl.at;
import java.util.List;
import java.util.Map;
public abstract class iv extends it implements at.a {
    @NonNull
    private final ay h;
    @NonNull
    private final ck i;
    @NonNull
    private final at j;
    @Nullable
    private cn k;
    @NonNull
    private final dj l = new dj(this.b, s());
    @NonNull
    private final jn m;
    @NonNull
    private final t n;
    private final ba o;

    public iv(@NonNull Context context, @NonNull ck ckVar, @NonNull b bVar) {
        super(context, bVar);
        AnonymousClass1 r62 = new ba() { // from class: com.yandex.mobile.ads.impl.iv.1
            @Override // com.yandex.mobile.ads.impl.ba
            @NonNull
            public final an a(int i2) {
                an.a aVar;
                if (iv.this.y()) {
                    aVar = an.a.APPLICATION_INACTIVE;
                } else if (!iv.this.l()) {
                    aVar = an.a.AD_NOT_LOADED;
                } else if (iv.this.h()) {
                    aVar = an.a.SUPERVIEW_HIDDEN;
                } else if (!iv.this.a(i2) || !iv.this.b()) {
                    aVar = an.a.NOT_VISIBLE_FOR_PERCENT;
                } else {
                    aVar = an.a.SUCCESS;
                }
                return new an(aVar, new co());
            }
        };
        this.o = r62;
        this.i = ckVar;
        jn jnVar = new jn();
        this.m = jnVar;
        t tVar = new t(jnVar);
        this.n = tVar;
        cs csVar = new cs(context, s());
        at atVar = new at(this, csVar, tVar);
        this.j = atVar;
        ay a = az.a(this.b, s(), csVar, r62, dt.a(this));
        this.h = a;
        a.a(atVar);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean h() {
        return !a();
    }

    public final synchronized void D() {
        this.h.a();
        cn cnVar = this.k;
        if (cnVar != null) {
            cnVar.b();
        }
    }

    public final boolean E() {
        return h() || y();
    }

    @NonNull
    public abstract ja a(@NonNull String str, @NonNull x<String> xVar, @NonNull am amVar, @NonNull at atVar);

    public abstract boolean a(int i2);

    public abstract boolean b();

    @Override // com.yandex.mobile.ads.impl.it, com.yandex.mobile.ads.impl.ab
    public void d() {
        super.d();
        this.h.b();
        cn cnVar = this.k;
        if (cnVar != null) {
            cnVar.c();
        }
    }

    @Override // com.yandex.mobile.ads.impl.ab
    public void e() {
        super.e();
        this.l.e();
    }

    @Override // com.yandex.mobile.ads.impl.ab, com.yandex.mobile.ads.AdEventListener
    public void onAdClosed() {
        super.onAdClosed();
        this.l.b();
    }

    @Override // com.yandex.mobile.ads.impl.ab, com.yandex.mobile.ads.AdEventListener
    public synchronized void onAdLeftApplication() {
        super.onAdLeftApplication();
        this.l.c();
    }

    @Override // com.yandex.mobile.ads.impl.ab, com.yandex.mobile.ads.AdEventListener
    public void onAdOpened() {
        super.onAdOpened();
        this.l.a();
    }

    @Override // com.yandex.mobile.ads.impl.it
    public final void b(@NonNull x<String> xVar) {
        if (a(xVar.e())) {
            super.b(xVar);
        } else {
            onAdFailedToLoad(v.e);
        }
    }

    @Override // com.yandex.mobile.ads.impl.ab, com.yandex.mobile.ads.impl.ah.b
    public void a(@NonNull Intent intent) {
        intent.getAction();
        a();
        this.h.a(intent, a());
    }

    public void b(int i2) {
        fz a = fy.a().a(this.b);
        if (a != null && a.p()) {
            if (i2 == 0) {
                this.h.a();
            } else {
                this.h.b();
            }
        } else if (a()) {
            this.h.a();
        } else {
            this.h.b();
        }
        getClass().toString();
    }

    @Override // com.yandex.mobile.ads.impl.it
    public final ja a(@NonNull String str, @NonNull x<String> xVar, @NonNull am amVar) {
        return a(str, xVar, amVar, this.j);
    }

    @Override // com.yandex.mobile.ads.impl.ab
    public synchronized void a(@NonNull x<String> xVar) {
        super.a((x) xVar);
        this.k = new cn(this.b, this.i, xVar, this.f, this.n, xVar.g());
    }

    @Override // com.yandex.mobile.ads.impl.ab, com.yandex.mobile.ads.impl.y.a
    public void a(int i2, @Nullable Bundle bundle) {
        if (i2 == 9) {
            this.l.d();
            this.h.c();
        } else if (i2 == 14) {
            this.j.b();
        } else if (i2 != 15) {
            super.a(i2, bundle);
        } else {
            this.j.d_();
        }
    }

    @Override // com.yandex.mobile.ads.impl.er
    public void a(@Nullable WebView webView, @Nullable Map<String, String> map) {
        this.m.a(this.g);
        x<T> xVar = this.g;
        if (xVar != null) {
            List<bo> a = dt.a(xVar, map);
            this.j.a(this.g, a);
            this.h.a(this.g, a);
        }
        dj djVar = this.l;
        x<T> xVar2 = this.g;
        djVar.a(xVar2 != null ? xVar2.h() : null);
        D();
    }

    @Override // com.yandex.mobile.ads.impl.er
    public final void a(@NonNull String str) {
        b(str);
    }

    private boolean a() {
        return this.i.a();
    }
}

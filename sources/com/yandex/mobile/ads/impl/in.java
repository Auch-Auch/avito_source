package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.webkit.WebView;
import com.yandex.mobile.ads.AdActivity;
import com.yandex.mobile.ads.AdRequest;
import com.yandex.mobile.ads.AdRequestError;
import com.yandex.mobile.ads.AdSize;
import com.yandex.mobile.ads.a;
import com.yandex.mobile.ads.b;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
public abstract class in extends iv {
    @NonNull
    private final im h;
    @NonNull
    private final ks i = new ks();
    @Nullable
    private kq j;
    @Nullable
    private kq k;
    @NonNull
    private final l l;

    public in(@NonNull Context context, @NonNull b bVar, @NonNull im imVar) {
        super(context, new il(), bVar);
        this.h = imVar;
        jx jxVar = new jx();
        this.l = jxVar;
        b(a.a(AdSize.FULL_SCREEN));
        m.a().a("window_type_interstitial", jxVar);
    }

    public final boolean A() {
        kq kqVar = this.j;
        return kqVar != null && kqVar.a();
    }

    public final void B() {
        this.h.h();
        kq kqVar = this.k;
        if (kqVar != this.j) {
            a(this.b, kqVar);
            this.k = this.j;
        }
    }

    public final void C() {
        v();
        this.h.b();
    }

    @NonNull
    public abstract kq a(@NonNull kr krVar);

    @Override // com.yandex.mobile.ads.impl.iv
    public final boolean a(int i2) {
        return true;
    }

    @Override // com.yandex.mobile.ads.impl.iv
    public final boolean b() {
        return true;
    }

    @Override // com.yandex.mobile.ads.impl.iv, com.yandex.mobile.ads.impl.it, com.yandex.mobile.ads.impl.ab
    public final synchronized void d() {
        super.d();
    }

    @Override // com.yandex.mobile.ads.impl.iv, com.yandex.mobile.ads.impl.ab
    public final void e() {
        a(this.b, this.k, this.j);
        super.e();
    }

    @Override // com.yandex.mobile.ads.impl.at.a
    public final void f() {
        this.h.c();
    }

    @Override // com.yandex.mobile.ads.impl.at.a
    public final void g() {
        this.h.d();
    }

    public final void h() {
        Context context = this.b;
        x<String> z = z();
        fo s = s();
        y yVar = this.d;
        if (context != null) {
            Intent intent = new Intent(context, AdActivity.class);
            intent.putExtra("window_type", "window_type_interstitial");
            intent.putExtra("extra_receiver", dt.a((ResultReceiver) yVar));
            intent.putExtra("extra_interstitial_isShouldOpenLinksInApp", s.k());
            intent.addFlags(268435456);
            jv a = jv.a();
            a.a(z);
            a.a(s);
            try {
                context.startActivity(intent);
            } catch (Exception e) {
                ij.c("Failed to show Interstitial Ad. Exception: ".concat(String.valueOf(e)), new Object[0]);
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.ab
    public final void j() {
        this.h.f();
    }

    @Override // com.yandex.mobile.ads.impl.iv, com.yandex.mobile.ads.impl.ab, com.yandex.mobile.ads.AdEventListener
    public void onAdClosed() {
        super.onAdClosed();
        this.h.a();
    }

    @Override // com.yandex.mobile.ads.impl.ab, com.yandex.mobile.ads.AdEventListener
    public void onAdFailedToLoad(@NonNull AdRequestError adRequestError) {
        super.onAdFailedToLoad(adRequestError);
        v();
    }

    @Override // com.yandex.mobile.ads.impl.iv, com.yandex.mobile.ads.impl.ab, com.yandex.mobile.ads.AdEventListener
    public void onAdLeftApplication() {
        super.onAdLeftApplication();
        this.h.e();
    }

    @Override // com.yandex.mobile.ads.impl.iv, com.yandex.mobile.ads.impl.ab, com.yandex.mobile.ads.AdEventListener
    public void onAdOpened() {
        super.onAdOpened();
        this.h.g();
    }

    public void a() {
        if (this.j != null && !a_()) {
            this.j.b();
        }
    }

    @Override // com.yandex.mobile.ads.impl.ab
    public final void a(AdRequest adRequest) {
        u();
        super.a(adRequest);
    }

    @Override // com.yandex.mobile.ads.impl.it
    public final boolean a(@NonNull am amVar) {
        return amVar.b(this.b) > 0 && amVar.a(this.b) > 0;
    }

    @Override // com.yandex.mobile.ads.impl.iv, com.yandex.mobile.ads.impl.ab, com.yandex.mobile.ads.impl.y.a
    public void a(int i2, @Nullable Bundle bundle) {
        if (i2 == 0) {
            a((WebView) null, bundle != null ? (Map) bundle.getSerializable("extra_tracking_parameters") : null);
        } else if (i2 == 8) {
            onAdClosed();
        } else if (i2 == 2) {
            b(0);
        } else if (i2 == 3) {
            b(8);
        } else if (i2 == 4) {
            C();
        } else if (i2 == 5) {
        } else {
            if (i2 != 6) {
                super.a(i2, bundle);
            } else {
                onAdOpened();
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.iv
    @NonNull
    public final ja a(@NonNull String str, @NonNull x<String> xVar, @NonNull am amVar, @NonNull at atVar) {
        ip ipVar = new ip(this);
        io ioVar = new io(this.b, xVar);
        new jb();
        boolean a = jb.a(str);
        je.a();
        return je.a(a).a(ioVar, ipVar);
    }

    @Override // com.yandex.mobile.ads.impl.iv, com.yandex.mobile.ads.impl.er
    public final void a(@Nullable WebView webView, @Nullable Map<String, String> map) {
        B();
        super.a(webView, map);
    }

    private static void a(@NonNull Context context, @NonNull kq... kqVarArr) {
        Iterator it = new HashSet(Arrays.asList(kqVarArr)).iterator();
        while (it.hasNext()) {
            kq kqVar = (kq) it.next();
            if (kqVar != null) {
                kqVar.a(context);
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.ab
    public final void a(@NonNull AdRequestError adRequestError) {
        this.h.a(adRequestError);
    }

    @Override // com.yandex.mobile.ads.impl.iv, com.yandex.mobile.ads.impl.ab
    public void a(@NonNull x<String> xVar) {
        super.a(xVar);
        kq a = a(ks.a(xVar));
        this.j = a;
        a.a(this.b, xVar);
    }
}

package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.yandex.mobile.ads.AdRequestError;
import com.yandex.mobile.ads.impl.ir;
import java.io.Serializable;
import java.util.Map;
public final class jw implements er, eu, jk, jl, k {
    @NonNull
    private final RelativeLayout a;
    @NonNull
    private final dm b;
    @NonNull
    private final n c;
    @NonNull
    private final Context d;
    @NonNull
    private final Window e;
    @NonNull
    private final x<String> f;
    @NonNull
    private final String g;
    @NonNull
    private final dg h;
    @NonNull
    private final bl i;
    @NonNull
    private final iu j;
    @NonNull
    private final kk k;
    @NonNull
    private final iz l;

    public jw(@NonNull Context context, @NonNull RelativeLayout relativeLayout, @NonNull dm dmVar, @NonNull n nVar, @NonNull Window window, @NonNull ka kaVar) {
        this.d = context;
        this.a = relativeLayout;
        this.b = dmVar;
        this.c = nVar;
        this.e = window;
        x<String> a3 = kaVar.a();
        this.f = a3;
        String c2 = kaVar.c();
        this.g = c2;
        fo b2 = kaVar.b();
        this.h = new dg(context, b2);
        this.i = new bl(b2);
        kb kbVar = new kb(context, a3);
        this.j = kbVar;
        new jb();
        boolean a4 = jb.a(c2);
        je.a();
        final iz a5 = je.a(a4).a(kbVar, this, this, this, this);
        this.l = a5;
        boolean y = a3.y();
        View a6 = ir.g.a(context);
        a6.setOnClickListener(new View.OnClickListener() { // from class: com.yandex.mobile.ads.impl.jw.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                a5.a();
                jw.this.h();
            }
        });
        new kl(new ke());
        this.k = kl.a(a3, a6, a4, y);
    }

    @Override // com.yandex.mobile.ads.impl.k
    public final void a() {
        this.e.requestFeature(1);
        this.e.addFlags(1024);
        if (id.a(11)) {
            this.e.addFlags(16777216);
        }
        this.k.a(this.d, this.c, this.f.e());
    }

    @Override // com.yandex.mobile.ads.impl.jk
    public final void b() {
        this.c.a(14, null);
    }

    @Override // com.yandex.mobile.ads.impl.er
    public final void b(boolean z) {
    }

    @Override // com.yandex.mobile.ads.impl.k
    public final boolean c() {
        return !this.k.c();
    }

    @Override // com.yandex.mobile.ads.impl.k
    public final void c_() {
        this.l.a(this.g);
        this.k.a(this.a);
        this.j.setId(2);
        this.a.addView(this.k.a(this.j, this.f));
        this.c.a(5, null);
    }

    @Override // com.yandex.mobile.ads.impl.k
    public final void d() {
        this.c.a(4, null);
    }

    @Override // com.yandex.mobile.ads.impl.jk
    public final void d_() {
        this.c.a(15, null);
    }

    @Override // com.yandex.mobile.ads.impl.k
    public final void e() {
        this.j.f();
        this.c.a(2, null);
    }

    @Override // com.yandex.mobile.ads.impl.k
    public final void f() {
        this.j.e();
        this.c.a(3, null);
    }

    @Override // com.yandex.mobile.ads.impl.k
    public final void g() {
        this.j.g();
        this.l.b();
        this.k.b();
    }

    @Override // com.yandex.mobile.ads.impl.eu
    public final void h() {
        this.c.a();
    }

    @Override // com.yandex.mobile.ads.impl.jl
    public final void i() {
        this.i.c(this.d, this.f);
        this.c.a(13, null);
    }

    @Override // com.yandex.mobile.ads.impl.er
    public final void onAdFailedToLoad(@NonNull AdRequestError adRequestError) {
    }

    @Override // com.yandex.mobile.ads.impl.er
    public final void onAdLoaded() {
    }

    @Override // com.yandex.mobile.ads.impl.eu
    public final void a(boolean z) {
        this.k.a(z);
    }

    @Override // com.yandex.mobile.ads.impl.er
    public final void a(@Nullable WebView webView, @Nullable Map<String, String> map) {
        this.k.a();
        Bundle bundle = new Bundle();
        bundle.putSerializable("extra_tracking_parameters", (Serializable) map);
        this.c.a(0, bundle);
    }

    @Override // com.yandex.mobile.ads.impl.er
    public final void a(@NonNull String str) {
        this.h.a(str, this.f, this.b);
    }
}

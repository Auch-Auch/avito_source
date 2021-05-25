package com.yandex.mobile.ads.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.yandex.mobile.ads.impl.iu;
@SuppressLint({"ViewConstructor"})
public final class d extends iu {
    @VisibleForTesting
    public final int a;
    @VisibleForTesting
    public int b;
    @NonNull
    private final am g;
    @Nullable
    private am h;
    private boolean i = true;

    public d(@NonNull Context context, @NonNull x xVar, @NonNull am amVar) {
        super(context, xVar);
        this.g = amVar;
        if (k()) {
            this.a = amVar.b(context);
            this.b = amVar.a(context);
        } else {
            this.a = xVar.q() == 0 ? amVar.b(context) : xVar.q();
            this.b = xVar.r();
        }
        a(this.a, this.b);
    }

    @VisibleForTesting
    private boolean k() {
        Context context = getContext();
        return i() && ((iu) this).f.q() == 0 && ((iu) this).f.r() == 0 && this.g.b(context) > 0 && this.g.a(context) > 0;
    }

    @Override // com.yandex.mobile.ads.impl.ev
    public final void a() {
        if (this.i) {
            a(this.a, this.b);
            boolean a3 = ju.a(getContext(), this.h, this.g);
            er erVar = this.e;
            if (erVar != null && a3) {
                erVar.a(this, j());
            }
            er erVar2 = this.e;
            if (erVar2 != null) {
                if (a3) {
                    erVar2.onAdLoaded();
                } else {
                    erVar2.onAdFailedToLoad(v.c);
                }
            }
            this.i = false;
        }
    }

    @Override // com.yandex.mobile.ads.impl.iu, com.yandex.mobile.ads.impl.ev, com.yandex.mobile.ads.impl.ac
    public final String b() {
        StringBuilder sb = new StringBuilder();
        String str = "";
        sb.append(((iu) this).f.w() ? ew.a(this.a) : str);
        Context context = getContext();
        int b2 = this.g.b(context);
        int a3 = this.g.a(context);
        if (k()) {
            str = ew.a(b2, a3);
        }
        sb.append(str);
        sb.append(super.b());
        return sb.toString();
    }

    @Nullable
    public final am c() {
        return this.h;
    }

    private void a(int i2, int i3) {
        this.h = new am(i2, i3, this.g.c());
    }

    @Override // com.yandex.mobile.ads.impl.iu
    @SuppressLint({"AddJavascriptInterface"})
    public final void a(@NonNull Context context) {
        addJavascriptInterface(new iu.a(context), "AdPerformActionsJSI");
    }

    @Override // com.yandex.mobile.ads.impl.iu
    public final void a(int i2, String str) {
        if (((iu) this).f.r() != 0) {
            i2 = ((iu) this).f.r();
        }
        this.b = i2;
        super.a(i2, str);
    }
}

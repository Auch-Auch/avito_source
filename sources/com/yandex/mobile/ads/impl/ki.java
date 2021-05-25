package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.RelativeLayout;
import com.yandex.mobile.ads.impl.ir;
public final class ki implements kk {
    @NonNull
    private final kd a;
    @NonNull
    private final RelativeLayout b;
    @NonNull
    private final ir.f c;

    public ki(@NonNull Context context, @NonNull kd kdVar) {
        this.a = kdVar;
        this.b = ir.c.a(context);
        this.c = new ir.f(context);
    }

    @Override // com.yandex.mobile.ads.impl.kk
    public final void a(@NonNull RelativeLayout relativeLayout) {
        relativeLayout.setBackground(ir.b.a);
    }

    @Override // com.yandex.mobile.ads.impl.kk
    public final void b() {
        this.a.c();
    }

    @Override // com.yandex.mobile.ads.impl.kk
    public final boolean c() {
        return this.a.d();
    }

    @Override // com.yandex.mobile.ads.impl.kk
    public final void a(@NonNull Context context, @NonNull n nVar, @NonNull am amVar) {
        int i = context.getResources().getConfiguration().orientation;
        boolean a3 = ju.a(context, amVar);
        boolean b2 = ju.b(context, amVar);
        int i2 = 1;
        if (a3 == b2) {
            i2 = -1;
        } else if (!b2 ? 1 != i : 1 == i) {
            i2 = 0;
        }
        if (-1 != i2) {
            nVar.a(i2);
        }
    }

    @Override // com.yandex.mobile.ads.impl.kk
    @NonNull
    public final View a(@NonNull View view, @NonNull x xVar) {
        Context context = view.getContext();
        RelativeLayout.LayoutParams a3 = ir.d.a(context, xVar);
        this.b.addView(view, a3);
        RelativeLayout.LayoutParams a4 = ir.d.a(context, view);
        this.b.addView(this.a.a(), a4);
        RelativeLayout.LayoutParams b2 = ir.d.b(context, xVar);
        RelativeLayout b3 = ir.c.b(context);
        this.c.setBackFace(this.b, b2);
        this.c.setFrontFace(b3, a3);
        this.c.setLayoutParams(ir.d.a(context, (x) null));
        return this.c;
    }

    @Override // com.yandex.mobile.ads.impl.kk
    public final void a() {
        this.a.b();
        iq.a(this.c, eg.b(this.b));
    }

    @Override // com.yandex.mobile.ads.impl.kk
    public final void a(boolean z) {
        this.a.a(z);
    }
}

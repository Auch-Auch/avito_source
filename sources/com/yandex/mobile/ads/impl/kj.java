package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.RelativeLayout;
import com.yandex.mobile.ads.impl.ir;
public final class kj implements kk {
    @NonNull
    private final kd a;

    public kj(@NonNull kd kdVar) {
        this.a = kdVar;
    }

    @Override // com.yandex.mobile.ads.impl.kk
    public final void a(@NonNull Context context, @NonNull n nVar, @NonNull am amVar) {
    }

    @Override // com.yandex.mobile.ads.impl.kk
    public final void a(@NonNull RelativeLayout relativeLayout) {
        relativeLayout.setBackground(ir.b.b);
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
    @NonNull
    public final View a(@NonNull View view, @NonNull x<String> xVar) {
        Context context = view.getContext();
        RelativeLayout.LayoutParams a3 = ir.d.a();
        RelativeLayout a4 = ir.c.a(context);
        a4.setLayoutParams(a3);
        a4.addView(view, ir.d.a());
        a4.addView(this.a.a(), ir.d.a(context, view));
        return a4;
    }

    @Override // com.yandex.mobile.ads.impl.kk
    public final void a() {
        this.a.b();
    }

    @Override // com.yandex.mobile.ads.impl.kk
    public final void a(boolean z) {
        this.a.a(z);
    }
}

package com.yandex.mobile.ads.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import com.yandex.mobile.ads.impl.el;
@SuppressLint({"ViewConstructor"})
public final class es extends ev {
    @NonNull
    private final et a;
    @NonNull
    private el b = new en();

    public es(@NonNull Context context, @NonNull at atVar) {
        super(context);
        this.a = new et(this, atVar);
    }

    @Override // com.yandex.mobile.ads.impl.ev
    public final void a() {
        this.a.a();
    }

    public final void c(@NonNull String str) {
        this.a.b(str);
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        el.a a3 = this.b.a(i, i2);
        super.onMeasure(a3.a, a3.b);
    }

    public final void setAspectRatio(float f) {
        this.b = new em(f);
    }

    public final void setClickListener(@NonNull nb nbVar) {
        this.a.a(nbVar);
    }
}

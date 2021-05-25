package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.view.View;
import com.yandex.mobile.ads.impl.el;
public final class ek implements el {
    @NonNull
    private final el.a a = new el.a();

    @Override // com.yandex.mobile.ads.impl.el
    @NonNull
    public final el.a a(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
        el.a aVar = this.a;
        aVar.a = makeMeasureSpec;
        aVar.b = makeMeasureSpec;
        return aVar;
    }
}

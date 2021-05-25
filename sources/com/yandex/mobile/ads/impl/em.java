package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import android.view.View;
import com.yandex.mobile.ads.impl.el;
public final class em implements el {
    @NonNull
    private final el.a a = new el.a();
    @NonNull
    private final aa b;

    public em(float f) {
        this.b = new aa(f);
    }

    private static boolean a(int i) {
        return i == Integer.MIN_VALUE || i == 0;
    }

    private static int b(int i, int i2, int i3) {
        return i3 == Integer.MIN_VALUE ? Math.min(i2, i) : i;
    }

    @Override // com.yandex.mobile.ads.impl.el
    @NonNull
    public final el.a a(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824 && a(mode2)) {
            i2 = a(this.b.b(size), size2, mode2);
        } else if (mode2 == 1073741824 && a(mode)) {
            i = a(this.b.a(size2), size, mode);
        }
        el.a aVar = this.a;
        aVar.a = i;
        aVar.b = i2;
        return aVar;
    }

    private static int a(int i, int i2, int i3) {
        return View.MeasureSpec.makeMeasureSpec(b(i, i2, i3), 1073741824);
    }
}

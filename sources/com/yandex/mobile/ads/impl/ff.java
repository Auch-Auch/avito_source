package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.view.View;
import com.yandex.mobile.ads.impl.iw;
public final class ff {
    @NonNull
    private final iw a = new iw();

    @NonNull
    public static <T extends View & iw.a> fi a(@NonNull T t) {
        int i;
        RectF rectF = null;
        if (iw.a(t)) {
            i = eg.e(t);
            Rect rect = new Rect();
            if (t.getLocalVisibleRect(rect)) {
                rect.offset(t.getLeft(), t.getTop());
            } else {
                rect = null;
            }
            Context context = t.getContext();
            if (rect != null) {
                int a3 = eg.a(context, rect.left);
                int a4 = eg.a(context, rect.top);
                int a5 = eg.a(context, rect.right);
                int a6 = eg.a(context, rect.bottom);
                int i2 = a6 - a4;
                if (a5 - a3 > 0 && i2 > 0) {
                    rectF = new RectF((float) a3, (float) a4, (float) a5, (float) a6);
                }
            }
        } else {
            i = 0;
        }
        return new fi(i, rectF);
    }
}

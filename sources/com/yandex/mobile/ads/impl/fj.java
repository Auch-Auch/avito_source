package com.yandex.mobile.ads.impl;

import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public final class fj implements fk {
    @Nullable
    private final RectF a;
    private final int b;

    public fj(int i, @Nullable RectF rectF) {
        this.b = i;
        this.a = rectF;
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0041: APUT  (r1v0 java.lang.Object[]), (1 ??[boolean, int, float, short, byte, char]), (r0v1 java.lang.String) */
    @Override // com.yandex.mobile.ads.impl.fk
    @NonNull
    public final String a() {
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(this.b);
        RectF rectF = this.a;
        objArr[1] = rectF != null ? String.format("{x:%s,y:%s,width:%s,height:%s}", Float.valueOf(rectF.left), Float.valueOf(rectF.top), Float.valueOf(rectF.width()), Float.valueOf(rectF.height())) : null;
        return String.format("exposure:{exposedPercentage:%s,visibleRectangle:%s,occlusionRectangles:[]}", objArr);
    }
}

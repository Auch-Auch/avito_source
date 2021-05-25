package com.yandex.mobile.ads.impl;

import android.graphics.RectF;
import android.support.annotation.Nullable;
public final class fi {
    @Nullable
    private final RectF a;
    private final int b;

    public fi(int i, @Nullable RectF rectF) {
        this.b = i;
        this.a = rectF;
    }

    public final int a() {
        return this.b;
    }

    @Nullable
    public final RectF b() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && fi.class == obj.getClass()) {
            fi fiVar = (fi) obj;
            if (this.b != fiVar.b) {
                return false;
            }
            RectF rectF = this.a;
            RectF rectF2 = fiVar.a;
            if (rectF != null) {
                return rectF.equals(rectF2);
            }
            if (rectF2 == null) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        RectF rectF = this.a;
        return ((rectF != null ? rectF.hashCode() : 0) * 31) + this.b;
    }
}

package com.yandex.mobile.ads.impl;

import android.support.annotation.Nullable;
public final class ov {
    @Nullable
    private final String a;
    private final float b;

    public ov(@Nullable String str, float f) {
        this.a = str;
        this.b = f;
    }

    @Nullable
    public final String a() {
        return this.a;
    }

    public final float b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ov.class != obj.getClass()) {
            return false;
        }
        ov ovVar = (ov) obj;
        if (Float.compare(ovVar.b, this.b) != 0) {
            return false;
        }
        return this.a.equals(ovVar.a);
    }

    public final int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        float f = this.b;
        return hashCode + (f != 0.0f ? Float.floatToIntBits(f) : 0);
    }
}

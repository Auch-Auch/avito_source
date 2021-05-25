package com.yandex.mobile.ads.impl;

import android.support.annotation.Nullable;
public final class ow {
    @Nullable
    private final ov a;
    @Nullable
    private final ot b;

    public ow(@Nullable ov ovVar, @Nullable ot otVar) {
        this.a = ovVar;
        this.b = otVar;
    }

    @Nullable
    public final ov a() {
        return this.a;
    }

    @Nullable
    public final ot b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ow)) {
            return false;
        }
        ow owVar = (ow) obj;
        ov ovVar = this.a;
        if (ovVar == null ? owVar.a != null : !ovVar.equals(owVar.a)) {
            return false;
        }
        ot otVar = this.b;
        ot otVar2 = owVar.b;
        if (otVar != null) {
            return otVar.equals(otVar2);
        }
        return otVar2 == null;
    }

    public final int hashCode() {
        ov ovVar = this.a;
        int i = 0;
        int hashCode = (ovVar != null ? ovVar.hashCode() : 0) * 31;
        ot otVar = this.b;
        if (otVar != null) {
            i = otVar.hashCode();
        }
        return hashCode + i;
    }
}

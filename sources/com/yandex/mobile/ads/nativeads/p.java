package com.yandex.mobile.ads.nativeads;

import android.support.annotation.NonNull;
import com.yandex.mobile.ads.impl.fo;
import com.yandex.mobile.ads.impl.oy;
import com.yandex.mobile.ads.impl.x;
public final class p {
    private final x a;
    private final fo b;
    private final oy c;

    public p(@NonNull oy oyVar, @NonNull x xVar, @NonNull fo foVar) {
        this.a = xVar;
        this.b = foVar;
        this.c = oyVar;
    }

    @NonNull
    public final fo a() {
        return this.b;
    }

    @NonNull
    public final x b() {
        return this.a;
    }

    @NonNull
    public final oy c() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && p.class == obj.getClass()) {
            p pVar = (p) obj;
            x xVar = this.a;
            if (xVar == null ? pVar.a != null : !xVar.equals(pVar.a)) {
                return false;
            }
            fo foVar = this.b;
            if (foVar == null ? pVar.b != null : !foVar.equals(pVar.b)) {
                return false;
            }
            oy oyVar = this.c;
            if (oyVar != null) {
                return oyVar.equals(pVar.c);
            }
            if (pVar.c == null) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        x xVar = this.a;
        int i = 0;
        int hashCode = (xVar != null ? xVar.hashCode() : 0) * 31;
        fo foVar = this.b;
        int hashCode2 = (hashCode + (foVar != null ? foVar.hashCode() : 0)) * 31;
        oy oyVar = this.c;
        if (oyVar != null) {
            i = oyVar.hashCode();
        }
        return hashCode2 + i;
    }
}

package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import java.util.List;
public final class pg {
    @NonNull
    private final List<ph> a;

    public pg(@NonNull List<ph> list) {
        this.a = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || pg.class != obj.getClass()) {
            return false;
        }
        return this.a.equals(((pg) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }
}

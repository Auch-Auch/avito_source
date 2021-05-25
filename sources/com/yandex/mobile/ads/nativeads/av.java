package com.yandex.mobile.ads.nativeads;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.or;
public final class av {
    @Nullable
    private final String a;
    @NonNull
    private final a b;

    public enum a {
        TEXT,
        IMAGE
    }

    public av(@NonNull or orVar) {
        this.a = orVar.a();
        this.b = orVar.b();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && av.class == obj.getClass()) {
            av avVar = (av) obj;
            String str = this.a;
            if (str == null ? avVar.a != null : !str.equals(avVar.a)) {
                return false;
            }
            if (this.b == avVar.b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.a;
        return this.b.hashCode() + ((str != null ? str.hashCode() : 0) * 31);
    }
}

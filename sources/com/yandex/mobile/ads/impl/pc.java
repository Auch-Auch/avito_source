package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import java.util.List;
public final class pc extends pa {
    @NonNull
    private final List<a> a;

    public static class a {
        @NonNull
        private final String a;
        @NonNull
        private final String b;

        public a(@NonNull String str, @NonNull String str2) {
            this.a = str;
            this.b = str2;
        }

        @NonNull
        public final String a() {
            return this.a;
        }

        @NonNull
        public final String b() {
            return this.b;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (!this.a.equals(aVar.a)) {
                return false;
            }
            return this.b.equals(aVar.b);
        }

        public final int hashCode() {
            return this.b.hashCode() + (this.a.hashCode() * 31);
        }
    }

    public pc(@NonNull String str, @NonNull List<a> list) {
        super(str);
        this.a = list;
    }

    @NonNull
    public final List<a> b() {
        return this.a;
    }

    @Override // com.yandex.mobile.ads.impl.pa
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || pc.class != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        return this.a.equals(((pc) obj).a);
    }

    @Override // com.yandex.mobile.ads.impl.pa
    public final int hashCode() {
        return this.a.hashCode() + (super.hashCode() * 31);
    }
}

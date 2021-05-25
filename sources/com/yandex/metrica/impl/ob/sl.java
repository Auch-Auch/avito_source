package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
public class sl implements sm {
    @NonNull
    private final sm a;
    @NonNull
    private final sm b;

    public static class a {
        @NonNull
        private sm a;
        @NonNull
        private sm b;

        private a() {
        }

        public a a(@NonNull yb ybVar) {
            this.b = new sv(ybVar.B);
            return this;
        }

        public a(@NonNull sm smVar, @NonNull sm smVar2) {
            this.a = smVar;
            this.b = smVar2;
        }

        public a a(boolean z) {
            this.a = new sn(z);
            return this;
        }

        public sl a() {
            return new sl(this.a, this.b);
        }
    }

    @VisibleForTesting
    public sl(@NonNull sm smVar, @NonNull sm smVar2) {
        this.a = smVar;
        this.b = smVar2;
    }

    public static a b() {
        return new a(new sn(false), new sv(null));
    }

    @Override // com.yandex.metrica.impl.ob.sm
    public boolean a(@NonNull String str) {
        return this.b.a(str) && this.a.a(str);
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("AskForPermissionsStrategy{mLocationFlagStrategy=");
        L.append(this.a);
        L.append(", mStartupStateStrategy=");
        L.append(this.b);
        L.append('}');
        return L.toString();
    }

    public a a() {
        return new a(this.a, this.b);
    }
}

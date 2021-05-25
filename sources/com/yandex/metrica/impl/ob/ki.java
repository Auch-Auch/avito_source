package com.yandex.metrica.impl.ob;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
public class ki {
    @NonNull
    private final act a;

    public static class a implements Runnable {
        @NonNull
        private final kp a;
        @Nullable
        private final Bundle b;
        @Nullable
        private final kn c;

        public a(@NonNull kp kpVar, @Nullable Bundle bundle) {
            this(kpVar, bundle, null);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.a.a(this.b, this.c);
            } catch (Throwable unused) {
                kn knVar = this.c;
                if (knVar != null) {
                    knVar.a();
                }
            }
        }

        public a(@NonNull kp kpVar, @Nullable Bundle bundle, @Nullable kn knVar) {
            this.a = kpVar;
            this.b = bundle;
            this.c = knVar;
        }
    }

    public ki() {
        this(as.a().k().f());
    }

    public void a(@NonNull kp kpVar, @Nullable Bundle bundle) {
        this.a.a(new a(kpVar, bundle));
    }

    @VisibleForTesting
    public ki(@NonNull act act) {
        this.a = act;
    }

    public void a(@NonNull kp kpVar, @Nullable Bundle bundle, @Nullable kn knVar) {
        this.a.a(new a(kpVar, bundle, knVar));
    }

    @NonNull
    public act a() {
        return this.a;
    }
}

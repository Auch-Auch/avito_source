package com.yandex.metrica.impl.ob;

import android.support.annotation.Nullable;
import java.util.concurrent.TimeUnit;
public interface r {

    public static class a<T> {
        public static final long a = TimeUnit.SECONDS.toMillis(10);
        private long b;
        private long c;
        @Nullable
        private T d;

        public a() {
            this(a);
        }

        private void d() {
            this.c = System.currentTimeMillis();
        }

        @Nullable
        public T a() {
            return this.d;
        }

        public final boolean b() {
            return this.d == null;
        }

        public final boolean c() {
            return a(this.b);
        }

        public a(long j) {
            this.c = 0;
            this.d = null;
            this.b = j;
        }

        public void a(T t) {
            this.d = t;
            d();
        }

        public final boolean a(long j) {
            long currentTimeMillis = System.currentTimeMillis() - this.c;
            return currentTimeMillis > j || currentTimeMillis < 0;
        }
    }
}

package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.impl.ob.h;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class ao {
    @NonNull
    private final List<c> a = new ArrayList();

    public static class a {
        private boolean a;
        private long b;
        private long c;
        private long d;
        @NonNull
        private b e;

        public a() {
            this(new b());
        }

        public boolean a() {
            if (this.a) {
                return true;
            }
            return this.e.a(this.c, this.b, this.d);
        }

        public void b() {
            this.a = true;
        }

        public a(@NonNull b bVar) {
            this.e = bVar;
            this.a = false;
            this.d = Long.MAX_VALUE;
        }

        public void a(long j, @NonNull TimeUnit timeUnit) {
            this.d = timeUnit.toMillis(j);
        }

        public void a(@Nullable yb ybVar) {
            if (ybVar != null) {
                TimeUnit timeUnit = TimeUnit.SECONDS;
                this.b = timeUnit.toMillis(ybVar.F);
                this.c = timeUnit.toMillis(ybVar.G);
            }
        }
    }

    public static class b {
        public boolean a(long j, long j2, long j3) {
            return j2 - j >= j3;
        }
    }

    public static class c {
        @NonNull
        private a a;
        @NonNull
        private final h.a b;
        @NonNull
        private final act c;

        public void a(@NonNull yb ybVar) {
            this.a.a(ybVar);
        }

        private c(@NonNull act act, @NonNull h.a aVar, @NonNull a aVar2) {
            this.b = aVar;
            this.a = aVar2;
            this.c = act;
        }

        public void a(long j) {
            this.a.a(j, TimeUnit.SECONDS);
        }

        public boolean a(int i) {
            if (!this.a.a()) {
                return false;
            }
            this.b.a(TimeUnit.SECONDS.toMillis((long) i), this.c);
            this.a.b();
            return true;
        }
    }

    public c a(@NonNull Runnable runnable, @NonNull act act) {
        return a(act, new h.a(runnable), new a());
    }

    @VisibleForTesting
    public c a(@NonNull act act, @NonNull h.a aVar, @NonNull a aVar2) {
        c cVar = new c(act, aVar, aVar2);
        this.a.add(cVar);
        return cVar;
    }

    public void a(@NonNull yb ybVar) {
        for (c cVar : this.a) {
            cVar.a(ybVar);
        }
    }
}

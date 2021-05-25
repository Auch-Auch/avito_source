package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import java.util.concurrent.TimeUnit;
public class h {
    public static final long a = TimeUnit.SECONDS.toMillis(10);
    private long b;
    @NonNull
    private final abs c;

    public static class a {
        private boolean a;
        @NonNull
        private final b b;
        @NonNull
        private final h c;

        public a(@NonNull Runnable runnable) {
            this(runnable, as.a().j());
        }

        @VisibleForTesting
        public a(@NonNull final Runnable runnable, @NonNull h hVar) {
            this.a = false;
            this.b = new b() { // from class: com.yandex.metrica.impl.ob.h.a.1
                @Override // com.yandex.metrica.impl.ob.h.b
                public void a() {
                    a.this.a = true;
                    runnable.run();
                }
            };
            this.c = hVar;
        }

        public void a(long j, @NonNull act act) {
            if (!this.a) {
                this.c.a(j, act, this.b);
            }
        }
    }

    public interface b {
        void a();
    }

    public h() {
        this(new abs());
    }

    public void a() {
        this.b = this.c.a();
    }

    @VisibleForTesting
    public h(@NonNull abs abs) {
        this.c = abs;
    }

    public void a(long j, @NonNull act act, @NonNull final b bVar) {
        act.a(new Runnable() { // from class: com.yandex.metrica.impl.ob.h.1
            @Override // java.lang.Runnable
            public void run() {
                bVar.a();
            }
        }, Math.max(j - (this.c.a() - this.b), 0L));
    }
}

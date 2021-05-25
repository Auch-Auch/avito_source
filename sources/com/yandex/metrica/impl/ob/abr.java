package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import java.util.concurrent.TimeUnit;
public class abr {
    @NonNull
    private final abs a;

    public abr() {
        this(new abs());
    }

    public long a(long j, @NonNull TimeUnit timeUnit) {
        return TimeUnit.MILLISECONDS.toSeconds(b(j, timeUnit));
    }

    public long b(long j, @NonNull TimeUnit timeUnit) {
        return this.a.c() - timeUnit.toMillis(j);
    }

    public long c(long j, @NonNull TimeUnit timeUnit) {
        return this.a.d() - timeUnit.toNanos(j);
    }

    public long d(long j, @NonNull TimeUnit timeUnit) {
        return TimeUnit.NANOSECONDS.toSeconds(c(j, timeUnit));
    }

    public long e(long j, @NonNull TimeUnit timeUnit) {
        return this.a.b() - timeUnit.toSeconds(j);
    }

    @VisibleForTesting
    public abr(@NonNull abs abs) {
        this.a = abs;
    }
}

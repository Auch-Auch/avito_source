package io.reactivex.schedulers;

import a2.b.a.a.a;
import io.reactivex.annotations.NonNull;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.TimeUnit;
public final class Timed<T> {
    public final T a;
    public final long b;
    public final TimeUnit c;

    public Timed(@NonNull T t, long j, @NonNull TimeUnit timeUnit) {
        this.a = t;
        this.b = j;
        this.c = (TimeUnit) ObjectHelper.requireNonNull(timeUnit, "unit is null");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Timed)) {
            return false;
        }
        Timed timed = (Timed) obj;
        if (!ObjectHelper.equals(this.a, timed.a) || this.b != timed.b || !ObjectHelper.equals(this.c, timed.c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        T t = this.a;
        int hashCode = t != null ? t.hashCode() : 0;
        long j = this.b;
        return this.c.hashCode() + (((hashCode * 31) + ((int) (j ^ (j >>> 31)))) * 31);
    }

    public long time() {
        return this.b;
    }

    public String toString() {
        StringBuilder L = a.L("Timed[time=");
        L.append(this.b);
        L.append(", unit=");
        L.append(this.c);
        L.append(", value=");
        return a.r(L, this.a, "]");
    }

    @NonNull
    public TimeUnit unit() {
        return this.c;
    }

    @NonNull
    public T value() {
        return this.a;
    }

    public long time(@NonNull TimeUnit timeUnit) {
        return timeUnit.convert(this.b, this.c);
    }
}

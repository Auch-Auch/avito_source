package io.reactivex.rxjava3.schedulers;

import a2.b.a.a.a;
import io.reactivex.rxjava3.annotations.NonNull;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
public final class Timed<T> {
    public final T a;
    public final long b;
    public final TimeUnit c;

    public Timed(@NonNull T t, long j, @NonNull TimeUnit timeUnit) {
        Objects.requireNonNull(t, "value is null");
        this.a = t;
        this.b = j;
        Objects.requireNonNull(timeUnit, "unit is null");
        this.c = timeUnit;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Timed)) {
            return false;
        }
        Timed timed = (Timed) obj;
        if (!Objects.equals(this.a, timed.a) || this.b != timed.b || !Objects.equals(this.c, timed.c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.b;
        return this.c.hashCode() + (((this.a.hashCode() * 31) + ((int) (j ^ (j >>> 31)))) * 31);
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

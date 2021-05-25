package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import java.util.Random;
public class abf {
    @NonNull
    private final Random a;

    public abf() {
        this(new Random());
    }

    public long a(long j, long j2) {
        if (j < j2) {
            long nextLong = this.a.nextLong();
            if (nextLong == Long.MIN_VALUE) {
                nextLong = 0;
            } else if (nextLong < 0) {
                nextLong = -nextLong;
            }
            return (nextLong % (j2 - j)) + j;
        }
        throw new IllegalArgumentException("min should be less than max");
    }

    public abf(@NonNull Random random) {
        this.a = random;
    }
}

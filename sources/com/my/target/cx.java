package com.my.target;

import androidx.annotation.NonNull;
public class cx extends cy {
    public float d = -1.0f;
    public float e = -1.0f;

    public cx(@NonNull String str) {
        super("playheadReachedValue", str);
    }

    @NonNull
    public static cx J(@NonNull String str) {
        return new cx(str);
    }

    public float cu() {
        return this.d;
    }

    public float cv() {
        return this.e;
    }

    public void l(float f) {
        this.d = f;
    }

    public void m(float f) {
        this.e = f;
    }

    public String toString() {
        return "ProgressStat{value=" + this.d + ", pvalue=" + this.e + '}';
    }
}

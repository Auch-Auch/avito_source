package com.my.target;

import androidx.annotation.NonNull;
public class bv extends cy {
    public int d;
    public int e;
    public int f = 1;

    public bv(@NonNull String str) {
        super("playheadTimerValue", str);
    }

    public static bv s(@NonNull String str) {
        return new bv(str);
    }

    public int bB() {
        return this.d;
    }

    public int bC() {
        return this.e;
    }

    public int bD() {
        return this.f;
    }

    public void o(int i) {
        this.d = i;
    }

    public void p(int i) {
        this.e = i;
    }

    public void q(int i) {
        this.f = i;
    }
}

package com.my.target;

import androidx.annotation.NonNull;
public class bw extends cv {
    public int i;
    public int j;

    public bw(@NonNull String str) {
        super("playheadViewabilityValue", str);
    }

    public static bw t(@NonNull String str) {
        return new bw(str);
    }

    public int bB() {
        return this.i;
    }

    public int bC() {
        return this.j;
    }

    public void o(int i2) {
        this.i = i2;
    }

    public void p(int i2) {
        this.j = i2;
    }
}

package com.my.target;

import androidx.annotation.NonNull;
public class bq {
    @NonNull
    public static final bq dI = new bq(4096);
    @NonNull
    public static final bq dJ = new bq(64);
    public final int a;
    public final boolean dK;
    public final boolean dL;
    public final boolean dM;
    public final boolean dN;
    public final boolean dO;
    public final boolean dP;
    public final boolean dQ;
    public final boolean dR;
    public final boolean dS;
    public final boolean dT;
    public final boolean dU;
    public final boolean dV;
    public final boolean dW;

    public bq(int i) {
        this.a = i;
        boolean z = false;
        this.dK = (i & 1) == 1;
        this.dL = (i & 2) == 2;
        this.dM = (i & 4) == 4;
        this.dN = (i & 8) == 8;
        this.dO = (i & 16) == 16;
        this.dP = (i & 32) == 32;
        this.dQ = (i & 64) == 64;
        this.dR = (i & 128) == 128;
        this.dS = (i & 256) == 256;
        this.dT = (i & 512) == 512;
        this.dU = (i & 1024) == 1024;
        this.dV = (i & 2048) == 2048;
        this.dW = (i & 4096) == 4096 ? true : z;
    }

    @NonNull
    public static bq h(int i) {
        return new bq(i);
    }

    public int bp() {
        return this.a;
    }
}

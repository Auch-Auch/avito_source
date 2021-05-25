package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
public final class zziw extends Exception {
    private final int errorCode;

    public zziw(int i) {
        super(a.m2(36, "AudioTrack write failed: ", i));
        this.errorCode = i;
    }
}

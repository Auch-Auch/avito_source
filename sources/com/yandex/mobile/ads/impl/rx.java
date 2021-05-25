package com.yandex.mobile.ads.impl;

import java.util.Map;
public final class rx {
    public final int a;
    public final byte[] b;
    public final Map<String, String> c;
    public final boolean d;
    public final long e;

    public rx(int i, byte[] bArr, Map<String, String> map, boolean z, long j) {
        this.a = i;
        this.b = bArr;
        this.c = map;
        this.d = z;
        this.e = j;
    }

    public rx(byte[] bArr, Map<String, String> map) {
        this(200, bArr, map, false, 0);
    }
}

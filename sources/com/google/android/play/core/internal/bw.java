package com.google.android.play.core.internal;

import java.io.IOException;
import java.io.InputStream;
public final class bw extends bv {
    public final bv a;
    public final long b;
    public final long c;

    public bw(bv bvVar, long j, long j2) {
        this.a = bvVar;
        long c2 = c(j);
        this.b = c2;
        this.c = c(c2 + j2);
    }

    @Override // com.google.android.play.core.internal.bv
    public final long a() {
        return this.c - this.b;
    }

    @Override // com.google.android.play.core.internal.bv
    public final InputStream a(long j, long j2) throws IOException {
        long c2 = c(this.b + j);
        return this.a.a(c2, c(j2 + c2) - c2);
    }

    public final long c(long j) {
        if (j >= 0) {
            return j > this.a.a() ? this.a.a() : j;
        }
        return 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
    }
}

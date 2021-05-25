package com.yandex.mobile.ads.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
public final class sv extends ByteArrayOutputStream {
    private final sn a;

    public sv(sn snVar, int i) {
        this.a = snVar;
        ((ByteArrayOutputStream) this).buf = snVar.a(Math.max(i, 256));
    }

    private void a(int i) {
        int i2 = ((ByteArrayOutputStream) this).count;
        if (i2 + i > ((ByteArrayOutputStream) this).buf.length) {
            byte[] a3 = this.a.a((i2 + i) * 2);
            System.arraycopy(((ByteArrayOutputStream) this).buf, 0, a3, 0, ((ByteArrayOutputStream) this).count);
            this.a.a(((ByteArrayOutputStream) this).buf);
            ((ByteArrayOutputStream) this).buf = a3;
        }
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.a.a(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = null;
        super.close();
    }

    @Override // java.lang.Object
    public final void finalize() {
        this.a.a(((ByteArrayOutputStream) this).buf);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public final synchronized void write(byte[] bArr, int i, int i2) {
        a(i2);
        super.write(bArr, i, i2);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public final synchronized void write(int i) {
        a(1);
        super.write(i);
    }
}

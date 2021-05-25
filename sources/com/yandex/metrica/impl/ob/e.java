package com.yandex.metrica.impl.ob;

import java.io.IOException;
public abstract class e {
    public volatile int a = -1;

    public int a() {
        if (this.a < 0) {
            b();
        }
        return this.a;
    }

    public abstract e a(a aVar) throws IOException;

    public void a(b bVar) throws IOException {
    }

    public int b() {
        int c = c();
        this.a = c;
        return c;
    }

    public int c() {
        return 0;
    }

    public String toString() {
        return f.a(this);
    }

    public static final <T extends e> T b(T t, byte[] bArr, int i, int i2) throws d {
        try {
            a a3 = a.a(bArr, i, i2);
            t.a(a3);
            a3.a(0);
            return t;
        } catch (d e) {
            throw e;
        } catch (IOException unused) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    public static final byte[] a(e eVar) {
        int b = eVar.b();
        byte[] bArr = new byte[b];
        a(eVar, bArr, 0, b);
        return bArr;
    }

    public static final void a(e eVar, byte[] bArr, int i, int i2) {
        try {
            b a3 = b.a(bArr, i, i2);
            eVar.a(a3);
            a3.b();
        } catch (IOException e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    public static final <T extends e> T a(T t, byte[] bArr) throws d {
        return (T) b(t, bArr, 0, bArr.length);
    }
}

package org.spongycastle.crypto.prng;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
public class FixedSecureRandom extends SecureRandom {
    public byte[] a;
    public int b;
    public int c;

    public FixedSecureRandom(byte[] bArr) {
        this(false, new byte[][]{bArr});
    }

    public final int a() {
        byte[] bArr = this.a;
        int i = this.b;
        this.b = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.security.SecureRandom
    public byte[] generateSeed(int i) {
        byte[] bArr = new byte[i];
        nextBytes(bArr);
        return bArr;
    }

    public boolean isExhausted() {
        return this.b == this.a.length;
    }

    @Override // java.security.SecureRandom, java.util.Random
    public void nextBytes(byte[] bArr) {
        System.arraycopy(this.a, this.b, bArr, 0, bArr.length);
        this.b += bArr.length;
    }

    @Override // java.util.Random
    public int nextInt() {
        int a3 = (a() << 24) | 0 | (a() << 16);
        int i = this.c;
        if (i == 2) {
            this.c = i - 1;
        } else {
            a3 |= a() << 8;
        }
        int i2 = this.c;
        if (i2 != 1) {
            return a3 | a();
        }
        this.c = i2 - 1;
        return a3;
    }

    @Override // java.util.Random
    public long nextLong() {
        return (((long) a()) << 56) | 0 | (((long) a()) << 48) | (((long) a()) << 40) | (((long) a()) << 32) | (((long) a()) << 24) | (((long) a()) << 16) | (((long) a()) << 8) | ((long) a());
    }

    public FixedSecureRandom(byte[][] bArr) {
        this(false, bArr);
    }

    public FixedSecureRandom(boolean z, byte[] bArr) {
        this(z, new byte[][]{bArr});
    }

    public FixedSecureRandom(boolean z, byte[][] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i = 0; i != bArr.length; i++) {
            try {
                byteArrayOutputStream.write(bArr[i]);
            } catch (IOException unused) {
                throw new IllegalArgumentException("can't save value array.");
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        this.a = byteArray;
        if (z) {
            this.c = byteArray.length % 4;
        }
    }
}

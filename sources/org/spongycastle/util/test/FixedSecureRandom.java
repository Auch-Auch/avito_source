package org.spongycastle.util.test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.Provider;
import java.security.SecureRandom;
import org.spongycastle.util.Pack;
import org.spongycastle.util.encoders.Hex;
public class FixedSecureRandom extends SecureRandom {
    public static java.math.BigInteger c = new java.math.BigInteger("01020304ffffffff0506070811111111", 16);
    public static java.math.BigInteger d = new java.math.BigInteger("1111111105060708ffffffff01020304", 16);
    public static java.math.BigInteger e = new java.math.BigInteger("3020104ffffffff05060708111111", 16);
    public static final boolean f;
    public static final boolean g;
    public static final boolean h;
    public byte[] a;
    public int b;

    public static class BigInteger extends Source {
        public BigInteger(byte[] bArr) {
            super(bArr);
        }

        public BigInteger(int i, byte[] bArr) {
            super(FixedSecureRandom.a(i, bArr));
        }

        public BigInteger(String str) {
            this(Hex.decode(str));
        }

        public BigInteger(int i, String str) {
            super(FixedSecureRandom.a(i, Hex.decode(str)));
        }
    }

    public static class Data extends Source {
        public Data(byte[] bArr) {
            super(bArr);
        }
    }

    public static class Source {
        public byte[] a;

        public Source(byte[] bArr) {
            this.a = bArr;
        }
    }

    public static class a extends Provider {
        public a() {
            super("BCFIPS_FIXED_RNG", 1.0d, "BCFIPS Fixed Secure Random Provider");
        }
    }

    public static class b extends SecureRandom {
        public byte[] a = Hex.decode("01020304ffffffff0506070811111111");
        public int b = 0;

        public b() {
            super(null, new a());
        }

        @Override // java.security.SecureRandom, java.util.Random
        public void nextBytes(byte[] bArr) {
            System.arraycopy(this.a, this.b, bArr, 0, bArr.length);
            this.b += bArr.length;
        }
    }

    static {
        java.math.BigInteger bigInteger = new java.math.BigInteger(128, new b());
        java.math.BigInteger bigInteger2 = new java.math.BigInteger(120, new b());
        f = bigInteger.equals(d);
        h = bigInteger.equals(c);
        g = bigInteger2.equals(e);
    }

    public FixedSecureRandom(byte[] bArr) {
        this(new Source[]{new Data(bArr)});
    }

    public static byte[] a(int i, byte[] bArr) {
        int i2;
        int i3;
        int i4 = (i + 7) / 8;
        if (i4 > bArr.length) {
            byte[] bArr2 = new byte[i4];
            System.arraycopy(bArr, 0, bArr2, i4 - bArr.length, bArr.length);
            if (f && (i3 = i % 8) != 0) {
                Pack.intToBigEndian(Pack.bigEndianToInt(bArr2, 0) << (8 - i3), bArr2, 0);
            }
            return bArr2;
        } else if (!f || i >= bArr.length * 8 || (i2 = i % 8) == 0) {
            return bArr;
        } else {
            Pack.intToBigEndian(Pack.bigEndianToInt(bArr, 0) << (8 - i2), bArr, 0);
            return bArr;
        }
    }

    public final int b() {
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
        return (b() << 24) | 0 | (b() << 16) | (b() << 8) | b();
    }

    @Override // java.util.Random
    public long nextLong() {
        return (((long) b()) << 56) | 0 | (((long) b()) << 48) | (((long) b()) << 40) | (((long) b()) << 32) | (((long) b()) << 24) | (((long) b()) << 16) | (((long) b()) << 8) | ((long) b());
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public FixedSecureRandom(byte[][] r5) {
        /*
            r4 = this;
            int r0 = r5.length
            org.spongycastle.util.test.FixedSecureRandom$Data[] r0 = new org.spongycastle.util.test.FixedSecureRandom.Data[r0]
            r1 = 0
        L_0x0004:
            int r2 = r5.length
            if (r1 == r2) goto L_0x0013
            org.spongycastle.util.test.FixedSecureRandom$Data r2 = new org.spongycastle.util.test.FixedSecureRandom$Data
            r3 = r5[r1]
            r2.<init>(r3)
            r0[r1] = r2
            int r1 = r1 + 1
            goto L_0x0004
        L_0x0013:
            r4.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.util.test.FixedSecureRandom.<init>(byte[][]):void");
    }

    public FixedSecureRandom(Source[] sourceArr) {
        super(null, new a());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        if (h) {
            if (g) {
                while (i != sourceArr.length) {
                    try {
                        if (sourceArr[i] instanceof BigInteger) {
                            byte[] bArr = sourceArr[i].a;
                            int length = bArr.length - (bArr.length % 4);
                            for (int length2 = (bArr.length - length) - 1; length2 >= 0; length2--) {
                                byteArrayOutputStream.write(bArr[length2]);
                            }
                            for (int length3 = bArr.length - length; length3 < bArr.length; length3 += 4) {
                                byteArrayOutputStream.write(bArr, length3, 4);
                            }
                        } else {
                            byteArrayOutputStream.write(sourceArr[i].a);
                        }
                        i++;
                    } catch (IOException unused) {
                        throw new IllegalArgumentException("can't save value source.");
                    }
                }
            } else {
                while (i != sourceArr.length) {
                    try {
                        byteArrayOutputStream.write(sourceArr[i].a);
                        i++;
                    } catch (IOException unused2) {
                        throw new IllegalArgumentException("can't save value source.");
                    }
                }
            }
        } else if (f) {
            for (int i2 = 0; i2 != sourceArr.length; i2++) {
                try {
                    if (sourceArr[i2] instanceof BigInteger) {
                        byte[] bArr2 = sourceArr[i2].a;
                        int length4 = bArr2.length - (bArr2.length % 4);
                        int i3 = 0;
                        while (i3 < length4) {
                            i3 += 4;
                            byteArrayOutputStream.write(bArr2, bArr2.length - i3, 4);
                        }
                        if (bArr2.length - length4 != 0) {
                            for (int i4 = 0; i4 != 4 - (bArr2.length - length4); i4++) {
                                byteArrayOutputStream.write(0);
                            }
                        }
                        for (int i5 = 0; i5 != bArr2.length - length4; i5++) {
                            byteArrayOutputStream.write(bArr2[length4 + i5]);
                        }
                    } else {
                        byteArrayOutputStream.write(sourceArr[i2].a);
                    }
                } catch (IOException unused3) {
                    throw new IllegalArgumentException("can't save value source.");
                }
            }
        } else {
            throw new IllegalStateException("Unrecognized BigInteger implementation");
        }
        this.a = byteArrayOutputStream.toByteArray();
    }
}

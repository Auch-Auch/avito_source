package org.spongycastle.pqc.math.ntru.polynomial;

import android.support.v4.media.session.PlaybackStateCompat;
import org.spongycastle.util.Arrays;
public class LongPolynomial2 {
    public long[] a;
    public int b;

    public LongPolynomial2(IntegerPolynomial integerPolynomial) {
        int i;
        long j;
        int length = integerPolynomial.coeffs.length;
        this.b = length;
        this.a = new long[((length + 1) / 2)];
        int i2 = 0;
        for (int i3 = 0; i3 < this.b; i3 = i) {
            i = i3 + 1;
            int i4 = integerPolynomial.coeffs[i3];
            while (i4 < 0) {
                i4 += 2048;
            }
            if (i < this.b) {
                i++;
                j = (long) integerPolynomial.coeffs[i];
            } else {
                j = 0;
            }
            while (j < 0) {
                j += PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            this.a[i2] = ((long) i4) + (j << 24);
            i2++;
        }
    }

    public final void a(LongPolynomial2 longPolynomial2) {
        long[] jArr = longPolynomial2.a;
        int length = jArr.length;
        long[] jArr2 = this.a;
        if (length > jArr2.length) {
            this.a = Arrays.copyOf(jArr2, jArr.length);
        }
        int i = 0;
        while (true) {
            long[] jArr3 = longPolynomial2.a;
            if (i < jArr3.length) {
                long[] jArr4 = this.a;
                jArr4[i] = (jArr4[i] + jArr3[i]) & 34342963199L;
                i++;
            } else {
                return;
            }
        }
    }

    public final LongPolynomial2 b(LongPolynomial2 longPolynomial2) {
        long[] jArr = this.a;
        long[] jArr2 = longPolynomial2.a;
        int length = jArr2.length;
        int i = 0;
        if (length <= 32) {
            int i2 = length * 2;
            LongPolynomial2 longPolynomial22 = new LongPolynomial2(new long[i2]);
            for (int i3 = 0; i3 < i2; i3++) {
                for (int max = Math.max(0, (i3 - length) + 1); max <= Math.min(i3, length - 1); max++) {
                    long j = jArr[i3 - max] * jArr2[max];
                    long[] jArr3 = longPolynomial22.a;
                    jArr3[i3] = (jArr3[i3] + (j & ((j & 2047) + 34342961152L))) & 34342963199L;
                    int i4 = i3 + 1;
                    jArr3[i4] = (jArr3[i4] + ((j >>> 48) & 2047)) & 34342963199L;
                }
            }
            return longPolynomial22;
        }
        int i5 = length / 2;
        LongPolynomial2 longPolynomial23 = new LongPolynomial2(Arrays.copyOf(jArr, i5));
        LongPolynomial2 longPolynomial24 = new LongPolynomial2(Arrays.copyOfRange(jArr, i5, length));
        LongPolynomial2 longPolynomial25 = new LongPolynomial2(Arrays.copyOf(jArr2, i5));
        LongPolynomial2 longPolynomial26 = new LongPolynomial2(Arrays.copyOfRange(jArr2, i5, length));
        LongPolynomial2 longPolynomial27 = (LongPolynomial2) longPolynomial23.clone();
        longPolynomial27.a(longPolynomial24);
        LongPolynomial2 longPolynomial28 = (LongPolynomial2) longPolynomial25.clone();
        longPolynomial28.a(longPolynomial26);
        LongPolynomial2 b2 = longPolynomial23.b(longPolynomial25);
        LongPolynomial2 b3 = longPolynomial24.b(longPolynomial26);
        LongPolynomial2 b4 = longPolynomial27.b(longPolynomial28);
        b4.c(b2);
        b4.c(b3);
        LongPolynomial2 longPolynomial29 = new LongPolynomial2(length * 2);
        int i6 = 0;
        while (true) {
            long[] jArr4 = b2.a;
            if (i6 >= jArr4.length) {
                break;
            }
            longPolynomial29.a[i6] = jArr4[i6] & 34342963199L;
            i6++;
        }
        int i7 = 0;
        while (true) {
            long[] jArr5 = b4.a;
            if (i7 >= jArr5.length) {
                break;
            }
            long[] jArr6 = longPolynomial29.a;
            int i8 = i5 + i7;
            jArr6[i8] = (jArr6[i8] + jArr5[i7]) & 34342963199L;
            i7++;
        }
        while (true) {
            long[] jArr7 = b3.a;
            if (i >= jArr7.length) {
                return longPolynomial29;
            }
            long[] jArr8 = longPolynomial29.a;
            int i9 = (i5 * 2) + i;
            jArr8[i9] = (jArr8[i9] + jArr7[i]) & 34342963199L;
            i++;
        }
    }

    public final void c(LongPolynomial2 longPolynomial2) {
        long[] jArr = longPolynomial2.a;
        int length = jArr.length;
        long[] jArr2 = this.a;
        if (length > jArr2.length) {
            this.a = Arrays.copyOf(jArr2, jArr.length);
        }
        int i = 0;
        while (true) {
            long[] jArr3 = longPolynomial2.a;
            if (i < jArr3.length) {
                long[] jArr4 = this.a;
                jArr4[i] = 34342963199L & ((jArr4[i] + 140737496743936L) - jArr3[i]);
                i++;
            } else {
                return;
            }
        }
    }

    public Object clone() {
        LongPolynomial2 longPolynomial2 = new LongPolynomial2((long[]) this.a.clone());
        longPolynomial2.b = this.b;
        return longPolynomial2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof LongPolynomial2) {
            return Arrays.areEqual(this.a, ((LongPolynomial2) obj).a);
        }
        return false;
    }

    public LongPolynomial2 mult(LongPolynomial2 longPolynomial2) {
        long[] jArr;
        long[] jArr2;
        int length = this.a.length;
        if (longPolynomial2.a.length == length && this.b == longPolynomial2.b) {
            LongPolynomial2 b2 = b(longPolynomial2);
            if (b2.a.length > length) {
                if (this.b % 2 == 0) {
                    int i = length;
                    while (true) {
                        jArr2 = b2.a;
                        if (i >= jArr2.length) {
                            break;
                        }
                        int i2 = i - length;
                        jArr2[i2] = (jArr2[i2] + jArr2[i]) & 34342963199L;
                        i++;
                    }
                    b2.a = Arrays.copyOf(jArr2, length);
                } else {
                    int i3 = length;
                    while (true) {
                        jArr = b2.a;
                        if (i3 >= jArr.length) {
                            break;
                        }
                        int i4 = i3 - length;
                        jArr[i4] = jArr[i4] + (jArr[i3 - 1] >> 24);
                        jArr[i4] = jArr[i4] + ((2047 & jArr[i3]) << 24);
                        jArr[i4] = jArr[i4] & 34342963199L;
                        i3++;
                    }
                    long[] copyOf = Arrays.copyOf(jArr, length);
                    b2.a = copyOf;
                    int length2 = copyOf.length - 1;
                    copyOf[length2] = copyOf[length2] & 2047;
                }
            }
            LongPolynomial2 longPolynomial22 = new LongPolynomial2(b2.a);
            longPolynomial22.b = this.b;
            return longPolynomial22;
        }
        throw new IllegalArgumentException("Number of coefficients must be the same");
    }

    public void mult2And(int i) {
        long j = (long) i;
        long j2 = (j << 24) + j;
        int i2 = 0;
        while (true) {
            long[] jArr = this.a;
            if (i2 < jArr.length) {
                jArr[i2] = (jArr[i2] << 1) & j2;
                i2++;
            } else {
                return;
            }
        }
    }

    public void subAnd(LongPolynomial2 longPolynomial2, int i) {
        long j = (long) i;
        long j2 = (j << 24) + j;
        int i2 = 0;
        while (true) {
            long[] jArr = longPolynomial2.a;
            if (i2 < jArr.length) {
                long[] jArr2 = this.a;
                jArr2[i2] = ((jArr2[i2] + 140737496743936L) - jArr[i2]) & j2;
                i2++;
            } else {
                return;
            }
        }
    }

    public IntegerPolynomial toIntegerPolynomial() {
        int[] iArr = new int[this.b];
        int i = 0;
        int i2 = 0;
        while (true) {
            long[] jArr = this.a;
            if (i >= jArr.length) {
                return new IntegerPolynomial(iArr);
            }
            int i3 = i2 + 1;
            iArr[i2] = (int) (jArr[i] & 2047);
            if (i3 < this.b) {
                i2 = i3 + 1;
                iArr[i3] = (int) ((jArr[i] >> 24) & 2047);
            } else {
                i2 = i3;
            }
            i++;
        }
    }

    public LongPolynomial2(long[] jArr) {
        this.a = jArr;
    }

    public LongPolynomial2(int i) {
        this.a = new long[i];
    }
}

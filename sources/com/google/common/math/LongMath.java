package com.google.common.math;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.avito.android.remote.auth.AuthSource;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Longs;
import com.google.common.primitives.UnsignedLongs;
import java.math.RoundingMode;
import okhttp3.internal.connection.RealConnection;
import org.spongycastle.asn1.cmc.BodyPartID;
@GwtCompatible(emulated = true)
public final class LongMath {
    @VisibleForTesting
    public static final byte[] a = {19, Ascii.DC2, Ascii.DC2, Ascii.DC2, Ascii.DC2, 17, 17, 17, Ascii.DLE, Ascii.DLE, Ascii.DLE, Ascii.SI, Ascii.SI, Ascii.SI, Ascii.SI, Ascii.SO, Ascii.SO, Ascii.SO, Ascii.CR, Ascii.CR, Ascii.CR, Ascii.FF, Ascii.FF, Ascii.FF, Ascii.FF, Ascii.VT, Ascii.VT, Ascii.VT, 10, 10, 10, 9, 9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0};
    @VisibleForTesting
    @GwtIncompatible
    public static final long[] b = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000, RealConnection.IDLE_CONNECTION_HEALTHY_NS, 100000000000L, 1000000000000L, 10000000000000L, 100000000000000L, 1000000000000000L, 10000000000000000L, 100000000000000000L, 1000000000000000000L};
    @VisibleForTesting
    @GwtIncompatible
    public static final long[] c = {3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, 3162277660L, 31622776601L, 316227766016L, 3162277660168L, 31622776601683L, 316227766016837L, 3162277660168379L, 31622776601683793L, 316227766016837933L, 3162277660168379331L};
    public static final long[] d = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600, 6227020800L, 87178291200L, 1307674368000L, 20922789888000L, 355687428096000L, 6402373705728000L, 121645100408832000L, 2432902008176640000L};
    public static final int[] e = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 3810779, 121977, 16175, 4337, 1733, 887, 534, 361, 265, 206, 169, 143, 125, 111, 101, 94, 88, 83, 79, 76, 74, 72, 70, 69, 68, 67, 67, 66, 66, 66, 66};
    @VisibleForTesting
    public static final int[] f = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 2642246, 86251, 11724, 3218, 1313, 684, 419, 287, 214, 169, 139, 119, 105, 95, 87, 81, 76, 73, 70, 68, 66, 64, 63, 62, 62, 61, 61, 61};
    public static final long[][] g = {new long[]{291830, 126401071349994536L}, new long[]{885594168, 725270293939359937L, 3569819667048198375L}, new long[]{273919523040L, 15, 7363882082L, 992620450144556L}, new long[]{47636622961200L, 2, 2570940, 211991001, 3749873356L}, new long[]{7999252175582850L, 2, 4130806001517L, 149795463772692060L, 186635894390467037L, 3967304179347715805L}, new long[]{585226005592931976L, 2, 123635709730000L, 9233062284813009L, 43835965440333360L, 761179012939631437L, 1263739024124850375L}, new long[]{Long.MAX_VALUE, 2, 325, 9375, 28178, 450775, 9780504, 1795265022}};

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            a = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[RoundingMode.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[RoundingMode.FLOOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[RoundingMode.UP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[RoundingMode.CEILING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[RoundingMode.HALF_DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[RoundingMode.HALF_EVEN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public enum b {
        SMALL {
            @Override // com.google.common.math.LongMath.b
            public long a(long j, long j2, long j3) {
                return (j * j2) % j3;
            }

            @Override // com.google.common.math.LongMath.b
            public long b(long j, long j2) {
                return (j * j) % j2;
            }
        },
        LARGE {
            @Override // com.google.common.math.LongMath.b
            public long a(long j, long j2, long j3) {
                long j4 = j >>> 32;
                long j5 = j2 >>> 32;
                long j6 = j & BodyPartID.bodyIdMax;
                long j7 = j2 & BodyPartID.bodyIdMax;
                long c = (j4 * j7) + c(j4 * j5, j3);
                if (c < 0) {
                    c = UnsignedLongs.remainder(c, j3);
                }
                Long.signum(j6);
                long c2 = c((j5 * j6) + c, j3);
                long remainder = UnsignedLongs.remainder(j6 * j7, j3);
                int i = (c2 > (j3 - remainder) ? 1 : (c2 == (j3 - remainder) ? 0 : -1));
                long j8 = c2 + remainder;
                return i >= 0 ? j8 - j3 : j8;
            }

            @Override // com.google.common.math.LongMath.b
            public long b(long j, long j2) {
                long j3 = j >>> 32;
                long j4 = j & BodyPartID.bodyIdMax;
                long c = c(j3 * j3, j2);
                long j5 = j3 * j4 * 2;
                if (j5 < 0) {
                    j5 = UnsignedLongs.remainder(j5, j2);
                }
                long c2 = c(c + j5, j2);
                long remainder = UnsignedLongs.remainder(j4 * j4, j2);
                int i = (c2 > (j2 - remainder) ? 1 : (c2 == (j2 - remainder) ? 0 : -1));
                long j6 = c2 + remainder;
                return i >= 0 ? j6 - j2 : j6;
            }

            public final long c(long j, long j2) {
                int i = 32;
                do {
                    int min = Math.min(i, Long.numberOfLeadingZeros(j));
                    j = UnsignedLongs.remainder(j << min, j2);
                    i -= min;
                } while (i > 0);
                return j;
            }
        };

        /* access modifiers changed from: public */
        b(a aVar) {
        }

        public abstract long a(long j, long j2, long j3);

        public abstract long b(long j, long j2);
    }

    @VisibleForTesting
    public static int a(long j, long j2) {
        return (int) ((~(~(j - j2))) >>> 63);
    }

    public static long b(long j, long j2, long j3) {
        if (j == 1) {
            return j2 / j3;
        }
        long gcd = gcd(j, j3);
        return (j2 / (j3 / gcd)) * (j / gcd);
    }

    public static long binomial(int i, int i2) {
        AppCompatDelegateImpl.i.x("n", i);
        AppCompatDelegateImpl.i.x("k", i2);
        Preconditions.checkArgument(i2 <= i, "k (%s) > n (%s)", i2, i);
        if (i2 > (i >> 1)) {
            i2 = i - i2;
        }
        long j = 1;
        if (i2 == 0) {
            return 1;
        }
        if (i2 == 1) {
            return (long) i;
        }
        long[] jArr = d;
        if (i < jArr.length) {
            return jArr[i] / (jArr[i2] * jArr[i - i2]);
        }
        int[] iArr = e;
        if (i2 >= iArr.length || i > iArr[i2]) {
            return Long.MAX_VALUE;
        }
        int[] iArr2 = f;
        if (i2 >= iArr2.length || i > iArr2[i2]) {
            long j2 = (long) i;
            int log2 = log2(j2, RoundingMode.CEILING);
            int i3 = i - 1;
            int i4 = log2;
            long j3 = j2;
            int i5 = 2;
            long j4 = 1;
            while (i5 <= i2) {
                i4 += log2;
                if (i4 < 63) {
                    j3 *= (long) i3;
                    j4 *= (long) i5;
                } else {
                    j = b(j, j3, j4);
                    j3 = (long) i3;
                    j4 = (long) i5;
                    i4 = log2;
                }
                i5++;
                i3--;
            }
            return b(j, j3, j4);
        }
        int i6 = i - 1;
        long j5 = (long) i;
        for (int i7 = 2; i7 <= i2; i7++) {
            j5 = (j5 * ((long) i6)) / ((long) i7);
            i6--;
        }
        return j5;
    }

    @Beta
    public static long ceilingPowerOfTwo(long j) {
        AppCompatDelegateImpl.i.C("x", j);
        if (j <= Longs.MAX_POWER_OF_TWO) {
            return 1 << (-Long.numberOfLeadingZeros(j - 1));
        }
        throw new ArithmeticException(a2.b.a.a.a.V2("ceilingPowerOfTwo(", j, ") is not representable as a long"));
    }

    @GwtIncompatible
    public static long checkedAdd(long j, long j2) {
        long j3 = j + j2;
        boolean z = true;
        boolean z2 = (j ^ j2) < 0;
        if ((j ^ j3) < 0) {
            z = false;
        }
        AppCompatDelegateImpl.i.w(z2 | z, "checkedAdd", j, j2);
        return j3;
    }

    public static long checkedMultiply(long j, long j2) {
        int numberOfLeadingZeros = Long.numberOfLeadingZeros(~j2) + Long.numberOfLeadingZeros(j2) + Long.numberOfLeadingZeros(~j) + Long.numberOfLeadingZeros(j);
        if (numberOfLeadingZeros > 65) {
            return j * j2;
        }
        AppCompatDelegateImpl.i.w(numberOfLeadingZeros >= 64, "checkedMultiply", j, j2);
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        AppCompatDelegateImpl.i.w((i >= 0) | (j2 != Long.MIN_VALUE), "checkedMultiply", j, j2);
        long j3 = j * j2;
        AppCompatDelegateImpl.i.w(i == 0 || j3 / j == j2, "checkedMultiply", j, j2);
        return j3;
    }

    @GwtIncompatible
    public static long checkedPow(long j, int i) {
        int i2 = i;
        AppCompatDelegateImpl.i.x("exponent", i2);
        boolean z = false;
        if ((j >= -2) && (j <= 2)) {
            int i3 = (int) j;
            if (i3 == -2) {
                if (i2 < 64) {
                    z = true;
                }
                AppCompatDelegateImpl.i.w(z, "checkedPow", j, (long) i2);
                return (i2 & 1) == 0 ? 1 << i2 : -1 << i2;
            } else if (i3 == -1) {
                return (i2 & 1) == 0 ? 1 : -1;
            } else {
                if (i3 != 0) {
                    if (i3 == 1) {
                        return 1;
                    }
                    if (i3 == 2) {
                        if (i2 < 63) {
                            z = true;
                        }
                        AppCompatDelegateImpl.i.w(z, "checkedPow", j, (long) i2);
                        return 1 << i2;
                    }
                    throw new AssertionError();
                } else if (i2 == 0) {
                    return 1;
                } else {
                    return 0;
                }
            }
        } else {
            long j2 = 1;
            long j3 = j;
            while (i2 != 0) {
                if (i2 == 1) {
                    return checkedMultiply(j2, j3);
                }
                if ((i2 & 1) != 0) {
                    j2 = checkedMultiply(j2, j3);
                }
                int i4 = i2 >> 1;
                if (i4 > 0) {
                    AppCompatDelegateImpl.i.w(-3037000499L <= j3 && j3 <= 3037000499L, "checkedPow", j3, (long) i4);
                    j3 *= j3;
                }
                j2 = j2;
                i2 = i4;
            }
            return j2;
        }
    }

    @GwtIncompatible
    public static long checkedSubtract(long j, long j2) {
        long j3 = j - j2;
        boolean z = true;
        boolean z2 = (j ^ j2) >= 0;
        if ((j ^ j3) < 0) {
            z = false;
        }
        AppCompatDelegateImpl.i.w(z2 | z, "checkedSubtract", j, j2);
        return j3;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0051, code lost:
        if (r11 > 0) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0054, code lost:
        if (r10 > 0) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0057, code lost:
        if (r10 < 0) goto L_0x0062;
     */
    @com.google.common.annotations.GwtIncompatible
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long divide(long r9, long r11, java.math.RoundingMode r13) {
        /*
            com.google.common.base.Preconditions.checkNotNull(r13)
            long r0 = r9 / r11
            long r2 = r11 * r0
            long r2 = r9 - r2
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x0010
            return r0
        L_0x0010:
            long r9 = r9 ^ r11
            r7 = 63
            long r9 = r9 >> r7
            int r10 = (int) r9
            r9 = 1
            r10 = r10 | r9
            int[] r7 = com.google.common.math.LongMath.a.a
            int r8 = r13.ordinal()
            r7 = r7[r8]
            r8 = 0
            switch(r7) {
                case 1: goto L_0x005a;
                case 2: goto L_0x0061;
                case 3: goto L_0x0057;
                case 4: goto L_0x0062;
                case 5: goto L_0x0054;
                case 6: goto L_0x0029;
                case 7: goto L_0x0029;
                case 8: goto L_0x0029;
                default: goto L_0x0023;
            }
        L_0x0023:
            java.lang.AssertionError r9 = new java.lang.AssertionError
            r9.<init>()
            throw r9
        L_0x0029:
            long r2 = java.lang.Math.abs(r2)
            long r11 = java.lang.Math.abs(r11)
            long r11 = r11 - r2
            long r2 = r2 - r11
            int r11 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r11 != 0) goto L_0x0051
            java.math.RoundingMode r11 = java.math.RoundingMode.HALF_UP
            if (r13 != r11) goto L_0x003d
            r11 = 1
            goto L_0x003e
        L_0x003d:
            r11 = 0
        L_0x003e:
            java.math.RoundingMode r12 = java.math.RoundingMode.HALF_EVEN
            if (r13 != r12) goto L_0x0044
            r12 = 1
            goto L_0x0045
        L_0x0044:
            r12 = 0
        L_0x0045:
            r2 = 1
            long r2 = r2 & r0
            int r13 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x004d
            goto L_0x004e
        L_0x004d:
            r9 = 0
        L_0x004e:
            r9 = r9 & r12
            r9 = r9 | r11
            goto L_0x0062
        L_0x0051:
            if (r11 <= 0) goto L_0x0061
            goto L_0x0062
        L_0x0054:
            if (r10 <= 0) goto L_0x0061
            goto L_0x0062
        L_0x0057:
            if (r10 >= 0) goto L_0x0061
            goto L_0x0062
        L_0x005a:
            if (r6 != 0) goto L_0x005d
            goto L_0x005e
        L_0x005d:
            r9 = 0
        L_0x005e:
            androidx.appcompat.app.AppCompatDelegateImpl.i.F(r9)
        L_0x0061:
            r9 = 0
        L_0x0062:
            if (r9 == 0) goto L_0x0066
            long r9 = (long) r10
            long r0 = r0 + r9
        L_0x0066:
            return r0
            switch-data {1->0x005a, 2->0x0061, 3->0x0057, 4->0x0062, 5->0x0054, 6->0x0029, 7->0x0029, 8->0x0029, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.LongMath.divide(long, long, java.math.RoundingMode):long");
    }

    @GwtIncompatible
    public static long factorial(int i) {
        AppCompatDelegateImpl.i.x("n", i);
        long[] jArr = d;
        if (i < jArr.length) {
            return jArr[i];
        }
        return Long.MAX_VALUE;
    }

    @Beta
    public static long floorPowerOfTwo(long j) {
        AppCompatDelegateImpl.i.C("x", j);
        return 1 << (63 - Long.numberOfLeadingZeros(j));
    }

    public static long gcd(long j, long j2) {
        AppCompatDelegateImpl.i.y(AuthSource.SEND_ABUSE, j);
        AppCompatDelegateImpl.i.y(AuthSource.BOOKING_ORDER, j2);
        if (j == 0) {
            return j2;
        }
        if (j2 == 0) {
            return j;
        }
        int numberOfTrailingZeros = Long.numberOfTrailingZeros(j);
        long j3 = j >> numberOfTrailingZeros;
        int numberOfTrailingZeros2 = Long.numberOfTrailingZeros(j2);
        long j4 = j2 >> numberOfTrailingZeros2;
        while (j3 != j4) {
            long j5 = j3 - j4;
            long j6 = (j5 >> 63) & j5;
            long j7 = (j5 - j6) - j6;
            j4 += j6;
            j3 = j7 >> Long.numberOfTrailingZeros(j7);
        }
        return j3 << Math.min(numberOfTrailingZeros, numberOfTrailingZeros2);
    }

    public static boolean isPowerOfTwo(long j) {
        boolean z = true;
        boolean z2 = j > 0;
        if ((j & (j - 1)) != 0) {
            z = false;
        }
        return z2 & z;
    }

    @Beta
    @GwtIncompatible
    public static boolean isPrime(long j) {
        boolean z;
        int i;
        int i2 = (j > 2 ? 1 : (j == 2 ? 0 : -1));
        if (i2 < 0) {
            AppCompatDelegateImpl.i.y("n", j);
            return false;
        } else if (i2 == 0 || j == 3 || j == 5 || j == 7 || j == 11 || j == 13) {
            return true;
        } else {
            if ((-545925251 & (1 << ((int) (j % 30)))) != 0) {
                return false;
            }
            long j2 = 0;
            if (j % 7 == 0 || j % 11 == 0 || j % 13 == 0) {
                return false;
            }
            if (j < 289) {
                return true;
            }
            long[][] jArr = g;
            int length = jArr.length;
            int i3 = 0;
            while (i3 < length) {
                long[] jArr2 = jArr[i3];
                if (j <= jArr2[0]) {
                    int i4 = 1;
                    while (i4 < jArr2.length) {
                        long j3 = jArr2[i4];
                        b bVar = j <= 3037000499L ? b.SMALL : b.LARGE;
                        long j4 = j - 1;
                        int numberOfTrailingZeros = Long.numberOfTrailingZeros(j4);
                        long j5 = j4 >> numberOfTrailingZeros;
                        long j6 = j3 % j;
                        if (j6 != j2) {
                            long j7 = j5;
                            long j8 = j6;
                            long j9 = 1;
                            while (j7 != j2) {
                                if ((j7 & 1) != j2) {
                                    i = numberOfTrailingZeros;
                                    j9 = bVar.a(j9, j8, j);
                                } else {
                                    i = numberOfTrailingZeros;
                                }
                                j8 = bVar.b(j8, j);
                                j7 >>= 1;
                                numberOfTrailingZeros = i;
                                j2 = 0;
                            }
                            if (j9 != 1) {
                                int i5 = 0;
                                while (true) {
                                    if (j9 == j4) {
                                        break;
                                    }
                                    i5++;
                                    if (i5 == numberOfTrailingZeros) {
                                        z = false;
                                        break;
                                    }
                                    j9 = bVar.b(j9, j);
                                }
                            }
                        }
                        z = true;
                        if (!z) {
                            return false;
                        }
                        i4++;
                        j2 = 0;
                    }
                    return true;
                }
                i3++;
                j2 = 0;
            }
            throw new AssertionError();
        }
    }

    @GwtIncompatible
    public static int log10(long j, RoundingMode roundingMode) {
        int a3;
        AppCompatDelegateImpl.i.C("x", j);
        byte b2 = a[Long.numberOfLeadingZeros(j)];
        long[] jArr = b;
        int a4 = b2 - a(j, jArr[b2]);
        long j2 = jArr[a4];
        switch (a.a[roundingMode.ordinal()]) {
            case 1:
                AppCompatDelegateImpl.i.F(j == j2);
                return a4;
            case 2:
            case 3:
                return a4;
            case 4:
            case 5:
                a3 = a(j2, j);
                return a3 + a4;
            case 6:
            case 7:
            case 8:
                a3 = a(c[a4], j);
                return a3 + a4;
            default:
                throw new AssertionError();
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static int log2(long j, RoundingMode roundingMode) {
        AppCompatDelegateImpl.i.C("x", j);
        switch (a.a[roundingMode.ordinal()]) {
            case 1:
                AppCompatDelegateImpl.i.F(isPowerOfTwo(j));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 64 - Long.numberOfLeadingZeros(j - 1);
            case 6:
            case 7:
            case 8:
                int numberOfLeadingZeros = Long.numberOfLeadingZeros(j);
                return a(-5402926248376769404 >>> numberOfLeadingZeros, j) + (63 - numberOfLeadingZeros);
            default:
                throw new AssertionError("impossible");
        }
        return 63 - Long.numberOfLeadingZeros(j);
    }

    public static long mean(long j, long j2) {
        return (j & j2) + ((j ^ j2) >> 1);
    }

    @GwtIncompatible
    public static int mod(long j, int i) {
        return (int) mod(j, (long) i);
    }

    @GwtIncompatible
    public static long pow(long j, int i) {
        AppCompatDelegateImpl.i.x("exponent", i);
        if (-2 > j || j > 2) {
            long j2 = 1;
            while (i != 0) {
                if (i == 1) {
                    return j2 * j;
                }
                j2 *= (i & 1) == 0 ? 1 : j;
                j *= j;
                i >>= 1;
            }
            return j2;
        }
        int i2 = (int) j;
        if (i2 != -2) {
            if (i2 != -1) {
                if (i2 == 0) {
                    return i == 0 ? 1 : 0;
                }
                if (i2 == 1) {
                    return 1;
                }
                if (i2 != 2) {
                    throw new AssertionError();
                } else if (i < 64) {
                    return 1 << i;
                } else {
                    return 0;
                }
            } else if ((i & 1) == 0) {
                return 1;
            } else {
                return -1;
            }
        } else if (i < 64) {
            return (i & 1) == 0 ? 1 << i : -(1 << i);
        } else {
            return 0;
        }
    }

    @Beta
    public static long saturatedAdd(long j, long j2) {
        long j3 = j + j2;
        boolean z = true;
        boolean z2 = (j2 ^ j) < 0;
        if ((j ^ j3) < 0) {
            z = false;
        }
        return z2 | z ? j3 : ((j3 >>> 63) ^ 1) + Long.MAX_VALUE;
    }

    @Beta
    public static long saturatedMultiply(long j, long j2) {
        int numberOfLeadingZeros = Long.numberOfLeadingZeros(~j2) + Long.numberOfLeadingZeros(j2) + Long.numberOfLeadingZeros(~j) + Long.numberOfLeadingZeros(j);
        if (numberOfLeadingZeros > 65) {
            return j * j2;
        }
        long j3 = ((j ^ j2) >>> 63) + Long.MAX_VALUE;
        boolean z = true;
        boolean z2 = numberOfLeadingZeros < 64;
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        boolean z3 = i < 0;
        if (j2 != Long.MIN_VALUE) {
            z = false;
        }
        if (z2 || (z & z3)) {
            return j3;
        }
        long j4 = j * j2;
        return (i == 0 || j4 / j == j2) ? j4 : j3;
    }

    @Beta
    public static long saturatedPow(long j, int i) {
        AppCompatDelegateImpl.i.x("exponent", i);
        long j2 = 1;
        if ((j >= -2) && (j <= 2)) {
            int i2 = (int) j;
            if (i2 != -2) {
                if (i2 == -1) {
                    return (i & 1) == 0 ? 1 : -1;
                }
                if (i2 != 0) {
                    if (i2 == 1) {
                        return 1;
                    }
                    if (i2 != 2) {
                        throw new AssertionError();
                    } else if (i >= 63) {
                        return Long.MAX_VALUE;
                    } else {
                        return 1 << i;
                    }
                } else if (i == 0) {
                    return 1;
                } else {
                    return 0;
                }
            } else if (i >= 64) {
                return ((long) (i & 1)) + Long.MAX_VALUE;
            } else {
                return (i & 1) == 0 ? 1 << i : -1 << i;
            }
        } else {
            long j3 = ((j >>> 63) & ((long) (i & 1))) + Long.MAX_VALUE;
            while (i != 0) {
                if (i == 1) {
                    return saturatedMultiply(j2, j);
                }
                if ((i & 1) != 0) {
                    j2 = saturatedMultiply(j2, j);
                }
                i >>= 1;
                if (i > 0) {
                    if ((-3037000499L > j) || (j > 3037000499L)) {
                        return j3;
                    }
                    j *= j;
                }
            }
            return j2;
        }
    }

    @Beta
    public static long saturatedSubtract(long j, long j2) {
        long j3 = j - j2;
        boolean z = true;
        boolean z2 = (j2 ^ j) >= 0;
        if ((j ^ j3) < 0) {
            z = false;
        }
        return z2 | z ? j3 : ((j3 >>> 63) ^ 1) + Long.MAX_VALUE;
    }

    @GwtIncompatible
    public static long sqrt(long j, RoundingMode roundingMode) {
        AppCompatDelegateImpl.i.y("x", j);
        int i = (int) j;
        boolean z = true;
        int i2 = 1;
        if (((long) i) == j) {
            return (long) IntMath.sqrt(i, roundingMode);
        }
        long sqrt = (long) Math.sqrt((double) j);
        long j2 = sqrt * sqrt;
        switch (a.a[roundingMode.ordinal()]) {
            case 1:
                if (j2 != j) {
                    z = false;
                }
                AppCompatDelegateImpl.i.F(z);
                return sqrt;
            case 2:
            case 3:
                return j < j2 ? sqrt - 1 : sqrt;
            case 4:
            case 5:
                return j > j2 ? sqrt + 1 : sqrt;
            case 6:
            case 7:
            case 8:
                if (j >= j2) {
                    i2 = 0;
                }
                long j3 = sqrt - ((long) i2);
                return j3 + ((long) a((j3 * j3) + j3, j));
            default:
                throw new AssertionError();
        }
    }

    @GwtIncompatible
    public static long mod(long j, long j2) {
        if (j2 > 0) {
            long j3 = j % j2;
            return j3 >= 0 ? j3 : j3 + j2;
        }
        throw new ArithmeticException("Modulus must be positive");
    }
}

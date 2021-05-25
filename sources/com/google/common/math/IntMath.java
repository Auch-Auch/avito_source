package com.google.common.math;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.math.RoundingMode;
import okhttp3.internal.http2.Http2Connection;
@GwtCompatible(emulated = true)
public final class IntMath {
    @VisibleForTesting
    public static final byte[] a = {9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0, 0};
    @VisibleForTesting
    public static final int[] b = {1, 10, 100, 1000, 10000, AacUtil.AAC_LC_MAX_RATE_BYTES_PER_SECOND, 1000000, 10000000, 100000000, Http2Connection.DEGRADED_PONG_TIMEOUT_NS};
    @VisibleForTesting
    public static final int[] c = {3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, Integer.MAX_VALUE};
    public static final int[] d = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600};
    @VisibleForTesting
    public static int[] e = {Integer.MAX_VALUE, Integer.MAX_VALUE, 65536, 2345, 477, 193, 110, 75, 58, 49, 43, 39, 37, 35, 34, 34, 33};

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

    @VisibleForTesting
    public static int a(int i, int i2) {
        return (~(~(i - i2))) >>> 31;
    }

    public static int binomial(int i, int i2) {
        AppCompatDelegateImpl.i.x("n", i);
        AppCompatDelegateImpl.i.x("k", i2);
        int i3 = 0;
        Preconditions.checkArgument(i2 <= i, "k (%s) > n (%s)", i2, i);
        if (i2 > (i >> 1)) {
            i2 = i - i2;
        }
        int[] iArr = e;
        if (i2 >= iArr.length || i > iArr[i2]) {
            return Integer.MAX_VALUE;
        }
        if (i2 == 0) {
            return 1;
        }
        if (i2 == 1) {
            return i;
        }
        long j = 1;
        while (i3 < i2) {
            i3++;
            j = (j * ((long) (i - i3))) / ((long) i3);
        }
        return (int) j;
    }

    @Beta
    public static int ceilingPowerOfTwo(int i) {
        AppCompatDelegateImpl.i.B("x", i);
        if (i <= 1073741824) {
            return 1 << (-Integer.numberOfLeadingZeros(i - 1));
        }
        throw new ArithmeticException(a2.b.a.a.a.Q2("ceilingPowerOfTwo(", i, ") not representable as an int"));
    }

    public static int checkedAdd(int i, int i2) {
        long j = ((long) i) + ((long) i2);
        int i3 = (int) j;
        AppCompatDelegateImpl.i.v(j == ((long) i3), "checkedAdd", i, i2);
        return i3;
    }

    public static int checkedMultiply(int i, int i2) {
        long j = ((long) i) * ((long) i2);
        int i3 = (int) j;
        AppCompatDelegateImpl.i.v(j == ((long) i3), "checkedMultiply", i, i2);
        return i3;
    }

    public static int checkedPow(int i, int i2) {
        AppCompatDelegateImpl.i.x("exponent", i2);
        boolean z = false;
        if (i == -2) {
            if (i2 < 32) {
                z = true;
            }
            AppCompatDelegateImpl.i.v(z, "checkedPow", i, i2);
            return (i2 & 1) == 0 ? 1 << i2 : -1 << i2;
        } else if (i != -1) {
            if (i != 0) {
                if (i == 1) {
                    return 1;
                }
                if (i != 2) {
                    int i3 = 1;
                    while (i2 != 0) {
                        if (i2 == 1) {
                            return checkedMultiply(i3, i);
                        }
                        if ((i2 & 1) != 0) {
                            i3 = checkedMultiply(i3, i);
                        }
                        i2 >>= 1;
                        if (i2 > 0) {
                            AppCompatDelegateImpl.i.v((-46340 <= i) & (i <= 46340), "checkedPow", i, i2);
                            i *= i;
                        }
                    }
                    return i3;
                }
                if (i2 < 31) {
                    z = true;
                }
                AppCompatDelegateImpl.i.v(z, "checkedPow", i, i2);
                return 1 << i2;
            } else if (i2 == 0) {
                return 1;
            } else {
                return 0;
            }
        } else if ((i2 & 1) == 0) {
            return 1;
        } else {
            return -1;
        }
    }

    public static int checkedSubtract(int i, int i2) {
        long j = ((long) i) - ((long) i2);
        int i3 = (int) j;
        AppCompatDelegateImpl.i.v(j == ((long) i3), "checkedSubtract", i, i2);
        return i3;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0044, code lost:
        if (((r7 == java.math.RoundingMode.HALF_EVEN) & ((r0 & 1) != 0)) != false) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0047, code lost:
        if (r1 > 0) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004a, code lost:
        if (r5 > 0) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004d, code lost:
        if (r5 < 0) goto L_0x0058;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int divide(int r5, int r6, java.math.RoundingMode r7) {
        /*
            com.google.common.base.Preconditions.checkNotNull(r7)
            if (r6 == 0) goto L_0x005c
            int r0 = r5 / r6
            int r1 = r6 * r0
            int r1 = r5 - r1
            if (r1 != 0) goto L_0x000e
            return r0
        L_0x000e:
            r5 = r5 ^ r6
            int r5 = r5 >> 31
            r2 = 1
            r5 = r5 | r2
            int[] r3 = com.google.common.math.IntMath.a.a
            int r4 = r7.ordinal()
            r3 = r3[r4]
            r4 = 0
            switch(r3) {
                case 1: goto L_0x0050;
                case 2: goto L_0x0057;
                case 3: goto L_0x004d;
                case 4: goto L_0x0058;
                case 5: goto L_0x004a;
                case 6: goto L_0x0025;
                case 7: goto L_0x0025;
                case 8: goto L_0x0025;
                default: goto L_0x001f;
            }
        L_0x001f:
            java.lang.AssertionError r5 = new java.lang.AssertionError
            r5.<init>()
            throw r5
        L_0x0025:
            int r1 = java.lang.Math.abs(r1)
            int r6 = java.lang.Math.abs(r6)
            int r6 = r6 - r1
            int r1 = r1 - r6
            if (r1 != 0) goto L_0x0047
            java.math.RoundingMode r6 = java.math.RoundingMode.HALF_UP
            if (r7 == r6) goto L_0x0058
            java.math.RoundingMode r6 = java.math.RoundingMode.HALF_EVEN
            if (r7 != r6) goto L_0x003b
            r6 = 1
            goto L_0x003c
        L_0x003b:
            r6 = 0
        L_0x003c:
            r7 = r0 & 1
            if (r7 == 0) goto L_0x0042
            r7 = 1
            goto L_0x0043
        L_0x0042:
            r7 = 0
        L_0x0043:
            r6 = r6 & r7
            if (r6 == 0) goto L_0x0057
            goto L_0x0058
        L_0x0047:
            if (r1 <= 0) goto L_0x0057
            goto L_0x0058
        L_0x004a:
            if (r5 <= 0) goto L_0x0057
            goto L_0x0058
        L_0x004d:
            if (r5 >= 0) goto L_0x0057
            goto L_0x0058
        L_0x0050:
            if (r1 != 0) goto L_0x0053
            goto L_0x0054
        L_0x0053:
            r2 = 0
        L_0x0054:
            androidx.appcompat.app.AppCompatDelegateImpl.i.F(r2)
        L_0x0057:
            r2 = 0
        L_0x0058:
            if (r2 == 0) goto L_0x005b
            int r0 = r0 + r5
        L_0x005b:
            return r0
        L_0x005c:
            java.lang.ArithmeticException r5 = new java.lang.ArithmeticException
            java.lang.String r6 = "/ by zero"
            r5.<init>(r6)
            throw r5
            switch-data {1->0x0050, 2->0x0057, 3->0x004d, 4->0x0058, 5->0x004a, 6->0x0025, 7->0x0025, 8->0x0025, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.IntMath.divide(int, int, java.math.RoundingMode):int");
    }

    public static int factorial(int i) {
        AppCompatDelegateImpl.i.x("n", i);
        int[] iArr = d;
        if (i < iArr.length) {
            return iArr[i];
        }
        return Integer.MAX_VALUE;
    }

    @Beta
    public static int floorPowerOfTwo(int i) {
        AppCompatDelegateImpl.i.B("x", i);
        return Integer.highestOneBit(i);
    }

    public static int gcd(int i, int i2) {
        AppCompatDelegateImpl.i.x(AuthSource.SEND_ABUSE, i);
        AppCompatDelegateImpl.i.x(AuthSource.BOOKING_ORDER, i2);
        if (i == 0) {
            return i2;
        }
        if (i2 == 0) {
            return i;
        }
        int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i);
        int i3 = i >> numberOfTrailingZeros;
        int numberOfTrailingZeros2 = Integer.numberOfTrailingZeros(i2);
        int i4 = i2 >> numberOfTrailingZeros2;
        while (i3 != i4) {
            int i5 = i3 - i4;
            int i6 = (i5 >> 31) & i5;
            int i7 = (i5 - i6) - i6;
            i4 += i6;
            i3 = i7 >> Integer.numberOfTrailingZeros(i7);
        }
        return i3 << Math.min(numberOfTrailingZeros, numberOfTrailingZeros2);
    }

    public static boolean isPowerOfTwo(int i) {
        boolean z = false;
        boolean z2 = i > 0;
        if ((i & (i - 1)) == 0) {
            z = true;
        }
        return z2 & z;
    }

    @Beta
    @GwtIncompatible
    public static boolean isPrime(int i) {
        return LongMath.isPrime((long) i);
    }

    @GwtIncompatible
    public static int log10(int i, RoundingMode roundingMode) {
        int a3;
        AppCompatDelegateImpl.i.B("x", i);
        byte b2 = a[Integer.numberOfLeadingZeros(i)];
        int[] iArr = b;
        int a4 = b2 - a(i, iArr[b2]);
        int i2 = iArr[a4];
        switch (a.a[roundingMode.ordinal()]) {
            case 1:
                AppCompatDelegateImpl.i.F(i == i2);
                return a4;
            case 2:
            case 3:
                return a4;
            case 4:
            case 5:
                a3 = a(i2, i);
                return a3 + a4;
            case 6:
            case 7:
            case 8:
                a3 = a(c[a4], i);
                return a3 + a4;
            default:
                throw new AssertionError();
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static int log2(int i, RoundingMode roundingMode) {
        AppCompatDelegateImpl.i.B("x", i);
        switch (a.a[roundingMode.ordinal()]) {
            case 1:
                AppCompatDelegateImpl.i.F(isPowerOfTwo(i));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 32 - Integer.numberOfLeadingZeros(i - 1);
            case 6:
            case 7:
            case 8:
                int numberOfLeadingZeros = Integer.numberOfLeadingZeros(i);
                return a(-1257966797 >>> numberOfLeadingZeros, i) + (31 - numberOfLeadingZeros);
            default:
                throw new AssertionError();
        }
        return 31 - Integer.numberOfLeadingZeros(i);
    }

    public static int mean(int i, int i2) {
        return (i & i2) + ((i ^ i2) >> 1);
    }

    public static int mod(int i, int i2) {
        if (i2 > 0) {
            int i3 = i % i2;
            return i3 >= 0 ? i3 : i3 + i2;
        }
        throw new ArithmeticException(a2.b.a.a.a.Q2("Modulus ", i2, " must be > 0"));
    }

    @GwtIncompatible
    public static int pow(int i, int i2) {
        AppCompatDelegateImpl.i.x("exponent", i2);
        if (i != -2) {
            if (i == -1) {
                return (i2 & 1) == 0 ? 1 : -1;
            }
            if (i == 0) {
                return i2 == 0 ? 1 : 0;
            }
            if (i == 1) {
                return 1;
            }
            if (i != 2) {
                int i3 = 1;
                while (i2 != 0) {
                    if (i2 == 1) {
                        return i * i3;
                    }
                    i3 *= (i2 & 1) == 0 ? 1 : i;
                    i *= i;
                    i2 >>= 1;
                }
                return i3;
            } else if (i2 < 32) {
                return 1 << i2;
            } else {
                return 0;
            }
        } else if (i2 < 32) {
            return (i2 & 1) == 0 ? 1 << i2 : -(1 << i2);
        } else {
            return 0;
        }
    }

    @Beta
    public static int saturatedAdd(int i, int i2) {
        return Ints.saturatedCast(((long) i) + ((long) i2));
    }

    @Beta
    public static int saturatedMultiply(int i, int i2) {
        return Ints.saturatedCast(((long) i) * ((long) i2));
    }

    @Beta
    public static int saturatedPow(int i, int i2) {
        AppCompatDelegateImpl.i.x("exponent", i2);
        if (i != -2) {
            if (i != -1) {
                if (i != 0) {
                    if (i == 1) {
                        return 1;
                    }
                    if (i != 2) {
                        int i3 = ((i >>> 31) & i2 & 1) + Integer.MAX_VALUE;
                        int i4 = 1;
                        while (i2 != 0) {
                            if (i2 == 1) {
                                return saturatedMultiply(i4, i);
                            }
                            if ((i2 & 1) != 0) {
                                i4 = saturatedMultiply(i4, i);
                            }
                            i2 >>= 1;
                            if (i2 > 0) {
                                if ((-46340 > i) || (i > 46340)) {
                                    return i3;
                                }
                                i *= i;
                            }
                        }
                        return i4;
                    } else if (i2 >= 31) {
                        return Integer.MAX_VALUE;
                    } else {
                        return 1 << i2;
                    }
                } else if (i2 == 0) {
                    return 1;
                } else {
                    return 0;
                }
            } else if ((i2 & 1) == 0) {
                return 1;
            } else {
                return -1;
            }
        } else if (i2 >= 32) {
            return (i2 & 1) + Integer.MAX_VALUE;
        } else {
            return (i2 & 1) == 0 ? 1 << i2 : -1 << i2;
        }
    }

    @Beta
    public static int saturatedSubtract(int i, int i2) {
        return Ints.saturatedCast(((long) i) - ((long) i2));
    }

    @GwtIncompatible
    public static int sqrt(int i, RoundingMode roundingMode) {
        int a3;
        AppCompatDelegateImpl.i.x("x", i);
        int sqrt = (int) Math.sqrt((double) i);
        switch (a.a[roundingMode.ordinal()]) {
            case 1:
                AppCompatDelegateImpl.i.F(sqrt * sqrt == i);
                return sqrt;
            case 2:
            case 3:
                return sqrt;
            case 4:
            case 5:
                a3 = a(sqrt * sqrt, i);
                return a3 + sqrt;
            case 6:
            case 7:
            case 8:
                a3 = a((sqrt * sqrt) + sqrt, i);
                return a3 + sqrt;
            default:
                throw new AssertionError();
        }
    }
}

package com.google.common.math;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Booleans;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Iterator;
@GwtCompatible(emulated = true)
public final class DoubleMath {
    public static final double a = Math.log(2.0d);
    @VisibleForTesting
    public static final double[] b = {1.0d, 2.0922789888E13d, 2.631308369336935E35d, 1.2413915592536073E61d, 1.2688693218588417E89d, 7.156945704626381E118d, 9.916779348709496E149d, 1.974506857221074E182d, 3.856204823625804E215d, 5.5502938327393044E249d, 4.7147236359920616E284d};

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
                a[RoundingMode.FLOOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[RoundingMode.CEILING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[RoundingMode.DOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[RoundingMode.UP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[RoundingMode.HALF_EVEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[RoundingMode.HALF_DOWN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    @CanIgnoreReturnValue
    @GwtIncompatible
    public static double a(double d) {
        Preconditions.checkArgument(AppCompatDelegateImpl.i.Y0(d));
        return d;
    }

    @GwtIncompatible
    public static double b(double d, RoundingMode roundingMode) {
        if (AppCompatDelegateImpl.i.Y0(d)) {
            switch (a.a[roundingMode.ordinal()]) {
                case 1:
                    AppCompatDelegateImpl.i.F(isMathematicalInteger(d));
                    return d;
                case 2:
                    return (d >= 0.0d || isMathematicalInteger(d)) ? d : (double) (((long) d) - 1);
                case 3:
                    return (d <= 0.0d || isMathematicalInteger(d)) ? d : (double) (((long) d) + 1);
                case 4:
                    return d;
                case 5:
                    if (isMathematicalInteger(d)) {
                        return d;
                    }
                    return (double) (((long) d) + ((long) (d > 0.0d ? 1 : -1)));
                case 6:
                    return Math.rint(d);
                case 7:
                    double rint = Math.rint(d);
                    return Math.abs(d - rint) == 0.5d ? Math.copySign(0.5d, d) + d : rint;
                case 8:
                    double rint2 = Math.rint(d);
                    return Math.abs(d - rint2) == 0.5d ? d : rint2;
                default:
                    throw new AssertionError();
            }
        } else {
            throw new ArithmeticException("input is infinite or NaN");
        }
    }

    public static double factorial(int i) {
        AppCompatDelegateImpl.i.x("n", i);
        if (i > 170) {
            return Double.POSITIVE_INFINITY;
        }
        double d = 1.0d;
        int i2 = i & -16;
        while (true) {
            i2++;
            if (i2 > i) {
                return d * b[i >> 4];
            }
            d *= (double) i2;
        }
    }

    public static int fuzzyCompare(double d, double d2, double d3) {
        if (fuzzyEquals(d, d2, d3)) {
            return 0;
        }
        if (d < d2) {
            return -1;
        }
        if (d > d2) {
            return 1;
        }
        return Booleans.compare(Double.isNaN(d), Double.isNaN(d2));
    }

    public static boolean fuzzyEquals(double d, double d2, double d3) {
        if (d3 >= 0.0d) {
            return Math.copySign(d - d2, 1.0d) <= d3 || d == d2 || (Double.isNaN(d) && Double.isNaN(d2));
        }
        throw new IllegalArgumentException("tolerance (" + d3 + ") must be >= 0");
    }

    @GwtIncompatible
    public static boolean isMathematicalInteger(double d) {
        return AppCompatDelegateImpl.i.Y0(d) && (d == 0.0d || 52 - Long.numberOfTrailingZeros(AppCompatDelegateImpl.i.I0(d)) <= Math.getExponent(d));
    }

    @GwtIncompatible
    public static boolean isPowerOfTwo(double d) {
        if (d <= 0.0d || !AppCompatDelegateImpl.i.Y0(d)) {
            return false;
        }
        long I0 = AppCompatDelegateImpl.i.I0(d);
        if ((I0 & (I0 - 1)) == 0) {
            return true;
        }
        return false;
    }

    public static double log2(double d) {
        return Math.log(d) / a;
    }

    @GwtIncompatible
    @Deprecated
    public static double mean(double... dArr) {
        Preconditions.checkArgument(dArr.length > 0, "Cannot take mean of 0 values");
        double d = dArr[0];
        a(d);
        long j = 1;
        for (int i = 1; i < dArr.length; i++) {
            a(dArr[i]);
            j++;
            d += (dArr[i] - d) / ((double) j);
        }
        return d;
    }

    @GwtIncompatible
    public static BigInteger roundToBigInteger(double d, RoundingMode roundingMode) {
        double b2 = b(d, roundingMode);
        boolean z = true;
        boolean z2 = -9.223372036854776E18d - b2 < 1.0d;
        if (b2 >= 9.223372036854776E18d) {
            z = false;
        }
        if (z && z2) {
            return BigInteger.valueOf((long) b2);
        }
        BigInteger shiftLeft = BigInteger.valueOf(AppCompatDelegateImpl.i.I0(b2)).shiftLeft(Math.getExponent(b2) - 52);
        return b2 < 0.0d ? shiftLeft.negate() : shiftLeft;
    }

    @GwtIncompatible
    public static int roundToInt(double d, RoundingMode roundingMode) {
        double b2 = b(d, roundingMode);
        boolean z = true;
        boolean z2 = b2 > -2.147483649E9d;
        if (b2 >= 2.147483648E9d) {
            z = false;
        }
        AppCompatDelegateImpl.i.u(z & z2, d, roundingMode);
        return (int) b2;
    }

    @GwtIncompatible
    public static long roundToLong(double d, RoundingMode roundingMode) {
        double b2 = b(d, roundingMode);
        boolean z = true;
        boolean z2 = -9.223372036854776E18d - b2 < 1.0d;
        if (b2 >= 9.223372036854776E18d) {
            z = false;
        }
        AppCompatDelegateImpl.i.u(z2 & z, d, roundingMode);
        return (long) b2;
    }

    @GwtIncompatible
    public static int log2(double d, RoundingMode roundingMode) {
        boolean z;
        boolean z2 = false;
        Preconditions.checkArgument(d > 0.0d && AppCompatDelegateImpl.i.Y0(d), "x must be positive and finite");
        int exponent = Math.getExponent(d);
        if (!(Math.getExponent(d) >= -1022)) {
            return log2(d * 4.503599627370496E15d, roundingMode) - 52;
        }
        switch (a.a[roundingMode.ordinal()]) {
            case 1:
                AppCompatDelegateImpl.i.F(isPowerOfTwo(d));
                break;
            case 2:
                break;
            case 3:
                z2 = !isPowerOfTwo(d);
                break;
            case 4:
                if (exponent < 0) {
                    z2 = true;
                }
                z = isPowerOfTwo(d);
                z2 &= !z;
                break;
            case 5:
                if (exponent >= 0) {
                    z2 = true;
                }
                z = isPowerOfTwo(d);
                z2 &= !z;
                break;
            case 6:
            case 7:
            case 8:
                double longBitsToDouble = Double.longBitsToDouble((Double.doubleToRawLongBits(d) & 4503599627370495L) | 4607182418800017408L);
                if (longBitsToDouble * longBitsToDouble > 2.0d) {
                    z2 = true;
                    break;
                }
                break;
            default:
                throw new AssertionError();
        }
        return z2 ? exponent + 1 : exponent;
    }

    @Deprecated
    public static double mean(int... iArr) {
        Preconditions.checkArgument(iArr.length > 0, "Cannot take mean of 0 values");
        long j = 0;
        for (int i : iArr) {
            j += (long) i;
        }
        return ((double) j) / ((double) iArr.length);
    }

    @Deprecated
    public static double mean(long... jArr) {
        Preconditions.checkArgument(jArr.length > 0, "Cannot take mean of 0 values");
        double d = (double) jArr[0];
        long j = 1;
        for (int i = 1; i < jArr.length; i++) {
            j++;
            d += (((double) jArr[i]) - d) / ((double) j);
        }
        return d;
    }

    @GwtIncompatible
    @Deprecated
    public static double mean(Iterable<? extends Number> iterable) {
        return mean(iterable.iterator());
    }

    @GwtIncompatible
    @Deprecated
    public static double mean(Iterator<? extends Number> it) {
        Preconditions.checkArgument(it.hasNext(), "Cannot take mean of 0 values");
        double doubleValue = ((Number) it.next()).doubleValue();
        a(doubleValue);
        long j = 1;
        while (it.hasNext()) {
            double doubleValue2 = ((Number) it.next()).doubleValue();
            a(doubleValue2);
            j++;
            doubleValue += (doubleValue2 - doubleValue) / ((double) j);
        }
        return doubleValue;
    }
}

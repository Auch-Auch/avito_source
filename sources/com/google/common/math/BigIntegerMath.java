package com.google.common.math;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
@GwtCompatible(emulated = true)
public final class BigIntegerMath {
    @VisibleForTesting
    public static final BigInteger a = new BigInteger("16a09e667f3bcc908b2fb1366ea957d3e3adec17512775099da2f590b0667322a", 16);
    public static final double b = Math.log(10.0d);
    public static final double c = Math.log(2.0d);

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

    public static BigInteger a(List<BigInteger> list, int i, int i2) {
        int i3 = i2 - i;
        if (i3 == 0) {
            return BigInteger.ONE;
        }
        if (i3 == 1) {
            return list.get(i);
        }
        if (i3 == 2) {
            return list.get(i).multiply(list.get(i + 1));
        }
        if (i3 == 3) {
            return list.get(i).multiply(list.get(i + 1)).multiply(list.get(i + 2));
        }
        int i4 = (i2 + i) >>> 1;
        return a(list, i, i4).multiply(a(list, i4, i2));
    }

    @GwtIncompatible
    public static BigInteger b(BigInteger bigInteger) {
        double d;
        BigInteger abs = bigInteger.abs();
        boolean z = true;
        int bitLength = abs.bitLength() - 1;
        if (bitLength < 63) {
            d = (double) bigInteger.longValue();
        } else if (bitLength > 1023) {
            d = ((double) bigInteger.signum()) * Double.POSITIVE_INFINITY;
        } else {
            int i = (bitLength - 52) - 1;
            long longValue = abs.shiftRight(i).longValue();
            long j = (longValue >> 1) & 4503599627370495L;
            if ((longValue & 1) == 0 || ((j & 1) == 0 && abs.getLowestSetBit() >= i)) {
                z = false;
            }
            if (z) {
                j++;
            }
            d = Double.longBitsToDouble(((((long) (bitLength + 1023)) << 52) + j) | (((long) bigInteger.signum()) & Long.MIN_VALUE));
        }
        return DoubleMath.roundToBigInteger(Math.sqrt(d), RoundingMode.HALF_EVEN);
    }

    public static BigInteger binomial(int i, int i2) {
        AppCompatDelegateImpl.i.x("n", i);
        AppCompatDelegateImpl.i.x("k", i2);
        int i3 = 1;
        Preconditions.checkArgument(i2 <= i, "k (%s) > n (%s)", i2, i);
        if (i2 > (i >> 1)) {
            i2 = i - i2;
        }
        int[] iArr = LongMath.e;
        if (i2 < iArr.length && i <= iArr[i2]) {
            return BigInteger.valueOf(LongMath.binomial(i, i2));
        }
        BigInteger bigInteger = BigInteger.ONE;
        long j = (long) i;
        long j2 = 1;
        int log2 = LongMath.log2(j, RoundingMode.CEILING);
        while (true) {
            int i4 = log2;
            while (i3 < i2) {
                int i5 = i - i3;
                i3++;
                i4 += log2;
                if (i4 >= 63) {
                    bigInteger = bigInteger.multiply(BigInteger.valueOf(j)).divide(BigInteger.valueOf(j2));
                    j = (long) i5;
                    j2 = (long) i3;
                } else {
                    j *= (long) i5;
                    j2 *= (long) i3;
                }
            }
            return bigInteger.multiply(BigInteger.valueOf(j)).divide(BigInteger.valueOf(j2));
        }
    }

    @Beta
    public static BigInteger ceilingPowerOfTwo(BigInteger bigInteger) {
        return BigInteger.ZERO.setBit(log2(bigInteger, RoundingMode.CEILING));
    }

    @GwtIncompatible
    public static BigInteger divide(BigInteger bigInteger, BigInteger bigInteger2, RoundingMode roundingMode) {
        return new BigDecimal(bigInteger).divide(new BigDecimal(bigInteger2), 0, roundingMode).toBigIntegerExact();
    }

    public static BigInteger factorial(int i) {
        AppCompatDelegateImpl.i.x("n", i);
        long[] jArr = LongMath.d;
        if (i < jArr.length) {
            return BigInteger.valueOf(jArr[i]);
        }
        ArrayList arrayList = new ArrayList(IntMath.divide(IntMath.log2(i, RoundingMode.CEILING) * i, 64, RoundingMode.CEILING));
        int length = jArr.length;
        long j = jArr[length - 1];
        int numberOfTrailingZeros = Long.numberOfTrailingZeros(j);
        long j2 = j >> numberOfTrailingZeros;
        int log2 = LongMath.log2(j2, RoundingMode.FLOOR) + 1;
        long j3 = (long) length;
        int log22 = LongMath.log2(j3, RoundingMode.FLOOR) + 1;
        int i2 = 1 << (log22 - 1);
        while (j3 <= ((long) i)) {
            if ((((long) i2) & j3) != 0) {
                i2 <<= 1;
                log22++;
            }
            int numberOfTrailingZeros2 = Long.numberOfTrailingZeros(j3);
            long j4 = j3 >> numberOfTrailingZeros2;
            numberOfTrailingZeros += numberOfTrailingZeros2;
            if ((log22 - numberOfTrailingZeros2) + log2 >= 64) {
                arrayList.add(BigInteger.valueOf(j2));
                j2 = 1;
            }
            j2 *= j4;
            log2 = LongMath.log2(j2, RoundingMode.FLOOR) + 1;
            j3++;
        }
        if (j2 > 1) {
            arrayList.add(BigInteger.valueOf(j2));
        }
        return a(arrayList, 0, arrayList.size()).shiftLeft(numberOfTrailingZeros);
    }

    @Beta
    public static BigInteger floorPowerOfTwo(BigInteger bigInteger) {
        return BigInteger.ZERO.setBit(log2(bigInteger, RoundingMode.FLOOR));
    }

    public static boolean isPowerOfTwo(BigInteger bigInteger) {
        Preconditions.checkNotNull(bigInteger);
        return bigInteger.signum() > 0 && bigInteger.getLowestSetBit() == bigInteger.bitLength() - 1;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @GwtIncompatible
    public static int log10(BigInteger bigInteger, RoundingMode roundingMode) {
        int i;
        AppCompatDelegateImpl.i.D("x", bigInteger);
        boolean z = false;
        if (bigInteger.bitLength() <= 63) {
            return LongMath.log10(bigInteger.longValue(), roundingMode);
        }
        int log2 = (int) ((((double) log2(bigInteger, RoundingMode.FLOOR)) * c) / b);
        BigInteger pow = BigInteger.TEN.pow(log2);
        int compareTo = pow.compareTo(bigInteger);
        if (compareTo > 0) {
            do {
                log2--;
                pow = pow.divide(BigInteger.TEN);
                i = pow.compareTo(bigInteger);
            } while (i > 0);
        } else {
            BigInteger multiply = BigInteger.TEN.multiply(pow);
            int compareTo2 = multiply.compareTo(bigInteger);
            BigInteger bigInteger2 = pow;
            BigInteger bigInteger3 = multiply;
            int i2 = compareTo;
            while (compareTo2 <= 0) {
                log2++;
                BigInteger multiply2 = BigInteger.TEN.multiply(bigInteger3);
                int compareTo3 = multiply2.compareTo(bigInteger);
                bigInteger2 = bigInteger3;
                bigInteger3 = multiply2;
                compareTo2 = compareTo3;
                i2 = compareTo2;
            }
            pow = bigInteger2;
            i = i2;
        }
        switch (a.a[roundingMode.ordinal()]) {
            case 1:
                if (i == 0) {
                    z = true;
                }
                AppCompatDelegateImpl.i.F(z);
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return pow.equals(bigInteger) ? log2 : log2 + 1;
            case 6:
            case 7:
            case 8:
                return bigInteger.pow(2).compareTo(pow.pow(2).multiply(BigInteger.TEN)) <= 0 ? log2 : log2 + 1;
            default:
                throw new AssertionError();
        }
        return log2;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static int log2(BigInteger bigInteger, RoundingMode roundingMode) {
        AppCompatDelegateImpl.i.D("x", (BigInteger) Preconditions.checkNotNull(bigInteger));
        int bitLength = bigInteger.bitLength() - 1;
        switch (a.a[roundingMode.ordinal()]) {
            case 1:
                AppCompatDelegateImpl.i.F(isPowerOfTwo(bigInteger));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return isPowerOfTwo(bigInteger) ? bitLength : bitLength + 1;
            case 6:
            case 7:
            case 8:
                return bitLength < 256 ? bigInteger.compareTo(a.shiftRight(256 - bitLength)) <= 0 ? bitLength : bitLength + 1 : bigInteger.pow(2).bitLength() + -1 < (bitLength * 2) + 1 ? bitLength : bitLength + 1;
            default:
                throw new AssertionError();
        }
        return bitLength;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @GwtIncompatible
    public static BigInteger sqrt(BigInteger bigInteger, RoundingMode roundingMode) {
        BigInteger bigInteger2;
        if (bigInteger.signum() >= 0) {
            boolean z = false;
            if (bigInteger.bitLength() <= 63) {
                return BigInteger.valueOf(LongMath.sqrt(bigInteger.longValue(), roundingMode));
            }
            int log2 = log2(bigInteger, RoundingMode.FLOOR);
            if (log2 < 1023) {
                bigInteger2 = b(bigInteger);
            } else {
                int i = (log2 - 52) & -2;
                bigInteger2 = b(bigInteger.shiftRight(i)).shiftLeft(i >> 1);
            }
            BigInteger shiftRight = bigInteger2.add(bigInteger.divide(bigInteger2)).shiftRight(1);
            if (!bigInteger2.equals(shiftRight)) {
                do {
                    bigInteger2 = shiftRight;
                    shiftRight = bigInteger2.add(bigInteger.divide(bigInteger2)).shiftRight(1);
                } while (shiftRight.compareTo(bigInteger2) < 0);
            }
            switch (a.a[roundingMode.ordinal()]) {
                case 1:
                    AppCompatDelegateImpl.i.F(bigInteger2.pow(2).equals(bigInteger));
                    break;
                case 2:
                case 3:
                    break;
                case 4:
                case 5:
                    int intValue = bigInteger2.intValue();
                    if (intValue * intValue == bigInteger.intValue() && bigInteger2.pow(2).equals(bigInteger)) {
                        z = true;
                    }
                    return z ? bigInteger2 : bigInteger2.add(BigInteger.ONE);
                case 6:
                case 7:
                case 8:
                    return bigInteger2.pow(2).add(bigInteger2).compareTo(bigInteger) >= 0 ? bigInteger2 : bigInteger2.add(BigInteger.ONE);
                default:
                    throw new AssertionError();
            }
            return bigInteger2;
        }
        throw new IllegalArgumentException("x (" + bigInteger + ") must be >= 0");
    }
}

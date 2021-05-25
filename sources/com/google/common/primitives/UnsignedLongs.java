package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
@Beta
@GwtCompatible
public final class UnsignedLongs {
    public static final long MAX_VALUE = -1;

    public enum a implements Comparator<long[]> {
        INSTANCE;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(long[] jArr, long[] jArr2) {
            long[] jArr3 = jArr;
            long[] jArr4 = jArr2;
            int min = Math.min(jArr3.length, jArr4.length);
            for (int i = 0; i < min; i++) {
                if (jArr3[i] != jArr4[i]) {
                    return UnsignedLongs.compare(jArr3[i], jArr4[i]);
                }
            }
            return jArr3.length - jArr4.length;
        }

        @Override // java.lang.Enum, java.lang.Object
        public String toString() {
            return "UnsignedLongs.lexicographicalComparator()";
        }
    }

    public static final class b {
        public static final long[] a = new long[37];
        public static final int[] b = new int[37];
        public static final int[] c = new int[37];

        static {
            BigInteger bigInteger = new BigInteger("10000000000000000", 16);
            for (int i = 2; i <= 36; i++) {
                long j = (long) i;
                a[i] = UnsignedLongs.divide(-1, j);
                b[i] = (int) UnsignedLongs.remainder(-1, j);
                c[i] = bigInteger.toString(i).length() - 1;
            }
        }
    }

    public static int compare(long j, long j2) {
        return Longs.compare(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE);
    }

    @CanIgnoreReturnValue
    public static long decode(String str) {
        a2.j.d.j.a a3 = a2.j.d.j.a.a(str);
        try {
            return parseUnsignedLong(a3.a, a3.b);
        } catch (NumberFormatException e) {
            NumberFormatException numberFormatException = new NumberFormatException(a2.b.a.a.a.c3("Error parsing value: ", str));
            numberFormatException.initCause(e);
            throw numberFormatException;
        }
    }

    public static long divide(long j, long j2) {
        if (j2 < 0) {
            return compare(j, j2) < 0 ? 0 : 1;
        }
        if (j >= 0) {
            return j / j2;
        }
        int i = 1;
        long j3 = ((j >>> 1) / j2) << 1;
        if (compare(j - (j3 * j2), j2) < 0) {
            i = 0;
        }
        return j3 + ((long) i);
    }

    public static String join(String str, long... jArr) {
        Preconditions.checkNotNull(str);
        if (jArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(jArr.length * 5);
        sb.append(toString(jArr[0]));
        for (int i = 1; i < jArr.length; i++) {
            sb.append(str);
            sb.append(toString(jArr[i]));
        }
        return sb.toString();
    }

    public static Comparator<long[]> lexicographicalComparator() {
        return a.INSTANCE;
    }

    public static long max(long... jArr) {
        Preconditions.checkArgument(jArr.length > 0);
        long j = jArr[0] ^ Long.MIN_VALUE;
        for (int i = 1; i < jArr.length; i++) {
            long j2 = jArr[i] ^ Long.MIN_VALUE;
            if (j2 > j) {
                j = j2;
            }
        }
        return j ^ Long.MIN_VALUE;
    }

    public static long min(long... jArr) {
        Preconditions.checkArgument(jArr.length > 0);
        long j = jArr[0] ^ Long.MIN_VALUE;
        for (int i = 1; i < jArr.length; i++) {
            long j2 = jArr[i] ^ Long.MIN_VALUE;
            if (j2 < j) {
                j = j2;
            }
        }
        return j ^ Long.MIN_VALUE;
    }

    @CanIgnoreReturnValue
    public static long parseUnsignedLong(String str) {
        return parseUnsignedLong(str, 10);
    }

    public static long remainder(long j, long j2) {
        if (j2 < 0) {
            return compare(j, j2) < 0 ? j : j - j2;
        }
        if (j >= 0) {
            return j % j2;
        }
        long j3 = j - ((((j >>> 1) / j2) << 1) * j2);
        if (compare(j3, j2) < 0) {
            j2 = 0;
        }
        return j3 - j2;
    }

    public static void sort(long[] jArr) {
        Preconditions.checkNotNull(jArr);
        sort(jArr, 0, jArr.length);
    }

    public static void sortDescending(long[] jArr) {
        Preconditions.checkNotNull(jArr);
        sortDescending(jArr, 0, jArr.length);
    }

    public static String toString(long j) {
        return toString(j, 10);
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x004e A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x005a A[SYNTHETIC] */
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long parseUnsignedLong(java.lang.String r11, int r12) {
        /*
            com.google.common.base.Preconditions.checkNotNull(r11)
            int r0 = r11.length()
            if (r0 == 0) goto L_0x0075
            r0 = 2
            if (r12 < r0) goto L_0x0069
            r0 = 36
            if (r12 > r0) goto L_0x0069
            int[] r0 = com.google.common.primitives.UnsignedLongs.b.c
            r0 = r0[r12]
            int r0 = r0 + -1
            r1 = 0
            r3 = 0
            r4 = r1
        L_0x001a:
            int r6 = r11.length()
            if (r3 >= r6) goto L_0x0068
            char r6 = r11.charAt(r3)
            int r6 = java.lang.Character.digit(r6, r12)
            r7 = -1
            if (r6 == r7) goto L_0x0062
            if (r3 <= r0) goto L_0x005a
            int r7 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r7 < 0) goto L_0x004a
            long[] r7 = com.google.common.primitives.UnsignedLongs.b.a
            r8 = r7[r12]
            int r10 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r10 >= 0) goto L_0x003a
            goto L_0x0048
        L_0x003a:
            r8 = r7[r12]
            int r7 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r7 <= 0) goto L_0x0041
            goto L_0x004a
        L_0x0041:
            int[] r7 = com.google.common.primitives.UnsignedLongs.b.b
            r7 = r7[r12]
            if (r6 <= r7) goto L_0x0048
            goto L_0x004a
        L_0x0048:
            r7 = 0
            goto L_0x004b
        L_0x004a:
            r7 = 1
        L_0x004b:
            if (r7 != 0) goto L_0x004e
            goto L_0x005a
        L_0x004e:
            java.lang.NumberFormatException r12 = new java.lang.NumberFormatException
            java.lang.String r0 = "Too large for unsigned long: "
            java.lang.String r11 = a2.b.a.a.a.c3(r0, r11)
            r12.<init>(r11)
            throw r12
        L_0x005a:
            long r7 = (long) r12
            long r4 = r4 * r7
            long r6 = (long) r6
            long r4 = r4 + r6
            int r3 = r3 + 1
            goto L_0x001a
        L_0x0062:
            java.lang.NumberFormatException r12 = new java.lang.NumberFormatException
            r12.<init>(r11)
            throw r12
        L_0x0068:
            return r4
        L_0x0069:
            java.lang.NumberFormatException r11 = new java.lang.NumberFormatException
            java.lang.String r0 = "illegal radix: "
            java.lang.String r12 = a2.b.a.a.a.M2(r0, r12)
            r11.<init>(r12)
            throw r11
        L_0x0075:
            java.lang.NumberFormatException r11 = new java.lang.NumberFormatException
            java.lang.String r12 = "empty string"
            r11.<init>(r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.primitives.UnsignedLongs.parseUnsignedLong(java.lang.String, int):long");
    }

    public static String toString(long j, int i) {
        long j2;
        Preconditions.checkArgument(i >= 2 && i <= 36, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", i);
        int i2 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i2 == 0) {
            return "0";
        }
        if (i2 > 0) {
            return Long.toString(j, i);
        }
        int i3 = 64;
        char[] cArr = new char[64];
        int i4 = i - 1;
        if ((i & i4) == 0) {
            int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i);
            do {
                i3--;
                cArr[i3] = Character.forDigit(((int) j) & i4, i);
                j >>>= numberOfTrailingZeros;
            } while (j != 0);
        } else {
            if ((i & 1) == 0) {
                j2 = (j >>> 1) / ((long) (i >>> 1));
            } else {
                j2 = divide(j, (long) i);
            }
            long j3 = (long) i;
            cArr[63] = Character.forDigit((int) (j - (j2 * j3)), i);
            i3 = 63;
            while (j2 > 0) {
                i3--;
                cArr[i3] = Character.forDigit((int) (j2 % j3), i);
                j2 /= j3;
            }
        }
        return new String(cArr, i3, 64 - i3);
    }

    public static void sort(long[] jArr, int i, int i2) {
        Preconditions.checkNotNull(jArr);
        Preconditions.checkPositionIndexes(i, i2, jArr.length);
        for (int i3 = i; i3 < i2; i3++) {
            jArr[i3] = Long.MIN_VALUE ^ jArr[i3];
        }
        Arrays.sort(jArr, i, i2);
        while (i < i2) {
            jArr[i] = jArr[i] ^ Long.MIN_VALUE;
            i++;
        }
    }

    public static void sortDescending(long[] jArr, int i, int i2) {
        Preconditions.checkNotNull(jArr);
        Preconditions.checkPositionIndexes(i, i2, jArr.length);
        for (int i3 = i; i3 < i2; i3++) {
            jArr[i3] = Long.MAX_VALUE ^ jArr[i3];
        }
        Arrays.sort(jArr, i, i2);
        while (i < i2) {
            jArr[i] = jArr[i] ^ Long.MAX_VALUE;
            i++;
        }
    }
}

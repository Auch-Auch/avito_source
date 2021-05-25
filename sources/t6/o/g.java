package t6.o;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.SinceKotlin;
import kotlin.UShort;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public class g {
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: maxOf-5PvTz6A  reason: not valid java name */
    public static final short m943maxOf5PvTz6A(short s, short s2) {
        return Intrinsics.compare(s & UShort.MAX_VALUE, 65535 & s2) >= 0 ? s : s2;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: maxOf-J1ME1BU  reason: not valid java name */
    public static final int m944maxOfJ1ME1BU(int i, int i2) {
        return UnsignedKt.uintCompare(i, i2) >= 0 ? i : i2;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: maxOf-Kr8caGY  reason: not valid java name */
    public static final byte m945maxOfKr8caGY(byte b, byte b2) {
        return Intrinsics.compare(b & 255, b2 & 255) >= 0 ? b : b2;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: maxOf-Md2H83M  reason: not valid java name */
    public static final int m946maxOfMd2H83M(int i, @NotNull int... iArr) {
        Intrinsics.checkNotNullParameter(iArr, "other");
        for (int i2 : iArr) {
            i = m944maxOfJ1ME1BU(i, i2);
        }
        return i;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: maxOf-R03FKyM  reason: not valid java name */
    public static final long m947maxOfR03FKyM(long j, @NotNull long... jArr) {
        Intrinsics.checkNotNullParameter(jArr, "other");
        for (long j2 : jArr) {
            j = m949maxOfeb3DHEI(j, j2);
        }
        return j;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: maxOf-Wr6uiD8  reason: not valid java name */
    public static final byte m948maxOfWr6uiD8(byte b, @NotNull byte... bArr) {
        Intrinsics.checkNotNullParameter(bArr, "other");
        for (byte b2 : bArr) {
            b = m945maxOfKr8caGY(b, b2);
        }
        return b;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: maxOf-eb3DHEI  reason: not valid java name */
    public static final long m949maxOfeb3DHEI(long j, long j2) {
        return UnsignedKt.ulongCompare(j, j2) >= 0 ? j : j2;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: maxOf-t1qELG4  reason: not valid java name */
    public static final short m950maxOft1qELG4(short s, @NotNull short... sArr) {
        Intrinsics.checkNotNullParameter(sArr, "other");
        for (short s2 : sArr) {
            s = m943maxOf5PvTz6A(s, s2);
        }
        return s;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: minOf-5PvTz6A  reason: not valid java name */
    public static final short m951minOf5PvTz6A(short s, short s2) {
        return Intrinsics.compare(s & UShort.MAX_VALUE, 65535 & s2) <= 0 ? s : s2;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: minOf-J1ME1BU  reason: not valid java name */
    public static final int m952minOfJ1ME1BU(int i, int i2) {
        return UnsignedKt.uintCompare(i, i2) <= 0 ? i : i2;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: minOf-Kr8caGY  reason: not valid java name */
    public static final byte m953minOfKr8caGY(byte b, byte b2) {
        return Intrinsics.compare(b & 255, b2 & 255) <= 0 ? b : b2;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: minOf-Md2H83M  reason: not valid java name */
    public static final int m954minOfMd2H83M(int i, @NotNull int... iArr) {
        Intrinsics.checkNotNullParameter(iArr, "other");
        for (int i2 : iArr) {
            i = m952minOfJ1ME1BU(i, i2);
        }
        return i;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: minOf-R03FKyM  reason: not valid java name */
    public static final long m955minOfR03FKyM(long j, @NotNull long... jArr) {
        Intrinsics.checkNotNullParameter(jArr, "other");
        for (long j2 : jArr) {
            j = m957minOfeb3DHEI(j, j2);
        }
        return j;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: minOf-Wr6uiD8  reason: not valid java name */
    public static final byte m956minOfWr6uiD8(byte b, @NotNull byte... bArr) {
        Intrinsics.checkNotNullParameter(bArr, "other");
        for (byte b2 : bArr) {
            b = m953minOfKr8caGY(b, b2);
        }
        return b;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: minOf-eb3DHEI  reason: not valid java name */
    public static final long m957minOfeb3DHEI(long j, long j2) {
        return UnsignedKt.ulongCompare(j, j2) <= 0 ? j : j2;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: minOf-t1qELG4  reason: not valid java name */
    public static final short m958minOft1qELG4(short s, @NotNull short... sArr) {
        Intrinsics.checkNotNullParameter(sArr, "other");
        for (short s2 : sArr) {
            s = m951minOf5PvTz6A(s, s2);
        }
        return s;
    }
}

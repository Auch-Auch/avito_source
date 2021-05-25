package t6.o;

import com.avito.android.remote.auth.AuthSource;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public class b extends a {
    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T extends Comparable<? super T>> T maxOf(@NotNull T t, @NotNull T t2) {
        Intrinsics.checkNotNullParameter(t, AuthSource.SEND_ABUSE);
        Intrinsics.checkNotNullParameter(t2, AuthSource.BOOKING_ORDER);
        return t.compareTo(t2) >= 0 ? t : t2;
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T extends Comparable<? super T>> T minOf(@NotNull T t, @NotNull T t2) {
        Intrinsics.checkNotNullParameter(t, AuthSource.SEND_ABUSE);
        Intrinsics.checkNotNullParameter(t2, AuthSource.BOOKING_ORDER);
        return t.compareTo(t2) <= 0 ? t : t2;
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T extends Comparable<? super T>> T maxOf(@NotNull T t, @NotNull T t2, @NotNull T t3) {
        Intrinsics.checkNotNullParameter(t, AuthSource.SEND_ABUSE);
        Intrinsics.checkNotNullParameter(t2, AuthSource.BOOKING_ORDER);
        Intrinsics.checkNotNullParameter(t3, "c");
        return (T) maxOf(t, maxOf(t2, t3));
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T extends Comparable<? super T>> T minOf(@NotNull T t, @NotNull T t2, @NotNull T t3) {
        Intrinsics.checkNotNullParameter(t, AuthSource.SEND_ABUSE);
        Intrinsics.checkNotNullParameter(t2, AuthSource.BOOKING_ORDER);
        Intrinsics.checkNotNullParameter(t3, "c");
        return (T) minOf(t, minOf(t2, t3));
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <T extends Comparable<? super T>> T maxOf(@NotNull T t, @NotNull T... tArr) {
        Intrinsics.checkNotNullParameter(t, AuthSource.SEND_ABUSE);
        Intrinsics.checkNotNullParameter(tArr, "other");
        for (T t2 : tArr) {
            t = (T) maxOf(t, t2);
        }
        return t;
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <T extends Comparable<? super T>> T minOf(@NotNull T t, @NotNull T... tArr) {
        Intrinsics.checkNotNullParameter(t, AuthSource.SEND_ABUSE);
        Intrinsics.checkNotNullParameter(tArr, "other");
        for (T t2 : tArr) {
            t = (T) minOf(t, t2);
        }
        return t;
    }

    @SinceKotlin(version = "1.4")
    public static final byte maxOf(byte b, @NotNull byte... bArr) {
        Intrinsics.checkNotNullParameter(bArr, "other");
        for (byte b2 : bArr) {
            b = (byte) Math.max((int) b, (int) b2);
        }
        return b;
    }

    @SinceKotlin(version = "1.4")
    public static final byte minOf(byte b, @NotNull byte... bArr) {
        Intrinsics.checkNotNullParameter(bArr, "other");
        for (byte b2 : bArr) {
            b = (byte) Math.min((int) b, (int) b2);
        }
        return b;
    }

    @SinceKotlin(version = "1.4")
    public static final short maxOf(short s, @NotNull short... sArr) {
        Intrinsics.checkNotNullParameter(sArr, "other");
        for (short s2 : sArr) {
            s = (short) Math.max((int) s, (int) s2);
        }
        return s;
    }

    @SinceKotlin(version = "1.4")
    public static final short minOf(short s, @NotNull short... sArr) {
        Intrinsics.checkNotNullParameter(sArr, "other");
        for (short s2 : sArr) {
            s = (short) Math.min((int) s, (int) s2);
        }
        return s;
    }

    @SinceKotlin(version = "1.4")
    public static final int maxOf(int i, @NotNull int... iArr) {
        Intrinsics.checkNotNullParameter(iArr, "other");
        for (int i2 : iArr) {
            i = Math.max(i, i2);
        }
        return i;
    }

    @SinceKotlin(version = "1.4")
    public static final int minOf(int i, @NotNull int... iArr) {
        Intrinsics.checkNotNullParameter(iArr, "other");
        for (int i2 : iArr) {
            i = Math.min(i, i2);
        }
        return i;
    }

    @SinceKotlin(version = "1.4")
    public static final long maxOf(long j, @NotNull long... jArr) {
        Intrinsics.checkNotNullParameter(jArr, "other");
        for (long j2 : jArr) {
            j = Math.max(j, j2);
        }
        return j;
    }

    @SinceKotlin(version = "1.4")
    public static final long minOf(long j, @NotNull long... jArr) {
        Intrinsics.checkNotNullParameter(jArr, "other");
        for (long j2 : jArr) {
            j = Math.min(j, j2);
        }
        return j;
    }

    @SinceKotlin(version = "1.4")
    public static final float maxOf(float f, @NotNull float... fArr) {
        Intrinsics.checkNotNullParameter(fArr, "other");
        for (float f2 : fArr) {
            f = Math.max(f, f2);
        }
        return f;
    }

    @SinceKotlin(version = "1.4")
    public static final float minOf(float f, @NotNull float... fArr) {
        Intrinsics.checkNotNullParameter(fArr, "other");
        for (float f2 : fArr) {
            f = Math.min(f, f2);
        }
        return f;
    }

    @SinceKotlin(version = "1.4")
    public static final double maxOf(double d, @NotNull double... dArr) {
        Intrinsics.checkNotNullParameter(dArr, "other");
        for (double d2 : dArr) {
            d = Math.max(d, d2);
        }
        return d;
    }

    @SinceKotlin(version = "1.4")
    public static final double minOf(double d, @NotNull double... dArr) {
        Intrinsics.checkNotNullParameter(dArr, "other");
        for (double d2 : dArr) {
            d = Math.min(d, d2);
        }
        return d;
    }
}

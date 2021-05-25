package t6.v;

import a2.b.a.a.a;
import com.avito.android.lib.design.input.FormatterType;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.ExperimentalStdlibApi;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.RandomKt;
import kotlin.ranges.CharProgression;
import kotlin.ranges.CharRange;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongProgression;
import kotlin.ranges.LongRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public class e extends d {
    @JvmName(name = "byteRangeContains")
    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", warningSince = "1.3")
    public static final boolean byteRangeContains(@NotNull ClosedRange<Byte> closedRange, double d) {
        Intrinsics.checkNotNullParameter(closedRange, "$this$contains");
        Byte byteExactOrNull = toByteExactOrNull(d);
        if (byteExactOrNull != null) {
            return closedRange.contains(byteExactOrNull);
        }
        return false;
    }

    public static final byte coerceAtLeast(byte b, byte b2) {
        return b < b2 ? b2 : b;
    }

    public static final double coerceAtLeast(double d, double d2) {
        return d < d2 ? d2 : d;
    }

    public static final float coerceAtLeast(float f, float f2) {
        return f < f2 ? f2 : f;
    }

    public static final int coerceAtLeast(int i, int i2) {
        return i < i2 ? i2 : i;
    }

    public static final long coerceAtLeast(long j, long j2) {
        return j < j2 ? j2 : j;
    }

    @NotNull
    public static final <T extends Comparable<? super T>> T coerceAtLeast(@NotNull T t, @NotNull T t2) {
        Intrinsics.checkNotNullParameter(t, "$this$coerceAtLeast");
        Intrinsics.checkNotNullParameter(t2, "minimumValue");
        return t.compareTo(t2) < 0 ? t2 : t;
    }

    public static final short coerceAtLeast(short s, short s2) {
        return s < s2 ? s2 : s;
    }

    public static final byte coerceAtMost(byte b, byte b2) {
        return b > b2 ? b2 : b;
    }

    public static final double coerceAtMost(double d, double d2) {
        return d > d2 ? d2 : d;
    }

    public static final float coerceAtMost(float f, float f2) {
        return f > f2 ? f2 : f;
    }

    public static final int coerceAtMost(int i, int i2) {
        return i > i2 ? i2 : i;
    }

    public static final long coerceAtMost(long j, long j2) {
        return j > j2 ? j2 : j;
    }

    @NotNull
    public static final <T extends Comparable<? super T>> T coerceAtMost(@NotNull T t, @NotNull T t2) {
        Intrinsics.checkNotNullParameter(t, "$this$coerceAtMost");
        Intrinsics.checkNotNullParameter(t2, "maximumValue");
        return t.compareTo(t2) > 0 ? t2 : t;
    }

    public static final short coerceAtMost(short s, short s2) {
        return s > s2 ? s2 : s;
    }

    @NotNull
    public static final <T extends Comparable<? super T>> T coerceIn(@NotNull T t, @Nullable T t2, @Nullable T t3) {
        Intrinsics.checkNotNullParameter(t, "$this$coerceIn");
        if (t2 == null || t3 == null) {
            if (t2 != null && t.compareTo(t2) < 0) {
                return t2;
            }
            if (t3 != null && t.compareTo(t3) > 0) {
                return t3;
            }
        } else if (t2.compareTo(t3) > 0) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + t3 + " is less than minimum " + t2 + FormatterType.defaultDecimalSeparator);
        } else if (t.compareTo(t2) < 0) {
            return t2;
        } else {
            if (t.compareTo(t3) > 0) {
                return t3;
            }
        }
        return t;
    }

    @JvmName(name = "doubleRangeContains")
    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", warningSince = "1.3")
    public static final boolean doubleRangeContains(@NotNull ClosedRange<Double> closedRange, byte b) {
        Intrinsics.checkNotNullParameter(closedRange, "$this$contains");
        return closedRange.contains(Double.valueOf((double) b));
    }

    @NotNull
    public static final IntProgression downTo(int i, byte b) {
        return IntProgression.Companion.fromClosedRange(i, b, -1);
    }

    @JvmName(name = "floatRangeContains")
    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", warningSince = "1.3")
    public static final boolean floatRangeContains(@NotNull ClosedRange<Float> closedRange, byte b) {
        Intrinsics.checkNotNullParameter(closedRange, "$this$contains");
        return closedRange.contains(Float.valueOf((float) b));
    }

    @JvmName(name = "intRangeContains")
    public static final boolean intRangeContains(@NotNull ClosedRange<Integer> closedRange, byte b) {
        Intrinsics.checkNotNullParameter(closedRange, "$this$contains");
        return closedRange.contains(Integer.valueOf(b));
    }

    @JvmName(name = "longRangeContains")
    public static final boolean longRangeContains(@NotNull ClosedRange<Long> closedRange, byte b) {
        Intrinsics.checkNotNullParameter(closedRange, "$this$contains");
        return closedRange.contains(Long.valueOf((long) b));
    }

    @SinceKotlin(version = "1.3")
    public static final int random(@NotNull IntRange intRange, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(intRange, "$this$random");
        Intrinsics.checkNotNullParameter(random, "random");
        try {
            return RandomKt.nextInt(random, intRange);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    public static final Integer randomOrNull(@NotNull IntRange intRange, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(intRange, "$this$randomOrNull");
        Intrinsics.checkNotNullParameter(random, "random");
        if (intRange.isEmpty()) {
            return null;
        }
        return Integer.valueOf(RandomKt.nextInt(random, intRange));
    }

    @NotNull
    public static final IntProgression reversed(@NotNull IntProgression intProgression) {
        Intrinsics.checkNotNullParameter(intProgression, "$this$reversed");
        return IntProgression.Companion.fromClosedRange(intProgression.getLast(), intProgression.getFirst(), -intProgression.getStep());
    }

    @JvmName(name = "shortRangeContains")
    public static final boolean shortRangeContains(@NotNull ClosedRange<Short> closedRange, byte b) {
        Intrinsics.checkNotNullParameter(closedRange, "$this$contains");
        return closedRange.contains(Short.valueOf((short) b));
    }

    @NotNull
    public static final IntProgression step(@NotNull IntProgression intProgression, int i) {
        Intrinsics.checkNotNullParameter(intProgression, "$this$step");
        d.checkStepIsPositive(i > 0, Integer.valueOf(i));
        IntProgression.Companion companion = IntProgression.Companion;
        int first = intProgression.getFirst();
        int last = intProgression.getLast();
        if (intProgression.getStep() <= 0) {
            i = -i;
        }
        return companion.fromClosedRange(first, last, i);
    }

    @Nullable
    public static final Byte toByteExactOrNull(int i) {
        if (-128 <= i && 127 >= i) {
            return Byte.valueOf((byte) i);
        }
        return null;
    }

    @Nullable
    public static final Integer toIntExactOrNull(long j) {
        long j2 = (long) Integer.MAX_VALUE;
        if (((long) Integer.MIN_VALUE) <= j && j2 >= j) {
            return Integer.valueOf((int) j);
        }
        return null;
    }

    @Nullable
    public static final Long toLongExactOrNull(double d) {
        double d2 = (double) Long.MAX_VALUE;
        if (d < ((double) Long.MIN_VALUE) || d > d2) {
            return null;
        }
        return Long.valueOf((long) d);
    }

    @Nullable
    public static final Short toShortExactOrNull(int i) {
        if (-32768 <= i && 32767 >= i) {
            return Short.valueOf((short) i);
        }
        return null;
    }

    @NotNull
    public static final IntRange until(int i, byte b) {
        return new IntRange(i, b - 1);
    }

    @JvmName(name = "byteRangeContains")
    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", warningSince = "1.3")
    public static final boolean byteRangeContains(@NotNull ClosedRange<Byte> closedRange, float f) {
        Intrinsics.checkNotNullParameter(closedRange, "$this$contains");
        Byte byteExactOrNull = toByteExactOrNull(f);
        if (byteExactOrNull != null) {
            return closedRange.contains(byteExactOrNull);
        }
        return false;
    }

    @JvmName(name = "doubleRangeContains")
    public static final boolean doubleRangeContains(@NotNull ClosedRange<Double> closedRange, float f) {
        Intrinsics.checkNotNullParameter(closedRange, "$this$contains");
        return closedRange.contains(Double.valueOf((double) f));
    }

    @NotNull
    public static final LongProgression downTo(long j, byte b) {
        return LongProgression.Companion.fromClosedRange(j, (long) b, -1);
    }

    @JvmName(name = "floatRangeContains")
    public static final boolean floatRangeContains(@NotNull ClosedRange<Float> closedRange, double d) {
        Intrinsics.checkNotNullParameter(closedRange, "$this$contains");
        return closedRange.contains(Float.valueOf((float) d));
    }

    @JvmName(name = "intRangeContains")
    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", warningSince = "1.3")
    public static final boolean intRangeContains(@NotNull ClosedRange<Integer> closedRange, double d) {
        Intrinsics.checkNotNullParameter(closedRange, "$this$contains");
        Integer intExactOrNull = toIntExactOrNull(d);
        if (intExactOrNull != null) {
            return closedRange.contains(intExactOrNull);
        }
        return false;
    }

    @JvmName(name = "longRangeContains")
    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", warningSince = "1.3")
    public static final boolean longRangeContains(@NotNull ClosedRange<Long> closedRange, double d) {
        Intrinsics.checkNotNullParameter(closedRange, "$this$contains");
        Long longExactOrNull = toLongExactOrNull(d);
        if (longExactOrNull != null) {
            return closedRange.contains(longExactOrNull);
        }
        return false;
    }

    @NotNull
    public static final LongProgression reversed(@NotNull LongProgression longProgression) {
        Intrinsics.checkNotNullParameter(longProgression, "$this$reversed");
        return LongProgression.Companion.fromClosedRange(longProgression.getLast(), longProgression.getFirst(), -longProgression.getStep());
    }

    @JvmName(name = "shortRangeContains")
    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", warningSince = "1.3")
    public static final boolean shortRangeContains(@NotNull ClosedRange<Short> closedRange, double d) {
        Intrinsics.checkNotNullParameter(closedRange, "$this$contains");
        Short shortExactOrNull = toShortExactOrNull(d);
        if (shortExactOrNull != null) {
            return closedRange.contains(shortExactOrNull);
        }
        return false;
    }

    @Nullable
    public static final Byte toByteExactOrNull(long j) {
        long j2 = (long) 127;
        if (((long) -128) <= j && j2 >= j) {
            return Byte.valueOf((byte) ((int) j));
        }
        return null;
    }

    @Nullable
    public static final Integer toIntExactOrNull(double d) {
        double d2 = (double) Integer.MAX_VALUE;
        if (d < ((double) Integer.MIN_VALUE) || d > d2) {
            return null;
        }
        return Integer.valueOf((int) d);
    }

    @Nullable
    public static final Long toLongExactOrNull(float f) {
        float f2 = (float) Long.MAX_VALUE;
        if (f < ((float) Long.MIN_VALUE) || f > f2) {
            return null;
        }
        return Long.valueOf((long) f);
    }

    @Nullable
    public static final Short toShortExactOrNull(long j) {
        long j2 = (long) 32767;
        if (((long) -32768) <= j && j2 >= j) {
            return Short.valueOf((short) ((int) j));
        }
        return null;
    }

    @NotNull
    public static final LongRange until(long j, byte b) {
        return new LongRange(j, ((long) b) - 1);
    }

    @JvmName(name = "byteRangeContains")
    public static final boolean byteRangeContains(@NotNull ClosedRange<Byte> closedRange, int i) {
        Intrinsics.checkNotNullParameter(closedRange, "$this$contains");
        Byte byteExactOrNull = toByteExactOrNull(i);
        if (byteExactOrNull != null) {
            return closedRange.contains(byteExactOrNull);
        }
        return false;
    }

    @JvmName(name = "doubleRangeContains")
    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", warningSince = "1.3")
    public static final boolean doubleRangeContains(@NotNull ClosedRange<Double> closedRange, int i) {
        Intrinsics.checkNotNullParameter(closedRange, "$this$contains");
        return closedRange.contains(Double.valueOf((double) i));
    }

    @NotNull
    public static final IntProgression downTo(byte b, byte b2) {
        return IntProgression.Companion.fromClosedRange(b, b2, -1);
    }

    @JvmName(name = "floatRangeContains")
    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", warningSince = "1.3")
    public static final boolean floatRangeContains(@NotNull ClosedRange<Float> closedRange, int i) {
        Intrinsics.checkNotNullParameter(closedRange, "$this$contains");
        return closedRange.contains(Float.valueOf((float) i));
    }

    @JvmName(name = "intRangeContains")
    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", warningSince = "1.3")
    public static final boolean intRangeContains(@NotNull ClosedRange<Integer> closedRange, float f) {
        Intrinsics.checkNotNullParameter(closedRange, "$this$contains");
        Integer intExactOrNull = toIntExactOrNull(f);
        if (intExactOrNull != null) {
            return closedRange.contains(intExactOrNull);
        }
        return false;
    }

    @JvmName(name = "longRangeContains")
    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", warningSince = "1.3")
    public static final boolean longRangeContains(@NotNull ClosedRange<Long> closedRange, float f) {
        Intrinsics.checkNotNullParameter(closedRange, "$this$contains");
        Long longExactOrNull = toLongExactOrNull(f);
        if (longExactOrNull != null) {
            return closedRange.contains(longExactOrNull);
        }
        return false;
    }

    @SinceKotlin(version = "1.3")
    public static final long random(@NotNull LongRange longRange, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(longRange, "$this$random");
        Intrinsics.checkNotNullParameter(random, "random");
        try {
            return RandomKt.nextLong(random, longRange);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    public static final Long randomOrNull(@NotNull LongRange longRange, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(longRange, "$this$randomOrNull");
        Intrinsics.checkNotNullParameter(random, "random");
        if (longRange.isEmpty()) {
            return null;
        }
        return Long.valueOf(RandomKt.nextLong(random, longRange));
    }

    @NotNull
    public static final CharProgression reversed(@NotNull CharProgression charProgression) {
        Intrinsics.checkNotNullParameter(charProgression, "$this$reversed");
        return CharProgression.Companion.fromClosedRange(charProgression.getLast(), charProgression.getFirst(), -charProgression.getStep());
    }

    @JvmName(name = "shortRangeContains")
    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", warningSince = "1.3")
    public static final boolean shortRangeContains(@NotNull ClosedRange<Short> closedRange, float f) {
        Intrinsics.checkNotNullParameter(closedRange, "$this$contains");
        Short shortExactOrNull = toShortExactOrNull(f);
        if (shortExactOrNull != null) {
            return closedRange.contains(shortExactOrNull);
        }
        return false;
    }

    @NotNull
    public static final LongProgression step(@NotNull LongProgression longProgression, long j) {
        Intrinsics.checkNotNullParameter(longProgression, "$this$step");
        d.checkStepIsPositive(j > 0, Long.valueOf(j));
        LongProgression.Companion companion = LongProgression.Companion;
        long first = longProgression.getFirst();
        long last = longProgression.getLast();
        if (longProgression.getStep() <= 0) {
            j = -j;
        }
        return companion.fromClosedRange(first, last, j);
    }

    @Nullable
    public static final Byte toByteExactOrNull(short s) {
        short s2 = (short) 127;
        if (((short) -128) <= s && s2 >= s) {
            return Byte.valueOf((byte) s);
        }
        return null;
    }

    @Nullable
    public static final Integer toIntExactOrNull(float f) {
        float f2 = (float) Integer.MAX_VALUE;
        if (f < ((float) Integer.MIN_VALUE) || f > f2) {
            return null;
        }
        return Integer.valueOf((int) f);
    }

    @Nullable
    public static final Short toShortExactOrNull(double d) {
        double d2 = (double) 32767;
        if (d < ((double) -32768) || d > d2) {
            return null;
        }
        return Short.valueOf((short) ((int) d));
    }

    @NotNull
    public static final IntRange until(byte b, byte b2) {
        return new IntRange(b, b2 - 1);
    }

    @JvmName(name = "byteRangeContains")
    public static final boolean byteRangeContains(@NotNull ClosedRange<Byte> closedRange, long j) {
        Intrinsics.checkNotNullParameter(closedRange, "$this$contains");
        Byte byteExactOrNull = toByteExactOrNull(j);
        if (byteExactOrNull != null) {
            return closedRange.contains(byteExactOrNull);
        }
        return false;
    }

    @JvmName(name = "doubleRangeContains")
    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", warningSince = "1.3")
    public static final boolean doubleRangeContains(@NotNull ClosedRange<Double> closedRange, long j) {
        Intrinsics.checkNotNullParameter(closedRange, "$this$contains");
        return closedRange.contains(Double.valueOf((double) j));
    }

    @NotNull
    public static final IntProgression downTo(short s, byte b) {
        return IntProgression.Companion.fromClosedRange(s, b, -1);
    }

    @JvmName(name = "floatRangeContains")
    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", warningSince = "1.3")
    public static final boolean floatRangeContains(@NotNull ClosedRange<Float> closedRange, long j) {
        Intrinsics.checkNotNullParameter(closedRange, "$this$contains");
        return closedRange.contains(Float.valueOf((float) j));
    }

    @JvmName(name = "intRangeContains")
    public static final boolean intRangeContains(@NotNull ClosedRange<Integer> closedRange, long j) {
        Intrinsics.checkNotNullParameter(closedRange, "$this$contains");
        Integer intExactOrNull = toIntExactOrNull(j);
        if (intExactOrNull != null) {
            return closedRange.contains(intExactOrNull);
        }
        return false;
    }

    @JvmName(name = "longRangeContains")
    public static final boolean longRangeContains(@NotNull ClosedRange<Long> closedRange, int i) {
        Intrinsics.checkNotNullParameter(closedRange, "$this$contains");
        return closedRange.contains(Long.valueOf((long) i));
    }

    @JvmName(name = "shortRangeContains")
    public static final boolean shortRangeContains(@NotNull ClosedRange<Short> closedRange, int i) {
        Intrinsics.checkNotNullParameter(closedRange, "$this$contains");
        Short shortExactOrNull = toShortExactOrNull(i);
        if (shortExactOrNull != null) {
            return closedRange.contains(shortExactOrNull);
        }
        return false;
    }

    @Nullable
    public static final Byte toByteExactOrNull(double d) {
        double d2 = (double) 127;
        if (d < ((double) -128) || d > d2) {
            return null;
        }
        return Byte.valueOf((byte) ((int) d));
    }

    @Nullable
    public static final Short toShortExactOrNull(float f) {
        float f2 = (float) 32767;
        if (f < ((float) -32768) || f > f2) {
            return null;
        }
        return Short.valueOf((short) ((int) f));
    }

    @NotNull
    public static final IntRange until(short s, byte b) {
        return new IntRange(s, b - 1);
    }

    @JvmName(name = "byteRangeContains")
    public static final boolean byteRangeContains(@NotNull ClosedRange<Byte> closedRange, short s) {
        Intrinsics.checkNotNullParameter(closedRange, "$this$contains");
        Byte byteExactOrNull = toByteExactOrNull(s);
        if (byteExactOrNull != null) {
            return closedRange.contains(byteExactOrNull);
        }
        return false;
    }

    @JvmName(name = "doubleRangeContains")
    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", warningSince = "1.3")
    public static final boolean doubleRangeContains(@NotNull ClosedRange<Double> closedRange, short s) {
        Intrinsics.checkNotNullParameter(closedRange, "$this$contains");
        return closedRange.contains(Double.valueOf((double) s));
    }

    @NotNull
    public static final CharProgression downTo(char c, char c2) {
        return CharProgression.Companion.fromClosedRange(c, c2, -1);
    }

    @JvmName(name = "floatRangeContains")
    @Deprecated(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @DeprecatedSinceKotlin(errorSince = "1.4", warningSince = "1.3")
    public static final boolean floatRangeContains(@NotNull ClosedRange<Float> closedRange, short s) {
        Intrinsics.checkNotNullParameter(closedRange, "$this$contains");
        return closedRange.contains(Float.valueOf((float) s));
    }

    @JvmName(name = "intRangeContains")
    public static final boolean intRangeContains(@NotNull ClosedRange<Integer> closedRange, short s) {
        Intrinsics.checkNotNullParameter(closedRange, "$this$contains");
        return closedRange.contains(Integer.valueOf(s));
    }

    @JvmName(name = "longRangeContains")
    public static final boolean longRangeContains(@NotNull ClosedRange<Long> closedRange, short s) {
        Intrinsics.checkNotNullParameter(closedRange, "$this$contains");
        return closedRange.contains(Long.valueOf((long) s));
    }

    @SinceKotlin(version = "1.3")
    public static final char random(@NotNull CharRange charRange, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(charRange, "$this$random");
        Intrinsics.checkNotNullParameter(random, "random");
        try {
            return (char) random.nextInt(charRange.getFirst(), charRange.getLast() + 1);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @Nullable
    public static final Character randomOrNull(@NotNull CharRange charRange, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(charRange, "$this$randomOrNull");
        Intrinsics.checkNotNullParameter(random, "random");
        if (charRange.isEmpty()) {
            return null;
        }
        return Character.valueOf((char) random.nextInt(charRange.getFirst(), charRange.getLast() + 1));
    }

    @JvmName(name = "shortRangeContains")
    public static final boolean shortRangeContains(@NotNull ClosedRange<Short> closedRange, long j) {
        Intrinsics.checkNotNullParameter(closedRange, "$this$contains");
        Short shortExactOrNull = toShortExactOrNull(j);
        if (shortExactOrNull != null) {
            return closedRange.contains(shortExactOrNull);
        }
        return false;
    }

    @NotNull
    public static final CharProgression step(@NotNull CharProgression charProgression, int i) {
        Intrinsics.checkNotNullParameter(charProgression, "$this$step");
        d.checkStepIsPositive(i > 0, Integer.valueOf(i));
        CharProgression.Companion companion = CharProgression.Companion;
        char first = charProgression.getFirst();
        char last = charProgression.getLast();
        if (charProgression.getStep() <= 0) {
            i = -i;
        }
        return companion.fromClosedRange(first, last, i);
    }

    @Nullable
    public static final Byte toByteExactOrNull(float f) {
        float f2 = (float) 127;
        if (f < ((float) -128) || f > f2) {
            return null;
        }
        return Byte.valueOf((byte) ((int) f));
    }

    @NotNull
    public static final CharRange until(char c, char c2) {
        if (Intrinsics.compare((int) c2, 0) <= 0) {
            return CharRange.Companion.getEMPTY();
        }
        return new CharRange(c, (char) (c2 - 1));
    }

    @NotNull
    public static final IntProgression downTo(int i, int i2) {
        return IntProgression.Companion.fromClosedRange(i, i2, -1);
    }

    public static final byte coerceIn(byte b, byte b2, byte b3) {
        if (b2 > b3) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((int) b3) + " is less than minimum " + ((int) b2) + FormatterType.defaultDecimalSeparator);
        } else if (b < b2) {
            return b2;
        } else {
            return b > b3 ? b3 : b;
        }
    }

    @NotNull
    public static final LongProgression downTo(long j, int i) {
        return LongProgression.Companion.fromClosedRange(j, (long) i, -1);
    }

    @NotNull
    public static final IntRange until(int i, int i2) {
        if (i2 <= Integer.MIN_VALUE) {
            return IntRange.Companion.getEMPTY();
        }
        return new IntRange(i, i2 - 1);
    }

    public static final short coerceIn(short s, short s2, short s3) {
        if (s2 > s3) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((int) s3) + " is less than minimum " + ((int) s2) + FormatterType.defaultDecimalSeparator);
        } else if (s < s2) {
            return s2;
        } else {
            return s > s3 ? s3 : s;
        }
    }

    @NotNull
    public static final IntProgression downTo(byte b, int i) {
        return IntProgression.Companion.fromClosedRange(b, i, -1);
    }

    public static final int coerceIn(int i, int i2, int i3) {
        if (i2 > i3) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i3 + " is less than minimum " + i2 + FormatterType.defaultDecimalSeparator);
        } else if (i < i2) {
            return i2;
        } else {
            return i > i3 ? i3 : i;
        }
    }

    @NotNull
    public static final IntProgression downTo(short s, int i) {
        return IntProgression.Companion.fromClosedRange(s, i, -1);
    }

    @NotNull
    public static final LongRange until(long j, int i) {
        return new LongRange(j, ((long) i) - 1);
    }

    public static final long coerceIn(long j, long j2, long j3) {
        if (j2 > j3) {
            throw new IllegalArgumentException(a.k(a.O("Cannot coerce value to an empty range: maximum ", j3, " is less than minimum "), j2, FormatterType.defaultDecimalSeparator));
        } else if (j < j2) {
            return j2;
        } else {
            return j > j3 ? j3 : j;
        }
    }

    @NotNull
    public static final LongProgression downTo(int i, long j) {
        return LongProgression.Companion.fromClosedRange((long) i, j, -1);
    }

    @NotNull
    public static final IntRange until(byte b, int i) {
        if (i <= Integer.MIN_VALUE) {
            return IntRange.Companion.getEMPTY();
        }
        return new IntRange(b, i - 1);
    }

    public static final float coerceIn(float f, float f2, float f3) {
        if (f2 > f3) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + f3 + " is less than minimum " + f2 + FormatterType.defaultDecimalSeparator);
        } else if (f < f2) {
            return f2;
        } else {
            return f > f3 ? f3 : f;
        }
    }

    @NotNull
    public static final LongProgression downTo(long j, long j2) {
        return LongProgression.Companion.fromClosedRange(j, j2, -1);
    }

    public static final double coerceIn(double d, double d2, double d3) {
        if (d2 > d3) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + d3 + " is less than minimum " + d2 + FormatterType.defaultDecimalSeparator);
        } else if (d < d2) {
            return d2;
        } else {
            return d > d3 ? d3 : d;
        }
    }

    @NotNull
    public static final LongProgression downTo(byte b, long j) {
        return LongProgression.Companion.fromClosedRange((long) b, j, -1);
    }

    @NotNull
    public static final IntRange until(short s, int i) {
        if (i <= Integer.MIN_VALUE) {
            return IntRange.Companion.getEMPTY();
        }
        return new IntRange(s, i - 1);
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T extends Comparable<? super T>> T coerceIn(@NotNull T t, @NotNull ClosedFloatingPointRange<T> closedFloatingPointRange) {
        Intrinsics.checkNotNullParameter(t, "$this$coerceIn");
        Intrinsics.checkNotNullParameter(closedFloatingPointRange, "range");
        if (closedFloatingPointRange.isEmpty()) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: " + closedFloatingPointRange + FormatterType.defaultDecimalSeparator);
        } else if (!closedFloatingPointRange.lessThanOrEquals(t, closedFloatingPointRange.getStart()) || closedFloatingPointRange.lessThanOrEquals(closedFloatingPointRange.getStart(), t)) {
            return (!closedFloatingPointRange.lessThanOrEquals(closedFloatingPointRange.getEndInclusive(), t) || closedFloatingPointRange.lessThanOrEquals(t, closedFloatingPointRange.getEndInclusive())) ? t : closedFloatingPointRange.getEndInclusive();
        } else {
            return closedFloatingPointRange.getStart();
        }
    }

    @NotNull
    public static final LongProgression downTo(short s, long j) {
        return LongProgression.Companion.fromClosedRange((long) s, j, -1);
    }

    @NotNull
    public static final IntProgression downTo(int i, short s) {
        return IntProgression.Companion.fromClosedRange(i, s, -1);
    }

    @NotNull
    public static final LongRange until(int i, long j) {
        if (j <= Long.MIN_VALUE) {
            return LongRange.Companion.getEMPTY();
        }
        return new LongRange((long) i, j - 1);
    }

    @NotNull
    public static final LongProgression downTo(long j, short s) {
        return LongProgression.Companion.fromClosedRange(j, (long) s, -1);
    }

    @NotNull
    public static final IntProgression downTo(byte b, short s) {
        return IntProgression.Companion.fromClosedRange(b, s, -1);
    }

    @NotNull
    public static final LongRange until(long j, long j2) {
        if (j2 <= Long.MIN_VALUE) {
            return LongRange.Companion.getEMPTY();
        }
        return new LongRange(j, j2 - 1);
    }

    @NotNull
    public static final <T extends Comparable<? super T>> T coerceIn(@NotNull T t, @NotNull ClosedRange<T> closedRange) {
        Intrinsics.checkNotNullParameter(t, "$this$coerceIn");
        Intrinsics.checkNotNullParameter(closedRange, "range");
        if (closedRange instanceof ClosedFloatingPointRange) {
            return (T) coerceIn((Comparable) t, (ClosedFloatingPointRange) closedRange);
        }
        if (closedRange.isEmpty()) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: " + closedRange + FormatterType.defaultDecimalSeparator);
        } else if (t.compareTo(closedRange.getStart()) < 0) {
            return closedRange.getStart();
        } else {
            return t.compareTo(closedRange.getEndInclusive()) > 0 ? closedRange.getEndInclusive() : t;
        }
    }

    @NotNull
    public static final IntProgression downTo(short s, short s2) {
        return IntProgression.Companion.fromClosedRange(s, s2, -1);
    }

    @NotNull
    public static final LongRange until(byte b, long j) {
        if (j <= Long.MIN_VALUE) {
            return LongRange.Companion.getEMPTY();
        }
        return new LongRange((long) b, j - 1);
    }

    @NotNull
    public static final LongRange until(short s, long j) {
        if (j <= Long.MIN_VALUE) {
            return LongRange.Companion.getEMPTY();
        }
        return new LongRange((long) s, j - 1);
    }

    @NotNull
    public static final IntRange until(int i, short s) {
        return new IntRange(i, s - 1);
    }

    public static final int coerceIn(int i, @NotNull ClosedRange<Integer> closedRange) {
        Intrinsics.checkNotNullParameter(closedRange, "range");
        if (closedRange instanceof ClosedFloatingPointRange) {
            return ((Number) coerceIn(Integer.valueOf(i), (ClosedFloatingPointRange<Integer>) ((ClosedFloatingPointRange) closedRange))).intValue();
        }
        if (closedRange.isEmpty()) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: " + closedRange + FormatterType.defaultDecimalSeparator);
        } else if (i < closedRange.getStart().intValue()) {
            return closedRange.getStart().intValue();
        } else {
            return i > closedRange.getEndInclusive().intValue() ? closedRange.getEndInclusive().intValue() : i;
        }
    }

    @NotNull
    public static final LongRange until(long j, short s) {
        return new LongRange(j, ((long) s) - 1);
    }

    @NotNull
    public static final IntRange until(byte b, short s) {
        return new IntRange(b, s - 1);
    }

    @NotNull
    public static final IntRange until(short s, short s2) {
        return new IntRange(s, s2 - 1);
    }

    public static final long coerceIn(long j, @NotNull ClosedRange<Long> closedRange) {
        Intrinsics.checkNotNullParameter(closedRange, "range");
        if (closedRange instanceof ClosedFloatingPointRange) {
            return ((Number) coerceIn(Long.valueOf(j), (ClosedFloatingPointRange<Long>) ((ClosedFloatingPointRange) closedRange))).longValue();
        }
        if (closedRange.isEmpty()) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: " + closedRange + FormatterType.defaultDecimalSeparator);
        } else if (j < closedRange.getStart().longValue()) {
            return closedRange.getStart().longValue();
        } else {
            return j > closedRange.getEndInclusive().longValue() ? closedRange.getEndInclusive().longValue() : j;
        }
    }
}

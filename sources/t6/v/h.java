package t6.v;

import a2.b.a.a.a;
import com.avito.android.lib.design.input.FormatterType;
import java.util.NoSuchElementException;
import kotlin.ExperimentalStdlibApi;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.UnsignedKt;
import kotlin.WasExperimental;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.URandomKt;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.UIntProgression;
import kotlin.ranges.UIntRange;
import kotlin.ranges.ULongProgression;
import kotlin.ranges.ULongRange;
import okhttp3.internal.ws.WebSocketProtocol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongycastle.asn1.cmc.BodyPartID;
public class h {
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: coerceAtLeast-5PvTz6A  reason: not valid java name */
    public static final short m959coerceAtLeast5PvTz6A(short s, short s2) {
        return Intrinsics.compare(s & UShort.MAX_VALUE, 65535 & s2) < 0 ? s2 : s;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: coerceAtLeast-J1ME1BU  reason: not valid java name */
    public static final int m960coerceAtLeastJ1ME1BU(int i, int i2) {
        return UnsignedKt.uintCompare(i, i2) < 0 ? i2 : i;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: coerceAtLeast-Kr8caGY  reason: not valid java name */
    public static final byte m961coerceAtLeastKr8caGY(byte b, byte b2) {
        return Intrinsics.compare(b & 255, b2 & 255) < 0 ? b2 : b;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: coerceAtLeast-eb3DHEI  reason: not valid java name */
    public static final long m962coerceAtLeasteb3DHEI(long j, long j2) {
        return UnsignedKt.ulongCompare(j, j2) < 0 ? j2 : j;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: coerceAtMost-5PvTz6A  reason: not valid java name */
    public static final short m963coerceAtMost5PvTz6A(short s, short s2) {
        return Intrinsics.compare(s & UShort.MAX_VALUE, 65535 & s2) > 0 ? s2 : s;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: coerceAtMost-J1ME1BU  reason: not valid java name */
    public static final int m964coerceAtMostJ1ME1BU(int i, int i2) {
        return UnsignedKt.uintCompare(i, i2) > 0 ? i2 : i;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: coerceAtMost-Kr8caGY  reason: not valid java name */
    public static final byte m965coerceAtMostKr8caGY(byte b, byte b2) {
        return Intrinsics.compare(b & 255, b2 & 255) > 0 ? b2 : b;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: coerceAtMost-eb3DHEI  reason: not valid java name */
    public static final long m966coerceAtMosteb3DHEI(long j, long j2) {
        return UnsignedKt.ulongCompare(j, j2) > 0 ? j2 : j;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: coerceIn-JPwROB0  reason: not valid java name */
    public static final long m967coerceInJPwROB0(long j, @NotNull ClosedRange<ULong> closedRange) {
        Intrinsics.checkNotNullParameter(closedRange, "range");
        if (closedRange instanceof ClosedFloatingPointRange) {
            return ((ULong) e.coerceIn(ULong.m301boximpl(j), (ClosedFloatingPointRange<ULong>) ((ClosedFloatingPointRange) closedRange))).m307unboximpl();
        }
        if (closedRange.isEmpty()) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: " + closedRange + FormatterType.defaultDecimalSeparator);
        } else if (UnsignedKt.ulongCompare(j, closedRange.getStart().m307unboximpl()) < 0) {
            return closedRange.getStart().m307unboximpl();
        } else {
            return UnsignedKt.ulongCompare(j, closedRange.getEndInclusive().m307unboximpl()) > 0 ? closedRange.getEndInclusive().m307unboximpl() : j;
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: coerceIn-VKSA0NQ  reason: not valid java name */
    public static final short m968coerceInVKSA0NQ(short s, short s2, short s3) {
        int i = s2 & UShort.MAX_VALUE;
        int i2 = s3 & UShort.MAX_VALUE;
        if (Intrinsics.compare(i, i2) <= 0) {
            int i3 = 65535 & s;
            if (Intrinsics.compare(i3, i) < 0) {
                return s2;
            }
            return Intrinsics.compare(i3, i2) > 0 ? s3 : s;
        }
        StringBuilder L = a.L("Cannot coerce value to an empty range: maximum ");
        L.append(UShort.m331toStringimpl(s3));
        L.append(" is less than minimum ");
        L.append(UShort.m331toStringimpl(s2));
        L.append(FormatterType.defaultDecimalSeparator);
        throw new IllegalArgumentException(L.toString());
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: coerceIn-WZ9TVnA  reason: not valid java name */
    public static final int m969coerceInWZ9TVnA(int i, int i2, int i3) {
        if (UnsignedKt.uintCompare(i2, i3) > 0) {
            StringBuilder L = a.L("Cannot coerce value to an empty range: maximum ");
            L.append(UInt.m281toStringimpl(i3));
            L.append(" is less than minimum ");
            L.append(UInt.m281toStringimpl(i2));
            L.append(FormatterType.defaultDecimalSeparator);
            throw new IllegalArgumentException(L.toString());
        } else if (UnsignedKt.uintCompare(i, i2) < 0) {
            return i2;
        } else {
            return UnsignedKt.uintCompare(i, i3) > 0 ? i3 : i;
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: coerceIn-b33U2AM  reason: not valid java name */
    public static final byte m970coerceInb33U2AM(byte b, byte b2, byte b3) {
        int i = b2 & 255;
        int i2 = b3 & 255;
        if (Intrinsics.compare(i, i2) <= 0) {
            int i3 = b & 255;
            if (Intrinsics.compare(i3, i) < 0) {
                return b2;
            }
            return Intrinsics.compare(i3, i2) > 0 ? b3 : b;
        }
        StringBuilder L = a.L("Cannot coerce value to an empty range: maximum ");
        L.append(UByte.m256toStringimpl(b3));
        L.append(" is less than minimum ");
        L.append(UByte.m256toStringimpl(b2));
        L.append(FormatterType.defaultDecimalSeparator);
        throw new IllegalArgumentException(L.toString());
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: coerceIn-sambcqE  reason: not valid java name */
    public static final long m971coerceInsambcqE(long j, long j2, long j3) {
        if (UnsignedKt.ulongCompare(j2, j3) > 0) {
            StringBuilder L = a.L("Cannot coerce value to an empty range: maximum ");
            L.append(ULong.m306toStringimpl(j3));
            L.append(" is less than minimum ");
            L.append(ULong.m306toStringimpl(j2));
            L.append(FormatterType.defaultDecimalSeparator);
            throw new IllegalArgumentException(L.toString());
        } else if (UnsignedKt.ulongCompare(j, j2) < 0) {
            return j2;
        } else {
            return UnsignedKt.ulongCompare(j, j3) > 0 ? j3 : j;
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: coerceIn-wuiCnnA  reason: not valid java name */
    public static final int m972coerceInwuiCnnA(int i, @NotNull ClosedRange<UInt> closedRange) {
        Intrinsics.checkNotNullParameter(closedRange, "range");
        if (closedRange instanceof ClosedFloatingPointRange) {
            return ((UInt) e.coerceIn(UInt.m276boximpl(i), (ClosedFloatingPointRange<UInt>) ((ClosedFloatingPointRange) closedRange))).m282unboximpl();
        }
        if (closedRange.isEmpty()) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: " + closedRange + FormatterType.defaultDecimalSeparator);
        } else if (UnsignedKt.uintCompare(i, closedRange.getStart().m282unboximpl()) < 0) {
            return closedRange.getStart().m282unboximpl();
        } else {
            return UnsignedKt.uintCompare(i, closedRange.getEndInclusive().m282unboximpl()) > 0 ? closedRange.getEndInclusive().m282unboximpl() : i;
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: contains-68kG9v0  reason: not valid java name */
    public static final boolean m973contains68kG9v0(@NotNull UIntRange uIntRange, byte b) {
        Intrinsics.checkNotNullParameter(uIntRange, "$this$contains");
        return uIntRange.m413containsWZ4Q5Ns(UInt.m277constructorimpl(b & 255));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: contains-Gab390E  reason: not valid java name */
    public static final boolean m974containsGab390E(@NotNull ULongRange uLongRange, int i) {
        Intrinsics.checkNotNullParameter(uLongRange, "$this$contains");
        return uLongRange.m419containsVKZWuLQ(ULong.m302constructorimpl(((long) i) & BodyPartID.bodyIdMax));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: contains-ULb-yJY  reason: not valid java name */
    public static final boolean m975containsULbyJY(@NotNull ULongRange uLongRange, byte b) {
        Intrinsics.checkNotNullParameter(uLongRange, "$this$contains");
        return uLongRange.m419containsVKZWuLQ(ULong.m302constructorimpl(((long) b) & 255));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: contains-ZsK3CEQ  reason: not valid java name */
    public static final boolean m976containsZsK3CEQ(@NotNull UIntRange uIntRange, short s) {
        Intrinsics.checkNotNullParameter(uIntRange, "$this$contains");
        return uIntRange.m413containsWZ4Q5Ns(UInt.m277constructorimpl(s & UShort.MAX_VALUE));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: contains-fz5IDCE  reason: not valid java name */
    public static final boolean m977containsfz5IDCE(@NotNull UIntRange uIntRange, long j) {
        Intrinsics.checkNotNullParameter(uIntRange, "$this$contains");
        return ULong.m302constructorimpl(j >>> 32) == 0 && uIntRange.m413containsWZ4Q5Ns(UInt.m277constructorimpl((int) j));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: contains-uhHAxoY  reason: not valid java name */
    public static final boolean m978containsuhHAxoY(@NotNull ULongRange uLongRange, short s) {
        Intrinsics.checkNotNullParameter(uLongRange, "$this$contains");
        return uLongRange.m419containsVKZWuLQ(ULong.m302constructorimpl(((long) s) & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: downTo-5PvTz6A  reason: not valid java name */
    public static final UIntProgression m979downTo5PvTz6A(short s, short s2) {
        return UIntProgression.Companion.m412fromClosedRangeNkh28Cs(UInt.m277constructorimpl(s & UShort.MAX_VALUE), UInt.m277constructorimpl(s2 & UShort.MAX_VALUE), -1);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: downTo-J1ME1BU  reason: not valid java name */
    public static final UIntProgression m980downToJ1ME1BU(int i, int i2) {
        return UIntProgression.Companion.m412fromClosedRangeNkh28Cs(i, i2, -1);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: downTo-Kr8caGY  reason: not valid java name */
    public static final UIntProgression m981downToKr8caGY(byte b, byte b2) {
        return UIntProgression.Companion.m412fromClosedRangeNkh28Cs(UInt.m277constructorimpl(b & 255), UInt.m277constructorimpl(b2 & 255), -1);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: downTo-eb3DHEI  reason: not valid java name */
    public static final ULongProgression m982downToeb3DHEI(long j, long j2) {
        return ULongProgression.Companion.m418fromClosedRange7ftBX0g(j, j2, -1);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final int random(@NotNull UIntRange uIntRange, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(uIntRange, "$this$random");
        Intrinsics.checkNotNullParameter(random, "random");
        try {
            return URandomKt.nextUInt(random, uIntRange);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final UInt randomOrNull(@NotNull UIntRange uIntRange, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(uIntRange, "$this$randomOrNull");
        Intrinsics.checkNotNullParameter(random, "random");
        if (uIntRange.isEmpty()) {
            return null;
        }
        return UInt.m276boximpl(URandomKt.nextUInt(random, uIntRange));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final UIntProgression reversed(@NotNull UIntProgression uIntProgression) {
        Intrinsics.checkNotNullParameter(uIntProgression, "$this$reversed");
        return UIntProgression.Companion.m412fromClosedRangeNkh28Cs(uIntProgression.m411getLastpVg5ArA(), uIntProgression.m410getFirstpVg5ArA(), -uIntProgression.getStep());
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final UIntProgression step(@NotNull UIntProgression uIntProgression, int i) {
        Intrinsics.checkNotNullParameter(uIntProgression, "$this$step");
        d.checkStepIsPositive(i > 0, Integer.valueOf(i));
        UIntProgression.Companion companion = UIntProgression.Companion;
        int r1 = uIntProgression.m410getFirstpVg5ArA();
        int r2 = uIntProgression.m411getLastpVg5ArA();
        if (uIntProgression.getStep() <= 0) {
            i = -i;
        }
        return companion.m412fromClosedRangeNkh28Cs(r1, r2, i);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: until-5PvTz6A  reason: not valid java name */
    public static final UIntRange m983until5PvTz6A(short s, short s2) {
        int i = s2 & UShort.MAX_VALUE;
        if (Intrinsics.compare(i, 0) <= 0) {
            return UIntRange.Companion.getEMPTY();
        }
        return new UIntRange(UInt.m277constructorimpl(s & UShort.MAX_VALUE), UInt.m277constructorimpl(UInt.m277constructorimpl(i) - 1), null);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: until-J1ME1BU  reason: not valid java name */
    public static final UIntRange m984untilJ1ME1BU(int i, int i2) {
        if (UnsignedKt.uintCompare(i2, 0) <= 0) {
            return UIntRange.Companion.getEMPTY();
        }
        return new UIntRange(i, UInt.m277constructorimpl(i2 - 1), null);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: until-Kr8caGY  reason: not valid java name */
    public static final UIntRange m985untilKr8caGY(byte b, byte b2) {
        int i = b2 & 255;
        if (Intrinsics.compare(i, 0) <= 0) {
            return UIntRange.Companion.getEMPTY();
        }
        return new UIntRange(UInt.m277constructorimpl(b & 255), UInt.m277constructorimpl(UInt.m277constructorimpl(i) - 1), null);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: until-eb3DHEI  reason: not valid java name */
    public static final ULongRange m986untileb3DHEI(long j, long j2) {
        if (UnsignedKt.ulongCompare(j2, 0) <= 0) {
            return ULongRange.Companion.getEMPTY();
        }
        return new ULongRange(j, ULong.m302constructorimpl(j2 - ULong.m302constructorimpl(((long) 1) & BodyPartID.bodyIdMax)), null);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final ULongProgression reversed(@NotNull ULongProgression uLongProgression) {
        Intrinsics.checkNotNullParameter(uLongProgression, "$this$reversed");
        return ULongProgression.Companion.m418fromClosedRange7ftBX0g(uLongProgression.m417getLastsVKNKU(), uLongProgression.m416getFirstsVKNKU(), -uLongProgression.getStep());
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final long random(@NotNull ULongRange uLongRange, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(uLongRange, "$this$random");
        Intrinsics.checkNotNullParameter(random, "random");
        try {
            return URandomKt.nextULong(random, uLongRange);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    @Nullable
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final ULong randomOrNull(@NotNull ULongRange uLongRange, @NotNull Random random) {
        Intrinsics.checkNotNullParameter(uLongRange, "$this$randomOrNull");
        Intrinsics.checkNotNullParameter(random, "random");
        if (uLongRange.isEmpty()) {
            return null;
        }
        return ULong.m301boximpl(URandomKt.nextULong(random, uLongRange));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final ULongProgression step(@NotNull ULongProgression uLongProgression, long j) {
        Intrinsics.checkNotNullParameter(uLongProgression, "$this$step");
        d.checkStepIsPositive(j > 0, Long.valueOf(j));
        ULongProgression.Companion companion = ULongProgression.Companion;
        long r5 = uLongProgression.m416getFirstsVKNKU();
        long r7 = uLongProgression.m417getLastsVKNKU();
        if (uLongProgression.getStep() <= 0) {
            j = -j;
        }
        return companion.m418fromClosedRange7ftBX0g(r5, r7, j);
    }
}

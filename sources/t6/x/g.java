package t6.x;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
public class g {
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @JvmName(name = "sumOfUByte")
    public static final int sumOfUByte(@NotNull Sequence<UByte> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$sum");
        int i = 0;
        for (UByte uByte : sequence) {
            i = UInt.m277constructorimpl(UInt.m277constructorimpl(uByte.m257unboximpl() & 255) + i);
        }
        return i;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @JvmName(name = "sumOfUInt")
    public static final int sumOfUInt(@NotNull Sequence<UInt> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$sum");
        int i = 0;
        for (UInt uInt : sequence) {
            i = UInt.m277constructorimpl(uInt.m282unboximpl() + i);
        }
        return i;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @JvmName(name = "sumOfULong")
    public static final long sumOfULong(@NotNull Sequence<ULong> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$sum");
        long j = 0;
        for (ULong uLong : sequence) {
            j = ULong.m302constructorimpl(uLong.m307unboximpl() + j);
        }
        return j;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @JvmName(name = "sumOfUShort")
    public static final int sumOfUShort(@NotNull Sequence<UShort> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "$this$sum");
        int i = 0;
        for (UShort uShort : sequence) {
            i = UInt.m277constructorimpl(UInt.m277constructorimpl(uShort.m332unboximpl() & UShort.MAX_VALUE) + i);
        }
        return i;
    }
}

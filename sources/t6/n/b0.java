package t6.n;

import java.util.Collection;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public class b0 {
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @JvmName(name = "sumOfUByte")
    public static final int sumOfUByte(@NotNull Iterable<UByte> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$sum");
        int i = 0;
        for (UByte uByte : iterable) {
            i = UInt.m277constructorimpl(UInt.m277constructorimpl(uByte.m257unboximpl() & 255) + i);
        }
        return i;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @JvmName(name = "sumOfUInt")
    public static final int sumOfUInt(@NotNull Iterable<UInt> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$sum");
        int i = 0;
        for (UInt uInt : iterable) {
            i = UInt.m277constructorimpl(uInt.m282unboximpl() + i);
        }
        return i;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @JvmName(name = "sumOfULong")
    public static final long sumOfULong(@NotNull Iterable<ULong> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$sum");
        long j = 0;
        for (ULong uLong : iterable) {
            j = ULong.m302constructorimpl(uLong.m307unboximpl() + j);
        }
        return j;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @JvmName(name = "sumOfUShort")
    public static final int sumOfUShort(@NotNull Iterable<UShort> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "$this$sum");
        int i = 0;
        for (UShort uShort : iterable) {
            i = UInt.m277constructorimpl(UInt.m277constructorimpl(uShort.m332unboximpl() & UShort.MAX_VALUE) + i);
        }
        return i;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final byte[] toUByteArray(@NotNull Collection<UByte> collection) {
        Intrinsics.checkNotNullParameter(collection, "$this$toUByteArray");
        byte[] r0 = UByteArray.m259constructorimpl(collection.size());
        int i = 0;
        for (UByte uByte : collection) {
            UByteArray.m270setVurrAj0(r0, i, uByte.m257unboximpl());
            i++;
        }
        return r0;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final int[] toUIntArray(@NotNull Collection<UInt> collection) {
        Intrinsics.checkNotNullParameter(collection, "$this$toUIntArray");
        int[] r0 = UIntArray.m284constructorimpl(collection.size());
        int i = 0;
        for (UInt uInt : collection) {
            UIntArray.m295setVXSXFK8(r0, i, uInt.m282unboximpl());
            i++;
        }
        return r0;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final long[] toULongArray(@NotNull Collection<ULong> collection) {
        Intrinsics.checkNotNullParameter(collection, "$this$toULongArray");
        long[] r0 = ULongArray.m309constructorimpl(collection.size());
        int i = 0;
        for (ULong uLong : collection) {
            ULongArray.m320setk8EXiF4(r0, i, uLong.m307unboximpl());
            i++;
        }
        return r0;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final short[] toUShortArray(@NotNull Collection<UShort> collection) {
        Intrinsics.checkNotNullParameter(collection, "$this$toUShortArray");
        short[] r0 = UShortArray.m334constructorimpl(collection.size());
        int i = 0;
        for (UShort uShort : collection) {
            UShortArray.m345set01HTLdE(r0, i, uShort.m332unboximpl());
            i++;
        }
        return r0;
    }
}

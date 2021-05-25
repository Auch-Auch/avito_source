package kotlin.random;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
import kotlin.ranges.ULongRange;
import org.jetbrains.annotations.NotNull;
import org.spongycastle.asn1.cmc.BodyPartID;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\u001a\u0016\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001e\u0010\u0002\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a&\u0010\u0002\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001e\u0010\u0002\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\f\u001a\u0016\u0010\u000e\u001a\u00020\r*\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001e\u0010\u000e\u001a\u00020\r*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a&\u0010\u000e\u001a\u00020\r*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001e\u0010\u000e\u001a\u00020\r*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0014H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u0015\u001a\u001e\u0010\u001a\u001a\u00020\u0016*\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0016H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u001e\u0010\u001a\u001a\u00020\u0016*\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001d\u001a2\u0010\u001a\u001a\u00020\u0016*\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u001e\u001a\u00020\u001b2\b\b\u0002\u0010\u001f\u001a\u00020\u001bH\u0007ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001a\"\u0010%\u001a\u00020\"2\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a\"\u0010(\u001a\u00020\"2\u0006\u0010\u0007\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\rH\u0001ø\u0001\u0000¢\u0006\u0004\b&\u0010'\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, d2 = {"Lkotlin/random/Random;", "Lkotlin/UInt;", "nextUInt", "(Lkotlin/random/Random;)I", "until", "nextUInt-qCasIEU", "(Lkotlin/random/Random;I)I", "from", "nextUInt-a8DCA5k", "(Lkotlin/random/Random;II)I", "Lkotlin/ranges/UIntRange;", "range", "(Lkotlin/random/Random;Lkotlin/ranges/UIntRange;)I", "Lkotlin/ULong;", "nextULong", "(Lkotlin/random/Random;)J", "nextULong-V1Xi4fY", "(Lkotlin/random/Random;J)J", "nextULong-jmpaW-c", "(Lkotlin/random/Random;JJ)J", "Lkotlin/ranges/ULongRange;", "(Lkotlin/random/Random;Lkotlin/ranges/ULongRange;)J", "Lkotlin/UByteArray;", "array", "nextUBytes-EVgfTAA", "(Lkotlin/random/Random;[B)[B", "nextUBytes", "", "size", "(Lkotlin/random/Random;I)[B", "fromIndex", "toIndex", "nextUBytes-Wvrt4B4", "(Lkotlin/random/Random;[BII)[B", "", "checkUIntRangeBounds-J1ME1BU", "(II)V", "checkUIntRangeBounds", "checkULongRangeBounds-eb3DHEI", "(JJ)V", "checkULongRangeBounds", "kotlin-stdlib"}, k = 2, mv = {1, 4, 1})
public final class URandomKt {
    @ExperimentalUnsignedTypes
    /* renamed from: checkUIntRangeBounds-J1ME1BU  reason: not valid java name */
    public static final void m401checkUIntRangeBoundsJ1ME1BU(int i, int i2) {
        if (!(UnsignedKt.uintCompare(i2, i) > 0)) {
            throw new IllegalArgumentException(RandomKt.boundsErrorMessage(UInt.m276boximpl(i), UInt.m276boximpl(i2)).toString());
        }
    }

    @ExperimentalUnsignedTypes
    /* renamed from: checkULongRangeBounds-eb3DHEI  reason: not valid java name */
    public static final void m402checkULongRangeBoundseb3DHEI(long j, long j2) {
        if (!(UnsignedKt.ulongCompare(j2, j) > 0)) {
            throw new IllegalArgumentException(RandomKt.boundsErrorMessage(ULong.m301boximpl(j), ULong.m301boximpl(j2)).toString());
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    public static final byte[] nextUBytes(@NotNull Random random, int i) {
        Intrinsics.checkNotNullParameter(random, "$this$nextUBytes");
        return UByteArray.m260constructorimpl(random.nextBytes(i));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: nextUBytes-EVgfTAA  reason: not valid java name */
    public static final byte[] m403nextUBytesEVgfTAA(@NotNull Random random, @NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(random, "$this$nextUBytes");
        Intrinsics.checkNotNullParameter(bArr, "array");
        random.nextBytes(bArr);
        return bArr;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @NotNull
    /* renamed from: nextUBytes-Wvrt4B4  reason: not valid java name */
    public static final byte[] m404nextUBytesWvrt4B4(@NotNull Random random, @NotNull byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(random, "$this$nextUBytes");
        Intrinsics.checkNotNullParameter(bArr, "array");
        random.nextBytes(bArr, i, i2);
        return bArr;
    }

    /* renamed from: nextUBytes-Wvrt4B4$default  reason: not valid java name */
    public static /* synthetic */ byte[] m405nextUBytesWvrt4B4$default(Random random, byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = UByteArray.m266getSizeimpl(bArr);
        }
        return m404nextUBytesWvrt4B4(random, bArr, i, i2);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final int nextUInt(@NotNull Random random) {
        Intrinsics.checkNotNullParameter(random, "$this$nextUInt");
        return UInt.m277constructorimpl(random.nextInt());
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: nextUInt-a8DCA5k  reason: not valid java name */
    public static final int m406nextUInta8DCA5k(@NotNull Random random, int i, int i2) {
        Intrinsics.checkNotNullParameter(random, "$this$nextUInt");
        m401checkUIntRangeBoundsJ1ME1BU(i, i2);
        return UInt.m277constructorimpl(random.nextInt(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE) ^ Integer.MIN_VALUE);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: nextUInt-qCasIEU  reason: not valid java name */
    public static final int m407nextUIntqCasIEU(@NotNull Random random, int i) {
        Intrinsics.checkNotNullParameter(random, "$this$nextUInt");
        return m406nextUInta8DCA5k(random, 0, i);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final long nextULong(@NotNull Random random) {
        Intrinsics.checkNotNullParameter(random, "$this$nextULong");
        return ULong.m302constructorimpl(random.nextLong());
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: nextULong-V1Xi4fY  reason: not valid java name */
    public static final long m408nextULongV1Xi4fY(@NotNull Random random, long j) {
        Intrinsics.checkNotNullParameter(random, "$this$nextULong");
        return m409nextULongjmpaWc(random, 0, j);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: nextULong-jmpaW-c  reason: not valid java name */
    public static final long m409nextULongjmpaWc(@NotNull Random random, long j, long j2) {
        Intrinsics.checkNotNullParameter(random, "$this$nextULong");
        m402checkULongRangeBoundseb3DHEI(j, j2);
        return ULong.m302constructorimpl(random.nextLong(j ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE) ^ Long.MIN_VALUE);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final int nextUInt(@NotNull Random random, @NotNull UIntRange uIntRange) {
        Intrinsics.checkNotNullParameter(random, "$this$nextUInt");
        Intrinsics.checkNotNullParameter(uIntRange, "range");
        if (uIntRange.isEmpty()) {
            throw new IllegalArgumentException("Cannot get random in empty range: " + uIntRange);
        } else if (UnsignedKt.uintCompare(uIntRange.m411getLastpVg5ArA(), -1) < 0) {
            return m406nextUInta8DCA5k(random, uIntRange.m410getFirstpVg5ArA(), UInt.m277constructorimpl(uIntRange.m411getLastpVg5ArA() + 1));
        } else {
            if (UnsignedKt.uintCompare(uIntRange.m410getFirstpVg5ArA(), 0) > 0) {
                return UInt.m277constructorimpl(m406nextUInta8DCA5k(random, UInt.m277constructorimpl(uIntRange.m410getFirstpVg5ArA() - 1), uIntRange.m411getLastpVg5ArA()) + 1);
            }
            return nextUInt(random);
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    public static final long nextULong(@NotNull Random random, @NotNull ULongRange uLongRange) {
        Intrinsics.checkNotNullParameter(random, "$this$nextULong");
        Intrinsics.checkNotNullParameter(uLongRange, "range");
        if (uLongRange.isEmpty()) {
            throw new IllegalArgumentException("Cannot get random in empty range: " + uLongRange);
        } else if (UnsignedKt.ulongCompare(uLongRange.m417getLastsVKNKU(), -1) < 0) {
            return m409nextULongjmpaWc(random, uLongRange.m416getFirstsVKNKU(), ULong.m302constructorimpl(ULong.m302constructorimpl(((long) 1) & BodyPartID.bodyIdMax) + uLongRange.m417getLastsVKNKU()));
        } else if (UnsignedKt.ulongCompare(uLongRange.m416getFirstsVKNKU(), 0) <= 0) {
            return nextULong(random);
        } else {
            long r4 = uLongRange.m416getFirstsVKNKU();
            long j = ((long) 1) & BodyPartID.bodyIdMax;
            return ULong.m302constructorimpl(ULong.m302constructorimpl(j) + m409nextULongjmpaWc(random, ULong.m302constructorimpl(r4 - ULong.m302constructorimpl(j)), uLongRange.m417getLastsVKNKU()));
        }
    }
}

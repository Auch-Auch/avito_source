package kotlin;

import com.vk.sdk.api.VKApiConst;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.spongycastle.asn1.cmc.BodyPartID;
import t6.y.a;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\u001f\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001f\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\u0006\u0010\u0007\u001a\"\u0010\n\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\bH\u0001ø\u0001\u0000¢\u0006\u0004\b\t\u0010\u0004\u001a\"\u0010\f\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\bH\u0001ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\u0004\u001a\"\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0001\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\rH\u0001ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\"\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0001\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\rH\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u000f\u001a\u001a\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001a\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0013H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0017\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0000H\u0001¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0017\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u001f\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u001e\u0010!\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"", "v1", "v2", "uintCompare", "(II)I", "", "ulongCompare", "(JJ)I", "Lkotlin/UInt;", "uintDivide-J1ME1BU", "uintDivide", "uintRemainder-J1ME1BU", "uintRemainder", "Lkotlin/ULong;", "ulongDivide-eb3DHEI", "(JJ)J", "ulongDivide", "ulongRemainder-eb3DHEI", "ulongRemainder", "", VKApiConst.VERSION, "doubleToUInt", "(D)I", "doubleToULong", "(D)J", "uintToDouble", "(I)D", "ulongToDouble", "(J)D", "", "ulongToString", "(J)Ljava/lang/String;", "base", "(JI)Ljava/lang/String;", "kotlin-stdlib"}, k = 2, mv = {1, 4, 1})
@JvmName(name = "UnsignedKt")
public final class UnsignedKt {
    @PublishedApi
    public static final int doubleToUInt(double d) {
        if (Double.isNaN(d) || d <= uintToDouble(0)) {
            return 0;
        }
        if (d >= uintToDouble(-1)) {
            return -1;
        }
        double d2 = (double) Integer.MAX_VALUE;
        if (d <= d2) {
            return UInt.m277constructorimpl((int) d);
        }
        return UInt.m277constructorimpl(UInt.m277constructorimpl(Integer.MAX_VALUE) + UInt.m277constructorimpl((int) (d - d2)));
    }

    @PublishedApi
    public static final long doubleToULong(double d) {
        if (Double.isNaN(d) || d <= ulongToDouble(0)) {
            return 0;
        }
        if (d >= ulongToDouble(-1)) {
            return -1;
        }
        if (d < ((double) Long.MAX_VALUE)) {
            return ULong.m302constructorimpl((long) d);
        }
        return ULong.m302constructorimpl(ULong.m302constructorimpl((long) (d - 9.223372036854776E18d)) - Long.MIN_VALUE);
    }

    @PublishedApi
    public static final int uintCompare(int i, int i2) {
        return Intrinsics.compare(i ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE);
    }

    @PublishedApi
    /* renamed from: uintDivide-J1ME1BU  reason: not valid java name */
    public static final int m351uintDivideJ1ME1BU(int i, int i2) {
        return UInt.m277constructorimpl((int) ((((long) i) & BodyPartID.bodyIdMax) / (((long) i2) & BodyPartID.bodyIdMax)));
    }

    @PublishedApi
    /* renamed from: uintRemainder-J1ME1BU  reason: not valid java name */
    public static final int m352uintRemainderJ1ME1BU(int i, int i2) {
        return UInt.m277constructorimpl((int) ((((long) i) & BodyPartID.bodyIdMax) % (((long) i2) & BodyPartID.bodyIdMax)));
    }

    @PublishedApi
    public static final double uintToDouble(int i) {
        return (((double) ((i >>> 31) << 30)) * ((double) 2)) + ((double) (Integer.MAX_VALUE & i));
    }

    @PublishedApi
    public static final int ulongCompare(long j, long j2) {
        return ((j ^ Long.MIN_VALUE) > (j2 ^ Long.MIN_VALUE) ? 1 : ((j ^ Long.MIN_VALUE) == (j2 ^ Long.MIN_VALUE) ? 0 : -1));
    }

    @PublishedApi
    /* renamed from: ulongDivide-eb3DHEI  reason: not valid java name */
    public static final long m353ulongDivideeb3DHEI(long j, long j2) {
        if (j2 < 0) {
            return ulongCompare(j, j2) < 0 ? ULong.m302constructorimpl(0) : ULong.m302constructorimpl(1);
        }
        if (j >= 0) {
            return ULong.m302constructorimpl(j / j2);
        }
        int i = 1;
        long j3 = ((j >>> 1) / j2) << 1;
        if (ulongCompare(ULong.m302constructorimpl(j - (j3 * j2)), ULong.m302constructorimpl(j2)) < 0) {
            i = 0;
        }
        return ULong.m302constructorimpl(j3 + ((long) i));
    }

    @PublishedApi
    /* renamed from: ulongRemainder-eb3DHEI  reason: not valid java name */
    public static final long m354ulongRemaindereb3DHEI(long j, long j2) {
        if (j2 < 0) {
            return ulongCompare(j, j2) < 0 ? j : ULong.m302constructorimpl(j - j2);
        }
        if (j >= 0) {
            return ULong.m302constructorimpl(j % j2);
        }
        long j3 = j - ((((j >>> 1) / j2) << 1) * j2);
        if (ulongCompare(ULong.m302constructorimpl(j3), ULong.m302constructorimpl(j2)) < 0) {
            j2 = 0;
        }
        return ULong.m302constructorimpl(j3 - j2);
    }

    @PublishedApi
    public static final double ulongToDouble(long j) {
        return (((double) (j >>> 11)) * ((double) 2048)) + ((double) (j & 2047));
    }

    @NotNull
    public static final String ulongToString(long j) {
        return ulongToString(j, 10);
    }

    @NotNull
    public static final String ulongToString(long j, int i) {
        if (j >= 0) {
            String l = Long.toString(j, a.checkRadix(i));
            Intrinsics.checkNotNullExpressionValue(l, "java.lang.Long.toString(this, checkRadix(radix))");
            return l;
        }
        long j2 = (long) i;
        long j3 = ((j >>> 1) / j2) << 1;
        long j4 = j - (j3 * j2);
        if (j4 >= j2) {
            j4 -= j2;
            j3++;
        }
        StringBuilder sb = new StringBuilder();
        String l2 = Long.toString(j3, a.checkRadix(i));
        Intrinsics.checkNotNullExpressionValue(l2, "java.lang.Long.toString(this, checkRadix(radix))");
        sb.append(l2);
        String l3 = Long.toString(j4, a.checkRadix(i));
        Intrinsics.checkNotNullExpressionValue(l3, "java.lang.Long.toString(this, checkRadix(radix))");
        sb.append(l3);
        return sb.toString();
    }
}

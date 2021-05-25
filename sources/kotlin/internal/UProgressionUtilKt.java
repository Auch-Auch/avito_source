package kotlin.internal;

import com.avito.android.remote.auth.AuthSource;
import com.yandex.mobile.ads.video.tracking.Tracker;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UnsignedKt;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\u001a*\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0001\u0010\u0004\u001a*\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0005H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0006\u001a*\u0010\f\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH\u0001ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\u0004\u001a*\u0010\f\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\rH\u0001ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lkotlin/UInt;", AuthSource.SEND_ABUSE, AuthSource.BOOKING_ORDER, "c", "(III)I", "Lkotlin/ULong;", "(JJJ)J", Tracker.Events.CREATIVE_START, "end", "", AnalyticFieldsName.step, "getProgressionLastElement-Nkh28Cs", "getProgressionLastElement", "", "getProgressionLastElement-7ftBX0g", "kotlin-stdlib"}, k = 2, mv = {1, 4, 1})
public final class UProgressionUtilKt {
    public static final int a(int i, int i2, int i3) {
        int r1 = UnsignedKt.m352uintRemainderJ1ME1BU(i, i3);
        int r2 = UnsignedKt.m352uintRemainderJ1ME1BU(i2, i3);
        int uintCompare = UnsignedKt.uintCompare(r1, r2);
        int r12 = UInt.m277constructorimpl(r1 - r2);
        return uintCompare >= 0 ? r12 : UInt.m277constructorimpl(r12 + i3);
    }

    public static final long b(long j, long j2, long j3) {
        long r1 = UnsignedKt.m354ulongRemaindereb3DHEI(j, j3);
        long r3 = UnsignedKt.m354ulongRemaindereb3DHEI(j2, j3);
        int ulongCompare = UnsignedKt.ulongCompare(r1, r3);
        long r12 = ULong.m302constructorimpl(r1 - r3);
        return ulongCompare >= 0 ? r12 : ULong.m302constructorimpl(r12 + j3);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    /* renamed from: getProgressionLastElement-7ftBX0g  reason: not valid java name */
    public static final long m399getProgressionLastElement7ftBX0g(long j, long j2, long j3) {
        int i = (j3 > 0 ? 1 : (j3 == 0 ? 0 : -1));
        if (i > 0) {
            if (UnsignedKt.ulongCompare(j, j2) >= 0) {
                return j2;
            }
            return ULong.m302constructorimpl(j2 - b(j2, j, ULong.m302constructorimpl(j3)));
        } else if (i < 0) {
            return UnsignedKt.ulongCompare(j, j2) <= 0 ? j2 : ULong.m302constructorimpl(b(j, j2, ULong.m302constructorimpl(-j3)) + j2);
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    /* renamed from: getProgressionLastElement-Nkh28Cs  reason: not valid java name */
    public static final int m400getProgressionLastElementNkh28Cs(int i, int i2, int i3) {
        if (i3 > 0) {
            if (UnsignedKt.uintCompare(i, i2) >= 0) {
                return i2;
            }
            return UInt.m277constructorimpl(i2 - a(i2, i, UInt.m277constructorimpl(i3)));
        } else if (i3 < 0) {
            return UnsignedKt.uintCompare(i, i2) <= 0 ? i2 : UInt.m277constructorimpl(a(i, i2, UInt.m277constructorimpl(-i3)) + i2);
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
    }
}

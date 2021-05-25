package kotlin.internal;

import com.avito.android.remote.auth.AuthSource;
import com.yandex.mobile.ads.video.tracking.Tracker;
import kotlin.Metadata;
import kotlin.PublishedApi;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\u001a\u001f\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0001\u0010\u0003\u001a\u001f\u0010\u0002\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0002\u0010\u0005\u001a'\u0010\t\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0000H\u0001¢\u0006\u0004\b\t\u0010\n\u001a'\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\t\u0010\u000b¨\u0006\f"}, d2 = {"", AuthSource.SEND_ABUSE, AuthSource.BOOKING_ORDER, "(II)I", "", "(JJ)J", Tracker.Events.CREATIVE_START, "end", AnalyticFieldsName.step, "getProgressionLastElement", "(III)I", "(JJJ)J", "kotlin-stdlib"}, k = 2, mv = {1, 4, 1})
public final class ProgressionUtilKt {
    public static final int a(int i, int i2) {
        int i3 = i % i2;
        return i3 >= 0 ? i3 : i3 + i2;
    }

    public static final long b(long j, long j2) {
        long j3 = j % j2;
        return j3 >= 0 ? j3 : j3 + j2;
    }

    @PublishedApi
    public static final int getProgressionLastElement(int i, int i2, int i3) {
        if (i3 > 0) {
            if (i >= i2) {
                return i2;
            }
            return i2 - a(a(i2, i3) - a(i, i3), i3);
        } else if (i3 >= 0) {
            throw new IllegalArgumentException("Step is zero.");
        } else if (i <= i2) {
            return i2;
        } else {
            int i4 = -i3;
            return i2 + a(a(i, i4) - a(i2, i4), i4);
        }
    }

    @PublishedApi
    public static final long getProgressionLastElement(long j, long j2, long j3) {
        int i = (j3 > 0 ? 1 : (j3 == 0 ? 0 : -1));
        if (i > 0) {
            if (j >= j2) {
                return j2;
            }
            return j2 - b(b(j2, j3) - b(j, j3), j3);
        } else if (i >= 0) {
            throw new IllegalArgumentException("Step is zero.");
        } else if (j <= j2) {
            return j2;
        } else {
            long j4 = -j3;
            return j2 + b(b(j, j4) - b(j2, j4), j4);
        }
    }
}

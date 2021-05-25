package kotlinx.coroutines;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlinx.coroutines.internal.Symbol;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0017\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0005\u0010\u0003\"\u001c\u0010\u000b\u001a\u00020\u00068\u0002@\u0003X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u0012\u0004\b\t\u0010\n\"\u001c\u0010\u000e\u001a\u00020\u00068\u0002@\u0003X\u0004¢\u0006\f\n\u0004\b\f\u0010\b\u0012\u0004\b\r\u0010\n*\u001e\b\u0002\u0010\u0011\u001a\u0004\b\u0000\u0010\u000f\"\b\u0012\u0004\u0012\u00028\u00000\u00102\b\u0012\u0004\u0012\u00028\u00000\u0010¨\u0006\u0012"}, d2 = {"", "timeMillis", "delayToNanos", "(J)J", "timeNanos", "delayNanosToMillis", "Lkotlinx/coroutines/internal/Symbol;", AuthSource.BOOKING_ORDER, "Lkotlinx/coroutines/internal/Symbol;", "getCLOSED_EMPTY$annotations", "()V", "CLOSED_EMPTY", AuthSource.SEND_ABUSE, "getDISPOSED_TASK$annotations", "DISPOSED_TASK", "T", "Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "Queue", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
public final class EventLoop_commonKt {
    public static final Symbol a = new Symbol("REMOVED_TASK");
    public static final Symbol b = new Symbol("CLOSED_EMPTY");

    public static final long delayNanosToMillis(long j) {
        return j / 1000000;
    }

    public static final long delayToNanos(long j) {
        if (j <= 0) {
            return 0;
        }
        if (j >= 9223372036854L) {
            return Long.MAX_VALUE;
        }
        return 1000000 * j;
    }
}

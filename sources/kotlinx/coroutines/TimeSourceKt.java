package kotlinx.coroutines;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\b\"$\u0010\u0007\u001a\u0004\u0018\u00010\u00008\u0000@\u0000X\u000e¢\u0006\u0012\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/TimeSource;", AuthSource.SEND_ABUSE, "Lkotlinx/coroutines/TimeSource;", "getTimeSource", "()Lkotlinx/coroutines/TimeSource;", "setTimeSource", "(Lkotlinx/coroutines/TimeSource;)V", "timeSource", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
public final class TimeSourceKt {
    @Nullable
    public static TimeSource a;

    @Nullable
    public static final TimeSource getTimeSource() {
        return a;
    }

    public static final void setTimeSource(@Nullable TimeSource timeSource) {
        a = timeSource;
    }
}

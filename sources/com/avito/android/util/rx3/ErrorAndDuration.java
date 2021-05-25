package com.avito.android.util.rx3;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/util/rx3/ErrorAndDuration;", "", "", AuthSource.BOOKING_ORDER, "J", "getDurationMs", "()J", "durationMs", "", AuthSource.SEND_ABUSE, "Ljava/lang/Throwable;", "getThrowable", "()Ljava/lang/Throwable;", "throwable", "<init>", "(Ljava/lang/Throwable;J)V", "rx"}, k = 1, mv = {1, 4, 2})
public final class ErrorAndDuration {
    @NotNull
    public final Throwable a;
    public final long b;

    public ErrorAndDuration(@NotNull Throwable th, long j) {
        Intrinsics.checkNotNullParameter(th, "throwable");
        this.a = th;
        this.b = j;
    }

    public final long getDurationMs() {
        return this.b;
    }

    @NotNull
    public final Throwable getThrowable() {
        return this.a;
    }
}

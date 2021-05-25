package com.avito.android.server_time;

import com.avito.android.remote.auth.AuthSource;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u000e\u001a\u00020\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/server_time/UtcTimeSource;", "Lcom/avito/android/server_time/TimeSource;", "", "now", "()J", "timeout", "", "sleep", "(J)V", "Ljava/util/TimeZone;", AuthSource.SEND_ABUSE, "Ljava/util/TimeZone;", "getTimeZone", "()Ljava/util/TimeZone;", "timeZone", AuthSource.BOOKING_ORDER, "Lcom/avito/android/server_time/TimeSource;", "timeSource", "<init>", "(Lcom/avito/android/server_time/TimeSource;)V", "server-time_release"}, k = 1, mv = {1, 4, 2})
public final class UtcTimeSource implements TimeSource {
    @NotNull
    public final TimeZone a;
    public final TimeSource b;

    public UtcTimeSource(@NotNull TimeSource timeSource) {
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        this.b = timeSource;
        TimeZone timeZone = TimeZone.getTimeZone("UTC");
        Intrinsics.checkNotNullExpressionValue(timeZone, "TimeZone.getTimeZone(\"UTC\")");
        this.a = timeZone;
    }

    @Override // com.avito.android.server_time.TimeSource
    @NotNull
    public TimeZone getTimeZone() {
        return this.a;
    }

    @Override // com.avito.android.server_time.TimeSource
    public long now() {
        return this.b.now();
    }

    @Override // com.avito.android.server_time.TimeSource
    public void sleep(long j) {
        this.b.sleep(j);
    }
}

package com.avito.android.server_time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\b¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/server_time/TimeSource;", "", "nowInSeconds", "(Lcom/avito/android/server_time/TimeSource;)J", "server-time_release"}, k = 2, mv = {1, 4, 2})
public final class TimeSourceKt {
    public static final long nowInSeconds(@NotNull TimeSource timeSource) {
        Intrinsics.checkNotNullParameter(timeSource, "$this$nowInSeconds");
        return TimeUnit.SECONDS.convert(timeSource.now(), TimeUnit.MILLISECONDS);
    }
}

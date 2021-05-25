package com.avito.android.server_time;

import com.avito.android.remote.model.category_parameters.FormattedDateDisplayingType;
import com.avito.android.util.CalendarsKt;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/server_time/TimeSource;", "", "getTodayMidnightInSeconds", "(Lcom/avito/android/server_time/TimeSource;)J", "server-time_release"}, k = 2, mv = {1, 4, 2})
public final class TimeSourcesKt {
    public static final long getTodayMidnightInSeconds(@NotNull TimeSource timeSource) {
        Intrinsics.checkNotNullParameter(timeSource, "$this$getTodayMidnightInSeconds");
        Calendar instance = Calendar.getInstance(timeSource.getTimeZone());
        Intrinsics.checkNotNullExpressionValue(instance, FormattedDateDisplayingType.TYPE_CALENDAR);
        instance.setTimeInMillis(timeSource.now());
        CalendarsKt.clearTime(instance);
        return TimeUnit.MILLISECONDS.toSeconds(instance.getTimeInMillis());
    }
}

package com.avito.android.util;

import com.vk.sdk.api.VKApiConst;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0011\u0010\u0005\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0003¨\u0006\u0006"}, d2 = {"Ljava/util/Calendar;", "", "clearTime", "(Ljava/util/Calendar;)V", "clearDayOfMonth", "clearHourOfDay", VKApiConst.LANG}, k = 2, mv = {1, 4, 2})
public final class CalendarsKt {
    public static final void clearDayOfMonth(@NotNull Calendar calendar) {
        Intrinsics.checkNotNullParameter(calendar, "$this$clearDayOfMonth");
        calendar.set(5, calendar.getActualMinimum(5));
    }

    public static final void clearHourOfDay(@NotNull Calendar calendar) {
        Intrinsics.checkNotNullParameter(calendar, "$this$clearHourOfDay");
        calendar.set(11, calendar.getActualMinimum(11));
    }

    public static final void clearTime(@NotNull Calendar calendar) {
        Intrinsics.checkNotNullParameter(calendar, "$this$clearTime");
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
    }
}

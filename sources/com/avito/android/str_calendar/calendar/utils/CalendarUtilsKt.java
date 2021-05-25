package com.avito.android.str_calendar.calendar.utils;

import com.avito.android.util.CalendarsKt;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\u001a\r\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0015\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0001\u0010\u0005\u001a\u0011\u0010\u0006\u001a\u00020\u0003*\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ljava/util/Calendar;", "getCalendar", "()Ljava/util/Calendar;", "", "timeInSeconds", "(J)Ljava/util/Calendar;", "secondsToMills", "(J)J", "str-calendar_release"}, k = 2, mv = {1, 4, 2})
public final class CalendarUtilsKt {
    @NotNull
    public static final Calendar getCalendar() {
        Calendar instance = GregorianCalendar.getInstance(new Locale("ru", "RU"));
        CalendarsKt.clearTime(instance);
        Intrinsics.checkNotNullExpressionValue(instance, "GregorianCalendar.getIns…\")).apply { clearTime() }");
        return instance;
    }

    public static final long secondsToMills(long j) {
        return j * 1000;
    }

    @NotNull
    public static final Calendar getCalendar(long j) {
        Calendar instance = GregorianCalendar.getInstance(new Locale("ru", "RU"));
        instance.setTime(new Date(secondsToMills(j)));
        CalendarsKt.clearTime(instance);
        Intrinsics.checkNotNullExpressionValue(instance, "GregorianCalendar.getIns…ills())\n    clearTime()\n}");
        return instance;
    }
}

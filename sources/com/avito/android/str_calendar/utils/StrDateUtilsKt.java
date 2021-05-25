package com.avito.android.str_calendar.utils;

import a2.b.a.a.a;
import com.avito.android.str_calendar.calendar.utils.CalendarUtilsKt;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0000*\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0011\u0010\u0006\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0003\u001a\u0011\u0010\u0007\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0007\u0010\u0003\u001a\u0011\u0010\b\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\b\u0010\u0003\u001a\u0011\u0010\n\u001a\u00020\u0001*\u00020\t¢\u0006\u0004\b\n\u0010\u000b\u001a\u0011\u0010\f\u001a\u00020\u0001*\u00020\t¢\u0006\u0004\b\f\u0010\u000b\u001a\u0011\u0010\u000e\u001a\u00020\r*\u00020\t¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Ljava/util/Date;", "", "convertToStrDate", "(Ljava/util/Date;)Ljava/lang/String;", "convertStrDateToDate", "(Ljava/lang/String;)Ljava/util/Date;", "convertStrDateToDMMMM", "convertStrDateToDMMM", "convertStrDateToD", "Lcom/avito/android/str_calendar/utils/DateRange;", "getTitle", "(Lcom/avito/android/str_calendar/utils/DateRange;)Ljava/lang/String;", "getHotelsFilterText", "", "calculateNightsBetween", "(Lcom/avito/android/str_calendar/utils/DateRange;)I", "str-calendar_release"}, k = 2, mv = {1, 4, 2})
public final class StrDateUtilsKt {
    public static final int calculateNightsBetween(@NotNull DateRange dateRange) {
        Intrinsics.checkNotNullParameter(dateRange, "$this$calculateNightsBetween");
        return (int) TimeUnit.DAYS.convert(dateRange.getEndInclusive().getTime() - dateRange.getStart().getTime(), TimeUnit.MILLISECONDS);
    }

    @NotNull
    public static final String convertStrDateToD(@NotNull Date date) {
        Intrinsics.checkNotNullParameter(date, "$this$convertStrDateToD");
        String format = new SimpleDateFormat("d", Locale.getDefault()).format(date);
        Intrinsics.checkNotNullExpressionValue(format, "formatter.format(this)");
        return format;
    }

    @NotNull
    public static final String convertStrDateToDMMM(@NotNull Date date) {
        Intrinsics.checkNotNullParameter(date, "$this$convertStrDateToDMMM");
        String format = new SimpleDateFormat("d MMM", Locale.getDefault()).format(date);
        Intrinsics.checkNotNullExpressionValue(format, "formatter.format(this)");
        return format;
    }

    @NotNull
    public static final String convertStrDateToDMMMM(@NotNull Date date) {
        Intrinsics.checkNotNullParameter(date, "$this$convertStrDateToDMMMM");
        String format = new SimpleDateFormat("d MMMM", Locale.getDefault()).format(date);
        Intrinsics.checkNotNullExpressionValue(format, "formatter.format(this)");
        return format;
    }

    @NotNull
    public static final Date convertStrDateToDate(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "$this$convertStrDateToDate");
        Date parse = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(str);
        Intrinsics.checkNotNullExpressionValue(parse, "formatter.parse(this)");
        return parse;
    }

    @NotNull
    public static final String convertToStrDate(@NotNull Date date) {
        Intrinsics.checkNotNullParameter(date, "$this$convertToStrDate");
        String format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(date);
        Intrinsics.checkNotNullExpressionValue(format, "formatter.format(this)");
        return format;
    }

    @NotNull
    public static final String getHotelsFilterText(@NotNull DateRange dateRange) {
        Intrinsics.checkNotNullParameter(dateRange, "$this$getHotelsFilterText");
        Calendar calendar = CalendarUtilsKt.getCalendar();
        Calendar calendar2 = CalendarUtilsKt.getCalendar();
        calendar.setTime(dateRange.getStart());
        calendar2.setTime(dateRange.getEndInclusive());
        if (calendar.get(2) == calendar2.get(2)) {
            return a.H(new Object[]{convertStrDateToD(dateRange.getStart()), convertStrDateToDMMM(dateRange.getEndInclusive())}, 2, "%s–%s, ", "java.lang.String.format(format, *args)");
        }
        return a.H(new Object[]{convertStrDateToDMMM(dateRange.getStart()), convertStrDateToDMMM(dateRange.getEndInclusive())}, 2, "%s – %s, ", "java.lang.String.format(format, *args)");
    }

    @NotNull
    public static final String getTitle(@NotNull DateRange dateRange) {
        Intrinsics.checkNotNullParameter(dateRange, "$this$getTitle");
        Calendar calendar = CalendarUtilsKt.getCalendar();
        Calendar calendar2 = CalendarUtilsKt.getCalendar();
        calendar.setTime(dateRange.getStart());
        calendar2.setTime(dateRange.getEndInclusive());
        if (calendar.get(2) == calendar2.get(2)) {
            return a.H(new Object[]{convertStrDateToD(dateRange.getStart()), convertStrDateToDMMMM(dateRange.getEndInclusive())}, 2, "%s–%s", "java.lang.String.format(format, *args)");
        }
        return a.H(new Object[]{convertStrDateToDMMM(dateRange.getStart()), convertStrDateToDMMM(dateRange.getEndInclusive())}, 2, "%s – %s", "java.lang.String.format(format, *args)");
    }
}

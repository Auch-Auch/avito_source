package com.avito.android.str_calendar.calendar.view.data;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/str_calendar/calendar/view/data/CalendarDataSourceProvider;", "T", "", "data", "Lcom/avito/android/str_calendar/calendar/view/data/CalendarDataSource;", "getDataSource", "(Ljava/lang/Object;)Lcom/avito/android/str_calendar/calendar/view/data/CalendarDataSource;", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public interface CalendarDataSourceProvider<T> {
    @NotNull
    CalendarDataSource getDataSource(T t);
}

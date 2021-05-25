package com.avito.android.str_calendar.booking.data;

import com.avito.android.str_calendar.calendar.view.data.items.CalendarItemState;
import com.avito.android.str_calendar.utils.DateRange;
import java.util.Date;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J/\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\b\u0010\tJ#\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/str_calendar/booking/data/BookingCalendarDayStateProvider;", "", "Ljava/util/Date;", "day", "selectedDate", "Lcom/avito/android/str_calendar/utils/DateRange;", "selectedRange", "Lcom/avito/android/str_calendar/calendar/view/data/items/CalendarItemState;", "getDayState", "(Ljava/util/Date;Ljava/util/Date;Lcom/avito/android/str_calendar/utils/DateRange;)Lcom/avito/android/str_calendar/calendar/view/data/items/CalendarItemState;", "nextDate", "getEmptyItemState", "(Ljava/util/Date;Lcom/avito/android/str_calendar/utils/DateRange;)Lcom/avito/android/str_calendar/calendar/view/data/items/CalendarItemState;", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public interface BookingCalendarDayStateProvider {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ CalendarItemState getDayState$default(BookingCalendarDayStateProvider bookingCalendarDayStateProvider, Date date, Date date2, DateRange dateRange, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    date2 = null;
                }
                if ((i & 4) != 0) {
                    dateRange = null;
                }
                return bookingCalendarDayStateProvider.getDayState(date, date2, dateRange);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getDayState");
        }

        public static /* synthetic */ CalendarItemState getEmptyItemState$default(BookingCalendarDayStateProvider bookingCalendarDayStateProvider, Date date, DateRange dateRange, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    dateRange = null;
                }
                return bookingCalendarDayStateProvider.getEmptyItemState(date, dateRange);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getEmptyItemState");
        }
    }

    @NotNull
    CalendarItemState getDayState(@NotNull Date date, @Nullable Date date2, @Nullable DateRange dateRange);

    @NotNull
    CalendarItemState getEmptyItemState(@NotNull Date date, @Nullable DateRange dateRange);
}

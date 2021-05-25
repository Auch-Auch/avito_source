package com.avito.android.str_calendar.booking.data;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.str_calendar.calendar.utils.CalendarUtilsKt;
import com.avito.android.str_calendar.calendar.view.checker.CalendarAvailabilityChecker;
import com.avito.android.str_calendar.calendar.view.data.items.CalendarItemState;
import com.avito.android.str_calendar.utils.DateRange;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015J+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ!\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/str_calendar/booking/data/BookingCalendarDayStateProviderImpl;", "Lcom/avito/android/str_calendar/booking/data/BookingCalendarDayStateProvider;", "Ljava/util/Date;", "day", "selectedDate", "Lcom/avito/android/str_calendar/utils/DateRange;", "selectedRange", "Lcom/avito/android/str_calendar/calendar/view/data/items/CalendarItemState;", "getDayState", "(Ljava/util/Date;Ljava/util/Date;Lcom/avito/android/str_calendar/utils/DateRange;)Lcom/avito/android/str_calendar/calendar/view/data/items/CalendarItemState;", "nextDate", "getEmptyItemState", "(Ljava/util/Date;Lcom/avito/android/str_calendar/utils/DateRange;)Lcom/avito/android/str_calendar/calendar/view/data/items/CalendarItemState;", AuthSource.SEND_ABUSE, "Ljava/util/Date;", "currentDate", "Lcom/avito/android/str_calendar/calendar/view/checker/CalendarAvailabilityChecker;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/str_calendar/calendar/view/checker/CalendarAvailabilityChecker;", "checker", "<init>", "(Lcom/avito/android/str_calendar/calendar/view/checker/CalendarAvailabilityChecker;)V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public final class BookingCalendarDayStateProviderImpl implements BookingCalendarDayStateProvider {
    public final Date a;
    public final CalendarAvailabilityChecker b;

    public BookingCalendarDayStateProviderImpl(@NotNull CalendarAvailabilityChecker calendarAvailabilityChecker) {
        Intrinsics.checkNotNullParameter(calendarAvailabilityChecker, "checker");
        this.b = calendarAvailabilityChecker;
        Date time = CalendarUtilsKt.getCalendar().getTime();
        Intrinsics.checkNotNullExpressionValue(time, "calendar.time");
        this.a = time;
    }

    @Override // com.avito.android.str_calendar.booking.data.BookingCalendarDayStateProvider
    @NotNull
    public CalendarItemState getDayState(@NotNull Date date, @Nullable Date date2, @Nullable DateRange dateRange) {
        Intrinsics.checkNotNullParameter(date, "day");
        if (date.compareTo(this.a) < 0) {
            return CalendarItemState.UNAVAILABLE;
        }
        if (dateRange == null || !dateRange.contains(date)) {
            if (date2 != null) {
                if (Intrinsics.areEqual(date2, date)) {
                    return CalendarItemState.SELECTED_SINGLE;
                }
                if (date2.compareTo(date) < 0) {
                    if (this.b.isCheckOutAvailable(date, date2)) {
                        return CalendarItemState.NORMAL;
                    }
                    if (dateRange == null) {
                        if (!this.b.isCheckInOrCheckOutPotentiallyPossible(date)) {
                            return CalendarItemState.CROSSED;
                        }
                        return CalendarItemState.UNAVAILABLE;
                    }
                }
            }
            if (Intrinsics.areEqual(date, this.a)) {
                if (this.b.isCheckInAvailable(date)) {
                    return CalendarItemState.CURRENT;
                }
                return CalendarItemState.CURRENT_CROSSED;
            } else if (!this.b.isCheckInOrCheckOutPotentiallyPossible(date)) {
                return CalendarItemState.CROSSED;
            } else {
                if (this.b.isCheckInAvailable(date)) {
                    return CalendarItemState.NORMAL;
                }
                return CalendarItemState.UNAVAILABLE;
            }
        } else if (Intrinsics.areEqual(date, dateRange.getStart())) {
            return CalendarItemState.SELECTED_LEFT;
        } else {
            if (Intrinsics.areEqual(date, dateRange.getEndInclusive())) {
                return CalendarItemState.SELECTED_RIGHT;
            }
            return CalendarItemState.SELECTED;
        }
    }

    @Override // com.avito.android.str_calendar.booking.data.BookingCalendarDayStateProvider
    @NotNull
    public CalendarItemState getEmptyItemState(@NotNull Date date, @Nullable DateRange dateRange) {
        Intrinsics.checkNotNullParameter(date, "nextDate");
        if (dateRange == null || !dateRange.contains(date) || !(!Intrinsics.areEqual(dateRange.getStart(), date))) {
            return CalendarItemState.NORMAL;
        }
        return CalendarItemState.SELECTED;
    }
}

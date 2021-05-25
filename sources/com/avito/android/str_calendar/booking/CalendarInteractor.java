package com.avito.android.str_calendar.booking;

import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.str_calendar.booking.model.BookingCalendarItem;
import com.avito.android.str_calendar.booking.model.CalendarBookingRestriction;
import com.avito.android.util.LoadingState;
import com.yandex.mobile.ads.video.tracking.Tracker;
import io.reactivex.Observable;
import java.util.Calendar;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JC\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b0\u00072\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u000b\u0010\fJ1\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\t0\b0\u00072\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH&¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/avito/android/str_calendar/booking/CalendarInteractor;", "", "Ljava/util/Calendar;", Tracker.Events.CREATIVE_START, "end", "", "maxDurationDays", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "", "Lcom/avito/android/str_calendar/booking/model/CalendarBookingRestriction;", "getDefaultRestrictions", "(Ljava/util/Calendar;Ljava/util/Calendar;I)Lio/reactivex/Observable;", "", BookingInfoActivity.EXTRA_ITEM_ID, "startDate", "Lcom/avito/android/str_calendar/booking/model/BookingCalendarItem;", "getBookingCalendar", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public interface CalendarInteractor {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Observable getDefaultRestrictions$default(CalendarInteractor calendarInteractor, Calendar calendar, Calendar calendar2, int i, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    calendar = null;
                }
                if ((i2 & 2) != 0) {
                    calendar2 = null;
                }
                if ((i2 & 4) != 0) {
                    i = Integer.MAX_VALUE;
                }
                return calendarInteractor.getDefaultRestrictions(calendar, calendar2, i);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getDefaultRestrictions");
        }
    }

    @NotNull
    Observable<LoadingState<List<BookingCalendarItem>>> getBookingCalendar(@NotNull String str, @NotNull String str2);

    @NotNull
    Observable<LoadingState<List<CalendarBookingRestriction>>> getDefaultRestrictions(@Nullable Calendar calendar, @Nullable Calendar calendar2, int i);
}

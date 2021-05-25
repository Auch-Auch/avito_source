package com.avito.android.str_calendar.booking.model;

import com.avito.android.remote.model.StrBookingCalendar;
import com.avito.android.str_calendar.utils.DateRange;
import com.avito.android.str_calendar.utils.StrDateUtilsKt;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0011\u0010\u0003\u001a\u00020\u0002*\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0005\u001a\u0011\u0010\u0003\u001a\u00020\u0007*\u00020\u0006¢\u0006\u0004\b\u0003\u0010\b¨\u0006\t"}, d2 = {"", "Lcom/avito/android/remote/model/StrBookingCalendar$BookingCalendarItem;", "Lcom/avito/android/str_calendar/booking/model/BookingCalendarItem;", "convert", "(Ljava/util/List;)Ljava/util/List;", "(Lcom/avito/android/remote/model/StrBookingCalendar$BookingCalendarItem;)Lcom/avito/android/str_calendar/booking/model/BookingCalendarItem;", "Lcom/avito/android/remote/model/StrBookingCalendar$AvailableCheckOutDateRange;", "Lcom/avito/android/str_calendar/utils/DateRange;", "(Lcom/avito/android/remote/model/StrBookingCalendar$AvailableCheckOutDateRange;)Lcom/avito/android/str_calendar/utils/DateRange;", "str-calendar_release"}, k = 2, mv = {1, 4, 2})
public final class BookingCalendarItemKt {
    @NotNull
    public static final BookingCalendarItem convert(@NotNull StrBookingCalendar.BookingCalendarItem bookingCalendarItem) {
        Intrinsics.checkNotNullParameter(bookingCalendarItem, "$this$convert");
        Date convertStrDateToDate = StrDateUtilsKt.convertStrDateToDate(bookingCalendarItem.getDate());
        boolean isCheckInAvailable = bookingCalendarItem.isCheckInAvailable();
        StrBookingCalendar.AvailableCheckOutDateRange availableCheckOutDateRange = bookingCalendarItem.getAvailableCheckOutDateRange();
        return new BookingCalendarItem(convertStrDateToDate, isCheckInAvailable, availableCheckOutDateRange != null ? convert(availableCheckOutDateRange) : null);
    }

    @NotNull
    public static final DateRange convert(@NotNull StrBookingCalendar.AvailableCheckOutDateRange availableCheckOutDateRange) {
        Intrinsics.checkNotNullParameter(availableCheckOutDateRange, "$this$convert");
        return new DateRange(StrDateUtilsKt.convertStrDateToDate(availableCheckOutDateRange.getStartDate()), StrDateUtilsKt.convertStrDateToDate(availableCheckOutDateRange.getEndDate()));
    }

    @NotNull
    public static final List<BookingCalendarItem> convert(@NotNull List<StrBookingCalendar.BookingCalendarItem> list) {
        Intrinsics.checkNotNullParameter(list, "$this$convert");
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(convert((StrBookingCalendar.BookingCalendarItem) it.next()));
        }
        return arrayList;
    }
}

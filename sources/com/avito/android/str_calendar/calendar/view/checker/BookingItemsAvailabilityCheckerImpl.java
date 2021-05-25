package com.avito.android.str_calendar.calendar.view.checker;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Sort;
import com.avito.android.str_calendar.booking.model.BookingCalendarItem;
import com.avito.android.str_calendar.utils.DateRange;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.v.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00130\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0006R2\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u000bj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004`\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR2\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00100\u000bj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0010`\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000eR2\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00130\u000bj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0013`\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u000eR2\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u000bj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004`\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/avito/android/str_calendar/calendar/view/checker/BookingItemsAvailabilityCheckerImpl;", "Lcom/avito/android/str_calendar/calendar/view/checker/CalendarAvailabilityChecker;", "Ljava/util/Date;", Sort.DATE, "", "isCheckInAvailable", "(Ljava/util/Date;)Z", "checkInDate", "isCheckOutAvailable", "(Ljava/util/Date;Ljava/util/Date;)Z", "isCheckInOrCheckOutPotentiallyPossible", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", AuthSource.BOOKING_ORDER, "Ljava/util/HashMap;", "checkInAvailabilityMap", "Lcom/avito/android/str_calendar/utils/DateRange;", "c", "checkOutAvailabilityMap", "Lcom/avito/android/str_calendar/booking/model/BookingCalendarItem;", AuthSource.SEND_ABUSE, "calendarItemsMap", "d", "checkInOrCheckOutPotentialAvailabilityMap", "", "calendarItems", "<init>", "(Ljava/util/List;)V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public final class BookingItemsAvailabilityCheckerImpl implements CalendarAvailabilityChecker {
    public final HashMap<Date, BookingCalendarItem> a = new HashMap<>();
    public final HashMap<Date, Boolean> b = new HashMap<>();
    public final HashMap<Date, DateRange> c = new HashMap<>();
    public final HashMap<Date, Boolean> d = new HashMap<>();

    public BookingItemsAvailabilityCheckerImpl(@NotNull List<BookingCalendarItem> list) {
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(list, "calendarItems");
        int i = 0;
        for (T t : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            T t2 = t;
            Date date = t2.getDate();
            this.a.put(date, t2);
            this.b.put(date, Boolean.valueOf(t2.isCheckInAvailable()));
            DateRange availableCheckOutDateRange = t2.getAvailableCheckOutDateRange();
            if (availableCheckOutDateRange != null) {
                this.c.put(date, availableCheckOutDateRange);
            }
            if (t2.isCheckInAvailable()) {
                this.d.put(date, Boolean.TRUE);
            } else {
                HashMap<Date, Boolean> hashMap = this.d;
                List slice = CollectionsKt___CollectionsKt.slice((List) list, e.until(0, i));
                if (!(slice instanceof Collection) || !slice.isEmpty()) {
                    Iterator it = slice.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        DateRange availableCheckOutDateRange2 = ((BookingCalendarItem) it.next()).getAvailableCheckOutDateRange();
                        if (availableCheckOutDateRange2 != null) {
                            z2 = availableCheckOutDateRange2.contains(date);
                            continue;
                        } else {
                            z2 = false;
                            continue;
                        }
                        if (z2) {
                            z = true;
                            break;
                        }
                    }
                    hashMap.put(date, Boolean.valueOf(z));
                }
                z = false;
                hashMap.put(date, Boolean.valueOf(z));
            }
            i = i2;
        }
    }

    @Override // com.avito.android.str_calendar.calendar.view.checker.CalendarAvailabilityChecker
    public boolean isCheckInAvailable(@NotNull Date date) {
        Intrinsics.checkNotNullParameter(date, Sort.DATE);
        Boolean bool = this.b.get(date);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @Override // com.avito.android.str_calendar.calendar.view.checker.CalendarAvailabilityChecker
    public boolean isCheckInOrCheckOutPotentiallyPossible(@NotNull Date date) {
        Intrinsics.checkNotNullParameter(date, Sort.DATE);
        Boolean bool = this.d.get(date);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @Override // com.avito.android.str_calendar.calendar.view.checker.CalendarAvailabilityChecker
    public boolean isCheckOutAvailable(@NotNull Date date, @NotNull Date date2) {
        Intrinsics.checkNotNullParameter(date, Sort.DATE);
        Intrinsics.checkNotNullParameter(date2, "checkInDate");
        DateRange dateRange = this.c.get(date2);
        if (dateRange != null) {
            return dateRange.contains(date);
        }
        return false;
    }
}

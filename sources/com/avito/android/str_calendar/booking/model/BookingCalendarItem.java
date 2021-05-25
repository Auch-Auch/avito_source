package com.avito.android.str_calendar.booking.model;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Sort;
import com.avito.android.str_calendar.utils.DateRange;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ0\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\f\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\f\u0010\u0007R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\n¨\u0006#"}, d2 = {"Lcom/avito/android/str_calendar/booking/model/BookingCalendarItem;", "", "Ljava/util/Date;", "component1", "()Ljava/util/Date;", "", "component2", "()Z", "Lcom/avito/android/str_calendar/utils/DateRange;", "component3", "()Lcom/avito/android/str_calendar/utils/DateRange;", Sort.DATE, "isCheckInAvailable", "availableCheckOutDateRange", "copy", "(Ljava/util/Date;ZLcom/avito/android/str_calendar/utils/DateRange;)Lcom/avito/android/str_calendar/booking/model/BookingCalendarItem;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Z", AuthSource.SEND_ABUSE, "Ljava/util/Date;", "getDate", "c", "Lcom/avito/android/str_calendar/utils/DateRange;", "getAvailableCheckOutDateRange", "<init>", "(Ljava/util/Date;ZLcom/avito/android/str_calendar/utils/DateRange;)V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public final class BookingCalendarItem {
    @NotNull
    public final Date a;
    public final boolean b;
    @Nullable
    public final DateRange c;

    public BookingCalendarItem(@NotNull Date date, boolean z, @Nullable DateRange dateRange) {
        Intrinsics.checkNotNullParameter(date, Sort.DATE);
        this.a = date;
        this.b = z;
        this.c = dateRange;
    }

    public static /* synthetic */ BookingCalendarItem copy$default(BookingCalendarItem bookingCalendarItem, Date date, boolean z, DateRange dateRange, int i, Object obj) {
        if ((i & 1) != 0) {
            date = bookingCalendarItem.a;
        }
        if ((i & 2) != 0) {
            z = bookingCalendarItem.b;
        }
        if ((i & 4) != 0) {
            dateRange = bookingCalendarItem.c;
        }
        return bookingCalendarItem.copy(date, z, dateRange);
    }

    @NotNull
    public final Date component1() {
        return this.a;
    }

    public final boolean component2() {
        return this.b;
    }

    @Nullable
    public final DateRange component3() {
        return this.c;
    }

    @NotNull
    public final BookingCalendarItem copy(@NotNull Date date, boolean z, @Nullable DateRange dateRange) {
        Intrinsics.checkNotNullParameter(date, Sort.DATE);
        return new BookingCalendarItem(date, z, dateRange);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BookingCalendarItem)) {
            return false;
        }
        BookingCalendarItem bookingCalendarItem = (BookingCalendarItem) obj;
        return Intrinsics.areEqual(this.a, bookingCalendarItem.a) && this.b == bookingCalendarItem.b && Intrinsics.areEqual(this.c, bookingCalendarItem.c);
    }

    @Nullable
    public final DateRange getAvailableCheckOutDateRange() {
        return this.c;
    }

    @NotNull
    public final Date getDate() {
        return this.a;
    }

    public int hashCode() {
        Date date = this.a;
        int i = 0;
        int hashCode = (date != null ? date.hashCode() : 0) * 31;
        boolean z = this.b;
        if (z) {
            z = true;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = (hashCode + i2) * 31;
        DateRange dateRange = this.c;
        if (dateRange != null) {
            i = dateRange.hashCode();
        }
        return i5 + i;
    }

    public final boolean isCheckInAvailable() {
        return this.b;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("BookingCalendarItem(date=");
        L.append(this.a);
        L.append(", isCheckInAvailable=");
        L.append(this.b);
        L.append(", availableCheckOutDateRange=");
        L.append(this.c);
        L.append(")");
        return L.toString();
    }
}

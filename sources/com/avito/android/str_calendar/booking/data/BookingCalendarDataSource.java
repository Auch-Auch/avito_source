package com.avito.android.str_calendar.booking.data;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Sort;
import com.avito.android.str_calendar.calendar.view.checker.CalendarAvailabilityChecker;
import com.avito.android.str_calendar.calendar.view.data.CalendarData;
import com.avito.android.str_calendar.calendar.view.data.CalendarDataConverter;
import com.avito.android.str_calendar.calendar.view.data.CalendarDataSource;
import com.avito.android.str_calendar.calendar.view.konveyor.items.day.booking.DayItem;
import com.avito.android.str_calendar.utils.DateRange;
import com.avito.konveyor.blueprint.Item;
import com.jakewharton.rxrelay2.BehaviorRelay;
import com.jakewharton.rxrelay2.Relay;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\b\u0010/\u001a\u0004\u0018\u00010\u0002\u0012\b\u00100\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b1\u00102J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0011\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0012\u0010\tJ\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0014\u0010\u0006R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u001eR\u0018\u0010!\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R(\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190*8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0014\u0010+\u001a\u0004\b,\u0010-¨\u00063"}, d2 = {"Lcom/avito/android/str_calendar/booking/data/BookingCalendarDataSource;", "Lcom/avito/android/str_calendar/calendar/view/data/CalendarDataSource;", "Ljava/util/Date;", Sort.DATE, "", "onItemSelected", "(Ljava/util/Date;)Z", "", "onClearSelection", "()V", "Lcom/avito/android/str_calendar/utils/DateRange;", "getSelectedRange", "()Lcom/avito/android/str_calendar/utils/DateRange;", "getSelectedDate", "()Ljava/util/Date;", "", "positionOfDate", "(Ljava/util/Date;)I", AuthSource.BOOKING_ORDER, "checkInDate", AuthSource.SEND_ABUSE, "Lcom/avito/android/str_calendar/calendar/view/data/CalendarDataConverter;", "f", "Lcom/avito/android/str_calendar/calendar/view/data/CalendarDataConverter;", "converter", "", "Lcom/avito/konveyor/blueprint/Item;", "c", "()Ljava/util/List;", "items", "Ljava/util/Date;", "selectedDate", "Lcom/avito/android/str_calendar/utils/DateRange;", "selectedRange", "Lcom/avito/android/str_calendar/calendar/view/checker/CalendarAvailabilityChecker;", "d", "Lcom/avito/android/str_calendar/calendar/view/checker/CalendarAvailabilityChecker;", "checker", "Lcom/avito/android/str_calendar/calendar/view/data/CalendarData;", "e", "Lcom/avito/android/str_calendar/calendar/view/data/CalendarData;", "calendarData", "Lcom/jakewharton/rxrelay2/Relay;", "Lcom/jakewharton/rxrelay2/Relay;", "getListItemsObservable", "()Lcom/jakewharton/rxrelay2/Relay;", "listItemsObservable", "initialCheckInDate", "initialCheckOutDate", "<init>", "(Lcom/avito/android/str_calendar/calendar/view/checker/CalendarAvailabilityChecker;Lcom/avito/android/str_calendar/calendar/view/data/CalendarData;Lcom/avito/android/str_calendar/calendar/view/data/CalendarDataConverter;Ljava/util/Date;Ljava/util/Date;)V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public final class BookingCalendarDataSource implements CalendarDataSource {
    @NotNull
    public final Relay<List<Item>> a;
    public Date b;
    public DateRange c;
    public final CalendarAvailabilityChecker d;
    public final CalendarData e;
    public final CalendarDataConverter f;

    public BookingCalendarDataSource(@NotNull CalendarAvailabilityChecker calendarAvailabilityChecker, @NotNull CalendarData calendarData, @NotNull CalendarDataConverter calendarDataConverter, @Nullable Date date, @Nullable Date date2) {
        Intrinsics.checkNotNullParameter(calendarAvailabilityChecker, "checker");
        Intrinsics.checkNotNullParameter(calendarData, "calendarData");
        Intrinsics.checkNotNullParameter(calendarDataConverter, "converter");
        this.d = calendarAvailabilityChecker;
        this.e = calendarData;
        this.f = calendarDataConverter;
        BehaviorRelay create = BehaviorRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "BehaviorRelay.create()");
        this.a = create;
        this.b = date;
        this.c = (date == null || date2 == null) ? null : new DateRange(date, date2);
        getListItemsObservable().accept(c());
    }

    public final boolean a(Date date) {
        if (!this.d.isCheckInAvailable(date)) {
            return false;
        }
        this.b = date;
        getListItemsObservable().accept(c());
        return true;
    }

    public final void b() {
        this.b = null;
        this.c = null;
    }

    public final List<Item> c() {
        return this.f.convert(this.e, this.b, this.c);
    }

    @Override // com.avito.android.str_calendar.calendar.view.data.CalendarDataSource
    @Nullable
    public Date getSelectedDate() {
        return this.b;
    }

    @Override // com.avito.android.str_calendar.calendar.view.data.CalendarDataSource
    @Nullable
    public DateRange getSelectedRange() {
        return this.c;
    }

    @Override // com.avito.android.str_calendar.calendar.view.data.CalendarDataSource
    public void onClearSelection() {
        b();
        getListItemsObservable().accept(c());
    }

    @Override // com.avito.android.str_calendar.calendar.view.data.CalendarDataSource
    public boolean onItemSelected(@NotNull Date date) {
        Intrinsics.checkNotNullParameter(date, Sort.DATE);
        Date date2 = this.b;
        if (date2 == null) {
            return a(date);
        }
        if (date2.compareTo(date) > 0) {
            b();
            return a(date);
        } else if (this.c != null) {
            b();
            return a(date);
        } else {
            Date date3 = this.b;
            if (date3 == null || !this.d.isCheckOutAvailable(date, date3)) {
                return false;
            }
            this.c = new DateRange(date3, date);
            getListItemsObservable().accept(c());
            return true;
        }
    }

    @Override // com.avito.android.str_calendar.calendar.view.data.CalendarDataSource
    public int positionOfDate(@NotNull Date date) {
        Intrinsics.checkNotNullParameter(date, Sort.DATE);
        int i = 0;
        for (Item item : c()) {
            if ((item instanceof DayItem) && Intrinsics.areEqual(((DayItem) item).getDate(), date)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override // com.avito.android.str_calendar.calendar.view.data.CalendarDataSource
    @NotNull
    public Relay<List<Item>> getListItemsObservable() {
        return this.a;
    }
}

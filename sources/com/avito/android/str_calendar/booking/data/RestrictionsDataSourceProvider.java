package com.avito.android.str_calendar.booking.data;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.str_calendar.booking.model.CalendarBookingRestriction;
import com.avito.android.str_calendar.calendar.view.checker.RestrictionsAvailabilityCheckerImpl;
import com.avito.android.str_calendar.calendar.view.data.CalendarDataBuilderImpl;
import com.avito.android.str_calendar.calendar.view.data.CalendarDataSource;
import com.avito.android.str_calendar.calendar.view.data.CalendarDataSourceProvider;
import com.avito.android.str_calendar.di.qualifier.EndDate;
import com.avito.android.str_calendar.di.qualifier.StartDate;
import com.avito.android.str_calendar.utils.DateRange;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B!\b\u0007\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\r\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/avito/android/str_calendar/booking/data/RestrictionsDataSourceProvider;", "Lcom/avito/android/str_calendar/calendar/view/data/CalendarDataSourceProvider;", "", "Lcom/avito/android/str_calendar/booking/model/CalendarBookingRestriction;", "data", "Lcom/avito/android/str_calendar/calendar/view/data/CalendarDataSource;", "getDataSource", "(Ljava/util/List;)Lcom/avito/android/str_calendar/calendar/view/data/CalendarDataSource;", "Ljava/util/Date;", AuthSource.BOOKING_ORDER, "Ljava/util/Date;", "initialCheckOutDate", AuthSource.SEND_ABUSE, "initialCheckInDate", "<init>", "(Ljava/util/Date;Ljava/util/Date;)V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public final class RestrictionsDataSourceProvider implements CalendarDataSourceProvider<List<? extends CalendarBookingRestriction>> {
    public final Date a;
    public final Date b;

    @Inject
    public RestrictionsDataSourceProvider(@StartDate @Nullable Date date, @EndDate @Nullable Date date2) {
        this.a = date;
        this.b = date2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.avito.android.str_calendar.calendar.view.data.CalendarDataSourceProvider
    public /* bridge */ /* synthetic */ CalendarDataSource getDataSource(List<? extends CalendarBookingRestriction> list) {
        return getDataSource((List<CalendarBookingRestriction>) list);
    }

    @NotNull
    public CalendarDataSource getDataSource(@NotNull List<CalendarBookingRestriction> list) {
        Intrinsics.checkNotNullParameter(list, "data");
        CalendarDataBuilderImpl calendarDataBuilderImpl = new CalendarDataBuilderImpl(new DateRange(((CalendarBookingRestriction) CollectionsKt___CollectionsKt.first((List<? extends Object>) list)).getDate(), ((CalendarBookingRestriction) CollectionsKt___CollectionsKt.last((List<? extends Object>) list)).getDate()));
        RestrictionsAvailabilityCheckerImpl restrictionsAvailabilityCheckerImpl = new RestrictionsAvailabilityCheckerImpl(list);
        return new BookingCalendarDataSource(restrictionsAvailabilityCheckerImpl, calendarDataBuilderImpl.build(), new BookingCalendarDataConverter(new BookingCalendarDayStateProviderImpl(restrictionsAvailabilityCheckerImpl)), this.a, this.b);
    }
}

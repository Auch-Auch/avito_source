package com.avito.android.str_calendar.booking;

import a2.g.r.g;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.server_time.TimeSource;
import com.avito.android.str_calendar.analytics.StrAnalyticsTracker;
import com.avito.android.str_calendar.booking.model.BookingCalendarItem;
import com.avito.android.str_calendar.booking.model.CalendarBookingRestriction;
import com.avito.android.str_calendar.calendar.view.data.CalendarDataSourceProvider;
import com.avito.android.util.SchedulersFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001Bi\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\b\u0010,\u001a\u0004\u0018\u00010)\u0012\u0012\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u001c\u0012\u0012\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u001d0\u001c\u0012\u0006\u0010(\u001a\u00020%¢\u0006\u0004\b-\u0010.J)\u0010\u0006\u001a\u00028\u0000\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\"\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\"\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u001d0\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010 R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006/"}, d2 = {"Lcom/avito/android/str_calendar/booking/CalendarViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "modelClass", "create", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/util/SchedulersFactory;", "c", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/str_calendar/booking/CalendarResourceProvider;", "d", "Lcom/avito/android/str_calendar/booking/CalendarResourceProvider;", "resourceProvider", "Lcom/avito/android/str_calendar/analytics/StrAnalyticsTracker;", "e", "Lcom/avito/android/str_calendar/analytics/StrAnalyticsTracker;", "strAnalyticsTracker", "Lcom/avito/android/str_calendar/booking/CalendarInteractor;", AuthSource.SEND_ABUSE, "Lcom/avito/android/str_calendar/booking/CalendarInteractor;", "interactor", "Lcom/avito/android/server_time/TimeSource;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Lcom/avito/android/str_calendar/calendar/view/data/CalendarDataSourceProvider;", "", "Lcom/avito/android/str_calendar/booking/model/CalendarBookingRestriction;", g.a, "Lcom/avito/android/str_calendar/calendar/view/data/CalendarDataSourceProvider;", "restrictionsDataSourceProvider", "Lcom/avito/android/str_calendar/booking/model/BookingCalendarItem;", "h", "calendarItemDataSourceProvider", "", "i", "Z", "enableClearButton", "", "f", "Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "<init>", "(Lcom/avito/android/str_calendar/booking/CalendarInteractor;Lcom/avito/android/server_time/TimeSource;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/str_calendar/booking/CalendarResourceProvider;Lcom/avito/android/str_calendar/analytics/StrAnalyticsTracker;Ljava/lang/String;Lcom/avito/android/str_calendar/calendar/view/data/CalendarDataSourceProvider;Lcom/avito/android/str_calendar/calendar/view/data/CalendarDataSourceProvider;Z)V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public final class CalendarViewModelFactory implements ViewModelProvider.Factory {
    public final CalendarInteractor a;
    public final TimeSource b;
    public final SchedulersFactory c;
    public final CalendarResourceProvider d;
    public final StrAnalyticsTracker e;
    public final String f;
    public final CalendarDataSourceProvider<List<CalendarBookingRestriction>> g;
    public final CalendarDataSourceProvider<List<BookingCalendarItem>> h;
    public final boolean i;

    public CalendarViewModelFactory(@NotNull CalendarInteractor calendarInteractor, @NotNull TimeSource timeSource, @NotNull SchedulersFactory schedulersFactory, @NotNull CalendarResourceProvider calendarResourceProvider, @NotNull StrAnalyticsTracker strAnalyticsTracker, @Nullable String str, @NotNull CalendarDataSourceProvider<List<CalendarBookingRestriction>> calendarDataSourceProvider, @NotNull CalendarDataSourceProvider<List<BookingCalendarItem>> calendarDataSourceProvider2, boolean z) {
        Intrinsics.checkNotNullParameter(calendarInteractor, "interactor");
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(calendarResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(strAnalyticsTracker, "strAnalyticsTracker");
        Intrinsics.checkNotNullParameter(calendarDataSourceProvider, "restrictionsDataSourceProvider");
        Intrinsics.checkNotNullParameter(calendarDataSourceProvider2, "calendarItemDataSourceProvider");
        this.a = calendarInteractor;
        this.b = timeSource;
        this.c = schedulersFactory;
        this.d = calendarResourceProvider;
        this.e = strAnalyticsTracker;
        this.f = str;
        this.g = calendarDataSourceProvider;
        this.h = calendarDataSourceProvider2;
        this.i = z;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (cls.isAssignableFrom(CalendarViewModelImpl.class)) {
            return new CalendarViewModelImpl(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}

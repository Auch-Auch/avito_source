package com.avito.android.short_term_rent.hotels.dialogs.calendar;

import com.avito.android.short_term_rent.hotels.data.HotelsCalendarRestrictions;
import com.avito.android.str_calendar.booking.CalendarInteractor;
import com.avito.android.str_calendar.booking.CalendarResourceProvider;
import com.avito.android.str_calendar.booking.model.CalendarBookingRestriction;
import com.avito.android.str_calendar.calendar.view.data.CalendarDataSourceProvider;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import java.util.List;
import javax.inject.Provider;
public final class HotelsCalendarViewModelImplFactory_Factory implements Factory<HotelsCalendarViewModelImplFactory> {
    public final Provider<CalendarInteractor> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<CalendarResourceProvider> c;
    public final Provider<CalendarDataSourceProvider<List<? extends CalendarBookingRestriction>>> d;
    public final Provider<String> e;
    public final Provider<HotelsCalendarRestrictions> f;

    public HotelsCalendarViewModelImplFactory_Factory(Provider<CalendarInteractor> provider, Provider<SchedulersFactory3> provider2, Provider<CalendarResourceProvider> provider3, Provider<CalendarDataSourceProvider<List<? extends CalendarBookingRestriction>>> provider4, Provider<String> provider5, Provider<HotelsCalendarRestrictions> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static HotelsCalendarViewModelImplFactory_Factory create(Provider<CalendarInteractor> provider, Provider<SchedulersFactory3> provider2, Provider<CalendarResourceProvider> provider3, Provider<CalendarDataSourceProvider<List<? extends CalendarBookingRestriction>>> provider4, Provider<String> provider5, Provider<HotelsCalendarRestrictions> provider6) {
        return new HotelsCalendarViewModelImplFactory_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static HotelsCalendarViewModelImplFactory newInstance(CalendarInteractor calendarInteractor, SchedulersFactory3 schedulersFactory3, CalendarResourceProvider calendarResourceProvider, CalendarDataSourceProvider<List<? extends CalendarBookingRestriction>> calendarDataSourceProvider, String str, HotelsCalendarRestrictions hotelsCalendarRestrictions) {
        return new HotelsCalendarViewModelImplFactory(calendarInteractor, schedulersFactory3, calendarResourceProvider, calendarDataSourceProvider, str, hotelsCalendarRestrictions);
    }

    @Override // javax.inject.Provider
    public HotelsCalendarViewModelImplFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}

package com.avito.android.inline_filters.dialog.calendar;

import com.avito.android.remote.model.search.Filter;
import com.avito.android.remote.model.search.InlineFilterValue;
import com.avito.android.str_calendar.booking.CalendarInteractor;
import com.avito.android.str_calendar.booking.CalendarResourceProvider;
import com.avito.android.str_calendar.booking.model.CalendarBookingRestriction;
import com.avito.android.str_calendar.calendar.view.data.CalendarDataSourceProvider;
import com.avito.android.util.SchedulersFactory;
import dagger.internal.Factory;
import java.util.List;
import javax.inject.Provider;
public final class InlineFiltersCalendarViewModelImplFactory_Factory implements Factory<InlineFiltersCalendarViewModelImplFactory> {
    public final Provider<CalendarInteractor> a;
    public final Provider<SchedulersFactory> b;
    public final Provider<CalendarResourceProvider> c;
    public final Provider<CalendarDataSourceProvider<List<? extends CalendarBookingRestriction>>> d;
    public final Provider<String> e;
    public final Provider<InlineFilterValue.InlineFilterDateRangeValue> f;
    public final Provider<Filter.Widget> g;

    public InlineFiltersCalendarViewModelImplFactory_Factory(Provider<CalendarInteractor> provider, Provider<SchedulersFactory> provider2, Provider<CalendarResourceProvider> provider3, Provider<CalendarDataSourceProvider<List<? extends CalendarBookingRestriction>>> provider4, Provider<String> provider5, Provider<InlineFilterValue.InlineFilterDateRangeValue> provider6, Provider<Filter.Widget> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static InlineFiltersCalendarViewModelImplFactory_Factory create(Provider<CalendarInteractor> provider, Provider<SchedulersFactory> provider2, Provider<CalendarResourceProvider> provider3, Provider<CalendarDataSourceProvider<List<? extends CalendarBookingRestriction>>> provider4, Provider<String> provider5, Provider<InlineFilterValue.InlineFilterDateRangeValue> provider6, Provider<Filter.Widget> provider7) {
        return new InlineFiltersCalendarViewModelImplFactory_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static InlineFiltersCalendarViewModelImplFactory newInstance(CalendarInteractor calendarInteractor, SchedulersFactory schedulersFactory, CalendarResourceProvider calendarResourceProvider, CalendarDataSourceProvider<List<? extends CalendarBookingRestriction>> calendarDataSourceProvider, String str, InlineFilterValue.InlineFilterDateRangeValue inlineFilterDateRangeValue, Filter.Widget widget) {
        return new InlineFiltersCalendarViewModelImplFactory(calendarInteractor, schedulersFactory, calendarResourceProvider, calendarDataSourceProvider, str, inlineFilterDateRangeValue, widget);
    }

    @Override // javax.inject.Provider
    public InlineFiltersCalendarViewModelImplFactory get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get());
    }
}

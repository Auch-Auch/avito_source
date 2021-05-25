package com.avito.android.str_calendar.di.module;

import com.avito.android.str_calendar.calendar.view.konveyor.CalendarViewTypeProvider;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class StrCalendarRecyclerCommon_ProvideAdapterPresenter$str_calendar_releaseFactory implements Factory<AdapterPresenter> {
    public final Provider<CalendarViewTypeProvider> a;
    public final Provider<ItemBinder> b;

    public StrCalendarRecyclerCommon_ProvideAdapterPresenter$str_calendar_releaseFactory(Provider<CalendarViewTypeProvider> provider, Provider<ItemBinder> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static StrCalendarRecyclerCommon_ProvideAdapterPresenter$str_calendar_releaseFactory create(Provider<CalendarViewTypeProvider> provider, Provider<ItemBinder> provider2) {
        return new StrCalendarRecyclerCommon_ProvideAdapterPresenter$str_calendar_releaseFactory(provider, provider2);
    }

    public static AdapterPresenter provideAdapterPresenter$str_calendar_release(CalendarViewTypeProvider calendarViewTypeProvider, ItemBinder itemBinder) {
        return (AdapterPresenter) Preconditions.checkNotNullFromProvides(StrCalendarRecyclerCommon.provideAdapterPresenter$str_calendar_release(calendarViewTypeProvider, itemBinder));
    }

    @Override // javax.inject.Provider
    public AdapterPresenter get() {
        return provideAdapterPresenter$str_calendar_release(this.a.get(), this.b.get());
    }
}

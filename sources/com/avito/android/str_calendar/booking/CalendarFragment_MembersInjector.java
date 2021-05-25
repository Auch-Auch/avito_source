package com.avito.android.str_calendar.booking;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.util.DeviceMetrics;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class CalendarFragment_MembersInjector implements MembersInjector<CalendarFragment> {
    public final Provider<Analytics> a;
    public final Provider<CalendarViewModel> b;
    public final Provider<AdapterPresenter> c;
    public final Provider<ItemBinder> d;
    public final Provider<DeviceMetrics> e;
    public final Provider<Features> f;

    public CalendarFragment_MembersInjector(Provider<Analytics> provider, Provider<CalendarViewModel> provider2, Provider<AdapterPresenter> provider3, Provider<ItemBinder> provider4, Provider<DeviceMetrics> provider5, Provider<Features> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static MembersInjector<CalendarFragment> create(Provider<Analytics> provider, Provider<CalendarViewModel> provider2, Provider<AdapterPresenter> provider3, Provider<ItemBinder> provider4, Provider<DeviceMetrics> provider5, Provider<Features> provider6) {
        return new CalendarFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @InjectedFieldSignature("com.avito.android.str_calendar.booking.CalendarFragment.adapterPresenter")
    public static void injectAdapterPresenter(CalendarFragment calendarFragment, AdapterPresenter adapterPresenter) {
        calendarFragment.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.str_calendar.booking.CalendarFragment.analytics")
    public static void injectAnalytics(CalendarFragment calendarFragment, Analytics analytics) {
        calendarFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.str_calendar.booking.CalendarFragment.calendarViewModel")
    public static void injectCalendarViewModel(CalendarFragment calendarFragment, CalendarViewModel calendarViewModel) {
        calendarFragment.calendarViewModel = calendarViewModel;
    }

    @InjectedFieldSignature("com.avito.android.str_calendar.booking.CalendarFragment.deviceMetrics")
    public static void injectDeviceMetrics(CalendarFragment calendarFragment, DeviceMetrics deviceMetrics) {
        calendarFragment.deviceMetrics = deviceMetrics;
    }

    @InjectedFieldSignature("com.avito.android.str_calendar.booking.CalendarFragment.features")
    public static void injectFeatures(CalendarFragment calendarFragment, Features features) {
        calendarFragment.features = features;
    }

    @InjectedFieldSignature("com.avito.android.str_calendar.booking.CalendarFragment.itemBinder")
    public static void injectItemBinder(CalendarFragment calendarFragment, ItemBinder itemBinder) {
        calendarFragment.itemBinder = itemBinder;
    }

    public void injectMembers(CalendarFragment calendarFragment) {
        injectAnalytics(calendarFragment, this.a.get());
        injectCalendarViewModel(calendarFragment, this.b.get());
        injectAdapterPresenter(calendarFragment, this.c.get());
        injectItemBinder(calendarFragment, this.d.get());
        injectDeviceMetrics(calendarFragment, this.e.get());
        injectFeatures(calendarFragment, this.f.get());
    }
}

package com.avito.android.short_term_rent.hotels.dialogs.calendar;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.util.DeviceMetrics;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class HotelsCalendarDialog_MembersInjector implements MembersInjector<HotelsCalendarDialog> {
    public final Provider<Analytics> a;
    public final Provider<HotelsFiltersCalendarViewModel> b;
    public final Provider<AdapterPresenter> c;
    public final Provider<ItemBinder> d;
    public final Provider<DeviceMetrics> e;
    public final Provider<Features> f;

    public HotelsCalendarDialog_MembersInjector(Provider<Analytics> provider, Provider<HotelsFiltersCalendarViewModel> provider2, Provider<AdapterPresenter> provider3, Provider<ItemBinder> provider4, Provider<DeviceMetrics> provider5, Provider<Features> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static MembersInjector<HotelsCalendarDialog> create(Provider<Analytics> provider, Provider<HotelsFiltersCalendarViewModel> provider2, Provider<AdapterPresenter> provider3, Provider<ItemBinder> provider4, Provider<DeviceMetrics> provider5, Provider<Features> provider6) {
        return new HotelsCalendarDialog_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @InjectedFieldSignature("com.avito.android.short_term_rent.hotels.dialogs.calendar.HotelsCalendarDialog.adapterPresenter")
    public static void injectAdapterPresenter(HotelsCalendarDialog hotelsCalendarDialog, AdapterPresenter adapterPresenter) {
        hotelsCalendarDialog.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.short_term_rent.hotels.dialogs.calendar.HotelsCalendarDialog.analytics")
    public static void injectAnalytics(HotelsCalendarDialog hotelsCalendarDialog, Analytics analytics) {
        hotelsCalendarDialog.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.short_term_rent.hotels.dialogs.calendar.HotelsCalendarDialog.calendarViewModel")
    public static void injectCalendarViewModel(HotelsCalendarDialog hotelsCalendarDialog, HotelsFiltersCalendarViewModel hotelsFiltersCalendarViewModel) {
        hotelsCalendarDialog.calendarViewModel = hotelsFiltersCalendarViewModel;
    }

    @InjectedFieldSignature("com.avito.android.short_term_rent.hotels.dialogs.calendar.HotelsCalendarDialog.deviceMetrics")
    public static void injectDeviceMetrics(HotelsCalendarDialog hotelsCalendarDialog, DeviceMetrics deviceMetrics) {
        hotelsCalendarDialog.deviceMetrics = deviceMetrics;
    }

    @InjectedFieldSignature("com.avito.android.short_term_rent.hotels.dialogs.calendar.HotelsCalendarDialog.features")
    public static void injectFeatures(HotelsCalendarDialog hotelsCalendarDialog, Features features) {
        hotelsCalendarDialog.features = features;
    }

    @InjectedFieldSignature("com.avito.android.short_term_rent.hotels.dialogs.calendar.HotelsCalendarDialog.itemBinder")
    public static void injectItemBinder(HotelsCalendarDialog hotelsCalendarDialog, ItemBinder itemBinder) {
        hotelsCalendarDialog.itemBinder = itemBinder;
    }

    public void injectMembers(HotelsCalendarDialog hotelsCalendarDialog) {
        injectAnalytics(hotelsCalendarDialog, this.a.get());
        injectCalendarViewModel(hotelsCalendarDialog, this.b.get());
        injectAdapterPresenter(hotelsCalendarDialog, this.c.get());
        injectItemBinder(hotelsCalendarDialog, this.d.get());
        injectDeviceMetrics(hotelsCalendarDialog, this.e.get());
        injectFeatures(hotelsCalendarDialog, this.f.get());
    }
}

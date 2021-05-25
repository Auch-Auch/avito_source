package com.avito.android.inline_filters.dialog.calendar;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.util.DeviceMetrics;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class InlineFiltersCalendarDialog_MembersInjector implements MembersInjector<InlineFiltersCalendarDialog> {
    public final Provider<Analytics> a;
    public final Provider<InlineFiltersCalendarViewModel> b;
    public final Provider<AdapterPresenter> c;
    public final Provider<ItemBinder> d;
    public final Provider<DeviceMetrics> e;
    public final Provider<Features> f;

    public InlineFiltersCalendarDialog_MembersInjector(Provider<Analytics> provider, Provider<InlineFiltersCalendarViewModel> provider2, Provider<AdapterPresenter> provider3, Provider<ItemBinder> provider4, Provider<DeviceMetrics> provider5, Provider<Features> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static MembersInjector<InlineFiltersCalendarDialog> create(Provider<Analytics> provider, Provider<InlineFiltersCalendarViewModel> provider2, Provider<AdapterPresenter> provider3, Provider<ItemBinder> provider4, Provider<DeviceMetrics> provider5, Provider<Features> provider6) {
        return new InlineFiltersCalendarDialog_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @InjectedFieldSignature("com.avito.android.inline_filters.dialog.calendar.InlineFiltersCalendarDialog.adapterPresenter")
    public static void injectAdapterPresenter(InlineFiltersCalendarDialog inlineFiltersCalendarDialog, AdapterPresenter adapterPresenter) {
        inlineFiltersCalendarDialog.adapterPresenter = adapterPresenter;
    }

    @InjectedFieldSignature("com.avito.android.inline_filters.dialog.calendar.InlineFiltersCalendarDialog.analytics")
    public static void injectAnalytics(InlineFiltersCalendarDialog inlineFiltersCalendarDialog, Analytics analytics) {
        inlineFiltersCalendarDialog.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.inline_filters.dialog.calendar.InlineFiltersCalendarDialog.calendarViewModel")
    public static void injectCalendarViewModel(InlineFiltersCalendarDialog inlineFiltersCalendarDialog, InlineFiltersCalendarViewModel inlineFiltersCalendarViewModel) {
        inlineFiltersCalendarDialog.calendarViewModel = inlineFiltersCalendarViewModel;
    }

    @InjectedFieldSignature("com.avito.android.inline_filters.dialog.calendar.InlineFiltersCalendarDialog.deviceMetrics")
    public static void injectDeviceMetrics(InlineFiltersCalendarDialog inlineFiltersCalendarDialog, DeviceMetrics deviceMetrics) {
        inlineFiltersCalendarDialog.deviceMetrics = deviceMetrics;
    }

    @InjectedFieldSignature("com.avito.android.inline_filters.dialog.calendar.InlineFiltersCalendarDialog.features")
    public static void injectFeatures(InlineFiltersCalendarDialog inlineFiltersCalendarDialog, Features features) {
        inlineFiltersCalendarDialog.features = features;
    }

    @InjectedFieldSignature("com.avito.android.inline_filters.dialog.calendar.InlineFiltersCalendarDialog.itemBinder")
    public static void injectItemBinder(InlineFiltersCalendarDialog inlineFiltersCalendarDialog, ItemBinder itemBinder) {
        inlineFiltersCalendarDialog.itemBinder = itemBinder;
    }

    public void injectMembers(InlineFiltersCalendarDialog inlineFiltersCalendarDialog) {
        injectAnalytics(inlineFiltersCalendarDialog, this.a.get());
        injectCalendarViewModel(inlineFiltersCalendarDialog, this.b.get());
        injectAdapterPresenter(inlineFiltersCalendarDialog, this.c.get());
        injectItemBinder(inlineFiltersCalendarDialog, this.d.get());
        injectDeviceMetrics(inlineFiltersCalendarDialog, this.e.get());
        injectFeatures(inlineFiltersCalendarDialog, this.f.get());
    }
}

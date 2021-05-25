package com.avito.android.inline_filters.di;

import android.content.res.Resources;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.inline_filters.di.InlineFilterCalendarComponent;
import com.avito.android.inline_filters.dialog.calendar.InlineFiltersCalendarDialog;
import com.avito.android.inline_filters.dialog.calendar.InlineFiltersCalendarDialog_MembersInjector;
import com.avito.android.inline_filters.dialog.calendar.InlineFiltersCalendarViewModel;
import com.avito.android.inline_filters.dialog.calendar.InlineFiltersCalendarViewModelImplFactory;
import com.avito.android.inline_filters.dialog.calendar.InlineFiltersCalendarViewModelImplFactory_Factory;
import com.avito.android.remote.ShortTermRentApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.search.Filter;
import com.avito.android.remote.model.search.InlineFilterValue;
import com.avito.android.str_calendar.booking.CalendarInteractor;
import com.avito.android.str_calendar.booking.CalendarInteractorImpl;
import com.avito.android.str_calendar.booking.CalendarInteractorImpl_Factory;
import com.avito.android.str_calendar.booking.CalendarResourceProvider;
import com.avito.android.str_calendar.booking.CalendarResourceProviderImpl;
import com.avito.android.str_calendar.booking.CalendarResourceProviderImpl_Factory;
import com.avito.android.str_calendar.booking.data.RestrictionsDataSourceProvider;
import com.avito.android.str_calendar.booking.data.RestrictionsDataSourceProvider_Factory;
import com.avito.android.str_calendar.booking.model.CalendarBookingRestriction;
import com.avito.android.str_calendar.calendar.view.data.CalendarDataSourceProvider;
import com.avito.android.str_calendar.calendar.view.konveyor.CalendarViewTypeProvider;
import com.avito.android.str_calendar.calendar.view.konveyor.CalendarViewTypeProviderImpl_Factory;
import com.avito.android.str_calendar.calendar.view.konveyor.items.day.booking.DayItemBlueprint;
import com.avito.android.str_calendar.calendar.view.konveyor.items.day.booking.DayItemBlueprint_Factory;
import com.avito.android.str_calendar.calendar.view.konveyor.items.day.booking.DayItemPresenter;
import com.avito.android.str_calendar.calendar.view.konveyor.items.empty.EmptyItemBlueprint;
import com.avito.android.str_calendar.calendar.view.konveyor.items.empty.EmptyItemPresenter;
import com.avito.android.str_calendar.calendar.view.konveyor.items.month.MonthItemBlueprint;
import com.avito.android.str_calendar.calendar.view.konveyor.items.month.MonthItemPresenter;
import com.avito.android.str_calendar.di.component.StrBookingCalendarDependencies;
import com.avito.android.str_calendar.di.module.StrCalendarRecyclerCommon_ProvideAdapterPresenter$str_calendar_releaseFactory;
import com.avito.android.str_calendar.di.module.StrCalendarRecyclerCommon_ProvideEmptyItemBlueprint$str_calendar_releaseFactory;
import com.avito.android.str_calendar.di.module.StrCalendarRecyclerCommon_ProvideEmptyItemPresenter$str_calendar_releaseFactory;
import com.avito.android.str_calendar.di.module.StrCalendarRecyclerCommon_ProvideMonthItemBlueprint$str_calendar_releaseFactory;
import com.avito.android.str_calendar.di.module.StrCalendarRecyclerCommon_ProvideMonthItemPresenter$str_calendar_releaseFactory;
import com.avito.android.util.DeviceMetrics;
import com.avito.android.util.SchedulersFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import java.util.Date;
import java.util.List;
import javax.inject.Provider;
public final class DaggerInlineFilterCalendarComponent implements InlineFilterCalendarComponent {
    public Provider<AdapterPresenter> A;
    public final StrBookingCalendarDependencies a;
    public Provider<ShortTermRentApi> b;
    public Provider<SchedulersFactory> c;
    public Provider<TypedErrorThrowableConverter> d;
    public Provider<CalendarInteractorImpl> e;
    public Provider<CalendarInteractor> f;
    public Provider<Resources> g;
    public Provider<CalendarResourceProviderImpl> h;
    public Provider<CalendarResourceProvider> i;
    public Provider<Date> j;
    public Provider<Date> k;
    public Provider<RestrictionsDataSourceProvider> l;
    public Provider<CalendarDataSourceProvider<List<? extends CalendarBookingRestriction>>> m;
    public Provider<String> n;
    public Provider<InlineFilterValue.InlineFilterDateRangeValue> o;
    public Provider<Filter.Widget> p;
    public Provider<InlineFiltersCalendarViewModelImplFactory> q;
    public Provider<InlineFiltersCalendarViewModel> r;
    public Provider<CalendarViewTypeProvider> s = DoubleCheck.provider(CalendarViewTypeProviderImpl_Factory.create());
    public Provider<MonthItemPresenter> t;
    public Provider<MonthItemBlueprint> u;
    public Provider<DayItemPresenter> v;
    public Provider<DayItemBlueprint> w;
    public Provider<EmptyItemPresenter> x;
    public Provider<EmptyItemBlueprint> y;
    public Provider<ItemBinder> z;

    public static final class b implements InlineFilterCalendarComponent.Builder {
        public Resources a;
        public InlineFilterValue.InlineFilterDateRangeValue b;
        public Filter.Widget c;
        public String d;
        public Date e;
        public Date f;
        public StrBookingCalendarDependencies g;

        public b(a aVar) {
        }

        @Override // com.avito.android.inline_filters.di.InlineFilterCalendarComponent.Builder
        public InlineFilterCalendarComponent.Builder bindTitle(String str) {
            this.d = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.inline_filters.di.InlineFilterCalendarComponent.Builder
        public InlineFilterCalendarComponent.Builder bindValue(InlineFilterValue.InlineFilterDateRangeValue inlineFilterDateRangeValue) {
            this.b = inlineFilterDateRangeValue;
            return this;
        }

        @Override // com.avito.android.inline_filters.di.InlineFilterCalendarComponent.Builder
        public InlineFilterCalendarComponent.Builder bindWidget(Filter.Widget widget) {
            this.c = widget;
            return this;
        }

        @Override // com.avito.android.inline_filters.di.InlineFilterCalendarComponent.Builder
        public InlineFilterCalendarComponent.Builder bookingCalendarDependencies(StrBookingCalendarDependencies strBookingCalendarDependencies) {
            this.g = (StrBookingCalendarDependencies) Preconditions.checkNotNull(strBookingCalendarDependencies);
            return this;
        }

        @Override // com.avito.android.inline_filters.di.InlineFilterCalendarComponent.Builder
        public InlineFilterCalendarComponent build() {
            Preconditions.checkBuilderRequirement(this.a, Resources.class);
            Preconditions.checkBuilderRequirement(this.d, String.class);
            Preconditions.checkBuilderRequirement(this.g, StrBookingCalendarDependencies.class);
            return new DaggerInlineFilterCalendarComponent(this.g, this.a, this.b, this.c, this.d, this.e, this.f, null);
        }

        @Override // com.avito.android.inline_filters.di.InlineFilterCalendarComponent.Builder
        public InlineFilterCalendarComponent.Builder checkInDate(Date date) {
            this.e = date;
            return this;
        }

        @Override // com.avito.android.inline_filters.di.InlineFilterCalendarComponent.Builder
        public InlineFilterCalendarComponent.Builder checkOutDate(Date date) {
            this.f = date;
            return this;
        }

        @Override // com.avito.android.inline_filters.di.InlineFilterCalendarComponent.Builder
        public InlineFilterCalendarComponent.Builder resources(Resources resources) {
            this.a = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }
    }

    public static class c implements Provider<SchedulersFactory> {
        public final StrBookingCalendarDependencies a;

        public c(StrBookingCalendarDependencies strBookingCalendarDependencies) {
            this.a = strBookingCalendarDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class d implements Provider<ShortTermRentApi> {
        public final StrBookingCalendarDependencies a;

        public d(StrBookingCalendarDependencies strBookingCalendarDependencies) {
            this.a = strBookingCalendarDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ShortTermRentApi get() {
            return (ShortTermRentApi) Preconditions.checkNotNullFromComponent(this.a.shortTermRentApi());
        }
    }

    public static class e implements Provider<TypedErrorThrowableConverter> {
        public final StrBookingCalendarDependencies a;

        public e(StrBookingCalendarDependencies strBookingCalendarDependencies) {
            this.a = strBookingCalendarDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
        }
    }

    public DaggerInlineFilterCalendarComponent(StrBookingCalendarDependencies strBookingCalendarDependencies, Resources resources, InlineFilterValue.InlineFilterDateRangeValue inlineFilterDateRangeValue, Filter.Widget widget, String str, Date date, Date date2, a aVar) {
        this.a = strBookingCalendarDependencies;
        d dVar = new d(strBookingCalendarDependencies);
        this.b = dVar;
        c cVar = new c(strBookingCalendarDependencies);
        this.c = cVar;
        e eVar = new e(strBookingCalendarDependencies);
        this.d = eVar;
        CalendarInteractorImpl_Factory create = CalendarInteractorImpl_Factory.create(dVar, cVar, eVar);
        this.e = create;
        this.f = DoubleCheck.provider(create);
        Factory create2 = InstanceFactory.create(resources);
        this.g = create2;
        CalendarResourceProviderImpl_Factory create3 = CalendarResourceProviderImpl_Factory.create(create2);
        this.h = create3;
        this.i = DoubleCheck.provider(create3);
        this.j = InstanceFactory.createNullable(date);
        Factory createNullable = InstanceFactory.createNullable(date2);
        this.k = createNullable;
        RestrictionsDataSourceProvider_Factory create4 = RestrictionsDataSourceProvider_Factory.create(this.j, createNullable);
        this.l = create4;
        this.m = DoubleCheck.provider(create4);
        this.n = InstanceFactory.create(str);
        this.o = InstanceFactory.createNullable(inlineFilterDateRangeValue);
        Factory createNullable2 = InstanceFactory.createNullable(widget);
        this.p = createNullable2;
        InlineFiltersCalendarViewModelImplFactory_Factory create5 = InlineFiltersCalendarViewModelImplFactory_Factory.create(this.f, this.c, this.i, this.m, this.n, this.o, createNullable2);
        this.q = create5;
        this.r = DoubleCheck.provider(InlineFiltersCalendarModule_ProvideCalendarViewModel$serp_core_releaseFactory.create(create5));
        Provider<MonthItemPresenter> provider = DoubleCheck.provider(StrCalendarRecyclerCommon_ProvideMonthItemPresenter$str_calendar_releaseFactory.create());
        this.t = provider;
        this.u = DoubleCheck.provider(StrCalendarRecyclerCommon_ProvideMonthItemBlueprint$str_calendar_releaseFactory.create(provider));
        Provider<DayItemPresenter> provider2 = DoubleCheck.provider(InlineFiltersCalendarModule_ProvideDayItemPresenter$serp_core_releaseFactory.create(this.r));
        this.v = provider2;
        this.w = DayItemBlueprint_Factory.create(provider2);
        Provider<EmptyItemPresenter> provider3 = DoubleCheck.provider(StrCalendarRecyclerCommon_ProvideEmptyItemPresenter$str_calendar_releaseFactory.create());
        this.x = provider3;
        Provider<EmptyItemBlueprint> provider4 = DoubleCheck.provider(StrCalendarRecyclerCommon_ProvideEmptyItemBlueprint$str_calendar_releaseFactory.create(provider3));
        this.y = provider4;
        Provider<ItemBinder> provider5 = DoubleCheck.provider(InlineFiltersCalendarModule_ProvideItemBinder$serp_core_releaseFactory.create(this.u, this.w, provider4));
        this.z = provider5;
        this.A = DoubleCheck.provider(StrCalendarRecyclerCommon_ProvideAdapterPresenter$str_calendar_releaseFactory.create(this.s, provider5));
    }

    public static InlineFilterCalendarComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.inline_filters.di.InlineFilterCalendarComponent
    public void inject(InlineFiltersCalendarDialog inlineFiltersCalendarDialog) {
        InlineFiltersCalendarDialog_MembersInjector.injectAnalytics(inlineFiltersCalendarDialog, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        InlineFiltersCalendarDialog_MembersInjector.injectCalendarViewModel(inlineFiltersCalendarDialog, this.r.get());
        InlineFiltersCalendarDialog_MembersInjector.injectAdapterPresenter(inlineFiltersCalendarDialog, this.A.get());
        InlineFiltersCalendarDialog_MembersInjector.injectItemBinder(inlineFiltersCalendarDialog, this.z.get());
        InlineFiltersCalendarDialog_MembersInjector.injectDeviceMetrics(inlineFiltersCalendarDialog, (DeviceMetrics) Preconditions.checkNotNullFromComponent(this.a.deviceMetrics()));
        InlineFiltersCalendarDialog_MembersInjector.injectFeatures(inlineFiltersCalendarDialog, (Features) Preconditions.checkNotNullFromComponent(this.a.features()));
    }
}

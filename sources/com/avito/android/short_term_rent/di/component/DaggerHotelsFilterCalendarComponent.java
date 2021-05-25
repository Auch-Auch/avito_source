package com.avito.android.short_term_rent.di.component;

import android.content.res.Resources;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.remote.ShortTermRentApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.short_term_rent.di.component.HotelsFilterCalendarComponent;
import com.avito.android.short_term_rent.di.module.HotelsFiltersCalendarModule_ProvideCalendarViewModel$short_term_rent_releaseFactory;
import com.avito.android.short_term_rent.di.module.HotelsFiltersCalendarModule_ProvideDayItemPresenter$short_term_rent_releaseFactory;
import com.avito.android.short_term_rent.di.module.HotelsFiltersCalendarModule_ProvideItemBinder$short_term_rent_releaseFactory;
import com.avito.android.short_term_rent.hotels.data.HotelsCalendarRestrictions;
import com.avito.android.short_term_rent.hotels.dialogs.calendar.HotelsCalendarDialog;
import com.avito.android.short_term_rent.hotels.dialogs.calendar.HotelsCalendarDialog_MembersInjector;
import com.avito.android.short_term_rent.hotels.dialogs.calendar.HotelsCalendarViewModelImplFactory;
import com.avito.android.short_term_rent.hotels.dialogs.calendar.HotelsCalendarViewModelImplFactory_Factory;
import com.avito.android.short_term_rent.hotels.dialogs.calendar.HotelsFiltersCalendarViewModel;
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
import com.avito.android.str_calendar.utils.DateRange;
import com.avito.android.util.DeviceMetrics;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import java.util.Date;
import java.util.List;
import javax.inject.Provider;
public final class DaggerHotelsFilterCalendarComponent implements HotelsFilterCalendarComponent {
    public Provider<AdapterPresenter> A;
    public final StrBookingCalendarDependencies a;
    public Provider<ShortTermRentApi> b;
    public Provider<SchedulersFactory> c;
    public Provider<TypedErrorThrowableConverter> d;
    public Provider<CalendarInteractorImpl> e;
    public Provider<CalendarInteractor> f;
    public Provider<SchedulersFactory3> g;
    public Provider<Resources> h;
    public Provider<CalendarResourceProviderImpl> i;
    public Provider<CalendarResourceProvider> j;
    public Provider<Date> k;
    public Provider<Date> l;
    public Provider<RestrictionsDataSourceProvider> m;
    public Provider<CalendarDataSourceProvider<List<? extends CalendarBookingRestriction>>> n;
    public Provider<String> o;
    public Provider<HotelsCalendarRestrictions> p;
    public Provider<HotelsCalendarViewModelImplFactory> q;
    public Provider<HotelsFiltersCalendarViewModel> r;
    public Provider<CalendarViewTypeProvider> s = DoubleCheck.provider(CalendarViewTypeProviderImpl_Factory.create());
    public Provider<MonthItemPresenter> t;
    public Provider<MonthItemBlueprint> u;
    public Provider<DayItemPresenter> v;
    public Provider<DayItemBlueprint> w;
    public Provider<EmptyItemPresenter> x;
    public Provider<EmptyItemBlueprint> y;
    public Provider<ItemBinder> z;

    public static final class b implements HotelsFilterCalendarComponent.Builder {
        public Resources a;
        public DateRange b;
        public HotelsCalendarRestrictions c;
        public String d;
        public Date e;
        public Date f;
        public StrBookingCalendarDependencies g;

        public b(a aVar) {
        }

        @Override // com.avito.android.short_term_rent.di.component.HotelsFilterCalendarComponent.Builder
        public HotelsFilterCalendarComponent.Builder bindRestrictions(HotelsCalendarRestrictions hotelsCalendarRestrictions) {
            this.c = hotelsCalendarRestrictions;
            return this;
        }

        @Override // com.avito.android.short_term_rent.di.component.HotelsFilterCalendarComponent.Builder
        public HotelsFilterCalendarComponent.Builder bindTitle(String str) {
            this.d = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.short_term_rent.di.component.HotelsFilterCalendarComponent.Builder
        public HotelsFilterCalendarComponent.Builder bindValue(DateRange dateRange) {
            this.b = (DateRange) Preconditions.checkNotNull(dateRange);
            return this;
        }

        @Override // com.avito.android.short_term_rent.di.component.HotelsFilterCalendarComponent.Builder
        public HotelsFilterCalendarComponent.Builder bookingCalendarDependencies(StrBookingCalendarDependencies strBookingCalendarDependencies) {
            this.g = (StrBookingCalendarDependencies) Preconditions.checkNotNull(strBookingCalendarDependencies);
            return this;
        }

        @Override // com.avito.android.short_term_rent.di.component.HotelsFilterCalendarComponent.Builder
        public HotelsFilterCalendarComponent build() {
            Preconditions.checkBuilderRequirement(this.a, Resources.class);
            Preconditions.checkBuilderRequirement(this.b, DateRange.class);
            Preconditions.checkBuilderRequirement(this.d, String.class);
            Preconditions.checkBuilderRequirement(this.g, StrBookingCalendarDependencies.class);
            return new DaggerHotelsFilterCalendarComponent(this.g, this.a, this.b, this.c, this.d, this.e, this.f, null);
        }

        @Override // com.avito.android.short_term_rent.di.component.HotelsFilterCalendarComponent.Builder
        public HotelsFilterCalendarComponent.Builder checkInDate(Date date) {
            this.e = date;
            return this;
        }

        @Override // com.avito.android.short_term_rent.di.component.HotelsFilterCalendarComponent.Builder
        public HotelsFilterCalendarComponent.Builder checkOutDate(Date date) {
            this.f = date;
            return this;
        }

        @Override // com.avito.android.short_term_rent.di.component.HotelsFilterCalendarComponent.Builder
        public HotelsFilterCalendarComponent.Builder resources(Resources resources) {
            this.a = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }
    }

    public static class c implements Provider<SchedulersFactory3> {
        public final StrBookingCalendarDependencies a;

        public c(StrBookingCalendarDependencies strBookingCalendarDependencies) {
            this.a = strBookingCalendarDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class d implements Provider<SchedulersFactory> {
        public final StrBookingCalendarDependencies a;

        public d(StrBookingCalendarDependencies strBookingCalendarDependencies) {
            this.a = strBookingCalendarDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class e implements Provider<ShortTermRentApi> {
        public final StrBookingCalendarDependencies a;

        public e(StrBookingCalendarDependencies strBookingCalendarDependencies) {
            this.a = strBookingCalendarDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ShortTermRentApi get() {
            return (ShortTermRentApi) Preconditions.checkNotNullFromComponent(this.a.shortTermRentApi());
        }
    }

    public static class f implements Provider<TypedErrorThrowableConverter> {
        public final StrBookingCalendarDependencies a;

        public f(StrBookingCalendarDependencies strBookingCalendarDependencies) {
            this.a = strBookingCalendarDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
        }
    }

    public DaggerHotelsFilterCalendarComponent(StrBookingCalendarDependencies strBookingCalendarDependencies, Resources resources, DateRange dateRange, HotelsCalendarRestrictions hotelsCalendarRestrictions, String str, Date date, Date date2, a aVar) {
        this.a = strBookingCalendarDependencies;
        e eVar = new e(strBookingCalendarDependencies);
        this.b = eVar;
        d dVar = new d(strBookingCalendarDependencies);
        this.c = dVar;
        f fVar = new f(strBookingCalendarDependencies);
        this.d = fVar;
        CalendarInteractorImpl_Factory create = CalendarInteractorImpl_Factory.create(eVar, dVar, fVar);
        this.e = create;
        this.f = DoubleCheck.provider(create);
        this.g = new c(strBookingCalendarDependencies);
        Factory create2 = InstanceFactory.create(resources);
        this.h = create2;
        CalendarResourceProviderImpl_Factory create3 = CalendarResourceProviderImpl_Factory.create(create2);
        this.i = create3;
        this.j = DoubleCheck.provider(create3);
        this.k = InstanceFactory.createNullable(date);
        Factory createNullable = InstanceFactory.createNullable(date2);
        this.l = createNullable;
        RestrictionsDataSourceProvider_Factory create4 = RestrictionsDataSourceProvider_Factory.create(this.k, createNullable);
        this.m = create4;
        this.n = DoubleCheck.provider(create4);
        this.o = InstanceFactory.create(str);
        Factory createNullable2 = InstanceFactory.createNullable(hotelsCalendarRestrictions);
        this.p = createNullable2;
        HotelsCalendarViewModelImplFactory_Factory create5 = HotelsCalendarViewModelImplFactory_Factory.create(this.f, this.g, this.j, this.n, this.o, createNullable2);
        this.q = create5;
        this.r = DoubleCheck.provider(HotelsFiltersCalendarModule_ProvideCalendarViewModel$short_term_rent_releaseFactory.create(create5));
        Provider<MonthItemPresenter> provider = DoubleCheck.provider(StrCalendarRecyclerCommon_ProvideMonthItemPresenter$str_calendar_releaseFactory.create());
        this.t = provider;
        this.u = DoubleCheck.provider(StrCalendarRecyclerCommon_ProvideMonthItemBlueprint$str_calendar_releaseFactory.create(provider));
        Provider<DayItemPresenter> provider2 = DoubleCheck.provider(HotelsFiltersCalendarModule_ProvideDayItemPresenter$short_term_rent_releaseFactory.create(this.r));
        this.v = provider2;
        this.w = DayItemBlueprint_Factory.create(provider2);
        Provider<EmptyItemPresenter> provider3 = DoubleCheck.provider(StrCalendarRecyclerCommon_ProvideEmptyItemPresenter$str_calendar_releaseFactory.create());
        this.x = provider3;
        Provider<EmptyItemBlueprint> provider4 = DoubleCheck.provider(StrCalendarRecyclerCommon_ProvideEmptyItemBlueprint$str_calendar_releaseFactory.create(provider3));
        this.y = provider4;
        Provider<ItemBinder> provider5 = DoubleCheck.provider(HotelsFiltersCalendarModule_ProvideItemBinder$short_term_rent_releaseFactory.create(this.u, this.w, provider4));
        this.z = provider5;
        this.A = DoubleCheck.provider(StrCalendarRecyclerCommon_ProvideAdapterPresenter$str_calendar_releaseFactory.create(this.s, provider5));
    }

    public static HotelsFilterCalendarComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.short_term_rent.di.component.HotelsFilterCalendarComponent
    public void inject(HotelsCalendarDialog hotelsCalendarDialog) {
        HotelsCalendarDialog_MembersInjector.injectAnalytics(hotelsCalendarDialog, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        HotelsCalendarDialog_MembersInjector.injectCalendarViewModel(hotelsCalendarDialog, this.r.get());
        HotelsCalendarDialog_MembersInjector.injectAdapterPresenter(hotelsCalendarDialog, this.A.get());
        HotelsCalendarDialog_MembersInjector.injectItemBinder(hotelsCalendarDialog, this.z.get());
        HotelsCalendarDialog_MembersInjector.injectDeviceMetrics(hotelsCalendarDialog, (DeviceMetrics) Preconditions.checkNotNullFromComponent(this.a.deviceMetrics()));
        HotelsCalendarDialog_MembersInjector.injectFeatures(hotelsCalendarDialog, (Features) Preconditions.checkNotNullFromComponent(this.a.features()));
    }
}

package com.avito.android.str_calendar.di.component;

import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.remote.ShortTermRentApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.server_time.TimeSource;
import com.avito.android.str_calendar.analytics.StrAnalyticsTracker;
import com.avito.android.str_calendar.analytics.StrAnalyticsTrackerImpl;
import com.avito.android.str_calendar.analytics.StrAnalyticsTrackerImpl_Factory;
import com.avito.android.str_calendar.booking.CalendarFragment;
import com.avito.android.str_calendar.booking.CalendarFragment_MembersInjector;
import com.avito.android.str_calendar.booking.CalendarInteractor;
import com.avito.android.str_calendar.booking.CalendarInteractorImpl;
import com.avito.android.str_calendar.booking.CalendarInteractorImpl_Factory;
import com.avito.android.str_calendar.booking.CalendarResourceProvider;
import com.avito.android.str_calendar.booking.CalendarResourceProviderImpl;
import com.avito.android.str_calendar.booking.CalendarResourceProviderImpl_Factory;
import com.avito.android.str_calendar.booking.CalendarViewModel;
import com.avito.android.str_calendar.booking.CalendarViewModelFactory;
import com.avito.android.str_calendar.booking.model.BookingCalendarItem;
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
import com.avito.android.str_calendar.di.component.StrBookingCalendarComponent;
import com.avito.android.str_calendar.di.module.StrBookingCalendarModule_ProvideCalendarDataSourceProvider$str_calendar_releaseFactory;
import com.avito.android.str_calendar.di.module.StrBookingCalendarModule_ProvideCalendarViewModel$str_calendar_releaseFactory;
import com.avito.android.str_calendar.di.module.StrBookingCalendarModule_ProvideCalendarViewModelFactory$str_calendar_releaseFactory;
import com.avito.android.str_calendar.di.module.StrBookingCalendarModule_ProvideDayItemPresenter$str_calendar_releaseFactory;
import com.avito.android.str_calendar.di.module.StrBookingCalendarModule_ProvideItemBinder$str_calendar_releaseFactory;
import com.avito.android.str_calendar.di.module.StrBookingCalendarModule_ProvideNewCalendarDataSourceProvider$str_calendar_releaseFactory;
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
public final class DaggerStrBookingCalendarComponent implements StrBookingCalendarComponent {
    public Provider<EmptyItemPresenter> A;
    public Provider<EmptyItemBlueprint> B;
    public Provider<ItemBinder> C;
    public Provider<AdapterPresenter> D;
    public final StrBookingCalendarDependencies a;
    public Provider<Fragment> b;
    public Provider<ShortTermRentApi> c;
    public Provider<SchedulersFactory> d;
    public Provider<TypedErrorThrowableConverter> e;
    public Provider<CalendarInteractorImpl> f;
    public Provider<CalendarInteractor> g;
    public Provider<TimeSource> h;
    public Provider<Resources> i;
    public Provider<CalendarResourceProviderImpl> j;
    public Provider<CalendarResourceProvider> k;
    public Provider<Analytics> l;
    public Provider<StrAnalyticsTrackerImpl> m;
    public Provider<StrAnalyticsTracker> n;
    public Provider<Date> o;
    public Provider<Date> p;
    public Provider<CalendarDataSourceProvider<List<CalendarBookingRestriction>>> q;
    public Provider<CalendarDataSourceProvider<List<BookingCalendarItem>>> r = DoubleCheck.provider(StrBookingCalendarModule_ProvideNewCalendarDataSourceProvider$str_calendar_releaseFactory.create(this.o, this.p));
    public Provider<String> s;
    public Provider<CalendarViewModelFactory> t;
    public Provider<CalendarViewModel> u;
    public Provider<CalendarViewTypeProvider> v;
    public Provider<MonthItemPresenter> w;
    public Provider<MonthItemBlueprint> x;
    public Provider<DayItemPresenter> y;
    public Provider<DayItemBlueprint> z;

    public static final class b implements StrBookingCalendarComponent.Builder {
        public Resources a;
        public Fragment b;
        public String c;
        public Date d;
        public Date e;
        public StrBookingCalendarDependencies f;

        public b(a aVar) {
        }

        @Override // com.avito.android.str_calendar.di.component.StrBookingCalendarComponent.Builder
        public StrBookingCalendarComponent.Builder advertId(String str) {
            this.c = str;
            return this;
        }

        @Override // com.avito.android.str_calendar.di.component.StrBookingCalendarComponent.Builder
        public StrBookingCalendarComponent.Builder bookingCalendarDependencies(StrBookingCalendarDependencies strBookingCalendarDependencies) {
            this.f = (StrBookingCalendarDependencies) Preconditions.checkNotNull(strBookingCalendarDependencies);
            return this;
        }

        @Override // com.avito.android.str_calendar.di.component.StrBookingCalendarComponent.Builder
        public StrBookingCalendarComponent build() {
            Preconditions.checkBuilderRequirement(this.a, Resources.class);
            Preconditions.checkBuilderRequirement(this.b, Fragment.class);
            Preconditions.checkBuilderRequirement(this.f, StrBookingCalendarDependencies.class);
            return new DaggerStrBookingCalendarComponent(this.f, this.a, this.b, this.c, this.d, this.e, null);
        }

        @Override // com.avito.android.str_calendar.di.component.StrBookingCalendarComponent.Builder
        public StrBookingCalendarComponent.Builder checkInDate(Date date) {
            this.d = date;
            return this;
        }

        @Override // com.avito.android.str_calendar.di.component.StrBookingCalendarComponent.Builder
        public StrBookingCalendarComponent.Builder checkOutDate(Date date) {
            this.e = date;
            return this;
        }

        @Override // com.avito.android.str_calendar.di.component.StrBookingCalendarComponent.Builder
        public StrBookingCalendarComponent.Builder resources(Resources resources) {
            this.a = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.str_calendar.di.component.StrBookingCalendarComponent.Builder
        public StrBookingCalendarComponent.Builder viewModelFragment(Fragment fragment) {
            this.b = (Fragment) Preconditions.checkNotNull(fragment);
            return this;
        }
    }

    public static class c implements Provider<Analytics> {
        public final StrBookingCalendarDependencies a;

        public c(StrBookingCalendarDependencies strBookingCalendarDependencies) {
            this.a = strBookingCalendarDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
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

    public static class f implements Provider<TimeSource> {
        public final StrBookingCalendarDependencies a;

        public f(StrBookingCalendarDependencies strBookingCalendarDependencies) {
            this.a = strBookingCalendarDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimeSource get() {
            return (TimeSource) Preconditions.checkNotNullFromComponent(this.a.timeSource());
        }
    }

    public static class g implements Provider<TypedErrorThrowableConverter> {
        public final StrBookingCalendarDependencies a;

        public g(StrBookingCalendarDependencies strBookingCalendarDependencies) {
            this.a = strBookingCalendarDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
        }
    }

    public DaggerStrBookingCalendarComponent(StrBookingCalendarDependencies strBookingCalendarDependencies, Resources resources, Fragment fragment, String str, Date date, Date date2, a aVar) {
        this.a = strBookingCalendarDependencies;
        this.b = InstanceFactory.create(fragment);
        e eVar = new e(strBookingCalendarDependencies);
        this.c = eVar;
        d dVar = new d(strBookingCalendarDependencies);
        this.d = dVar;
        g gVar = new g(strBookingCalendarDependencies);
        this.e = gVar;
        CalendarInteractorImpl_Factory create = CalendarInteractorImpl_Factory.create(eVar, dVar, gVar);
        this.f = create;
        this.g = DoubleCheck.provider(create);
        this.h = new f(strBookingCalendarDependencies);
        Factory create2 = InstanceFactory.create(resources);
        this.i = create2;
        CalendarResourceProviderImpl_Factory create3 = CalendarResourceProviderImpl_Factory.create(create2);
        this.j = create3;
        this.k = DoubleCheck.provider(create3);
        c cVar = new c(strBookingCalendarDependencies);
        this.l = cVar;
        StrAnalyticsTrackerImpl_Factory create4 = StrAnalyticsTrackerImpl_Factory.create(cVar);
        this.m = create4;
        this.n = DoubleCheck.provider(create4);
        this.o = InstanceFactory.createNullable(date);
        Factory createNullable = InstanceFactory.createNullable(date2);
        this.p = createNullable;
        this.q = DoubleCheck.provider(StrBookingCalendarModule_ProvideCalendarDataSourceProvider$str_calendar_releaseFactory.create(this.o, createNullable));
        Factory createNullable2 = InstanceFactory.createNullable(str);
        this.s = createNullable2;
        Provider<CalendarViewModelFactory> provider = DoubleCheck.provider(StrBookingCalendarModule_ProvideCalendarViewModelFactory$str_calendar_releaseFactory.create(this.g, this.d, this.h, this.k, this.n, this.q, this.r, createNullable2, this.o, this.p));
        this.t = provider;
        this.u = DoubleCheck.provider(StrBookingCalendarModule_ProvideCalendarViewModel$str_calendar_releaseFactory.create(this.b, provider));
        this.v = DoubleCheck.provider(CalendarViewTypeProviderImpl_Factory.create());
        Provider<MonthItemPresenter> provider2 = DoubleCheck.provider(StrCalendarRecyclerCommon_ProvideMonthItemPresenter$str_calendar_releaseFactory.create());
        this.w = provider2;
        this.x = DoubleCheck.provider(StrCalendarRecyclerCommon_ProvideMonthItemBlueprint$str_calendar_releaseFactory.create(provider2));
        Provider<DayItemPresenter> provider3 = DoubleCheck.provider(StrBookingCalendarModule_ProvideDayItemPresenter$str_calendar_releaseFactory.create(this.u));
        this.y = provider3;
        this.z = DayItemBlueprint_Factory.create(provider3);
        Provider<EmptyItemPresenter> provider4 = DoubleCheck.provider(StrCalendarRecyclerCommon_ProvideEmptyItemPresenter$str_calendar_releaseFactory.create());
        this.A = provider4;
        Provider<EmptyItemBlueprint> provider5 = DoubleCheck.provider(StrCalendarRecyclerCommon_ProvideEmptyItemBlueprint$str_calendar_releaseFactory.create(provider4));
        this.B = provider5;
        Provider<ItemBinder> provider6 = DoubleCheck.provider(StrBookingCalendarModule_ProvideItemBinder$str_calendar_releaseFactory.create(this.x, this.z, provider5));
        this.C = provider6;
        this.D = DoubleCheck.provider(StrCalendarRecyclerCommon_ProvideAdapterPresenter$str_calendar_releaseFactory.create(this.v, provider6));
    }

    public static StrBookingCalendarComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.str_calendar.di.component.StrBookingCalendarComponent
    public void inject(CalendarFragment calendarFragment) {
        CalendarFragment_MembersInjector.injectAnalytics(calendarFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        CalendarFragment_MembersInjector.injectCalendarViewModel(calendarFragment, this.u.get());
        CalendarFragment_MembersInjector.injectAdapterPresenter(calendarFragment, this.D.get());
        CalendarFragment_MembersInjector.injectItemBinder(calendarFragment, this.C.get());
        CalendarFragment_MembersInjector.injectDeviceMetrics(calendarFragment, (DeviceMetrics) Preconditions.checkNotNullFromComponent(this.a.deviceMetrics()));
        CalendarFragment_MembersInjector.injectFeatures(calendarFragment, (Features) Preconditions.checkNotNullFromComponent(this.a.features()));
    }
}

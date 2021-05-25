package com.avito.android.str_calendar.di.component;

import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import com.avito.android.analytics.Analytics;
import com.avito.android.remote.ShortTermRentApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.str_calendar.calendar.view.data.CalendarDataSourceProvider;
import com.avito.android.str_calendar.calendar.view.konveyor.CalendarViewTypeProvider;
import com.avito.android.str_calendar.calendar.view.konveyor.CalendarViewTypeProviderImpl_Factory;
import com.avito.android.str_calendar.calendar.view.konveyor.items.day.seller.SellerDayItemBackgroundsProvider;
import com.avito.android.str_calendar.calendar.view.konveyor.items.day.seller.SellerDayItemBlueprint;
import com.avito.android.str_calendar.calendar.view.konveyor.items.day.seller.SellerDayItemPresenter;
import com.avito.android.str_calendar.calendar.view.konveyor.items.empty.EmptyItemBlueprint;
import com.avito.android.str_calendar.calendar.view.konveyor.items.empty.EmptyItemPresenter;
import com.avito.android.str_calendar.calendar.view.konveyor.items.month.MonthItemBlueprint;
import com.avito.android.str_calendar.calendar.view.konveyor.items.month.MonthItemPresenter;
import com.avito.android.str_calendar.di.component.StrSellerCalendarComponent;
import com.avito.android.str_calendar.di.module.StrCalendarRecyclerCommon_ProvideAdapterPresenter$str_calendar_releaseFactory;
import com.avito.android.str_calendar.di.module.StrCalendarRecyclerCommon_ProvideEmptyItemBlueprint$str_calendar_releaseFactory;
import com.avito.android.str_calendar.di.module.StrCalendarRecyclerCommon_ProvideEmptyItemPresenter$str_calendar_releaseFactory;
import com.avito.android.str_calendar.di.module.StrCalendarRecyclerCommon_ProvideMonthItemBlueprint$str_calendar_releaseFactory;
import com.avito.android.str_calendar.di.module.StrCalendarRecyclerCommon_ProvideMonthItemPresenter$str_calendar_releaseFactory;
import com.avito.android.str_calendar.di.module.StrSellerCalendarModule_ProvideCalendarDataSourceProvider$str_calendar_releaseFactory;
import com.avito.android.str_calendar.di.module.StrSellerCalendarModule_ProvideCalendarViewModelFactory$str_calendar_releaseFactory;
import com.avito.android.str_calendar.di.module.StrSellerCalendarModule_ProvideDayItemBackgroundsProvider$str_calendar_releaseFactory;
import com.avito.android.str_calendar.di.module.StrSellerCalendarModule_ProvideDayItemBlueprint$str_calendar_releaseFactory;
import com.avito.android.str_calendar.di.module.StrSellerCalendarModule_ProvideItemBinder$str_calendar_releaseFactory;
import com.avito.android.str_calendar.di.module.StrSellerCalendarModule_ProvideSellerCalendarViewModel$str_calendar_releaseFactory;
import com.avito.android.str_calendar.di.module.StrSellerCalendarModule_ProvideSellerDayItemPresenter$str_calendar_releaseFactory;
import com.avito.android.str_calendar.seller.SellerCalendarRouter;
import com.avito.android.str_calendar.seller.calendar.SellerCalendarFragment;
import com.avito.android.str_calendar.seller.calendar.SellerCalendarFragment_MembersInjector;
import com.avito.android.str_calendar.seller.calendar.SellerCalendarInteractor;
import com.avito.android.str_calendar.seller.calendar.SellerCalendarInteractorImpl;
import com.avito.android.str_calendar.seller.calendar.SellerCalendarInteractorImpl_Factory;
import com.avito.android.str_calendar.seller.calendar.SellerCalendarResourceProvider;
import com.avito.android.str_calendar.seller.calendar.SellerCalendarResourceProviderImpl;
import com.avito.android.str_calendar.seller.calendar.SellerCalendarResourceProviderImpl_Factory;
import com.avito.android.str_calendar.seller.calendar.SellerCalendarViewModel;
import com.avito.android.str_calendar.seller.calendar.SellerCalendarViewModelFactory;
import com.avito.android.str_calendar.seller.calendar.model.SellerCalendarInfo;
import com.avito.android.util.SchedulersFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerStrSellerCalendarComponent implements StrSellerCalendarComponent {
    public final StrSellerCalendarDependencies a;
    public final SellerCalendarRouter b;
    public Provider<Fragment> c;
    public Provider<ShortTermRentApi> d;
    public Provider<SchedulersFactory> e;
    public Provider<TypedErrorThrowableConverter> f;
    public Provider<SellerCalendarInteractorImpl> g;
    public Provider<SellerCalendarInteractor> h;
    public Provider<String> i;
    public Provider<CalendarDataSourceProvider<SellerCalendarInfo>> j = DoubleCheck.provider(StrSellerCalendarModule_ProvideCalendarDataSourceProvider$str_calendar_releaseFactory.create());
    public Provider<Resources> k;
    public Provider<SellerCalendarResourceProviderImpl> l;
    public Provider<SellerCalendarResourceProvider> m;
    public Provider<SellerCalendarViewModelFactory> n;
    public Provider<SellerCalendarViewModel> o;
    public Provider<CalendarViewTypeProvider> p;
    public Provider<MonthItemPresenter> q;
    public Provider<MonthItemBlueprint> r;
    public Provider<SellerDayItemPresenter> s;
    public Provider<SellerDayItemBackgroundsProvider> t;
    public Provider<SellerDayItemBlueprint> u;
    public Provider<EmptyItemPresenter> v;
    public Provider<EmptyItemBlueprint> w;
    public Provider<ItemBinder> x;
    public Provider<AdapterPresenter> y;

    public static final class b implements StrSellerCalendarComponent.Builder {
        public Resources a;
        public String b;
        public Fragment c;
        public SellerCalendarRouter d;
        public StrSellerCalendarDependencies e;

        public b(a aVar) {
        }

        @Override // com.avito.android.str_calendar.di.component.StrSellerCalendarComponent.Builder
        public StrSellerCalendarComponent.Builder advertId(String str) {
            this.b = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.str_calendar.di.component.StrSellerCalendarComponent.Builder
        public StrSellerCalendarComponent build() {
            Preconditions.checkBuilderRequirement(this.a, Resources.class);
            Preconditions.checkBuilderRequirement(this.b, String.class);
            Preconditions.checkBuilderRequirement(this.c, Fragment.class);
            Preconditions.checkBuilderRequirement(this.d, SellerCalendarRouter.class);
            Preconditions.checkBuilderRequirement(this.e, StrSellerCalendarDependencies.class);
            return new DaggerStrSellerCalendarComponent(this.e, this.a, this.b, this.c, this.d, null);
        }

        @Override // com.avito.android.str_calendar.di.component.StrSellerCalendarComponent.Builder
        public StrSellerCalendarComponent.Builder resources(Resources resources) {
            this.a = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.str_calendar.di.component.StrSellerCalendarComponent.Builder
        public StrSellerCalendarComponent.Builder router(SellerCalendarRouter sellerCalendarRouter) {
            this.d = (SellerCalendarRouter) Preconditions.checkNotNull(sellerCalendarRouter);
            return this;
        }

        @Override // com.avito.android.str_calendar.di.component.StrSellerCalendarComponent.Builder
        public StrSellerCalendarComponent.Builder sellerCalendarDependencies(StrSellerCalendarDependencies strSellerCalendarDependencies) {
            this.e = (StrSellerCalendarDependencies) Preconditions.checkNotNull(strSellerCalendarDependencies);
            return this;
        }

        @Override // com.avito.android.str_calendar.di.component.StrSellerCalendarComponent.Builder
        public StrSellerCalendarComponent.Builder viewModelFragment(Fragment fragment) {
            this.c = (Fragment) Preconditions.checkNotNull(fragment);
            return this;
        }
    }

    public static class c implements Provider<SchedulersFactory> {
        public final StrSellerCalendarDependencies a;

        public c(StrSellerCalendarDependencies strSellerCalendarDependencies) {
            this.a = strSellerCalendarDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class d implements Provider<ShortTermRentApi> {
        public final StrSellerCalendarDependencies a;

        public d(StrSellerCalendarDependencies strSellerCalendarDependencies) {
            this.a = strSellerCalendarDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ShortTermRentApi get() {
            return (ShortTermRentApi) Preconditions.checkNotNullFromComponent(this.a.shortTermRentApi());
        }
    }

    public static class e implements Provider<TypedErrorThrowableConverter> {
        public final StrSellerCalendarDependencies a;

        public e(StrSellerCalendarDependencies strSellerCalendarDependencies) {
            this.a = strSellerCalendarDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
        }
    }

    public DaggerStrSellerCalendarComponent(StrSellerCalendarDependencies strSellerCalendarDependencies, Resources resources, String str, Fragment fragment, SellerCalendarRouter sellerCalendarRouter, a aVar) {
        this.a = strSellerCalendarDependencies;
        this.b = sellerCalendarRouter;
        this.c = InstanceFactory.create(fragment);
        d dVar = new d(strSellerCalendarDependencies);
        this.d = dVar;
        c cVar = new c(strSellerCalendarDependencies);
        this.e = cVar;
        e eVar = new e(strSellerCalendarDependencies);
        this.f = eVar;
        SellerCalendarInteractorImpl_Factory create = SellerCalendarInteractorImpl_Factory.create(dVar, cVar, eVar);
        this.g = create;
        this.h = DoubleCheck.provider(create);
        this.i = InstanceFactory.create(str);
        Factory create2 = InstanceFactory.create(resources);
        this.k = create2;
        SellerCalendarResourceProviderImpl_Factory create3 = SellerCalendarResourceProviderImpl_Factory.create(create2);
        this.l = create3;
        Provider<SellerCalendarResourceProvider> provider = DoubleCheck.provider(create3);
        this.m = provider;
        Provider<SellerCalendarViewModelFactory> provider2 = DoubleCheck.provider(StrSellerCalendarModule_ProvideCalendarViewModelFactory$str_calendar_releaseFactory.create(this.h, this.e, this.i, this.j, provider));
        this.n = provider2;
        this.o = DoubleCheck.provider(StrSellerCalendarModule_ProvideSellerCalendarViewModel$str_calendar_releaseFactory.create(this.c, provider2));
        this.p = DoubleCheck.provider(CalendarViewTypeProviderImpl_Factory.create());
        Provider<MonthItemPresenter> provider3 = DoubleCheck.provider(StrCalendarRecyclerCommon_ProvideMonthItemPresenter$str_calendar_releaseFactory.create());
        this.q = provider3;
        this.r = DoubleCheck.provider(StrCalendarRecyclerCommon_ProvideMonthItemBlueprint$str_calendar_releaseFactory.create(provider3));
        this.s = DoubleCheck.provider(StrSellerCalendarModule_ProvideSellerDayItemPresenter$str_calendar_releaseFactory.create(this.o));
        Provider<SellerDayItemBackgroundsProvider> provider4 = DoubleCheck.provider(StrSellerCalendarModule_ProvideDayItemBackgroundsProvider$str_calendar_releaseFactory.create());
        this.t = provider4;
        this.u = DoubleCheck.provider(StrSellerCalendarModule_ProvideDayItemBlueprint$str_calendar_releaseFactory.create(this.s, provider4));
        Provider<EmptyItemPresenter> provider5 = DoubleCheck.provider(StrCalendarRecyclerCommon_ProvideEmptyItemPresenter$str_calendar_releaseFactory.create());
        this.v = provider5;
        Provider<EmptyItemBlueprint> provider6 = DoubleCheck.provider(StrCalendarRecyclerCommon_ProvideEmptyItemBlueprint$str_calendar_releaseFactory.create(provider5));
        this.w = provider6;
        Provider<ItemBinder> provider7 = DoubleCheck.provider(StrSellerCalendarModule_ProvideItemBinder$str_calendar_releaseFactory.create(this.r, this.u, provider6));
        this.x = provider7;
        this.y = DoubleCheck.provider(StrCalendarRecyclerCommon_ProvideAdapterPresenter$str_calendar_releaseFactory.create(this.p, provider7));
    }

    public static StrSellerCalendarComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.str_calendar.di.component.StrSellerCalendarComponent
    public void inject(SellerCalendarFragment sellerCalendarFragment) {
        SellerCalendarFragment_MembersInjector.injectViewModel(sellerCalendarFragment, this.o.get());
        SellerCalendarFragment_MembersInjector.injectAnalytics(sellerCalendarFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        SellerCalendarFragment_MembersInjector.injectAdapterPresenter(sellerCalendarFragment, this.y.get());
        SellerCalendarFragment_MembersInjector.injectItemBinder(sellerCalendarFragment, this.x.get());
        SellerCalendarFragment_MembersInjector.injectResourceProvider(sellerCalendarFragment, this.m.get());
        SellerCalendarFragment_MembersInjector.injectRouter(sellerCalendarFragment, this.b);
    }
}

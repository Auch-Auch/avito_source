package com.avito.android.short_term_rent.di.component;

import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.recycler.data_aware.DiffCalculator;
import com.avito.android.remote.ShortTermRentApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.short_term_rent.analytics.StrAnalyticsTracker;
import com.avito.android.short_term_rent.analytics.StrAnalyticsTrackerImpl;
import com.avito.android.short_term_rent.analytics.StrAnalyticsTrackerImpl_Factory;
import com.avito.android.short_term_rent.di.component.StrStartBookingComponent;
import com.avito.android.short_term_rent.di.module.StrStartBookingModule_ProvideAdapterPresenter$short_term_rent_releaseFactory;
import com.avito.android.short_term_rent.di.module.StrStartBookingModule_ProvideContentsComparator$short_term_rent_releaseFactory;
import com.avito.android.short_term_rent.di.module.StrStartBookingModule_ProvideDataAwareAdapterPresenter$short_term_rent_releaseFactory;
import com.avito.android.short_term_rent.di.module.StrStartBookingModule_ProvideDiffCalculator$short_term_rent_releaseFactory;
import com.avito.android.short_term_rent.di.module.StrStartBookingModule_ProvideDisclaimerItemBlueprint$short_term_rent_releaseFactory;
import com.avito.android.short_term_rent.di.module.StrStartBookingModule_ProvideDisclaimerItemPresenter$short_term_rent_releaseFactory;
import com.avito.android.short_term_rent.di.module.StrStartBookingModule_ProvideGuestCountClickListener$short_term_rent_releaseFactory;
import com.avito.android.short_term_rent.di.module.StrStartBookingModule_ProvideGuestCountItemPresenterFactory;
import com.avito.android.short_term_rent.di.module.StrStartBookingModule_ProvideGuestsCountBluePrint$short_term_rent_releaseFactory;
import com.avito.android.short_term_rent.di.module.StrStartBookingModule_ProvideGuestsCountsProvider$short_term_rent_releaseFactory;
import com.avito.android.short_term_rent.di.module.StrStartBookingModule_ProvideItemBinder$short_term_rent_releaseFactory;
import com.avito.android.short_term_rent.di.module.StrStartBookingModule_ProvideListUpdateCallback$short_term_rent_releaseFactory;
import com.avito.android.short_term_rent.di.module.StrStartBookingModule_ProvideRecyclerAdapterFactory;
import com.avito.android.short_term_rent.di.module.StrStartBookingModule_ProvideSelectItemBlueprint$short_term_rent_releaseFactory;
import com.avito.android.short_term_rent.di.module.StrStartBookingModule_ProvideSelectItemClearConsumer$short_term_rent_releaseFactory;
import com.avito.android.short_term_rent.di.module.StrStartBookingModule_ProvideSelectItemClickConsumer$short_term_rent_releaseFactory;
import com.avito.android.short_term_rent.di.module.StrStartBookingModule_ProvideSelectItemPresenter$short_term_rent_releaseFactory;
import com.avito.android.short_term_rent.di.module.StrStartBookingModule_ProvideStrStartBookingViewModel$short_term_rent_releaseFactory;
import com.avito.android.short_term_rent.di.module.StrStartBookingModule_ProvideStrStartBookingViewModelFactory$short_term_rent_releaseFactory;
import com.avito.android.short_term_rent.di.module.StrStartBookingModule_ProvideSummaryItemBlueprint$short_term_rent_releaseFactory;
import com.avito.android.short_term_rent.di.module.StrStartBookingModule_ProvideSummaryItemPresenter$short_term_rent_releaseFactory;
import com.avito.android.short_term_rent.di.module.StrStartBookingModule_ProvideSummaryLoadingItemBlueprint$short_term_rent_releaseFactory;
import com.avito.android.short_term_rent.di.module.StrStartBookingModule_ProvideSummaryLoadingItemPresenter$short_term_rent_releaseFactory;
import com.avito.android.short_term_rent.start_booking.StrStartBookingFragment;
import com.avito.android.short_term_rent.start_booking.StrStartBookingFragment_MembersInjector;
import com.avito.android.short_term_rent.start_booking.StrStartBookingInteractorImpl;
import com.avito.android.short_term_rent.start_booking.StrStartBookingInteractorImpl_Factory;
import com.avito.android.short_term_rent.start_booking.StrStartBookingViewModel;
import com.avito.android.short_term_rent.start_booking.StrStartBookingViewModelFactory;
import com.avito.android.short_term_rent.start_booking.items.disclaimer.DisclaimerItemBlueprint;
import com.avito.android.short_term_rent.start_booking.items.disclaimer.DisclaimerItemPresenter;
import com.avito.android.short_term_rent.start_booking.items.enter_departure.SelectItemBlueprint;
import com.avito.android.short_term_rent.start_booking.items.enter_departure.SelectItemClearListenter;
import com.avito.android.short_term_rent.start_booking.items.enter_departure.SelectItemClickListenter;
import com.avito.android.short_term_rent.start_booking.items.enter_departure.SelectItemPresenter;
import com.avito.android.short_term_rent.start_booking.items.guest_count.GuestsCountBluePrint;
import com.avito.android.short_term_rent.start_booking.items.guest_count.GuestsCountClickListener;
import com.avito.android.short_term_rent.start_booking.items.guest_count.GuestsCountItemPresenter;
import com.avito.android.short_term_rent.start_booking.items.guest_count.GuestsCountsProvider;
import com.avito.android.short_term_rent.start_booking.items.summary.SummaryItemBlueprint;
import com.avito.android.short_term_rent.start_booking.items.summary.SummaryItemPresenter;
import com.avito.android.short_term_rent.start_booking.items.summary.loading.SummaryLoadingItemBlueprint;
import com.avito.android.short_term_rent.start_booking.items.summary.loading.SummaryLoadingItemPresenter;
import com.avito.android.short_term_rent.start_booking.utils.StrStartBookingContentsComparator;
import com.avito.android.short_term_rent.start_booking.utils.StrStartBookingResourceProvider;
import com.avito.android.short_term_rent.start_booking.utils.StrStartBookingResourceProviderImpl;
import com.avito.android.short_term_rent.start_booking.utils.StrStartBookingResourceProviderImpl_Factory;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import java.util.Date;
import javax.inject.Provider;
public final class DaggerStrStartBookingComponent implements StrStartBookingComponent {
    public Provider<GuestsCountClickListener> A;
    public Provider<GuestsCountItemPresenter> B;
    public Provider<GuestsCountsProvider> C;
    public Provider<GuestsCountBluePrint> D;
    public Provider<SummaryItemPresenter> E;
    public Provider<SummaryItemBlueprint> F;
    public Provider<SummaryLoadingItemPresenter> G;
    public Provider<SummaryLoadingItemBlueprint> H;
    public Provider<DisclaimerItemPresenter> I;
    public Provider<DisclaimerItemBlueprint> J;
    public Provider<ItemBinder> K;
    public Provider<AdapterPresenter> L;
    public Provider<SimpleRecyclerAdapter> M;
    public Provider<ListUpdateCallback> N;
    public Provider<StrStartBookingContentsComparator> O;
    public Provider<DiffCalculator> P;
    public Provider<DataAwareAdapterPresenter> Q;
    public final StrStartBookingDependencies a;
    public Provider<Fragment> b;
    public Provider<ShortTermRentApi> c;
    public Provider<SchedulersFactory> d;
    public Provider<TypedErrorThrowableConverter> e;
    public Provider<String> f;
    public Provider<StrStartBookingInteractorImpl> g;
    public Provider<String> h;
    public Provider<String> i;
    public Provider<AccountStateProvider> j;
    public Provider<Analytics> k;
    public Provider<StrAnalyticsTrackerImpl> l;
    public Provider<StrAnalyticsTracker> m;
    public Provider<Resources> n;
    public Provider<StrStartBookingResourceProviderImpl> o;
    public Provider<StrStartBookingResourceProvider> p;
    public Provider<AttributedTextFormatter> q = SingleCheck.provider(AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory.create());
    public Provider<Date> r;
    public Provider<Date> s;
    public Provider<Boolean> t;
    public Provider<StrStartBookingViewModelFactory> u;
    public Provider<StrStartBookingViewModel> v;
    public Provider<SelectItemClickListenter> w;
    public Provider<SelectItemClearListenter> x;
    public Provider<SelectItemPresenter> y;
    public Provider<SelectItemBlueprint> z;

    public static final class b implements StrStartBookingComponent.Builder {
        public Resources a;
        public Fragment b;
        public String c;
        public Date d;
        public Date e;
        public Boolean f;
        public String g;
        public String h;
        public StrStartBookingDependencies i;

        public b(a aVar) {
        }

        @Override // com.avito.android.short_term_rent.di.component.StrStartBookingComponent.Builder
        public StrStartBookingComponent.Builder advertId(String str) {
            this.c = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.short_term_rent.di.component.StrStartBookingComponent.Builder
        public StrStartBookingComponent build() {
            Preconditions.checkBuilderRequirement(this.a, Resources.class);
            Preconditions.checkBuilderRequirement(this.b, Fragment.class);
            Preconditions.checkBuilderRequirement(this.c, String.class);
            Preconditions.checkBuilderRequirement(this.f, Boolean.class);
            Preconditions.checkBuilderRequirement(this.g, String.class);
            Preconditions.checkBuilderRequirement(this.i, StrStartBookingDependencies.class);
            return new DaggerStrStartBookingComponent(this.i, this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, null);
        }

        @Override // com.avito.android.short_term_rent.di.component.StrStartBookingComponent.Builder
        public StrStartBookingComponent.Builder checkInDate(Date date) {
            this.d = date;
            return this;
        }

        @Override // com.avito.android.short_term_rent.di.component.StrStartBookingComponent.Builder
        public StrStartBookingComponent.Builder checkOutDate(Date date) {
            this.e = date;
            return this;
        }

        @Override // com.avito.android.short_term_rent.di.component.StrStartBookingComponent.Builder
        public StrStartBookingComponent.Builder resources(Resources resources) {
            this.a = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.short_term_rent.di.component.StrStartBookingComponent.Builder
        public StrStartBookingComponent.Builder showCalendar(boolean z) {
            this.f = (Boolean) Preconditions.checkNotNull(Boolean.valueOf(z));
            return this;
        }

        @Override // com.avito.android.short_term_rent.di.component.StrStartBookingComponent.Builder
        public StrStartBookingComponent.Builder source(String str) {
            this.g = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.short_term_rent.di.component.StrStartBookingComponent.Builder
        public StrStartBookingComponent.Builder startBookingDependencies(StrStartBookingDependencies strStartBookingDependencies) {
            this.i = (StrStartBookingDependencies) Preconditions.checkNotNull(strStartBookingDependencies);
            return this;
        }

        @Override // com.avito.android.short_term_rent.di.component.StrStartBookingComponent.Builder
        public StrStartBookingComponent.Builder viewModelFragment(Fragment fragment) {
            this.b = (Fragment) Preconditions.checkNotNull(fragment);
            return this;
        }

        @Override // com.avito.android.short_term_rent.di.component.StrStartBookingComponent.Builder
        public StrStartBookingComponent.Builder workflow(String str) {
            this.h = str;
            return this;
        }
    }

    public static class c implements Provider<AccountStateProvider> {
        public final StrStartBookingDependencies a;

        public c(StrStartBookingDependencies strStartBookingDependencies) {
            this.a = strStartBookingDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AccountStateProvider get() {
            return (AccountStateProvider) Preconditions.checkNotNullFromComponent(this.a.accountStateProvider());
        }
    }

    public static class d implements Provider<Analytics> {
        public final StrStartBookingDependencies a;

        public d(StrStartBookingDependencies strStartBookingDependencies) {
            this.a = strStartBookingDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class e implements Provider<SchedulersFactory> {
        public final StrStartBookingDependencies a;

        public e(StrStartBookingDependencies strStartBookingDependencies) {
            this.a = strStartBookingDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class f implements Provider<ShortTermRentApi> {
        public final StrStartBookingDependencies a;

        public f(StrStartBookingDependencies strStartBookingDependencies) {
            this.a = strStartBookingDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ShortTermRentApi get() {
            return (ShortTermRentApi) Preconditions.checkNotNullFromComponent(this.a.shortTermRentApi());
        }
    }

    public static class g implements Provider<TypedErrorThrowableConverter> {
        public final StrStartBookingDependencies a;

        public g(StrStartBookingDependencies strStartBookingDependencies) {
            this.a = strStartBookingDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
        }
    }

    public DaggerStrStartBookingComponent(StrStartBookingDependencies strStartBookingDependencies, Resources resources, Fragment fragment, String str, Date date, Date date2, Boolean bool, String str2, String str3, a aVar) {
        this.a = strStartBookingDependencies;
        this.b = InstanceFactory.create(fragment);
        this.c = new f(strStartBookingDependencies);
        this.d = new e(strStartBookingDependencies);
        this.e = new g(strStartBookingDependencies);
        Factory createNullable = InstanceFactory.createNullable(str3);
        this.f = createNullable;
        this.g = StrStartBookingInteractorImpl_Factory.create(this.c, this.d, this.e, createNullable);
        this.h = InstanceFactory.create(str);
        this.i = InstanceFactory.create(str2);
        this.j = new c(strStartBookingDependencies);
        d dVar = new d(strStartBookingDependencies);
        this.k = dVar;
        StrAnalyticsTrackerImpl_Factory create = StrAnalyticsTrackerImpl_Factory.create(this.h, dVar);
        this.l = create;
        this.m = DoubleCheck.provider(create);
        Factory create2 = InstanceFactory.create(resources);
        this.n = create2;
        StrStartBookingResourceProviderImpl_Factory create3 = StrStartBookingResourceProviderImpl_Factory.create(create2);
        this.o = create3;
        this.p = DoubleCheck.provider(create3);
        this.r = InstanceFactory.createNullable(date);
        this.s = InstanceFactory.createNullable(date2);
        Factory create4 = InstanceFactory.create(bool);
        this.t = create4;
        Provider<StrStartBookingViewModelFactory> provider = DoubleCheck.provider(StrStartBookingModule_ProvideStrStartBookingViewModelFactory$short_term_rent_releaseFactory.create(this.g, this.d, this.h, this.i, this.j, this.m, this.p, this.q, this.r, this.s, create4));
        this.u = provider;
        Provider<StrStartBookingViewModel> provider2 = DoubleCheck.provider(StrStartBookingModule_ProvideStrStartBookingViewModel$short_term_rent_releaseFactory.create(this.b, provider));
        this.v = provider2;
        this.w = DoubleCheck.provider(StrStartBookingModule_ProvideSelectItemClickConsumer$short_term_rent_releaseFactory.create(provider2));
        Provider<SelectItemClearListenter> provider3 = DoubleCheck.provider(StrStartBookingModule_ProvideSelectItemClearConsumer$short_term_rent_releaseFactory.create(this.v));
        this.x = provider3;
        Provider<SelectItemPresenter> provider4 = DoubleCheck.provider(StrStartBookingModule_ProvideSelectItemPresenter$short_term_rent_releaseFactory.create(this.w, provider3));
        this.y = provider4;
        this.z = DoubleCheck.provider(StrStartBookingModule_ProvideSelectItemBlueprint$short_term_rent_releaseFactory.create(provider4));
        Provider<GuestsCountClickListener> provider5 = DoubleCheck.provider(StrStartBookingModule_ProvideGuestCountClickListener$short_term_rent_releaseFactory.create(this.v));
        this.A = provider5;
        this.B = DoubleCheck.provider(StrStartBookingModule_ProvideGuestCountItemPresenterFactory.create(provider5));
        Provider<GuestsCountsProvider> provider6 = DoubleCheck.provider(StrStartBookingModule_ProvideGuestsCountsProvider$short_term_rent_releaseFactory.create(this.v));
        this.C = provider6;
        this.D = DoubleCheck.provider(StrStartBookingModule_ProvideGuestsCountBluePrint$short_term_rent_releaseFactory.create(this.B, provider6));
        Provider<SummaryItemPresenter> provider7 = DoubleCheck.provider(StrStartBookingModule_ProvideSummaryItemPresenter$short_term_rent_releaseFactory.create());
        this.E = provider7;
        this.F = DoubleCheck.provider(StrStartBookingModule_ProvideSummaryItemBlueprint$short_term_rent_releaseFactory.create(provider7));
        Provider<SummaryLoadingItemPresenter> provider8 = DoubleCheck.provider(StrStartBookingModule_ProvideSummaryLoadingItemPresenter$short_term_rent_releaseFactory.create());
        this.G = provider8;
        this.H = DoubleCheck.provider(StrStartBookingModule_ProvideSummaryLoadingItemBlueprint$short_term_rent_releaseFactory.create(provider8));
        Provider<DisclaimerItemPresenter> provider9 = DoubleCheck.provider(StrStartBookingModule_ProvideDisclaimerItemPresenter$short_term_rent_releaseFactory.create());
        this.I = provider9;
        Provider<DisclaimerItemBlueprint> provider10 = DoubleCheck.provider(StrStartBookingModule_ProvideDisclaimerItemBlueprint$short_term_rent_releaseFactory.create(provider9));
        this.J = provider10;
        Provider<ItemBinder> provider11 = DoubleCheck.provider(StrStartBookingModule_ProvideItemBinder$short_term_rent_releaseFactory.create(this.z, this.D, this.F, this.H, provider10));
        this.K = provider11;
        Provider<AdapterPresenter> provider12 = DoubleCheck.provider(StrStartBookingModule_ProvideAdapterPresenter$short_term_rent_releaseFactory.create(provider11));
        this.L = provider12;
        Provider<SimpleRecyclerAdapter> provider13 = DoubleCheck.provider(StrStartBookingModule_ProvideRecyclerAdapterFactory.create(provider12, this.K));
        this.M = provider13;
        this.N = DoubleCheck.provider(StrStartBookingModule_ProvideListUpdateCallback$short_term_rent_releaseFactory.create(provider13));
        Provider<StrStartBookingContentsComparator> provider14 = DoubleCheck.provider(StrStartBookingModule_ProvideContentsComparator$short_term_rent_releaseFactory.create());
        this.O = provider14;
        Provider<DiffCalculator> provider15 = DoubleCheck.provider(StrStartBookingModule_ProvideDiffCalculator$short_term_rent_releaseFactory.create(provider14));
        this.P = provider15;
        this.Q = DoubleCheck.provider(StrStartBookingModule_ProvideDataAwareAdapterPresenter$short_term_rent_releaseFactory.create(this.N, this.L, provider15));
    }

    public static StrStartBookingComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.short_term_rent.di.component.StrStartBookingComponent
    public void inject(StrStartBookingFragment strStartBookingFragment) {
        StrStartBookingFragment_MembersInjector.injectViewModel(strStartBookingFragment, this.v.get());
        StrStartBookingFragment_MembersInjector.injectRecyclerAdapter(strStartBookingFragment, this.M.get());
        StrStartBookingFragment_MembersInjector.injectAdapterPresenter(strStartBookingFragment, this.Q.get());
        StrStartBookingFragment_MembersInjector.injectItemBinder(strStartBookingFragment, this.K.get());
        StrStartBookingFragment_MembersInjector.injectIntentFactory(strStartBookingFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
    }
}

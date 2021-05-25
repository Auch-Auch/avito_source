package com.avito.android.str_calendar.di.component;

import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.category_parameters.CategoryParametersElementConverter;
import com.avito.android.di.module.InputItemFormatterProviderModule_ProvideInputItemFormatter$formatters_provider_releaseFactory;
import com.avito.android.html_formatter.HtmlCleaner;
import com.avito.android.html_formatter.HtmlNodeFactory;
import com.avito.android.html_formatter.HtmlRenderer;
import com.avito.android.provider.InputItemFormatterProvider;
import com.avito.android.remote.ShortTermRentApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.server_time.TimeSource;
import com.avito.android.str_calendar.di.component.StrSellerCalendarParametersComponent;
import com.avito.android.str_calendar.di.module.StrSellerCalendarParametersModule_ProvideAdapterPresenterFactory;
import com.avito.android.str_calendar.di.module.StrSellerCalendarParametersModule_ProvideCategoryParametersElementConverterFactory;
import com.avito.android.str_calendar.di.module.StrSellerCalendarParametersModule_ProvideChipsSelectItemBlueprint$str_calendar_releaseFactory;
import com.avito.android.str_calendar.di.module.StrSellerCalendarParametersModule_ProvideChipsSelectItemPresenter$str_calendar_releaseFactory;
import com.avito.android.str_calendar.di.module.StrSellerCalendarParametersModule_ProvideHeaderItemBlueprint$str_calendar_releaseFactory;
import com.avito.android.str_calendar.di.module.StrSellerCalendarParametersModule_ProvideHeaderItemPresenter$str_calendar_releaseFactory;
import com.avito.android.str_calendar.di.module.StrSellerCalendarParametersModule_ProvideItemBinder$str_calendar_releaseFactory;
import com.avito.android.str_calendar.di.module.StrSellerCalendarParametersModule_ProvideLocalPretendInteractorFactory;
import com.avito.android.str_calendar.di.module.StrSellerCalendarParametersModule_ProvideLocalPretendInteractorResourceProviderFactory;
import com.avito.android.str_calendar.di.module.StrSellerCalendarParametersModule_ProvideParametersValidatorFactory;
import com.avito.android.str_calendar.di.module.StrSellerCalendarParametersModule_ProvideRadioGroupSelectItemBlueprint$str_calendar_releaseFactory;
import com.avito.android.str_calendar.di.module.StrSellerCalendarParametersModule_ProvideRadioGroupSelectItemPresenter$str_calendar_releaseFactory;
import com.avito.android.str_calendar.di.module.StrSellerCalendarParametersModule_ProvideRdsInputItemBlueprint$str_calendar_releaseFactory;
import com.avito.android.str_calendar.di.module.StrSellerCalendarParametersModule_ProvideRdsInputItemPresenter$str_calendar_releaseFactory;
import com.avito.android.str_calendar.di.module.StrSellerCalendarParametersModule_ProvideSellerBaseCalendarParametersViewModel$str_calendar_releaseFactory;
import com.avito.android.str_calendar.di.module.StrSellerCalendarParametersModule_ProvideSellerBaseCalendarParametersViewModelFactory$str_calendar_releaseFactory;
import com.avito.android.str_calendar.seller.SellerCalendarRouter;
import com.avito.android.str_calendar.seller.edit.SellerBaseCalendarParametersViewModelFactory;
import com.avito.android.str_calendar.seller.edit.SellerCalendarParametersConverter;
import com.avito.android.str_calendar.seller.edit.SellerCalendarParametersConverterImpl;
import com.avito.android.str_calendar.seller.edit.SellerCalendarParametersConverterImpl_Factory;
import com.avito.android.str_calendar.seller.edit.SellerCalendarParametersFragment;
import com.avito.android.str_calendar.seller.edit.SellerCalendarParametersFragment_MembersInjector;
import com.avito.android.str_calendar.seller.edit.SellerCalendarParametersInteractor;
import com.avito.android.str_calendar.seller.edit.SellerCalendarParametersInteractorImpl;
import com.avito.android.str_calendar.seller.edit.SellerCalendarParametersInteractorImpl_Factory;
import com.avito.android.str_calendar.seller.edit.SellerCalendarParametersViewModel;
import com.avito.android.str_calendar.seller.edit.SellerCalendarParamsResourceProvider;
import com.avito.android.str_calendar.seller.edit.SellerCalendarParamsResourceProviderImpl;
import com.avito.android.str_calendar.seller.edit.SellerCalendarParamsResourceProviderImpl_Factory;
import com.avito.android.str_calendar.seller.edit.konveyor.chips.ChipsSelectItemBlueprint;
import com.avito.android.str_calendar.seller.edit.konveyor.chips.ChipsSelectItemPresenter;
import com.avito.android.str_calendar.seller.edit.konveyor.header.HeaderItemBlueprint;
import com.avito.android.str_calendar.seller.edit.konveyor.header.HeaderItemPresenter;
import com.avito.android.str_calendar.seller.edit.konveyor.input.RdsInputItemBlueprint;
import com.avito.android.str_calendar.seller.edit.konveyor.input.RdsInputItemPresenter;
import com.avito.android.str_calendar.seller.edit.konveyor.radiogroup.RadioGroupSelectItemBlueprint;
import com.avito.android.str_calendar.seller.edit.konveyor.radiogroup.RadioGroupSelectItemPresenter;
import com.avito.android.util.PhoneNumberFormatterModule_ProvidePhoneNumberFormatterFactory;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.validation.LocalPretendInteractor;
import com.avito.android.validation.ParametersValidator;
import com.avito.android.validation.ParametersValidatorResourceProvider;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import java.util.Date;
import java.util.Locale;
import javax.inject.Provider;
public final class DaggerStrSellerCalendarParametersComponent implements StrSellerCalendarParametersComponent {
    public Provider<SellerBaseCalendarParametersViewModelFactory> A;
    public Provider<SellerCalendarParametersViewModel> B;
    public Provider<ChipsSelectItemPresenter> C;
    public Provider<ChipsSelectItemBlueprint> D;
    public Provider<RadioGroupSelectItemPresenter> E;
    public Provider<RadioGroupSelectItemBlueprint> F;
    public Provider<InputItemFormatterProvider> G;
    public Provider<RdsInputItemPresenter> H;
    public Provider<RdsInputItemBlueprint> I;
    public Provider<HeaderItemPresenter> J;
    public Provider<HeaderItemBlueprint> K;
    public Provider<ItemBinder> L;
    public Provider<AdapterPresenter> M;
    public final StrSellerCalendarParametersDependencies a;
    public final SellerCalendarRouter b;
    public Provider<Fragment> c;
    public Provider<ShortTermRentApi> d;
    public Provider<SchedulersFactory> e;
    public Provider<TypedErrorThrowableConverter> f;
    public Provider<Resources> g;
    public Provider<ParametersValidatorResourceProvider> h;
    public Provider<Features> i;
    public Provider<HtmlRenderer> j;
    public Provider<HtmlCleaner> k;
    public Provider<ParametersValidator> l;
    public Provider<LocalPretendInteractor> m;
    public Provider<SellerCalendarParametersInteractorImpl> n;
    public Provider<SellerCalendarParametersInteractor> o;
    public Provider<String> p;
    public Provider<TimeSource> q;
    public Provider<Locale> r;
    public Provider<HtmlNodeFactory> s;
    public Provider<CategoryParametersElementConverter> t;
    public Provider<SellerCalendarParametersConverterImpl> u;
    public Provider<SellerCalendarParametersConverter> v;
    public Provider<Date> w;
    public Provider<Date> x;
    public Provider<SellerCalendarParamsResourceProviderImpl> y;
    public Provider<SellerCalendarParamsResourceProvider> z;

    public static final class b implements StrSellerCalendarParametersComponent.Builder {
        public SellerCalendarRouter a;
        public Resources b;
        public String c;
        public Date d;
        public Date e;
        public Fragment f;
        public StrSellerCalendarParametersDependencies g;

        public b(a aVar) {
        }

        @Override // com.avito.android.str_calendar.di.component.StrSellerCalendarParametersComponent.Builder
        public StrSellerCalendarParametersComponent.Builder advertId(String str) {
            this.c = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.str_calendar.di.component.StrSellerCalendarParametersComponent.Builder
        public StrSellerCalendarParametersComponent build() {
            Preconditions.checkBuilderRequirement(this.a, SellerCalendarRouter.class);
            Preconditions.checkBuilderRequirement(this.b, Resources.class);
            Preconditions.checkBuilderRequirement(this.c, String.class);
            Preconditions.checkBuilderRequirement(this.f, Fragment.class);
            Preconditions.checkBuilderRequirement(this.g, StrSellerCalendarParametersDependencies.class);
            return new DaggerStrSellerCalendarParametersComponent(this.g, this.a, this.b, this.c, this.d, this.e, this.f, null);
        }

        @Override // com.avito.android.str_calendar.di.component.StrSellerCalendarParametersComponent.Builder
        public StrSellerCalendarParametersComponent.Builder endDate(Date date) {
            this.e = date;
            return this;
        }

        @Override // com.avito.android.str_calendar.di.component.StrSellerCalendarParametersComponent.Builder
        public StrSellerCalendarParametersComponent.Builder resources(Resources resources) {
            this.b = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.str_calendar.di.component.StrSellerCalendarParametersComponent.Builder
        public StrSellerCalendarParametersComponent.Builder router(SellerCalendarRouter sellerCalendarRouter) {
            this.a = (SellerCalendarRouter) Preconditions.checkNotNull(sellerCalendarRouter);
            return this;
        }

        @Override // com.avito.android.str_calendar.di.component.StrSellerCalendarParametersComponent.Builder
        public StrSellerCalendarParametersComponent.Builder sellerBaseCalendarParametersDependencies(StrSellerCalendarParametersDependencies strSellerCalendarParametersDependencies) {
            this.g = (StrSellerCalendarParametersDependencies) Preconditions.checkNotNull(strSellerCalendarParametersDependencies);
            return this;
        }

        @Override // com.avito.android.str_calendar.di.component.StrSellerCalendarParametersComponent.Builder
        public StrSellerCalendarParametersComponent.Builder startDate(Date date) {
            this.d = date;
            return this;
        }

        @Override // com.avito.android.str_calendar.di.component.StrSellerCalendarParametersComponent.Builder
        public StrSellerCalendarParametersComponent.Builder viewModelFragment(Fragment fragment) {
            this.f = (Fragment) Preconditions.checkNotNull(fragment);
            return this;
        }
    }

    public static class c implements Provider<Features> {
        public final StrSellerCalendarParametersDependencies a;

        public c(StrSellerCalendarParametersDependencies strSellerCalendarParametersDependencies) {
            this.a = strSellerCalendarParametersDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class d implements Provider<HtmlCleaner> {
        public final StrSellerCalendarParametersDependencies a;

        public d(StrSellerCalendarParametersDependencies strSellerCalendarParametersDependencies) {
            this.a = strSellerCalendarParametersDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public HtmlCleaner get() {
            return (HtmlCleaner) Preconditions.checkNotNullFromComponent(this.a.htmlCleaner());
        }
    }

    public static class e implements Provider<HtmlNodeFactory> {
        public final StrSellerCalendarParametersDependencies a;

        public e(StrSellerCalendarParametersDependencies strSellerCalendarParametersDependencies) {
            this.a = strSellerCalendarParametersDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public HtmlNodeFactory get() {
            return (HtmlNodeFactory) Preconditions.checkNotNullFromComponent(this.a.htmlNodeFactory());
        }
    }

    public static class f implements Provider<HtmlRenderer> {
        public final StrSellerCalendarParametersDependencies a;

        public f(StrSellerCalendarParametersDependencies strSellerCalendarParametersDependencies) {
            this.a = strSellerCalendarParametersDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public HtmlRenderer get() {
            return (HtmlRenderer) Preconditions.checkNotNullFromComponent(this.a.htmlRenderer());
        }
    }

    public static class g implements Provider<Locale> {
        public final StrSellerCalendarParametersDependencies a;

        public g(StrSellerCalendarParametersDependencies strSellerCalendarParametersDependencies) {
            this.a = strSellerCalendarParametersDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Locale get() {
            return (Locale) Preconditions.checkNotNullFromComponent(this.a.locale());
        }
    }

    public static class h implements Provider<SchedulersFactory> {
        public final StrSellerCalendarParametersDependencies a;

        public h(StrSellerCalendarParametersDependencies strSellerCalendarParametersDependencies) {
            this.a = strSellerCalendarParametersDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class i implements Provider<ShortTermRentApi> {
        public final StrSellerCalendarParametersDependencies a;

        public i(StrSellerCalendarParametersDependencies strSellerCalendarParametersDependencies) {
            this.a = strSellerCalendarParametersDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ShortTermRentApi get() {
            return (ShortTermRentApi) Preconditions.checkNotNullFromComponent(this.a.shortTermRentApi());
        }
    }

    public static class j implements Provider<TimeSource> {
        public final StrSellerCalendarParametersDependencies a;

        public j(StrSellerCalendarParametersDependencies strSellerCalendarParametersDependencies) {
            this.a = strSellerCalendarParametersDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimeSource get() {
            return (TimeSource) Preconditions.checkNotNullFromComponent(this.a.timeSource());
        }
    }

    public static class k implements Provider<TypedErrorThrowableConverter> {
        public final StrSellerCalendarParametersDependencies a;

        public k(StrSellerCalendarParametersDependencies strSellerCalendarParametersDependencies) {
            this.a = strSellerCalendarParametersDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
        }
    }

    public DaggerStrSellerCalendarParametersComponent(StrSellerCalendarParametersDependencies strSellerCalendarParametersDependencies, SellerCalendarRouter sellerCalendarRouter, Resources resources, String str, Date date, Date date2, Fragment fragment, a aVar) {
        this.a = strSellerCalendarParametersDependencies;
        this.b = sellerCalendarRouter;
        this.c = InstanceFactory.create(fragment);
        this.d = new i(strSellerCalendarParametersDependencies);
        this.e = new h(strSellerCalendarParametersDependencies);
        this.f = new k(strSellerCalendarParametersDependencies);
        Factory create = InstanceFactory.create(resources);
        this.g = create;
        Provider<ParametersValidatorResourceProvider> provider = DoubleCheck.provider(StrSellerCalendarParametersModule_ProvideLocalPretendInteractorResourceProviderFactory.create(create));
        this.h = provider;
        c cVar = new c(strSellerCalendarParametersDependencies);
        this.i = cVar;
        f fVar = new f(strSellerCalendarParametersDependencies);
        this.j = fVar;
        d dVar = new d(strSellerCalendarParametersDependencies);
        this.k = dVar;
        Provider<ParametersValidator> provider2 = DoubleCheck.provider(StrSellerCalendarParametersModule_ProvideParametersValidatorFactory.create(provider, cVar, fVar, dVar));
        this.l = provider2;
        Provider<LocalPretendInteractor> provider3 = DoubleCheck.provider(StrSellerCalendarParametersModule_ProvideLocalPretendInteractorFactory.create(provider2));
        this.m = provider3;
        SellerCalendarParametersInteractorImpl_Factory create2 = SellerCalendarParametersInteractorImpl_Factory.create(this.d, this.e, this.f, provider3);
        this.n = create2;
        this.o = DoubleCheck.provider(create2);
        this.p = InstanceFactory.create(str);
        this.q = new j(strSellerCalendarParametersDependencies);
        this.r = new g(strSellerCalendarParametersDependencies);
        this.s = new e(strSellerCalendarParametersDependencies);
        Provider<CategoryParametersElementConverter> provider4 = DoubleCheck.provider(StrSellerCalendarParametersModule_ProvideCategoryParametersElementConverterFactory.create(PhoneNumberFormatterModule_ProvidePhoneNumberFormatterFactory.create(), this.q, this.r, this.g, this.i, this.k, this.s));
        this.t = provider4;
        SellerCalendarParametersConverterImpl_Factory create3 = SellerCalendarParametersConverterImpl_Factory.create(provider4);
        this.u = create3;
        this.v = DoubleCheck.provider(create3);
        this.w = InstanceFactory.createNullable(date);
        Factory createNullable = InstanceFactory.createNullable(date2);
        this.x = createNullable;
        SellerCalendarParamsResourceProviderImpl_Factory create4 = SellerCalendarParamsResourceProviderImpl_Factory.create(this.w, createNullable, this.g);
        this.y = create4;
        Provider<SellerCalendarParamsResourceProvider> provider5 = DoubleCheck.provider(create4);
        this.z = provider5;
        Provider<SellerBaseCalendarParametersViewModelFactory> provider6 = DoubleCheck.provider(StrSellerCalendarParametersModule_ProvideSellerBaseCalendarParametersViewModelFactory$str_calendar_releaseFactory.create(this.o, this.e, this.p, this.v, this.w, this.x, provider5));
        this.A = provider6;
        Provider<SellerCalendarParametersViewModel> provider7 = DoubleCheck.provider(StrSellerCalendarParametersModule_ProvideSellerBaseCalendarParametersViewModel$str_calendar_releaseFactory.create(this.c, provider6));
        this.B = provider7;
        Provider<ChipsSelectItemPresenter> provider8 = DoubleCheck.provider(StrSellerCalendarParametersModule_ProvideChipsSelectItemPresenter$str_calendar_releaseFactory.create(provider7));
        this.C = provider8;
        this.D = DoubleCheck.provider(StrSellerCalendarParametersModule_ProvideChipsSelectItemBlueprint$str_calendar_releaseFactory.create(provider8));
        Provider<RadioGroupSelectItemPresenter> provider9 = DoubleCheck.provider(StrSellerCalendarParametersModule_ProvideRadioGroupSelectItemPresenter$str_calendar_releaseFactory.create(this.B));
        this.E = provider9;
        this.F = DoubleCheck.provider(StrSellerCalendarParametersModule_ProvideRadioGroupSelectItemBlueprint$str_calendar_releaseFactory.create(provider9));
        Provider<InputItemFormatterProvider> provider10 = SingleCheck.provider(InputItemFormatterProviderModule_ProvideInputItemFormatter$formatters_provider_releaseFactory.create());
        this.G = provider10;
        Provider<RdsInputItemPresenter> provider11 = DoubleCheck.provider(StrSellerCalendarParametersModule_ProvideRdsInputItemPresenter$str_calendar_releaseFactory.create(this.B, provider10));
        this.H = provider11;
        this.I = DoubleCheck.provider(StrSellerCalendarParametersModule_ProvideRdsInputItemBlueprint$str_calendar_releaseFactory.create(provider11));
        Provider<HeaderItemPresenter> provider12 = DoubleCheck.provider(StrSellerCalendarParametersModule_ProvideHeaderItemPresenter$str_calendar_releaseFactory.create());
        this.J = provider12;
        Provider<HeaderItemBlueprint> provider13 = DoubleCheck.provider(StrSellerCalendarParametersModule_ProvideHeaderItemBlueprint$str_calendar_releaseFactory.create(provider12));
        this.K = provider13;
        Provider<ItemBinder> provider14 = DoubleCheck.provider(StrSellerCalendarParametersModule_ProvideItemBinder$str_calendar_releaseFactory.create(this.D, this.F, this.I, provider13));
        this.L = provider14;
        this.M = DoubleCheck.provider(StrSellerCalendarParametersModule_ProvideAdapterPresenterFactory.create(provider14));
    }

    public static StrSellerCalendarParametersComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.str_calendar.di.component.StrSellerCalendarParametersComponent
    public void inject(SellerCalendarParametersFragment sellerCalendarParametersFragment) {
        SellerCalendarParametersFragment_MembersInjector.injectAdapterPresenter(sellerCalendarParametersFragment, this.M.get());
        SellerCalendarParametersFragment_MembersInjector.injectItemBinder(sellerCalendarParametersFragment, this.L.get());
        SellerCalendarParametersFragment_MembersInjector.injectViewModel(sellerCalendarParametersFragment, this.B.get());
        SellerCalendarParametersFragment_MembersInjector.injectAnalytics(sellerCalendarParametersFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        SellerCalendarParametersFragment_MembersInjector.injectResourceProvider(sellerCalendarParametersFragment, this.z.get());
        SellerCalendarParametersFragment_MembersInjector.injectRouter(sellerCalendarParametersFragment, this.b);
    }
}

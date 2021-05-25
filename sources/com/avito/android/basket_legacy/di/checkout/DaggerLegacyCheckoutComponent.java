package com.avito.android.basket_legacy.di.checkout;

import android.content.res.Resources;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.basket_legacy.di.checkout.LegacyCheckoutComponent;
import com.avito.android.basket_legacy.item.BasketItemBlueprint;
import com.avito.android.basket_legacy.item.BasketItemBlueprint_Factory;
import com.avito.android.basket_legacy.item.BasketItemPresenter;
import com.avito.android.basket_legacy.item.BasketItemPresenter_Factory;
import com.avito.android.basket_legacy.item.disclaimer.DisclaimerItemBlueprint;
import com.avito.android.basket_legacy.item.disclaimer.DisclaimerItemBlueprint_Factory;
import com.avito.android.basket_legacy.item.header.HeaderItemBlueprint;
import com.avito.android.basket_legacy.item.header.HeaderItemBlueprint_Factory;
import com.avito.android.basket_legacy.item.header.HeaderItemPresenter_Factory;
import com.avito.android.basket_legacy.item.total.TotalItemBlueprint;
import com.avito.android.basket_legacy.item.total.TotalItemBlueprint_Factory;
import com.avito.android.basket_legacy.item.total.TotalItemPresenter_Factory;
import com.avito.android.basket_legacy.repositories.BasketRepository;
import com.avito.android.basket_legacy.ui.LegacyCheckoutFragment;
import com.avito.android.basket_legacy.ui.LegacyCheckoutFragment_MembersInjector;
import com.avito.android.basket_legacy.utils.CrossClickListener;
import com.avito.android.basket_legacy.utils.DisclaimerProvider;
import com.avito.android.basket_legacy.utils.DisclaimerProviderImpl;
import com.avito.android.basket_legacy.utils.DisclaimerProviderImpl_Factory;
import com.avito.android.basket_legacy.utils.FeesToBasketItemConverter;
import com.avito.android.basket_legacy.utils.FeesToBasketItemConverterImpl;
import com.avito.android.basket_legacy.utils.FeesToBasketItemConverterImpl_Factory;
import com.avito.android.basket_legacy.utils.PriceCalculator;
import com.avito.android.basket_legacy.utils.PriceCalculatorImpl;
import com.avito.android.basket_legacy.utils.PriceCalculatorImpl_Factory;
import com.avito.android.basket_legacy.utils.PriceFormatter;
import com.avito.android.basket_legacy.utils.PriceFormatterImpl;
import com.avito.android.basket_legacy.utils.PriceFormatterImpl_Factory;
import com.avito.android.basket_legacy.utils.StringProvider;
import com.avito.android.basket_legacy.utils.StringProviderImpl;
import com.avito.android.basket_legacy.utils.StringProviderImpl_Factory;
import com.avito.android.basket_legacy.utils.VasToBasketItemConverter;
import com.avito.android.basket_legacy.utils.VasToBasketItemConverterImpl;
import com.avito.android.basket_legacy.utils.VasToBasketItemConverterImpl_Factory;
import com.avito.android.basket_legacy.viewmodels.checkout.LegacyCheckoutViewModel;
import com.avito.android.basket_legacy.viewmodels.checkout.LegacyCheckoutViewModelFactory;
import com.avito.android.component.disclaimer.DisclaimerItemPresenter;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.OnDeepLinkClickListener;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBinder$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import dagger.internal.SetFactory;
import dagger.internal.SingleCheck;
import java.util.Locale;
import java.util.Set;
import javax.inject.Provider;
public final class DaggerLegacyCheckoutComponent implements LegacyCheckoutComponent {
    public Provider<BasketItemPresenter> A;
    public Provider<BasketItemBlueprint> B;
    public Provider<ItemBlueprint<?, ?>> C;
    public Provider<HeaderItemBlueprint> D;
    public Provider<ItemBlueprint<?, ?>> E;
    public Provider<TotalItemBlueprint> F;
    public Provider<ItemBlueprint<?, ?>> G;
    public Provider<OnDeepLinkClickListener> H;
    public Provider<DisclaimerItemPresenter> I;
    public Provider<AttributedTextFormatter> J;
    public Provider<DisclaimerItemBlueprint> K;
    public Provider<ItemBlueprint<?, ?>> L;
    public Provider<Set<ItemBlueprint<?, ?>>> M;
    public Provider<ItemBinder> N;
    public Provider<AdapterPresenter> O;
    public Provider<String> a;
    public Provider<String> b;
    public Provider<Boolean> c;
    public Provider<BasketRepository> d;
    public Provider<Resources> e;
    public Provider<StringProviderImpl> f;
    public Provider<StringProvider> g;
    public Provider<VasToBasketItemConverterImpl> h;
    public Provider<VasToBasketItemConverter> i;
    public Provider<FeesToBasketItemConverterImpl> j;
    public Provider<FeesToBasketItemConverter> k;
    public Provider<DeepLinkIntentFactory> l;
    public Provider<ActivityIntentFactory> m;
    public Provider<Locale> n;
    public Provider<PriceFormatterImpl> o;
    public Provider<PriceFormatter> p;
    public Provider<PriceCalculatorImpl> q;
    public Provider<PriceCalculator> r;
    public Provider<DisclaimerProviderImpl> s;
    public Provider<DisclaimerProvider> t;
    public Provider<Features> u;
    public Provider<SchedulersFactory> v;
    public Provider<LegacyCheckoutViewModelFactory> w;
    public Provider<LegacyCheckoutViewModel> x;
    public Provider<Set<ItemBlueprint<?, ?>>> y = SingleCheck.provider(AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory.create());
    public Provider<CrossClickListener> z;

    public static final class b implements LegacyCheckoutComponent.Builder {
        public LegacyCheckoutDependencies a;
        public LegacyCheckoutViewModelModule b;
        public LegacyCheckoutUiModule c;

        public b(a aVar) {
        }

        @Override // com.avito.android.basket_legacy.di.checkout.LegacyCheckoutComponent.Builder
        public LegacyCheckoutComponent.Builder basketViewModelModule(LegacyCheckoutViewModelModule legacyCheckoutViewModelModule) {
            this.b = (LegacyCheckoutViewModelModule) Preconditions.checkNotNull(legacyCheckoutViewModelModule);
            return this;
        }

        @Override // com.avito.android.basket_legacy.di.checkout.LegacyCheckoutComponent.Builder
        public LegacyCheckoutComponent build() {
            Preconditions.checkBuilderRequirement(this.a, LegacyCheckoutDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, LegacyCheckoutViewModelModule.class);
            if (this.c == null) {
                this.c = new LegacyCheckoutUiModule();
            }
            return new DaggerLegacyCheckoutComponent(this.c, this.b, this.a, null);
        }

        @Override // com.avito.android.basket_legacy.di.checkout.LegacyCheckoutComponent.Builder
        public LegacyCheckoutComponent.Builder checkoutModule(LegacyCheckoutUiModule legacyCheckoutUiModule) {
            this.c = (LegacyCheckoutUiModule) Preconditions.checkNotNull(legacyCheckoutUiModule);
            return this;
        }

        @Override // com.avito.android.basket_legacy.di.checkout.LegacyCheckoutComponent.Builder
        public LegacyCheckoutComponent.Builder dependencies(LegacyCheckoutDependencies legacyCheckoutDependencies) {
            this.a = (LegacyCheckoutDependencies) Preconditions.checkNotNull(legacyCheckoutDependencies);
            return this;
        }
    }

    public static class c implements Provider<ActivityIntentFactory> {
        public final LegacyCheckoutDependencies a;

        public c(LegacyCheckoutDependencies legacyCheckoutDependencies) {
            this.a = legacyCheckoutDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ActivityIntentFactory get() {
            return (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory());
        }
    }

    public static class d implements Provider<String> {
        public final LegacyCheckoutDependencies a;

        public d(LegacyCheckoutDependencies legacyCheckoutDependencies) {
            this.a = legacyCheckoutDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public String get() {
            return (String) Preconditions.checkNotNullFromComponent(this.a.advertId());
        }
    }

    public static class e implements Provider<BasketRepository> {
        public final LegacyCheckoutDependencies a;

        public e(LegacyCheckoutDependencies legacyCheckoutDependencies) {
            this.a = legacyCheckoutDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public BasketRepository get() {
            return (BasketRepository) Preconditions.checkNotNullFromComponent(this.a.basketRepository());
        }
    }

    public static class f implements Provider<DeepLinkIntentFactory> {
        public final LegacyCheckoutDependencies a;

        public f(LegacyCheckoutDependencies legacyCheckoutDependencies) {
            this.a = legacyCheckoutDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeepLinkIntentFactory get() {
            return (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deeplinkIntentFactory());
        }
    }

    public static class g implements Provider<Features> {
        public final LegacyCheckoutDependencies a;

        public g(LegacyCheckoutDependencies legacyCheckoutDependencies) {
            this.a = legacyCheckoutDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class h implements Provider<Boolean> {
        public final LegacyCheckoutDependencies a;

        public h(LegacyCheckoutDependencies legacyCheckoutDependencies) {
            this.a = legacyCheckoutDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Boolean get() {
            return Boolean.valueOf(this.a.lfRequired());
        }
    }

    public static class i implements Provider<Locale> {
        public final LegacyCheckoutDependencies a;

        public i(LegacyCheckoutDependencies legacyCheckoutDependencies) {
            this.a = legacyCheckoutDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Locale get() {
            return (Locale) Preconditions.checkNotNullFromComponent(this.a.locale());
        }
    }

    public static class j implements Provider<Resources> {
        public final LegacyCheckoutDependencies a;

        public j(LegacyCheckoutDependencies legacyCheckoutDependencies) {
            this.a = legacyCheckoutDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Resources get() {
            return (Resources) Preconditions.checkNotNullFromComponent(this.a.resources());
        }
    }

    public static class k implements Provider<SchedulersFactory> {
        public final LegacyCheckoutDependencies a;

        public k(LegacyCheckoutDependencies legacyCheckoutDependencies) {
            this.a = legacyCheckoutDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class l implements Provider<String> {
        public final LegacyCheckoutDependencies a;

        public l(LegacyCheckoutDependencies legacyCheckoutDependencies) {
            this.a = legacyCheckoutDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public String get() {
            return (String) Preconditions.checkNotNullFromComponent(this.a.vasContext());
        }
    }

    public DaggerLegacyCheckoutComponent(LegacyCheckoutUiModule legacyCheckoutUiModule, LegacyCheckoutViewModelModule legacyCheckoutViewModelModule, LegacyCheckoutDependencies legacyCheckoutDependencies, a aVar) {
        this.a = new d(legacyCheckoutDependencies);
        this.b = new l(legacyCheckoutDependencies);
        this.c = new h(legacyCheckoutDependencies);
        this.d = new e(legacyCheckoutDependencies);
        j jVar = new j(legacyCheckoutDependencies);
        this.e = jVar;
        StringProviderImpl_Factory create = StringProviderImpl_Factory.create(jVar);
        this.f = create;
        Provider<StringProvider> provider = DoubleCheck.provider(create);
        this.g = provider;
        VasToBasketItemConverterImpl_Factory create2 = VasToBasketItemConverterImpl_Factory.create(provider);
        this.h = create2;
        this.i = DoubleCheck.provider(create2);
        FeesToBasketItemConverterImpl_Factory create3 = FeesToBasketItemConverterImpl_Factory.create(this.g);
        this.j = create3;
        this.k = DoubleCheck.provider(create3);
        this.l = new f(legacyCheckoutDependencies);
        this.m = new c(legacyCheckoutDependencies);
        i iVar = new i(legacyCheckoutDependencies);
        this.n = iVar;
        PriceFormatterImpl_Factory create4 = PriceFormatterImpl_Factory.create(iVar);
        this.o = create4;
        Provider<PriceFormatter> provider2 = DoubleCheck.provider(create4);
        this.p = provider2;
        PriceCalculatorImpl_Factory create5 = PriceCalculatorImpl_Factory.create(this.g, provider2);
        this.q = create5;
        this.r = DoubleCheck.provider(create5);
        DisclaimerProviderImpl_Factory create6 = DisclaimerProviderImpl_Factory.create(this.g);
        this.s = create6;
        Provider<DisclaimerProvider> provider3 = DoubleCheck.provider(create6);
        this.t = provider3;
        g gVar = new g(legacyCheckoutDependencies);
        this.u = gVar;
        k kVar = new k(legacyCheckoutDependencies);
        this.v = kVar;
        Provider<LegacyCheckoutViewModelFactory> provider4 = DoubleCheck.provider(LegacyCheckoutViewModelModule_ProvideViewModelFactoryFactory.create(legacyCheckoutViewModelModule, this.a, this.b, this.c, this.d, this.i, this.k, this.l, this.m, this.r, this.g, provider3, gVar, kVar));
        this.w = provider4;
        this.x = DoubleCheck.provider(LegacyCheckoutViewModelModule_ProvideBasketScreenViewModelImplFactory.create(legacyCheckoutViewModelModule, provider4));
        Provider<CrossClickListener> provider5 = DoubleCheck.provider(LegacyCheckoutViewModelModule_ProvideCrossClickListenerFactory.create(legacyCheckoutViewModelModule, this.x));
        this.z = provider5;
        BasketItemPresenter_Factory create7 = BasketItemPresenter_Factory.create(provider5);
        this.A = create7;
        BasketItemBlueprint_Factory create8 = BasketItemBlueprint_Factory.create(create7);
        this.B = create8;
        this.C = DoubleCheck.provider(create8);
        HeaderItemBlueprint_Factory create9 = HeaderItemBlueprint_Factory.create(HeaderItemPresenter_Factory.create());
        this.D = create9;
        this.E = DoubleCheck.provider(create9);
        TotalItemBlueprint_Factory create10 = TotalItemBlueprint_Factory.create(TotalItemPresenter_Factory.create());
        this.F = create10;
        this.G = DoubleCheck.provider(create10);
        Provider<OnDeepLinkClickListener> provider6 = DoubleCheck.provider(LegacyCheckoutViewModelModule_ProvideDeeplinkClickListenerFactory.create(legacyCheckoutViewModelModule, this.x));
        this.H = provider6;
        this.I = DoubleCheck.provider(LegacyCheckoutUiModule_ProvideDisclaimerItemPresenter$basket_releaseFactory.create(legacyCheckoutUiModule, provider6));
        Provider<AttributedTextFormatter> provider7 = SingleCheck.provider(AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory.create());
        this.J = provider7;
        DisclaimerItemBlueprint_Factory create11 = DisclaimerItemBlueprint_Factory.create(this.I, provider7);
        this.K = create11;
        this.L = DoubleCheck.provider(create11);
        SetFactory build = SetFactory.builder(4, 1).addCollectionProvider(this.y).addProvider(this.C).addProvider(this.E).addProvider(this.G).addProvider(this.L).build();
        this.M = build;
        Provider<ItemBinder> provider8 = SingleCheck.provider(AdapterModule_ProvideItemBinder$konveyor_releaseFactory.create(build));
        this.N = provider8;
        this.O = SingleCheck.provider(AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory.create(provider8));
    }

    public static LegacyCheckoutComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.basket_legacy.di.checkout.LegacyCheckoutComponent
    public void inject(LegacyCheckoutFragment legacyCheckoutFragment) {
        LegacyCheckoutFragment_MembersInjector.injectViewModel(legacyCheckoutFragment, this.x.get());
        LegacyCheckoutFragment_MembersInjector.injectItemBinder(legacyCheckoutFragment, this.N.get());
        LegacyCheckoutFragment_MembersInjector.injectAdapterPresenter(legacyCheckoutFragment, this.O.get());
    }
}

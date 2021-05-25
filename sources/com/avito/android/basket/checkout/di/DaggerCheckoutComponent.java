package com.avito.android.basket.checkout.di;

import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.avito.android.Features;
import com.avito.android.basket.checkout.CheckoutFragment;
import com.avito.android.basket.checkout.CheckoutFragment_MembersInjector;
import com.avito.android.basket.checkout.ResourceProvider;
import com.avito.android.basket.checkout.ResourceProviderImpl;
import com.avito.android.basket.checkout.ResourceProviderImpl_Factory;
import com.avito.android.basket.checkout.di.CheckoutComponent;
import com.avito.android.basket.checkout.item.checkout.CheckoutItemBlueprint;
import com.avito.android.basket.checkout.item.checkout.CheckoutItemBlueprint_Factory;
import com.avito.android.basket.checkout.item.checkout.CheckoutItemClickListener;
import com.avito.android.basket.checkout.item.checkout.CheckoutItemPresenter;
import com.avito.android.basket.checkout.item.checkout.CheckoutItemPresenter_Factory;
import com.avito.android.basket.checkout.item.disclaimer.CheckoutDisclaimerItemPresenter;
import com.avito.android.basket.checkout.item.disclaimer.CheckoutDisclaimerItemPresenter_Factory;
import com.avito.android.basket.checkout.item.disclaimer.DisclaimerItemBlueprint;
import com.avito.android.basket.checkout.item.disclaimer.DisclaimerItemBlueprint_Factory;
import com.avito.android.basket.checkout.item.price.PriceItemBlueprint;
import com.avito.android.basket.checkout.item.price.PriceItemBlueprint_Factory;
import com.avito.android.basket.checkout.item.price.PriceItemPresenter_Factory;
import com.avito.android.basket.checkout.item.prolongation.ProlongationItemBlueprint;
import com.avito.android.basket.checkout.item.prolongation.ProlongationItemBlueprint_Factory;
import com.avito.android.basket.checkout.item.prolongation.ProlongationItemPresenterImpl;
import com.avito.android.basket.checkout.item.prolongation.ProlongationItemPresenterImpl_Factory;
import com.avito.android.basket.checkout.utils.CheckoutCalculator;
import com.avito.android.basket.checkout.utils.CheckoutCalculatorImpl_Factory;
import com.avito.android.basket.checkout.utils.PriceItemCreator;
import com.avito.android.basket.checkout.utils.PriceItemCreatorImpl;
import com.avito.android.basket.checkout.utils.PriceItemCreatorImpl_Factory;
import com.avito.android.basket.checkout.viewmodel.CheckoutCommitConverter;
import com.avito.android.basket.checkout.viewmodel.CheckoutCommitConverterImpl;
import com.avito.android.basket.checkout.viewmodel.CheckoutCommitConverterImpl_Factory;
import com.avito.android.basket.checkout.viewmodel.CheckoutConverter;
import com.avito.android.basket.checkout.viewmodel.CheckoutConverterImpl;
import com.avito.android.basket.checkout.viewmodel.CheckoutConverterImpl_Factory;
import com.avito.android.basket.checkout.viewmodel.CheckoutRepository;
import com.avito.android.basket.checkout.viewmodel.CheckoutRepositoryImpl;
import com.avito.android.basket.checkout.viewmodel.CheckoutRepositoryImpl_Factory;
import com.avito.android.basket.checkout.viewmodel.CheckoutViewModel;
import com.avito.android.basket.checkout.viewmodel.CheckoutViewModelFactory;
import com.avito.android.basket.checkout.viewmodel.CheckoutViewModelFactory_Factory;
import com.avito.android.basket_legacy.utils.PriceFormatter;
import com.avito.android.basket_legacy.utils.PriceFormatterImpl;
import com.avito.android.basket_legacy.utils.PriceFormatterImpl_Factory;
import com.avito.android.conveyor_shared_item.paid_services.PaidServiceHeaderItemPresenter;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBinder$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory;
import com.avito.android.remote.CheckoutApi;
import com.avito.android.tariff.StringProvider;
import com.avito.android.tariff.di.HeaderModule_ProvideHeaderBlueprintFactory;
import com.avito.android.tariff.di.HeaderModule_ProvideHeaderPresenterFactory;
import com.avito.android.tariff.view.TariffBarConverter;
import com.avito.android.tariff.view.TariffBarConverterImpl_Factory;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SetBuilder;
import dagger.internal.SetFactory;
import dagger.internal.SingleCheck;
import java.util.Locale;
import java.util.Set;
import javax.inject.Provider;
public final class DaggerCheckoutComponent implements CheckoutComponent {
    public Provider<Kundle> A;
    public Provider<Features> B;
    public Provider<CheckoutViewModelFactory> C;
    public Provider<ViewModelProvider.Factory> D;
    public Provider<CheckoutViewModel> E;
    public Provider<CheckoutItemClickListener> F;
    public Provider<CheckoutItemPresenter> G;
    public Provider<CheckoutItemBlueprint> H;
    public Provider<ItemBlueprint<?, ?>> I;
    public Provider<ProlongationItemPresenterImpl> J;
    public Provider<ProlongationItemBlueprint> K;
    public Provider<ItemBlueprint<?, ?>> L;
    public Provider<PriceItemBlueprint> M;
    public Provider<ItemBlueprint<?, ?>> N;
    public Provider<CheckoutDisclaimerItemPresenter> O;
    public Provider<DisclaimerItemBlueprint> P;
    public Provider<Set<ItemBlueprint<?, ?>>> Q;
    public Provider<ItemBinder> R;
    public Provider<AdapterPresenter> S;
    public Provider<SimpleRecyclerAdapter> T;
    public Provider<ItemPresenter<?, ?>> U;
    public Provider<ItemPresenter<?, ?>> V;
    public Provider<Set<ItemBlueprint<?, ?>>> a = SingleCheck.provider(AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory.create());
    public Provider<PaidServiceHeaderItemPresenter> b;
    public Provider<ItemBlueprint<?, ?>> c;
    public Provider<Resources> d;
    public Provider<ResourceProviderImpl> e;
    public Provider<ResourceProvider> f;
    public Provider<Fragment> g;
    public Provider<String> h;
    public Provider<CheckoutApi> i;
    public Provider<SchedulersFactory> j;
    public Provider<CheckoutRepositoryImpl> k;
    public Provider<CheckoutRepository> l;
    public Provider<AttributedTextFormatter> m;
    public Provider<Locale> n;
    public Provider<PriceFormatterImpl> o;
    public Provider<PriceFormatter> p;
    public Provider<PriceItemCreatorImpl> q;
    public Provider<PriceItemCreator> r;
    public Provider<CheckoutConverterImpl> s;
    public Provider<CheckoutConverter> t;
    public Provider<TariffBarConverter> u;
    public Provider<CheckoutCommitConverterImpl> v;
    public Provider<CheckoutCommitConverter> w;
    public Provider<StringProvider> x;
    public Provider<DeepLinkIntentFactory> y;
    public Provider<CheckoutCalculator> z;

    public static final class b implements CheckoutComponent.Builder {
        public CheckoutDependencies a;
        public String b;
        public Fragment c;
        public Resources d;
        public Kundle e;

        public b(a aVar) {
        }

        @Override // com.avito.android.basket.checkout.di.CheckoutComponent.Builder
        public CheckoutComponent build() {
            Preconditions.checkBuilderRequirement(this.a, CheckoutDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, String.class);
            Preconditions.checkBuilderRequirement(this.c, Fragment.class);
            Preconditions.checkBuilderRequirement(this.d, Resources.class);
            Preconditions.checkBuilderRequirement(this.e, Kundle.class);
            return new DaggerCheckoutComponent(this.a, this.b, this.c, this.d, this.e, null);
        }

        @Override // com.avito.android.basket.checkout.di.CheckoutComponent.Builder
        public CheckoutComponent.Builder checkoutContext(String str) {
            this.b = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.basket.checkout.di.CheckoutComponent.Builder
        public CheckoutComponent.Builder dependencies(CheckoutDependencies checkoutDependencies) {
            this.a = (CheckoutDependencies) Preconditions.checkNotNull(checkoutDependencies);
            return this;
        }

        @Override // com.avito.android.basket.checkout.di.CheckoutComponent.Builder
        public CheckoutComponent.Builder fragment(Fragment fragment) {
            this.c = (Fragment) Preconditions.checkNotNull(fragment);
            return this;
        }

        @Override // com.avito.android.basket.checkout.di.CheckoutComponent.Builder
        public CheckoutComponent.Builder resources(Resources resources) {
            this.d = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.basket.checkout.di.CheckoutComponent.Builder
        public CheckoutComponent.Builder savedState(Kundle kundle) {
            this.e = (Kundle) Preconditions.checkNotNull(kundle);
            return this;
        }
    }

    public static class c implements Provider<AttributedTextFormatter> {
        public final CheckoutDependencies a;

        public c(CheckoutDependencies checkoutDependencies) {
            this.a = checkoutDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AttributedTextFormatter get() {
            return (AttributedTextFormatter) Preconditions.checkNotNullFromComponent(this.a.attributedTextFormatter());
        }
    }

    public static class d implements Provider<CheckoutApi> {
        public final CheckoutDependencies a;

        public d(CheckoutDependencies checkoutDependencies) {
            this.a = checkoutDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public CheckoutApi get() {
            return (CheckoutApi) Preconditions.checkNotNullFromComponent(this.a.checkoutApi());
        }
    }

    public static class e implements Provider<DeepLinkIntentFactory> {
        public final CheckoutDependencies a;

        public e(CheckoutDependencies checkoutDependencies) {
            this.a = checkoutDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public DeepLinkIntentFactory get() {
            return (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deeplinkIntentFactory());
        }
    }

    public static class f implements Provider<Features> {
        public final CheckoutDependencies a;

        public f(CheckoutDependencies checkoutDependencies) {
            this.a = checkoutDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class g implements Provider<Locale> {
        public final CheckoutDependencies a;

        public g(CheckoutDependencies checkoutDependencies) {
            this.a = checkoutDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Locale get() {
            return (Locale) Preconditions.checkNotNullFromComponent(this.a.locale());
        }
    }

    public static class h implements Provider<SchedulersFactory> {
        public final CheckoutDependencies a;

        public h(CheckoutDependencies checkoutDependencies) {
            this.a = checkoutDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class i implements Provider<StringProvider> {
        public final CheckoutDependencies a;

        public i(CheckoutDependencies checkoutDependencies) {
            this.a = checkoutDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public StringProvider get() {
            return (StringProvider) Preconditions.checkNotNullFromComponent(this.a.stringProvider());
        }
    }

    public DaggerCheckoutComponent(CheckoutDependencies checkoutDependencies, String str, Fragment fragment, Resources resources, Kundle kundle, a aVar) {
        Provider<PaidServiceHeaderItemPresenter> provider = DoubleCheck.provider(HeaderModule_ProvideHeaderPresenterFactory.create());
        this.b = provider;
        this.c = DoubleCheck.provider(HeaderModule_ProvideHeaderBlueprintFactory.create(provider));
        Factory create = InstanceFactory.create(resources);
        this.d = create;
        ResourceProviderImpl_Factory create2 = ResourceProviderImpl_Factory.create(create);
        this.e = create2;
        this.f = DoubleCheck.provider(create2);
        this.g = InstanceFactory.create(fragment);
        this.h = InstanceFactory.create(str);
        d dVar = new d(checkoutDependencies);
        this.i = dVar;
        h hVar = new h(checkoutDependencies);
        this.j = hVar;
        CheckoutRepositoryImpl_Factory create3 = CheckoutRepositoryImpl_Factory.create(dVar, hVar);
        this.k = create3;
        this.l = DoubleCheck.provider(create3);
        this.m = new c(checkoutDependencies);
        g gVar = new g(checkoutDependencies);
        this.n = gVar;
        PriceFormatterImpl_Factory create4 = PriceFormatterImpl_Factory.create(gVar);
        this.o = create4;
        Provider<PriceFormatter> provider2 = DoubleCheck.provider(create4);
        this.p = provider2;
        PriceItemCreatorImpl_Factory create5 = PriceItemCreatorImpl_Factory.create(provider2);
        this.q = create5;
        Provider<PriceItemCreator> provider3 = DoubleCheck.provider(create5);
        this.r = provider3;
        CheckoutConverterImpl_Factory create6 = CheckoutConverterImpl_Factory.create(this.m, provider3);
        this.s = create6;
        this.t = DoubleCheck.provider(create6);
        Provider<TariffBarConverter> provider4 = DoubleCheck.provider(TariffBarConverterImpl_Factory.create());
        this.u = provider4;
        CheckoutCommitConverterImpl_Factory create7 = CheckoutCommitConverterImpl_Factory.create(provider4);
        this.v = create7;
        this.w = DoubleCheck.provider(create7);
        this.x = new i(checkoutDependencies);
        this.y = new e(checkoutDependencies);
        this.z = DoubleCheck.provider(CheckoutCalculatorImpl_Factory.create());
        Factory create8 = InstanceFactory.create(kundle);
        this.A = create8;
        f fVar = new f(checkoutDependencies);
        this.B = fVar;
        CheckoutViewModelFactory_Factory create9 = CheckoutViewModelFactory_Factory.create(this.h, this.l, this.t, this.w, this.j, this.x, this.y, this.z, this.r, create8, fVar);
        this.C = create9;
        Provider<ViewModelProvider.Factory> provider5 = DoubleCheck.provider(create9);
        this.D = provider5;
        Provider<CheckoutViewModel> provider6 = DoubleCheck.provider(CheckoutModule_ProvideViewModelFactory.create(this.g, provider5));
        this.E = provider6;
        Provider<CheckoutItemClickListener> provider7 = DoubleCheck.provider(CheckoutModule_ProvideCheckoutItemListenerFactory.create(provider6));
        this.F = provider7;
        CheckoutItemPresenter_Factory create10 = CheckoutItemPresenter_Factory.create(this.f, provider7);
        this.G = create10;
        CheckoutItemBlueprint_Factory create11 = CheckoutItemBlueprint_Factory.create(create10);
        this.H = create11;
        this.I = DoubleCheck.provider(create11);
        Provider<ProlongationItemPresenterImpl> provider8 = DoubleCheck.provider(ProlongationItemPresenterImpl_Factory.create(this.f));
        this.J = provider8;
        ProlongationItemBlueprint_Factory create12 = ProlongationItemBlueprint_Factory.create(provider8);
        this.K = create12;
        this.L = DoubleCheck.provider(create12);
        PriceItemBlueprint_Factory create13 = PriceItemBlueprint_Factory.create(PriceItemPresenter_Factory.create());
        this.M = create13;
        this.N = DoubleCheck.provider(create13);
        Provider<CheckoutDisclaimerItemPresenter> provider9 = DoubleCheck.provider(CheckoutDisclaimerItemPresenter_Factory.create());
        this.O = provider9;
        this.P = DoubleCheck.provider(DisclaimerItemBlueprint_Factory.create(provider9, this.m));
        SetFactory build = SetFactory.builder(5, 1).addCollectionProvider(this.a).addProvider(this.c).addProvider(this.I).addProvider(this.L).addProvider(this.N).addProvider(this.P).build();
        this.Q = build;
        Provider<ItemBinder> provider10 = SingleCheck.provider(AdapterModule_ProvideItemBinder$konveyor_releaseFactory.create(build));
        this.R = provider10;
        Provider<AdapterPresenter> provider11 = SingleCheck.provider(AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory.create(provider10));
        this.S = provider11;
        this.T = DoubleCheck.provider(CheckoutModule_ProvideSimpleRecyclerAdapterFactory.create(provider11, this.R));
        this.U = DoubleCheck.provider(this.G);
        this.V = DoubleCheck.provider(PriceItemPresenter_Factory.create());
    }

    public static CheckoutComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.basket.checkout.di.CheckoutComponent
    public void inject(CheckoutFragment checkoutFragment) {
        CheckoutFragment_MembersInjector.injectAdapterPresenter(checkoutFragment, this.S.get());
        CheckoutFragment_MembersInjector.injectRecyclerAdapter(checkoutFragment, this.T.get());
        CheckoutFragment_MembersInjector.injectItemPresenterSet(checkoutFragment, SetBuilder.newSetBuilder(5).add(this.b.get()).add(this.U.get()).add(this.J.get()).add(this.V.get()).add(this.O.get()).build());
        CheckoutFragment_MembersInjector.injectViewModel(checkoutFragment, this.E.get());
    }
}

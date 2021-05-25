package com.avito.android.cart.di.component;

import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.TimerFactory_Factory;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTrackerImpl;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTrackerImpl_Factory;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.cart.analytics.summary.StepperUsageType;
import com.avito.android.cart.di.component.CartSummaryComponent;
import com.avito.android.cart.di.deps.CartSummaryDependencies;
import com.avito.android.cart.di.module.CartSummaryBlueprintsModule_ProvideDataAwareAdapterPresenterFactory;
import com.avito.android.cart.di.module.CartSummaryBlueprintsModule_ProvideDiffCalculatorFactory;
import com.avito.android.cart.di.module.CartSummaryBlueprintsModule_ProvideRecyclerAdapterFactory;
import com.avito.android.cart.di.module.CartSummaryModule_ProvideCartSummaryViewModel$cart_releaseFactory;
import com.avito.android.cart.di.module.CartSummaryTrackerModule_ProvidesScreenContentTypeFactory;
import com.avito.android.cart.di.module.CartSummaryTrackerModule_ProvidesScreenDiInjectTracker$cart_releaseFactory;
import com.avito.android.cart.di.module.CartSummaryTrackerModule_ProvidesScreenFlowTrackerProviderFactory;
import com.avito.android.cart.di.module.CartSummaryTrackerModule_ProvidesScreenInitTrackerFactory;
import com.avito.android.cart.summary.CartSummaryAnalyticsTracker;
import com.avito.android.cart.summary.CartSummaryAnalyticsTracker_Factory;
import com.avito.android.cart.summary.CartSummaryFragment;
import com.avito.android.cart.summary.CartSummaryFragment_MembersInjector;
import com.avito.android.cart.summary.CartSummaryRepository;
import com.avito.android.cart.summary.CartSummaryRepositoryImpl;
import com.avito.android.cart.summary.CartSummaryRepositoryImpl_Factory;
import com.avito.android.cart.summary.CartSummaryResourceProvider;
import com.avito.android.cart.summary.CartSummaryResourceProvider_Factory;
import com.avito.android.cart.summary.CartSummaryViewModel;
import com.avito.android.cart.summary.CartSummaryViewModelFactory;
import com.avito.android.cart.summary.CartSummaryViewModelFactory_Factory;
import com.avito.android.cart.summary.konveyor.CartSummaryItemsConverter;
import com.avito.android.cart.summary.konveyor.CartSummaryItemsConverterImpl_Factory;
import com.avito.android.cart.summary.konveyor.decoration.HeaderItemDecoration;
import com.avito.android.cart.summary.konveyor.decoration.HeaderItemDecoration_Factory;
import com.avito.android.cart.summary.konveyor.divider.DividerItemBlueprint;
import com.avito.android.cart.summary.konveyor.divider.DividerItemBlueprint_Factory;
import com.avito.android.cart.summary.konveyor.divider.DividerItemPresenter_Factory;
import com.avito.android.cart.summary.konveyor.header.HeaderItemBlueprint;
import com.avito.android.cart.summary.konveyor.header.HeaderItemBlueprint_Factory;
import com.avito.android.cart.summary.konveyor.header.HeaderItemPresenter_Factory;
import com.avito.android.cart.summary.konveyor.header.store.StoreHeaderItemBlueprint;
import com.avito.android.cart.summary.konveyor.header.store.StoreHeaderItemBlueprint_Factory;
import com.avito.android.cart.summary.konveyor.header.store.StoreHeaderItemPresenter_Factory;
import com.avito.android.cart.summary.konveyor.price.PriceItemBlueprint;
import com.avito.android.cart.summary.konveyor.price.PriceItemBlueprint_Factory;
import com.avito.android.cart.summary.konveyor.price.PriceItemPresenter_Factory;
import com.avito.android.cart.summary.konveyor.product.ProductItem;
import com.avito.android.cart.summary.konveyor.product.ProductItemBlueprint;
import com.avito.android.cart.summary.konveyor.product.ProductItemBlueprint_Factory;
import com.avito.android.cart.summary.konveyor.product.ProductItemPresenter;
import com.avito.android.cart.summary.konveyor.product.ProductItemPresenter_Factory;
import com.avito.android.cart.summary.konveyor.text.TextItemBlueprint;
import com.avito.android.cart.summary.konveyor.text.TextItemBlueprint_Factory;
import com.avito.android.cart.summary.konveyor.text.TextItemPresenter;
import com.avito.android.cart.summary.konveyor.text.TextItemPresenter_Factory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBinder$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.recycler.data_aware.DiffCalculator;
import com.avito.android.remote.cart.CartApi;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.android.util.text.AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.internal.DelegateFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SetFactory;
import dagger.internal.SingleCheck;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Collections;
import java.util.Set;
import javax.inject.Provider;
import kotlin.Pair;
public final class DaggerCartSummaryComponent implements CartSummaryComponent {
    public Provider<CartSummaryAnalyticsTracker> A;
    public Provider<SchedulersFactory3> B;
    public Provider<CartApi> C;
    public Provider<CartSummaryRepositoryImpl> D;
    public Provider<CartSummaryRepository> E;
    public Provider<CartSummaryItemsConverter> F;
    public Provider<Resources> G;
    public Provider<CartSummaryResourceProvider> H;
    public Provider<AccountStateProvider> I;
    public Provider<ActivityIntentFactory> J;
    public Provider<Observable<Pair<ProductItem, Integer>>> K;
    public Provider<Observable<ProductItem>> L;
    public Provider<Observable<String>> M;
    public Provider<Observable<Pair<ProductItem, StepperUsageType>>> N;
    public Provider<ScreenTrackerFactory> O;
    public Provider<String> P;
    public Provider<ScreenDiInjectTracker> Q;
    public Provider<ScreenInitTracker> R;
    public Provider<ScreenFlowTrackerProvider> S;
    public Provider<BaseScreenPerformanceTrackerImpl> T;
    public Provider<BaseScreenPerformanceTracker> U;
    public Provider<CartSummaryViewModelFactory> V;
    public Provider<CartSummaryViewModel> W;
    public Provider<TextItemPresenter> X;
    public Provider<TextItemBlueprint> Y;
    public Provider<ItemBlueprint<?, ?>> Z;
    public final CartSummaryDependencies a;
    public Provider<DividerItemBlueprint> a0;
    public Provider<DataAwareAdapterPresenter> b = new DelegateFactory();
    public Provider<ItemBlueprint<?, ?>> b0;
    public Provider<Set<ItemBlueprint<?, ?>>> c = SingleCheck.provider(AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory.create());
    public Provider<Set<ItemBlueprint<?, ?>>> c0;
    public Provider<PublishRelay<Pair<ProductItem, Integer>>> d;
    public Provider<ItemBinder> d0;
    public Provider<Consumer<Pair<ProductItem, Integer>>> e;
    public Provider<SimpleRecyclerAdapter> e0;
    public Provider<PublishRelay<ProductItem>> f;
    public Provider<AdapterPresenter> f0;
    public Provider<Consumer<ProductItem>> g;
    public Provider<DiffCalculator> g0;
    public Provider<PublishRelay<String>> h;
    public Provider<HeaderItemDecoration> h0;
    public Provider<Consumer<String>> i;
    public Provider<RecyclerView.ItemDecoration> i0;
    public Provider<PublishRelay<Integer>> j;
    public Provider<Consumer<Integer>> k;
    public Provider<PublishRelay<Pair<ProductItem, StepperUsageType>>> l;
    public Provider<Consumer<Pair<ProductItem, StepperUsageType>>> m;
    public Provider<ProductItemPresenter> n;
    public Provider<AttributedTextFormatter> o;
    public Provider<Observable<Integer>> p;
    public Provider<ProductItemBlueprint> q;
    public Provider<ItemBlueprint<?, ?>> r;
    public Provider<HeaderItemBlueprint> s;
    public Provider<ItemBlueprint<?, ?>> t;
    public Provider<StoreHeaderItemBlueprint> u;
    public Provider<ItemBlueprint<?, ?>> v;
    public Provider<PriceItemBlueprint> w;
    public Provider<ItemBlueprint<?, ?>> x;
    public Provider<Fragment> y;
    public Provider<Analytics> z;

    public static final class b implements CartSummaryComponent.Factory {
        public b(a aVar) {
        }

        @Override // com.avito.android.cart.di.component.CartSummaryComponent.Factory
        public CartSummaryComponent create(Fragment fragment, Resources resources, PublishRelay<Pair<ProductItem, Integer>> publishRelay, PublishRelay<ProductItem> publishRelay2, PublishRelay<String> publishRelay3, PublishRelay<Integer> publishRelay4, PublishRelay<Pair<ProductItem, StepperUsageType>> publishRelay5, CartSummaryDependencies cartSummaryDependencies) {
            Preconditions.checkNotNull(fragment);
            Preconditions.checkNotNull(resources);
            Preconditions.checkNotNull(publishRelay);
            Preconditions.checkNotNull(publishRelay2);
            Preconditions.checkNotNull(publishRelay3);
            Preconditions.checkNotNull(publishRelay4);
            Preconditions.checkNotNull(publishRelay5);
            Preconditions.checkNotNull(cartSummaryDependencies);
            return new DaggerCartSummaryComponent(cartSummaryDependencies, fragment, resources, publishRelay, publishRelay2, publishRelay3, publishRelay4, publishRelay5, null);
        }
    }

    public static class c implements Provider<AccountStateProvider> {
        public final CartSummaryDependencies a;

        public c(CartSummaryDependencies cartSummaryDependencies) {
            this.a = cartSummaryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AccountStateProvider get() {
            return (AccountStateProvider) Preconditions.checkNotNullFromComponent(this.a.accountStateProvider());
        }
    }

    public static class d implements Provider<ActivityIntentFactory> {
        public final CartSummaryDependencies a;

        public d(CartSummaryDependencies cartSummaryDependencies) {
            this.a = cartSummaryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ActivityIntentFactory get() {
            return (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory());
        }
    }

    public static class e implements Provider<Analytics> {
        public final CartSummaryDependencies a;

        public e(CartSummaryDependencies cartSummaryDependencies) {
            this.a = cartSummaryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class f implements Provider<CartApi> {
        public final CartSummaryDependencies a;

        public f(CartSummaryDependencies cartSummaryDependencies) {
            this.a = cartSummaryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public CartApi get() {
            return (CartApi) Preconditions.checkNotNullFromComponent(this.a.cartApi());
        }
    }

    public static class g implements Provider<SchedulersFactory3> {
        public final CartSummaryDependencies a;

        public g(CartSummaryDependencies cartSummaryDependencies) {
            this.a = cartSummaryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class h implements Provider<ScreenTrackerFactory> {
        public final CartSummaryDependencies a;

        public h(CartSummaryDependencies cartSummaryDependencies) {
            this.a = cartSummaryDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ScreenTrackerFactory get() {
            return (ScreenTrackerFactory) Preconditions.checkNotNullFromComponent(this.a.screenTrackerFactory());
        }
    }

    public DaggerCartSummaryComponent(CartSummaryDependencies cartSummaryDependencies, Fragment fragment, Resources resources, PublishRelay publishRelay, PublishRelay publishRelay2, PublishRelay publishRelay3, PublishRelay publishRelay4, PublishRelay publishRelay5, a aVar) {
        this.a = cartSummaryDependencies;
        Factory create = InstanceFactory.create(publishRelay);
        this.d = create;
        this.e = DoubleCheck.provider(create);
        Factory create2 = InstanceFactory.create(publishRelay2);
        this.f = create2;
        this.g = DoubleCheck.provider(create2);
        Factory create3 = InstanceFactory.create(publishRelay3);
        this.h = create3;
        this.i = DoubleCheck.provider(create3);
        Factory create4 = InstanceFactory.create(publishRelay4);
        this.j = create4;
        this.k = DoubleCheck.provider(create4);
        Factory create5 = InstanceFactory.create(publishRelay5);
        this.l = create5;
        Provider<Consumer<Pair<ProductItem, StepperUsageType>>> provider = DoubleCheck.provider(create5);
        this.m = provider;
        this.n = ProductItemPresenter_Factory.create(this.e, this.g, this.i, this.k, provider);
        this.o = SingleCheck.provider(AttributedTextFormatterModule_ProvideAttributedTextFormatterFactory.create());
        Provider<Observable<Integer>> provider2 = DoubleCheck.provider(this.j);
        this.p = provider2;
        ProductItemBlueprint_Factory create6 = ProductItemBlueprint_Factory.create(this.n, this.o, provider2);
        this.q = create6;
        this.r = DoubleCheck.provider(create6);
        HeaderItemBlueprint_Factory create7 = HeaderItemBlueprint_Factory.create(HeaderItemPresenter_Factory.create());
        this.s = create7;
        this.t = DoubleCheck.provider(create7);
        StoreHeaderItemBlueprint_Factory create8 = StoreHeaderItemBlueprint_Factory.create(StoreHeaderItemPresenter_Factory.create());
        this.u = create8;
        this.v = DoubleCheck.provider(create8);
        PriceItemBlueprint_Factory create9 = PriceItemBlueprint_Factory.create(PriceItemPresenter_Factory.create(), this.o);
        this.w = create9;
        this.x = DoubleCheck.provider(create9);
        this.y = InstanceFactory.create(fragment);
        e eVar = new e(cartSummaryDependencies);
        this.z = eVar;
        this.A = CartSummaryAnalyticsTracker_Factory.create(eVar);
        g gVar = new g(cartSummaryDependencies);
        this.B = gVar;
        f fVar = new f(cartSummaryDependencies);
        this.C = fVar;
        CartSummaryRepositoryImpl_Factory create10 = CartSummaryRepositoryImpl_Factory.create(gVar, fVar);
        this.D = create10;
        this.E = DoubleCheck.provider(create10);
        this.F = DoubleCheck.provider(CartSummaryItemsConverterImpl_Factory.create());
        Factory create11 = InstanceFactory.create(resources);
        this.G = create11;
        this.H = CartSummaryResourceProvider_Factory.create(create11);
        this.I = new c(cartSummaryDependencies);
        this.J = new d(cartSummaryDependencies);
        this.K = DoubleCheck.provider(this.d);
        this.L = DoubleCheck.provider(this.f);
        this.M = DoubleCheck.provider(this.h);
        this.N = DoubleCheck.provider(this.l);
        this.O = new h(cartSummaryDependencies);
        this.P = DoubleCheck.provider(CartSummaryTrackerModule_ProvidesScreenContentTypeFactory.create());
        this.Q = DoubleCheck.provider(CartSummaryTrackerModule_ProvidesScreenDiInjectTracker$cart_releaseFactory.create(this.O, TimerFactory_Factory.create(), this.P));
        this.R = DoubleCheck.provider(CartSummaryTrackerModule_ProvidesScreenInitTrackerFactory.create(this.O, TimerFactory_Factory.create(), this.P));
        Provider<ScreenFlowTrackerProvider> provider3 = DoubleCheck.provider(CartSummaryTrackerModule_ProvidesScreenFlowTrackerProviderFactory.create(this.O, TimerFactory_Factory.create()));
        this.S = provider3;
        BaseScreenPerformanceTrackerImpl_Factory create12 = BaseScreenPerformanceTrackerImpl_Factory.create(this.Q, this.R, provider3, this.P);
        this.T = create12;
        Provider<BaseScreenPerformanceTracker> provider4 = DoubleCheck.provider(create12);
        this.U = provider4;
        CartSummaryViewModelFactory_Factory create13 = CartSummaryViewModelFactory_Factory.create(this.A, this.E, this.F, this.H, this.I, this.B, this.J, this.K, this.L, this.M, this.N, provider4);
        this.V = create13;
        Provider<CartSummaryViewModel> provider5 = DoubleCheck.provider(CartSummaryModule_ProvideCartSummaryViewModel$cart_releaseFactory.create(this.y, create13));
        this.W = provider5;
        TextItemPresenter_Factory create14 = TextItemPresenter_Factory.create(provider5);
        this.X = create14;
        TextItemBlueprint_Factory create15 = TextItemBlueprint_Factory.create(create14, this.o);
        this.Y = create15;
        this.Z = DoubleCheck.provider(create15);
        DividerItemBlueprint_Factory create16 = DividerItemBlueprint_Factory.create(DividerItemPresenter_Factory.create());
        this.a0 = create16;
        this.b0 = DoubleCheck.provider(create16);
        SetFactory build = SetFactory.builder(6, 1).addCollectionProvider(this.c).addProvider(this.r).addProvider(this.t).addProvider(this.v).addProvider(this.x).addProvider(this.Z).addProvider(this.b0).build();
        this.c0 = build;
        Provider<ItemBinder> provider6 = SingleCheck.provider(AdapterModule_ProvideItemBinder$konveyor_releaseFactory.create(build));
        this.d0 = provider6;
        this.e0 = DoubleCheck.provider(CartSummaryBlueprintsModule_ProvideRecyclerAdapterFactory.create(this.b, provider6));
        this.f0 = SingleCheck.provider(AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory.create(this.d0));
        Provider<DiffCalculator> provider7 = DoubleCheck.provider(CartSummaryBlueprintsModule_ProvideDiffCalculatorFactory.create());
        this.g0 = provider7;
        DelegateFactory.setDelegate(this.b, DoubleCheck.provider(CartSummaryBlueprintsModule_ProvideDataAwareAdapterPresenterFactory.create(this.e0, this.f0, provider7)));
        HeaderItemDecoration_Factory create17 = HeaderItemDecoration_Factory.create(this.d0);
        this.h0 = create17;
        this.i0 = DoubleCheck.provider(create17);
    }

    public static CartSummaryComponent.Factory factory() {
        return new b(null);
    }

    @Override // com.avito.android.cart.di.component.CartSummaryComponent
    public void inject(CartSummaryFragment cartSummaryFragment) {
        CartSummaryFragment_MembersInjector.injectAdapterPresenter(cartSummaryFragment, this.b.get());
        CartSummaryFragment_MembersInjector.injectRecyclerAdapter(cartSummaryFragment, this.e0.get());
        CartSummaryFragment_MembersInjector.injectActivityIntentFactory(cartSummaryFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        CartSummaryFragment_MembersInjector.injectDeepLinkIntentFactory(cartSummaryFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        CartSummaryFragment_MembersInjector.injectAttributedTextFormatter(cartSummaryFragment, this.o.get());
        CartSummaryFragment_MembersInjector.injectAnalyticsTracker(cartSummaryFragment, new CartSummaryAnalyticsTracker((Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics())));
        CartSummaryFragment_MembersInjector.injectDecorations(cartSummaryFragment, Collections.singleton(this.i0.get()));
        CartSummaryFragment_MembersInjector.injectViewModel(cartSummaryFragment, this.W.get());
        CartSummaryFragment_MembersInjector.injectTracker(cartSummaryFragment, this.U.get());
    }
}

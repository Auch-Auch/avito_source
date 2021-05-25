package com.avito.android.shop.list.di;

import android.content.res.Resources;
import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.TopLocationInteractor;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.floating_views.FloatingViewsPresenterImpl;
import com.avito.android.floating_views.FloatingViewsPresenterImpl_Factory;
import com.avito.android.floating_views.PersistableFloatingViewsPresenter;
import com.avito.android.location.SavedLocationInteractor;
import com.avito.android.location.SavedLocationInteractorImpl;
import com.avito.android.location.SavedLocationInteractorImpl_Factory;
import com.avito.android.location.SavedLocationStorage;
import com.avito.android.location.back_navigation.BackNavigationLocationInteractor;
import com.avito.android.location.di.LocationDependencies;
import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.android.remote.LocationApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.shop.filter.ShopsSearchParameters;
import com.avito.android.serp.adapter.SerpSpanProvider;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.android.shop.detailed.di.ShopDetailedDependencies;
import com.avito.android.shop.list.ShopListFragment;
import com.avito.android.shop.list.ShopListFragment_MembersInjector;
import com.avito.android.shop.list.analytic.ShopListTracker;
import com.avito.android.shop.list.analytic.ShopListTrackerImpl;
import com.avito.android.shop.list.analytic.ShopListTrackerImpl_Factory;
import com.avito.android.shop.list.business.ShopListInteractor;
import com.avito.android.shop.list.business.ShopListInteractorImpl;
import com.avito.android.shop.list.business.ShopListInteractorImpl_Factory;
import com.avito.android.shop.list.business.ShopListResultConverter;
import com.avito.android.shop.list.business.ShopListResultConverterImpl_Factory;
import com.avito.android.shop.list.business.ShopSearchParamsConverter;
import com.avito.android.shop.list.business.ShopSearchParamsConverterImpl_Factory;
import com.avito.android.shop.list.di.ShopListComponent;
import com.avito.android.shop.list.presentation.ShopListConverter;
import com.avito.android.shop.list.presentation.ShopListConverterImpl;
import com.avito.android.shop.list.presentation.ShopListConverterImpl_Factory;
import com.avito.android.shop.list.presentation.ShopListDataChangeListener;
import com.avito.android.shop.list.presentation.ShopListDataChangeListenerImpl_Factory;
import com.avito.android.shop.list.presentation.ShopListPresenter;
import com.avito.android.shop.list.presentation.ShopListPresenterImpl;
import com.avito.android.shop.list.presentation.ShopListPresenterImpl_Factory;
import com.avito.android.shop.list.presentation.ShortcutNavigationItemConverter;
import com.avito.android.shop.list.presentation.ShortcutNavigationItemConverterImpl_Factory;
import com.avito.android.shop.list.presentation.item.ShopItemBlueprint;
import com.avito.android.shop.list.presentation.item.ShopItemBlueprint_Factory;
import com.avito.android.shop.list.presentation.item.ShopItemPresenter;
import com.avito.android.shop.list.presentation.item.ShopItemPresenterImpl;
import com.avito.android.shop.list.presentation.item.ShopItemPresenterImpl_Factory;
import com.avito.android.shop.remote.ShopsApi;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import javax.inject.Provider;
public final class DaggerShopListComponent implements ShopListComponent {
    public Provider<ShopListDataChangeListener> A;
    public Provider<Bundle> B;
    public Provider<FloatingViewsPresenterImpl> C;
    public Provider<PersistableFloatingViewsPresenter> D;
    public Provider<ShortcutNavigationItemConverter> E;
    public Provider<Analytics> F;
    public Provider<ShopsSearchParameters> G;
    public Provider<String> H;
    public Provider<Kundle> I;
    public Provider<ShopListPresenterImpl> J;
    public Provider<ShopListPresenter> K;
    public Provider<ShopItemPresenterImpl> L;
    public Provider<ShopItemPresenter> M;
    public Provider<ShopItemBlueprint> N;
    public Provider<ItemBinder> O;
    public Provider<DestroyableViewHolderBuilder> P;
    public Provider<AdapterPresenter> Q;
    public Provider<Resources> R;
    public Provider<SpannedGridPositionProvider> S;
    public Provider<SerpSpanProvider> T;
    public Provider<GridLayoutManager.SpanSizeLookup> U;
    public final ShopDetailedDependencies a;
    public Provider<ScreenTrackerFactory> b;
    public Provider<TimerFactory> c;
    public Provider<ScreenDiInjectTracker> d;
    public Provider<ScreenInitTracker> e = DoubleCheck.provider(ShopListModule_ProvidesScreenInitTrackerFactory.create(this.b, this.c));
    public Provider<ScreenFlowTrackerProvider> f;
    public Provider<ShopListTrackerImpl> g;
    public Provider<ShopListTracker> h;
    public Provider<ShopsApi> i;
    public Provider<LocationApi> j;
    public Provider<SavedLocationStorage> k;
    public Provider<TopLocationInteractor> l;
    public Provider<Features> m;
    public Provider<BackNavigationLocationInteractor> n;
    public Provider<SavedLocationInteractorImpl> o;
    public Provider<SavedLocationInteractor> p;
    public Provider<ShopSearchParamsConverter> q;
    public Provider<ShopListResultConverter> r;
    public Provider<TypedErrorThrowableConverter> s;
    public Provider<SchedulersFactory3> t;
    public Provider<Kundle> u;
    public Provider<ShopListInteractorImpl> v;
    public Provider<ShopListInteractor> w;
    public Provider<Integer> x;
    public Provider<ShopListConverterImpl> y;
    public Provider<ShopListConverter> z;

    public static final class b implements ShopListComponent.Builder {
        public LocationDependencies a;
        public ShopDetailedDependencies b;
        public Resources c;
        public ShopsSearchParameters d;
        public String e;
        public Kundle f;
        public Kundle g;
        public Bundle h;
        public Integer i;

        public b(a aVar) {
        }

        @Override // com.avito.android.shop.list.di.ShopListComponent.Builder
        public ShopListComponent build() {
            Preconditions.checkBuilderRequirement(this.a, LocationDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, ShopDetailedDependencies.class);
            Preconditions.checkBuilderRequirement(this.c, Resources.class);
            Preconditions.checkBuilderRequirement(this.d, ShopsSearchParameters.class);
            Preconditions.checkBuilderRequirement(this.i, Integer.class);
            return new DaggerShopListComponent(this.b, this.a, this.c, this.d, this.e, this.f, this.g, this.h, this.i, null);
        }

        @Override // com.avito.android.shop.list.di.ShopListComponent.Builder
        public ShopListComponent.Builder locationDependencies(LocationDependencies locationDependencies) {
            this.a = (LocationDependencies) Preconditions.checkNotNull(locationDependencies);
            return this;
        }

        @Override // com.avito.android.shop.list.di.ShopListComponent.Builder
        public ShopListComponent.Builder shopDetailedDependencies(ShopDetailedDependencies shopDetailedDependencies) {
            this.b = (ShopDetailedDependencies) Preconditions.checkNotNull(shopDetailedDependencies);
            return this;
        }

        @Override // com.avito.android.shop.list.di.ShopListComponent.Builder
        @Deprecated
        public ShopListComponent.Builder shopListModule(ShopListModule shopListModule) {
            Preconditions.checkNotNull(shopListModule);
            return this;
        }

        @Override // com.avito.android.shop.list.di.ShopListComponent.Builder
        public ShopListComponent.Builder withFloatingViewState(Bundle bundle) {
            this.h = bundle;
            return this;
        }

        @Override // com.avito.android.shop.list.di.ShopListComponent.Builder
        public ShopListComponent.Builder withInteractorState(Kundle kundle) {
            this.g = kundle;
            return this;
        }

        @Override // com.avito.android.shop.list.di.ShopListComponent.Builder
        public ShopListComponent.Builder withLocationName(String str) {
            this.e = str;
            return this;
        }

        @Override // com.avito.android.shop.list.di.ShopListComponent.Builder
        public ShopListComponent.Builder withPresenterState(Kundle kundle) {
            this.f = kundle;
            return this;
        }

        @Override // com.avito.android.shop.list.di.ShopListComponent.Builder
        public ShopListComponent.Builder withResources(Resources resources) {
            this.c = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.shop.list.di.ShopListComponent.Builder
        public ShopListComponent.Builder withSearchParams(ShopsSearchParameters shopsSearchParameters) {
            this.d = (ShopsSearchParameters) Preconditions.checkNotNull(shopsSearchParameters);
            return this;
        }

        @Override // com.avito.android.shop.list.di.ShopListComponent.Builder
        public ShopListComponent.Builder withSpanCount(int i2) {
            this.i = (Integer) Preconditions.checkNotNull(Integer.valueOf(i2));
            return this;
        }
    }

    public static class c implements Provider<BackNavigationLocationInteractor> {
        public final LocationDependencies a;

        public c(LocationDependencies locationDependencies) {
            this.a = locationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public BackNavigationLocationInteractor get() {
            return (BackNavigationLocationInteractor) Preconditions.checkNotNullFromComponent(this.a.backNavigationLocationInteractor());
        }
    }

    public static class d implements Provider<LocationApi> {
        public final LocationDependencies a;

        public d(LocationDependencies locationDependencies) {
            this.a = locationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public LocationApi get() {
            return (LocationApi) Preconditions.checkNotNullFromComponent(this.a.locationApi());
        }
    }

    public static class e implements Provider<SavedLocationStorage> {
        public final LocationDependencies a;

        public e(LocationDependencies locationDependencies) {
            this.a = locationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SavedLocationStorage get() {
            return (SavedLocationStorage) Preconditions.checkNotNullFromComponent(this.a.savedLocationStorage());
        }
    }

    public static class f implements Provider<TopLocationInteractor> {
        public final LocationDependencies a;

        public f(LocationDependencies locationDependencies) {
            this.a = locationDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TopLocationInteractor get() {
            return (TopLocationInteractor) Preconditions.checkNotNullFromComponent(this.a.topLocationInteractor());
        }
    }

    public static class g implements Provider<Analytics> {
        public final ShopDetailedDependencies a;

        public g(ShopDetailedDependencies shopDetailedDependencies) {
            this.a = shopDetailedDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class h implements Provider<Features> {
        public final ShopDetailedDependencies a;

        public h(ShopDetailedDependencies shopDetailedDependencies) {
            this.a = shopDetailedDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class i implements Provider<SchedulersFactory3> {
        public final ShopDetailedDependencies a;

        public i(ShopDetailedDependencies shopDetailedDependencies) {
            this.a = shopDetailedDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class j implements Provider<ScreenTrackerFactory> {
        public final ShopDetailedDependencies a;

        public j(ShopDetailedDependencies shopDetailedDependencies) {
            this.a = shopDetailedDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ScreenTrackerFactory get() {
            return (ScreenTrackerFactory) Preconditions.checkNotNullFromComponent(this.a.screenTrackerFactory());
        }
    }

    public static class k implements Provider<ShopsApi> {
        public final ShopDetailedDependencies a;

        public k(ShopDetailedDependencies shopDetailedDependencies) {
            this.a = shopDetailedDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ShopsApi get() {
            return (ShopsApi) Preconditions.checkNotNullFromComponent(this.a.shopsApi());
        }
    }

    public static class l implements Provider<TimerFactory> {
        public final ShopDetailedDependencies a;

        public l(ShopDetailedDependencies shopDetailedDependencies) {
            this.a = shopDetailedDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimerFactory get() {
            return (TimerFactory) Preconditions.checkNotNullFromComponent(this.a.timerFactory());
        }
    }

    public static class m implements Provider<TypedErrorThrowableConverter> {
        public final ShopDetailedDependencies a;

        public m(ShopDetailedDependencies shopDetailedDependencies) {
            this.a = shopDetailedDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
        }
    }

    public DaggerShopListComponent(ShopDetailedDependencies shopDetailedDependencies, LocationDependencies locationDependencies, Resources resources, ShopsSearchParameters shopsSearchParameters, String str, Kundle kundle, Kundle kundle2, Bundle bundle, Integer num, a aVar) {
        this.a = shopDetailedDependencies;
        j jVar = new j(shopDetailedDependencies);
        this.b = jVar;
        l lVar = new l(shopDetailedDependencies);
        this.c = lVar;
        this.d = DoubleCheck.provider(ShopListModule_ProvidesScreenDiInjectTracker$shop_releaseFactory.create(jVar, lVar));
        Provider<ScreenFlowTrackerProvider> provider = DoubleCheck.provider(ShopListModule_ProvidesScreenFlowTrackerProviderFactory.create(this.b, this.c));
        this.f = provider;
        ShopListTrackerImpl_Factory create = ShopListTrackerImpl_Factory.create(this.d, this.e, provider);
        this.g = create;
        this.h = DoubleCheck.provider(create);
        this.i = new k(shopDetailedDependencies);
        d dVar = new d(locationDependencies);
        this.j = dVar;
        e eVar = new e(locationDependencies);
        this.k = eVar;
        f fVar = new f(locationDependencies);
        this.l = fVar;
        h hVar = new h(shopDetailedDependencies);
        this.m = hVar;
        c cVar = new c(locationDependencies);
        this.n = cVar;
        SavedLocationInteractorImpl_Factory create2 = SavedLocationInteractorImpl_Factory.create(eVar, dVar, fVar, hVar, cVar);
        this.o = create2;
        this.p = SingleCheck.provider(create2);
        this.q = DoubleCheck.provider(ShopSearchParamsConverterImpl_Factory.create());
        this.r = DoubleCheck.provider(ShopListResultConverterImpl_Factory.create());
        this.s = new m(shopDetailedDependencies);
        this.t = new i(shopDetailedDependencies);
        Factory createNullable = InstanceFactory.createNullable(kundle2);
        this.u = createNullable;
        ShopListInteractorImpl_Factory create3 = ShopListInteractorImpl_Factory.create(this.i, this.j, this.p, this.q, this.r, this.s, this.t, createNullable);
        this.v = create3;
        this.w = DoubleCheck.provider(create3);
        Factory create4 = InstanceFactory.create(num);
        this.x = create4;
        ShopListConverterImpl_Factory create5 = ShopListConverterImpl_Factory.create(create4);
        this.y = create5;
        this.z = DoubleCheck.provider(create5);
        this.A = DoubleCheck.provider(ShopListDataChangeListenerImpl_Factory.create());
        Factory createNullable2 = InstanceFactory.createNullable(bundle);
        this.B = createNullable2;
        FloatingViewsPresenterImpl_Factory create6 = FloatingViewsPresenterImpl_Factory.create(createNullable2);
        this.C = create6;
        this.D = DoubleCheck.provider(create6);
        this.E = DoubleCheck.provider(ShortcutNavigationItemConverterImpl_Factory.create());
        this.F = new g(shopDetailedDependencies);
        this.G = InstanceFactory.create(shopsSearchParameters);
        this.H = InstanceFactory.createNullable(str);
        Factory createNullable3 = InstanceFactory.createNullable(kundle);
        this.I = createNullable3;
        ShopListPresenterImpl_Factory create7 = ShopListPresenterImpl_Factory.create(this.h, this.w, this.z, this.A, this.D, this.t, this.E, this.F, this.m, this.G, this.H, createNullable3);
        this.J = create7;
        Provider<ShopListPresenter> provider2 = DoubleCheck.provider(create7);
        this.K = provider2;
        ShopItemPresenterImpl_Factory create8 = ShopItemPresenterImpl_Factory.create(provider2);
        this.L = create8;
        Provider<ShopItemPresenter> provider3 = DoubleCheck.provider(create8);
        this.M = provider3;
        ShopItemBlueprint_Factory create9 = ShopItemBlueprint_Factory.create(provider3);
        this.N = create9;
        Provider<ItemBinder> provider4 = DoubleCheck.provider(ShopListModule_ProvideItemBinder$shop_releaseFactory.create(create9));
        this.O = provider4;
        this.P = DoubleCheck.provider(ShopListModule_ProvideDestroyableViewHolderBuilder$shop_releaseFactory.create(provider4));
        this.Q = DoubleCheck.provider(ShopListModule_ProvideAdapterPresenter$shop_releaseFactory.create(this.O));
        Factory create10 = InstanceFactory.create(resources);
        this.R = create10;
        Provider<SpannedGridPositionProvider> provider5 = DoubleCheck.provider(ShopListModule_ProvideGridPositionProvider$shop_releaseFactory.create(create10));
        this.S = provider5;
        Provider<SerpSpanProvider> provider6 = DoubleCheck.provider(ShopListModule_ProvideSpanProvider$shop_releaseFactory.create(provider5, this.K, this.R));
        this.T = provider6;
        this.U = DoubleCheck.provider(ShopListModule_ProvideSpanLookup$shop_releaseFactory.create(provider6));
    }

    public static ShopListComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.shop.list.di.ShopListComponent
    public void inject(ShopListFragment shopListFragment) {
        ShopListFragment_MembersInjector.injectPresenter(shopListFragment, this.K.get());
        ShopListFragment_MembersInjector.injectInteractor(shopListFragment, this.w.get());
        ShopListFragment_MembersInjector.injectFloatingViewsPresenter(shopListFragment, this.D.get());
        ShopListFragment_MembersInjector.injectImplicitIntentFactory(shopListFragment, (ImplicitIntentFactory) Preconditions.checkNotNullFromComponent(this.a.implicitIntentFactory()));
        ShopListFragment_MembersInjector.injectActivityIntentFactory(shopListFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        ShopListFragment_MembersInjector.injectSchedulers(shopListFragment, (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3()));
        ShopListFragment_MembersInjector.injectShopListTracker(shopListFragment, this.h.get());
        ShopListFragment_MembersInjector.injectShopListDataChangeListener(shopListFragment, this.A.get());
        ShopListFragment_MembersInjector.injectDeepLinkIntentFactory(shopListFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        ShopListFragment_MembersInjector.injectViewHolderBuilder(shopListFragment, this.P.get());
        ShopListFragment_MembersInjector.injectAdapterPresenter(shopListFragment, this.Q.get());
        ShopListFragment_MembersInjector.injectAnalytics(shopListFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        ShopListFragment_MembersInjector.injectBuildInfo(shopListFragment, (BuildInfo) Preconditions.checkNotNullFromComponent(this.a.buildInfo()));
        ShopListFragment_MembersInjector.injectGridPositionProvider(shopListFragment, this.S.get());
        ShopListFragment_MembersInjector.injectSpanSizeLookup(shopListFragment, this.U.get());
        ShopListFragment_MembersInjector.injectSpanProvider(shopListFragment, this.T.get());
        ShopListFragment_MembersInjector.injectFeatures(shopListFragment, (Features) Preconditions.checkNotNullFromComponent(this.a.features()));
    }
}

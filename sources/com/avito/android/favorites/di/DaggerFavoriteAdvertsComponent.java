package com.avito.android.favorites.di;

import android.content.Context;
import android.content.res.Resources;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.ab_tests.groups.SimpleTestGroupWithNone;
import com.avito.android.ab_tests.models.ExposedAbTestGroup;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.provider.TreeStateIdGenerator_Factory;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.common.CounterInteractor;
import com.avito.android.db.favorites.FavoriteItemsDao;
import com.avito.android.db.favorites.FavoritesSyncDao;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.favorite.FavoriteAdvertsEventInteractor;
import com.avito.android.favorite.FavoriteAdvertsInteractor;
import com.avito.android.favorites.FavoriteAdvertItemConverter;
import com.avito.android.favorites.FavoriteAdvertItemConverterImpl;
import com.avito.android.favorites.FavoriteAdvertItemConverterImpl_Factory;
import com.avito.android.favorites.FavoriteAdvertItemConverterResourceProvider;
import com.avito.android.favorites.FavoriteAdvertItemConverterResourceProviderImpl;
import com.avito.android.favorites.FavoriteAdvertItemConverterResourceProviderImpl_Factory;
import com.avito.android.favorites.FavoriteAdvertsListInteractorImpl;
import com.avito.android.favorites.FavoriteAdvertsListInteractorImpl_Factory;
import com.avito.android.favorites.FavoriteAdvertsSyncEventProvider;
import com.avito.android.favorites.FavoriteAdvertsSyncRunner;
import com.avito.android.favorites.FavoriteListResourceProvider;
import com.avito.android.favorites.FavoriteListResourceProviderImpl;
import com.avito.android.favorites.FavoriteListResourceProviderImpl_Factory;
import com.avito.android.favorites.FavoriteStorage;
import com.avito.android.favorites.FavoritesFragment;
import com.avito.android.favorites.FavoritesFragment_MembersInjector;
import com.avito.android.favorites.FavoritesListInteractor;
import com.avito.android.favorites.FavoritesListPresenter;
import com.avito.android.favorites.FavoritesListPresenterImpl;
import com.avito.android.favorites.FavoritesListPresenterImpl_Factory;
import com.avito.android.favorites.FavoritesListStorage;
import com.avito.android.favorites.PrefFavoriteStorage;
import com.avito.android.favorites.PrefFavoriteStorage_Factory;
import com.avito.android.favorites.action.FavoriteItemAction;
import com.avito.android.favorites.adapter.advert.FavoriteAdvertItemBlueprint;
import com.avito.android.favorites.adapter.advert.FavoriteAdvertItemBlueprint_Factory;
import com.avito.android.favorites.adapter.advert.FavoriteAdvertItemPresenter;
import com.avito.android.favorites.adapter.advert.FavoriteAdvertItemPresenterImpl;
import com.avito.android.favorites.adapter.advert.FavoriteAdvertItemPresenterImpl_Factory;
import com.avito.android.favorites.adapter.byuer_can_ask_item_test.TestFavoriteAdvertItemBlueprint;
import com.avito.android.favorites.adapter.byuer_can_ask_item_test.TestFavoriteAdvertItemBlueprint_Factory;
import com.avito.android.favorites.adapter.byuer_can_ask_item_test.TestFavoriteAdvertItemPresenter;
import com.avito.android.favorites.adapter.byuer_can_ask_item_test.TestFavoriteAdvertItemPresenterImpl;
import com.avito.android.favorites.adapter.byuer_can_ask_item_test.TestFavoriteAdvertItemPresenterImpl_Factory;
import com.avito.android.favorites.adapter.error.FavoriteErrorItemBlueprint;
import com.avito.android.favorites.adapter.error.FavoriteErrorItemBlueprint_Factory;
import com.avito.android.favorites.adapter.error.FavoriteErrorItemPresenter;
import com.avito.android.favorites.adapter.error.FavoriteErrorItemPresenterImpl;
import com.avito.android.favorites.adapter.error.FavoriteErrorItemPresenterImpl_Factory;
import com.avito.android.favorites.adapter.loading.FavoriteLoadingItemBlueprint;
import com.avito.android.favorites.adapter.loading.FavoriteLoadingItemBlueprint_Factory;
import com.avito.android.favorites.adapter.loading.FavoriteLoadingItemPresenter;
import com.avito.android.favorites.adapter.loading.FavoriteLoadingItemPresenterImpl;
import com.avito.android.favorites.adapter.loading.FavoriteLoadingItemPresenterImpl_Factory;
import com.avito.android.favorites.di.FavoriteAdvertsComponent;
import com.avito.android.favorites.remote.FavoritesApi;
import com.avito.android.favorites.tracker.FavoritesTracker;
import com.avito.android.favorites.tracker.FavoritesTrackerImpl;
import com.avito.android.favorites.tracker.FavoritesTrackerImpl_Factory;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.AdvertPrice;
import com.avito.android.server_time.TimeSource;
import com.avito.android.util.AdvertPriceFormatter;
import com.avito.android.util.AdvertPriceFormatter_Factory;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.ErrorFormatterImpl_Factory;
import com.avito.android.util.Formatter;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.preferences.Preferences;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.jakewharton.rxrelay2.PublishRelay;
import dagger.internal.DelegateFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.Locale;
import javax.inject.Provider;
public final class DaggerFavoriteAdvertsComponent implements FavoriteAdvertsComponent {
    public Provider<FavoritesListPresenter> A;
    public Provider<ExposedAbTestGroup<SimpleTestGroupWithNone>> B;
    public Provider<FavoriteAdvertItemPresenterImpl> C;
    public Provider<FavoriteAdvertItemPresenter> D;
    public Provider<TimeSource> E;
    public Provider<FavoriteAdvertItemBlueprint> F;
    public Provider<TestFavoriteAdvertItemPresenterImpl> G;
    public Provider<TestFavoriteAdvertItemPresenter> H;
    public Provider<TestFavoriteAdvertItemBlueprint> I;
    public Provider<PublishRelay<FavoriteItemAction>> J;
    public Provider<Consumer<FavoriteItemAction>> K;
    public Provider<FavoriteLoadingItemPresenterImpl> L;
    public Provider<FavoriteLoadingItemPresenter> M;
    public Provider<FavoriteLoadingItemBlueprint> N;
    public Provider<FavoriteErrorItemPresenterImpl> O;
    public Provider<FavoriteErrorItemPresenter> P;
    public Provider<FavoriteErrorItemBlueprint> Q;
    public Provider<ItemBinder> R;
    public Provider<AdapterPresenter> S;
    public Provider<FavoriteAdvertsInteractor> T;
    public Provider<FavoriteListResourceProviderImpl> U;
    public Provider<FavoriteListResourceProvider> V;
    public Provider<ScreenTrackerFactory> W;
    public Provider<TimerFactory> X;
    public Provider<ScreenDiInjectTracker> Y;
    public Provider<ScreenInitTracker> Z = DoubleCheck.provider(FavoriteTrackerModule_ProvideScreenInitTrackerFactory.create(this.W, this.X));
    public final FavoriteAdvertsDependencies a;
    public Provider<ScreenFlowTrackerProvider> a0;
    public Provider<FavoriteAdvertsSyncEventProvider> b;
    public Provider<FavoritesTrackerImpl> b0;
    public Provider<AccountStateProvider> c;
    public Provider<FavoritesTracker> c0;
    public Provider<FavoritesApi> d;
    public Provider<Analytics> d0;
    public Provider<FavoriteItemsDao> e;
    public Provider<Observable<FavoriteItemAction>> e0;
    public Provider<FavoritesSyncDao> f;
    public Provider<ErrorFormatterImpl> f0;
    public Provider<FavoriteAdvertsEventInteractor> g;
    public Provider<ErrorFormatter> g0;
    public Provider<TypedErrorThrowableConverter> h;
    public Provider<FavoritesListStorage> h0;
    public Provider<Preferences> i;
    public Provider<Kundle> i0;
    public Provider<PrefFavoriteStorage> j;
    public Provider<FavoritesListPresenterImpl> j0;
    public Provider<FavoriteStorage> k;
    public Provider<SchedulersFactory> l;
    public Provider<Locale> m;
    public Provider<AdvertPriceFormatter> n;
    public Provider<Formatter<AdvertPrice>> o;
    public Provider<Resources> p;
    public Provider<FavoriteAdvertItemConverterResourceProviderImpl> q;
    public Provider<FavoriteAdvertItemConverterResourceProvider> r;
    public Provider<Features> s;
    public Provider<FavoriteAdvertItemConverterImpl> t;
    public Provider<FavoriteAdvertItemConverter> u;
    public Provider<CounterInteractor> v;
    public Provider<FavoriteAdvertsListInteractorImpl> w;
    public Provider<FavoritesListInteractor> x;
    public Provider<AbTestsConfigProvider> y;
    public Provider<Boolean> z;

    public static final class b implements FavoriteAdvertsComponent.Builder {
        public FavoriteAdvertsDependencies a;
        public Resources b;
        public Context c;
        public PublishRelay<FavoriteItemAction> d;
        public Kundle e;

        public b(a aVar) {
        }

        @Override // com.avito.android.favorites.di.FavoriteAdvertsComponent.Builder
        public FavoriteAdvertsComponent build() {
            Preconditions.checkBuilderRequirement(this.a, FavoriteAdvertsDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, Resources.class);
            Preconditions.checkBuilderRequirement(this.c, Context.class);
            Preconditions.checkBuilderRequirement(this.d, PublishRelay.class);
            return new DaggerFavoriteAdvertsComponent(this.a, this.b, this.c, this.d, this.e, null);
        }

        @Override // com.avito.android.favorites.di.FavoriteAdvertsComponent.Builder
        public FavoriteAdvertsComponent.Builder dependentOn(FavoriteAdvertsDependencies favoriteAdvertsDependencies) {
            this.a = (FavoriteAdvertsDependencies) Preconditions.checkNotNull(favoriteAdvertsDependencies);
            return this;
        }

        @Override // com.avito.android.favorites.di.FavoriteAdvertsComponent.Builder
        public FavoriteAdvertsComponent.Builder withActionRelay(PublishRelay publishRelay) {
            this.d = (PublishRelay) Preconditions.checkNotNull(publishRelay);
            return this;
        }

        @Override // com.avito.android.favorites.di.FavoriteAdvertsComponent.Builder
        public FavoriteAdvertsComponent.Builder withContext(Context context) {
            this.c = (Context) Preconditions.checkNotNull(context);
            return this;
        }

        @Override // com.avito.android.favorites.di.FavoriteAdvertsComponent.Builder
        public FavoriteAdvertsComponent.Builder withPresenterState(Kundle kundle) {
            this.e = kundle;
            return this;
        }

        @Override // com.avito.android.favorites.di.FavoriteAdvertsComponent.Builder
        public FavoriteAdvertsComponent.Builder withResources(Resources resources) {
            this.b = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }
    }

    public static class c implements Provider<AbTestsConfigProvider> {
        public final FavoriteAdvertsDependencies a;

        public c(FavoriteAdvertsDependencies favoriteAdvertsDependencies) {
            this.a = favoriteAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AbTestsConfigProvider get() {
            return (AbTestsConfigProvider) Preconditions.checkNotNullFromComponent(this.a.abTestsConfigProvider());
        }
    }

    public static class d implements Provider<AccountStateProvider> {
        public final FavoriteAdvertsDependencies a;

        public d(FavoriteAdvertsDependencies favoriteAdvertsDependencies) {
            this.a = favoriteAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AccountStateProvider get() {
            return (AccountStateProvider) Preconditions.checkNotNullFromComponent(this.a.accountStateProvider());
        }
    }

    public static class e implements Provider<Analytics> {
        public final FavoriteAdvertsDependencies a;

        public e(FavoriteAdvertsDependencies favoriteAdvertsDependencies) {
            this.a = favoriteAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class f implements Provider<FavoriteAdvertsEventInteractor> {
        public final FavoriteAdvertsDependencies a;

        public f(FavoriteAdvertsDependencies favoriteAdvertsDependencies) {
            this.a = favoriteAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoriteAdvertsEventInteractor get() {
            return (FavoriteAdvertsEventInteractor) Preconditions.checkNotNullFromComponent(this.a.favoriteAdvertsEventInteractor());
        }
    }

    public static class g implements Provider<FavoriteAdvertsInteractor> {
        public final FavoriteAdvertsDependencies a;

        public g(FavoriteAdvertsDependencies favoriteAdvertsDependencies) {
            this.a = favoriteAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoriteAdvertsInteractor get() {
            return (FavoriteAdvertsInteractor) Preconditions.checkNotNullFromComponent(this.a.favoriteAdvertsInteractor());
        }
    }

    public static class h implements Provider<FavoriteAdvertsSyncEventProvider> {
        public final FavoriteAdvertsDependencies a;

        public h(FavoriteAdvertsDependencies favoriteAdvertsDependencies) {
            this.a = favoriteAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoriteAdvertsSyncEventProvider get() {
            return (FavoriteAdvertsSyncEventProvider) Preconditions.checkNotNullFromComponent(this.a.favoriteAdvertsSyncEventProvider());
        }
    }

    public static class i implements Provider<FavoriteItemsDao> {
        public final FavoriteAdvertsDependencies a;

        public i(FavoriteAdvertsDependencies favoriteAdvertsDependencies) {
            this.a = favoriteAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoriteItemsDao get() {
            return (FavoriteItemsDao) Preconditions.checkNotNullFromComponent(this.a.favoriteItemsDao());
        }
    }

    public static class j implements Provider<ExposedAbTestGroup<SimpleTestGroupWithNone>> {
        public final FavoriteAdvertsDependencies a;

        public j(FavoriteAdvertsDependencies favoriteAdvertsDependencies) {
            this.a = favoriteAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ExposedAbTestGroup<SimpleTestGroupWithNone> get() {
            return (ExposedAbTestGroup) Preconditions.checkNotNullFromComponent(this.a.favoriteSimilarAdvertsTestGroup());
        }
    }

    public static class k implements Provider<FavoritesApi> {
        public final FavoriteAdvertsDependencies a;

        public k(FavoriteAdvertsDependencies favoriteAdvertsDependencies) {
            this.a = favoriteAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoritesApi get() {
            return (FavoritesApi) Preconditions.checkNotNullFromComponent(this.a.favoritesApi());
        }
    }

    public static class l implements Provider<CounterInteractor> {
        public final FavoriteAdvertsDependencies a;

        public l(FavoriteAdvertsDependencies favoriteAdvertsDependencies) {
            this.a = favoriteAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public CounterInteractor get() {
            return (CounterInteractor) Preconditions.checkNotNullFromComponent(this.a.favoritesInteractor());
        }
    }

    public static class m implements Provider<FavoritesListStorage> {
        public final FavoriteAdvertsDependencies a;

        public m(FavoriteAdvertsDependencies favoriteAdvertsDependencies) {
            this.a = favoriteAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoritesListStorage get() {
            return (FavoritesListStorage) Preconditions.checkNotNullFromComponent(this.a.favoritesListStorage());
        }
    }

    public static class n implements Provider<FavoritesSyncDao> {
        public final FavoriteAdvertsDependencies a;

        public n(FavoriteAdvertsDependencies favoriteAdvertsDependencies) {
            this.a = favoriteAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoritesSyncDao get() {
            return (FavoritesSyncDao) Preconditions.checkNotNullFromComponent(this.a.favoritesSyncDao());
        }
    }

    public static class o implements Provider<Features> {
        public final FavoriteAdvertsDependencies a;

        public o(FavoriteAdvertsDependencies favoriteAdvertsDependencies) {
            this.a = favoriteAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class p implements Provider<Locale> {
        public final FavoriteAdvertsDependencies a;

        public p(FavoriteAdvertsDependencies favoriteAdvertsDependencies) {
            this.a = favoriteAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Locale get() {
            return (Locale) Preconditions.checkNotNullFromComponent(this.a.locale());
        }
    }

    public static class q implements Provider<Preferences> {
        public final FavoriteAdvertsDependencies a;

        public q(FavoriteAdvertsDependencies favoriteAdvertsDependencies) {
            this.a = favoriteAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Preferences get() {
            return (Preferences) Preconditions.checkNotNullFromComponent(this.a.preferences());
        }
    }

    public static class r implements Provider<SchedulersFactory> {
        public final FavoriteAdvertsDependencies a;

        public r(FavoriteAdvertsDependencies favoriteAdvertsDependencies) {
            this.a = favoriteAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class s implements Provider<ScreenTrackerFactory> {
        public final FavoriteAdvertsDependencies a;

        public s(FavoriteAdvertsDependencies favoriteAdvertsDependencies) {
            this.a = favoriteAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ScreenTrackerFactory get() {
            return (ScreenTrackerFactory) Preconditions.checkNotNullFromComponent(this.a.screenTrackerFactory());
        }
    }

    public static class t implements Provider<TimeSource> {
        public final FavoriteAdvertsDependencies a;

        public t(FavoriteAdvertsDependencies favoriteAdvertsDependencies) {
            this.a = favoriteAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimeSource get() {
            return (TimeSource) Preconditions.checkNotNullFromComponent(this.a.timeSource());
        }
    }

    public static class u implements Provider<TimerFactory> {
        public final FavoriteAdvertsDependencies a;

        public u(FavoriteAdvertsDependencies favoriteAdvertsDependencies) {
            this.a = favoriteAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimerFactory get() {
            return (TimerFactory) Preconditions.checkNotNullFromComponent(this.a.timerFactory());
        }
    }

    public static class v implements Provider<TypedErrorThrowableConverter> {
        public final FavoriteAdvertsDependencies a;

        public v(FavoriteAdvertsDependencies favoriteAdvertsDependencies) {
            this.a = favoriteAdvertsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
        }
    }

    public DaggerFavoriteAdvertsComponent(FavoriteAdvertsDependencies favoriteAdvertsDependencies, Resources resources, Context context, PublishRelay publishRelay, Kundle kundle, a aVar) {
        this.a = favoriteAdvertsDependencies;
        this.b = new h(favoriteAdvertsDependencies);
        this.c = new d(favoriteAdvertsDependencies);
        this.d = new k(favoriteAdvertsDependencies);
        this.e = new i(favoriteAdvertsDependencies);
        this.f = new n(favoriteAdvertsDependencies);
        this.g = new f(favoriteAdvertsDependencies);
        this.h = new v(favoriteAdvertsDependencies);
        q qVar = new q(favoriteAdvertsDependencies);
        this.i = qVar;
        PrefFavoriteStorage_Factory create = PrefFavoriteStorage_Factory.create(qVar);
        this.j = create;
        this.k = DoubleCheck.provider(create);
        this.l = new r(favoriteAdvertsDependencies);
        p pVar = new p(favoriteAdvertsDependencies);
        this.m = pVar;
        AdvertPriceFormatter_Factory create2 = AdvertPriceFormatter_Factory.create(pVar);
        this.n = create2;
        this.o = DoubleCheck.provider(create2);
        Factory create3 = InstanceFactory.create(resources);
        this.p = create3;
        FavoriteAdvertItemConverterResourceProviderImpl_Factory create4 = FavoriteAdvertItemConverterResourceProviderImpl_Factory.create(create3);
        this.q = create4;
        Provider<FavoriteAdvertItemConverterResourceProvider> provider = DoubleCheck.provider(create4);
        this.r = provider;
        o oVar = new o(favoriteAdvertsDependencies);
        this.s = oVar;
        FavoriteAdvertItemConverterImpl_Factory create5 = FavoriteAdvertItemConverterImpl_Factory.create(this.o, provider, oVar);
        this.t = create5;
        Provider<FavoriteAdvertItemConverter> provider2 = DoubleCheck.provider(create5);
        this.u = provider2;
        l lVar = new l(favoriteAdvertsDependencies);
        this.v = lVar;
        FavoriteAdvertsListInteractorImpl_Factory create6 = FavoriteAdvertsListInteractorImpl_Factory.create(this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.k, this.l, provider2, lVar, this.s);
        this.w = create6;
        this.x = DoubleCheck.provider(create6);
        c cVar = new c(favoriteAdvertsDependencies);
        this.y = cVar;
        this.z = DoubleCheck.provider(FavoriteAdvertsModule_ProvideIsBuyerCanAskSellerTtlItem$favorites_releaseFactory.create(this.s, cVar));
        DelegateFactory delegateFactory = new DelegateFactory();
        this.A = delegateFactory;
        j jVar = new j(favoriteAdvertsDependencies);
        this.B = jVar;
        FavoriteAdvertItemPresenterImpl_Factory create7 = FavoriteAdvertItemPresenterImpl_Factory.create(delegateFactory, jVar);
        this.C = create7;
        Provider<FavoriteAdvertItemPresenter> provider3 = DoubleCheck.provider(create7);
        this.D = provider3;
        t tVar = new t(favoriteAdvertsDependencies);
        this.E = tVar;
        this.F = FavoriteAdvertItemBlueprint_Factory.create(provider3, tVar, this.m);
        TestFavoriteAdvertItemPresenterImpl_Factory create8 = TestFavoriteAdvertItemPresenterImpl_Factory.create(this.A);
        this.G = create8;
        Provider<TestFavoriteAdvertItemPresenter> provider4 = DoubleCheck.provider(create8);
        this.H = provider4;
        this.I = TestFavoriteAdvertItemBlueprint_Factory.create(provider4, this.E, this.m);
        Factory create9 = InstanceFactory.create(publishRelay);
        this.J = create9;
        Provider<Consumer<FavoriteItemAction>> provider5 = DoubleCheck.provider(create9);
        this.K = provider5;
        FavoriteLoadingItemPresenterImpl_Factory create10 = FavoriteLoadingItemPresenterImpl_Factory.create(provider5);
        this.L = create10;
        Provider<FavoriteLoadingItemPresenter> provider6 = DoubleCheck.provider(create10);
        this.M = provider6;
        this.N = FavoriteLoadingItemBlueprint_Factory.create(provider6);
        FavoriteErrorItemPresenterImpl_Factory create11 = FavoriteErrorItemPresenterImpl_Factory.create(this.K);
        this.O = create11;
        Provider<FavoriteErrorItemPresenter> provider7 = DoubleCheck.provider(create11);
        this.P = provider7;
        FavoriteErrorItemBlueprint_Factory create12 = FavoriteErrorItemBlueprint_Factory.create(provider7);
        this.Q = create12;
        Provider<ItemBinder> provider8 = DoubleCheck.provider(FavoriteAdvertsModule_ProvideFavoriteItemBinder$favorites_releaseFactory.create(this.z, this.F, this.I, this.N, create12));
        this.R = provider8;
        this.S = DoubleCheck.provider(FavoriteAdvertsModule_ProvideFavoriteAdapterPresenter$favorites_releaseFactory.create(provider8));
        this.T = new g(favoriteAdvertsDependencies);
        FavoriteListResourceProviderImpl_Factory create13 = FavoriteListResourceProviderImpl_Factory.create(this.p);
        this.U = create13;
        this.V = DoubleCheck.provider(create13);
        s sVar = new s(favoriteAdvertsDependencies);
        this.W = sVar;
        u uVar = new u(favoriteAdvertsDependencies);
        this.X = uVar;
        this.Y = DoubleCheck.provider(FavoriteTrackerModule_ProvideScreenDiInjectTracker$favorites_releaseFactory.create(sVar, uVar));
        Provider<ScreenFlowTrackerProvider> provider9 = DoubleCheck.provider(FavoriteTrackerModule_ProvidesScreenFlowTrackerProviderFactory.create(this.W, this.X));
        this.a0 = provider9;
        FavoritesTrackerImpl_Factory create14 = FavoritesTrackerImpl_Factory.create(this.Y, this.Z, provider9);
        this.b0 = create14;
        this.c0 = DoubleCheck.provider(create14);
        this.d0 = new e(favoriteAdvertsDependencies);
        this.e0 = DoubleCheck.provider(this.J);
        ErrorFormatterImpl_Factory create15 = ErrorFormatterImpl_Factory.create(this.p);
        this.f0 = create15;
        this.g0 = SingleCheck.provider(create15);
        this.h0 = new m(favoriteAdvertsDependencies);
        this.i0 = InstanceFactory.createNullable(kundle);
        FavoritesListPresenterImpl_Factory create16 = FavoritesListPresenterImpl_Factory.create(this.x, this.l, this.S, this.T, this.V, TreeStateIdGenerator_Factory.create(), this.c0, this.d0, this.c, this.e0, this.g0, this.h0, this.i0, this.s);
        this.j0 = create16;
        DelegateFactory.setDelegate(this.A, DoubleCheck.provider(create16));
    }

    public static FavoriteAdvertsComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.favorites.di.FavoriteAdvertsComponent
    public void inject(FavoritesFragment favoritesFragment) {
        FavoritesFragment_MembersInjector.injectPresenter(favoritesFragment, this.A.get());
        FavoritesFragment_MembersInjector.injectInteractor(favoritesFragment, this.x.get());
        FavoritesFragment_MembersInjector.injectAdapterPresenter(favoritesFragment, this.S.get());
        FavoritesFragment_MembersInjector.injectItemBinder(favoritesFragment, this.R.get());
        FavoritesFragment_MembersInjector.injectAnalytics(favoritesFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        FavoritesFragment_MembersInjector.injectActivityIntentFactory(favoritesFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        FavoritesFragment_MembersInjector.injectFavoriteAdvertsSyncRunner(favoritesFragment, (FavoriteAdvertsSyncRunner) Preconditions.checkNotNullFromComponent(this.a.favoriteAdvertsSyncRunner()));
        FavoritesFragment_MembersInjector.injectDeepLinkIntentFactory(favoritesFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        FavoritesFragment_MembersInjector.injectAbTestsConfigProvider(favoritesFragment, (AbTestsConfigProvider) Preconditions.checkNotNullFromComponent(this.a.abTestsConfigProvider()));
        FavoritesFragment_MembersInjector.injectFeatures(favoritesFragment, (Features) Preconditions.checkNotNullFromComponent(this.a.features()));
        FavoritesFragment_MembersInjector.injectTracker(favoritesFragment, this.c0.get());
    }
}

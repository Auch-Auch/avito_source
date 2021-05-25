package com.avito.android.search.subscriptions.di;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.db.SearchSubscriptionDao;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.SearchParamsConverter;
import com.avito.android.remote.model.SearchParamsConverterImpl_Factory;
import com.avito.android.saved_searches.SavedSearchesPresenter;
import com.avito.android.saved_searches.SavedSearchesPresenterImpl;
import com.avito.android.saved_searches.SavedSearchesPresenterImpl_Factory;
import com.avito.android.search.subscriptions.SearchSubscriptionConsumer;
import com.avito.android.search.subscriptions.SearchSubscriptionFragment;
import com.avito.android.search.subscriptions.SearchSubscriptionFragment_MembersInjector;
import com.avito.android.search.subscriptions.SearchSubscriptionInteractor;
import com.avito.android.search.subscriptions.SearchSubscriptionInteractorImpl;
import com.avito.android.search.subscriptions.SearchSubscriptionInteractorImpl_Factory;
import com.avito.android.search.subscriptions.SearchSubscriptionObservable;
import com.avito.android.search.subscriptions.SearchSubscriptionPresenter;
import com.avito.android.search.subscriptions.SearchSubscriptionPresenterImpl;
import com.avito.android.search.subscriptions.SearchSubscriptionPresenterImpl_Factory;
import com.avito.android.search.subscriptions.SearchSubscriptionServiceInteractor;
import com.avito.android.search.subscriptions.SearchSubscriptionServiceInteractorImpl;
import com.avito.android.search.subscriptions.SearchSubscriptionServiceInteractorImpl_Factory;
import com.avito.android.search.subscriptions.SubscribeSearchInteractor;
import com.avito.android.search.subscriptions.SubscribeSearchInteractorImpl;
import com.avito.android.search.subscriptions.SubscribeSearchInteractorImpl_Factory;
import com.avito.android.search.subscriptions.adapter.SearchSubscriptionBlueprint;
import com.avito.android.search.subscriptions.adapter.SearchSubscriptionBlueprint_Factory;
import com.avito.android.search.subscriptions.adapter.SearchSubscriptionItemPresenter;
import com.avito.android.search.subscriptions.adapter.SearchSubscriptionItemPresenterImpl;
import com.avito.android.search.subscriptions.adapter.SearchSubscriptionItemPresenterImpl_Factory;
import com.avito.android.search.subscriptions.di.SearchSubscriptionComponent;
import com.avito.android.search.subscriptions.sync.SearchSubscriptionSyncRunner;
import com.avito.android.server_time.UtcTimeSource;
import com.avito.android.subscriptions.remote.SubscriptionsApi;
import com.avito.android.tracker.SearchSubscriptionsTracker;
import com.avito.android.tracker.SearchSubscriptionsTrackerImpl;
import com.avito.android.tracker.SearchSubscriptionsTrackerImpl_Factory;
import com.avito.android.util.Formatter;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import dagger.internal.DelegateFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import java.util.Locale;
import javax.inject.Provider;
public final class DaggerSearchSubscriptionComponent implements SearchSubscriptionComponent {
    public Provider<ScreenTrackerFactory> A;
    public Provider<TimerFactory> B;
    public Provider<ScreenDiInjectTracker> C;
    public Provider<ScreenInitTracker> D;
    public Provider<ScreenFlowTrackerProvider> E;
    public Provider<SearchSubscriptionsTrackerImpl> F;
    public Provider<SearchSubscriptionsTracker> G;
    public Provider<SearchParamsConverter> H;
    public Provider<TypedErrorThrowableConverter> I;
    public Provider<SubscribeSearchInteractorImpl> J;
    public Provider<SubscribeSearchInteractor> K;
    public Provider<AccountStateProvider> L;
    public Provider<Kundle> M;
    public Provider<SavedSearchesPresenterImpl> N;
    public Provider<SavedSearchesPresenter> O;
    public Provider<SearchSubscriptionPresenterImpl> P;
    public final SearchSubscriptionDependencies a;
    public Provider<Bundle> b;
    public Provider<Analytics> c;
    public Provider<Resources> d;
    public Provider<Formatter<Throwable>> e;
    public Provider<SubscriptionsApi> f;
    public Provider<SearchSubscriptionDao> g;
    public Provider<SearchSubscriptionConsumer> h;
    public Provider<SchedulersFactory3> i;
    public Provider<SearchSubscriptionInteractorImpl> j;
    public Provider<SearchSubscriptionInteractor> k;
    public Provider<Context> l;
    public Provider<SearchSubscriptionSyncRunner> m;
    public Provider<SearchSubscriptionServiceInteractorImpl> n;
    public Provider<SearchSubscriptionServiceInteractor> o;
    public Provider<SearchSubscriptionObservable> p;
    public Provider<AccountStorageInteractor> q;
    public Provider<SearchSubscriptionPresenter> r = new DelegateFactory();
    public Provider<Locale> s;
    public Provider<UtcTimeSource> t;
    public Provider<Formatter<Long>> u;
    public Provider<SearchSubscriptionItemPresenterImpl> v;
    public Provider<SearchSubscriptionItemPresenter> w;
    public Provider<SearchSubscriptionBlueprint> x;
    public Provider<ItemBinder> y;
    public Provider<AdapterPresenter> z;

    public static final class b implements SearchSubscriptionComponent.Builder {
        public SearchSubscriptionDependencies a;
        public Context b;
        public Resources c;
        public Bundle d;
        public Kundle e;

        public b(a aVar) {
        }

        @Override // com.avito.android.search.subscriptions.di.SearchSubscriptionComponent.Builder
        public SearchSubscriptionComponent build() {
            Preconditions.checkBuilderRequirement(this.a, SearchSubscriptionDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, Context.class);
            Preconditions.checkBuilderRequirement(this.c, Resources.class);
            Preconditions.checkBuilderRequirement(this.e, Kundle.class);
            return new DaggerSearchSubscriptionComponent(this.a, this.b, this.c, this.d, this.e, null);
        }

        @Override // com.avito.android.search.subscriptions.di.SearchSubscriptionComponent.Builder
        public SearchSubscriptionComponent.Builder dependentOn(SearchSubscriptionDependencies searchSubscriptionDependencies) {
            this.a = (SearchSubscriptionDependencies) Preconditions.checkNotNull(searchSubscriptionDependencies);
            return this;
        }

        @Override // com.avito.android.search.subscriptions.di.SearchSubscriptionComponent.Builder
        public SearchSubscriptionComponent.Builder withContext(Context context) {
            this.b = (Context) Preconditions.checkNotNull(context);
            return this;
        }

        @Override // com.avito.android.search.subscriptions.di.SearchSubscriptionComponent.Builder
        public SearchSubscriptionComponent.Builder withPresenterState(Bundle bundle) {
            this.d = bundle;
            return this;
        }

        @Override // com.avito.android.search.subscriptions.di.SearchSubscriptionComponent.Builder
        public SearchSubscriptionComponent.Builder withResources(Resources resources) {
            this.c = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.search.subscriptions.di.SearchSubscriptionComponent.Builder
        public SearchSubscriptionComponent.Builder withSavedSearchState(Kundle kundle) {
            this.e = (Kundle) Preconditions.checkNotNull(kundle);
            return this;
        }
    }

    public static class c implements Provider<AccountStateProvider> {
        public final SearchSubscriptionDependencies a;

        public c(SearchSubscriptionDependencies searchSubscriptionDependencies) {
            this.a = searchSubscriptionDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AccountStateProvider get() {
            return (AccountStateProvider) Preconditions.checkNotNullFromComponent(this.a.accountStateProvider());
        }
    }

    public static class d implements Provider<AccountStorageInteractor> {
        public final SearchSubscriptionDependencies a;

        public d(SearchSubscriptionDependencies searchSubscriptionDependencies) {
            this.a = searchSubscriptionDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AccountStorageInteractor get() {
            return (AccountStorageInteractor) Preconditions.checkNotNullFromComponent(this.a.accountStorageInteractor());
        }
    }

    public static class e implements Provider<Analytics> {
        public final SearchSubscriptionDependencies a;

        public e(SearchSubscriptionDependencies searchSubscriptionDependencies) {
            this.a = searchSubscriptionDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class f implements Provider<Locale> {
        public final SearchSubscriptionDependencies a;

        public f(SearchSubscriptionDependencies searchSubscriptionDependencies) {
            this.a = searchSubscriptionDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Locale get() {
            return (Locale) Preconditions.checkNotNullFromComponent(this.a.locale());
        }
    }

    public static class g implements Provider<SchedulersFactory3> {
        public final SearchSubscriptionDependencies a;

        public g(SearchSubscriptionDependencies searchSubscriptionDependencies) {
            this.a = searchSubscriptionDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class h implements Provider<ScreenTrackerFactory> {
        public final SearchSubscriptionDependencies a;

        public h(SearchSubscriptionDependencies searchSubscriptionDependencies) {
            this.a = searchSubscriptionDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ScreenTrackerFactory get() {
            return (ScreenTrackerFactory) Preconditions.checkNotNullFromComponent(this.a.screenTrackerFactory());
        }
    }

    public static class i implements Provider<SearchSubscriptionConsumer> {
        public final SearchSubscriptionDependencies a;

        public i(SearchSubscriptionDependencies searchSubscriptionDependencies) {
            this.a = searchSubscriptionDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SearchSubscriptionConsumer get() {
            return (SearchSubscriptionConsumer) Preconditions.checkNotNullFromComponent(this.a.searchSubscriptionConsumer());
        }
    }

    public static class j implements Provider<SearchSubscriptionDao> {
        public final SearchSubscriptionDependencies a;

        public j(SearchSubscriptionDependencies searchSubscriptionDependencies) {
            this.a = searchSubscriptionDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SearchSubscriptionDao get() {
            return (SearchSubscriptionDao) Preconditions.checkNotNullFromComponent(this.a.searchSubscriptionDao());
        }
    }

    public static class k implements Provider<SearchSubscriptionObservable> {
        public final SearchSubscriptionDependencies a;

        public k(SearchSubscriptionDependencies searchSubscriptionDependencies) {
            this.a = searchSubscriptionDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SearchSubscriptionObservable get() {
            return (SearchSubscriptionObservable) Preconditions.checkNotNullFromComponent(this.a.searchSubscriptionObservable());
        }
    }

    public static class l implements Provider<SearchSubscriptionSyncRunner> {
        public final SearchSubscriptionDependencies a;

        public l(SearchSubscriptionDependencies searchSubscriptionDependencies) {
            this.a = searchSubscriptionDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SearchSubscriptionSyncRunner get() {
            return (SearchSubscriptionSyncRunner) Preconditions.checkNotNullFromComponent(this.a.searchSubscriptionSyncRunner());
        }
    }

    public static class m implements Provider<SubscriptionsApi> {
        public final SearchSubscriptionDependencies a;

        public m(SearchSubscriptionDependencies searchSubscriptionDependencies) {
            this.a = searchSubscriptionDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SubscriptionsApi get() {
            return (SubscriptionsApi) Preconditions.checkNotNullFromComponent(this.a.subscriptionsApi());
        }
    }

    public static class n implements Provider<TimerFactory> {
        public final SearchSubscriptionDependencies a;

        public n(SearchSubscriptionDependencies searchSubscriptionDependencies) {
            this.a = searchSubscriptionDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimerFactory get() {
            return (TimerFactory) Preconditions.checkNotNullFromComponent(this.a.timerFactory());
        }
    }

    public static class o implements Provider<TypedErrorThrowableConverter> {
        public final SearchSubscriptionDependencies a;

        public o(SearchSubscriptionDependencies searchSubscriptionDependencies) {
            this.a = searchSubscriptionDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.typedErrorThrowableConverter());
        }
    }

    public static class p implements Provider<UtcTimeSource> {
        public final SearchSubscriptionDependencies a;

        public p(SearchSubscriptionDependencies searchSubscriptionDependencies) {
            this.a = searchSubscriptionDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public UtcTimeSource get() {
            return (UtcTimeSource) Preconditions.checkNotNullFromComponent(this.a.utcTimeSource());
        }
    }

    public DaggerSearchSubscriptionComponent(SearchSubscriptionDependencies searchSubscriptionDependencies, Context context, Resources resources, Bundle bundle, Kundle kundle, a aVar) {
        this.a = searchSubscriptionDependencies;
        this.b = InstanceFactory.createNullable(bundle);
        this.c = new e(searchSubscriptionDependencies);
        Factory create = InstanceFactory.create(resources);
        this.d = create;
        this.e = DoubleCheck.provider(SearchSubscriptionModule_ProvideErrorFormatter$subscriptions_releaseFactory.create(create));
        m mVar = new m(searchSubscriptionDependencies);
        this.f = mVar;
        j jVar = new j(searchSubscriptionDependencies);
        this.g = jVar;
        i iVar = new i(searchSubscriptionDependencies);
        this.h = iVar;
        g gVar = new g(searchSubscriptionDependencies);
        this.i = gVar;
        SearchSubscriptionInteractorImpl_Factory create2 = SearchSubscriptionInteractorImpl_Factory.create(mVar, jVar, iVar, gVar);
        this.j = create2;
        this.k = DoubleCheck.provider(create2);
        Factory create3 = InstanceFactory.create(context);
        this.l = create3;
        l lVar = new l(searchSubscriptionDependencies);
        this.m = lVar;
        SearchSubscriptionServiceInteractorImpl_Factory create4 = SearchSubscriptionServiceInteractorImpl_Factory.create(create3, lVar);
        this.n = create4;
        this.o = DoubleCheck.provider(create4);
        this.p = new k(searchSubscriptionDependencies);
        this.q = new d(searchSubscriptionDependencies);
        f fVar = new f(searchSubscriptionDependencies);
        this.s = fVar;
        p pVar = new p(searchSubscriptionDependencies);
        this.t = pVar;
        Provider<Formatter<Long>> provider = DoubleCheck.provider(SearchSubscriptionModule_ProvideDateFormat$subscriptions_releaseFactory.create(fVar, pVar));
        this.u = provider;
        SearchSubscriptionItemPresenterImpl_Factory create5 = SearchSubscriptionItemPresenterImpl_Factory.create(this.r, provider);
        this.v = create5;
        Provider<SearchSubscriptionItemPresenter> provider2 = DoubleCheck.provider(create5);
        this.w = provider2;
        SearchSubscriptionBlueprint_Factory create6 = SearchSubscriptionBlueprint_Factory.create(provider2);
        this.x = create6;
        Provider<ItemBinder> provider3 = DoubleCheck.provider(SearchSubscriptionModule_ProvideItemBinder$subscriptions_releaseFactory.create(create6));
        this.y = provider3;
        this.z = DoubleCheck.provider(SearchSubscriptionModule_ProvidesAdapterPresenter$subscriptions_releaseFactory.create(provider3));
        h hVar = new h(searchSubscriptionDependencies);
        this.A = hVar;
        n nVar = new n(searchSubscriptionDependencies);
        this.B = nVar;
        this.C = DoubleCheck.provider(SearchSubscriptionsTrackerModule_ProvideScreenDiInjectTracker$subscriptions_releaseFactory.create(hVar, nVar));
        this.D = DoubleCheck.provider(SearchSubscriptionsTrackerModule_ProvideScreenInitTrackerFactory.create(this.A, this.B));
        Provider<ScreenFlowTrackerProvider> provider4 = DoubleCheck.provider(SearchSubscriptionsTrackerModule_ProvidesScreenFlowTrackerProviderFactory.create(this.A, this.B));
        this.E = provider4;
        SearchSubscriptionsTrackerImpl_Factory create7 = SearchSubscriptionsTrackerImpl_Factory.create(this.C, this.D, provider4);
        this.F = create7;
        this.G = DoubleCheck.provider(create7);
        Provider<SearchParamsConverter> provider5 = DoubleCheck.provider(SearchParamsConverterImpl_Factory.create());
        this.H = provider5;
        o oVar = new o(searchSubscriptionDependencies);
        this.I = oVar;
        SubscribeSearchInteractorImpl_Factory create8 = SubscribeSearchInteractorImpl_Factory.create(this.f, this.g, provider5, oVar, this.i);
        this.J = create8;
        this.K = DoubleCheck.provider(create8);
        this.L = new c(searchSubscriptionDependencies);
        Factory create9 = InstanceFactory.create(kundle);
        this.M = create9;
        SavedSearchesPresenterImpl_Factory create10 = SavedSearchesPresenterImpl_Factory.create(this.K, this.i, this.L, this.c, create9);
        this.N = create10;
        Provider<SavedSearchesPresenter> provider6 = DoubleCheck.provider(create10);
        this.O = provider6;
        SearchSubscriptionPresenterImpl_Factory create11 = SearchSubscriptionPresenterImpl_Factory.create(this.b, this.c, this.e, this.k, this.o, this.p, this.q, this.i, this.z, this.G, provider6);
        this.P = create11;
        DelegateFactory.setDelegate(this.r, DoubleCheck.provider(create11));
    }

    public static SearchSubscriptionComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.search.subscriptions.di.SearchSubscriptionComponent
    public void inject(SearchSubscriptionFragment searchSubscriptionFragment) {
        SearchSubscriptionFragment_MembersInjector.injectActivityIntentFactory(searchSubscriptionFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        SearchSubscriptionFragment_MembersInjector.injectPresenter(searchSubscriptionFragment, this.r.get());
        SearchSubscriptionFragment_MembersInjector.injectAdapterPresenter(searchSubscriptionFragment, this.z.get());
        SearchSubscriptionFragment_MembersInjector.injectItemBinder(searchSubscriptionFragment, this.y.get());
        SearchSubscriptionFragment_MembersInjector.injectFeatures(searchSubscriptionFragment, (Features) Preconditions.checkNotNullFromComponent(this.a.features()));
        SearchSubscriptionFragment_MembersInjector.injectAnalytics(searchSubscriptionFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        SearchSubscriptionFragment_MembersInjector.injectTracker(searchSubscriptionFragment, this.G.get());
        SearchSubscriptionFragment_MembersInjector.injectImplicitIntentFactory(searchSubscriptionFragment, (ImplicitIntentFactory) Preconditions.checkNotNullFromComponent(this.a.implicitIntentFactory()));
        SearchSubscriptionFragment_MembersInjector.injectNotificationManagerProvider(searchSubscriptionFragment, (NotificationManagerProvider) Preconditions.checkNotNullFromComponent(this.a.notificationManagerProvider()));
        SearchSubscriptionFragment_MembersInjector.injectDeepLinkIntentFactory(searchSubscriptionFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deeplinkIntentFactory()));
        SearchSubscriptionFragment_MembersInjector.injectSavedSearchPresenter(searchSubscriptionFragment, this.O.get());
    }
}

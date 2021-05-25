package com.avito.android.authorization.login_suggests.di;

import android.content.res.Resources;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.account.LoginSuggestStorage;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.TimerFactory_Factory;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.authorization.login_suggests.LoginSuggestsActivity;
import com.avito.android.authorization.login_suggests.LoginSuggestsActivity_MembersInjector;
import com.avito.android.authorization.login_suggests.LoginSuggestsInteractor;
import com.avito.android.authorization.login_suggests.LoginSuggestsInteractorImpl;
import com.avito.android.authorization.login_suggests.LoginSuggestsInteractorImpl_Factory;
import com.avito.android.authorization.login_suggests.LoginSuggestsPresenter;
import com.avito.android.authorization.login_suggests.LoginSuggestsPresenterImpl;
import com.avito.android.authorization.login_suggests.LoginSuggestsPresenterImpl_Factory;
import com.avito.android.authorization.login_suggests.LoginSuggestsResourceProvider;
import com.avito.android.authorization.login_suggests.LoginSuggestsResourceProviderImpl;
import com.avito.android.authorization.login_suggests.LoginSuggestsResourceProviderImpl_Factory;
import com.avito.android.authorization.login_suggests.adapter.LoginSuggestsItem;
import com.avito.android.authorization.login_suggests.adapter.common_login.CommonLoginItemPresenter;
import com.avito.android.authorization.login_suggests.adapter.common_login.di.CommonLoginItemModule;
import com.avito.android.authorization.login_suggests.adapter.common_login.di.CommonLoginItemModule_ProvideBlueprint$authorization_releaseFactory;
import com.avito.android.authorization.login_suggests.adapter.common_login.di.CommonLoginItemModule_ProvidePresenter$authorization_releaseFactory;
import com.avito.android.authorization.login_suggests.adapter.error_snippet.ErrorSnippetItemPresenter;
import com.avito.android.authorization.login_suggests.adapter.error_snippet.di.ErrorSnippetItemModule;
import com.avito.android.authorization.login_suggests.adapter.error_snippet.di.ErrorSnippetItemModule_ProvideBlueprint$authorization_releaseFactory;
import com.avito.android.authorization.login_suggests.adapter.error_snippet.di.ErrorSnippetItemModule_ProvidePresenter$authorization_releaseFactory;
import com.avito.android.authorization.login_suggests.adapter.progress.ProgressItemPresenter;
import com.avito.android.authorization.login_suggests.adapter.progress.di.ProgressItemModule;
import com.avito.android.authorization.login_suggests.adapter.progress.di.ProgressItemModule_ProvideBlueprint$authorization_releaseFactory;
import com.avito.android.authorization.login_suggests.adapter.progress.di.ProgressItemModule_ProvidePresenter$authorization_releaseFactory;
import com.avito.android.authorization.login_suggests.adapter.suggest.SuggestItemPresenter;
import com.avito.android.authorization.login_suggests.adapter.suggest.di.SuggestItemModule;
import com.avito.android.authorization.login_suggests.adapter.suggest.di.SuggestItemModule_ProvideBlueprint$authorization_releaseFactory;
import com.avito.android.authorization.login_suggests.adapter.suggest.di.SuggestItemModule_ProvidePresenter$authorization_releaseFactory;
import com.avito.android.authorization.login_suggests.di.LoginSuggestsComponent;
import com.avito.android.authorization.login_suggests.tracker.LoginSuggestTrackersModule_ProvideScreenFactory;
import com.avito.android.authorization.login_suggests.tracker.suggests.SuggestsTrackerModule_ProvideContentTrackerFactory;
import com.avito.android.authorization.login_suggests.tracker.suggests.SuggestsTrackerModule_ProvideContentTrackerToSetFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBinder$konveyor_releaseFactory;
import com.avito.android.konveyor_adapter_module.AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory;
import com.avito.android.performance.ContentTracker;
import com.avito.android.performance.DiInjectTracker;
import com.avito.android.performance.DiInjectTrackerImpl;
import com.avito.android.performance.DiInjectTrackerImpl_Factory;
import com.avito.android.performance.InitTracker;
import com.avito.android.performance.InitTracker_Factory;
import com.avito.android.performance.ScreenTracker;
import com.avito.android.performance.ScreenTrackerImpl;
import com.avito.android.performance.ScreenTrackerImpl_Factory;
import com.avito.android.performance.SimpleTracker;
import com.avito.android.performance.di.PerformanceTrackersModule_ProvideContentTrackersFactory;
import com.avito.android.performance.di.PerformanceTrackersModule_ProvidesScreenDiInjectTracker$tns_core_releaseFactory;
import com.avito.android.performance.di.PerformanceTrackersModule_ProvidesScreenFlowTrackerProviderFactory;
import com.avito.android.performance.di.PerformanceTrackersModule_ProvidesScreenInitTrackerFactory;
import com.avito.android.remote.ProfileApi;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.jakewharton.rxrelay2.PublishRelay;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SetFactory;
import dagger.internal.SingleCheck;
import java.util.Set;
import javax.inject.Provider;
public final class DaggerLoginSuggestsComponent implements LoginSuggestsComponent {
    public Provider<DiInjectTracker> A;
    public Provider<ScreenInitTracker> B;
    public Provider<InitTracker> C;
    public Provider<SimpleTracker> D;
    public Provider<Set<ContentTracker>> E;
    public Provider<ScreenFlowTrackerProvider> F;
    public Provider<ContentTracker> G;
    public Provider<ContentTracker> H;
    public Provider<Set<ContentTracker>> I;
    public Provider<ScreenTrackerImpl> J;
    public Provider<ScreenTracker> K;
    public Provider<Kundle> L;
    public Provider<LoginSuggestsPresenterImpl> M;
    public Provider<LoginSuggestsPresenter> N;
    public final LoginSuggestsDependencies a;
    public Provider<Set<ItemBlueprint<?, ?>>> b = SingleCheck.provider(AdapterModule_ProvideItemBlueprints$konveyor_releaseFactory.create());
    public Provider<PublishRelay<LoginSuggestsItem>> c = DoubleCheck.provider(LoginSuggestsModule_ProvideClicksStream$authorization_releaseFactory.create());
    public Provider<Resources> d;
    public Provider<LoginSuggestsResourceProviderImpl> e;
    public Provider<LoginSuggestsResourceProvider> f;
    public Provider<SuggestItemPresenter> g;
    public Provider<ItemBlueprint<?, ?>> h;
    public Provider<ErrorSnippetItemPresenter> i;
    public Provider<ItemBlueprint<?, ?>> j;
    public Provider<CommonLoginItemPresenter> k;
    public Provider<ItemBlueprint<?, ?>> l;
    public Provider<ProgressItemPresenter> m;
    public Provider<ItemBlueprint<?, ?>> n;
    public Provider<Set<ItemBlueprint<?, ?>>> o;
    public Provider<ItemBinder> p;
    public Provider<AdapterPresenter> q;
    public Provider<ProfileApi> r;
    public Provider<SchedulersFactory> s;
    public Provider<LoginSuggestStorage> t;
    public Provider<LoginSuggestsInteractorImpl> u;
    public Provider<LoginSuggestsInteractor> v;
    public Provider<Analytics> w;
    public Provider<ScreenTrackerFactory> x;
    public Provider<ScreenDiInjectTracker> y;
    public Provider<DiInjectTrackerImpl> z;

    public static final class b implements LoginSuggestsComponent.Builder {
        public LoginSuggestsDependencies a;
        public Resources b;
        public Kundle c;

        public b(a aVar) {
        }

        @Override // com.avito.android.authorization.login_suggests.di.LoginSuggestsComponent.Builder
        public LoginSuggestsComponent build() {
            Preconditions.checkBuilderRequirement(this.a, LoginSuggestsDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, Resources.class);
            return new DaggerLoginSuggestsComponent(new SuggestItemModule(), new ErrorSnippetItemModule(), new CommonLoginItemModule(), new ProgressItemModule(), this.a, this.b, this.c, null);
        }

        @Override // com.avito.android.authorization.login_suggests.di.LoginSuggestsComponent.Builder
        public LoginSuggestsComponent.Builder dependentOn(LoginSuggestsDependencies loginSuggestsDependencies) {
            this.a = (LoginSuggestsDependencies) Preconditions.checkNotNull(loginSuggestsDependencies);
            return this;
        }

        @Override // com.avito.android.authorization.login_suggests.di.LoginSuggestsComponent.Builder
        public LoginSuggestsComponent.Builder withPresenterState(Kundle kundle) {
            this.c = kundle;
            return this;
        }

        @Override // com.avito.android.authorization.login_suggests.di.LoginSuggestsComponent.Builder
        public LoginSuggestsComponent.Builder withResources(Resources resources) {
            this.b = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }
    }

    public static class c implements Provider<Analytics> {
        public final LoginSuggestsDependencies a;

        public c(LoginSuggestsDependencies loginSuggestsDependencies) {
            this.a = loginSuggestsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class d implements Provider<LoginSuggestStorage> {
        public final LoginSuggestsDependencies a;

        public d(LoginSuggestsDependencies loginSuggestsDependencies) {
            this.a = loginSuggestsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public LoginSuggestStorage get() {
            return (LoginSuggestStorage) Preconditions.checkNotNullFromComponent(this.a.loginSuggestStorage());
        }
    }

    public static class e implements Provider<ProfileApi> {
        public final LoginSuggestsDependencies a;

        public e(LoginSuggestsDependencies loginSuggestsDependencies) {
            this.a = loginSuggestsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ProfileApi get() {
            return (ProfileApi) Preconditions.checkNotNullFromComponent(this.a.profileApi());
        }
    }

    public static class f implements Provider<SchedulersFactory> {
        public final LoginSuggestsDependencies a;

        public f(LoginSuggestsDependencies loginSuggestsDependencies) {
            this.a = loginSuggestsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class g implements Provider<ScreenTrackerFactory> {
        public final LoginSuggestsDependencies a;

        public g(LoginSuggestsDependencies loginSuggestsDependencies) {
            this.a = loginSuggestsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ScreenTrackerFactory get() {
            return (ScreenTrackerFactory) Preconditions.checkNotNullFromComponent(this.a.screenTrackerFactory());
        }
    }

    public DaggerLoginSuggestsComponent(SuggestItemModule suggestItemModule, ErrorSnippetItemModule errorSnippetItemModule, CommonLoginItemModule commonLoginItemModule, ProgressItemModule progressItemModule, LoginSuggestsDependencies loginSuggestsDependencies, Resources resources, Kundle kundle, a aVar) {
        this.a = loginSuggestsDependencies;
        Factory create = InstanceFactory.create(resources);
        this.d = create;
        LoginSuggestsResourceProviderImpl_Factory create2 = LoginSuggestsResourceProviderImpl_Factory.create(create);
        this.e = create2;
        Provider<LoginSuggestsResourceProvider> provider = DoubleCheck.provider(create2);
        this.f = provider;
        Provider<SuggestItemPresenter> provider2 = DoubleCheck.provider(SuggestItemModule_ProvidePresenter$authorization_releaseFactory.create(suggestItemModule, this.c, provider));
        this.g = provider2;
        this.h = DoubleCheck.provider(SuggestItemModule_ProvideBlueprint$authorization_releaseFactory.create(suggestItemModule, provider2));
        Provider<ErrorSnippetItemPresenter> provider3 = DoubleCheck.provider(ErrorSnippetItemModule_ProvidePresenter$authorization_releaseFactory.create(errorSnippetItemModule, this.c));
        this.i = provider3;
        this.j = DoubleCheck.provider(ErrorSnippetItemModule_ProvideBlueprint$authorization_releaseFactory.create(errorSnippetItemModule, provider3));
        Provider<CommonLoginItemPresenter> provider4 = DoubleCheck.provider(CommonLoginItemModule_ProvidePresenter$authorization_releaseFactory.create(commonLoginItemModule, this.c));
        this.k = provider4;
        this.l = DoubleCheck.provider(CommonLoginItemModule_ProvideBlueprint$authorization_releaseFactory.create(commonLoginItemModule, provider4));
        Provider<ProgressItemPresenter> provider5 = DoubleCheck.provider(ProgressItemModule_ProvidePresenter$authorization_releaseFactory.create(progressItemModule));
        this.m = provider5;
        this.n = DoubleCheck.provider(ProgressItemModule_ProvideBlueprint$authorization_releaseFactory.create(progressItemModule, provider5));
        SetFactory build = SetFactory.builder(4, 1).addCollectionProvider(this.b).addProvider(this.h).addProvider(this.j).addProvider(this.l).addProvider(this.n).build();
        this.o = build;
        Provider<ItemBinder> provider6 = SingleCheck.provider(AdapterModule_ProvideItemBinder$konveyor_releaseFactory.create(build));
        this.p = provider6;
        this.q = SingleCheck.provider(AdapterModule_ProvideAdapterPresenter$konveyor_releaseFactory.create(provider6));
        e eVar = new e(loginSuggestsDependencies);
        this.r = eVar;
        f fVar = new f(loginSuggestsDependencies);
        this.s = fVar;
        d dVar = new d(loginSuggestsDependencies);
        this.t = dVar;
        LoginSuggestsInteractorImpl_Factory create3 = LoginSuggestsInteractorImpl_Factory.create(eVar, fVar, dVar);
        this.u = create3;
        this.v = DoubleCheck.provider(create3);
        this.w = new c(loginSuggestsDependencies);
        g gVar = new g(loginSuggestsDependencies);
        this.x = gVar;
        Provider<ScreenDiInjectTracker> provider7 = SingleCheck.provider(PerformanceTrackersModule_ProvidesScreenDiInjectTracker$tns_core_releaseFactory.create(gVar, TimerFactory_Factory.create(), LoginSuggestTrackersModule_ProvideScreenFactory.create()));
        this.y = provider7;
        DiInjectTrackerImpl_Factory create4 = DiInjectTrackerImpl_Factory.create(provider7);
        this.z = create4;
        this.A = SingleCheck.provider(create4);
        Provider<ScreenInitTracker> provider8 = SingleCheck.provider(PerformanceTrackersModule_ProvidesScreenInitTrackerFactory.create(this.x, TimerFactory_Factory.create(), LoginSuggestTrackersModule_ProvideScreenFactory.create()));
        this.B = provider8;
        InitTracker_Factory create5 = InitTracker_Factory.create(provider8);
        this.C = create5;
        this.D = SingleCheck.provider(create5);
        this.E = SingleCheck.provider(PerformanceTrackersModule_ProvideContentTrackersFactory.create());
        Provider<ScreenFlowTrackerProvider> provider9 = SingleCheck.provider(PerformanceTrackersModule_ProvidesScreenFlowTrackerProviderFactory.create(this.x, TimerFactory_Factory.create(), LoginSuggestTrackersModule_ProvideScreenFactory.create()));
        this.F = provider9;
        Provider<ContentTracker> provider10 = SingleCheck.provider(SuggestsTrackerModule_ProvideContentTrackerFactory.create(provider9));
        this.G = provider10;
        this.H = SingleCheck.provider(SuggestsTrackerModule_ProvideContentTrackerToSetFactory.create(provider10));
        SetFactory build2 = SetFactory.builder(1, 1).addCollectionProvider(this.E).addProvider(this.H).build();
        this.I = build2;
        ScreenTrackerImpl_Factory create6 = ScreenTrackerImpl_Factory.create(this.A, this.D, build2);
        this.J = create6;
        this.K = SingleCheck.provider(create6);
        Factory createNullable = InstanceFactory.createNullable(kundle);
        this.L = createNullable;
        LoginSuggestsPresenterImpl_Factory create7 = LoginSuggestsPresenterImpl_Factory.create(this.v, this.q, this.c, this.s, this.w, this.K, this.G, createNullable);
        this.M = create7;
        this.N = DoubleCheck.provider(create7);
    }

    public static LoginSuggestsComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.authorization.login_suggests.di.LoginSuggestsComponent
    public void inject(LoginSuggestsActivity loginSuggestsActivity) {
        LoginSuggestsActivity_MembersInjector.injectIntentFactory(loginSuggestsActivity, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        LoginSuggestsActivity_MembersInjector.injectDeepLinkIntentFactory(loginSuggestsActivity, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        LoginSuggestsActivity_MembersInjector.injectAdapterPresenter(loginSuggestsActivity, this.q.get());
        LoginSuggestsActivity_MembersInjector.injectItemBinder(loginSuggestsActivity, this.p.get());
        LoginSuggestsActivity_MembersInjector.injectPresenter(loginSuggestsActivity, this.N.get());
        LoginSuggestsActivity_MembersInjector.injectScreenTracker(loginSuggestsActivity, this.K.get());
    }
}

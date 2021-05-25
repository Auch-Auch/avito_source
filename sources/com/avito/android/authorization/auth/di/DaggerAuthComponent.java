package com.avito.android.authorization.auth.di;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.account.AccountInteractor;
import com.avito.android.account.LoginSuggestStorage;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.TimerFactory_Factory;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.authorization.auth.AuthFragment;
import com.avito.android.authorization.auth.AuthFragment_MembersInjector;
import com.avito.android.authorization.auth.AuthInteractor;
import com.avito.android.authorization.auth.AuthInteractorImpl;
import com.avito.android.authorization.auth.AuthInteractorImpl_Factory;
import com.avito.android.authorization.auth.AuthPresenter;
import com.avito.android.authorization.auth.AuthPresenterImpl;
import com.avito.android.authorization.auth.AuthPresenterImpl_Factory;
import com.avito.android.authorization.auth.AuthResourceProvider;
import com.avito.android.authorization.auth.AuthResourceProviderImpl;
import com.avito.android.authorization.auth.AuthResourceProviderImpl_Factory;
import com.avito.android.authorization.auth.OldAuthActivity;
import com.avito.android.authorization.auth.OldAuthActivity_MembersInjector;
import com.avito.android.authorization.auth.di.AuthComponent;
import com.avito.android.authorization.auth.tracker.AuthTrackersModule_ProvideScreenFactory;
import com.avito.android.authorization.auth.tracker.check.CheckTrackerModule_ProvideContentTrackerFactory;
import com.avito.android.authorization.auth.tracker.check.CheckTrackerModule_ProvideContentTrackerToSetFactory;
import com.avito.android.authorization.smart_lock.SmartLockLoader;
import com.avito.android.authorization.smart_lock.di.SmartLockLoaderModule_ProvideSmartLockLoaderFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.DialogRouterModule_ProvideDialogRouterFactory;
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
import com.avito.android.social.AppleSignInManager;
import com.avito.android.social.AppleSignInManagerImpl_Factory;
import com.avito.android.social.FacebookSocialManager;
import com.avito.android.social.FacebookSocialManagerImpl_Factory;
import com.avito.android.social.GoogleSocialManager;
import com.avito.android.social.GoogleSocialManagerImpl;
import com.avito.android.social.GoogleSocialManagerImpl_Factory;
import com.avito.android.social.OdnoklassnikiSocialManager;
import com.avito.android.social.OdnoklassnikiSocialManagerImpl;
import com.avito.android.social.OdnoklassnikiSocialManagerImpl_Factory;
import com.avito.android.social.SignInManager;
import com.avito.android.social.SocialTypeToStringMapper;
import com.avito.android.social.VkontakteSocialManager;
import com.avito.android.social.VkontakteSocialManagerImpl;
import com.avito.android.social.VkontakteSocialManagerImpl_Factory;
import com.avito.android.social.button.SignInSocialInfoProvider_Factory;
import com.avito.android.social.button.SocialInfoProvider;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SetFactory;
import dagger.internal.SingleCheck;
import java.util.ArrayList;
import java.util.Set;
import javax.inject.Provider;
public final class DaggerAuthComponent implements AuthComponent {
    public Provider<ScreenTrackerFactory> A;
    public Provider<ScreenDiInjectTracker> B;
    public Provider<DiInjectTrackerImpl> C;
    public Provider<DiInjectTracker> D;
    public Provider<ScreenInitTracker> E;
    public Provider<InitTracker> F;
    public Provider<SimpleTracker> G;
    public Provider<Set<ContentTracker>> H;
    public Provider<ScreenFlowTrackerProvider> I;
    public Provider<ContentTracker> J;
    public Provider<ContentTracker> K;
    public Provider<Set<ContentTracker>> L;
    public Provider<ScreenTrackerImpl> M;
    public Provider<ScreenTracker> N;
    public Provider<SocialTypeToStringMapper> O;
    public Provider<Kundle> P;
    public Provider<String> Q;
    public Provider<AuthPresenterImpl> R;
    public Provider<AuthPresenter> S;
    public final AuthDependencies a;
    public Provider<AccountInteractor> b;
    public Provider<LoginSuggestStorage> c;
    public Provider<Analytics> d;
    public Provider<Activity> e;
    public Provider<DialogRouter> f;
    public Provider<SchedulersFactory3> g;
    public Provider<Features> h;
    public Provider<Kundle> i;
    public Provider<SmartLockLoader> j;
    public Provider<AuthInteractorImpl> k;
    public Provider<AuthInteractor> l;
    public Provider<FacebookSocialManager> m = SingleCheck.provider(FacebookSocialManagerImpl_Factory.create());
    public Provider<Context> n;
    public Provider<OdnoklassnikiSocialManagerImpl> o;
    public Provider<OdnoklassnikiSocialManager> p;
    public Provider<VkontakteSocialManagerImpl> q;
    public Provider<VkontakteSocialManager> r;
    public Provider<GoogleSocialManagerImpl> s;
    public Provider<GoogleSocialManager> t;
    public Provider<AppleSignInManager> u;
    public Provider<ArrayList<SignInManager>> v;
    public Provider<SocialInfoProvider> w;
    public Provider<Resources> x;
    public Provider<AuthResourceProviderImpl> y;
    public Provider<AuthResourceProvider> z;

    public static final class b implements AuthComponent.Builder {
        public AuthDependencies a;
        public Activity b;
        public Resources c;
        public Kundle d;
        public Kundle e;
        public String f;

        public b(a aVar) {
        }

        @Override // com.avito.android.authorization.auth.di.AuthComponent.Builder
        public AuthComponent build() {
            Preconditions.checkBuilderRequirement(this.a, AuthDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, Activity.class);
            Preconditions.checkBuilderRequirement(this.c, Resources.class);
            return new DaggerAuthComponent(this.a, this.b, this.c, this.d, this.e, this.f, null);
        }

        @Override // com.avito.android.authorization.auth.di.AuthComponent.Builder
        public AuthComponent.Builder dependentOn(AuthDependencies authDependencies) {
            this.a = (AuthDependencies) Preconditions.checkNotNull(authDependencies);
            return this;
        }

        @Override // com.avito.android.authorization.auth.di.AuthComponent.Builder
        public AuthComponent.Builder withActivity(Activity activity) {
            this.b = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }

        @Override // com.avito.android.authorization.auth.di.AuthComponent.Builder
        public AuthComponent.Builder withPresenterState(Kundle kundle) {
            this.d = kundle;
            return this;
        }

        @Override // com.avito.android.authorization.auth.di.AuthComponent.Builder
        public AuthComponent.Builder withResources(Resources resources) {
            this.c = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.authorization.auth.di.AuthComponent.Builder
        public AuthComponent.Builder withSmartLockState(Kundle kundle) {
            this.e = kundle;
            return this;
        }

        @Override // com.avito.android.authorization.auth.di.AuthComponent.Builder
        public AuthComponent.Builder withSrc(String str) {
            this.f = str;
            return this;
        }
    }

    public static class c implements Provider<AccountInteractor> {
        public final AuthDependencies a;

        public c(AuthDependencies authDependencies) {
            this.a = authDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AccountInteractor get() {
            return (AccountInteractor) Preconditions.checkNotNullFromComponent(this.a.accountInteractor());
        }
    }

    public static class d implements Provider<Analytics> {
        public final AuthDependencies a;

        public d(AuthDependencies authDependencies) {
            this.a = authDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class e implements Provider<Context> {
        public final AuthDependencies a;

        public e(AuthDependencies authDependencies) {
            this.a = authDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Context get() {
            return (Context) Preconditions.checkNotNullFromComponent(this.a.context());
        }
    }

    public static class f implements Provider<Features> {
        public final AuthDependencies a;

        public f(AuthDependencies authDependencies) {
            this.a = authDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class g implements Provider<LoginSuggestStorage> {
        public final AuthDependencies a;

        public g(AuthDependencies authDependencies) {
            this.a = authDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public LoginSuggestStorage get() {
            return (LoginSuggestStorage) Preconditions.checkNotNullFromComponent(this.a.loginSuggestStorage());
        }
    }

    public static class h implements Provider<SchedulersFactory3> {
        public final AuthDependencies a;

        public h(AuthDependencies authDependencies) {
            this.a = authDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class i implements Provider<ScreenTrackerFactory> {
        public final AuthDependencies a;

        public i(AuthDependencies authDependencies) {
            this.a = authDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ScreenTrackerFactory get() {
            return (ScreenTrackerFactory) Preconditions.checkNotNullFromComponent(this.a.screenTrackerFactory());
        }
    }

    public static class j implements Provider<SocialTypeToStringMapper> {
        public final AuthDependencies a;

        public j(AuthDependencies authDependencies) {
            this.a = authDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SocialTypeToStringMapper get() {
            return (SocialTypeToStringMapper) Preconditions.checkNotNullFromComponent(this.a.socialTypeToStringMapper());
        }
    }

    public DaggerAuthComponent(AuthDependencies authDependencies, Activity activity, Resources resources, Kundle kundle, Kundle kundle2, String str, a aVar) {
        this.a = authDependencies;
        this.b = new c(authDependencies);
        this.c = new g(authDependencies);
        this.d = new d(authDependencies);
        Factory create = InstanceFactory.create(activity);
        this.e = create;
        this.f = SingleCheck.provider(DialogRouterModule_ProvideDialogRouterFactory.create(create));
        this.g = new h(authDependencies);
        this.h = new f(authDependencies);
        Factory createNullable = InstanceFactory.createNullable(kundle2);
        this.i = createNullable;
        Provider<SmartLockLoader> provider = DoubleCheck.provider(SmartLockLoaderModule_ProvideSmartLockLoaderFactory.create(this.d, this.f, this.g, this.h, this.e, createNullable));
        this.j = provider;
        AuthInteractorImpl_Factory create2 = AuthInteractorImpl_Factory.create(this.b, this.c, provider, this.g, this.h, this.d);
        this.k = create2;
        this.l = DoubleCheck.provider(create2);
        e eVar = new e(authDependencies);
        this.n = eVar;
        OdnoklassnikiSocialManagerImpl_Factory create3 = OdnoklassnikiSocialManagerImpl_Factory.create(eVar);
        this.o = create3;
        this.p = SingleCheck.provider(create3);
        VkontakteSocialManagerImpl_Factory create4 = VkontakteSocialManagerImpl_Factory.create(this.n);
        this.q = create4;
        this.r = SingleCheck.provider(create4);
        GoogleSocialManagerImpl_Factory create5 = GoogleSocialManagerImpl_Factory.create(this.n);
        this.s = create5;
        this.t = SingleCheck.provider(create5);
        Provider<AppleSignInManager> provider2 = SingleCheck.provider(AppleSignInManagerImpl_Factory.create());
        this.u = provider2;
        this.v = DoubleCheck.provider(AuthModule_ProvideSocialManagersFactory.create(this.m, this.p, this.r, this.t, provider2, this.h));
        this.w = DoubleCheck.provider(SignInSocialInfoProvider_Factory.create());
        Factory create6 = InstanceFactory.create(resources);
        this.x = create6;
        AuthResourceProviderImpl_Factory create7 = AuthResourceProviderImpl_Factory.create(create6);
        this.y = create7;
        this.z = DoubleCheck.provider(create7);
        i iVar = new i(authDependencies);
        this.A = iVar;
        Provider<ScreenDiInjectTracker> provider3 = SingleCheck.provider(PerformanceTrackersModule_ProvidesScreenDiInjectTracker$tns_core_releaseFactory.create(iVar, TimerFactory_Factory.create(), AuthTrackersModule_ProvideScreenFactory.create()));
        this.B = provider3;
        DiInjectTrackerImpl_Factory create8 = DiInjectTrackerImpl_Factory.create(provider3);
        this.C = create8;
        this.D = SingleCheck.provider(create8);
        Provider<ScreenInitTracker> provider4 = SingleCheck.provider(PerformanceTrackersModule_ProvidesScreenInitTrackerFactory.create(this.A, TimerFactory_Factory.create(), AuthTrackersModule_ProvideScreenFactory.create()));
        this.E = provider4;
        InitTracker_Factory create9 = InitTracker_Factory.create(provider4);
        this.F = create9;
        this.G = SingleCheck.provider(create9);
        this.H = SingleCheck.provider(PerformanceTrackersModule_ProvideContentTrackersFactory.create());
        Provider<ScreenFlowTrackerProvider> provider5 = SingleCheck.provider(PerformanceTrackersModule_ProvidesScreenFlowTrackerProviderFactory.create(this.A, TimerFactory_Factory.create(), AuthTrackersModule_ProvideScreenFactory.create()));
        this.I = provider5;
        Provider<ContentTracker> provider6 = SingleCheck.provider(CheckTrackerModule_ProvideContentTrackerFactory.create(provider5));
        this.J = provider6;
        this.K = SingleCheck.provider(CheckTrackerModule_ProvideContentTrackerToSetFactory.create(provider6));
        SetFactory build = SetFactory.builder(1, 1).addCollectionProvider(this.H).addProvider(this.K).build();
        this.L = build;
        ScreenTrackerImpl_Factory create10 = ScreenTrackerImpl_Factory.create(this.D, this.G, build);
        this.M = create10;
        this.N = SingleCheck.provider(create10);
        this.O = new j(authDependencies);
        this.P = InstanceFactory.createNullable(kundle);
        Factory createNullable2 = InstanceFactory.createNullable(str);
        this.Q = createNullable2;
        AuthPresenterImpl_Factory create11 = AuthPresenterImpl_Factory.create(this.l, this.j, this.v, this.w, this.d, this.g, this.z, this.N, this.J, this.O, this.P, createNullable2);
        this.R = create11;
        this.S = DoubleCheck.provider(create11);
    }

    public static AuthComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.authorization.auth.di.AuthComponent
    public void inject(OldAuthActivity oldAuthActivity) {
        OldAuthActivity_MembersInjector.injectIntentFactory(oldAuthActivity, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        OldAuthActivity_MembersInjector.injectDeepLinkIntentFactory(oldAuthActivity, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        OldAuthActivity_MembersInjector.injectPresenter(oldAuthActivity, this.S.get());
        OldAuthActivity_MembersInjector.injectAnalytics(oldAuthActivity, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        OldAuthActivity_MembersInjector.injectSmartLock(oldAuthActivity, this.j.get());
        OldAuthActivity_MembersInjector.injectSocialTypeToStringMapper(oldAuthActivity, (SocialTypeToStringMapper) Preconditions.checkNotNullFromComponent(this.a.socialTypeToStringMapper()));
        OldAuthActivity_MembersInjector.injectFeatures(oldAuthActivity, (Features) Preconditions.checkNotNullFromComponent(this.a.features()));
        OldAuthActivity_MembersInjector.injectScreenTracker(oldAuthActivity, this.N.get());
    }

    @Override // com.avito.android.authorization.auth.di.AuthComponent
    public void inject(AuthFragment authFragment) {
        AuthFragment_MembersInjector.injectIntentFactory(authFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        AuthFragment_MembersInjector.injectDeepLinkIntentFactory(authFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        AuthFragment_MembersInjector.injectPresenter(authFragment, this.S.get());
        AuthFragment_MembersInjector.injectAnalytics(authFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        AuthFragment_MembersInjector.injectSmartLock(authFragment, this.j.get());
        AuthFragment_MembersInjector.injectSocialTypeToStringMapper(authFragment, (SocialTypeToStringMapper) Preconditions.checkNotNullFromComponent(this.a.socialTypeToStringMapper()));
        AuthFragment_MembersInjector.injectFeatures(authFragment, (Features) Preconditions.checkNotNullFromComponent(this.a.features()));
        AuthFragment_MembersInjector.injectScreenTracker(authFragment, this.N.get());
    }
}

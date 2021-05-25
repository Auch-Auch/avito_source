package com.avito.android.user_adverts.di.host_fragment;

import android.app.Application;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelStoreOwner;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.ab_tests.AbTestsConfigProvider;
import com.avito.android.ab_tests.configs.UserAdvertsTabTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.account.AccountStorageInteractor;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.provider.CurrentUserIdProvider;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.app_rater.AppRaterInteractorImpl;
import com.avito.android.app_rater.AppRaterInteractorImpl_Factory;
import com.avito.android.app_rater.PrefAppRaterSessionStorage;
import com.avito.android.app_rater.PrefAppRaterSessionStorage_Factory;
import com.avito.android.cart_fab.CartFabModule_ProvideCartFabViewModelFactory;
import com.avito.android.cart_fab.CartFabPreferences;
import com.avito.android.cart_fab.CartFabPreferencesImpl;
import com.avito.android.cart_fab.CartFabPreferencesImpl_Factory;
import com.avito.android.cart_fab.CartFabQuantityVisibilityHandler_Factory;
import com.avito.android.cart_fab.CartFabRepository;
import com.avito.android.cart_fab.CartFabRepositoryImpl;
import com.avito.android.cart_fab.CartFabRepositoryImpl_Factory;
import com.avito.android.cart_fab.CartFabViewModel;
import com.avito.android.cart_fab.CartFabViewModelFactory;
import com.avito.android.cart_fab.CartFabViewModelFactory_Factory;
import com.avito.android.cart_fab.CartQuantityChangesHandler;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.module.AbTestGroupModule;
import com.avito.android.di.module.AbTestGroupModule_UserAdvertsTabManuallyExposedTestGroupFactory;
import com.avito.android.di.module.AbTestGroupModule_UserAdvertsTabTestGroupFactory;
import com.avito.android.notification_center.counter.NotificationCenterCounterInteractor;
import com.avito.android.remote.UserAdvertsCommonApi;
import com.avito.android.remote.cart.CartApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.server_time.TimeSource;
import com.avito.android.ui.adapter.tab.TabsDataProvider;
import com.avito.android.user_advert.UserAdvertsInfoUpdateRunner;
import com.avito.android.user_adverts.di.UserAdvertsTrackerModule_ProvideScreenDiInjectTracker$user_adverts_releaseFactory;
import com.avito.android.user_adverts.di.UserAdvertsTrackerModule_ProvideScreenInitTrackerFactory;
import com.avito.android.user_adverts.di.UserAdvertsTrackerModule_ProvidesScreenFlowTrackerProviderFactory;
import com.avito.android.user_adverts.di.host_fragment.UserAdvertsHostFragmentComponent;
import com.avito.android.user_adverts.remote.UserAdvertsApi;
import com.avito.android.user_adverts.root_screen.adverts_host.TabItem;
import com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostFragment;
import com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostFragment_MembersInjector;
import com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostPresenter;
import com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostPresenterImpl;
import com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostPresenterImpl_Factory;
import com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostViewModelFactory;
import com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsHostViewModelFactory_Factory;
import com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsInteractor;
import com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsInteractorImpl;
import com.avito.android.user_adverts.root_screen.adverts_host.UserAdvertsInteractorImpl_Factory;
import com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderInteractor;
import com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderInteractorImpl;
import com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderInteractorImpl_Factory;
import com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderResourceProvider;
import com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderResourceProviderImpl;
import com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderResourceProviderImpl_Factory;
import com.avito.android.user_adverts.root_screen.adverts_host.header.ProfileHeaderViewModelFactory;
import com.avito.android.user_adverts.root_screen.adverts_host.header.SoaPriceFormatter;
import com.avito.android.user_adverts.root_screen.adverts_host.header.SoaPriceFormatter_Factory;
import com.avito.android.user_adverts.root_screen.adverts_host.header.soa_statistics_storage.SoaPopupSessionStorage;
import com.avito.android.user_adverts.root_screen.adverts_host.soa_info_bottom_sheet.SoaInfoInteractor;
import com.avito.android.user_adverts.root_screen.adverts_host.soa_info_bottom_sheet.SoaInfoInteractorImpl;
import com.avito.android.user_adverts.root_screen.adverts_host.soa_info_bottom_sheet.SoaInfoInteractorImpl_Factory;
import com.avito.android.user_adverts.tracker.UserAdvertsTracker;
import com.avito.android.user_adverts.tracker.UserAdvertsTrackerImpl;
import com.avito.android.user_adverts.tracker.UserAdvertsTrackerImpl_Factory;
import com.avito.android.user_adverts_common.charity.CharityInteractorImpl;
import com.avito.android.user_adverts_common.safety.SafetyInfoProviderImpl;
import com.avito.android.user_adverts_common.safety.SafetyInfoProviderImpl_Factory;
import com.avito.android.user_adverts_common.safety.storage.PrefSafetyInfoSessionStorage;
import com.avito.android.user_adverts_common.safety.storage.PrefSafetyInfoSessionStorage_Factory;
import com.avito.android.user_stats.di.UserStatsStorageModule_ProvideEditorPreferencesFactory;
import com.avito.android.user_stats.storage.SmbStatsTooltipSessionStorage;
import com.avito.android.user_stats.storage.SmbStatsTooltipSessionStorageImpl;
import com.avito.android.user_stats.storage.SmbStatsTooltipSessionStorageImpl_Factory;
import com.avito.android.util.Formatter;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.SearchContextWrapper;
import com.avito.android.util.preferences.PreferenceFactory;
import com.avito.android.util.preferences.Preferences;
import com.avito.android.util.text.AttributedTextFormatter;
import com.google.common.base.Optional;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import java.util.Locale;
import javax.inject.Provider;
public final class DaggerUserAdvertsHostFragmentComponent implements UserAdvertsHostFragmentComponent {
    public static final Provider i0 = InstanceFactory.create(Optional.absent());
    public Provider<UserAdvertsHostPresenterImpl> A;
    public Provider<UserAdvertsHostPresenter> B;
    public Provider<Locale> C;
    public Provider<SoaPriceFormatter> D;
    public Provider<Formatter<String>> E;
    public Provider<SoaPopupSessionStorage> F;
    public Provider<Resources> G;
    public Provider<ProfileHeaderResourceProviderImpl> H;
    public Provider<ProfileHeaderResourceProvider> I;
    public Provider<Application> J;
    public Provider<PreferenceFactory> K;
    public Provider<Preferences> L;
    public Provider<SmbStatsTooltipSessionStorageImpl> M;
    public Provider<SmbStatsTooltipSessionStorage> N;
    public Provider<ProfileHeaderInteractorImpl> O;
    public Provider<ProfileHeaderInteractor> P;
    public Provider<AbTestsConfigProvider> Q;
    public Provider<SingleManuallyExposedAbTestGroup<UserAdvertsTabTestGroup>> R;
    public Provider<UserAdvertsTabTestGroup> S;
    public Provider<TypedErrorThrowableConverter> T;
    public Provider<SoaInfoInteractorImpl> U;
    public Provider<SoaInfoInteractor> V;
    public Provider<AttributedTextFormatter> W;
    public Provider<UserAdvertsHostViewModelFactory> X;
    public Provider<ViewModelStoreOwner> Y;
    public Provider<CartApi> Z;
    public final UserAdvertsHostFragmentDependencies a;
    public Provider<CartFabRepositoryImpl> a0;
    public Provider<UserAdvertsApi> b;
    public Provider<CartFabRepository> b0;
    public Provider<SchedulersFactory> c;
    public Provider<CartFabPreferencesImpl> c0;
    public Provider<UserAdvertsInteractorImpl> d;
    public Provider<CartFabPreferences> d0;
    public Provider<UserAdvertsInteractor> e;
    public Provider<Optional<SearchContextWrapper>> e0;
    public Provider<TabsDataProvider<TabItem>> f = DoubleCheck.provider(UserAdvertsHostFragmentModule_ProvideTabsDataProviderFactory.create());
    public Provider<CartFabViewModelFactory> f0;
    public Provider<Features> g;
    public Provider<CartFabViewModel> g0;
    public Provider<Analytics> h;
    public Provider<CartQuantityChangesHandler> h0;
    public Provider<Preferences> i;
    public Provider<PrefAppRaterSessionStorage> j;
    public Provider<AppRaterInteractorImpl> k;
    public Provider<TimeSource> l;
    public Provider<ScreenTrackerFactory> m;
    public Provider<TimerFactory> n;
    public Provider<ScreenDiInjectTracker> o;
    public Provider<ScreenInitTracker> p;
    public Provider<ScreenFlowTrackerProvider> q;
    public Provider<UserAdvertsTrackerImpl> r;
    public Provider<UserAdvertsTracker> s;
    public Provider<Bundle> t;
    public Provider<String> u;
    public Provider<AccountStateProvider> v;
    public Provider<UserAdvertsCommonApi> w;
    public Provider<SchedulersFactory3> x;
    public Provider<PrefSafetyInfoSessionStorage> y;
    public Provider<SafetyInfoProviderImpl> z;

    public static final class b implements UserAdvertsHostFragmentComponent.Builder {
        public Bundle a;
        public String b;
        public FragmentManager c;
        public Resources d;
        public AttributedTextFormatter e;
        public ViewModelStoreOwner f;
        public UserAdvertsHostFragmentDependencies g;

        public b(a aVar) {
        }

        @Override // com.avito.android.user_adverts.di.host_fragment.UserAdvertsHostFragmentComponent.Builder
        public UserAdvertsHostFragmentComponent build() {
            Preconditions.checkBuilderRequirement(this.c, FragmentManager.class);
            Preconditions.checkBuilderRequirement(this.d, Resources.class);
            Preconditions.checkBuilderRequirement(this.e, AttributedTextFormatter.class);
            Preconditions.checkBuilderRequirement(this.f, ViewModelStoreOwner.class);
            Preconditions.checkBuilderRequirement(this.g, UserAdvertsHostFragmentDependencies.class);
            return new DaggerUserAdvertsHostFragmentComponent(new AbTestGroupModule(), this.g, this.a, this.b, this.c, this.d, this.e, this.f, null);
        }

        @Override // com.avito.android.user_adverts.di.host_fragment.UserAdvertsHostFragmentComponent.Builder
        public UserAdvertsHostFragmentComponent.Builder defaultShortcut(String str) {
            this.b = null;
            return this;
        }

        @Override // com.avito.android.user_adverts.di.host_fragment.UserAdvertsHostFragmentComponent.Builder
        public UserAdvertsHostFragmentComponent.Builder fragmentManager(FragmentManager fragmentManager) {
            this.c = (FragmentManager) Preconditions.checkNotNull(fragmentManager);
            return this;
        }

        @Override // com.avito.android.user_adverts.di.host_fragment.UserAdvertsHostFragmentComponent.Builder
        public UserAdvertsHostFragmentComponent.Builder resources(Resources resources) {
            this.d = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.user_adverts.di.host_fragment.UserAdvertsHostFragmentComponent.Builder
        public UserAdvertsHostFragmentComponent.Builder state(Bundle bundle) {
            this.a = bundle;
            return this;
        }

        @Override // com.avito.android.user_adverts.di.host_fragment.UserAdvertsHostFragmentComponent.Builder
        public UserAdvertsHostFragmentComponent.Builder userAdvertsHostFragmentDependencies(UserAdvertsHostFragmentDependencies userAdvertsHostFragmentDependencies) {
            this.g = (UserAdvertsHostFragmentDependencies) Preconditions.checkNotNull(userAdvertsHostFragmentDependencies);
            return this;
        }

        @Override // com.avito.android.user_adverts.di.host_fragment.UserAdvertsHostFragmentComponent.Builder
        public UserAdvertsHostFragmentComponent.Builder withFormatter(AttributedTextFormatter attributedTextFormatter) {
            this.e = (AttributedTextFormatter) Preconditions.checkNotNull(attributedTextFormatter);
            return this;
        }

        @Override // com.avito.android.user_adverts.di.host_fragment.UserAdvertsHostFragmentComponent.Builder
        public UserAdvertsHostFragmentComponent.Builder withViewModelStoreOwner(ViewModelStoreOwner viewModelStoreOwner) {
            this.f = (ViewModelStoreOwner) Preconditions.checkNotNull(viewModelStoreOwner);
            return this;
        }
    }

    public static class c implements Provider<AbTestsConfigProvider> {
        public final UserAdvertsHostFragmentDependencies a;

        public c(UserAdvertsHostFragmentDependencies userAdvertsHostFragmentDependencies) {
            this.a = userAdvertsHostFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AbTestsConfigProvider get() {
            return (AbTestsConfigProvider) Preconditions.checkNotNullFromComponent(this.a.abTestsConfigProvider());
        }
    }

    public static class d implements Provider<AccountStateProvider> {
        public final UserAdvertsHostFragmentDependencies a;

        public d(UserAdvertsHostFragmentDependencies userAdvertsHostFragmentDependencies) {
            this.a = userAdvertsHostFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AccountStateProvider get() {
            return (AccountStateProvider) Preconditions.checkNotNullFromComponent(this.a.accountStateProvider());
        }
    }

    public static class e implements Provider<Analytics> {
        public final UserAdvertsHostFragmentDependencies a;

        public e(UserAdvertsHostFragmentDependencies userAdvertsHostFragmentDependencies) {
            this.a = userAdvertsHostFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class f implements Provider<Application> {
        public final UserAdvertsHostFragmentDependencies a;

        public f(UserAdvertsHostFragmentDependencies userAdvertsHostFragmentDependencies) {
            this.a = userAdvertsHostFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Application get() {
            return (Application) Preconditions.checkNotNullFromComponent(this.a.application());
        }
    }

    public static class g implements Provider<CartApi> {
        public final UserAdvertsHostFragmentDependencies a;

        public g(UserAdvertsHostFragmentDependencies userAdvertsHostFragmentDependencies) {
            this.a = userAdvertsHostFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public CartApi get() {
            return (CartApi) Preconditions.checkNotNullFromComponent(this.a.cartApi());
        }
    }

    public static class h implements Provider<Features> {
        public final UserAdvertsHostFragmentDependencies a;

        public h(UserAdvertsHostFragmentDependencies userAdvertsHostFragmentDependencies) {
            this.a = userAdvertsHostFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class i implements Provider<Locale> {
        public final UserAdvertsHostFragmentDependencies a;

        public i(UserAdvertsHostFragmentDependencies userAdvertsHostFragmentDependencies) {
            this.a = userAdvertsHostFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Locale get() {
            return (Locale) Preconditions.checkNotNullFromComponent(this.a.locale());
        }
    }

    public static class j implements Provider<PreferenceFactory> {
        public final UserAdvertsHostFragmentDependencies a;

        public j(UserAdvertsHostFragmentDependencies userAdvertsHostFragmentDependencies) {
            this.a = userAdvertsHostFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PreferenceFactory get() {
            return (PreferenceFactory) Preconditions.checkNotNullFromComponent(this.a.preferenceFactory());
        }
    }

    public static class k implements Provider<Preferences> {
        public final UserAdvertsHostFragmentDependencies a;

        public k(UserAdvertsHostFragmentDependencies userAdvertsHostFragmentDependencies) {
            this.a = userAdvertsHostFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Preferences get() {
            return (Preferences) Preconditions.checkNotNullFromComponent(this.a.preferences());
        }
    }

    public static class l implements Provider<SchedulersFactory3> {
        public final UserAdvertsHostFragmentDependencies a;

        public l(UserAdvertsHostFragmentDependencies userAdvertsHostFragmentDependencies) {
            this.a = userAdvertsHostFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class m implements Provider<SchedulersFactory> {
        public final UserAdvertsHostFragmentDependencies a;

        public m(UserAdvertsHostFragmentDependencies userAdvertsHostFragmentDependencies) {
            this.a = userAdvertsHostFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory get() {
            return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
        }
    }

    public static class n implements Provider<ScreenTrackerFactory> {
        public final UserAdvertsHostFragmentDependencies a;

        public n(UserAdvertsHostFragmentDependencies userAdvertsHostFragmentDependencies) {
            this.a = userAdvertsHostFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ScreenTrackerFactory get() {
            return (ScreenTrackerFactory) Preconditions.checkNotNullFromComponent(this.a.screenTrackerFactory());
        }
    }

    public static class o implements Provider<SoaPopupSessionStorage> {
        public final UserAdvertsHostFragmentDependencies a;

        public o(UserAdvertsHostFragmentDependencies userAdvertsHostFragmentDependencies) {
            this.a = userAdvertsHostFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SoaPopupSessionStorage get() {
            return (SoaPopupSessionStorage) Preconditions.checkNotNullFromComponent(this.a.soaPopupSessionStorage());
        }
    }

    public static class p implements Provider<TypedErrorThrowableConverter> {
        public final UserAdvertsHostFragmentDependencies a;

        public p(UserAdvertsHostFragmentDependencies userAdvertsHostFragmentDependencies) {
            this.a = userAdvertsHostFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TypedErrorThrowableConverter get() {
            return (TypedErrorThrowableConverter) Preconditions.checkNotNullFromComponent(this.a.throwableConverter());
        }
    }

    public static class q implements Provider<TimeSource> {
        public final UserAdvertsHostFragmentDependencies a;

        public q(UserAdvertsHostFragmentDependencies userAdvertsHostFragmentDependencies) {
            this.a = userAdvertsHostFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimeSource get() {
            return (TimeSource) Preconditions.checkNotNullFromComponent(this.a.timeSource());
        }
    }

    public static class r implements Provider<TimerFactory> {
        public final UserAdvertsHostFragmentDependencies a;

        public r(UserAdvertsHostFragmentDependencies userAdvertsHostFragmentDependencies) {
            this.a = userAdvertsHostFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimerFactory get() {
            return (TimerFactory) Preconditions.checkNotNullFromComponent(this.a.timerFactory());
        }
    }

    public static class s implements Provider<UserAdvertsApi> {
        public final UserAdvertsHostFragmentDependencies a;

        public s(UserAdvertsHostFragmentDependencies userAdvertsHostFragmentDependencies) {
            this.a = userAdvertsHostFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public UserAdvertsApi get() {
            return (UserAdvertsApi) Preconditions.checkNotNullFromComponent(this.a.userAdvertsApi());
        }
    }

    public static class t implements Provider<UserAdvertsCommonApi> {
        public final UserAdvertsHostFragmentDependencies a;

        public t(UserAdvertsHostFragmentDependencies userAdvertsHostFragmentDependencies) {
            this.a = userAdvertsHostFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public UserAdvertsCommonApi get() {
            return (UserAdvertsCommonApi) Preconditions.checkNotNullFromComponent(this.a.userAdvertsCommonApi());
        }
    }

    public DaggerUserAdvertsHostFragmentComponent(AbTestGroupModule abTestGroupModule, UserAdvertsHostFragmentDependencies userAdvertsHostFragmentDependencies, Bundle bundle, String str, FragmentManager fragmentManager, Resources resources, AttributedTextFormatter attributedTextFormatter, ViewModelStoreOwner viewModelStoreOwner, a aVar) {
        this.a = userAdvertsHostFragmentDependencies;
        s sVar = new s(userAdvertsHostFragmentDependencies);
        this.b = sVar;
        m mVar = new m(userAdvertsHostFragmentDependencies);
        this.c = mVar;
        UserAdvertsInteractorImpl_Factory create = UserAdvertsInteractorImpl_Factory.create(sVar, mVar);
        this.d = create;
        this.e = DoubleCheck.provider(create);
        this.g = new h(userAdvertsHostFragmentDependencies);
        this.h = new e(userAdvertsHostFragmentDependencies);
        k kVar = new k(userAdvertsHostFragmentDependencies);
        this.i = kVar;
        PrefAppRaterSessionStorage_Factory create2 = PrefAppRaterSessionStorage_Factory.create(kVar);
        this.j = create2;
        this.k = AppRaterInteractorImpl_Factory.create(create2);
        this.l = new q(userAdvertsHostFragmentDependencies);
        n nVar = new n(userAdvertsHostFragmentDependencies);
        this.m = nVar;
        r rVar = new r(userAdvertsHostFragmentDependencies);
        this.n = rVar;
        this.o = DoubleCheck.provider(UserAdvertsTrackerModule_ProvideScreenDiInjectTracker$user_adverts_releaseFactory.create(nVar, rVar));
        this.p = DoubleCheck.provider(UserAdvertsTrackerModule_ProvideScreenInitTrackerFactory.create(this.m, this.n));
        Provider<ScreenFlowTrackerProvider> provider = DoubleCheck.provider(UserAdvertsTrackerModule_ProvidesScreenFlowTrackerProviderFactory.create(this.m, this.n));
        this.q = provider;
        UserAdvertsTrackerImpl_Factory create3 = UserAdvertsTrackerImpl_Factory.create(this.o, this.p, provider);
        this.r = create3;
        this.s = DoubleCheck.provider(create3);
        this.t = InstanceFactory.createNullable(bundle);
        this.u = InstanceFactory.createNullable(str);
        this.v = new d(userAdvertsHostFragmentDependencies);
        this.w = new t(userAdvertsHostFragmentDependencies);
        this.x = new l(userAdvertsHostFragmentDependencies);
        PrefSafetyInfoSessionStorage_Factory create4 = PrefSafetyInfoSessionStorage_Factory.create(this.i);
        this.y = create4;
        SafetyInfoProviderImpl_Factory create5 = SafetyInfoProviderImpl_Factory.create(this.w, this.x, create4, this.l);
        this.z = create5;
        UserAdvertsHostPresenterImpl_Factory create6 = UserAdvertsHostPresenterImpl_Factory.create(this.e, this.c, this.f, this.g, this.h, this.k, this.l, this.s, this.t, this.u, this.v, create5);
        this.A = create6;
        this.B = DoubleCheck.provider(create6);
        i iVar = new i(userAdvertsHostFragmentDependencies);
        this.C = iVar;
        SoaPriceFormatter_Factory create7 = SoaPriceFormatter_Factory.create(iVar);
        this.D = create7;
        this.E = DoubleCheck.provider(create7);
        this.F = new o(userAdvertsHostFragmentDependencies);
        Factory create8 = InstanceFactory.create(resources);
        this.G = create8;
        ProfileHeaderResourceProviderImpl_Factory create9 = ProfileHeaderResourceProviderImpl_Factory.create(create8);
        this.H = create9;
        this.I = DoubleCheck.provider(create9);
        f fVar = new f(userAdvertsHostFragmentDependencies);
        this.J = fVar;
        j jVar = new j(userAdvertsHostFragmentDependencies);
        this.K = jVar;
        UserStatsStorageModule_ProvideEditorPreferencesFactory create10 = UserStatsStorageModule_ProvideEditorPreferencesFactory.create(fVar, jVar);
        this.L = create10;
        SmbStatsTooltipSessionStorageImpl_Factory create11 = SmbStatsTooltipSessionStorageImpl_Factory.create(create10);
        this.M = create11;
        Provider<SmbStatsTooltipSessionStorage> provider2 = DoubleCheck.provider(create11);
        this.N = provider2;
        ProfileHeaderInteractorImpl_Factory create12 = ProfileHeaderInteractorImpl_Factory.create(this.b, this.c, this.E, this.F, this.I, provider2, this.l);
        this.O = create12;
        this.P = DoubleCheck.provider(create12);
        c cVar = new c(userAdvertsHostFragmentDependencies);
        this.Q = cVar;
        Provider<SingleManuallyExposedAbTestGroup<UserAdvertsTabTestGroup>> provider3 = SingleCheck.provider(AbTestGroupModule_UserAdvertsTabManuallyExposedTestGroupFactory.create(abTestGroupModule, cVar));
        this.R = provider3;
        this.S = SingleCheck.provider(AbTestGroupModule_UserAdvertsTabTestGroupFactory.create(abTestGroupModule, provider3));
        p pVar = new p(userAdvertsHostFragmentDependencies);
        this.T = pVar;
        SoaInfoInteractorImpl_Factory create13 = SoaInfoInteractorImpl_Factory.create(this.b, this.c, pVar);
        this.U = create13;
        this.V = DoubleCheck.provider(create13);
        Factory create14 = InstanceFactory.create(attributedTextFormatter);
        this.W = create14;
        this.X = DoubleCheck.provider(UserAdvertsHostViewModelFactory_Factory.create(this.V, this.c, create14, this.h, this.v));
        this.Y = InstanceFactory.create(viewModelStoreOwner);
        g gVar = new g(userAdvertsHostFragmentDependencies);
        this.Z = gVar;
        CartFabRepositoryImpl_Factory create15 = CartFabRepositoryImpl_Factory.create(gVar, this.x);
        this.a0 = create15;
        this.b0 = SingleCheck.provider(create15);
        CartFabPreferencesImpl_Factory create16 = CartFabPreferencesImpl_Factory.create(this.i);
        this.c0 = create16;
        Provider<CartFabPreferences> provider4 = SingleCheck.provider(create16);
        this.d0 = provider4;
        Provider<Optional<SearchContextWrapper>> provider5 = i0;
        this.e0 = provider5;
        CartFabViewModelFactory_Factory create17 = CartFabViewModelFactory_Factory.create(this.g, this.b0, provider4, this.v, this.x, this.h, provider5);
        this.f0 = create17;
        this.g0 = SingleCheck.provider(CartFabModule_ProvideCartFabViewModelFactory.create(this.Y, create17));
        this.h0 = SingleCheck.provider(CartFabQuantityVisibilityHandler_Factory.create());
    }

    public static UserAdvertsHostFragmentComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.user_adverts.di.UserAdvertsListComponentDependencies
    public ActivityIntentFactory activityIntentFactory() {
        return (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory());
    }

    @Override // com.avito.android.user_adverts.di.UserAdvertsListComponentDependencies
    public Analytics analytics() {
        return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
    }

    @Override // com.avito.android.user_adverts.di.UserAdvertsListComponentDependencies
    public DeepLinkFactory deepLinkFactory() {
        return (DeepLinkFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkFactory());
    }

    @Override // com.avito.android.user_adverts.di.UserAdvertsListComponentDependencies
    public DeepLinkIntentFactory deepLinkIntentFactory() {
        return (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory());
    }

    @Override // com.avito.android.user_adverts.di.UserAdvertsListComponentDependencies
    public Features features() {
        return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
    }

    @Override // com.avito.android.user_adverts.di.host_fragment.UserAdvertsHostFragmentComponent
    public void inject(UserAdvertsHostFragment userAdvertsHostFragment) {
        UserAdvertsHostFragment_MembersInjector.injectActivityIntentFactory(userAdvertsHostFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        UserAdvertsHostFragment_MembersInjector.injectDeepLinkIntentFactory(userAdvertsHostFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        UserAdvertsHostFragment_MembersInjector.injectPresenter(userAdvertsHostFragment, this.B.get());
        UserAdvertsHostFragment_MembersInjector.injectInteractor(userAdvertsHostFragment, this.e.get());
        UserAdvertsHostFragment_MembersInjector.injectTabsDataProvider(userAdvertsHostFragment, this.f.get());
        UserAdvertsHostFragment_MembersInjector.injectAnalytics(userAdvertsHostFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        UserAdvertsHostFragment_MembersInjector.injectUserAdvertsInfoUpdateRunner(userAdvertsHostFragment, (UserAdvertsInfoUpdateRunner) Preconditions.checkNotNullFromComponent(this.a.userAdvertsInfoUpdateRunner()));
        UserAdvertsHostFragment_MembersInjector.injectTracker(userAdvertsHostFragment, this.s.get());
        UserAdvertsHostFragment_MembersInjector.injectProfileHeaderViewModelFactory(userAdvertsHostFragment, new ProfileHeaderViewModelFactory((AccountStorageInteractor) Preconditions.checkNotNullFromComponent(this.a.accountStorageInteractor()), (NotificationCenterCounterInteractor) Preconditions.checkNotNullFromComponent(this.a.notificationCenterCounterInteractor()), this.P.get(), new CharityInteractorImpl((SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3()), (UserAdvertsCommonApi) Preconditions.checkNotNullFromComponent(this.a.userAdvertsCommonApi()), (CurrentUserIdProvider) Preconditions.checkNotNullFromComponent(this.a.currentUserProvider()), (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics())), (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory()), (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()), (AccountStateProvider) Preconditions.checkNotNullFromComponent(this.a.accountStateProvider()), (Features) Preconditions.checkNotNullFromComponent(this.a.features()), this.I.get(), this.S.get()));
        UserAdvertsHostFragment_MembersInjector.injectViewModelFactory(userAdvertsHostFragment, this.X.get());
        UserAdvertsHostFragment_MembersInjector.injectFeatures(userAdvertsHostFragment, (Features) Preconditions.checkNotNullFromComponent(this.a.features()));
        UserAdvertsHostFragment_MembersInjector.injectTabTestGroup(userAdvertsHostFragment, this.S.get());
        UserAdvertsHostFragment_MembersInjector.injectCartFabViewModel(userAdvertsHostFragment, this.g0.get());
        UserAdvertsHostFragment_MembersInjector.injectCartQuantityHandler(userAdvertsHostFragment, this.h0.get());
    }

    @Override // com.avito.android.user_adverts.di.UserAdvertsListComponentDependencies
    public SchedulersFactory schedulersFactory() {
        return (SchedulersFactory) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory());
    }

    @Override // com.avito.android.user_adverts.di.UserAdvertsListComponentDependencies
    public ScreenTrackerFactory screenTrackerFactory() {
        return (ScreenTrackerFactory) Preconditions.checkNotNullFromComponent(this.a.screenTrackerFactory());
    }

    @Override // com.avito.android.user_adverts.di.UserAdvertsListComponentDependencies
    public TimerFactory timerFactory() {
        return (TimerFactory) Preconditions.checkNotNullFromComponent(this.a.timerFactory());
    }

    @Override // com.avito.android.user_adverts.di.UserAdvertsListComponentDependencies
    public UserAdvertsApi userAdvertsApi() {
        return (UserAdvertsApi) Preconditions.checkNotNullFromComponent(this.a.userAdvertsApi());
    }

    @Override // com.avito.android.user_adverts.di.UserAdvertsListComponentDependencies
    public UserAdvertsInfoUpdateRunner userAdvertsInfoUpdateRunner() {
        return (UserAdvertsInfoUpdateRunner) Preconditions.checkNotNullFromComponent(this.a.userAdvertsInfoUpdateRunner());
    }

    @Override // com.avito.android.user_adverts.di.UserAdvertsListComponentDependencies
    public UserAdvertsHostPresenter userAdvertsPresenter() {
        return this.B.get();
    }
}

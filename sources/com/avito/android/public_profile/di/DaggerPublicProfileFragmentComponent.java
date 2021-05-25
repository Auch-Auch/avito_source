package com.avito.android.public_profile.di;

import android.app.Activity;
import android.app.Application;
import android.content.res.Resources;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.FragmentManager;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.FavoriteSellersRepository;
import com.avito.android.Features;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.analytics.screens.ScreenFlowTrackerProvider;
import com.avito.android.analytics.screens.ScreenTransferRecovery;
import com.avito.android.analytics.screens.ScreenTransferRecovery_Impl_Factory;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenDiInjectTracker;
import com.avito.android.analytics.screens.tracker.ScreenInitTracker;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.design.widget.tab.TabBlueprint;
import com.avito.android.design.widget.tab.TabLayoutAdapter;
import com.avito.android.design.widget.tab.TabPagerAdapter;
import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.error_helper.ErrorHelperImpl;
import com.avito.android.error_helper.ErrorHelperImpl_Factory;
import com.avito.android.lib.design.snackbar.util.CompositeSnackbarModule_ProvideCompositeSnackbarPresenterFactory;
import com.avito.android.lib.design.snackbar.util.CompositeSnackbarPresenter;
import com.avito.android.notification_manager_provider.NotificationManagerModule;
import com.avito.android.notification_manager_provider.NotificationManagerModule_ProvideNotificationManagerProviderFactory;
import com.avito.android.notification_manager_provider.NotificationManagerProvider;
import com.avito.android.public_profile.ProfileAdvertsTabBlueprint;
import com.avito.android.public_profile.ProfileAdvertsTabBlueprint_Factory;
import com.avito.android.public_profile.PublicProfileFragment;
import com.avito.android.public_profile.PublicProfileFragment_MembersInjector;
import com.avito.android.public_profile.di.PublicProfileFragmentComponent;
import com.avito.android.public_profile.remote.PublicProfileApi;
import com.avito.android.public_profile.remote.model.DefaultPublicUserProfile;
import com.avito.android.public_profile.remote.model.ProfileAdvertsResult;
import com.avito.android.public_profile.tracker.PublicProfileTracker;
import com.avito.android.public_profile.tracker.PublicProfileTrackerImpl;
import com.avito.android.public_profile.tracker.PublicProfileTrackerImpl_Factory;
import com.avito.android.public_profile.ui.PublicProfileInteractor;
import com.avito.android.public_profile.ui.PublicProfileInteractorImpl;
import com.avito.android.public_profile.ui.PublicProfileInteractorImpl_Factory;
import com.avito.android.public_profile.ui.PublicProfilePresenter;
import com.avito.android.public_profile.ui.PublicProfilePresenterImpl;
import com.avito.android.public_profile.ui.PublicProfilePresenterImpl_Factory;
import com.avito.android.public_profile.ui.PublicProfileResourceProvider;
import com.avito.android.public_profile.ui.PublicProfileResourceProviderImpl;
import com.avito.android.public_profile.ui.PublicProfileResourceProviderImpl_Factory;
import com.avito.android.public_profile.ui.SubscribeInteractor;
import com.avito.android.public_profile.ui.SubscriptionsPresenter;
import com.avito.android.public_profile.ui.SubscriptionsResourceProvider;
import com.avito.android.remote.FavoriteSellersApi;
import com.avito.android.ui.adapter.tab.BaseTabItem;
import com.avito.android.ui.adapter.tab.TabsDataProvider;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.ErrorFormatterImpl_Factory;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SetFactory;
import dagger.internal.SingleCheck;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Set;
import javax.inject.Provider;
import kotlin.Unit;
public final class DaggerPublicProfileFragmentComponent implements PublicProfileFragmentComponent {
    public Provider<ErrorFormatterImpl> A;
    public Provider<ErrorFormatter> B;
    public Provider<ErrorHelperImpl> C;
    public Provider<ErrorHelper> D;
    public Provider<Analytics> E;
    public Provider<PublicProfileResourceProviderImpl> F;
    public Provider<PublicProfileResourceProvider> G;
    public Provider<Kundle> H;
    public Provider<TreeClickStreamParent> I;
    public Provider<FavoriteSellersRepository> J;
    public Provider<AccountStateProvider> K;
    public Provider<SubscriptionsResourceProvider> L;
    public Provider<SubscribeInteractor> M;
    public Provider<Kundle> N;
    public Provider<CompositeSnackbarPresenter> O;
    public Provider<SubscriptionsPresenter> P;
    public Provider<PublishRelay<ProfileAdvertsResult>> Q;
    public Provider<PublishRelay<Unit>> R;
    public Provider<Consumer<Unit>> S;
    public Provider<PublicProfilePresenterImpl> T;
    public Provider<PublicProfilePresenter> U;
    public Provider<Activity> V;
    public Provider<TabLayoutAdapter<BaseTabItem>> W;
    public Provider<FragmentManager> X;
    public Provider<Screen> Y;
    public Provider<Boolean> Z;
    public final PublicProfileFragmentDependencies a;
    public Provider<ProfileAdvertsTabBlueprint> a0;
    public Provider<String> b;
    public Provider<TabBlueprint<? extends BaseTabItem>> b0;
    public Provider<String> c;
    public Provider<Set<TabBlueprint<? extends BaseTabItem>>> c0;
    public Provider<DefaultPublicUserProfile> d;
    public Provider<TabPagerAdapter> d0;
    public Provider<PublicProfileApi> e;
    public Provider<FavoriteSellersApi> f;
    public Provider<SchedulersFactory3> g;
    public Provider<Application> h;
    public Provider<NotificationManagerCompat> i;
    public Provider<NotificationManagerProvider> j;
    public Provider<ScreenTrackerFactory> k;
    public Provider<Screen> l;
    public Provider<Boolean> m;
    public Provider<TimerFactory> n;
    public Provider<ScreenDiInjectTracker> o;
    public Provider<ScreenInitTracker> p = DoubleCheck.provider(PublicProfileTrackerModule_ProvidesScreenInitTrackerFactory.create(this.k, this.l, this.m, this.n));
    public Provider<ScreenFlowTrackerProvider> q = DoubleCheck.provider(PublicProfileTrackerModule_ProvidesScreenFlowTrackerProviderFactory.create(this.k, this.l, this.n));
    public Provider<ScreenTransferRecovery.Impl> r;
    public Provider<ScreenTransferRecovery> s;
    public Provider<PublicProfileTrackerImpl> t;
    public Provider<PublicProfileTracker> u;
    public Provider<Features> v;
    public Provider<PublicProfileInteractorImpl> w;
    public Provider<PublicProfileInteractor> x;
    public Provider<TabsDataProvider<BaseTabItem>> y;
    public Provider<Resources> z;

    public static final class b implements PublicProfileFragmentComponent.Builder {
        public PublicProfileFragmentDependencies a;
        public Resources b;
        public FragmentManager c;
        public String d;
        public String e;
        public TreeClickStreamParent f;
        public Screen g;
        public Boolean h;
        public Kundle i;
        public Kundle j;
        public DefaultPublicUserProfile k;
        public Activity l;

        public b(a aVar) {
        }

        @Override // com.avito.android.public_profile.di.PublicProfileFragmentComponent.Builder
        public PublicProfileFragmentComponent.Builder bindActivity(Activity activity) {
            this.l = (Activity) Preconditions.checkNotNull(activity);
            return this;
        }

        @Override // com.avito.android.public_profile.di.PublicProfileFragmentComponent.Builder
        public PublicProfileFragmentComponent.Builder bindContextId(String str) {
            this.e = str;
            return this;
        }

        @Override // com.avito.android.public_profile.di.PublicProfileFragmentComponent.Builder
        public PublicProfileFragmentComponent.Builder bindFragmentManager(FragmentManager fragmentManager) {
            this.c = (FragmentManager) Preconditions.checkNotNull(fragmentManager);
            return this;
        }

        @Override // com.avito.android.public_profile.di.PublicProfileFragmentComponent.Builder
        public PublicProfileFragmentComponent.Builder bindPresenterState(Kundle kundle) {
            this.i = kundle;
            return this;
        }

        @Override // com.avito.android.public_profile.di.PublicProfileFragmentComponent.Builder
        public PublicProfileFragmentComponent.Builder bindPublicUserProfile(DefaultPublicUserProfile defaultPublicUserProfile) {
            this.k = defaultPublicUserProfile;
            return this;
        }

        @Override // com.avito.android.public_profile.di.PublicProfileFragmentComponent.Builder
        public PublicProfileFragmentComponent.Builder bindResources(Resources resources) {
            this.b = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.public_profile.di.PublicProfileFragmentComponent.Builder
        public PublicProfileFragmentComponent.Builder bindSubscriptionsState(Kundle kundle) {
            this.j = kundle;
            return this;
        }

        @Override // com.avito.android.public_profile.di.PublicProfileFragmentComponent.Builder
        public PublicProfileFragmentComponent.Builder bindTreeParent(TreeClickStreamParent treeClickStreamParent) {
            this.f = treeClickStreamParent;
            return this;
        }

        @Override // com.avito.android.public_profile.di.PublicProfileFragmentComponent.Builder
        public PublicProfileFragmentComponent.Builder bindUserKey(String str) {
            this.d = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.public_profile.di.PublicProfileFragmentComponent.Builder
        public PublicProfileFragmentComponent build() {
            Preconditions.checkBuilderRequirement(this.a, PublicProfileFragmentDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, Resources.class);
            Preconditions.checkBuilderRequirement(this.c, FragmentManager.class);
            Preconditions.checkBuilderRequirement(this.d, String.class);
            Preconditions.checkBuilderRequirement(this.g, Screen.class);
            Preconditions.checkBuilderRequirement(this.h, Boolean.class);
            Preconditions.checkBuilderRequirement(this.l, Activity.class);
            return new DaggerPublicProfileFragmentComponent(new NotificationManagerModule(), this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, null);
        }

        @Override // com.avito.android.public_profile.di.PublicProfileFragmentComponent.Builder
        public PublicProfileFragmentComponent.Builder publicProfileFragmentDependencies(PublicProfileFragmentDependencies publicProfileFragmentDependencies) {
            this.a = (PublicProfileFragmentDependencies) Preconditions.checkNotNull(publicProfileFragmentDependencies);
            return this;
        }

        @Override // com.avito.android.public_profile.di.PublicProfileFragmentComponent.Builder
        public PublicProfileFragmentComponent.Builder withScreen(Screen screen) {
            this.g = (Screen) Preconditions.checkNotNull(screen);
            return this;
        }

        @Override // com.avito.android.public_profile.di.PublicProfileFragmentComponent.Builder
        public PublicProfileFragmentComponent.Builder withSubComponent(boolean z) {
            this.h = (Boolean) Preconditions.checkNotNull(Boolean.valueOf(z));
            return this;
        }
    }

    public static class c implements Provider<AccountStateProvider> {
        public final PublicProfileFragmentDependencies a;

        public c(PublicProfileFragmentDependencies publicProfileFragmentDependencies) {
            this.a = publicProfileFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public AccountStateProvider get() {
            return (AccountStateProvider) Preconditions.checkNotNullFromComponent(this.a.accountStateProvider());
        }
    }

    public static class d implements Provider<PublishRelay<Unit>> {
        public final PublicProfileFragmentDependencies a;

        public d(PublicProfileFragmentDependencies publicProfileFragmentDependencies) {
            this.a = publicProfileFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PublishRelay<Unit> get() {
            return (PublishRelay) Preconditions.checkNotNullFromComponent(this.a.advertsReload());
        }
    }

    public static class e implements Provider<PublishRelay<ProfileAdvertsResult>> {
        public final PublicProfileFragmentDependencies a;

        public e(PublicProfileFragmentDependencies publicProfileFragmentDependencies) {
            this.a = publicProfileFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PublishRelay<ProfileAdvertsResult> get() {
            return (PublishRelay) Preconditions.checkNotNullFromComponent(this.a.advertsResults());
        }
    }

    public static class f implements Provider<Analytics> {
        public final PublicProfileFragmentDependencies a;

        public f(PublicProfileFragmentDependencies publicProfileFragmentDependencies) {
            this.a = publicProfileFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class g implements Provider<Application> {
        public final PublicProfileFragmentDependencies a;

        public g(PublicProfileFragmentDependencies publicProfileFragmentDependencies) {
            this.a = publicProfileFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Application get() {
            return (Application) Preconditions.checkNotNullFromComponent(this.a.application());
        }
    }

    public static class h implements Provider<FavoriteSellersApi> {
        public final PublicProfileFragmentDependencies a;

        public h(PublicProfileFragmentDependencies publicProfileFragmentDependencies) {
            this.a = publicProfileFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoriteSellersApi get() {
            return (FavoriteSellersApi) Preconditions.checkNotNullFromComponent(this.a.favoriteSellersApi());
        }
    }

    public static class i implements Provider<FavoriteSellersRepository> {
        public final PublicProfileFragmentDependencies a;

        public i(PublicProfileFragmentDependencies publicProfileFragmentDependencies) {
            this.a = publicProfileFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public FavoriteSellersRepository get() {
            return (FavoriteSellersRepository) Preconditions.checkNotNullFromComponent(this.a.favoriteSellersRepository());
        }
    }

    public static class j implements Provider<Features> {
        public final PublicProfileFragmentDependencies a;

        public j(PublicProfileFragmentDependencies publicProfileFragmentDependencies) {
            this.a = publicProfileFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Features get() {
            return (Features) Preconditions.checkNotNullFromComponent(this.a.features());
        }
    }

    public static class k implements Provider<PublicProfileApi> {
        public final PublicProfileFragmentDependencies a;

        public k(PublicProfileFragmentDependencies publicProfileFragmentDependencies) {
            this.a = publicProfileFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public PublicProfileApi get() {
            return (PublicProfileApi) Preconditions.checkNotNullFromComponent(this.a.publicProfileApi());
        }
    }

    public static class l implements Provider<SchedulersFactory3> {
        public final PublicProfileFragmentDependencies a;

        public l(PublicProfileFragmentDependencies publicProfileFragmentDependencies) {
            this.a = publicProfileFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public static class m implements Provider<ScreenTrackerFactory> {
        public final PublicProfileFragmentDependencies a;

        public m(PublicProfileFragmentDependencies publicProfileFragmentDependencies) {
            this.a = publicProfileFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ScreenTrackerFactory get() {
            return (ScreenTrackerFactory) Preconditions.checkNotNullFromComponent(this.a.screenTrackerFactory());
        }
    }

    public static class n implements Provider<TimerFactory> {
        public final PublicProfileFragmentDependencies a;

        public n(PublicProfileFragmentDependencies publicProfileFragmentDependencies) {
            this.a = publicProfileFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimerFactory get() {
            return (TimerFactory) Preconditions.checkNotNullFromComponent(this.a.timerFactory());
        }
    }

    public DaggerPublicProfileFragmentComponent(NotificationManagerModule notificationManagerModule, PublicProfileFragmentDependencies publicProfileFragmentDependencies, Resources resources, FragmentManager fragmentManager, String str, String str2, TreeClickStreamParent treeClickStreamParent, Screen screen, Boolean bool, Kundle kundle, Kundle kundle2, DefaultPublicUserProfile defaultPublicUserProfile, Activity activity, a aVar) {
        this.a = publicProfileFragmentDependencies;
        this.b = InstanceFactory.create(str);
        this.c = InstanceFactory.createNullable(str2);
        this.d = InstanceFactory.createNullable(defaultPublicUserProfile);
        this.e = new k(publicProfileFragmentDependencies);
        this.f = new h(publicProfileFragmentDependencies);
        this.g = new l(publicProfileFragmentDependencies);
        g gVar = new g(publicProfileFragmentDependencies);
        this.h = gVar;
        Provider<NotificationManagerCompat> provider = DoubleCheck.provider(PublicProfileFragmentModule_ProvideNotificationManagerFactory.create(gVar));
        this.i = provider;
        this.j = NotificationManagerModule_ProvideNotificationManagerProviderFactory.create(notificationManagerModule, provider);
        this.k = new m(publicProfileFragmentDependencies);
        this.l = InstanceFactory.create(screen);
        Factory create = InstanceFactory.create(bool);
        this.m = create;
        n nVar = new n(publicProfileFragmentDependencies);
        this.n = nVar;
        this.o = DoubleCheck.provider(PublicProfileTrackerModule_ProvidesScreenDiInjectTracker$public_profile_releaseFactory.create(this.k, this.l, create, nVar));
        ScreenTransferRecovery_Impl_Factory create2 = ScreenTransferRecovery_Impl_Factory.create(this.k, this.n);
        this.r = create2;
        Provider<ScreenTransferRecovery> provider2 = DoubleCheck.provider(create2);
        this.s = provider2;
        PublicProfileTrackerImpl_Factory create3 = PublicProfileTrackerImpl_Factory.create(this.o, this.p, this.q, this.l, provider2);
        this.t = create3;
        Provider<PublicProfileTracker> provider3 = DoubleCheck.provider(create3);
        this.u = provider3;
        j jVar = new j(publicProfileFragmentDependencies);
        this.v = jVar;
        PublicProfileInteractorImpl_Factory create4 = PublicProfileInteractorImpl_Factory.create(this.e, this.f, this.g, this.j, provider3, jVar);
        this.w = create4;
        this.x = DoubleCheck.provider(create4);
        this.y = DoubleCheck.provider(PublicProfileFragmentModule_ProvideTabsDataProviderFactory.create());
        Factory create5 = InstanceFactory.create(resources);
        this.z = create5;
        ErrorFormatterImpl_Factory create6 = ErrorFormatterImpl_Factory.create(create5);
        this.A = create6;
        Provider<ErrorFormatter> provider4 = SingleCheck.provider(create6);
        this.B = provider4;
        ErrorHelperImpl_Factory create7 = ErrorHelperImpl_Factory.create(provider4);
        this.C = create7;
        this.D = SingleCheck.provider(create7);
        this.E = new f(publicProfileFragmentDependencies);
        PublicProfileResourceProviderImpl_Factory create8 = PublicProfileResourceProviderImpl_Factory.create(this.z);
        this.F = create8;
        this.G = DoubleCheck.provider(create8);
        this.H = InstanceFactory.createNullable(kundle);
        this.I = InstanceFactory.createNullable(treeClickStreamParent);
        this.J = new i(publicProfileFragmentDependencies);
        this.K = new c(publicProfileFragmentDependencies);
        this.L = DoubleCheck.provider(this.F);
        this.M = DoubleCheck.provider(this.w);
        this.N = InstanceFactory.createNullable(kundle2);
        Provider<CompositeSnackbarPresenter> provider5 = SingleCheck.provider(CompositeSnackbarModule_ProvideCompositeSnackbarPresenterFactory.create());
        this.O = provider5;
        this.P = DoubleCheck.provider(PublicProfileFragmentModule_ProvideSubscriptionsPresenterFactory.create(this.j, this.J, this.K, this.L, this.M, this.D, this.E, this.g, this.N, provider5, this.v));
        this.Q = new e(publicProfileFragmentDependencies);
        d dVar = new d(publicProfileFragmentDependencies);
        this.R = dVar;
        Provider<Consumer<Unit>> provider6 = DoubleCheck.provider(dVar);
        this.S = provider6;
        PublicProfilePresenterImpl_Factory create9 = PublicProfilePresenterImpl_Factory.create(this.b, this.c, this.d, this.x, this.g, this.y, this.D, this.E, this.G, this.H, this.u, this.I, this.P, this.O, this.v, this.Q, provider6);
        this.T = create9;
        this.U = DoubleCheck.provider(create9);
        Factory create10 = InstanceFactory.create(activity);
        this.V = create10;
        this.W = DoubleCheck.provider(PublicProfileFragmentModule_ProvideTabsLayout$public_profile_releaseFactory.create(this.y, create10));
        this.X = InstanceFactory.create(fragmentManager);
        this.Y = DoubleCheck.provider(PublicProfileTrackerModule_ProvidesScreenFactory.create(this.l));
        Provider<Boolean> provider7 = DoubleCheck.provider(PublicProfileTrackerModule_ProvidesIsSubComponentFactory.create(this.m));
        this.Z = provider7;
        ProfileAdvertsTabBlueprint_Factory create11 = ProfileAdvertsTabBlueprint_Factory.create(this.b, this.Y, provider7, this.c);
        this.a0 = create11;
        this.b0 = DoubleCheck.provider(create11);
        SetFactory build = SetFactory.builder(1, 0).addProvider(this.b0).build();
        this.c0 = build;
        this.d0 = DoubleCheck.provider(PublicProfileFragmentModule_ProvideTabPagerAdapterProviderFactory.create(this.X, this.y, build));
    }

    public static PublicProfileFragmentComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.public_profile.di.PublicProfileFragmentComponent
    public void inject(PublicProfileFragment publicProfileFragment) {
        PublicProfileFragment_MembersInjector.injectDeepLinkIntentFactory(publicProfileFragment, (DeepLinkIntentFactory) Preconditions.checkNotNullFromComponent(this.a.deepLinkIntentFactory()));
        PublicProfileFragment_MembersInjector.injectActivityIntentFactory(publicProfileFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
        PublicProfileFragment_MembersInjector.injectImplicitIntentFactory(publicProfileFragment, (ImplicitIntentFactory) Preconditions.checkNotNullFromComponent(this.a.implicitIntentFactory()));
        PublicProfileFragment_MembersInjector.injectPublicProfilePresenter(publicProfileFragment, this.U.get());
        PublicProfileFragment_MembersInjector.injectSubscriptionsPresenter(publicProfileFragment, this.P.get());
        PublicProfileFragment_MembersInjector.injectSnackbarPresenter(publicProfileFragment, this.O.get());
        PublicProfileFragment_MembersInjector.injectTabsDataProvider(publicProfileFragment, this.y.get());
        PublicProfileFragment_MembersInjector.injectTabLayoutAdapter(publicProfileFragment, this.W.get());
        PublicProfileFragment_MembersInjector.injectPagerAdapter(publicProfileFragment, this.d0.get());
        PublicProfileFragment_MembersInjector.injectAnalytics(publicProfileFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        PublicProfileFragment_MembersInjector.injectTracker(publicProfileFragment, this.u.get());
        PublicProfileFragment_MembersInjector.injectFeatures(publicProfileFragment, (Features) Preconditions.checkNotNullFromComponent(this.a.features()));
    }
}

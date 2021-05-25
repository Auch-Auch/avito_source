package com.avito.android.player.di;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.Screen;
import com.avito.android.analytics.screens.TimerFactory;
import com.avito.android.analytics.screens.tracker.ScreenTrackerFactory;
import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.di.module.ScreenAnalyticsDependencies;
import com.avito.android.player.di.PlayerFragmentComponent;
import com.avito.android.player.presenter.PlayerPresenter;
import com.avito.android.player.presenter.PlayerPresenterImpl;
import com.avito.android.player.presenter.PlayerPresenterImpl_Factory;
import com.avito.android.player.presenter.PlayerResourcesProvider;
import com.avito.android.player.presenter.PlayerResourcesProviderImpl;
import com.avito.android.player.presenter.PlayerResourcesProviderImpl_Factory;
import com.avito.android.player.presenter.analytics.PlayerAnalyticsInteractor;
import com.avito.android.player.presenter.analytics.PlayerAnalyticsInteractorImpl;
import com.avito.android.player.presenter.analytics.PlayerAnalyticsInteractorImpl_Factory;
import com.avito.android.player.presenter.tracker.PlayerTracker;
import com.avito.android.player.presenter.tracker.PlayerTrackerImpl;
import com.avito.android.player.presenter.tracker.PlayerTrackerImpl_Factory;
import com.avito.android.player.view.PlayerFragment;
import com.avito.android.player.view.PlayerFragment_MembersInjector;
import com.avito.android.rec.ScreenSource;
import com.avito.android.remote.CallAdapterFactoryResourceProvider;
import com.avito.android.util.SchedulersFactory3;
import com.google.android.exoplayer2.SimpleExoPlayer;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DaggerPlayerFragmentComponent implements PlayerFragmentComponent {
    public final PlayerFragmentDependencies a;
    public Provider<String> b;
    public Provider<ScreenTrackerFactory> c;
    public Provider<TimerFactory> d;
    public Provider<PlayerTrackerImpl> e;
    public Provider<PlayerTracker> f;
    public Provider<Resources> g;
    public Provider<Application> h;
    public Provider<CallAdapterFactoryResourceProvider> i;
    public Provider<PlayerResourcesProviderImpl> j;
    public Provider<PlayerResourcesProvider> k;
    public Provider<ConnectivityProvider> l;
    public Provider<String> m;
    public Provider<String> n;
    public Provider<ScreenSource> o;
    public Provider<Analytics> p;
    public Provider<PlayerAnalyticsInteractorImpl> q;
    public Provider<PlayerAnalyticsInteractor> r;
    public Provider<Context> s;
    public Provider<SimpleExoPlayer> t;
    public Provider<SchedulersFactory3> u;
    public Provider<PlayerPresenterImpl> v;
    public Provider<PlayerPresenter> w;

    public static final class b implements PlayerFragmentComponent.Builder {
        public PlayerFragmentDependencies a;
        public ScreenAnalyticsDependencies b;
        public Context c;
        public Screen d;
        public String e;
        public ScreenSource f;
        public String g;
        public String h;
        public Resources i;

        public b(a aVar) {
        }

        @Override // com.avito.android.player.di.PlayerFragmentComponent.Builder
        public PlayerFragmentComponent build() {
            Preconditions.checkBuilderRequirement(this.a, PlayerFragmentDependencies.class);
            Preconditions.checkBuilderRequirement(this.b, ScreenAnalyticsDependencies.class);
            Preconditions.checkBuilderRequirement(this.c, Context.class);
            Preconditions.checkBuilderRequirement(this.d, Screen.class);
            Preconditions.checkBuilderRequirement(this.e, String.class);
            Preconditions.checkBuilderRequirement(this.f, ScreenSource.class);
            Preconditions.checkBuilderRequirement(this.i, Resources.class);
            return new DaggerPlayerFragmentComponent(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, null);
        }

        @Override // com.avito.android.player.di.PlayerFragmentComponent.Builder
        public PlayerFragmentComponent.Builder withMediaBlockType(String str) {
            this.h = str;
            return this;
        }

        @Override // com.avito.android.player.di.PlayerFragmentComponent.Builder
        public PlayerFragmentComponent.Builder withMediaSlug(String str) {
            this.g = str;
            return this;
        }

        @Override // com.avito.android.player.di.PlayerFragmentComponent.Builder
        public PlayerFragmentComponent.Builder withMediaUrl(String str) {
            this.e = (String) Preconditions.checkNotNull(str);
            return this;
        }

        @Override // com.avito.android.player.di.PlayerFragmentComponent.Builder
        public PlayerFragmentComponent.Builder withPlayerDependencies(PlayerFragmentDependencies playerFragmentDependencies) {
            this.a = (PlayerFragmentDependencies) Preconditions.checkNotNull(playerFragmentDependencies);
            return this;
        }

        @Override // com.avito.android.player.di.PlayerFragmentComponent.Builder
        public PlayerFragmentComponent.Builder withResources(Resources resources) {
            this.i = (Resources) Preconditions.checkNotNull(resources);
            return this;
        }

        @Override // com.avito.android.player.di.PlayerFragmentComponent.Builder
        public PlayerFragmentComponent.Builder withScreen(Screen screen) {
            this.d = (Screen) Preconditions.checkNotNull(screen);
            return this;
        }

        @Override // com.avito.android.player.di.PlayerFragmentComponent.Builder
        public PlayerFragmentComponent.Builder withScreenAnalyticsDependencies(ScreenAnalyticsDependencies screenAnalyticsDependencies) {
            this.b = (ScreenAnalyticsDependencies) Preconditions.checkNotNull(screenAnalyticsDependencies);
            return this;
        }

        @Override // com.avito.android.player.di.PlayerFragmentComponent.Builder
        public PlayerFragmentComponent.Builder withScreenSource(ScreenSource screenSource) {
            this.f = (ScreenSource) Preconditions.checkNotNull(screenSource);
            return this;
        }

        @Override // com.avito.android.player.di.PlayerFragmentComponent.Builder
        public PlayerFragmentComponent.Builder withViewContext(Context context) {
            this.c = (Context) Preconditions.checkNotNull(context);
            return this;
        }
    }

    public static class c implements Provider<ScreenTrackerFactory> {
        public final ScreenAnalyticsDependencies a;

        public c(ScreenAnalyticsDependencies screenAnalyticsDependencies) {
            this.a = screenAnalyticsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ScreenTrackerFactory get() {
            return (ScreenTrackerFactory) Preconditions.checkNotNullFromComponent(this.a.screenTrackerFactory());
        }
    }

    public static class d implements Provider<TimerFactory> {
        public final ScreenAnalyticsDependencies a;

        public d(ScreenAnalyticsDependencies screenAnalyticsDependencies) {
            this.a = screenAnalyticsDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public TimerFactory get() {
            return (TimerFactory) Preconditions.checkNotNullFromComponent(this.a.timerFactory());
        }
    }

    public static class e implements Provider<Analytics> {
        public final PlayerFragmentDependencies a;

        public e(PlayerFragmentDependencies playerFragmentDependencies) {
            this.a = playerFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Analytics get() {
            return (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics());
        }
    }

    public static class f implements Provider<Application> {
        public final PlayerFragmentDependencies a;

        public f(PlayerFragmentDependencies playerFragmentDependencies) {
            this.a = playerFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public Application get() {
            return (Application) Preconditions.checkNotNullFromComponent(this.a.application());
        }
    }

    public static class g implements Provider<ConnectivityProvider> {
        public final PlayerFragmentDependencies a;

        public g(PlayerFragmentDependencies playerFragmentDependencies) {
            this.a = playerFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public ConnectivityProvider get() {
            return (ConnectivityProvider) Preconditions.checkNotNullFromComponent(this.a.connectivityProvider());
        }
    }

    public static class h implements Provider<SchedulersFactory3> {
        public final PlayerFragmentDependencies a;

        public h(PlayerFragmentDependencies playerFragmentDependencies) {
            this.a = playerFragmentDependencies;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // javax.inject.Provider
        public SchedulersFactory3 get() {
            return (SchedulersFactory3) Preconditions.checkNotNullFromComponent(this.a.schedulersFactory3());
        }
    }

    public DaggerPlayerFragmentComponent(PlayerFragmentDependencies playerFragmentDependencies, ScreenAnalyticsDependencies screenAnalyticsDependencies, Context context, Screen screen, String str, ScreenSource screenSource, String str2, String str3, Resources resources, a aVar) {
        this.a = playerFragmentDependencies;
        this.b = InstanceFactory.create(str);
        c cVar = new c(screenAnalyticsDependencies);
        this.c = cVar;
        d dVar = new d(screenAnalyticsDependencies);
        this.d = dVar;
        PlayerTrackerImpl_Factory create = PlayerTrackerImpl_Factory.create(cVar, dVar);
        this.e = create;
        this.f = DoubleCheck.provider(create);
        this.g = InstanceFactory.create(resources);
        f fVar = new f(playerFragmentDependencies);
        this.h = fVar;
        Provider<CallAdapterFactoryResourceProvider> provider = DoubleCheck.provider(PlayerFragmentModule_ProvideCallAdapterResourceProvider$player_releaseFactory.create(fVar));
        this.i = provider;
        PlayerResourcesProviderImpl_Factory create2 = PlayerResourcesProviderImpl_Factory.create(this.g, provider);
        this.j = create2;
        this.k = DoubleCheck.provider(create2);
        this.l = new g(playerFragmentDependencies);
        this.m = InstanceFactory.createNullable(str2);
        this.n = InstanceFactory.createNullable(str3);
        Factory create3 = InstanceFactory.create(screenSource);
        this.o = create3;
        e eVar = new e(playerFragmentDependencies);
        this.p = eVar;
        PlayerAnalyticsInteractorImpl_Factory create4 = PlayerAnalyticsInteractorImpl_Factory.create(this.b, this.m, this.n, create3, eVar);
        this.q = create4;
        this.r = DoubleCheck.provider(create4);
        Factory create5 = InstanceFactory.create(context);
        this.s = create5;
        Provider<SimpleExoPlayer> provider2 = DoubleCheck.provider(PlayerFragmentModule_ProvideSimpleExoPlayer$player_releaseFactory.create(create5));
        this.t = provider2;
        h hVar = new h(playerFragmentDependencies);
        this.u = hVar;
        PlayerPresenterImpl_Factory create6 = PlayerPresenterImpl_Factory.create(this.b, this.f, this.k, this.l, this.r, provider2, hVar);
        this.v = create6;
        this.w = DoubleCheck.provider(create6);
    }

    public static PlayerFragmentComponent.Builder builder() {
        return new b(null);
    }

    @Override // com.avito.android.player.di.PlayerFragmentComponent
    public void inject(PlayerFragment playerFragment) {
        PlayerFragment_MembersInjector.injectPresenter(playerFragment, this.w.get());
        PlayerFragment_MembersInjector.injectTracker(playerFragment, this.f.get());
        PlayerFragment_MembersInjector.injectAnalytics(playerFragment, (Analytics) Preconditions.checkNotNullFromComponent(this.a.analytics()));
        PlayerFragment_MembersInjector.injectActivityIntentFactory(playerFragment, (ActivityIntentFactory) Preconditions.checkNotNullFromComponent(this.a.activityIntentFactory()));
    }
}

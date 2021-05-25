package com.avito.android.player.presenter;

import com.avito.android.connection_quality.connectivity.ConnectivityProvider;
import com.avito.android.player.presenter.analytics.PlayerAnalyticsInteractor;
import com.avito.android.player.presenter.tracker.PlayerTracker;
import com.avito.android.util.SchedulersFactory3;
import com.google.android.exoplayer2.SimpleExoPlayer;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PlayerPresenterImpl_Factory implements Factory<PlayerPresenterImpl> {
    public final Provider<String> a;
    public final Provider<PlayerTracker> b;
    public final Provider<PlayerResourcesProvider> c;
    public final Provider<ConnectivityProvider> d;
    public final Provider<PlayerAnalyticsInteractor> e;
    public final Provider<SimpleExoPlayer> f;
    public final Provider<SchedulersFactory3> g;

    public PlayerPresenterImpl_Factory(Provider<String> provider, Provider<PlayerTracker> provider2, Provider<PlayerResourcesProvider> provider3, Provider<ConnectivityProvider> provider4, Provider<PlayerAnalyticsInteractor> provider5, Provider<SimpleExoPlayer> provider6, Provider<SchedulersFactory3> provider7) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static PlayerPresenterImpl_Factory create(Provider<String> provider, Provider<PlayerTracker> provider2, Provider<PlayerResourcesProvider> provider3, Provider<ConnectivityProvider> provider4, Provider<PlayerAnalyticsInteractor> provider5, Provider<SimpleExoPlayer> provider6, Provider<SchedulersFactory3> provider7) {
        return new PlayerPresenterImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static PlayerPresenterImpl newInstance(String str, PlayerTracker playerTracker, PlayerResourcesProvider playerResourcesProvider, ConnectivityProvider connectivityProvider, PlayerAnalyticsInteractor playerAnalyticsInteractor, Lazy<SimpleExoPlayer> lazy, SchedulersFactory3 schedulersFactory3) {
        return new PlayerPresenterImpl(str, playerTracker, playerResourcesProvider, connectivityProvider, playerAnalyticsInteractor, lazy, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public PlayerPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), DoubleCheck.lazy(this.f), this.g.get());
    }
}

package com.avito.android.player.view;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.analytics.Analytics;
import com.avito.android.player.presenter.PlayerPresenter;
import com.avito.android.player.presenter.tracker.PlayerTracker;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class PlayerFragment_MembersInjector implements MembersInjector<PlayerFragment> {
    public final Provider<PlayerPresenter> a;
    public final Provider<PlayerTracker> b;
    public final Provider<Analytics> c;
    public final Provider<ActivityIntentFactory> d;

    public PlayerFragment_MembersInjector(Provider<PlayerPresenter> provider, Provider<PlayerTracker> provider2, Provider<Analytics> provider3, Provider<ActivityIntentFactory> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static MembersInjector<PlayerFragment> create(Provider<PlayerPresenter> provider, Provider<PlayerTracker> provider2, Provider<Analytics> provider3, Provider<ActivityIntentFactory> provider4) {
        return new PlayerFragment_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.avito.android.player.view.PlayerFragment.activityIntentFactory")
    public static void injectActivityIntentFactory(PlayerFragment playerFragment, ActivityIntentFactory activityIntentFactory) {
        playerFragment.activityIntentFactory = activityIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.player.view.PlayerFragment.analytics")
    public static void injectAnalytics(PlayerFragment playerFragment, Analytics analytics) {
        playerFragment.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.player.view.PlayerFragment.presenter")
    public static void injectPresenter(PlayerFragment playerFragment, PlayerPresenter playerPresenter) {
        playerFragment.presenter = playerPresenter;
    }

    @InjectedFieldSignature("com.avito.android.player.view.PlayerFragment.tracker")
    public static void injectTracker(PlayerFragment playerFragment, PlayerTracker playerTracker) {
        playerFragment.tracker = playerTracker;
    }

    public void injectMembers(PlayerFragment playerFragment) {
        injectPresenter(playerFragment, this.a.get());
        injectTracker(playerFragment, this.b.get());
        injectAnalytics(playerFragment, this.c.get());
        injectActivityIntentFactory(playerFragment, this.d.get());
    }
}

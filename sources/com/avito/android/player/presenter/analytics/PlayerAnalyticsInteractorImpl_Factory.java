package com.avito.android.player.presenter.analytics;

import com.avito.android.analytics.Analytics;
import com.avito.android.rec.ScreenSource;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class PlayerAnalyticsInteractorImpl_Factory implements Factory<PlayerAnalyticsInteractorImpl> {
    public final Provider<String> a;
    public final Provider<String> b;
    public final Provider<String> c;
    public final Provider<ScreenSource> d;
    public final Provider<Analytics> e;

    public PlayerAnalyticsInteractorImpl_Factory(Provider<String> provider, Provider<String> provider2, Provider<String> provider3, Provider<ScreenSource> provider4, Provider<Analytics> provider5) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static PlayerAnalyticsInteractorImpl_Factory create(Provider<String> provider, Provider<String> provider2, Provider<String> provider3, Provider<ScreenSource> provider4, Provider<Analytics> provider5) {
        return new PlayerAnalyticsInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static PlayerAnalyticsInteractorImpl newInstance(String str, String str2, String str3, ScreenSource screenSource, Analytics analytics) {
        return new PlayerAnalyticsInteractorImpl(str, str2, str3, screenSource, analytics);
    }

    @Override // javax.inject.Provider
    public PlayerAnalyticsInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}

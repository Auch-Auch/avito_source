package com.avito.android.deep_linking;

import com.avito.android.analytics.Analytics;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class AppShortcutsDeepLinkPresenterImpl_Factory implements Factory<AppShortcutsDeepLinkPresenterImpl> {
    public final Provider<Analytics> a;
    public final Provider<DeepLinkFactory> b;
    public final Provider<AppShortcutsDeepLinkRouter> c;

    public AppShortcutsDeepLinkPresenterImpl_Factory(Provider<Analytics> provider, Provider<DeepLinkFactory> provider2, Provider<AppShortcutsDeepLinkRouter> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static AppShortcutsDeepLinkPresenterImpl_Factory create(Provider<Analytics> provider, Provider<DeepLinkFactory> provider2, Provider<AppShortcutsDeepLinkRouter> provider3) {
        return new AppShortcutsDeepLinkPresenterImpl_Factory(provider, provider2, provider3);
    }

    public static AppShortcutsDeepLinkPresenterImpl newInstance(Analytics analytics, DeepLinkFactory deepLinkFactory, AppShortcutsDeepLinkRouter appShortcutsDeepLinkRouter) {
        return new AppShortcutsDeepLinkPresenterImpl(analytics, deepLinkFactory, appShortcutsDeepLinkRouter);
    }

    @Override // javax.inject.Provider
    public AppShortcutsDeepLinkPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}

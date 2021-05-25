package com.avito.android.deep_linking;

import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class AppShortcutsDeepLinkActivity_MembersInjector implements MembersInjector<AppShortcutsDeepLinkActivity> {
    public final Provider<DeepLinkIntentFactory> a;
    public final Provider<AppShortcutsDeepLinkPresenter> b;

    public AppShortcutsDeepLinkActivity_MembersInjector(Provider<DeepLinkIntentFactory> provider, Provider<AppShortcutsDeepLinkPresenter> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static MembersInjector<AppShortcutsDeepLinkActivity> create(Provider<DeepLinkIntentFactory> provider, Provider<AppShortcutsDeepLinkPresenter> provider2) {
        return new AppShortcutsDeepLinkActivity_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("com.avito.android.deep_linking.AppShortcutsDeepLinkActivity.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(AppShortcutsDeepLinkActivity appShortcutsDeepLinkActivity, DeepLinkIntentFactory deepLinkIntentFactory) {
        appShortcutsDeepLinkActivity.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.deep_linking.AppShortcutsDeepLinkActivity.presenter")
    public static void injectPresenter(AppShortcutsDeepLinkActivity appShortcutsDeepLinkActivity, AppShortcutsDeepLinkPresenter appShortcutsDeepLinkPresenter) {
        appShortcutsDeepLinkActivity.presenter = appShortcutsDeepLinkPresenter;
    }

    public void injectMembers(AppShortcutsDeepLinkActivity appShortcutsDeepLinkActivity) {
        injectDeepLinkIntentFactory(appShortcutsDeepLinkActivity, this.a.get());
        injectPresenter(appShortcutsDeepLinkActivity, this.b.get());
    }
}

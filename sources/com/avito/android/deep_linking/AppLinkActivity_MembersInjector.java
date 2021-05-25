package com.avito.android.deep_linking;

import com.avito.android.analytics.Analytics;
import com.avito.android.util.ImplicitIntentFactory;
import dagger.MembersInjector;
import dagger.internal.InjectedFieldSignature;
import javax.inject.Provider;
public final class AppLinkActivity_MembersInjector implements MembersInjector<AppLinkActivity> {
    public final Provider<Analytics> a;
    public final Provider<DeepLinkIntentFactory> b;
    public final Provider<ImplicitIntentFactory> c;
    public final Provider<AppLinkPresenter> d;

    public AppLinkActivity_MembersInjector(Provider<Analytics> provider, Provider<DeepLinkIntentFactory> provider2, Provider<ImplicitIntentFactory> provider3, Provider<AppLinkPresenter> provider4) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static MembersInjector<AppLinkActivity> create(Provider<Analytics> provider, Provider<DeepLinkIntentFactory> provider2, Provider<ImplicitIntentFactory> provider3, Provider<AppLinkPresenter> provider4) {
        return new AppLinkActivity_MembersInjector(provider, provider2, provider3, provider4);
    }

    @InjectedFieldSignature("com.avito.android.deep_linking.AppLinkActivity.analytics")
    public static void injectAnalytics(AppLinkActivity appLinkActivity, Analytics analytics) {
        appLinkActivity.analytics = analytics;
    }

    @InjectedFieldSignature("com.avito.android.deep_linking.AppLinkActivity.deepLinkIntentFactory")
    public static void injectDeepLinkIntentFactory(AppLinkActivity appLinkActivity, DeepLinkIntentFactory deepLinkIntentFactory) {
        appLinkActivity.deepLinkIntentFactory = deepLinkIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.deep_linking.AppLinkActivity.implicitIntentFactory")
    public static void injectImplicitIntentFactory(AppLinkActivity appLinkActivity, ImplicitIntentFactory implicitIntentFactory) {
        appLinkActivity.implicitIntentFactory = implicitIntentFactory;
    }

    @InjectedFieldSignature("com.avito.android.deep_linking.AppLinkActivity.presenter")
    public static void injectPresenter(AppLinkActivity appLinkActivity, AppLinkPresenter appLinkPresenter) {
        appLinkActivity.presenter = appLinkPresenter;
    }

    public void injectMembers(AppLinkActivity appLinkActivity) {
        injectAnalytics(appLinkActivity, this.a.get());
        injectDeepLinkIntentFactory(appLinkActivity, this.b.get());
        injectImplicitIntentFactory(appLinkActivity, this.c.get());
        injectPresenter(appLinkActivity, this.d.get());
    }
}

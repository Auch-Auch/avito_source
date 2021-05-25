package com.avito.android.di.module;

import com.avito.android.app.ActivityProvider;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.remote.interceptors.FirewallErrorRouter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class FirewallErrorModule_ProvideFirewallErrorRouterFactory implements Factory<FirewallErrorRouter> {
    public final Provider<ActivityProvider> a;
    public final Provider<DeepLinkIntentFactory> b;

    public FirewallErrorModule_ProvideFirewallErrorRouterFactory(Provider<ActivityProvider> provider, Provider<DeepLinkIntentFactory> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static FirewallErrorModule_ProvideFirewallErrorRouterFactory create(Provider<ActivityProvider> provider, Provider<DeepLinkIntentFactory> provider2) {
        return new FirewallErrorModule_ProvideFirewallErrorRouterFactory(provider, provider2);
    }

    public static FirewallErrorRouter provideFirewallErrorRouter(ActivityProvider activityProvider, DeepLinkIntentFactory deepLinkIntentFactory) {
        return (FirewallErrorRouter) Preconditions.checkNotNullFromProvides(FirewallErrorModule.provideFirewallErrorRouter(activityProvider, deepLinkIntentFactory));
    }

    @Override // javax.inject.Provider
    public FirewallErrorRouter get() {
        return provideFirewallErrorRouter(this.a.get(), this.b.get());
    }
}

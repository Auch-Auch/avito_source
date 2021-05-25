package com.avito.android.di.module;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.calls_shared.CallUuidProvider;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.UTMLinkConverter;
import com.avito.android.navigation.NavigationTabProvider;
import com.avito.android.util.ImplicitIntentFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DeepLinkModule_ProvideDeepLinkIntentFactoryFactory implements Factory<DeepLinkIntentFactory> {
    public final DeepLinkModule a;
    public final Provider<ActivityIntentFactory> b;
    public final Provider<ImplicitIntentFactory> c;
    public final Provider<Features> d;
    public final Provider<UTMLinkConverter> e;
    public final Provider<NavigationTabProvider> f;
    public final Provider<CallUuidProvider> g;

    public DeepLinkModule_ProvideDeepLinkIntentFactoryFactory(DeepLinkModule deepLinkModule, Provider<ActivityIntentFactory> provider, Provider<ImplicitIntentFactory> provider2, Provider<Features> provider3, Provider<UTMLinkConverter> provider4, Provider<NavigationTabProvider> provider5, Provider<CallUuidProvider> provider6) {
        this.a = deepLinkModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
        this.e = provider4;
        this.f = provider5;
        this.g = provider6;
    }

    public static DeepLinkModule_ProvideDeepLinkIntentFactoryFactory create(DeepLinkModule deepLinkModule, Provider<ActivityIntentFactory> provider, Provider<ImplicitIntentFactory> provider2, Provider<Features> provider3, Provider<UTMLinkConverter> provider4, Provider<NavigationTabProvider> provider5, Provider<CallUuidProvider> provider6) {
        return new DeepLinkModule_ProvideDeepLinkIntentFactoryFactory(deepLinkModule, provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static DeepLinkIntentFactory provideDeepLinkIntentFactory(DeepLinkModule deepLinkModule, ActivityIntentFactory activityIntentFactory, ImplicitIntentFactory implicitIntentFactory, Features features, UTMLinkConverter uTMLinkConverter, NavigationTabProvider navigationTabProvider, CallUuidProvider callUuidProvider) {
        return (DeepLinkIntentFactory) Preconditions.checkNotNullFromProvides(deepLinkModule.provideDeepLinkIntentFactory(activityIntentFactory, implicitIntentFactory, features, uTMLinkConverter, navigationTabProvider, callUuidProvider));
    }

    @Override // javax.inject.Provider
    public DeepLinkIntentFactory get() {
        return provideDeepLinkIntentFactory(this.a, this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get(), this.g.get());
    }
}

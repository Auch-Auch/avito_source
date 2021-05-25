package com.avito.android.di.module;

import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.util.BuildInfo;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DeepLinkModule_ProvideDeepLinkFactoryFactory implements Factory<DeepLinkFactory> {
    public final DeepLinkModule a;
    public final Provider<Features> b;
    public final Provider<Analytics> c;
    public final Provider<BuildInfo> d;

    public DeepLinkModule_ProvideDeepLinkFactoryFactory(DeepLinkModule deepLinkModule, Provider<Features> provider, Provider<Analytics> provider2, Provider<BuildInfo> provider3) {
        this.a = deepLinkModule;
        this.b = provider;
        this.c = provider2;
        this.d = provider3;
    }

    public static DeepLinkModule_ProvideDeepLinkFactoryFactory create(DeepLinkModule deepLinkModule, Provider<Features> provider, Provider<Analytics> provider2, Provider<BuildInfo> provider3) {
        return new DeepLinkModule_ProvideDeepLinkFactoryFactory(deepLinkModule, provider, provider2, provider3);
    }

    public static DeepLinkFactory provideDeepLinkFactory(DeepLinkModule deepLinkModule, Features features, Analytics analytics, BuildInfo buildInfo) {
        return (DeepLinkFactory) Preconditions.checkNotNullFromProvides(deepLinkModule.provideDeepLinkFactory(features, analytics, buildInfo));
    }

    @Override // javax.inject.Provider
    public DeepLinkFactory get() {
        return provideDeepLinkFactory(this.a, this.b.get(), this.c.get(), this.d.get());
    }
}

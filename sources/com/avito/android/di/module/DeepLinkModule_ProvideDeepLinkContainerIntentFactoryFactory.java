package com.avito.android.di.module;

import com.avito.android.deep_linking.DeepLinkContainerIntentFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class DeepLinkModule_ProvideDeepLinkContainerIntentFactoryFactory implements Factory<DeepLinkContainerIntentFactory> {
    public final DeepLinkModule a;
    public final Provider<DeepLinkIntentFactory> b;

    public DeepLinkModule_ProvideDeepLinkContainerIntentFactoryFactory(DeepLinkModule deepLinkModule, Provider<DeepLinkIntentFactory> provider) {
        this.a = deepLinkModule;
        this.b = provider;
    }

    public static DeepLinkModule_ProvideDeepLinkContainerIntentFactoryFactory create(DeepLinkModule deepLinkModule, Provider<DeepLinkIntentFactory> provider) {
        return new DeepLinkModule_ProvideDeepLinkContainerIntentFactoryFactory(deepLinkModule, provider);
    }

    public static DeepLinkContainerIntentFactory provideDeepLinkContainerIntentFactory(DeepLinkModule deepLinkModule, DeepLinkIntentFactory deepLinkIntentFactory) {
        return (DeepLinkContainerIntentFactory) Preconditions.checkNotNullFromProvides(deepLinkModule.provideDeepLinkContainerIntentFactory(deepLinkIntentFactory));
    }

    @Override // javax.inject.Provider
    public DeepLinkContainerIntentFactory get() {
        return provideDeepLinkContainerIntentFactory(this.a, this.b.get());
    }
}

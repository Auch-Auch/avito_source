package com.avito.android.publish.details.di;

import com.avito.android.publish.details.PublishDetailsResourceProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class PublishDetailsModule_ProvidePublishDetailsResourceProviderFactory implements Factory<PublishDetailsResourceProvider> {
    public final PublishDetailsModule a;

    public PublishDetailsModule_ProvidePublishDetailsResourceProviderFactory(PublishDetailsModule publishDetailsModule) {
        this.a = publishDetailsModule;
    }

    public static PublishDetailsModule_ProvidePublishDetailsResourceProviderFactory create(PublishDetailsModule publishDetailsModule) {
        return new PublishDetailsModule_ProvidePublishDetailsResourceProviderFactory(publishDetailsModule);
    }

    public static PublishDetailsResourceProvider providePublishDetailsResourceProvider(PublishDetailsModule publishDetailsModule) {
        return (PublishDetailsResourceProvider) Preconditions.checkNotNullFromProvides(publishDetailsModule.providePublishDetailsResourceProvider());
    }

    @Override // javax.inject.Provider
    public PublishDetailsResourceProvider get() {
        return providePublishDetailsResourceProvider(this.a);
    }
}

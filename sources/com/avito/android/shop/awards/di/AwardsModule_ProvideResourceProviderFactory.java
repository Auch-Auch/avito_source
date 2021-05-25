package com.avito.android.shop.awards.di;

import android.content.res.Resources;
import com.avito.android.shop.awards.AwardsResourceProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class AwardsModule_ProvideResourceProviderFactory implements Factory<AwardsResourceProvider> {
    public final Provider<Resources> a;

    public AwardsModule_ProvideResourceProviderFactory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static AwardsModule_ProvideResourceProviderFactory create(Provider<Resources> provider) {
        return new AwardsModule_ProvideResourceProviderFactory(provider);
    }

    public static AwardsResourceProvider provideResourceProvider(Resources resources) {
        return (AwardsResourceProvider) Preconditions.checkNotNullFromProvides(AwardsModule.provideResourceProvider(resources));
    }

    @Override // javax.inject.Provider
    public AwardsResourceProvider get() {
        return provideResourceProvider(this.a.get());
    }
}

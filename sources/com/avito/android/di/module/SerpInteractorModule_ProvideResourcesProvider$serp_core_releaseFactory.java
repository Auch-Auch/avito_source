package com.avito.android.di.module;

import android.content.res.Resources;
import com.avito.android.serp.SerpResourcesProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
public final class SerpInteractorModule_ProvideResourcesProvider$serp_core_releaseFactory implements Factory<SerpResourcesProvider> {
    public final Provider<Resources> a;

    public SerpInteractorModule_ProvideResourcesProvider$serp_core_releaseFactory(Provider<Resources> provider) {
        this.a = provider;
    }

    public static SerpInteractorModule_ProvideResourcesProvider$serp_core_releaseFactory create(Provider<Resources> provider) {
        return new SerpInteractorModule_ProvideResourcesProvider$serp_core_releaseFactory(provider);
    }

    public static SerpResourcesProvider provideResourcesProvider$serp_core_release(Resources resources) {
        return (SerpResourcesProvider) Preconditions.checkNotNullFromProvides(SerpInteractorModule.provideResourcesProvider$serp_core_release(resources));
    }

    @Override // javax.inject.Provider
    public SerpResourcesProvider get() {
        return provideResourcesProvider$serp_core_release(this.a.get());
    }
}

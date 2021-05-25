package com.avito.android.brandspace.di;

import com.avito.android.brandspace.items.marketplace.UniversalCarouselItemsBlueprints;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class BrandspaceFragmentModule_ProvideUniversalCarouselBlueprints$brandspace_releaseFactory implements Factory<UniversalCarouselItemsBlueprints> {

    public static final class a {
        public static final BrandspaceFragmentModule_ProvideUniversalCarouselBlueprints$brandspace_releaseFactory a = new BrandspaceFragmentModule_ProvideUniversalCarouselBlueprints$brandspace_releaseFactory();
    }

    public static BrandspaceFragmentModule_ProvideUniversalCarouselBlueprints$brandspace_releaseFactory create() {
        return a.a;
    }

    public static UniversalCarouselItemsBlueprints provideUniversalCarouselBlueprints$brandspace_release() {
        return (UniversalCarouselItemsBlueprints) Preconditions.checkNotNullFromProvides(BrandspaceFragmentModule.INSTANCE.provideUniversalCarouselBlueprints$brandspace_release());
    }

    @Override // javax.inject.Provider
    public UniversalCarouselItemsBlueprints get() {
        return provideUniversalCarouselBlueprints$brandspace_release();
    }
}

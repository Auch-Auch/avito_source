package com.avito.android.brandspace.items.marketplace.carouselLoader;

import com.avito.android.brandspace.items.marketplace.skeleton.SkeletonItem;
import com.avito.android.brandspace.presenter.BrandspaceResourcesProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CarouselLoaderPresenterImpl_Factory implements Factory<CarouselLoaderPresenterImpl> {
    public final Provider<BrandspaceResourcesProvider> a;
    public final Provider<SkeletonItem> b;

    public CarouselLoaderPresenterImpl_Factory(Provider<BrandspaceResourcesProvider> provider, Provider<SkeletonItem> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static CarouselLoaderPresenterImpl_Factory create(Provider<BrandspaceResourcesProvider> provider, Provider<SkeletonItem> provider2) {
        return new CarouselLoaderPresenterImpl_Factory(provider, provider2);
    }

    public static CarouselLoaderPresenterImpl newInstance(BrandspaceResourcesProvider brandspaceResourcesProvider, SkeletonItem skeletonItem) {
        return new CarouselLoaderPresenterImpl(brandspaceResourcesProvider, skeletonItem);
    }

    @Override // javax.inject.Provider
    public CarouselLoaderPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}

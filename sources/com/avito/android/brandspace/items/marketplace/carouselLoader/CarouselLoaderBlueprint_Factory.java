package com.avito.android.brandspace.items.marketplace.carouselLoader;

import com.avito.android.brandspace.items.marketplace.skeleton.SkeletonBlueprint;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class CarouselLoaderBlueprint_Factory implements Factory<CarouselLoaderBlueprint> {
    public final Provider<CarouselLoaderPresenter> a;
    public final Provider<SkeletonBlueprint> b;

    public CarouselLoaderBlueprint_Factory(Provider<CarouselLoaderPresenter> provider, Provider<SkeletonBlueprint> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static CarouselLoaderBlueprint_Factory create(Provider<CarouselLoaderPresenter> provider, Provider<SkeletonBlueprint> provider2) {
        return new CarouselLoaderBlueprint_Factory(provider, provider2);
    }

    public static CarouselLoaderBlueprint newInstance(CarouselLoaderPresenter carouselLoaderPresenter, SkeletonBlueprint skeletonBlueprint) {
        return new CarouselLoaderBlueprint(carouselLoaderPresenter, skeletonBlueprint);
    }

    @Override // javax.inject.Provider
    public CarouselLoaderBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}

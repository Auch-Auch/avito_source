package com.avito.android.advert.item.skeleton;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsTitleSkeletonBlueprint_Factory implements Factory<AdvertDetailsTitleSkeletonBlueprint> {
    public final Provider<AdvertDetailsSkeletonPresenter> a;

    public AdvertDetailsTitleSkeletonBlueprint_Factory(Provider<AdvertDetailsSkeletonPresenter> provider) {
        this.a = provider;
    }

    public static AdvertDetailsTitleSkeletonBlueprint_Factory create(Provider<AdvertDetailsSkeletonPresenter> provider) {
        return new AdvertDetailsTitleSkeletonBlueprint_Factory(provider);
    }

    public static AdvertDetailsTitleSkeletonBlueprint newInstance(AdvertDetailsSkeletonPresenter advertDetailsSkeletonPresenter) {
        return new AdvertDetailsTitleSkeletonBlueprint(advertDetailsSkeletonPresenter);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsTitleSkeletonBlueprint get() {
        return newInstance(this.a.get());
    }
}

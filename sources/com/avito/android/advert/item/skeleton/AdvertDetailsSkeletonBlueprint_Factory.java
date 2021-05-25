package com.avito.android.advert.item.skeleton;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertDetailsSkeletonBlueprint_Factory implements Factory<AdvertDetailsSkeletonBlueprint> {
    public final Provider<AdvertDetailsSkeletonPresenter> a;

    public AdvertDetailsSkeletonBlueprint_Factory(Provider<AdvertDetailsSkeletonPresenter> provider) {
        this.a = provider;
    }

    public static AdvertDetailsSkeletonBlueprint_Factory create(Provider<AdvertDetailsSkeletonPresenter> provider) {
        return new AdvertDetailsSkeletonBlueprint_Factory(provider);
    }

    public static AdvertDetailsSkeletonBlueprint newInstance(AdvertDetailsSkeletonPresenter advertDetailsSkeletonPresenter) {
        return new AdvertDetailsSkeletonBlueprint(advertDetailsSkeletonPresenter);
    }

    @Override // javax.inject.Provider
    public AdvertDetailsSkeletonBlueprint get() {
        return newInstance(this.a.get());
    }
}

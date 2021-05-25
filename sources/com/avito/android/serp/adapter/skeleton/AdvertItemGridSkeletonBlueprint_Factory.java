package com.avito.android.serp.adapter.skeleton;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdvertItemGridSkeletonBlueprint_Factory implements Factory<AdvertItemGridSkeletonBlueprint> {
    public final Provider<SkeletonPresenter> a;

    public AdvertItemGridSkeletonBlueprint_Factory(Provider<SkeletonPresenter> provider) {
        this.a = provider;
    }

    public static AdvertItemGridSkeletonBlueprint_Factory create(Provider<SkeletonPresenter> provider) {
        return new AdvertItemGridSkeletonBlueprint_Factory(provider);
    }

    public static AdvertItemGridSkeletonBlueprint newInstance(SkeletonPresenter skeletonPresenter) {
        return new AdvertItemGridSkeletonBlueprint(skeletonPresenter);
    }

    @Override // javax.inject.Provider
    public AdvertItemGridSkeletonBlueprint get() {
        return newInstance(this.a.get());
    }
}

package com.avito.android.safedeal.delivery_type.items.skeleton;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class SkeletonBlueprint_Factory implements Factory<SkeletonBlueprint> {
    public final Provider<SkeletonPresenter> a;

    public SkeletonBlueprint_Factory(Provider<SkeletonPresenter> provider) {
        this.a = provider;
    }

    public static SkeletonBlueprint_Factory create(Provider<SkeletonPresenter> provider) {
        return new SkeletonBlueprint_Factory(provider);
    }

    public static SkeletonBlueprint newInstance(SkeletonPresenter skeletonPresenter) {
        return new SkeletonBlueprint(skeletonPresenter);
    }

    @Override // javax.inject.Provider
    public SkeletonBlueprint get() {
        return newInstance(this.a.get());
    }
}

package com.avito.android.brandspace.items.marketplace.tabsSkeleton;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class TabSkeletonBlueprint_Factory implements Factory<TabSkeletonBlueprint> {
    public final Provider<TabSkeletonPresenter> a;

    public TabSkeletonBlueprint_Factory(Provider<TabSkeletonPresenter> provider) {
        this.a = provider;
    }

    public static TabSkeletonBlueprint_Factory create(Provider<TabSkeletonPresenter> provider) {
        return new TabSkeletonBlueprint_Factory(provider);
    }

    public static TabSkeletonBlueprint newInstance(TabSkeletonPresenter tabSkeletonPresenter) {
        return new TabSkeletonBlueprint(tabSkeletonPresenter);
    }

    @Override // javax.inject.Provider
    public TabSkeletonBlueprint get() {
        return newInstance(this.a.get());
    }
}

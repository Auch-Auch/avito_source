package com.avito.android.brandspace.items.marketplace.tabsSkeleton.tabLoader;

import com.avito.android.brandspace.items.marketplace.tabsSkeleton.TabSkeletonBlueprint;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class TabLoaderBlueprint_Factory implements Factory<TabLoaderBlueprint> {
    public final Provider<TabLoaderPresenter> a;
    public final Provider<TabSkeletonBlueprint> b;

    public TabLoaderBlueprint_Factory(Provider<TabLoaderPresenter> provider, Provider<TabSkeletonBlueprint> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static TabLoaderBlueprint_Factory create(Provider<TabLoaderPresenter> provider, Provider<TabSkeletonBlueprint> provider2) {
        return new TabLoaderBlueprint_Factory(provider, provider2);
    }

    public static TabLoaderBlueprint newInstance(TabLoaderPresenter tabLoaderPresenter, TabSkeletonBlueprint tabSkeletonBlueprint) {
        return new TabLoaderBlueprint(tabLoaderPresenter, tabSkeletonBlueprint);
    }

    @Override // javax.inject.Provider
    public TabLoaderBlueprint get() {
        return newInstance(this.a.get(), this.b.get());
    }
}

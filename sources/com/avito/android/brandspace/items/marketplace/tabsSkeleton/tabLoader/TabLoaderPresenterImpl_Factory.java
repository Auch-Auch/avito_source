package com.avito.android.brandspace.items.marketplace.tabsSkeleton.tabLoader;

import com.avito.android.brandspace.items.marketplace.tabsSkeleton.TabSkeletonItem;
import com.avito.android.brandspace.presenter.BrandspaceResourcesProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class TabLoaderPresenterImpl_Factory implements Factory<TabLoaderPresenterImpl> {
    public final Provider<TabSkeletonItem> a;
    public final Provider<BrandspaceResourcesProvider> b;

    public TabLoaderPresenterImpl_Factory(Provider<TabSkeletonItem> provider, Provider<BrandspaceResourcesProvider> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static TabLoaderPresenterImpl_Factory create(Provider<TabSkeletonItem> provider, Provider<BrandspaceResourcesProvider> provider2) {
        return new TabLoaderPresenterImpl_Factory(provider, provider2);
    }

    public static TabLoaderPresenterImpl newInstance(TabSkeletonItem tabSkeletonItem, BrandspaceResourcesProvider brandspaceResourcesProvider) {
        return new TabLoaderPresenterImpl(tabSkeletonItem, brandspaceResourcesProvider);
    }

    @Override // javax.inject.Provider
    public TabLoaderPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}

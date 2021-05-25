package com.avito.android.brandspace.items.marketplace.tabsSkeleton;

import dagger.internal.Factory;
public final class TabSkeletonPresenterImpl_Factory implements Factory<TabSkeletonPresenterImpl> {

    public static final class a {
        public static final TabSkeletonPresenterImpl_Factory a = new TabSkeletonPresenterImpl_Factory();
    }

    public static TabSkeletonPresenterImpl_Factory create() {
        return a.a;
    }

    public static TabSkeletonPresenterImpl newInstance() {
        return new TabSkeletonPresenterImpl();
    }

    @Override // javax.inject.Provider
    public TabSkeletonPresenterImpl get() {
        return newInstance();
    }
}

package com.avito.android.advert.item.skeleton;

import dagger.internal.Factory;
public final class AdvertDetailsSkeletonPresenterImpl_Factory implements Factory<AdvertDetailsSkeletonPresenterImpl> {

    public static final class a {
        public static final AdvertDetailsSkeletonPresenterImpl_Factory a = new AdvertDetailsSkeletonPresenterImpl_Factory();
    }

    public static AdvertDetailsSkeletonPresenterImpl_Factory create() {
        return a.a;
    }

    public static AdvertDetailsSkeletonPresenterImpl newInstance() {
        return new AdvertDetailsSkeletonPresenterImpl();
    }

    @Override // javax.inject.Provider
    public AdvertDetailsSkeletonPresenterImpl get() {
        return newInstance();
    }
}

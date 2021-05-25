package com.avito.android.safedeal.delivery_type.items.skeleton;

import dagger.internal.Factory;
public final class SkeletonPresenterImpl_Factory implements Factory<SkeletonPresenterImpl> {

    public static final class a {
        public static final SkeletonPresenterImpl_Factory a = new SkeletonPresenterImpl_Factory();
    }

    public static SkeletonPresenterImpl_Factory create() {
        return a.a;
    }

    public static SkeletonPresenterImpl newInstance() {
        return new SkeletonPresenterImpl();
    }

    @Override // javax.inject.Provider
    public SkeletonPresenterImpl get() {
        return newInstance();
    }
}

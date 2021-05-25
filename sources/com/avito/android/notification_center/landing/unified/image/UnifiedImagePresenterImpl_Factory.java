package com.avito.android.notification_center.landing.unified.image;

import dagger.internal.Factory;
public final class UnifiedImagePresenterImpl_Factory implements Factory<UnifiedImagePresenterImpl> {

    public static final class a {
        public static final UnifiedImagePresenterImpl_Factory a = new UnifiedImagePresenterImpl_Factory();
    }

    public static UnifiedImagePresenterImpl_Factory create() {
        return a.a;
    }

    public static UnifiedImagePresenterImpl newInstance() {
        return new UnifiedImagePresenterImpl();
    }

    @Override // javax.inject.Provider
    public UnifiedImagePresenterImpl get() {
        return newInstance();
    }
}

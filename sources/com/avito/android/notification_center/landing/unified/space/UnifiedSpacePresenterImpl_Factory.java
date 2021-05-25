package com.avito.android.notification_center.landing.unified.space;

import dagger.internal.Factory;
public final class UnifiedSpacePresenterImpl_Factory implements Factory<UnifiedSpacePresenterImpl> {

    public static final class a {
        public static final UnifiedSpacePresenterImpl_Factory a = new UnifiedSpacePresenterImpl_Factory();
    }

    public static UnifiedSpacePresenterImpl_Factory create() {
        return a.a;
    }

    public static UnifiedSpacePresenterImpl newInstance() {
        return new UnifiedSpacePresenterImpl();
    }

    @Override // javax.inject.Provider
    public UnifiedSpacePresenterImpl get() {
        return newInstance();
    }
}

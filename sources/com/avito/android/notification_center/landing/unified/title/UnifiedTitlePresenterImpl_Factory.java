package com.avito.android.notification_center.landing.unified.title;

import dagger.internal.Factory;
public final class UnifiedTitlePresenterImpl_Factory implements Factory<UnifiedTitlePresenterImpl> {

    public static final class a {
        public static final UnifiedTitlePresenterImpl_Factory a = new UnifiedTitlePresenterImpl_Factory();
    }

    public static UnifiedTitlePresenterImpl_Factory create() {
        return a.a;
    }

    public static UnifiedTitlePresenterImpl newInstance() {
        return new UnifiedTitlePresenterImpl();
    }

    @Override // javax.inject.Provider
    public UnifiedTitlePresenterImpl get() {
        return newInstance();
    }
}

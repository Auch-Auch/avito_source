package com.avito.android.notification_center.landing.unified.description;

import dagger.internal.Factory;
public final class UnifiedDescriptionPresenterImpl_Factory implements Factory<UnifiedDescriptionPresenterImpl> {

    public static final class a {
        public static final UnifiedDescriptionPresenterImpl_Factory a = new UnifiedDescriptionPresenterImpl_Factory();
    }

    public static UnifiedDescriptionPresenterImpl_Factory create() {
        return a.a;
    }

    public static UnifiedDescriptionPresenterImpl newInstance() {
        return new UnifiedDescriptionPresenterImpl();
    }

    @Override // javax.inject.Provider
    public UnifiedDescriptionPresenterImpl get() {
        return newInstance();
    }
}

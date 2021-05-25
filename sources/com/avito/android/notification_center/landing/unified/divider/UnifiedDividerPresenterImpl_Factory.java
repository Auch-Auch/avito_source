package com.avito.android.notification_center.landing.unified.divider;

import dagger.internal.Factory;
public final class UnifiedDividerPresenterImpl_Factory implements Factory<UnifiedDividerPresenterImpl> {

    public static final class a {
        public static final UnifiedDividerPresenterImpl_Factory a = new UnifiedDividerPresenterImpl_Factory();
    }

    public static UnifiedDividerPresenterImpl_Factory create() {
        return a.a;
    }

    public static UnifiedDividerPresenterImpl newInstance() {
        return new UnifiedDividerPresenterImpl();
    }

    @Override // javax.inject.Provider
    public UnifiedDividerPresenterImpl get() {
        return newInstance();
    }
}

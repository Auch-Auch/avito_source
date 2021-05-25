package com.avito.android.location.back_navigation;

import dagger.internal.Factory;
public final class BackNavigationLocationStorageImpl_Factory implements Factory<BackNavigationLocationStorageImpl> {

    public static final class a {
        public static final BackNavigationLocationStorageImpl_Factory a = new BackNavigationLocationStorageImpl_Factory();
    }

    public static BackNavigationLocationStorageImpl_Factory create() {
        return a.a;
    }

    public static BackNavigationLocationStorageImpl newInstance() {
        return new BackNavigationLocationStorageImpl();
    }

    @Override // javax.inject.Provider
    public BackNavigationLocationStorageImpl get() {
        return newInstance();
    }
}

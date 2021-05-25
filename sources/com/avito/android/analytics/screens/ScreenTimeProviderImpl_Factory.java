package com.avito.android.analytics.screens;

import dagger.internal.Factory;
public final class ScreenTimeProviderImpl_Factory implements Factory<ScreenTimeProviderImpl> {

    public static final class a {
        public static final ScreenTimeProviderImpl_Factory a = new ScreenTimeProviderImpl_Factory();
    }

    public static ScreenTimeProviderImpl_Factory create() {
        return a.a;
    }

    public static ScreenTimeProviderImpl newInstance() {
        return new ScreenTimeProviderImpl();
    }

    @Override // javax.inject.Provider
    public ScreenTimeProviderImpl get() {
        return newInstance();
    }
}

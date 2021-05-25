package com.avito.android.util;

import dagger.internal.Factory;
public final class UUIDRandomKeyProvider_Factory implements Factory<UUIDRandomKeyProvider> {

    public static final class a {
        public static final UUIDRandomKeyProvider_Factory a = new UUIDRandomKeyProvider_Factory();
    }

    public static UUIDRandomKeyProvider_Factory create() {
        return a.a;
    }

    public static UUIDRandomKeyProvider newInstance() {
        return new UUIDRandomKeyProvider();
    }

    @Override // javax.inject.Provider
    public UUIDRandomKeyProvider get() {
        return newInstance();
    }
}

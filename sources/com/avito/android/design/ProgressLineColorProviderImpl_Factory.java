package com.avito.android.design;

import dagger.internal.Factory;
public final class ProgressLineColorProviderImpl_Factory implements Factory<ProgressLineColorProviderImpl> {

    public static final class a {
        public static final ProgressLineColorProviderImpl_Factory a = new ProgressLineColorProviderImpl_Factory();
    }

    public static ProgressLineColorProviderImpl_Factory create() {
        return a.a;
    }

    public static ProgressLineColorProviderImpl newInstance() {
        return new ProgressLineColorProviderImpl();
    }

    @Override // javax.inject.Provider
    public ProgressLineColorProviderImpl get() {
        return newInstance();
    }
}

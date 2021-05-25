package com.avito.android.in_app_calls;

import dagger.internal.Factory;
public final class CallRegistryImpl_Factory implements Factory<CallRegistryImpl> {

    public static final class a {
        public static final CallRegistryImpl_Factory a = new CallRegistryImpl_Factory();
    }

    public static CallRegistryImpl_Factory create() {
        return a.a;
    }

    public static CallRegistryImpl newInstance() {
        return new CallRegistryImpl();
    }

    @Override // javax.inject.Provider
    public CallRegistryImpl get() {
        return newInstance();
    }
}

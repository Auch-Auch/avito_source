package com.avito.android.recycler.responsive;

import dagger.internal.Factory;
public final class CallableResponsiveItemPresenterRegistryImpl_Factory implements Factory<CallableResponsiveItemPresenterRegistryImpl> {

    public static final class a {
        public static final CallableResponsiveItemPresenterRegistryImpl_Factory a = new CallableResponsiveItemPresenterRegistryImpl_Factory();
    }

    public static CallableResponsiveItemPresenterRegistryImpl_Factory create() {
        return a.a;
    }

    public static CallableResponsiveItemPresenterRegistryImpl newInstance() {
        return new CallableResponsiveItemPresenterRegistryImpl();
    }

    @Override // javax.inject.Provider
    public CallableResponsiveItemPresenterRegistryImpl get() {
        return newInstance();
    }
}

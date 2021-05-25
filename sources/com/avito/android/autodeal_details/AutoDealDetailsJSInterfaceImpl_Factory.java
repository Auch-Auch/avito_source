package com.avito.android.autodeal_details;

import dagger.internal.Factory;
public final class AutoDealDetailsJSInterfaceImpl_Factory implements Factory<AutoDealDetailsJSInterfaceImpl> {

    public static final class a {
        public static final AutoDealDetailsJSInterfaceImpl_Factory a = new AutoDealDetailsJSInterfaceImpl_Factory();
    }

    public static AutoDealDetailsJSInterfaceImpl_Factory create() {
        return a.a;
    }

    public static AutoDealDetailsJSInterfaceImpl newInstance() {
        return new AutoDealDetailsJSInterfaceImpl();
    }

    @Override // javax.inject.Provider
    public AutoDealDetailsJSInterfaceImpl get() {
        return newInstance();
    }
}

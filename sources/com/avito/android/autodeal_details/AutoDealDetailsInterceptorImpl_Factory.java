package com.avito.android.autodeal_details;

import dagger.internal.Factory;
public final class AutoDealDetailsInterceptorImpl_Factory implements Factory<AutoDealDetailsInterceptorImpl> {

    public static final class a {
        public static final AutoDealDetailsInterceptorImpl_Factory a = new AutoDealDetailsInterceptorImpl_Factory();
    }

    public static AutoDealDetailsInterceptorImpl_Factory create() {
        return a.a;
    }

    public static AutoDealDetailsInterceptorImpl newInstance() {
        return new AutoDealDetailsInterceptorImpl();
    }

    @Override // javax.inject.Provider
    public AutoDealDetailsInterceptorImpl get() {
        return newInstance();
    }
}

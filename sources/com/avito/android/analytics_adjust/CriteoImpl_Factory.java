package com.avito.android.analytics_adjust;

import dagger.internal.Factory;
public final class CriteoImpl_Factory implements Factory<CriteoImpl> {

    public static final class a {
        public static final CriteoImpl_Factory a = new CriteoImpl_Factory();
    }

    public static CriteoImpl_Factory create() {
        return a.a;
    }

    public static CriteoImpl newInstance() {
        return new CriteoImpl();
    }

    @Override // javax.inject.Provider
    public CriteoImpl get() {
        return newInstance();
    }
}

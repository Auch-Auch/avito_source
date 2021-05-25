package com.avito.android.tariff.fees_methods.items.high_demand;

import dagger.internal.Factory;
public final class HighDemandPresenterImpl_Factory implements Factory<HighDemandPresenterImpl> {

    public static final class a {
        public static final HighDemandPresenterImpl_Factory a = new HighDemandPresenterImpl_Factory();
    }

    public static HighDemandPresenterImpl_Factory create() {
        return a.a;
    }

    public static HighDemandPresenterImpl newInstance() {
        return new HighDemandPresenterImpl();
    }

    @Override // javax.inject.Provider
    public HighDemandPresenterImpl get() {
        return newInstance();
    }
}

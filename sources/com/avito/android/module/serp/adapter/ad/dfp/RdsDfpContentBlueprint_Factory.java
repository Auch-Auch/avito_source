package com.avito.android.module.serp.adapter.ad.dfp;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class RdsDfpContentBlueprint_Factory implements Factory<RdsDfpContentBlueprint> {
    public final Provider<DfpContentPresenter> a;

    public RdsDfpContentBlueprint_Factory(Provider<DfpContentPresenter> provider) {
        this.a = provider;
    }

    public static RdsDfpContentBlueprint_Factory create(Provider<DfpContentPresenter> provider) {
        return new RdsDfpContentBlueprint_Factory(provider);
    }

    public static RdsDfpContentBlueprint newInstance(DfpContentPresenter dfpContentPresenter) {
        return new RdsDfpContentBlueprint(dfpContentPresenter);
    }

    @Override // javax.inject.Provider
    public RdsDfpContentBlueprint get() {
        return newInstance(this.a.get());
    }
}

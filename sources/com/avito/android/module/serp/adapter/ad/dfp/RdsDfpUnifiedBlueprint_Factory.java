package com.avito.android.module.serp.adapter.ad.dfp;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class RdsDfpUnifiedBlueprint_Factory implements Factory<RdsDfpUnifiedBlueprint> {
    public final Provider<DfpUnifiedPresenter> a;

    public RdsDfpUnifiedBlueprint_Factory(Provider<DfpUnifiedPresenter> provider) {
        this.a = provider;
    }

    public static RdsDfpUnifiedBlueprint_Factory create(Provider<DfpUnifiedPresenter> provider) {
        return new RdsDfpUnifiedBlueprint_Factory(provider);
    }

    public static RdsDfpUnifiedBlueprint newInstance(DfpUnifiedPresenter dfpUnifiedPresenter) {
        return new RdsDfpUnifiedBlueprint(dfpUnifiedPresenter);
    }

    @Override // javax.inject.Provider
    public RdsDfpUnifiedBlueprint get() {
        return newInstance(this.a.get());
    }
}

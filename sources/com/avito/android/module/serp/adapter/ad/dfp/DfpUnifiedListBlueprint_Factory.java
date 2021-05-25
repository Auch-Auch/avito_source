package com.avito.android.module.serp.adapter.ad.dfp;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class DfpUnifiedListBlueprint_Factory implements Factory<DfpUnifiedListBlueprint> {
    public final Provider<DfpUnifiedPresenter> a;

    public DfpUnifiedListBlueprint_Factory(Provider<DfpUnifiedPresenter> provider) {
        this.a = provider;
    }

    public static DfpUnifiedListBlueprint_Factory create(Provider<DfpUnifiedPresenter> provider) {
        return new DfpUnifiedListBlueprint_Factory(provider);
    }

    public static DfpUnifiedListBlueprint newInstance(DfpUnifiedPresenter dfpUnifiedPresenter) {
        return new DfpUnifiedListBlueprint(dfpUnifiedPresenter);
    }

    @Override // javax.inject.Provider
    public DfpUnifiedListBlueprint get() {
        return newInstance(this.a.get());
    }
}

package com.avito.android.module.serp.adapter.ad.dfp;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class DfpUnifiedSingleGridBlueprint_Factory implements Factory<DfpUnifiedSingleGridBlueprint> {
    public final Provider<DfpUnifiedPresenter> a;

    public DfpUnifiedSingleGridBlueprint_Factory(Provider<DfpUnifiedPresenter> provider) {
        this.a = provider;
    }

    public static DfpUnifiedSingleGridBlueprint_Factory create(Provider<DfpUnifiedPresenter> provider) {
        return new DfpUnifiedSingleGridBlueprint_Factory(provider);
    }

    public static DfpUnifiedSingleGridBlueprint newInstance(DfpUnifiedPresenter dfpUnifiedPresenter) {
        return new DfpUnifiedSingleGridBlueprint(dfpUnifiedPresenter);
    }

    @Override // javax.inject.Provider
    public DfpUnifiedSingleGridBlueprint get() {
        return newInstance(this.a.get());
    }
}

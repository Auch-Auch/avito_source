package com.avito.android.module.serp.adapter.ad.dfp;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class DfpUnifiedDoubleBlueprint_Factory implements Factory<DfpUnifiedDoubleBlueprint> {
    public final Provider<DfpUnifiedPresenter> a;

    public DfpUnifiedDoubleBlueprint_Factory(Provider<DfpUnifiedPresenter> provider) {
        this.a = provider;
    }

    public static DfpUnifiedDoubleBlueprint_Factory create(Provider<DfpUnifiedPresenter> provider) {
        return new DfpUnifiedDoubleBlueprint_Factory(provider);
    }

    public static DfpUnifiedDoubleBlueprint newInstance(DfpUnifiedPresenter dfpUnifiedPresenter) {
        return new DfpUnifiedDoubleBlueprint(dfpUnifiedPresenter);
    }

    @Override // javax.inject.Provider
    public DfpUnifiedDoubleBlueprint get() {
        return newInstance(this.a.get());
    }
}

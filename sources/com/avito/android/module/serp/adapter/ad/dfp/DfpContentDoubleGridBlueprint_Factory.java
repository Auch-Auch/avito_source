package com.avito.android.module.serp.adapter.ad.dfp;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class DfpContentDoubleGridBlueprint_Factory implements Factory<DfpContentDoubleGridBlueprint> {
    public final Provider<DfpContentPresenter> a;

    public DfpContentDoubleGridBlueprint_Factory(Provider<DfpContentPresenter> provider) {
        this.a = provider;
    }

    public static DfpContentDoubleGridBlueprint_Factory create(Provider<DfpContentPresenter> provider) {
        return new DfpContentDoubleGridBlueprint_Factory(provider);
    }

    public static DfpContentDoubleGridBlueprint newInstance(DfpContentPresenter dfpContentPresenter) {
        return new DfpContentDoubleGridBlueprint(dfpContentPresenter);
    }

    @Override // javax.inject.Provider
    public DfpContentDoubleGridBlueprint get() {
        return newInstance(this.a.get());
    }
}

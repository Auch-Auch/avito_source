package com.avito.android.module.serp.adapter.ad.dfp;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class DfpContentSingleGridBlueprint_Factory implements Factory<DfpContentSingleGridBlueprint> {
    public final Provider<DfpContentPresenter> a;

    public DfpContentSingleGridBlueprint_Factory(Provider<DfpContentPresenter> provider) {
        this.a = provider;
    }

    public static DfpContentSingleGridBlueprint_Factory create(Provider<DfpContentPresenter> provider) {
        return new DfpContentSingleGridBlueprint_Factory(provider);
    }

    public static DfpContentSingleGridBlueprint newInstance(DfpContentPresenter dfpContentPresenter) {
        return new DfpContentSingleGridBlueprint(dfpContentPresenter);
    }

    @Override // javax.inject.Provider
    public DfpContentSingleGridBlueprint get() {
        return newInstance(this.a.get());
    }
}

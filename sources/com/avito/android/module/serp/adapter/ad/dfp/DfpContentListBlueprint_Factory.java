package com.avito.android.module.serp.adapter.ad.dfp;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class DfpContentListBlueprint_Factory implements Factory<DfpContentListBlueprint> {
    public final Provider<DfpContentPresenter> a;

    public DfpContentListBlueprint_Factory(Provider<DfpContentPresenter> provider) {
        this.a = provider;
    }

    public static DfpContentListBlueprint_Factory create(Provider<DfpContentPresenter> provider) {
        return new DfpContentListBlueprint_Factory(provider);
    }

    public static DfpContentListBlueprint newInstance(DfpContentPresenter dfpContentPresenter) {
        return new DfpContentListBlueprint(dfpContentPresenter);
    }

    @Override // javax.inject.Provider
    public DfpContentListBlueprint get() {
        return newInstance(this.a.get());
    }
}

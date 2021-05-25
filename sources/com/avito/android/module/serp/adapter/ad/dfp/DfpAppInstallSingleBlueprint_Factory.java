package com.avito.android.module.serp.adapter.ad.dfp;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class DfpAppInstallSingleBlueprint_Factory implements Factory<DfpAppInstallSingleBlueprint> {
    public final Provider<DfpAppInstallPresenter> a;

    public DfpAppInstallSingleBlueprint_Factory(Provider<DfpAppInstallPresenter> provider) {
        this.a = provider;
    }

    public static DfpAppInstallSingleBlueprint_Factory create(Provider<DfpAppInstallPresenter> provider) {
        return new DfpAppInstallSingleBlueprint_Factory(provider);
    }

    public static DfpAppInstallSingleBlueprint newInstance(DfpAppInstallPresenter dfpAppInstallPresenter) {
        return new DfpAppInstallSingleBlueprint(dfpAppInstallPresenter);
    }

    @Override // javax.inject.Provider
    public DfpAppInstallSingleBlueprint get() {
        return newInstance(this.a.get());
    }
}

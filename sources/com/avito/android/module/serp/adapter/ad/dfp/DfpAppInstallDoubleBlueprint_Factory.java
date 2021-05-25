package com.avito.android.module.serp.adapter.ad.dfp;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class DfpAppInstallDoubleBlueprint_Factory implements Factory<DfpAppInstallDoubleBlueprint> {
    public final Provider<DfpAppInstallPresenter> a;

    public DfpAppInstallDoubleBlueprint_Factory(Provider<DfpAppInstallPresenter> provider) {
        this.a = provider;
    }

    public static DfpAppInstallDoubleBlueprint_Factory create(Provider<DfpAppInstallPresenter> provider) {
        return new DfpAppInstallDoubleBlueprint_Factory(provider);
    }

    public static DfpAppInstallDoubleBlueprint newInstance(DfpAppInstallPresenter dfpAppInstallPresenter) {
        return new DfpAppInstallDoubleBlueprint(dfpAppInstallPresenter);
    }

    @Override // javax.inject.Provider
    public DfpAppInstallDoubleBlueprint get() {
        return newInstance(this.a.get());
    }
}

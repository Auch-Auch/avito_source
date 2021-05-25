package com.avito.android.module.serp.adapter.ad.dfp;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class RdsDfpAppInstallBlueprint_Factory implements Factory<RdsDfpAppInstallBlueprint> {
    public final Provider<DfpAppInstallPresenter> a;

    public RdsDfpAppInstallBlueprint_Factory(Provider<DfpAppInstallPresenter> provider) {
        this.a = provider;
    }

    public static RdsDfpAppInstallBlueprint_Factory create(Provider<DfpAppInstallPresenter> provider) {
        return new RdsDfpAppInstallBlueprint_Factory(provider);
    }

    public static RdsDfpAppInstallBlueprint newInstance(DfpAppInstallPresenter dfpAppInstallPresenter) {
        return new RdsDfpAppInstallBlueprint(dfpAppInstallPresenter);
    }

    @Override // javax.inject.Provider
    public RdsDfpAppInstallBlueprint get() {
        return newInstance(this.a.get());
    }
}

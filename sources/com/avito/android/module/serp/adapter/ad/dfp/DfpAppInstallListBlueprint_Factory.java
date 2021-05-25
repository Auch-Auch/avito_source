package com.avito.android.module.serp.adapter.ad.dfp;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class DfpAppInstallListBlueprint_Factory implements Factory<DfpAppInstallListBlueprint> {
    public final Provider<DfpAppInstallPresenter> a;

    public DfpAppInstallListBlueprint_Factory(Provider<DfpAppInstallPresenter> provider) {
        this.a = provider;
    }

    public static DfpAppInstallListBlueprint_Factory create(Provider<DfpAppInstallPresenter> provider) {
        return new DfpAppInstallListBlueprint_Factory(provider);
    }

    public static DfpAppInstallListBlueprint newInstance(DfpAppInstallPresenter dfpAppInstallPresenter) {
        return new DfpAppInstallListBlueprint(dfpAppInstallPresenter);
    }

    @Override // javax.inject.Provider
    public DfpAppInstallListBlueprint get() {
        return newInstance(this.a.get());
    }
}

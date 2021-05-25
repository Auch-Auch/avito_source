package com.avito.android.module.serp.adapter.ad.mytarget;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class RdsMyTargetAppInstallBlueprint_Factory implements Factory<RdsMyTargetAppInstallBlueprint> {
    public final Provider<MyTargetAppInstallPresenter> a;

    public RdsMyTargetAppInstallBlueprint_Factory(Provider<MyTargetAppInstallPresenter> provider) {
        this.a = provider;
    }

    public static RdsMyTargetAppInstallBlueprint_Factory create(Provider<MyTargetAppInstallPresenter> provider) {
        return new RdsMyTargetAppInstallBlueprint_Factory(provider);
    }

    public static RdsMyTargetAppInstallBlueprint newInstance(MyTargetAppInstallPresenter myTargetAppInstallPresenter) {
        return new RdsMyTargetAppInstallBlueprint(myTargetAppInstallPresenter);
    }

    @Override // javax.inject.Provider
    public RdsMyTargetAppInstallBlueprint get() {
        return newInstance(this.a.get());
    }
}

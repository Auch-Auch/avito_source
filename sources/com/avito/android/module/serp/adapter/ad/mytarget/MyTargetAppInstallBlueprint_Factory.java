package com.avito.android.module.serp.adapter.ad.mytarget;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class MyTargetAppInstallBlueprint_Factory implements Factory<MyTargetAppInstallBlueprint> {
    public final Provider<MyTargetAppInstallPresenter> a;

    public MyTargetAppInstallBlueprint_Factory(Provider<MyTargetAppInstallPresenter> provider) {
        this.a = provider;
    }

    public static MyTargetAppInstallBlueprint_Factory create(Provider<MyTargetAppInstallPresenter> provider) {
        return new MyTargetAppInstallBlueprint_Factory(provider);
    }

    public static MyTargetAppInstallBlueprint newInstance(MyTargetAppInstallPresenter myTargetAppInstallPresenter) {
        return new MyTargetAppInstallBlueprint(myTargetAppInstallPresenter);
    }

    @Override // javax.inject.Provider
    public MyTargetAppInstallBlueprint get() {
        return newInstance(this.a.get());
    }
}

package com.avito.android.module.serp.adapter.ad.mytarget;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class MyTargetAppInstallListBlueprint_Factory implements Factory<MyTargetAppInstallListBlueprint> {
    public final Provider<MyTargetAppInstallPresenter> a;

    public MyTargetAppInstallListBlueprint_Factory(Provider<MyTargetAppInstallPresenter> provider) {
        this.a = provider;
    }

    public static MyTargetAppInstallListBlueprint_Factory create(Provider<MyTargetAppInstallPresenter> provider) {
        return new MyTargetAppInstallListBlueprint_Factory(provider);
    }

    public static MyTargetAppInstallListBlueprint newInstance(MyTargetAppInstallPresenter myTargetAppInstallPresenter) {
        return new MyTargetAppInstallListBlueprint(myTargetAppInstallPresenter);
    }

    @Override // javax.inject.Provider
    public MyTargetAppInstallListBlueprint get() {
        return newInstance(this.a.get());
    }
}

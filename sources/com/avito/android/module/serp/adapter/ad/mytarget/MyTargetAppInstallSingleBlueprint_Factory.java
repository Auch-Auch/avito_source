package com.avito.android.module.serp.adapter.ad.mytarget;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class MyTargetAppInstallSingleBlueprint_Factory implements Factory<MyTargetAppInstallSingleBlueprint> {
    public final Provider<MyTargetAppInstallPresenter> a;

    public MyTargetAppInstallSingleBlueprint_Factory(Provider<MyTargetAppInstallPresenter> provider) {
        this.a = provider;
    }

    public static MyTargetAppInstallSingleBlueprint_Factory create(Provider<MyTargetAppInstallPresenter> provider) {
        return new MyTargetAppInstallSingleBlueprint_Factory(provider);
    }

    public static MyTargetAppInstallSingleBlueprint newInstance(MyTargetAppInstallPresenter myTargetAppInstallPresenter) {
        return new MyTargetAppInstallSingleBlueprint(myTargetAppInstallPresenter);
    }

    @Override // javax.inject.Provider
    public MyTargetAppInstallSingleBlueprint get() {
        return newInstance(this.a.get());
    }
}

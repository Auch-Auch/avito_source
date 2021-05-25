package com.avito.android.module.serp.adapter.ad.mytarget;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class RdsMyTargetContentBlueprint_Factory implements Factory<RdsMyTargetContentBlueprint> {
    public final Provider<MyTargetContentPresenter> a;

    public RdsMyTargetContentBlueprint_Factory(Provider<MyTargetContentPresenter> provider) {
        this.a = provider;
    }

    public static RdsMyTargetContentBlueprint_Factory create(Provider<MyTargetContentPresenter> provider) {
        return new RdsMyTargetContentBlueprint_Factory(provider);
    }

    public static RdsMyTargetContentBlueprint newInstance(MyTargetContentPresenter myTargetContentPresenter) {
        return new RdsMyTargetContentBlueprint(myTargetContentPresenter);
    }

    @Override // javax.inject.Provider
    public RdsMyTargetContentBlueprint get() {
        return newInstance(this.a.get());
    }
}

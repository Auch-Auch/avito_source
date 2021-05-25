package com.avito.android.module.serp.adapter.ad.mytarget;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class MyTargetContentSingleBlueprint_Factory implements Factory<MyTargetContentSingleBlueprint> {
    public final Provider<MyTargetContentPresenter> a;

    public MyTargetContentSingleBlueprint_Factory(Provider<MyTargetContentPresenter> provider) {
        this.a = provider;
    }

    public static MyTargetContentSingleBlueprint_Factory create(Provider<MyTargetContentPresenter> provider) {
        return new MyTargetContentSingleBlueprint_Factory(provider);
    }

    public static MyTargetContentSingleBlueprint newInstance(MyTargetContentPresenter myTargetContentPresenter) {
        return new MyTargetContentSingleBlueprint(myTargetContentPresenter);
    }

    @Override // javax.inject.Provider
    public MyTargetContentSingleBlueprint get() {
        return newInstance(this.a.get());
    }
}

package com.avito.android.module.serp.adapter.ad.mytarget;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class MyTargetContentListBlueprint_Factory implements Factory<MyTargetContentListBlueprint> {
    public final Provider<MyTargetContentPresenter> a;

    public MyTargetContentListBlueprint_Factory(Provider<MyTargetContentPresenter> provider) {
        this.a = provider;
    }

    public static MyTargetContentListBlueprint_Factory create(Provider<MyTargetContentPresenter> provider) {
        return new MyTargetContentListBlueprint_Factory(provider);
    }

    public static MyTargetContentListBlueprint newInstance(MyTargetContentPresenter myTargetContentPresenter) {
        return new MyTargetContentListBlueprint(myTargetContentPresenter);
    }

    @Override // javax.inject.Provider
    public MyTargetContentListBlueprint get() {
        return newInstance(this.a.get());
    }
}

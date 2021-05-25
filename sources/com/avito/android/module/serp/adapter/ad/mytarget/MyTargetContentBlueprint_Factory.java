package com.avito.android.module.serp.adapter.ad.mytarget;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class MyTargetContentBlueprint_Factory implements Factory<MyTargetContentBlueprint> {
    public final Provider<MyTargetContentPresenter> a;

    public MyTargetContentBlueprint_Factory(Provider<MyTargetContentPresenter> provider) {
        this.a = provider;
    }

    public static MyTargetContentBlueprint_Factory create(Provider<MyTargetContentPresenter> provider) {
        return new MyTargetContentBlueprint_Factory(provider);
    }

    public static MyTargetContentBlueprint newInstance(MyTargetContentPresenter myTargetContentPresenter) {
        return new MyTargetContentBlueprint(myTargetContentPresenter);
    }

    @Override // javax.inject.Provider
    public MyTargetContentBlueprint get() {
        return newInstance(this.a.get());
    }
}

package com.avito.android.serp.adapter.adstub;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class RdsEmptyAdStubItemBlueprint_Factory implements Factory<RdsEmptyAdStubItemBlueprint> {
    public final Provider<EmptyAdStubItemPresenter> a;

    public RdsEmptyAdStubItemBlueprint_Factory(Provider<EmptyAdStubItemPresenter> provider) {
        this.a = provider;
    }

    public static RdsEmptyAdStubItemBlueprint_Factory create(Provider<EmptyAdStubItemPresenter> provider) {
        return new RdsEmptyAdStubItemBlueprint_Factory(provider);
    }

    public static RdsEmptyAdStubItemBlueprint newInstance(EmptyAdStubItemPresenter emptyAdStubItemPresenter) {
        return new RdsEmptyAdStubItemBlueprint(emptyAdStubItemPresenter);
    }

    @Override // javax.inject.Provider
    public RdsEmptyAdStubItemBlueprint get() {
        return newInstance(this.a.get());
    }
}

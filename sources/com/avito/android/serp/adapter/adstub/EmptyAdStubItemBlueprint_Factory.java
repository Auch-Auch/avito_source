package com.avito.android.serp.adapter.adstub;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class EmptyAdStubItemBlueprint_Factory implements Factory<EmptyAdStubItemBlueprint> {
    public final Provider<EmptyAdStubItemPresenter> a;

    public EmptyAdStubItemBlueprint_Factory(Provider<EmptyAdStubItemPresenter> provider) {
        this.a = provider;
    }

    public static EmptyAdStubItemBlueprint_Factory create(Provider<EmptyAdStubItemPresenter> provider) {
        return new EmptyAdStubItemBlueprint_Factory(provider);
    }

    public static EmptyAdStubItemBlueprint newInstance(EmptyAdStubItemPresenter emptyAdStubItemPresenter) {
        return new EmptyAdStubItemBlueprint(emptyAdStubItemPresenter);
    }

    @Override // javax.inject.Provider
    public EmptyAdStubItemBlueprint get() {
        return newInstance(this.a.get());
    }
}

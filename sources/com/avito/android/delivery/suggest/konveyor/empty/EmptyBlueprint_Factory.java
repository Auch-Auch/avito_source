package com.avito.android.delivery.suggest.konveyor.empty;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class EmptyBlueprint_Factory implements Factory<EmptyBlueprint> {
    public final Provider<EmptyItemPresenter> a;

    public EmptyBlueprint_Factory(Provider<EmptyItemPresenter> provider) {
        this.a = provider;
    }

    public static EmptyBlueprint_Factory create(Provider<EmptyItemPresenter> provider) {
        return new EmptyBlueprint_Factory(provider);
    }

    public static EmptyBlueprint newInstance(EmptyItemPresenter emptyItemPresenter) {
        return new EmptyBlueprint(emptyItemPresenter);
    }

    @Override // javax.inject.Provider
    public EmptyBlueprint get() {
        return newInstance(this.a.get());
    }
}

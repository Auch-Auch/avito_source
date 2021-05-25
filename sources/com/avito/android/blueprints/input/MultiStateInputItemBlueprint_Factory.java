package com.avito.android.blueprints.input;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class MultiStateInputItemBlueprint_Factory implements Factory<MultiStateInputItemBlueprint> {
    public final Provider<MultiStateInputItemPresenter> a;

    public MultiStateInputItemBlueprint_Factory(Provider<MultiStateInputItemPresenter> provider) {
        this.a = provider;
    }

    public static MultiStateInputItemBlueprint_Factory create(Provider<MultiStateInputItemPresenter> provider) {
        return new MultiStateInputItemBlueprint_Factory(provider);
    }

    public static MultiStateInputItemBlueprint newInstance(MultiStateInputItemPresenter multiStateInputItemPresenter) {
        return new MultiStateInputItemBlueprint(multiStateInputItemPresenter);
    }

    @Override // javax.inject.Provider
    public MultiStateInputItemBlueprint get() {
        return newInstance(this.a.get());
    }
}

package com.avito.android.developments_catalog.items.params;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class ParamsBlueprint_Factory implements Factory<ParamsBlueprint> {
    public final Provider<ParamsPresenter> a;

    public ParamsBlueprint_Factory(Provider<ParamsPresenter> provider) {
        this.a = provider;
    }

    public static ParamsBlueprint_Factory create(Provider<ParamsPresenter> provider) {
        return new ParamsBlueprint_Factory(provider);
    }

    public static ParamsBlueprint newInstance(ParamsPresenter paramsPresenter) {
        return new ParamsBlueprint(paramsPresenter);
    }

    @Override // javax.inject.Provider
    public ParamsBlueprint get() {
        return newInstance(this.a.get());
    }
}

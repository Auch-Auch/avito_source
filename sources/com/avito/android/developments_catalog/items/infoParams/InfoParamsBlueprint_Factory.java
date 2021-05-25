package com.avito.android.developments_catalog.items.infoParams;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class InfoParamsBlueprint_Factory implements Factory<InfoParamsBlueprint> {
    public final Provider<InfoParamsPresenter> a;

    public InfoParamsBlueprint_Factory(Provider<InfoParamsPresenter> provider) {
        this.a = provider;
    }

    public static InfoParamsBlueprint_Factory create(Provider<InfoParamsPresenter> provider) {
        return new InfoParamsBlueprint_Factory(provider);
    }

    public static InfoParamsBlueprint newInstance(InfoParamsPresenter infoParamsPresenter) {
        return new InfoParamsBlueprint(infoParamsPresenter);
    }

    @Override // javax.inject.Provider
    public InfoParamsBlueprint get() {
        return newInstance(this.a.get());
    }
}

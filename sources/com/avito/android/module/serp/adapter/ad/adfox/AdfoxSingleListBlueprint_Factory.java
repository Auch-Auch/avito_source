package com.avito.android.module.serp.adapter.ad.adfox;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdfoxSingleListBlueprint_Factory implements Factory<AdfoxSingleListBlueprint> {
    public final Provider<AdfoxImageItemPresenter> a;

    public AdfoxSingleListBlueprint_Factory(Provider<AdfoxImageItemPresenter> provider) {
        this.a = provider;
    }

    public static AdfoxSingleListBlueprint_Factory create(Provider<AdfoxImageItemPresenter> provider) {
        return new AdfoxSingleListBlueprint_Factory(provider);
    }

    public static AdfoxSingleListBlueprint newInstance(AdfoxImageItemPresenter adfoxImageItemPresenter) {
        return new AdfoxSingleListBlueprint(adfoxImageItemPresenter);
    }

    @Override // javax.inject.Provider
    public AdfoxSingleListBlueprint get() {
        return newInstance(this.a.get());
    }
}

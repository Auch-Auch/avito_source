package com.avito.android.module.serp.adapter.ad.adfox;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AdfoxSingleGridBlueprint_Factory implements Factory<AdfoxSingleGridBlueprint> {
    public final Provider<AdfoxImageItemPresenter> a;

    public AdfoxSingleGridBlueprint_Factory(Provider<AdfoxImageItemPresenter> provider) {
        this.a = provider;
    }

    public static AdfoxSingleGridBlueprint_Factory create(Provider<AdfoxImageItemPresenter> provider) {
        return new AdfoxSingleGridBlueprint_Factory(provider);
    }

    public static AdfoxSingleGridBlueprint newInstance(AdfoxImageItemPresenter adfoxImageItemPresenter) {
        return new AdfoxSingleGridBlueprint(adfoxImageItemPresenter);
    }

    @Override // javax.inject.Provider
    public AdfoxSingleGridBlueprint get() {
        return newInstance(this.a.get());
    }
}

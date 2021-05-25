package com.avito.android.module.serp.adapter.ad.adfox;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class RdsAdfoxBigBlueprint_Factory implements Factory<RdsAdfoxBigBlueprint> {
    public final Provider<AdfoxImageItemPresenter> a;

    public RdsAdfoxBigBlueprint_Factory(Provider<AdfoxImageItemPresenter> provider) {
        this.a = provider;
    }

    public static RdsAdfoxBigBlueprint_Factory create(Provider<AdfoxImageItemPresenter> provider) {
        return new RdsAdfoxBigBlueprint_Factory(provider);
    }

    public static RdsAdfoxBigBlueprint newInstance(AdfoxImageItemPresenter adfoxImageItemPresenter) {
        return new RdsAdfoxBigBlueprint(adfoxImageItemPresenter);
    }

    @Override // javax.inject.Provider
    public RdsAdfoxBigBlueprint get() {
        return newInstance(this.a.get());
    }
}

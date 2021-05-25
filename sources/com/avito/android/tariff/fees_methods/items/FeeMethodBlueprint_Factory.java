package com.avito.android.tariff.fees_methods.items;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class FeeMethodBlueprint_Factory implements Factory<FeeMethodBlueprint> {
    public final Provider<FeeMethodPresenter> a;

    public FeeMethodBlueprint_Factory(Provider<FeeMethodPresenter> provider) {
        this.a = provider;
    }

    public static FeeMethodBlueprint_Factory create(Provider<FeeMethodPresenter> provider) {
        return new FeeMethodBlueprint_Factory(provider);
    }

    public static FeeMethodBlueprint newInstance(FeeMethodPresenter feeMethodPresenter) {
        return new FeeMethodBlueprint(feeMethodPresenter);
    }

    @Override // javax.inject.Provider
    public FeeMethodBlueprint get() {
        return newInstance(this.a.get());
    }
}

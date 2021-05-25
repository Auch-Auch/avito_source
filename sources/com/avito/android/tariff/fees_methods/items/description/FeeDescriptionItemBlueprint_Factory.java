package com.avito.android.tariff.fees_methods.items.description;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class FeeDescriptionItemBlueprint_Factory implements Factory<FeeDescriptionItemBlueprint> {
    public final Provider<FeeDescriptionItemPresenter> a;

    public FeeDescriptionItemBlueprint_Factory(Provider<FeeDescriptionItemPresenter> provider) {
        this.a = provider;
    }

    public static FeeDescriptionItemBlueprint_Factory create(Provider<FeeDescriptionItemPresenter> provider) {
        return new FeeDescriptionItemBlueprint_Factory(provider);
    }

    public static FeeDescriptionItemBlueprint newInstance(FeeDescriptionItemPresenter feeDescriptionItemPresenter) {
        return new FeeDescriptionItemBlueprint(feeDescriptionItemPresenter);
    }

    @Override // javax.inject.Provider
    public FeeDescriptionItemBlueprint get() {
        return newInstance(this.a.get());
    }
}

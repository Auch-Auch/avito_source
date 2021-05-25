package com.avito.android.select;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class VariantItemImageBlueprintImpl_Factory implements Factory<VariantItemImageBlueprintImpl> {
    public final Provider<VariantItemPresenter> a;

    public VariantItemImageBlueprintImpl_Factory(Provider<VariantItemPresenter> provider) {
        this.a = provider;
    }

    public static VariantItemImageBlueprintImpl_Factory create(Provider<VariantItemPresenter> provider) {
        return new VariantItemImageBlueprintImpl_Factory(provider);
    }

    public static VariantItemImageBlueprintImpl newInstance(VariantItemPresenter variantItemPresenter) {
        return new VariantItemImageBlueprintImpl(variantItemPresenter);
    }

    @Override // javax.inject.Provider
    public VariantItemImageBlueprintImpl get() {
        return newInstance(this.a.get());
    }
}

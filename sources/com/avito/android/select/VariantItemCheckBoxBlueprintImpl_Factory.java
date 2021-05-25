package com.avito.android.select;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class VariantItemCheckBoxBlueprintImpl_Factory implements Factory<VariantItemCheckBoxBlueprintImpl> {
    public final Provider<VariantItemPresenter> a;

    public VariantItemCheckBoxBlueprintImpl_Factory(Provider<VariantItemPresenter> provider) {
        this.a = provider;
    }

    public static VariantItemCheckBoxBlueprintImpl_Factory create(Provider<VariantItemPresenter> provider) {
        return new VariantItemCheckBoxBlueprintImpl_Factory(provider);
    }

    public static VariantItemCheckBoxBlueprintImpl newInstance(VariantItemPresenter variantItemPresenter) {
        return new VariantItemCheckBoxBlueprintImpl(variantItemPresenter);
    }

    @Override // javax.inject.Provider
    public VariantItemCheckBoxBlueprintImpl get() {
        return newInstance(this.a.get());
    }
}

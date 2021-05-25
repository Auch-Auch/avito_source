package com.avito.android.select;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class VariantCheckableItemBlueprintImpl_Factory implements Factory<VariantCheckableItemBlueprintImpl> {
    public final Provider<VariantItemPresenter> a;

    public VariantCheckableItemBlueprintImpl_Factory(Provider<VariantItemPresenter> provider) {
        this.a = provider;
    }

    public static VariantCheckableItemBlueprintImpl_Factory create(Provider<VariantItemPresenter> provider) {
        return new VariantCheckableItemBlueprintImpl_Factory(provider);
    }

    public static VariantCheckableItemBlueprintImpl newInstance(VariantItemPresenter variantItemPresenter) {
        return new VariantCheckableItemBlueprintImpl(variantItemPresenter);
    }

    @Override // javax.inject.Provider
    public VariantCheckableItemBlueprintImpl get() {
        return newInstance(this.a.get());
    }
}

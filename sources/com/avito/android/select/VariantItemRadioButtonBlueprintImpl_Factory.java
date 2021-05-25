package com.avito.android.select;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class VariantItemRadioButtonBlueprintImpl_Factory implements Factory<VariantItemRadioButtonBlueprintImpl> {
    public final Provider<VariantItemPresenter> a;

    public VariantItemRadioButtonBlueprintImpl_Factory(Provider<VariantItemPresenter> provider) {
        this.a = provider;
    }

    public static VariantItemRadioButtonBlueprintImpl_Factory create(Provider<VariantItemPresenter> provider) {
        return new VariantItemRadioButtonBlueprintImpl_Factory(provider);
    }

    public static VariantItemRadioButtonBlueprintImpl newInstance(VariantItemPresenter variantItemPresenter) {
        return new VariantItemRadioButtonBlueprintImpl(variantItemPresenter);
    }

    @Override // javax.inject.Provider
    public VariantItemRadioButtonBlueprintImpl get() {
        return newInstance(this.a.get());
    }
}

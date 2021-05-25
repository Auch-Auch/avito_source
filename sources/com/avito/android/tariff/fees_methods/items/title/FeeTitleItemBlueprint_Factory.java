package com.avito.android.tariff.fees_methods.items.title;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class FeeTitleItemBlueprint_Factory implements Factory<FeeTitleItemBlueprint> {
    public final Provider<FeeTitleItemPresenter> a;

    public FeeTitleItemBlueprint_Factory(Provider<FeeTitleItemPresenter> provider) {
        this.a = provider;
    }

    public static FeeTitleItemBlueprint_Factory create(Provider<FeeTitleItemPresenter> provider) {
        return new FeeTitleItemBlueprint_Factory(provider);
    }

    public static FeeTitleItemBlueprint newInstance(FeeTitleItemPresenter feeTitleItemPresenter) {
        return new FeeTitleItemBlueprint(feeTitleItemPresenter);
    }

    @Override // javax.inject.Provider
    public FeeTitleItemBlueprint get() {
        return newInstance(this.a.get());
    }
}

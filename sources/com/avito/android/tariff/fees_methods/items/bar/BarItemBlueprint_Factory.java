package com.avito.android.tariff.fees_methods.items.bar;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class BarItemBlueprint_Factory implements Factory<BarItemBlueprint> {
    public final Provider<BarItemPresenter> a;

    public BarItemBlueprint_Factory(Provider<BarItemPresenter> provider) {
        this.a = provider;
    }

    public static BarItemBlueprint_Factory create(Provider<BarItemPresenter> provider) {
        return new BarItemBlueprint_Factory(provider);
    }

    public static BarItemBlueprint newInstance(BarItemPresenter barItemPresenter) {
        return new BarItemBlueprint(barItemPresenter);
    }

    @Override // javax.inject.Provider
    public BarItemBlueprint get() {
        return newInstance(this.a.get());
    }
}

package com.avito.android.publish.input_vin.items.divider;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class DividerWithTextBlueprint_Factory implements Factory<DividerWithTextBlueprint> {
    public final Provider<DividerWithTextPresenter> a;

    public DividerWithTextBlueprint_Factory(Provider<DividerWithTextPresenter> provider) {
        this.a = provider;
    }

    public static DividerWithTextBlueprint_Factory create(Provider<DividerWithTextPresenter> provider) {
        return new DividerWithTextBlueprint_Factory(provider);
    }

    public static DividerWithTextBlueprint newInstance(DividerWithTextPresenter dividerWithTextPresenter) {
        return new DividerWithTextBlueprint(dividerWithTextPresenter);
    }

    @Override // javax.inject.Provider
    public DividerWithTextBlueprint get() {
        return newInstance(this.a.get());
    }
}

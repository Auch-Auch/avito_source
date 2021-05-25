package com.avito.android.cart.summary.konveyor.divider;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class DividerItemBlueprint_Factory implements Factory<DividerItemBlueprint> {
    public final Provider<DividerItemPresenter> a;

    public DividerItemBlueprint_Factory(Provider<DividerItemPresenter> provider) {
        this.a = provider;
    }

    public static DividerItemBlueprint_Factory create(Provider<DividerItemPresenter> provider) {
        return new DividerItemBlueprint_Factory(provider);
    }

    public static DividerItemBlueprint newInstance(DividerItemPresenter dividerItemPresenter) {
        return new DividerItemBlueprint(dividerItemPresenter);
    }

    @Override // javax.inject.Provider
    public DividerItemBlueprint get() {
        return newInstance(this.a.get());
    }
}

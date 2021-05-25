package com.avito.android.developments_catalog.items.divider;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class DividerBlueprint_Factory implements Factory<DividerBlueprint> {
    public final Provider<DividerPresenter> a;

    public DividerBlueprint_Factory(Provider<DividerPresenter> provider) {
        this.a = provider;
    }

    public static DividerBlueprint_Factory create(Provider<DividerPresenter> provider) {
        return new DividerBlueprint_Factory(provider);
    }

    public static DividerBlueprint newInstance(DividerPresenter dividerPresenter) {
        return new DividerBlueprint(dividerPresenter);
    }

    @Override // javax.inject.Provider
    public DividerBlueprint get() {
        return newInstance(this.a.get());
    }
}

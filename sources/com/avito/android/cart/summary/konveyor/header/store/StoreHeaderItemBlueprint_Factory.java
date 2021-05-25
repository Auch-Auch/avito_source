package com.avito.android.cart.summary.konveyor.header.store;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class StoreHeaderItemBlueprint_Factory implements Factory<StoreHeaderItemBlueprint> {
    public final Provider<StoreHeaderItemPresenter> a;

    public StoreHeaderItemBlueprint_Factory(Provider<StoreHeaderItemPresenter> provider) {
        this.a = provider;
    }

    public static StoreHeaderItemBlueprint_Factory create(Provider<StoreHeaderItemPresenter> provider) {
        return new StoreHeaderItemBlueprint_Factory(provider);
    }

    public static StoreHeaderItemBlueprint newInstance(StoreHeaderItemPresenter storeHeaderItemPresenter) {
        return new StoreHeaderItemBlueprint(storeHeaderItemPresenter);
    }

    @Override // javax.inject.Provider
    public StoreHeaderItemBlueprint get() {
        return newInstance(this.a.get());
    }
}

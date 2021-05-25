package com.avito.android.developments_catalog.items.address;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class AddressBlueprint_Factory implements Factory<AddressBlueprint> {
    public final Provider<AddressPresenter> a;

    public AddressBlueprint_Factory(Provider<AddressPresenter> provider) {
        this.a = provider;
    }

    public static AddressBlueprint_Factory create(Provider<AddressPresenter> provider) {
        return new AddressBlueprint_Factory(provider);
    }

    public static AddressBlueprint newInstance(AddressPresenter addressPresenter) {
        return new AddressBlueprint(addressPresenter);
    }

    @Override // javax.inject.Provider
    public AddressBlueprint get() {
        return newInstance(this.a.get());
    }
}

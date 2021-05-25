package com.avito.android.developments_catalog.items.address;

import dagger.internal.Factory;
public final class AddressPresenterImpl_Factory implements Factory<AddressPresenterImpl> {

    public static final class a {
        public static final AddressPresenterImpl_Factory a = new AddressPresenterImpl_Factory();
    }

    public static AddressPresenterImpl_Factory create() {
        return a.a;
    }

    public static AddressPresenterImpl newInstance() {
        return new AddressPresenterImpl();
    }

    @Override // javax.inject.Provider
    public AddressPresenterImpl get() {
        return newInstance();
    }
}

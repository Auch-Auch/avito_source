package com.avito.android.developments_catalog.items.metro;

import dagger.internal.Factory;
public final class MetroPresenterImpl_Factory implements Factory<MetroPresenterImpl> {

    public static final class a {
        public static final MetroPresenterImpl_Factory a = new MetroPresenterImpl_Factory();
    }

    public static MetroPresenterImpl_Factory create() {
        return a.a;
    }

    public static MetroPresenterImpl newInstance() {
        return new MetroPresenterImpl();
    }

    @Override // javax.inject.Provider
    public MetroPresenterImpl get() {
        return newInstance();
    }
}

package com.avito.android.select.new_metro.adapter.filter;

import dagger.internal.Factory;
public final class MetroFilterItemPresenterImpl_Factory implements Factory<MetroFilterItemPresenterImpl> {

    public static final class a {
        public static final MetroFilterItemPresenterImpl_Factory a = new MetroFilterItemPresenterImpl_Factory();
    }

    public static MetroFilterItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static MetroFilterItemPresenterImpl newInstance() {
        return new MetroFilterItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public MetroFilterItemPresenterImpl get() {
        return newInstance();
    }
}

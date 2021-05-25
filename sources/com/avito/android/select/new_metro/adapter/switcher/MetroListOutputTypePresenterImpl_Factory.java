package com.avito.android.select.new_metro.adapter.switcher;

import dagger.internal.Factory;
public final class MetroListOutputTypePresenterImpl_Factory implements Factory<MetroListOutputTypePresenterImpl> {

    public static final class a {
        public static final MetroListOutputTypePresenterImpl_Factory a = new MetroListOutputTypePresenterImpl_Factory();
    }

    public static MetroListOutputTypePresenterImpl_Factory create() {
        return a.a;
    }

    public static MetroListOutputTypePresenterImpl newInstance() {
        return new MetroListOutputTypePresenterImpl();
    }

    @Override // javax.inject.Provider
    public MetroListOutputTypePresenterImpl get() {
        return newInstance();
    }
}

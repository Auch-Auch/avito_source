package com.avito.android.developments_catalog.items.divider;

import dagger.internal.Factory;
public final class DividerPresenterImpl_Factory implements Factory<DividerPresenterImpl> {

    public static final class a {
        public static final DividerPresenterImpl_Factory a = new DividerPresenterImpl_Factory();
    }

    public static DividerPresenterImpl_Factory create() {
        return a.a;
    }

    public static DividerPresenterImpl newInstance() {
        return new DividerPresenterImpl();
    }

    @Override // javax.inject.Provider
    public DividerPresenterImpl get() {
        return newInstance();
    }
}

package com.avito.android.auto_catalog.items.image;

import dagger.internal.Factory;
public final class SchemePresenterImpl_Factory implements Factory<SchemePresenterImpl> {

    public static final class a {
        public static final SchemePresenterImpl_Factory a = new SchemePresenterImpl_Factory();
    }

    public static SchemePresenterImpl_Factory create() {
        return a.a;
    }

    public static SchemePresenterImpl newInstance() {
        return new SchemePresenterImpl();
    }

    @Override // javax.inject.Provider
    public SchemePresenterImpl get() {
        return newInstance();
    }
}

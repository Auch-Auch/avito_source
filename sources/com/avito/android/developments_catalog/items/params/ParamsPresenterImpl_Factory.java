package com.avito.android.developments_catalog.items.params;

import dagger.internal.Factory;
public final class ParamsPresenterImpl_Factory implements Factory<ParamsPresenterImpl> {

    public static final class a {
        public static final ParamsPresenterImpl_Factory a = new ParamsPresenterImpl_Factory();
    }

    public static ParamsPresenterImpl_Factory create() {
        return a.a;
    }

    public static ParamsPresenterImpl newInstance() {
        return new ParamsPresenterImpl();
    }

    @Override // javax.inject.Provider
    public ParamsPresenterImpl get() {
        return newInstance();
    }
}

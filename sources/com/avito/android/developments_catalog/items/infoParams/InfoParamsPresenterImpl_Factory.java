package com.avito.android.developments_catalog.items.infoParams;

import dagger.internal.Factory;
public final class InfoParamsPresenterImpl_Factory implements Factory<InfoParamsPresenterImpl> {

    public static final class a {
        public static final InfoParamsPresenterImpl_Factory a = new InfoParamsPresenterImpl_Factory();
    }

    public static InfoParamsPresenterImpl_Factory create() {
        return a.a;
    }

    public static InfoParamsPresenterImpl newInstance() {
        return new InfoParamsPresenterImpl();
    }

    @Override // javax.inject.Provider
    public InfoParamsPresenterImpl get() {
        return newInstance();
    }
}

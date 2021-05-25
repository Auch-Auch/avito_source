package com.avito.android.developments_catalog.items.title;

import dagger.internal.Factory;
public final class TitlePresenterImpl_Factory implements Factory<TitlePresenterImpl> {

    public static final class a {
        public static final TitlePresenterImpl_Factory a = new TitlePresenterImpl_Factory();
    }

    public static TitlePresenterImpl_Factory create() {
        return a.a;
    }

    public static TitlePresenterImpl newInstance() {
        return new TitlePresenterImpl();
    }

    @Override // javax.inject.Provider
    public TitlePresenterImpl get() {
        return newInstance();
    }
}

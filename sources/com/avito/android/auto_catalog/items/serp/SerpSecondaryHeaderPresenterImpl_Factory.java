package com.avito.android.auto_catalog.items.serp;

import dagger.internal.Factory;
public final class SerpSecondaryHeaderPresenterImpl_Factory implements Factory<SerpSecondaryHeaderPresenterImpl> {

    public static final class a {
        public static final SerpSecondaryHeaderPresenterImpl_Factory a = new SerpSecondaryHeaderPresenterImpl_Factory();
    }

    public static SerpSecondaryHeaderPresenterImpl_Factory create() {
        return a.a;
    }

    public static SerpSecondaryHeaderPresenterImpl newInstance() {
        return new SerpSecondaryHeaderPresenterImpl();
    }

    @Override // javax.inject.Provider
    public SerpSecondaryHeaderPresenterImpl get() {
        return newInstance();
    }
}

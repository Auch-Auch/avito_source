package com.avito.android.auto_catalog.items.serp;

import dagger.internal.Factory;
public final class SerpHeaderPresenterImpl_Factory implements Factory<SerpHeaderPresenterImpl> {

    public static final class a {
        public static final SerpHeaderPresenterImpl_Factory a = new SerpHeaderPresenterImpl_Factory();
    }

    public static SerpHeaderPresenterImpl_Factory create() {
        return a.a;
    }

    public static SerpHeaderPresenterImpl newInstance() {
        return new SerpHeaderPresenterImpl();
    }

    @Override // javax.inject.Provider
    public SerpHeaderPresenterImpl get() {
        return newInstance();
    }
}

package com.avito.android.serp.adapter.header;

import dagger.internal.Factory;
public final class HeaderPresenterImpl_Factory implements Factory<HeaderPresenterImpl> {

    public static final class a {
        public static final HeaderPresenterImpl_Factory a = new HeaderPresenterImpl_Factory();
    }

    public static HeaderPresenterImpl_Factory create() {
        return a.a;
    }

    public static HeaderPresenterImpl newInstance() {
        return new HeaderPresenterImpl();
    }

    @Override // javax.inject.Provider
    public HeaderPresenterImpl get() {
        return newInstance();
    }
}

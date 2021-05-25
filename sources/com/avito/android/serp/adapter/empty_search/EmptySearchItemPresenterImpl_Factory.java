package com.avito.android.serp.adapter.empty_search;

import dagger.internal.Factory;
public final class EmptySearchItemPresenterImpl_Factory implements Factory<EmptySearchItemPresenterImpl> {

    public static final class a {
        public static final EmptySearchItemPresenterImpl_Factory a = new EmptySearchItemPresenterImpl_Factory();
    }

    public static EmptySearchItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static EmptySearchItemPresenterImpl newInstance() {
        return new EmptySearchItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public EmptySearchItemPresenterImpl get() {
        return newInstance();
    }
}

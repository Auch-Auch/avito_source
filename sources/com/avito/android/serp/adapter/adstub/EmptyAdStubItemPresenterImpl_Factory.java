package com.avito.android.serp.adapter.adstub;

import dagger.internal.Factory;
public final class EmptyAdStubItemPresenterImpl_Factory implements Factory<EmptyAdStubItemPresenterImpl> {

    public static final class a {
        public static final EmptyAdStubItemPresenterImpl_Factory a = new EmptyAdStubItemPresenterImpl_Factory();
    }

    public static EmptyAdStubItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static EmptyAdStubItemPresenterImpl newInstance() {
        return new EmptyAdStubItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public EmptyAdStubItemPresenterImpl get() {
        return newInstance();
    }
}

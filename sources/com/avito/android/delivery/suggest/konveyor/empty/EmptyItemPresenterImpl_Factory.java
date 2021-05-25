package com.avito.android.delivery.suggest.konveyor.empty;

import dagger.internal.Factory;
public final class EmptyItemPresenterImpl_Factory implements Factory<EmptyItemPresenterImpl> {

    public static final class a {
        public static final EmptyItemPresenterImpl_Factory a = new EmptyItemPresenterImpl_Factory();
    }

    public static EmptyItemPresenterImpl_Factory create() {
        return a.a;
    }

    public static EmptyItemPresenterImpl newInstance() {
        return new EmptyItemPresenterImpl();
    }

    @Override // javax.inject.Provider
    public EmptyItemPresenterImpl get() {
        return newInstance();
    }
}

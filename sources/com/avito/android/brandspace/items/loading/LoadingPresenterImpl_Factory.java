package com.avito.android.brandspace.items.loading;

import dagger.internal.Factory;
public final class LoadingPresenterImpl_Factory implements Factory<LoadingPresenterImpl> {

    public static final class a {
        public static final LoadingPresenterImpl_Factory a = new LoadingPresenterImpl_Factory();
    }

    public static LoadingPresenterImpl_Factory create() {
        return a.a;
    }

    public static LoadingPresenterImpl newInstance() {
        return new LoadingPresenterImpl();
    }

    @Override // javax.inject.Provider
    public LoadingPresenterImpl get() {
        return newInstance();
    }
}

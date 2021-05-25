package com.avito.android.lib.design.snackbar.util;

import dagger.internal.Factory;
public final class CompositeSnackbarPresenterImpl_Factory implements Factory<CompositeSnackbarPresenterImpl> {

    public static final class a {
        public static final CompositeSnackbarPresenterImpl_Factory a = new CompositeSnackbarPresenterImpl_Factory();
    }

    public static CompositeSnackbarPresenterImpl_Factory create() {
        return a.a;
    }

    public static CompositeSnackbarPresenterImpl newInstance() {
        return new CompositeSnackbarPresenterImpl();
    }

    @Override // javax.inject.Provider
    public CompositeSnackbarPresenterImpl get() {
        return newInstance();
    }
}

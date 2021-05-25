package com.avito.android.lib.design.snackbar.util;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
public final class CompositeSnackbarModule_ProvideCompositeSnackbarPresenterFactory implements Factory<CompositeSnackbarPresenter> {

    public static final class a {
        public static final CompositeSnackbarModule_ProvideCompositeSnackbarPresenterFactory a = new CompositeSnackbarModule_ProvideCompositeSnackbarPresenterFactory();
    }

    public static CompositeSnackbarModule_ProvideCompositeSnackbarPresenterFactory create() {
        return a.a;
    }

    public static CompositeSnackbarPresenter provideCompositeSnackbarPresenter() {
        return (CompositeSnackbarPresenter) Preconditions.checkNotNullFromProvides(CompositeSnackbarModule.provideCompositeSnackbarPresenter());
    }

    @Override // javax.inject.Provider
    public CompositeSnackbarPresenter get() {
        return provideCompositeSnackbarPresenter();
    }
}

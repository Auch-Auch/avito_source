package com.avito.android.search.filter;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class SelectDialogPresenterImpl_Factory implements Factory<SelectDialogPresenterImpl> {
    public final Provider<FiltersChangeProvider> a;
    public final Provider<DialogResourceProvider> b;

    public SelectDialogPresenterImpl_Factory(Provider<FiltersChangeProvider> provider, Provider<DialogResourceProvider> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static SelectDialogPresenterImpl_Factory create(Provider<FiltersChangeProvider> provider, Provider<DialogResourceProvider> provider2) {
        return new SelectDialogPresenterImpl_Factory(provider, provider2);
    }

    public static SelectDialogPresenterImpl newInstance(FiltersChangeProvider filtersChangeProvider, DialogResourceProvider dialogResourceProvider) {
        return new SelectDialogPresenterImpl(filtersChangeProvider, dialogResourceProvider);
    }

    @Override // javax.inject.Provider
    public SelectDialogPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}

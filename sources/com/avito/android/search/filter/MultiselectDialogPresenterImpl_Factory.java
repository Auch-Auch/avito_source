package com.avito.android.search.filter;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class MultiselectDialogPresenterImpl_Factory implements Factory<MultiselectDialogPresenterImpl> {
    public final Provider<FiltersChangeProvider> a;
    public final Provider<DialogResourceProvider> b;

    public MultiselectDialogPresenterImpl_Factory(Provider<FiltersChangeProvider> provider, Provider<DialogResourceProvider> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static MultiselectDialogPresenterImpl_Factory create(Provider<FiltersChangeProvider> provider, Provider<DialogResourceProvider> provider2) {
        return new MultiselectDialogPresenterImpl_Factory(provider, provider2);
    }

    public static MultiselectDialogPresenterImpl newInstance(FiltersChangeProvider filtersChangeProvider, DialogResourceProvider dialogResourceProvider) {
        return new MultiselectDialogPresenterImpl(filtersChangeProvider, dialogResourceProvider);
    }

    @Override // javax.inject.Provider
    public MultiselectDialogPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}

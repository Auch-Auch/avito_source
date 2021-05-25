package com.avito.android.search.filter.adapter;

import com.avito.android.search.filter.FiltersChangeProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SelectItemPresenterImpl_Factory implements Factory<SelectItemPresenterImpl> {
    public final Provider<FiltersChangeProvider> a;

    public SelectItemPresenterImpl_Factory(Provider<FiltersChangeProvider> provider) {
        this.a = provider;
    }

    public static SelectItemPresenterImpl_Factory create(Provider<FiltersChangeProvider> provider) {
        return new SelectItemPresenterImpl_Factory(provider);
    }

    public static SelectItemPresenterImpl newInstance(FiltersChangeProvider filtersChangeProvider) {
        return new SelectItemPresenterImpl(filtersChangeProvider);
    }

    @Override // javax.inject.Provider
    public SelectItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}

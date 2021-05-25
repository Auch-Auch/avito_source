package com.avito.android.search.filter.adapter;

import com.avito.android.search.filter.FiltersChangeProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class MultiselectItemPresenterImpl_Factory implements Factory<MultiselectItemPresenterImpl> {
    public final Provider<FiltersChangeProvider> a;

    public MultiselectItemPresenterImpl_Factory(Provider<FiltersChangeProvider> provider) {
        this.a = provider;
    }

    public static MultiselectItemPresenterImpl_Factory create(Provider<FiltersChangeProvider> provider) {
        return new MultiselectItemPresenterImpl_Factory(provider);
    }

    public static MultiselectItemPresenterImpl newInstance(FiltersChangeProvider filtersChangeProvider) {
        return new MultiselectItemPresenterImpl(filtersChangeProvider);
    }

    @Override // javax.inject.Provider
    public MultiselectItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}

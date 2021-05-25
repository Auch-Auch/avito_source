package com.avito.android.search.filter.adapter;

import com.avito.android.search.filter.FiltersChangeProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class InlineMultiselectItemPresenterImpl_Factory implements Factory<InlineMultiselectItemPresenterImpl> {
    public final Provider<FiltersChangeProvider> a;

    public InlineMultiselectItemPresenterImpl_Factory(Provider<FiltersChangeProvider> provider) {
        this.a = provider;
    }

    public static InlineMultiselectItemPresenterImpl_Factory create(Provider<FiltersChangeProvider> provider) {
        return new InlineMultiselectItemPresenterImpl_Factory(provider);
    }

    public static InlineMultiselectItemPresenterImpl newInstance(FiltersChangeProvider filtersChangeProvider) {
        return new InlineMultiselectItemPresenterImpl(filtersChangeProvider);
    }

    @Override // javax.inject.Provider
    public InlineMultiselectItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}

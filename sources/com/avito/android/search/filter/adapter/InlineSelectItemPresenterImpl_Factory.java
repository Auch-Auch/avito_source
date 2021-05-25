package com.avito.android.search.filter.adapter;

import com.avito.android.search.filter.FiltersChangeProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class InlineSelectItemPresenterImpl_Factory implements Factory<InlineSelectItemPresenterImpl> {
    public final Provider<FiltersChangeProvider> a;

    public InlineSelectItemPresenterImpl_Factory(Provider<FiltersChangeProvider> provider) {
        this.a = provider;
    }

    public static InlineSelectItemPresenterImpl_Factory create(Provider<FiltersChangeProvider> provider) {
        return new InlineSelectItemPresenterImpl_Factory(provider);
    }

    public static InlineSelectItemPresenterImpl newInstance(FiltersChangeProvider filtersChangeProvider) {
        return new InlineSelectItemPresenterImpl(filtersChangeProvider);
    }

    @Override // javax.inject.Provider
    public InlineSelectItemPresenterImpl get() {
        return newInstance(this.a.get());
    }
}

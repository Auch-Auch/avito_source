package com.avito.android.search.filter.adapter;

import com.avito.android.search.filter.FiltersChangeProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class ChangeDisplayTypePresenterImpl_Factory implements Factory<ChangeDisplayTypePresenterImpl> {
    public final Provider<FiltersChangeProvider> a;

    public ChangeDisplayTypePresenterImpl_Factory(Provider<FiltersChangeProvider> provider) {
        this.a = provider;
    }

    public static ChangeDisplayTypePresenterImpl_Factory create(Provider<FiltersChangeProvider> provider) {
        return new ChangeDisplayTypePresenterImpl_Factory(provider);
    }

    public static ChangeDisplayTypePresenterImpl newInstance(FiltersChangeProvider filtersChangeProvider) {
        return new ChangeDisplayTypePresenterImpl(filtersChangeProvider);
    }

    @Override // javax.inject.Provider
    public ChangeDisplayTypePresenterImpl get() {
        return newInstance(this.a.get());
    }
}

package com.avito.android.search.filter.adapter;

import com.avito.android.search.filter.FiltersChangeProvider;
import com.avito.android.util.Kundle;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class BubblesSelectItemPresenterImpl_Factory implements Factory<BubblesSelectItemPresenterImpl> {
    public final Provider<FiltersChangeProvider> a;
    public final Provider<Kundle> b;

    public BubblesSelectItemPresenterImpl_Factory(Provider<FiltersChangeProvider> provider, Provider<Kundle> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static BubblesSelectItemPresenterImpl_Factory create(Provider<FiltersChangeProvider> provider, Provider<Kundle> provider2) {
        return new BubblesSelectItemPresenterImpl_Factory(provider, provider2);
    }

    public static BubblesSelectItemPresenterImpl newInstance(FiltersChangeProvider filtersChangeProvider, Kundle kundle) {
        return new BubblesSelectItemPresenterImpl(filtersChangeProvider, kundle);
    }

    @Override // javax.inject.Provider
    public BubblesSelectItemPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}

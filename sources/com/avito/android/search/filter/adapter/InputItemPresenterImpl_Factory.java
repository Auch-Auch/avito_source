package com.avito.android.search.filter.adapter;

import com.avito.android.search.filter.FiltersChangeProvider;
import com.avito.android.search.filter.InputItemFormatterProvider;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class InputItemPresenterImpl_Factory implements Factory<InputItemPresenterImpl> {
    public final Provider<FiltersChangeProvider> a;
    public final Provider<InputItemFormatterProvider> b;

    public InputItemPresenterImpl_Factory(Provider<FiltersChangeProvider> provider, Provider<InputItemFormatterProvider> provider2) {
        this.a = provider;
        this.b = provider2;
    }

    public static InputItemPresenterImpl_Factory create(Provider<FiltersChangeProvider> provider, Provider<InputItemFormatterProvider> provider2) {
        return new InputItemPresenterImpl_Factory(provider, provider2);
    }

    public static InputItemPresenterImpl newInstance(FiltersChangeProvider filtersChangeProvider, InputItemFormatterProvider inputItemFormatterProvider) {
        return new InputItemPresenterImpl(filtersChangeProvider, inputItemFormatterProvider);
    }

    @Override // javax.inject.Provider
    public InputItemPresenterImpl get() {
        return newInstance(this.a.get(), this.b.get());
    }
}

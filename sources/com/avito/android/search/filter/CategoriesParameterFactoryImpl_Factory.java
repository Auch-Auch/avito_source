package com.avito.android.search.filter;

import dagger.internal.Factory;
import javax.inject.Provider;
public final class CategoriesParameterFactoryImpl_Factory implements Factory<CategoriesParameterFactoryImpl> {
    public final Provider<FiltersResourceProvider> a;

    public CategoriesParameterFactoryImpl_Factory(Provider<FiltersResourceProvider> provider) {
        this.a = provider;
    }

    public static CategoriesParameterFactoryImpl_Factory create(Provider<FiltersResourceProvider> provider) {
        return new CategoriesParameterFactoryImpl_Factory(provider);
    }

    public static CategoriesParameterFactoryImpl newInstance(FiltersResourceProvider filtersResourceProvider) {
        return new CategoriesParameterFactoryImpl(filtersResourceProvider);
    }

    @Override // javax.inject.Provider
    public CategoriesParameterFactoryImpl get() {
        return newInstance(this.a.get());
    }
}

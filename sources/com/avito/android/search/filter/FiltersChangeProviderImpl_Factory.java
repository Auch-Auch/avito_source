package com.avito.android.search.filter;

import dagger.internal.Factory;
public final class FiltersChangeProviderImpl_Factory implements Factory<FiltersChangeProviderImpl> {

    public static final class a {
        public static final FiltersChangeProviderImpl_Factory a = new FiltersChangeProviderImpl_Factory();
    }

    public static FiltersChangeProviderImpl_Factory create() {
        return a.a;
    }

    public static FiltersChangeProviderImpl newInstance() {
        return new FiltersChangeProviderImpl();
    }

    @Override // javax.inject.Provider
    public FiltersChangeProviderImpl get() {
        return newInstance();
    }
}

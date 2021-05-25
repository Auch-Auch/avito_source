package com.avito.android.remote.model;

import dagger.internal.Factory;
public final class SearchParamsConverterImpl_Factory implements Factory<SearchParamsConverterImpl> {

    public static final class InstanceHolder {
        private static final SearchParamsConverterImpl_Factory INSTANCE = new SearchParamsConverterImpl_Factory();

        private InstanceHolder() {
        }
    }

    public static SearchParamsConverterImpl_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static SearchParamsConverterImpl newInstance() {
        return new SearchParamsConverterImpl();
    }

    @Override // javax.inject.Provider
    public SearchParamsConverterImpl get() {
        return newInstance();
    }
}

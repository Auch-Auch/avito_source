package com.avito.android.search.map.provider;

import dagger.internal.Factory;
public final class SearchHashProviderImpl_Factory implements Factory<SearchHashProviderImpl> {

    public static final class a {
        public static final SearchHashProviderImpl_Factory a = new SearchHashProviderImpl_Factory();
    }

    public static SearchHashProviderImpl_Factory create() {
        return a.a;
    }

    public static SearchHashProviderImpl newInstance() {
        return new SearchHashProviderImpl();
    }

    @Override // javax.inject.Provider
    public SearchHashProviderImpl get() {
        return newInstance();
    }
}

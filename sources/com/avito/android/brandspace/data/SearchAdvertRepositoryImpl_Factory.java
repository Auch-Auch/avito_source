package com.avito.android.brandspace.data;

import com.avito.android.brandspace.presenter.BrandspaceAdvertItemProcessor;
import com.avito.android.remote.SearchApi;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SearchAdvertRepositoryImpl_Factory implements Factory<SearchAdvertRepositoryImpl> {
    public final Provider<SearchApi> a;
    public final Provider<SchedulersFactory3> b;
    public final Provider<BrandspaceAdvertItemProcessor> c;

    public SearchAdvertRepositoryImpl_Factory(Provider<SearchApi> provider, Provider<SchedulersFactory3> provider2, Provider<BrandspaceAdvertItemProcessor> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static SearchAdvertRepositoryImpl_Factory create(Provider<SearchApi> provider, Provider<SchedulersFactory3> provider2, Provider<BrandspaceAdvertItemProcessor> provider3) {
        return new SearchAdvertRepositoryImpl_Factory(provider, provider2, provider3);
    }

    public static SearchAdvertRepositoryImpl newInstance(SearchApi searchApi, SchedulersFactory3 schedulersFactory3, BrandspaceAdvertItemProcessor brandspaceAdvertItemProcessor) {
        return new SearchAdvertRepositoryImpl(searchApi, schedulersFactory3, brandspaceAdvertItemProcessor);
    }

    @Override // javax.inject.Provider
    public SearchAdvertRepositoryImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}

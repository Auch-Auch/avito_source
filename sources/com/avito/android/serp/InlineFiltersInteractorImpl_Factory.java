package com.avito.android.serp;

import com.avito.android.Features;
import com.avito.android.remote.SearchApi;
import com.avito.android.remote.model.SearchParamsConverter;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class InlineFiltersInteractorImpl_Factory implements Factory<InlineFiltersInteractorImpl> {
    public final Provider<SearchApi> a;
    public final Provider<SearchParamsConverter> b;
    public final Provider<InlineFiltersChangesParamsConverter> c;
    public final Provider<InlineFiltersParametersKeyWrapper> d;
    public final Provider<SchedulersFactory3> e;
    public final Provider<Features> f;

    public InlineFiltersInteractorImpl_Factory(Provider<SearchApi> provider, Provider<SearchParamsConverter> provider2, Provider<InlineFiltersChangesParamsConverter> provider3, Provider<InlineFiltersParametersKeyWrapper> provider4, Provider<SchedulersFactory3> provider5, Provider<Features> provider6) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
    }

    public static InlineFiltersInteractorImpl_Factory create(Provider<SearchApi> provider, Provider<SearchParamsConverter> provider2, Provider<InlineFiltersChangesParamsConverter> provider3, Provider<InlineFiltersParametersKeyWrapper> provider4, Provider<SchedulersFactory3> provider5, Provider<Features> provider6) {
        return new InlineFiltersInteractorImpl_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static InlineFiltersInteractorImpl newInstance(SearchApi searchApi, SearchParamsConverter searchParamsConverter, InlineFiltersChangesParamsConverter inlineFiltersChangesParamsConverter, InlineFiltersParametersKeyWrapper inlineFiltersParametersKeyWrapper, SchedulersFactory3 schedulersFactory3, Features features) {
        return new InlineFiltersInteractorImpl(searchApi, searchParamsConverter, inlineFiltersChangesParamsConverter, inlineFiltersParametersKeyWrapper, schedulersFactory3, features);
    }

    @Override // javax.inject.Provider
    public InlineFiltersInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get(), this.f.get());
    }
}

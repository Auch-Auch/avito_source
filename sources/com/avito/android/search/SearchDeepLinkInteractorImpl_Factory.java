package com.avito.android.search;

import com.avito.android.remote.SearchApi;
import com.avito.android.remote.model.SearchParamsConverter;
import com.avito.android.util.SchedulersFactory3;
import dagger.internal.Factory;
import javax.inject.Provider;
public final class SearchDeepLinkInteractorImpl_Factory implements Factory<SearchDeepLinkInteractorImpl> {
    public final Provider<SearchApi> a;
    public final Provider<SearchParamsConverter> b;
    public final Provider<SchedulersFactory3> c;

    public SearchDeepLinkInteractorImpl_Factory(Provider<SearchApi> provider, Provider<SearchParamsConverter> provider2, Provider<SchedulersFactory3> provider3) {
        this.a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static SearchDeepLinkInteractorImpl_Factory create(Provider<SearchApi> provider, Provider<SearchParamsConverter> provider2, Provider<SchedulersFactory3> provider3) {
        return new SearchDeepLinkInteractorImpl_Factory(provider, provider2, provider3);
    }

    public static SearchDeepLinkInteractorImpl newInstance(SearchApi searchApi, SearchParamsConverter searchParamsConverter, SchedulersFactory3 schedulersFactory3) {
        return new SearchDeepLinkInteractorImpl(searchApi, searchParamsConverter, schedulersFactory3);
    }

    @Override // javax.inject.Provider
    public SearchDeepLinkInteractorImpl get() {
        return newInstance(this.a.get(), this.b.get(), this.c.get());
    }
}
